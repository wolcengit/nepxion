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
	protected JPopupMenu popupMenu;
	
	public JBasicMenuButton()
	{
		super();
		
		initComponents();
	}
	
	public JBasicMenuButton(Action action)
	{
		super(action);
		
		initComponents();
	}
	
	public JBasicMenuButton(String text)
	{
		super(text);
		
		initComponents();
	}
	
	public JBasicMenuButton(Icon icon)
	{
		super(icon);
		
		initComponents();
	}
	
	public JBasicMenuButton(Icon icon, String toolTipText)
	{
		super(icon);
		
		initComponents();
		
		setToolTipText(toolTipText);
	}
	
	public JBasicMenuButton(String text, String toolTipText)
	{
		super(text);
		
		initComponents();
		
		setToolTipText(toolTipText);
	}
	
	public JBasicMenuButton(String text, Icon icon)
	{
		super(text, icon);
		
		initComponents();
	}
	
	public JBasicMenuButton(String text, Icon icon, String toolTipText)
	{
		super(text, icon);
		
		initComponents();
		
		setToolTipText(toolTipText);
	}
	
	private void initComponents()
	{
		widthInset += 7;
		
		addMouseListener(this);
	}
	
	public JPopupMenu getPopupMenu()
	{
		return popupMenu;
	}
	
	public void setPopupMenu(JPopupMenu popupMenu)
	{
		this.popupMenu = popupMenu;
		this.popupMenu.addPopupMenuListener(this);
	}
	
	public void mouseClicked(MouseEvent e)
	{
	}
	
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
	
	public void mouseReleased(MouseEvent e)
	{
	}
	
	public void mouseEntered(MouseEvent e)
	{
	}
	
	public void mouseExited(MouseEvent e)
	{
	}
	
	public void popupMenuWillBecomeVisible(PopupMenuEvent e)
	{
		BasicButtonModel buttonModel = (BasicButtonModel) getModel();
		buttonModel.setMenuDropDown(true);
		
		repaint();
	}
	
	public void popupMenuWillBecomeInvisible(PopupMenuEvent e)
	{
		BasicButtonModel buttonModel = (BasicButtonModel) getModel();
		buttonModel.setMenuDropDown(false);
		
		repaint();
	}
	
	public void popupMenuCanceled(PopupMenuEvent e)
	{
	}
}