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

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.AbstractButton;

public class FullScreenRegister
	extends MouseAdapter implements ActionListener
{
	private FullScreenSupport fullScreenSupport;
	private List buttons;
	
	public FullScreenRegister(FullScreenSupport fullScreenSupport)
	{
		this.fullScreenSupport = fullScreenSupport;
		buttons = new ArrayList();
	}
	
	public void register(Component component)
	{
		if (component != null)
		{
			component.addMouseListener(this);
		}
	}
	
	public void register(AbstractButton button)
	{
		if (button != null)
		{
			button.addActionListener(this);
			buttons.add(button);
		}
	}
	
	public void toggleFullScreen()
	{
		for (Iterator iterator = buttons.iterator(); iterator.hasNext();)
		{
			AbstractButton button = (AbstractButton) iterator.next();
			adaptButtonUI(button);
		}
		fullScreenSupport.toggleFullScreen();
	}

	private void adaptButtonUI(AbstractButton button)
	{
		/*String text = null;
		Icon icon = null;*/
		boolean selected = false;

		if (fullScreenSupport.isFullScreen())
		{
			/*text = FullScreenConstants.TEXT_MAXIMIZE;
			icon = FullScreenConstants.ICON_MAXIMIZE;*/
			selected = false;
		}
		else
		{
			/*text = FullScreenConstants.TEXT_RESTORE;
			icon = FullScreenConstants.ICON_MAXIMIZE_RESTORE;*/
			selected = true;
		}
		/*if (!button.getText().equals(""))
		{
			button.setText(text);
		}
		if (button.getIcon() != null)
		{
			button.setIcon(icon);
		}
		button.setToolTipText(text);*/
		button.setSelected(selected);
	}
    
	public void mouseClicked(MouseEvent e)
	{
		if (e.getClickCount() > 1)
		{
			toggleFullScreen();
		}
	}
	
	public void actionPerformed(ActionEvent e)
	{
		toggleFullScreen();
	}
}