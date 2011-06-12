package com.nepxion.swing.toggle;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import javax.swing.Icon;
import javax.swing.JPanel;

public class JTogglePanel
	extends JPanel implements ITogglePanel
{
	/**
	 * The toggle name.
	 */
	protected String toggleName;
	
	/**
	 * The toggle icon.
	 */
	protected Icon toggleIcon;
	
	/**
	 * The toggle banner icon.
	 */
	protected Icon toggleBannerIcon;
	
	/**
	 * The toggle description.
	 */
	protected String toggleDescription;
	
	/**
	 * Constructs with the default.
	 */
	public JTogglePanel()
	{
		
	}
	
	/**
	 * Gets the toggle name.
	 * @return the toggle name string
	 */
	public String getToggleName()
	{
		return toggleName;
	}
	
	/**
	 * Sets the toggle name.
	 * @param toggleName the toggle name string
	 */
	public void setToggleName(String toggleName)
	{
		this.toggleName = toggleName;
	}
	
	/**
	 * Gets the toggle icon.
	 * @return the instance of Icon
	 */
	public Icon getToggleIcon()
	{
		return toggleIcon;
	}
	
	/**
	 * Sets the toggle icon.
	 * @param toggleIcon
	 */
	public void setToggleIcon(Icon toggleIcon)
	{
		this.toggleIcon = toggleIcon;
	}
	
	/**
	 * Gets the toggle banner icon.
	 * @return the instance of Icon
	 */
	public Icon getToggleBannerIcon()
	{
		return toggleBannerIcon;
	}
	
	/**
	 * Sets the toggle banner icon.
	 * @param toggleBannerIcon the instance of Icon
	 */
	public void setToggleBannerIcon(Icon toggleBannerIcon)
	{
		this.toggleBannerIcon = toggleBannerIcon;
	}
	
	/**
	 * Gets the toggle description.
	 * @return the toggle description string
	 */
	public String getToggleDescription()
	{
		return toggleDescription;
	}
	
	/**
	 * Sets the toggle description.
	 * @param toggleDescription the toggle description string
	 */
	public void setToggleDescription(String toggleDescription)
	{
		this.toggleDescription = toggleDescription;
	}
}