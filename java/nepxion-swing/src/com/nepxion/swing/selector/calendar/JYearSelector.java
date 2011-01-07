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

import java.util.Calendar;

import com.nepxion.swing.spinner.JNumberSpinnerField;

public class JYearSelector
    extends JNumberSpinnerField
{
    protected JDaySelector daySelector;
    protected int startYear;
    protected int endYear;

    /**
     * Default JCalendar constructor.
     */
    public JYearSelector()
    {
        Calendar calendar = Calendar.getInstance();
        daySelector = null;
        setMinimum(calendar.getMinimum(Calendar.YEAR));
        setMaximum(calendar.getMaximum(Calendar.YEAR));
        setValue(calendar.get(Calendar.YEAR));
    }

    /**
     * Sets the year. This is a bound property.
     *
     * @param y the new year
     *
     * @see #getYear
     */
    public void setYear(int y)
    {
        int oldYear = getValue();
        
        super.setValue(y, true, false);

        if (daySelector != null)
        {
            daySelector.setYear(value);
        }

        spinner.setValue(new Integer(value));

        if (oldYear == value) // by neptune
        {
            oldYear = -1;
        }
        firePropertyChange("year", oldYear, value);
    }

    /**
     * Sets the year value.
     *
     * @param value the year value
     */
    public void setValue(int value)
    {
        setYear(value);
    }

    /**
     * Returns the year.
     *
     * @return the year
     */
    public int getYear()
    {
        return super.getValue();
    }

    /**
     * Convenience method set a day selector that might be updated directly.
     *
     * @param daySelector the day selector
     */
    public void setDaySelector(JDaySelector daySelector)
    {
        this.daySelector = daySelector;
    }

    /**
     * Returns "JYearSelector".
     *
     * @return the name value
     */
    public String getName()
    {
        return "JYearSelector";
    }

    /**
     * Returns the endy ear.
     *
     * @return the end year
     */
    public int getEndYear()
    {
        return getMaximum();
    }

    /**
     * Sets the end ear.
     *
     * @param endYear the end year
     */
    public void setEndYear(int endYear)
    {
        setMaximum(endYear);
    }

    /**
     * Returns the start year.
     *
     * @return the start year.
     */
    public int getStartYear()
    {
        return getMinimum();
    }

    /**
     * Sets the start year.
     *
     * @param startYear the start year
     */
    public void setStartYear(int startYear)
    {
        setMinimum(startYear);
    }
}