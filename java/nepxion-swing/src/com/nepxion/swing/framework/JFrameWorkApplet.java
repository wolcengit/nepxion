package com.nepxion.swing.framework;

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

import javax.swing.JComponent;

import com.nepxion.swing.applet.JBasicApplet;
import com.nepxion.swing.style.framework.IStyle;
import com.nepxion.swing.style.framework.StyleManager;

public class JFrameWorkApplet
	extends JBasicApplet implements JFrameWorkWindow
{
	private JFrameWorkHierarchy frameWorkHierarchy;
	
	public void init()
	{
		super.init();
		
		JComponent contentPane = (JComponent) getContentPane();
		
		IStyle style = (IStyle) StyleManager.getStyle();
		contentPane.setBorder(style.getBorder());
		contentPane.setBackground(Color.white);
	}
	
	public void setHierarchy(JFrameWorkHierarchy frameWorkHierarchy)
	{
		this.frameWorkHierarchy = frameWorkHierarchy;
		
		if (getContentPane().getComponentCount() > 0)
		{
			getContentPane().removeAll();
		}
		getContentPane().add(frameWorkHierarchy);
	}
	
	public JFrameWorkHierarchy getHierarchy()
	{
		return frameWorkHierarchy;
	}
}