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

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.nepxion.swing.button.ButtonManager;
import com.nepxion.swing.button.JBasicToggleButton;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.textarea.JBasicTextArea;
import com.nepxion.util.io.FileUtil;

public class DemoToggleTemplate
	extends JPanel
{
	private JComponent viewComponent;
	private JScrollPane codeScrollPane;
	private JBasicTextArea codeTextArea;
	private ToggleButtonPanel toggleButtonPanel;
	
	private String codeContent;
	
	public DemoToggleTemplate(JComponent viewComponent)
	{
		this.viewComponent = viewComponent;
			
		codeTextArea = new JBasicTextArea();
		codeTextArea.setTabSize(2);
						
		codeScrollPane = new JScrollPane(codeTextArea);
		toggleButtonPanel = new ToggleButtonPanel();
		
		setLayout(new BorderLayout());
		add(viewComponent, BorderLayout.CENTER);
		add(toggleButtonPanel, BorderLayout.SOUTH); 
	}
	
	public class ToggleButtonPanel
		extends JPanel
	{
		public ToggleButtonPanel()
		{			
			JBasicToggleButton viewToggleButton = new JBasicToggleButton("View", IconFactory.getSwingIcon("component/view.png"), true);
			viewToggleButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					DemoToggleTemplate.this.remove(codeScrollPane);
					DemoToggleTemplate.this.add(viewComponent, BorderLayout.CENTER);
					DemoToggleTemplate.this.revalidate();
					DemoToggleTemplate.this.repaint(); 					
				}
			}
			);
			JBasicToggleButton codeToggleButton = new JBasicToggleButton("Code", IconFactory.getSwingIcon("component/java.png"), false);		
			codeToggleButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					DemoToggleTemplate.this.remove(viewComponent);
					DemoToggleTemplate.this.add(codeScrollPane, BorderLayout.CENTER);
					DemoToggleTemplate.this.revalidate();
					DemoToggleTemplate.this.repaint();
					
					if (codeContent == null)
					{
						String projectFolderName = "nepxion-swing-demo";
						String codePath = FileUtil.getCodePath(viewComponent.getClass(), projectFolderName);
						
						codeContent = FileUtil.read(codePath, false);
						
						codeTextArea.setText(codeContent);
						codeTextArea.moveCaretPosition(0);
					}					
				}
			}
			);
			
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(BorderFactory.createEmptyBorder(2, 0, 3, 3)); // 2, 0, 1, 1
			add(Box.createGlue());
			add(viewToggleButton);			
			add(Box.createHorizontalStrut(3));
			add(codeToggleButton);
			
			ButtonManager.updateUI(this, new Dimension(75, 25));
		}
	}
}