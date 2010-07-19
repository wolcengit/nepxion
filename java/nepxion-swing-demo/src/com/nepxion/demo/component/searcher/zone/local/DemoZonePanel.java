package com.nepxion.demo.component.searcher.zone.local;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.nepxion.swing.border.ComplexEtchedBorder;
import com.nepxion.swing.border.ComplexSide;
import com.nepxion.swing.border.ComplexTitleBorder;
import com.nepxion.swing.button.ButtonManager;
import com.nepxion.swing.layout.filed.FiledLayout;
import com.nepxion.swing.searcher.zone.local.JZoneSelectorButton;
import com.nepxion.swing.textfield.number.JNumberTextField;

public class DemoZonePanel
	extends JPanel
{
	public DemoZonePanel()
	{
		setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 0));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new ZonePanel());
	}
	
	public class ZonePanel
		extends JPanel
	{
		public ZonePanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(new ComplexTitleBorder(new ComplexEtchedBorder(ComplexEtchedBorder.LOWERED, ComplexSide.NORTH), "ÇøºÅ²éÑ¯"));
			
			JNumberTextField textField = new JNumberTextField(12, 0);
			JZoneSelectorButton selectorButton = new JZoneSelectorButton(textField);
			
			JPanel panel = new JPanel();
			panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
			panel.add(textField);
			panel.add(selectorButton);
			ButtonManager.updateUI(panel, new Dimension(26, 22));			
			add(panel);
		}
	}
}