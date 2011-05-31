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
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

import com.nepxion.swing.action.JSecurityAction;
import com.nepxion.swing.framework.ribbon.JRibbonHierarchy;
import com.nepxion.swing.framework.ribbon.JRibbonNavigatorBar;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.locale.SwingLocale;

public class JRibbonToggleHeightAction
	extends JSecurityAction	implements MouseListener
{
	/**
	 * The instance of JRibbonNavigatorBar.
	 */
	private JRibbonNavigatorBar ribbonNavigatorBar;
	
	/**
	 * The instance of JRibbonHierarchy.
	 */
	private JRibbonHierarchy ribbonHierarchy;
	
	/**
	 * Constructs with the specified initial ribbon navigator bar.
	 * @param ribbonNavigatorBar the instance of JRibbonNavigatorBar
	 */
	public JRibbonToggleHeightAction(JRibbonNavigatorBar ribbonNavigatorBar)
	{
		super(SwingLocale.getString("toggle_navigatorbar_visibility"), IconFactory.getSwingIcon("toggle_size.png"), SwingLocale.getString("toggle_navigatorbar_visibility"));
		
		this.ribbonNavigatorBar = ribbonNavigatorBar;
	}
	
	/**
	 * Constructs with the specified initial ribbon hierarchy.
	 * @param ribbonHierarchy the instance of JRibbonHierarchy
	 */
	public JRibbonToggleHeightAction(JRibbonHierarchy ribbonHierarchy)
	{
		super(SwingLocale.getString("toggle_navigatorbar_visibility"), IconFactory.getSwingIcon("toggle_size.png"), SwingLocale.getString("toggle_navigatorbar_visibility"));
		
		this.ribbonHierarchy = ribbonHierarchy;
	}
		
    /**
     * Invoked when an action occurs.
     * @param e the instance of ActionEvent
     */
	public void execute(ActionEvent e)
	{
		toggle();
	}
	
    /**
     * Invoked when the mouse button has been clicked (pressed and released) on a component.
     * @param e the instance of MouseEvent
     */
	public void mouseClicked(MouseEvent e)
	{
		Object source = e.getSource();
		if (source instanceof JTabbedPane)
		{
			JTabbedPane tabbedPane = (JTabbedPane) source;
			int index = tabbedPane.indexAtLocation(e.getX(), e.getY());
			if (index < 0)
			{
				return;
			}
			
			if (SwingUtilities.isLeftMouseButton(e) && e.getClickCount() > 1)
			{
				toggle();
			}
		}
		else
		{
			if (SwingUtilities.isLeftMouseButton(e) && e.getClickCount() > 1)
			{
				toggle();
			}
		}
	}
	
    /**
     * Invoked when the mouse button has been pressed on a component.
     * @param e the instance of MouseEvent
     */
	public void mousePressed(MouseEvent e)
	{
		
	}
	
    /**
     * Invoked when the mouse button has been released on a component.
     * @param e the instance of MouseEvent
     */
	public void mouseReleased(MouseEvent e)
	{
		
	}
	
    /**
     * Invoked when the mouse enters a component.
     * @param e the instance of MouseEvent
     */
	public void mouseEntered(MouseEvent e)
	{
		
	}
	
    /**
     * Invoked when the mouse exits a component.
     * @param e the instance of MouseEvent
     */
	public void mouseExited(MouseEvent e)
	{
		
	}
	
	/**
	 * Toggles the height.
	 */
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