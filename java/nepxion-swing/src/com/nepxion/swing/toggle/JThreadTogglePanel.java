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
import javax.swing.JLabel;

import com.nepxion.swing.thread.container.JThreadContainer;

public abstract class JThreadTogglePanel
	extends JThreadContainer implements ITogglePanel
{
	protected String toggleName;
	protected Icon toggleIcon;
	protected Icon toggleBannerIcon;
	protected String toggleDescription;
	
	public JThreadTogglePanel()
	{
		super();
	}
	
	public JThreadTogglePanel(String information)
	{
		super(information);
	}
	
	public JThreadTogglePanel(JLabel animationLabel, String information)
	{
		super(animationLabel, information);
	}
	
	public String getToggleName()
	{
		return toggleName;
	}
	
	public void setToggleName(String toggleName)
	{
		this.toggleName = toggleName;
	}
	
	public Icon getToggleIcon()
	{
		return toggleIcon;
	}
	
	public void setToggleIcon(Icon toggleIcon)
	{
		this.toggleIcon = toggleIcon;
	}
	
	public Icon getToggleBannerIcon()
	{
		return toggleBannerIcon;
	}
	
	public void setToggleBannerIcon(Icon toggleBannerIcon)
	{
		this.toggleBannerIcon = toggleBannerIcon;
	}
	
	public String getToggleDescription()
	{
		return toggleDescription;
	}
	
	public void setToggleDescription(String toggleDescription)
	{
		this.toggleDescription = toggleDescription;
	}
}