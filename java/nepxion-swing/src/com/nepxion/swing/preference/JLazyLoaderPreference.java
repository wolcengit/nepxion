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

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.JPanel;

import com.nepxion.swing.border.BorderManager;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.layout.filed.FiledLayout;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.radiobutton.JBasicRadioButton;
import com.nepxion.swing.toggle.ITogglePanel;

public class JLazyLoaderPreference
	extends JPanel implements ITogglePanel
{
	private JBasicRadioButton syncLoadStrategyRadioButton;
	private JBasicRadioButton asynLoadStrategyRadioButton;
	
	public JLazyLoaderPreference()
	{
		syncLoadStrategyRadioButton = new JBasicRadioButton(SwingLocale.getString("sync_loader_strategy"), false);
		asynLoadStrategyRadioButton = new JBasicRadioButton(SwingLocale.getString("asyn_loader_strategy"), true);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(syncLoadStrategyRadioButton);
		buttonGroup.add(asynLoadStrategyRadioButton);
		
		JPanel loadStrategyPanel = new JPanel();
		loadStrategyPanel.setLayout(new FiledLayout(FiledLayout.ROW, FiledLayout.LEFT, 5));
		loadStrategyPanel.setBorder(BorderManager.createComplexTitleBorder(SwingLocale.getString("loader_strategy")));
		loadStrategyPanel.add(syncLoadStrategyRadioButton);
		loadStrategyPanel.add(asynLoadStrategyRadioButton);
		
		setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 5));
		add(loadStrategyPanel);
	}
	
	public boolean isSynchronized()
	{
		return syncLoadStrategyRadioButton.isSelected();
	}
	
	public String getToggleName()
	{
		return SwingLocale.getString("loader_toggle_name");
	}
	
	public void setToggleName(String toggleName)
	{
		
	}
	
	public Icon getToggleIcon()
	{
		return IconFactory.getSwingIcon("banner/query.png");
	}
	
	public void setToggleIcon(Icon toggleIcon)
	{
		
	}
	
	public Icon getToggleBannerIcon()
	{
		return IconFactory.getSwingIcon("banner/query.png");
	}
	
	public void setToggleBannerIcon(Icon toggleBannerIcon)
	{
		
	}
	
	public String getToggleDescription()
	{
		return SwingLocale.getString("loader_toggle_description");
	}
	
	public void setToggleDescription(String toggleDescription)
	{
		
	}
}