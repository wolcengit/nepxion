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
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import com.nepxion.swing.border.ComplexEtchedBorder;
import com.nepxion.swing.border.ComplexSide;
import com.nepxion.swing.border.ComplexTitleBorder;
import com.nepxion.swing.checkbox.JLiteCheckBox;
import com.nepxion.swing.layout.filed.FiledLayout;

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
			setBorder(new ComplexTitleBorder(new ComplexEtchedBorder(ComplexEtchedBorder.LOWERED, ComplexSide.NORTH), "Flat ButtonUI"));
		
			JLiteCheckBox styleCheckBox = new JLiteCheckBox("Style CheckBox", true);
			add(styleCheckBox);
			
			JCheckBox c = new JCheckBox("CheckBox");
			add(c);

			JRadioButton r = new JRadioButton("RadioButton");
			add(r);			
		}
	}	
}