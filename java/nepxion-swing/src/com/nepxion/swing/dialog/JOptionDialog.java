package com.nepxion.swing.dialog;

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
import java.awt.Container;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Frame;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JComponent;

import com.nepxion.swing.panel.option.JOptionButtonPanel;
import com.nepxion.swing.panel.option.JOptionPanel;
import com.nepxion.swing.panel.option.OptionConstants;

public class JOptionDialog
	extends JBasicDialog implements OptionConstants
{
	private JOptionPanel optionPanel;
	private JOptionButtonPanel optionButtonPanel;
	
	public JOptionDialog(Frame owner, String title)
	{
		super(owner, title);
		
		initComponents();
	}
	
	public JOptionDialog(Dialog owner, String title)
	{
		super(owner, title);
		
		initComponents();
	}
	
	public JOptionDialog(Frame owner, String title, Dimension dimension)
	{
		super(owner, title, dimension);
		
		initComponents();
	}
	
	public JOptionDialog(Dialog owner, String title, Dimension dimension)
	{
		super(owner, title, dimension);
		
		initComponents();
	}
	
	public JOptionDialog(Frame owner, String title, boolean modal)
	{
		super(owner, title, modal);
		
		initComponents();
	}
	
	public JOptionDialog(Dialog owner, String title, boolean modal)
	{
		super(owner, title, modal);
		
		initComponents();
	}
	
	public JOptionDialog(Frame owner, String title, Dimension dimension, boolean modal)
	{
		super(owner, title, dimension, modal);
		
		initComponents();
	}
	
	public JOptionDialog(Dialog owner, String title, Dimension dimension, boolean modal)
	{
		super(owner, title, dimension, modal);
		
		initComponents();
	}
	
	public JOptionDialog(Frame owner, String title, boolean modal, boolean isHint)
	{
		super(owner, title, modal, isHint);
		
		initComponents();
	}
	
	public JOptionDialog(Dialog owner, String title, boolean modal, boolean isHint)
	{
		super(owner, title, modal, isHint);
		
		initComponents();
	}
	
	public JOptionDialog(Frame owner, String title, Dimension dimension, boolean modal, boolean isHint)
	{
		super(owner, title, dimension, modal, isHint);
		
		initComponents();
	}
	
	public JOptionDialog(Dialog owner, String title, Dimension dimension, boolean modal, boolean isHint)
	{
		super(owner, title, dimension, modal, isHint);
		
		initComponents();
	}
	
	public JOptionDialog(Frame owner, String title, boolean modal, boolean isHint, boolean isAdaptable)
	{
		super(owner, title, modal, isHint, isAdaptable);
		
		initComponents();
	}
	
	public JOptionDialog(Dialog owner, String title, boolean modal, boolean isHint, boolean isAdaptable)
	{
		super(owner, title, modal, isHint, isAdaptable);
		
		initComponents();
	}
	
	public JOptionDialog(Frame owner, String title, Dimension dimension, boolean modal, boolean isHint, boolean isAdaptable)
	{
		super(owner, title, dimension, modal, isHint, isAdaptable);
		
		initComponents();
	}
	
	public JOptionDialog(Dialog owner, String title, Dimension dimension, boolean modal, boolean isHint, boolean isAdaptable)
	{
		super(owner, title, dimension, modal, isHint, isAdaptable);
		
		initComponents();
	}
	
	private void initComponents()
	{
		optionPanel = new JOptionPanel();
		optionButtonPanel = new JOptionButtonPanel()
		{
			public boolean confirm()
			{
				return JOptionDialog.this.confirm();
			}
			
			public boolean cancel()
			{
				return JOptionDialog.this.cancel();
			}
			
			public boolean apply()
			{
				return JOptionDialog.this.apply();
			}
			
			public boolean close()
			{
				return JOptionDialog.this.close();
			}
		};
		optionButtonPanel.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
		
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		contentPane.add(optionPanel, BorderLayout.CENTER);
		contentPane.add(optionButtonPanel, BorderLayout.SOUTH);
	}
	
	public JOptionPanel getOptionPanel()
	{
		return optionPanel;
	}
	
	public JOptionButtonPanel getOptionButtonPanel()
	{
		return optionButtonPanel;
	}
	
	public void setOption(int option)
	{
		optionButtonPanel.setOption(option);
	}
	
	public void setIcon(Icon icon)
	{
		optionPanel.setIcon(icon);
	}
	
	public void setComponent(JComponent component)
	{
		optionPanel.setComponent(component);
	}
	
	public String getValue()
	{
		return optionButtonPanel.getValue();
	}
	
	public boolean confirm()
	{
		return true;
	}
	
	public boolean cancel()
	{
		return true;
	}
	
	public boolean apply()
	{
		return true;
	}
	
	public boolean close()
	{
		return true;
	}
	
	public boolean isConfirmed()
	{
		String value = getValue();
		if (value != null && value.equals(COMFIRM))
		{
			return true;
		}
		
		return false;
	}
	
	public boolean isCancelled()
	{
		String value = getValue();
		if (value != null && value.equals(CANCEL))
		{
			return true;
		}
		
		return false;
	}
	
	public boolean isApplied()
	{
		String value = getValue();
		if (value != null && value.equals(APPLY))
		{
			return true;
		}
		
		return false;
	}
	
	public boolean isClosed()
	{
		String value = getValue();
		if (value != null && value.equals(CLOSE))
		{
			return true;
		}
		
		return false;
	}
}