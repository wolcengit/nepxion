package com.nepxion.swing.framework.dockable;

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
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import com.nepxion.swing.button.ButtonManager;
import com.nepxion.swing.button.JBasicButton;
import com.nepxion.swing.fullscreen.FullScreenConstants;
import com.nepxion.swing.menuitem.JBasicMenuItem;
import com.nepxion.swing.panel.decoration.JDecorationHeader;
import com.nepxion.swing.panel.decoration.JDecorationPanel;
import com.nepxion.swing.popupmenu.JDecorationPopupMenu;
import com.nepxion.swing.style.framework.IStyle;
import com.nepxion.swing.style.framework.StyleManager;

public class JDockableView
	extends JDecorationPanel
{
	private boolean isMaximize = false;
	private boolean isClosable = true;
	private boolean isMaximizable = true;
	
	private ToolBar toolBar;
	private JPopupMenu popupMenu;
	
	private JDockable dockable;
	private JDockableContainer dockableContainer;
	private int dockIndex;
	
	private Object constraints;
	
	private AbstractButton foreignButton;
	
	public JDockableView()
	{
		this("");
	}
	
	public JDockableView(String title)
	{
		this(title, null, true, null, (IStyle) StyleManager.getStyle());
	}
	
	public JDockableView(String title, boolean isSelected)
	{
		this(title, null, isSelected, null, (IStyle) StyleManager.getStyle());
	}
	
	public JDockableView(String title, IStyle style)
	{
		this(title, null, true, null, style);
	}
	
	public JDockableView(String title, boolean isSelected, IStyle style)
	{
		this(title, null, isSelected, null, style);
	}
	
	public JDockableView(Icon icon)
	{
		this("", icon, true, null, (IStyle) StyleManager.getStyle());
	}
	
	public JDockableView(Icon icon, boolean isSelected)
	{
		this("", icon, isSelected, null, (IStyle) StyleManager.getStyle());
	}
	
	public JDockableView(Icon icon, IStyle style)
	{
		this("", icon, true, null, style);
	}
	
	public JDockableView(Icon icon, boolean isSelected, IStyle style)
	{
		this("", icon, isSelected, null, style);
	}
	
	public JDockableView(String title, Icon icon)
	{
		this(title, icon, true, null, (IStyle) StyleManager.getStyle());
	}
	
	public JDockableView(String title, Icon icon, boolean isSelected)
	{
		this(title, icon, isSelected, null, (IStyle) StyleManager.getStyle());
	}
	
	public JDockableView(String title, Icon icon, IStyle style)
	{
		this(title, icon, true, null, style);
	}
	
	public JDockableView(String title, Icon icon, boolean isSelected, IStyle style)
	{
		this(title, icon, isSelected, null, style);
	}
	
	public JDockableView(String title, Icon icon, JComponent content)
	{
		this(title, icon, true, content, (IStyle) StyleManager.getStyle());
	}
	
	public JDockableView(String title, Icon icon, JComponent content, IStyle style)
	{
		this(title, icon, true, content, style);
	}
	
	public JDockableView(String title, Icon icon, boolean isSelected, JComponent content)
	{
		this(title, icon, isSelected, content, (IStyle) StyleManager.getStyle());
	}
	
	public JDockableView(String title, Icon icon, boolean isSelected, JComponent content, IStyle style)
	{
		super(title, icon, isSelected, content, style);
		
		initComponents();
	}
	
	private void initComponents()
	{
		JDecorationHeader header = getHeader();
		
		toolBar = new ToolBar();
		popupMenu = new PopupMenu();
		
		header.add(toolBar, BorderLayout.EAST);
		header.addMouseListener(new MaximizeAndRestoreMouseListener());
	}
	
	private void initDock()
	{
		if (dockable == null)
		{
			dockable = DockableManager.getDockable(this);
		}
		
		if (dockableContainer == null)
		{
			dockableContainer = DockableManager.getDockableContainer(this);
		}
	}
	
	protected void restoreToMaximize()
	{
		initDock();
		dockIndex = dockable.indexOfPane(this);
		if (dockableContainer != null)
		{
			dockableContainer.dock(this);
		}
	}
	
	protected void maximizeToRestore()
	{
		initDock();
		if (dockableContainer != null)
		{
			dockableContainer.dock(null);
		}
		if (dockable != null)
		{
			if (constraints != null)
			{
				dockable.insertPane(this, constraints, dockIndex);
			}
			else
			{
				dockable.insertPane(this, dockIndex);
			}
		}
	}
	
	private void toggleMaximize()
	{
		String text = null;
		Icon icon = null;
		if (isMaximize)
		{
			maximizeToRestore();
			text = FullScreenConstants.TEXT_MAXIMIZE;
			icon = FullScreenConstants.ICON_MAXIMIZE;
		}
		else
		{
			restoreToMaximize();
			text = FullScreenConstants.TEXT_RESTORE;
			icon = FullScreenConstants.ICON_MAXIMIZE_RESTORE;
		}
		isMaximize = !isMaximize;
		
		JBasicButton maximizeButton = toolBar.getMaximizeButton();
		maximizeButton.setIcon(icon);
		maximizeButton.setToolTipText(text);
		if (isClosable)
		{
			toolBar.getCloseButton().setVisible(!isMaximize);
		}
		
		JPopupMenu popupMenu = getPopupMenu();
		if (popupMenu instanceof PopupMenu)
		{
			JBasicMenuItem maximizeMenuItem = ((PopupMenu) popupMenu).getMaximizeMenuItem();
			maximizeMenuItem.setText(text);
			maximizeMenuItem.setIcon(icon);
			maximizeMenuItem.setToolTipText(text);
			if (isClosable)
			{
				((PopupMenu) popupMenu).getCloseMenuItem().setVisible(!isMaximize);
			}
		}
	}
	
	public void registerForeignButton(AbstractButton foreignButton)
	{
		this.foreignButton = foreignButton;
	}
	
	public boolean isClosable()
	{
		return isClosable;
	}
	
	public void setClosable(boolean isClosable)
	{
		this.isClosable = isClosable;
		toolBar.getCloseButton().setVisible(isClosable);
		if (popupMenu instanceof PopupMenu)
		{
			((PopupMenu) popupMenu).getCloseMenuItem().setVisible(false);
		}
	}
	
	public boolean isMaximizable()
	{
		return isMaximizable;
	}
	
	public void setMaximizable(boolean isMaximizable)
	{
		this.isMaximizable = isMaximizable;
		toolBar.getMaximizeButton().setVisible(isMaximizable);
		if (popupMenu instanceof PopupMenu)
		{
			((PopupMenu) popupMenu).getMaximizeMenuItem().setVisible(false);
		}
	}
	
	public Object getConstraints()
	{
		return constraints;
	}
	
	public void setConstraints(Object constraints)
	{
		this.constraints = constraints;
	}
	
	public ToolBar getToolBar()
	{
		return toolBar;
	}
	
	public void setPopupMenu(JPopupMenu popupMenu)
	{
		this.popupMenu = popupMenu;
	}
	
	public JPopupMenu getPopupMenu()
	{
		return popupMenu;
	}
	
	public class PopupMenu
		extends JDecorationPopupMenu
	{
		private JBasicMenuItem maximizeMenuItem;
		private JBasicMenuItem closeMenuItem;
		
		public PopupMenu()
		{
			maximizeMenuItem = FullScreenConstants.createMaximizeMenuItem();
			maximizeMenuItem.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					toggleMaximize();
				}
			}
			);
			add(maximizeMenuItem);
			
			closeMenuItem = FullScreenConstants.createCloseMenuItem();
			closeMenuItem.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					JDockableView.this.setVisible(false);
					if (foreignButton != null)
					{
						foreignButton.setSelected(false);
					}
				}
			}
			);
			add(closeMenuItem);
		}
		
		public JBasicMenuItem getMaximizeMenuItem()
		{
			return maximizeMenuItem;
		}
		
		public JBasicMenuItem getCloseMenuItem()
		{
			return closeMenuItem;
		}
	}
	
	public class ToolBar
		extends JPanel
	{
		private JBasicButton maximizeButton;
		private JBasicButton closeButton;
		
		public ToolBar()
		{
			maximizeButton = FullScreenConstants.createMaximizeButton(false);
			maximizeButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					toggleMaximize();
				}
			}
			);
			add(maximizeButton);
			
			closeButton = FullScreenConstants.createCloseButton(false);
			closeButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					JDockableView.this.setVisible(false);
					if (foreignButton != null)
					{
						foreignButton.setSelected(false);
					}
				}
			}
			);
			add(closeButton);
			
			add(Box.createHorizontalStrut(1));
			
			ButtonManager.updateUI(this, new Dimension(20, 20), true);
			
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setOpaque(false);
		}
		
		public JBasicButton getMaximizeButton()
		{
			return maximizeButton;
		}
		
		public JBasicButton getCloseButton()
		{
			return closeButton;
		}
	}
	
	public class MaximizeAndRestoreMouseListener
		extends MouseAdapter
	{
		public void mouseClicked(MouseEvent e)
		{
			if (!isMaximizable)
			{
				return;
			}
			if (isMaximizable && e.getClickCount() > 1)
			{
				toggleMaximize();
			}
		}
		
		public void mouseReleased(MouseEvent e)
		{
			if (!isMaximizable && !isClosable)
			{
				return;
			}
			if (popupMenu != null)
			{
				if (!e.isPopupTrigger())
				{
					return;
				}
				
				popupMenu.show(e.getComponent(), e.getX(), e.getY());
			}
		}
	}
}