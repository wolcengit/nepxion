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
import com.nepxion.swing.spinner.JPointSpinner;

public class DemoPointSpinnerPanel
	extends JPanel
{
	public DemoPointSpinnerPanel()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new PointSpinnerPanel());
	}
	
	public class PointSpinnerPanel
		extends JPanel
	{
		public PointSpinnerPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(new ComplexTitleBorder(new ComplexEtchedBorder(ComplexEtchedBorder.LOWERED, ComplexSide.NORTH), "Point Spinner"));
			
			JPointSpinner pointSpinner = new JPointSpinner();
			pointSpinner.setPreferredSize(new Dimension(100, 30));
			
			add(pointSpinner);
		}
	}
}