package com.nepxion.swing.preference;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JPanel;

import com.nepxion.swing.border.BorderManager;
import com.nepxion.swing.checkbox.JBasicCheckBox;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.layout.filed.FiledLayout;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.panel.JTimePanel;

public class JSchedulerPreference
	extends JPreference
{
	private JTimePanel timePanel;
	
	private JBasicCheckBox bubbleTipCheckBox;
	
	public JSchedulerPreference()
	{
		timePanel = new JTimePanel(JTimePanel.VERTICAL);
		timePanel.setInterval(new int[] {0, 0, 0, 15, 0});
		timePanel.showMilliSecond(false);
		timePanel.setBorder(BorderManager.createComplexTitledBorder(SwingLocale.getString("timer_interval")));
		
		bubbleTipCheckBox = new JBasicCheckBox(SwingLocale.getString("timer_bubble_tip"), true);
		bubbleTipCheckBox.setBorder(BorderFactory.createEmptyBorder());
		
		JPanel scheduleMessagePanel = new JPanel();
		scheduleMessagePanel.setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.LEFT, 5));
		scheduleMessagePanel.setBorder(BorderManager.createComplexTitledBorder(SwingLocale.getString("timer_message_hint")));
		scheduleMessagePanel.add(bubbleTipCheckBox);
		
		setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 5));
		add(timePanel);
		add(scheduleMessagePanel);
	}
	
	public JTimePanel getTimePanel()
	{
		return timePanel;
	}
	
	public int[] getInterval()
	{
		return timePanel.getInterval();
	}
	
	public boolean isBubbleTipShowing()
	{
		return bubbleTipCheckBox.isSelected();
	}
	
	public boolean verify()
	{
		return timePanel.verify();
	}
	
	public String getToggleName()
	{
		return SwingLocale.getString("scheduler_toggle_name");
	}
	
	public void setToggleName(String toggleName)
	{
		
	}
	
	public Icon getToggleIcon()
	{
		return IconFactory.getSwingIcon("banner/timer.png");
	}
	
	public void setToggleIcon(Icon toggleIcon)
	{
		
	}
	
	public Icon getToggleBannerIcon()
	{
		return IconFactory.getSwingIcon("banner/timer.png");
	}
	
	public void setToggleBannerIcon(Icon toggleBannerIcon)
	{
		
	}
	
	public String getToggleDescription()
	{
		return SwingLocale.getString("scheduler_toggle_description");
	}
	
	public void setToggleDescription(String toggleDescription)
	{
		
	}
}