package com.nepxion.swing.selector.calendar;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class JCalendarSelector
    extends JPanel implements PropertyChangeListener
{
	private Calendar calendar;

    /** the day selector */
    protected JDaySelector daySelector;
    private boolean initialized = false;

    /** indicates if weeks of year shall be visible */
    protected boolean weekOfYearVisible = true;

    /** the locale */
    protected Locale locale;

    /** the month selector */
    protected JMonthSelector monthSelector;
    private JPanel monthYearPanel;

    /** the year selector */
    protected JYearSelector yearSelector;

    /**
     * Default JCalendar constructor.
     */
    public JCalendarSelector()
    {
        this(null, null, true, true);
    }

    /**
     * JCalendar constructor specifying the month spinner type.
     *
     * @param monthSpinner false, if no month spinner should be used
     */
    public JCalendarSelector(boolean monthSpinner)
    {
        this(null, null, monthSpinner, true);
    }

    /**
     * JCalendar constructor which allows the initial date to be set.
     *
     * @param date the date
     */
    public JCalendarSelector(Date date)
    {
        this(date, null, true, true);
    }

    /**
     * JCalendar constructor allowing the initial locale to be set.
     *
     * @param locale the new locale
     */
    public JCalendarSelector(Locale locale)
    {
        this(null, locale, true, true);
    }

    /**
     * JCalendar constructor specifying both the initial date and locale.
     *
     * @param date the date
     * @param locale the new locale
     */
    public JCalendarSelector(Date date, Locale locale)
    {
        this(date, locale, true, true);
    }

    /**
     * JCalendar constructor specifying both the initial date and the month
     * spinner type.
     *
     * @param date the date
     * @param monthSpinner false, if no month spinner should be used
     */
    public JCalendarSelector(Date date, boolean monthSpinner)
    {
        this(date, null, monthSpinner, true);
    }

    /**
     * JCalendar constructor specifying both the locale and the month spinner.
     *
     * @param locale the locale
     * @param monthSpinner false, if no month spinner should be used
     */
    public JCalendarSelector(Locale locale, boolean monthSpinner)
    {
        this(null, locale, monthSpinner, true);
    }

    /**
     * JCalendar constructor with month spinner parameter.
     *
     * @param date the date
     * @param locale the locale
     * @param monthSpinner false, if no month spinner should be used
     * @param weekOfYearVisible true, if weeks of year shall be visible
     */
    public JCalendarSelector(Date date, Locale locale, boolean monthSpinner,
                     boolean weekOfYearVisible)
    {
        // needed for setFont() etc.
        daySelector = null;
        monthSelector = null;
        yearSelector = null;
        this.weekOfYearVisible = weekOfYearVisible;

        this.locale = locale;

        if (locale == null)
        {
            this.locale = Locale.getDefault();
        }

        calendar = Calendar.getInstance();

        setLayout(new BorderLayout());

        monthYearPanel = new JPanel();
        monthYearPanel.setLayout(new BorderLayout());

        monthSelector = new JMonthSelector(monthSpinner);
        yearSelector = new JYearSelector();
        monthSelector.setYearSelector(yearSelector);
        monthYearPanel.add(monthSelector, BorderLayout.WEST);
        monthYearPanel.add(yearSelector, BorderLayout.CENTER);
        monthYearPanel.setBorder(BorderFactory.createEmptyBorder());

        daySelector = new JDaySelector(weekOfYearVisible);
        daySelector.addPropertyChangeListener(this);
        monthSelector.setDaySelector(daySelector);
        monthSelector.addPropertyChangeListener(this);
        yearSelector.setDaySelector(daySelector);
        yearSelector.addPropertyChangeListener(this);
        add(monthYearPanel, BorderLayout.NORTH);
        add(daySelector, BorderLayout.CENTER);

        // Set the initialized flag before setting the calendar. This will
        // cause the other components to be updated properly.
        if (date != null)
        {
            calendar.setTime(date);
        }

        initialized = true;
        setCalendar(calendar);
    }

    /**
     * Returns the calendar property.
     *
     * @return the value of the calendar property.
     */
    public Calendar getCalendar()
    {
        return calendar;
    }

    /**
     * Gets the daySelector attribute of the JCalendar object
     *
     * @return the daySelector value
     */
    public JDaySelector getDaySelector()
    {
        return daySelector;
    }

    /**
     * Returns the locale.
     *
     * @return the value of the locale property.
     *
     * @see #setLocale
     */
    public Locale getLocale()
    {
        return locale;
    }

    /**
     * Gets the monthSelector attribute of the JCalendar object
     *
     * @return the monthSelector value
     */
    public JMonthSelector getMonthSelector()
    {
        return monthSelector;
    }

    /**
     * Returns "JCalendar".
     *
     * @return "JCalendar"
     */
    public String getName()
    {
        return "JCalendar";
    }

    /**
     * Gets the yearSelector attribute of the JCalendar object
     *
     * @return the yearSelector value
     */
    public JYearSelector getYearSelector()
    {
        return yearSelector;
    }

    /**
     * Indicates if the weeks of year are visible..
     *
     * @return boolean true, if weeks of year are visible
     */
    public boolean isWeekOfYearVisible()
    {
        return daySelector.isWeekOfYearVisible();
    }

    /**
     * JCalendar is a PropertyChangeListener, for its day, month and year
     * selector.
     *
     * @param e the property change event
     */
    public void propertyChange(PropertyChangeEvent e)
    {
        if (calendar != null)
        {
            Calendar c = (Calendar) calendar.clone();

            if (e.getPropertyName().equals("day"))
            {
                c.set(Calendar.DAY_OF_MONTH,
                      ((Integer) e.getNewValue()).intValue());
                setCalendar(c, false);
            }
            else if (e.getPropertyName().equals("month"))
            {
                c.set(Calendar.MONTH, ((Integer) e.getNewValue()).intValue());
                setCalendar(c, false);
            }
            else if (e.getPropertyName().equals("year"))
            {
                c.set(Calendar.YEAR, ((Integer) e.getNewValue()).intValue());
                setCalendar(c, false);
            }
            else if (e.getPropertyName().equals("date"))
            {
                c.setTime((Date) e.getNewValue());
                setCalendar(c, true);
            }
        }
    }

    /**
     * Sets the background color.
     *
     * @param bg the new background
     */
    public void setBackground(Color bg)
    {
        super.setBackground(bg);

        if (daySelector != null)
        {
            daySelector.setBackground(bg);
        }
    }

    /**
     * Sets the calendar property. This is a bound property.
     *
     * @param c the new calendar
     *
     * @see #getCalendar
     */
    public void setCalendar(Calendar c)
    {
        setCalendar(c, true);
    }

    /**
     * Sets the calendar attribute of the JCalendar object
     *
     * @param c the new calendar value
     * @param update the new calendar value
     */
    private void setCalendar(Calendar c, boolean update)
    {
        Calendar oldCalendar = calendar;
        calendar = c;

        if (update)
        {
            // Thanks to Jeff Ulmer for correcting a bug in the sequence :)
            yearSelector.setYear(c.get(Calendar.YEAR));
            monthSelector.setMonth(c.get(Calendar.MONTH));
            daySelector.setDay(c.get(Calendar.DATE));
        }

        firePropertyChange("calendar", oldCalendar, calendar);
    }

    /**
     * Enable or disable the JCalendar.
     *
     * @param enabled the new enabled value
     */
    public void setEnabled(boolean enabled)
    {
        super.setEnabled(enabled);

        if (daySelector != null)
        {
            daySelector.setEnabled(enabled);
            monthSelector.setEnabled(enabled);
            yearSelector.setEnabled(enabled);
        }
    }

    /**
     * Returns true, if enabled.
     *
     * @return true, if enabled.
     */
    public boolean isEnabled()
    {
        return super.isEnabled();
    }

    /**
     * Sets the font property.
     *
     * @param font the new font
     */
    public void setFont(Font font)
    {
        super.setFont(font);

        if (daySelector != null)
        {
            daySelector.setFont(font);
            monthSelector.setFont(font);
            yearSelector.setFont(font);
        }
    }

    /**
     * Sets the foreground color.
     *
     * @param fg the new foreground
     */
    public void setForeground(Color fg)
    {
        super.setForeground(fg);

        if (daySelector != null)
        {
            daySelector.setForeground(fg);
            monthSelector.setForeground(fg);
            yearSelector.setForeground(fg);
        }
    }

    /**
     * Sets the locale property. This is a bound property.
     *
     * @param l the new locale value
     *
     * @see #getLocale
     */
    public void setLocale(Locale l)
    {
        if (!initialized)
        {
            super.setLocale(l);
        }
        else
        {
            Locale oldLocale = locale;
            locale = l;
            daySelector.setLocale(locale);
            monthSelector.setLocale(locale);
            firePropertyChange("locale", oldLocale, locale);
        }
    }

    /**
     * Sets the week of year visible.
     *
     * @param weekOfYearVisible true, if weeks of year shall be visible
     */
    public void setWeekOfYearVisible(boolean weekOfYearVisible)
    {
        daySelector.setWeekOfYearVisible(weekOfYearVisible);
        setLocale(locale); // hack for doing complete new layout :)
    }

    /**
     * Gets the visibility of the decoration background.
     *
     * @return true, if the decoration background is visible.
     */
    public boolean isDecorationBackgroundVisible()
    {
        return daySelector.isDecorationBackgroundVisible();
    }

    /**
     * Sets the decoration background visible.
     *
     * @param decorationBackgroundVisible true, if the decoration background
     *        should be visible.
     */
    public void setDecorationBackgroundVisible(
        boolean decorationBackgroundVisible)
    {
        daySelector.setDecorationBackgroundVisible(decorationBackgroundVisible);
        setLocale(locale); // hack for doing complete new layout :)
    }

    /**
     * Gets the visibility of the decoration border.
     *
     * @return true, if the decoration border is visible.
     */
    public boolean isDecorationBordersVisible()
    {
        return daySelector.isDecorationBordersVisible();
    }

    /**
     * Sets the decoration borders visible.
     *
     * @param decorationBordersVisible true, if the decoration borders should
     *        be visible.
     */
    public void setDecorationBordersVisible(boolean decorationBordersVisible)
    {
        daySelector.setDecorationBordersVisible(decorationBordersVisible);
        setLocale(locale); // hack for doing complete new layout :)
    }

    /**
     * Returns the color of the decoration (day names and weeks).
     *
     * @return the color of the decoration (day names and weeks).
     */
    public Color getDecorationBackgroundColor()
    {
        return daySelector.getDecorationBackgroundColor();
    }

    /**
     * Sets the background of days and weeks of year buttons.
     *
     * @param decorationBackgroundColor the background color
     */
    public void setDecorationBackgroundColor(Color decorationBackgroundColor)
    {
        daySelector.setDecorationBackgroundColor(decorationBackgroundColor);
    }

    /**
     * Returns the Sunday foreground.
     *
     * @return Color the Sunday foreground.
     */
    public Color getSundayForeground()
    {
        return daySelector.getSundayForeground();
    }

    /**
     * Returns the weekday foreground.
     *
     * @return Color the weekday foreground.
     */
    public Color getWeekdayForeground()
    {
        return daySelector.getWeekdayForeground();
    }

    /**
     * Sets the Sunday foreground.
     *
     * @param sundayForeground the sundayForeground to set
     */
    public void setSundayForeground(Color sundayForeground)
    {
        daySelector.setSundayForeground(sundayForeground);
    }

    /**
     * Sets the weekday foreground.
     *
     * @param weekdayForeground the weekdayForeground to set
     */
    public void setWeekdayForeground(Color weekdayForeground)
    {
        daySelector.setWeekdayForeground(weekdayForeground);
    }

    /**
     * Returns a Date object.
     *
     * @return a date object constructed from the calendar property.
     */
    public Date getDate()
    {
        return new Date(calendar.getTimeInMillis());
    }

    /**
     * Sets the date. Fires the property change "date".
     *
     * @param date the new date.
     */
    public void setDate(Date date)
    {
        Date oldDate = calendar.getTime();
        calendar.setTime(date);

        yearSelector.setYear(calendar.get(Calendar.YEAR));
        monthSelector.setMonth(calendar.get(Calendar.MONTH));
        daySelector.setDay(calendar.get(Calendar.DATE));

        firePropertyChange("date", oldDate, date);
    }
}