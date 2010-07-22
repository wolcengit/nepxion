package com.nepxion.demo.component.dialog;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.nepxion.swing.border.ComplexEtchedBorder;
import com.nepxion.swing.border.ComplexSide;
import com.nepxion.swing.border.ComplexTitleBorder;
import com.nepxion.swing.button.ButtonManager;
import com.nepxion.swing.button.JBasicButton;
import com.nepxion.swing.dialog.JExceptionDialog;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.layout.filed.FiledLayout;

public class DemoExceptionDialogPanel
	extends JPanel
{
	public DemoExceptionDialogPanel()
	{
		setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 0));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new ExceptionDialogPanel());
	}
	
	public class ExceptionDialogPanel
		extends JPanel
	{
		public ExceptionDialogPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(new ComplexTitleBorder(new ComplexEtchedBorder(ComplexEtchedBorder.LOWERED, ComplexSide.NORTH), "Exception Dialog"));
			
			JBasicButton exceptionDialogButton = new JBasicButton("Exception Dialog", IconFactory.getSwingIcon("component/dialog_16.png"), "Exception Dialog");
			exceptionDialogButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
	                try
	                {
	                    Integer.parseInt("a");
	                }
	                catch (NumberFormatException ex)
	                {
	                    JExceptionDialog.traceException(Frame.getFrames()[0], "Parse Integer Exception", "Exception Details", ex);
	                }
				}
			}
			);
			add(exceptionDialogButton);
			
			ButtonManager.updateUI(this);
		}
	}
}