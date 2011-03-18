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

import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Action;
import javax.swing.ButtonModel;
import javax.swing.Icon;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

public class JClassicMenuButton
	extends JClassicButton implements MouseListener, PopupMenuListener
{
	protected JPopupMenu popupMenu;
	
	public JClassicMenuButton()
	{
		super();
		
		initComponents();
	}
	
	public JClassicMenuButton(Action action)
	{
		super(action);
		
		initComponents();
	}
	
	public JClassicMenuButton(String text)
	{
		super(text);
		
		initComponents();
	}
	
	public JClassicMenuButton(Icon icon)
	{
		super(icon);
		
		initComponents();
	}
	
	public JClassicMenuButton(Icon icon, String toolTipText)
	{
		super(icon);
		
		initComponents();
		
		setToolTipText(toolTipText);
	}
	
	public JClassicMenuButton(String text, String toolTipText)
	{
		super(text);
		
		initComponents();
		
		setToolTipText(toolTipText);
	}
	
	public JClassicMenuButton(String text, Icon icon)
	{
		super(text, icon);
		
		initComponents();
	}
	
	public JClassicMenuButton(String text, Icon icon, String toolTipText)
	{
		super(text, icon);
		
		initComponents();
		
		setToolTipText(toolTipText);
	}
	
	private void initComponents()
	{		
		setMargin(new Insets(0, 0, 0, 5));
		
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
		ButtonModel buttonModel = getModel();
		if (!buttonModel.isEnabled())
		{
			return;
		}
		
		if (SwingUtilities.isLeftMouseButton(e))
		{
			if (popupMenu != null)
			{
				popupMenu.show(this, 2, getSize().height - 2);
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

	}
	
	public void popupMenuWillBecomeInvisible(PopupMenuEvent e)
	{

	}
	
	public void popupMenuCanceled(PopupMenuEvent e)
	{
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		
		ButtonModel buttonModel = getModel();
		if (!buttonModel.isEnabled())
		{
			g.setColor(UIManager.getColor("controlShadow"));
		}
		
		g.drawLine(getWidth() - 6 - 5, getHeight() / 2 - 1, getWidth() - 6 - 1, getHeight() / 2 - 1);
		g.drawLine(getWidth() - 6 - 4, getHeight() / 2, getWidth() - 6 - 2, getHeight() / 2);
		g.drawLine(getWidth() - 6 - 3, getHeight() / 2 + 1, getWidth() - 6 - 3, getHeight() / 2 + 1);
	}
}