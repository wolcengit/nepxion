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
import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class JMonthSelector
    extends JPanel implements ItemListener, ChangeListener
{
    /** true, if the month selector has a spinner component */
    protected boolean hasSpinner;
    private Locale locale;
    private int month;
    private int oldSpinnerValue = 0;

    // needed for comparison
    private JDaySelector daySelector;
    private JYearSelector yearSelector;
    private JComboBox comboBox;
    private JSpinner spinner;
    private boolean initialized;
    private boolean localInitialize;

    /**
     * Default JMonthSelector constructor.
     */
    public JMonthSelector()
    {
        this(true);
    }

    /**
     * JMonthSelector constructor with month spinner parameter.
     *
     * @param hasSpinner
     *            true, if the month selector should have a spinner component
     */
    public JMonthSelector(boolean hasSpinner)
    {
        super();

        this.hasSpinner = hasSpinner;

        setLayout(new BorderLayout());

        comboBox = new JComboBox();
        comboBox.setBackground(Color.white);
        comboBox.setFocusable(false);
        comboBox.setRequestFocusEnabled(false);
        comboBox.addItemListener(this);

        // comboBox.addPopupMenuListener(this);
        locale = Locale.getDefault();
        initNames();

        if (hasSpinner)
        {
            spinner = new JSpinner();
            spinner.addChangeListener(this);
            comboBox.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
            spinner.setEditor(comboBox);
            add(spinner, BorderLayout.CENTER);
            // add(spinner, BorderLayout.NORTH);
        }
        else
        {
            add(comboBox, BorderLayout.CENTER);
            // add(comboBox, BorderLayout.NORTH);
        }

        initialized = true;
        setMonth(Calendar.getInstance().get(Calendar.MONTH));
    }

    /**
     * Initializes the locale specific month names.
     */
    public void initNames()
    {
        localInitialize = true;

        DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(locale);
        String[] monthNames = dateFormatSymbols.getMonths();

        if (comboBox.getItemCount() == 12)
        {
            comboBox.removeAllItems();
        }

        for (int i = 0; i < 12; i++)
        {
            comboBox.addItem(monthNames[i]);
        }

        localInitialize = false;
        comboBox.setSelectedIndex(month);
    }

    /**
     * Is invoked if the state of the spnner changes.
     *
     * @param e
     *            the change event.
     */
    public void stateChanged(ChangeEvent e)
    {
        SpinnerNumberModel model = (SpinnerNumberModel) ((JSpinner) e.getSource()).getModel();
        int value = model.getNumber().intValue();
        boolean increase = (value > oldSpinnerValue) ? true : false;
        oldSpinnerValue = value;

        int month = getMonth();

        if (increase)
        {
            month += 1;

            if (month == 12)
            {
                month = 0;

                if (yearSelector != null)
                {
                    int year = yearSelector.getYear();
                    year += 1;
                    yearSelector.setYear(year);
                }
            }
        }
        else
        {
            month -= 1;

            if (month == -1)
            {
                month = 11;

                if (yearSelector != null)
                {
                    int year = yearSelector.getYear();
                    year -= 1;
                    yearSelector.setYear(year);
                }
            }
        }

        setMonth(month);
    }

    /**
     * The ItemListener for the months.
     *
     * @param e
     *            the item event
     */
    public void itemStateChanged(ItemEvent e)
    {
        if (e.getStateChange() == ItemEvent.SELECTED)
        {
            int index = comboBox.getSelectedIndex();

            if ((index >= 0) && (index != month))
            {
                setMonth(index, false);
            }
        }
    }

    /**
     * Sets the month attribute of the JMonthSelector object. Fires a property change "month".
     *
     * @param newMonth
     *            the new month value
     * @param select
     *            true, if the month should be selcted in the combo box.
     */
    private void setMonth(int newMonth, boolean select)
    {
        if (!initialized || localInitialize)
        {
            return;
        }

        int oldMonth = month;
        month = newMonth;

        if (select)
        {
            comboBox.setSelectedIndex(month);
        }

        if (daySelector != null)
        {
            daySelector.setMonth(month);
        }

        firePropertyChange("month", oldMonth, month);
    }

    /**
     * Sets the month. This is a bound property.
     *
     * @param newMonth
     *            the new month value
     *
     * @see #getMonth
     */
    public void setMonth(int newMonth)
    {
        if (newMonth < 0 || newMonth > 11)
        {
            return;
        }
        setMonth(newMonth, true);
    }

    /**
     * Returns the month.
     *
     * @return the month value
     */
    public int getMonth()
    {
        return month;
    }

    /**
     * Convenience method set a day selector.
     *
     * @param daySelector
     *            the day selector
     */
    public void setDaySelector(JDaySelector daySelector)
    {
        this.daySelector = daySelector;
    }

    /**
     * Convenience method set a year selector. If set, the spin for the month buttons will spin
     * the year as well
     *
     * @param yearSelector
     *            the new yearSelector value
     */
    public void setYearSelector(JYearSelector yearSelector)
    {
        this.yearSelector = yearSelector;
    }

    /**
     * Returns the locale.
     *
     * @return the locale value
     *
     * @see #setLocale
     */
    public Locale getLocale()
    {
        return locale;
    }

    /**
     * Set the locale and initializes the new month names.
     *
     * @param l
     *            the new locale value
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
            locale = l;
            initNames();
        }
    }

    /**
     * Enable or disable the JMonthSelector.
     *
     * @param enabled
     *            the new enabled value
     */
    public void setEnabled(boolean enabled)
    {
        super.setEnabled(enabled);
        comboBox.setEnabled(enabled);

        if (spinner != null)
        {
            spinner.setEnabled(enabled);
        }
    }

    /**
     * Returns the month selector's comboBox text area (which allow the focus to
     * be set to it).
     *
     * @return the combo box
     */
    public Component getComboBox()
    {
        return this.comboBox;
    }

    /**
     * Returns the month selector's comboBox bar (which allow the focus to be set
     * to it).
     *
     * @return Component the spinner or null, if the month selector has no
     *         spinner
     */
    public Component getSpinner()
    {
        // Returns <null> if there is no spinner.
        return spinner;
    }

    /**
     * Returns the type of spinner the month selector is using.
     *
     * @return true, if the month selector has a spinner
     */
    public boolean hasSpinner()
    {
        return hasSpinner;
    }

    /**
     * Returns "JMonthSelector".
     *
     * @return the name value
     */
    public String getName()
    {
        return "JMonthSelector";
    }
}