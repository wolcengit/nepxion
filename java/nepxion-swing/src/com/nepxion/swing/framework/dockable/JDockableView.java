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
import com.nepxion.swing.fullscreen.FullScreenManager;
import com.nepxion.swing.menuitem.JBasicMenuItem;
import com.nepxion.swing.panel.decoration.JDecorationHeader;
import com.nepxion.swing.panel.decoration.JDecorationPanel;
import com.nepxion.swing.popupmenu.JDecorationPopupMenu;
import com.nepxion.swing.style.framework.IStyle;
import com.nepxion.swing.style.framework.StyleManager;

public class JDockableView
	extends JDecorationPanel implements FullScreenConstants
{
	/**
	 * The boolean value of isMaximized.
	 */
	private boolean isMaximized = false;
	
	/**
	 * The boolean value of isClosable.
	 */
	private boolean isClosable = true;
	
	/**
	 * The boolean value of isMaximizable.
	 */
	private boolean isMaximizable = true;
	
	/**
	 * The instance of ToolBar.
	 */
	private ToolBar toolBar;
	
	/**
	 * The instance of JPopupMenu.
	 */
	private JPopupMenu popupMenu;
	
	/**
	 * The instance of JDockable.
	 */
	private JDockable dockable;
	
	/**
	 * The instance of JDockableContainer.
	 */
	private JDockableContainer dockableContainer;
	
	/**
	 * The dock index value.
	 */
	private int dockIndex;
	
	/**
	 * The constraints value.
	 */
	private Object constraints;
	
	/**
	 * The foreign button.
	 */
	private AbstractButton foreignButton;
	
	/**
	 * Constructs with the default.
	 */
	public JDockableView()
	{
		this("");
	}
	
	/**
	 * Constructs with the specified initial title.
	 * @param title the title string
	 */
	public JDockableView(String title)
	{
		this(title, null, true, null, (IStyle) StyleManager.getStyle());
	}
	
	/**
	 * Constructs with the specified initial title and selected.
	 * @param title the title string
	 * @param selected the boolean value of selected
	 */
	public JDockableView(String title, boolean selected)
	{
		this(title, null, selected, null, (IStyle) StyleManager.getStyle());
	}
	
	/**
	 * Constructs with the specified initial title and style.
	 * @param title the title string
	 * @param style the instance of IStyle
	 */
	public JDockableView(String title, IStyle style)
	{
		this(title, null, true, null, style);
	}
	
	/**
	 * Constructs with the specified initial title, selected and style.
	 * @param title the title string 
	 * @param selected the boolean value of selected
	 * @param style the instance of IStyle
	 */
	public JDockableView(String title, boolean selected, IStyle style)
	{
		this(title, null, selected, null, style);
	}
	
	/**
	 * Constructs with the specified initial icon.
	 * @param icon the instance of Icon
	 */
	public JDockableView(Icon icon)
	{
		this("", icon, true, null, (IStyle) StyleManager.getStyle());
	}
	
	/**
	 * Constructs with the specified initial icon and selected.
	 * @param icon the instance of Icon
	 * @param selected the boolean value of selected
	 */
	public JDockableView(Icon icon, boolean selected)
	{
		this("", icon, selected, null, (IStyle) StyleManager.getStyle());
	}
	
	/**
	 * Constructs with the specified initial icon and style.
	 * @param icon the instance of Icon
	 * @param style the instance of IStyle
	 */
	public JDockableView(Icon icon, IStyle style)
	{
		this("", icon, true, null, style);
	}
	
	/**
	 * Constructs with the specified initial icon, selected and style.
	 * @param icon the instance of Icon
	 * @param selected the boolean value of selected
	 * @param style the instance of IStyle
	 */
	public JDockableView(Icon icon, boolean selected, IStyle style)
	{
		this("", icon, selected, null, style);
	}
	
	/**
	 * Constructs with the specified initial title and icon.
	 * @param title the title string
	 * @param icon the instance of Icon
	 */
	public JDockableView(String title, Icon icon)
	{
		this(title, icon, true, null, (IStyle) StyleManager.getStyle());
	}
	
	/**
	 * Constructs with the specified initial title, icon and selected.
	 * @param title the title string
	 * @param icon the instance of Icon
	 * @param selected the boolean value of selected
	 */
	public JDockableView(String title, Icon icon, boolean selected)
	{
		this(title, icon, selected, null, (IStyle) StyleManager.getStyle());
	}
	
	/**
	 * Constructs with the specified initial title, icon and style.
	 * @param title the title string
	 * @param icon the instance of Icon
	 * @param style the instance of IStyle
	 */
	public JDockableView(String title, Icon icon, IStyle style)
	{
		this(title, icon, true, null, style);
	}
	
	/**
	 * Constructs with the specified initial title, icon, selected and style.
	 * @param title the title string
	 * @param icon the instance of Icon
	 * @param selected the boolean value of selected
	 * @param style the instance of IStyle
	 */
	public JDockableView(String title, Icon icon, boolean selected, IStyle style)
	{
		this(title, icon, selected, null, style);
	}
	
	/**
	 * Constructs with the specified initial title, icon and content.
	 * @param title the title string
	 * @param icon the instance of Icon
	 * @param content the instance of JComponent
	 */
	public JDockableView(String title, Icon icon, JComponent content)
	{
		this(title, icon, true, content, (IStyle) StyleManager.getStyle());
	}
	
	/**
	 * Constructs with the specified initial title, icon, content and style.
	 * @param title the title string
	 * @param icon the instance of Icon
	 * @param content the instance of JComponent
	 * @param style the instance of IStyle
	 */
	public JDockableView(String title, Icon icon, JComponent content, IStyle style)
	{
		this(title, icon, true, content, style);
	}
	
	/**
	 * Constructs with the specified initial title, icon, selected and content.
	 * @param title the title string
	 * @param icon the instance of Icon
	 * @param selected the boolean value of selected
	 * @param content the instance of JComponent
	 */
	public JDockableView(String title, Icon icon, boolean selected, JComponent content)
	{
		this(title, icon, selected, content, (IStyle) StyleManager.getStyle());
	}
	
	/**
	 * Constructs with the specified initial title, icon, selected, content and style.
	 * @param title the title string
	 * @param icon the instance of Icon
	 * @param selected the boolean value of selected
	 * @param content the instance of JComponent
	 * @param style the instance of IStyle
	 */
	public JDockableView(String title, Icon icon, boolean selected, JComponent content, IStyle style)
	{
		super(title, icon, selected, content, style);
		
		initComponents();
	}
	
	/**
	 * Initializes the components.
	 */
	private void initComponents()
	{
		JDecorationHeader header = getHeader();
		
		toolBar = new ToolBar();
		popupMenu = new PopupMenu();
		
		header.add(toolBar, BorderLayout.EAST);
		header.addMouseListener(new MaximizeAndRestoreMouseListener());
	}
	
	/**
	 * Initializes the dock.
	 */
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
	
	/**
	 * Restores to the maximize layout.
	 */
	protected void restoreToMaximize()
	{
		initDock();
		dockIndex = dockable.indexOfPane(this);
		if (dockableContainer != null)
		{
			dockableContainer.dock(this);
		}
	}
	
	/**
	 * Maximizes to the restore layout.
	 */
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
	
	/**
	 * Toggles to the maximum layout.
	 */
	private void toggleMaximum()
	{
		String text = null;
		Icon icon = null;
		if (isMaximized)
		{
			maximizeToRestore();
			text = TEXT_MAXIMIZE;
			icon = ICON_MAXIMIZE;
		}
		else
		{
			restoreToMaximize();
			text = TEXT_RESTORE;
			icon = ICON_MAXIMIZE_RESTORE;
		}
		isMaximized = !isMaximized;
		
		JBasicButton maximizeButton = toolBar.getMaximizeButton();
		maximizeButton.setIcon(icon);
		maximizeButton.setToolTipText(text);
		if (isClosable)
		{
			toolBar.getCloseButton().setVisible(!isMaximized);
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
				((PopupMenu) popupMenu).getCloseMenuItem().setVisible(!isMaximized);
			}
		}
	}
	
	/**
	 * Registers the foreign button.
	 * @param foreignButton the instance of AbstractButton
	 */
	public void registerForeignButton(AbstractButton foreignButton)
	{
		this.foreignButton = foreignButton;
	}
	
	/**
	 * Returns true if it is closable.
	 * @return true if it is closable
	 */
	public boolean isClosable()
	{
		return isClosable;
	}
	
	/**
	 * Sets the closable.
	 * @param isClosable the boolean value of isClosable
	 */
	public void setClosable(boolean isClosable)
	{
		this.isClosable = isClosable;
		
		toolBar.getCloseButton().setVisible(isClosable);
		if (popupMenu instanceof PopupMenu)
		{
			((PopupMenu) popupMenu).getCloseMenuItem().setVisible(false);
		}
	}
	
	/**
	 * Returns true if it is maximizable.
	 * @return true if it is maximizable
	 */
	public boolean isMaximizable()
	{
		return isMaximizable;
	}
	
	/**
	 * Sets the maximizable.
	 * @param isMaximizable the boolean value of isMaximizable
	 */
	public void setMaximizable(boolean isMaximizable)
	{
		this.isMaximizable = isMaximizable;
		
		toolBar.getMaximizeButton().setVisible(isMaximizable);
		if (popupMenu instanceof PopupMenu)
		{
			((PopupMenu) popupMenu).getMaximizeMenuItem().setVisible(false);
		}
	}
	
	/**
	 * Gets the constraints.
	 * @return the constraints value
	 */
	public Object getConstraints()
	{
		return constraints;
	}
	
	/**
	 * Sets the constraints.
	 * @param constraints the constraints value.
	 */
	public void setConstraints(Object constraints)
	{
		this.constraints = constraints;
	}
	
	/**
	 * Gets the tool bar.
	 * @return the instance of ToolBar
	 */
	public ToolBar getToolBar()
	{
		return toolBar;
	}
	
	/**
	 * Sets the popup menu.
	 * @param popupMenu the instance of JPopupMenu
	 */
	public void setPopupMenu(JPopupMenu popupMenu)
	{
		this.popupMenu = popupMenu;
	}
	
	/**
	 * Gets the popup menu.
	 * @return the instance of JPopupMenu
	 */
	public JPopupMenu getPopupMenu()
	{
		return popupMenu;
	}
	
	public class PopupMenu
		extends JDecorationPopupMenu
	{
		/**
		 * The maximize menu item.
		 */
		private JBasicMenuItem maximizeMenuItem;
		
		/**
		 * The close menu item.
		 */
		private JBasicMenuItem closeMenuItem;
		
		/**
		 * Constructs with the default.
		 */
		public PopupMenu()
		{
			maximizeMenuItem = FullScreenManager.createMaximizeMenuItem();
			maximizeMenuItem.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					toggleMaximum();
				}
			}
			);
			add(maximizeMenuItem);
			
			closeMenuItem = FullScreenManager.createCloseMenuItem();
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
		
		/**
		 * Gets the maximize menu item.
		 * @return the instance of JBasicMenuItem
		 */
		public JBasicMenuItem getMaximizeMenuItem()
		{
			return maximizeMenuItem;
		}
		
		/**
		 * Gets the close menu item.
		 * @return the instance of JBasicMenuItem
		 */
		public JBasicMenuItem getCloseMenuItem()
		{
			return closeMenuItem;
		}
	}
	
	public class ToolBar
		extends JPanel
	{
		/**
		 * The maximize button.
		 */
		private JBasicButton maximizeButton;
		
		/**
		 * The close button.
		 */
		private JBasicButton closeButton;
		
		/**
		 * Constructs with the default.
		 */
		public ToolBar()
		{
			maximizeButton = FullScreenManager.createMaximizeButton(false);
			maximizeButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					toggleMaximum();
				}
			}
			);
			add(maximizeButton);
			
			closeButton = FullScreenManager.createCloseButton(false);
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
		
		/**
		 * Gets the maximize button.
		 * @return the instance of JBasicButton
		 */
		public JBasicButton getMaximizeButton()
		{
			return maximizeButton;
		}
		
		/**
		 * Gets the close button.
		 * @return the instance of JBasicButton
		 */
		public JBasicButton getCloseButton()
		{
			return closeButton;
		}
	}
	
	public class MaximizeAndRestoreMouseListener
		extends MouseAdapter
	{
		/**
		 * Invoked when the mouse button has been clicked (pressed and released) on a component.
		 * @param e the instance of MouseEvent
		 */
		public void mouseClicked(MouseEvent e)
		{
			if (!isMaximizable)
			{
				return;
			}
			if (isMaximizable && e.getClickCount() > 1)
			{
				toggleMaximum();
			}
		}
		
		/**
		 * Invoked when the mouse button has been pressed on a component.
		 * @param e the instance of MouseEvent
		 */
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