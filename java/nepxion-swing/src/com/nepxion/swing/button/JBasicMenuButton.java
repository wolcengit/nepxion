package com.nepxion.swing.button;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

public class JBasicMenuButton
	extends JBasicButton implements MouseListener, PopupMenuListener
{
	/**
	 * The instance of JPopupMenu.
	 */
	protected JPopupMenu popupMenu;
	
	/**
	 * Constructs with the default.
	 */
	public JBasicMenuButton()
	{
		super();
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial action.
	 * @param action the instance of Action
	 */
	public JBasicMenuButton(Action action)
	{
		super(action);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial text.
	 * @param text the text string
	 */
	public JBasicMenuButton(String text)
	{
		super(text);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial icon.
	 * @param icon the instance of Icon
	 */
	public JBasicMenuButton(Icon icon)
	{
		super(icon);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial text and icon.
	 * @param text the text string 
	 * @param icon the icon of Icon
	 */
	public JBasicMenuButton(String text, Icon icon)
	{
		super(text, icon);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial text and tooltip text.
	 * @param text the text string
	 * @param toolTipText the tooltip text string
	 */
	public JBasicMenuButton(String text, String toolTipText)
	{
		super(text);
		
		initComponents();
		
		setToolTipText(toolTipText);
	}
	
	/**
	 * Constructs with the specified initial icon and tooltip text.
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text string
	 */
	public JBasicMenuButton(Icon icon, String toolTipText)
	{
		super(icon);
		
		initComponents();
		
		setToolTipText(toolTipText);
	}
	
	/**
	 * Constructs with the specified initial text and icon.
	 * @param text the text string 
	 * @param icon the icon of Icon
	 * @param toolTipText the tooltip text string
	 */
	public JBasicMenuButton(String text, Icon icon, String toolTipText)
	{
		super(text, icon);
		
		initComponents();
		
		setToolTipText(toolTipText);
	}
	
	/**
	 * Initializes the components.
	 */
	private void initComponents()
	{
		widthInset += 7;
		
		addMouseListener(this);
	}
	
	/**
	 * Gets the popup menu.
	 * @return the instance of JPopupMenu
	 */
	public JPopupMenu getPopupMenu()
	{
		return popupMenu;
	}
	
	/**
	 * Sets the popup menu.
	 * @param popupMenu the instance of JPopupMenu 
	 */
	public void setPopupMenu(JPopupMenu popupMenu)
	{
		this.popupMenu = popupMenu;
		this.popupMenu.addPopupMenuListener(this);
	}
	
	/**
	 * Fires the mouse clicked event.
	 * @param e the instance of MouseEvent
	 */
	public void mouseClicked(MouseEvent e)
	{
	}
	
	/**
	 * Fires the mouse pressed event.
	 * @param e the instance of MouseEvent
	 */
	public void mousePressed(MouseEvent e)
	{
		BasicButtonModel buttonModel = (BasicButtonModel) getModel();
		if (!buttonModel.isEnabled())
		{
			return;
		}
		
		if (SwingUtilities.isLeftMouseButton(e))
		{
			if (popupMenu != null)
			{
				popupMenu.show(this, 0, getSize().height);
			}
		}
	}
	
	/**
	 * Fires the mouse released event.
	 * @param e the instance of MouseEvent
	 */
	public void mouseReleased(MouseEvent e)
	{
	}
	
	/**
	 * Fires the mouse entered event.
	 * @param e the instance of MouseEvent
	 */
	public void mouseEntered(MouseEvent e)
	{
	}
	
	/**
	 * Fires the mouse exited event.
	 * @param e the instance of MouseEvent
	 */
	public void mouseExited(MouseEvent e)
	{
	}
	
	/**
	 * Fires the popup menu will become visible event.
	 * @param e the instance of PopupMenuEvent
	 */
	public void popupMenuWillBecomeVisible(PopupMenuEvent e)
	{
		BasicButtonModel buttonModel = (BasicButtonModel) getModel();
		buttonModel.setMenuDropDown(true);
		
		repaint();
	}
	
	/**
	 * Fires the popup menu will become invisible event.
	 * @param e the instance of PopupMenuEvent
	 */
	public void popupMenuWillBecomeInvisible(PopupMenuEvent e)
	{
		BasicButtonModel buttonModel = (BasicButtonModel) getModel();
		buttonModel.setMenuDropDown(false);
		
		repaint();
	}
	
	/**
	 * Fires the popup menu canceled event.
	 * @param e the instance of PopupMenuEvent
	 */
	public void popupMenuCanceled(PopupMenuEvent e)
	{
	}
}