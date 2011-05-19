package com.nepxion.swing.framework.ribbon.action;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.nepxion.swing.action.JSecurityAction;
import com.nepxion.swing.framework.ribbon.JRibbonHierarchy;
import com.nepxion.swing.framework.ribbon.JRibbonNavigatorBar;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.locale.SwingLocale;

public class JRibbonToggleHeightAction
	extends JSecurityAction	implements MouseListener
{
	private JRibbonNavigatorBar ribbonNavigatorBar;
	
	private JRibbonHierarchy ribbonHierarchy;
	
	public JRibbonToggleHeightAction(JRibbonNavigatorBar ribbonNavigatorBar)
	{
		super(SwingLocale.getString("toggle_navigatorbar_visibility"), IconFactory.getSwingIcon("toggle_size.png"), SwingLocale.getString("toggle_navigatorbar_visibility"));
		
		this.ribbonNavigatorBar = ribbonNavigatorBar;
	}
	
	public JRibbonToggleHeightAction(JRibbonHierarchy ribbonHierarchy)
	{
		super(SwingLocale.getString("toggle_navigatorbar_visibility"), IconFactory.getSwingIcon("toggle_size.png"), SwingLocale.getString("toggle_navigatorbar_visibility"));
		
		this.ribbonHierarchy = ribbonHierarchy;
	}
		
	public void execute(ActionEvent e)
	{
		toggle();
	}
	
	public void mouseClicked(MouseEvent e)
	{
		if (SwingUtilities.isLeftMouseButton(e) && e.getClickCount() > 1)
		{
			toggle();
		}
	}
	
	public void mousePressed(MouseEvent e)
	{
		
	}
	
	public void mouseReleased(MouseEvent e)
	{
		
	}
	
	public void mouseEntered(MouseEvent e)
	{
		
	}
	
	public void mouseExited(MouseEvent e)
	{
		
	}
	
	private void toggle()
	{
		if (ribbonNavigatorBar == null)
		{
			JPanel navigatorContainer = ribbonHierarchy.getNavigatorContainer();
			
			ribbonNavigatorBar = (JRibbonNavigatorBar) navigatorContainer.getComponent(0);
		}
		
		if (ribbonNavigatorBar == null)
		{
			return;
		}
		
		ribbonNavigatorBar.toggleHeight();
	}
}