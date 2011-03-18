package com.nepxion.demo.component.checkbox;

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
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.nepxion.swing.border.BorderManager;
import com.nepxion.swing.checkbox.JBasicCheckBox;
import com.nepxion.swing.checkbox.JLiteCheckBox;
import com.nepxion.swing.layout.filed.FiledLayout;
import com.nepxion.swing.radiobutton.JBasicRadioButton;

public class DemoCheckBoxPanel
	extends JPanel
{
	public DemoCheckBoxPanel()
	{
		setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 0));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new StyleCheckBoxPanel());
	}	
	
	public class StyleCheckBoxPanel
		extends JPanel
	{
		public StyleCheckBoxPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderManager.createComplexTitleBorder("Flat ButtonUI"));
		
			JLiteCheckBox styleCheckBox = new JLiteCheckBox("Style CheckBox", true);
			add(styleCheckBox);
			
			JBasicCheckBox c = new JBasicCheckBox("CheckBox");
			add(c);

			JBasicRadioButton r = new JBasicRadioButton("RadioButton");
			add(r);			
		}
	}	
}