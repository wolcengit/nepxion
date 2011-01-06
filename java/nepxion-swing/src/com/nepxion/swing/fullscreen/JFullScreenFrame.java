package com.nepxion.swing.fullscreen;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;

import com.nepxion.swing.frame.JBasicFrame;
import com.nepxion.swing.icon.IconFactory;

public class JFullScreenFrame
	extends JBasicFrame implements FullScreenConstants
{		
	private JFullScreenDecorationPanel decorationPanel;
	
	public JFullScreenFrame()
	{
		super();
		
		initComponents();
	}
	
	public JFullScreenFrame(String title)
	{
		super(title);
		
		initComponents();
	}
	
	public JFullScreenFrame(String title, ImageIcon imageIcon)
	{
		super(title, imageIcon);
		
		initComponents();
	}
	
	public JFullScreenFrame(String title, Dimension dimension)
	{
		super(title, dimension);
		
		initComponents();
	}
	
	public JFullScreenFrame(String title, boolean isDestroy)
	{
		super(title, isDestroy);
		
		initComponents();
	}
	
	public JFullScreenFrame(String title, ImageIcon imageIcon, Dimension dimension)
	{
		super(title, imageIcon, dimension);
		
		initComponents();
	}
	
	public JFullScreenFrame(String title, ImageIcon imageIcon, boolean isDestroy)
	{
		super(title, imageIcon, isDestroy);
		
		initComponents();
	}
	
	public JFullScreenFrame(String title, Dimension dimension, boolean isDestroy)
	{
		super(title, dimension, isDestroy);
		
		initComponents();
	}
	
	public JFullScreenFrame(String title, boolean isHint, boolean isDestroy)
	{
		super(title, isHint, isDestroy);
		
		initComponents();
	}
	
	public JFullScreenFrame(String title, ImageIcon imageIcon, Dimension dimension, boolean isDestroy)
	{
		super(title, imageIcon, dimension, isDestroy);
		
		initComponents();
	}
	
	public JFullScreenFrame(String title, ImageIcon imageIcon, boolean isHint, boolean isDestroy)
	{
		super(title, imageIcon, isHint, isDestroy);
		
		initComponents();
	}
	
	public JFullScreenFrame(String title, Dimension dimension, boolean isHint, boolean isDestroy)
	{
		super(title, dimension, isHint, isDestroy);
		
		initComponents();
	}
	
	public JFullScreenFrame(String title, ImageIcon imageIcon, Dimension dimension, boolean isHint, boolean isDestroy)
	{
		super(title, imageIcon, dimension, isHint, isDestroy);
		
		initComponents();
	}
	
	private void initComponents()
	{
		decorationPanel = new JFullScreenDecorationPanel(WINDOW_TITLE, IconFactory.getSwingIcon(WINDOW_ICON));
		decorationPanel.setBackground(Color.white);
		
		getContentPane().add(decorationPanel);
	}
	
	public boolean isValid(String content)
	{
		return content != null && !content.trim().equals("");
	}
	
	public JFullScreenDecorationPanel getContainer()
	{
		return decorationPanel;
	}
	
	public static void main(String[] args)
	{
		new JFullScreenFrame().setVisible(true);
	}
}