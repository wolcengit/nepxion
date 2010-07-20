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
import com.nepxion.swing.spinner.JSpinnerField;

public class DemoSpinnerFieldPanel
	extends JPanel
{
	public DemoSpinnerFieldPanel()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new SpinnerFieldPanel());
	}
	
	public class SpinnerFieldPanel
		extends JPanel
	{
		public SpinnerFieldPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(new ComplexTitleBorder(new ComplexEtchedBorder(ComplexEtchedBorder.LOWERED, ComplexSide.NORTH), "SpinnerField"));
			
			JSpinnerField spinnerField = new JSpinnerField();
			spinnerField.setPreferredSize(new Dimension(100, 30));
			
			add(spinnerField);
		}
	}
}