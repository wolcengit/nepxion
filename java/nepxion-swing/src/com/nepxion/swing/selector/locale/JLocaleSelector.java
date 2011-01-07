package com.nepxion.swing.selector.locale;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;
import java.util.Locale;

import javax.swing.JComboBox;
import javax.swing.JComponent;

public class JLocaleSelector
    extends JComboBox implements ItemListener
{
    protected JComponent component;

    /**
     * Default JLocaleSelector constructor.
     */
    public JLocaleSelector()
    {
        this(null);
    }

    /**
     * Returns "JLocaleSelector".
     *
     * @return the name value
     */
    public String getName()
    {
        return "JLocaleSelector";
    }

    /**
     * Default JLocaleSelector constructor.
     */
    public JLocaleSelector(JComponent component)
    {
        super();
        
        this.component = component;
        addItemListener(this);
        locales = Calendar.getAvailableLocales();
        localeCount = locales.length;

        for (int i = 0; i < localeCount; i++)
        {
            if (locales[i].getCountry().length() > 0)
            {
                addItem(locales[i].getDisplayName());
            }
        }

        setLocale(Locale.getDefault());
        
        setBackground(Color.white);
        setFocusable(false);
        setRequestFocusEnabled(false);         
    }

    /**
     * The ItemListener for the locales.
     */
    public void itemStateChanged(ItemEvent iEvt)
    {
        String item = (String) iEvt.getItem();
        int i;

        for (i = 0; i < localeCount; i++)
        {
            if (locales[i].getDisplayName().equals(item))
            {
                break;
            }
        }
        setLocale(locales[i], false);
    }

    /**
     * Sets the locale.
     *
     * @see #getLocale
     */
    private void setLocale(Locale l, boolean select)
    {
        Locale oldLocale = locale;
        locale = l;
        int n = 0;

        if (select)
        {
            for (int i = 0; i < localeCount; i++)
            {
                if (locales[i].getCountry().length() > 0)
                {
                    if (locales[i].equals(locale))
                    {
                        setSelectedIndex(n);
                    }
                    n += 1;
                }
            }
        }

        firePropertyChange("locale", oldLocale, locale);
        if (component != null)
        {
            component.setLocale(l);
        }
    }
    
    public JComponent getComponent()
    {
    	return component;
    }

    public void setComponent(JComponent component)
    {
    	this.component = component;
    }
    
    /**
     * Sets the locale. This is a bound property.
     *
     * @see #getLocale
     */
    public void setLocale(Locale l)
    {
        setLocale(l, true);
    }

    /**
     * Returns the locale.
     */
    public Locale getLocale()
    {
        return locale;
    }

    private Locale[] locales;
    private Locale locale;
    private int localeCount;
}
