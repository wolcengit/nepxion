package com.nepxion.demo.common;

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

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.nepxion.swing.border.ComplexEtchedBorder;
import com.nepxion.swing.border.ComplexSide;
import com.nepxion.swing.border.ComplexTitleBorder;
import com.nepxion.swing.textfield.JBasicTextField;

public class DemoSelectionValuePanel
	extends JPanel
{
	private JBasicTextField textField;
	
	public DemoSelectionValuePanel()
	{
		this(225);
	}
	
	public DemoSelectionValuePanel(int textFieldWidth)
	{
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setBorder(new ComplexTitleBorder(new ComplexEtchedBorder(ComplexEtchedBorder.LOWERED, ComplexSide.NORTH), "Selection Value"));
		
		textField = new JBasicTextField();
		textField.setOpaque(false);
		textField.setPreferredSize(new Dimension(textFieldWidth, textField.getPreferredSize().height));
		textField.setMaximumSize(new Dimension(textFieldWidth, textField.getPreferredSize().height));
		textField.setMinimumSize(new Dimension(textFieldWidth, textField.getPreferredSize().height));
		textField.setSize(new Dimension(textFieldWidth, textField.getPreferredSize().height));
		
		add(new JLabel("Your Selection Value"));
		add(textField);
	}
	
	public void setValue(String value)
	{
		textField.setText(value);
	}
}