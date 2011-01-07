package com.nepxion.swing.textcomponent;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.text.JTextComponent;

import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.keystroke.KeyStrokeManager;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.menuitem.JBasicMenuItem;
import com.nepxion.swing.popupmenu.JDecorationPopupMenu;

public class PopupMenuAdapter
	implements MouseListener
{
	private JTextComponent textComponent;
	
	private JBasicMenuItem copyMenuItem;
	private JBasicMenuItem pasteMenuItem;
	private JBasicMenuItem cutMenuItem;
	private JBasicMenuItem clearMenuItem;
	private JBasicMenuItem selectAllMenuItem;
	private JDecorationPopupMenu popupMenu;
	
	public PopupMenuAdapter(final JTextComponent textComponent)
	{
		this.textComponent = textComponent;
		this.textComponent.addMouseListener(this);
		
		popupMenu = new JDecorationPopupMenu();
		
		copyMenuItem = new JBasicMenuItem(SwingLocale.getString("copy"), IconFactory.getSwingIcon("copy.png"), SwingLocale.getString("copy"));
		KeyStrokeManager.registerButton(copyMenuItem, KeyEvent.VK_C, KeyEvent.CTRL_MASK, 'C');
		copyMenuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				textComponent.copy();
			}
		}
		);
		popupMenu.add(copyMenuItem);
		
		pasteMenuItem = new JBasicMenuItem(SwingLocale.getString("paste"), IconFactory.getSwingIcon("paste.png"), SwingLocale.getString("paste"));
		KeyStrokeManager.registerButton(pasteMenuItem, KeyEvent.VK_V, KeyEvent.CTRL_MASK, 'V');
		pasteMenuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				textComponent.paste();
			}
		}
		);
		popupMenu.add(pasteMenuItem);
		
		cutMenuItem = new JBasicMenuItem(SwingLocale.getString("cut"), IconFactory.getSwingIcon("cut.png"), SwingLocale.getString("cut"));
		KeyStrokeManager.registerButton(cutMenuItem, KeyEvent.VK_X, KeyEvent.CTRL_MASK, 'X');
		cutMenuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				textComponent.cut();
			}
		}
		);
		popupMenu.add(cutMenuItem);
		
		clearMenuItem = new JBasicMenuItem(SwingLocale.getString("clean"), IconFactory.getSwingIcon("clear.png"), SwingLocale.getString("clear"));
		ActionListener clearActionListener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				textComponent.setText("");
			}
		};
		clearMenuItem.addActionListener(clearActionListener);
		KeyStrokeManager.registerComponent(textComponent, clearActionListener, KeyEvent.VK_R, KeyEvent.CTRL_MASK);
		KeyStrokeManager.registerButton(clearMenuItem, KeyEvent.VK_R, KeyEvent.CTRL_MASK, 'R');
		popupMenu.add(clearMenuItem);
		
		selectAllMenuItem = new JBasicMenuItem(SwingLocale.getString("select_all"), IconFactory.getSwingIcon("select_all.png"), SwingLocale.getString("select_all"));
		KeyStrokeManager.registerButton(selectAllMenuItem, KeyEvent.VK_A, KeyEvent.CTRL_MASK, 'A');
		selectAllMenuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				textComponent.requestFocusInWindow();
				textComponent.selectAll();
			}
		}
		);
		popupMenu.add(selectAllMenuItem);
	}
	
	private boolean hasContent()
	{
		boolean hasContent = false;
		Clipboard clipboard = textComponent.getToolkit().getSystemClipboard();
		Transferable content = clipboard.getContents(textComponent);
		
		try
		{
			hasContent = content.getTransferData(DataFlavor.stringFlavor) instanceof String;
		}
		catch (UnsupportedFlavorException e)
		{
			
		}
		catch (IOException e)
		{
			
		}
		
		return hasContent;
	}
	
	private boolean canCopy()
	{
		return textComponent.getSelectionStart() != textComponent.getSelectionEnd();
	}
	
	private boolean canDelete()
	{
		return !textComponent.getText().equals("");
	}
	
	public JDecorationPopupMenu getPopupMenu()
	{
		return popupMenu;
	}
	
	public JBasicMenuItem getCutMenuItem()
	{
		return cutMenuItem;
	}
	
	public JBasicMenuItem getCopyMenuItem()
	{
		return copyMenuItem;
	}
	
	public JBasicMenuItem getPasteMenuItem()
	{
		return pasteMenuItem;
	}
	
	public JBasicMenuItem getClearMenuItem()
	{
		return clearMenuItem;
	}
	
	public JBasicMenuItem getSelectAllMenuItem()
	{
		return selectAllMenuItem;
	}
	
	public void mouseReleased(MouseEvent e)
	{
		if (!e.isPopupTrigger())
		{
			return;
		}
		
		if (!textComponent.isEnabled())
		{
			return;
		}
		
		if (textComponent.isEditable())
		{
			copyMenuItem.setEnabled(canCopy());
			pasteMenuItem.setEnabled(hasContent());
			cutMenuItem.setEnabled(canCopy());
			clearMenuItem.setEnabled(canDelete());
		}
		else
		{
			copyMenuItem.setEnabled(canCopy());
			pasteMenuItem.setEnabled(false);
			cutMenuItem.setEnabled(false);
			clearMenuItem.setEnabled(false);
		}
		
		popupMenu.show(e.getComponent(), e.getX(), e.getY());
	}
	
	public void mouseClicked(MouseEvent e)
	{
	}
	
	public void mouseEntered(MouseEvent e)
	{
	}
	
	public void mouseExited(MouseEvent e)
	{
	}
	
	public void mousePressed(MouseEvent e)
	{
	}
}