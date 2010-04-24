package com.nepxion.demo.component.textarea;

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
import javax.swing.JScrollPane;

import com.nepxion.swing.border.ComplexEtchedBorder;
import com.nepxion.swing.border.ComplexSide;
import com.nepxion.swing.border.ComplexTitleBorder;
import com.nepxion.swing.textarea.JBasicTextArea;

public class DemoBasicTextAreaPanel
	extends JPanel
{
	public DemoBasicTextAreaPanel()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new BasicTextAreaPanel());
	}
	
	public class BasicTextAreaPanel
		extends JPanel
	{
		public BasicTextAreaPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(new ComplexTitleBorder(new ComplexEtchedBorder(ComplexEtchedBorder.LOWERED, ComplexSide.NORTH), "Basic TextArea"));
			
			JBasicTextArea basicTextArea = new JBasicTextArea();
			basicTextArea.setText("Right-clicked popupMenu to 'Copy' 'Paste' 'Cut' & 'Clean'");
			
			JScrollPane basicScrollPane = new JScrollPane();
			basicScrollPane.getViewport().add(basicTextArea);	
			
			add(basicScrollPane);			
		}
	}
}