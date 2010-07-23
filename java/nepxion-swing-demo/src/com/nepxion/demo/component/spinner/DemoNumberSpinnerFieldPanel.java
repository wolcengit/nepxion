package com.nepxion.demo.component.spinner;

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
import com.nepxion.swing.layout.filed.FiledLayout;
import com.nepxion.swing.spinner.JNumberSpinnerField;

public class DemoNumberSpinnerFieldPanel
	extends JPanel
{
	public DemoNumberSpinnerFieldPanel()
	{
		setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 0));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new NumberSpinnerFieldPanel());
	}
	
	public class NumberSpinnerFieldPanel
		extends JPanel
	{
		public NumberSpinnerFieldPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(new ComplexTitleBorder(new ComplexEtchedBorder(ComplexEtchedBorder.LOWERED, ComplexSide.NORTH), "Number SpinnerField"));
			
			JNumberSpinnerField numberSpinnerField = new JNumberSpinnerField();
			numberSpinnerField.setMaximumSize(new Dimension(350, numberSpinnerField.getPreferredSize().height));
			
			add(numberSpinnerField);
		}
	}
}