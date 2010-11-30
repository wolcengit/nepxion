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

public interface ITogglePanel
{
	public String getToggleName();
	
	public void setToggleName(String toggleName);
	
	public Icon getToggleIcon();
	
	public void setToggleIcon(Icon toggleIcon);
	
	public Icon getToggleBannerIcon();
	
	public void setToggleBannerIcon(Icon toggleBannerIcon);
	
	public String getToggleDescription();
	
	public void setToggleDescription(String toggleDescription);
	
	public boolean isEnabled();
	
	public void setEnabled(boolean enabled);
}