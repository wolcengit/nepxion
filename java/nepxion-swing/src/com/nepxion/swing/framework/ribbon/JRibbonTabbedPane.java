package com.nepxion.swing.framework.ribbon;

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
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import javax.swing.plaf.UIResource;

import com.nepxion.swing.action.JAction;
import com.nepxion.swing.container.ContainerManager;
import com.nepxion.swing.framework.ribbon.action.JRibbonAction;
import com.nepxion.swing.gradient.JGradientPainter;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.icon.paint.CombinationIcon;
import com.nepxion.swing.label.JBasicLabel;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.menu.JBasicMenu;
import com.nepxion.swing.menuitem.JBasicCheckBoxMenuItem;
import com.nepxion.swing.menuitem.JBasicMenuItem;
import com.nepxion.swing.popupmenu.JDecorationPopupMenu;
import com.nepxion.swing.tabbedpane.JEclipseTabbedPane;
import com.nepxion.swing.tabbedpane.TabbedPaneManager;

public class JRibbonTabbedPane
	extends JEclipseTabbedPane
{
	/**
	 * The button style of plain.
	 */
	public static final int BUTTON_STYLE_PLAIN = 0;
	
	/**
	 * The button style of hover.
	 */
	public static final int BUTTON_STYLE_HOVER = 1;
	
	/**
	 * The button style of selected.
	 */
	public static final int BUTTON_STYLE_SELECTED = 2;
	
	/**
	 * The button style string.
	 */
	public static final String BUTTON_STYLE = "buttonStyle";
		
	/**
	 * The title string.
	 */
	private String title = "";
	
	/**
	 * The title font.
	 */
	private Font titleFont = new Font("Dialog", Font.PLAIN, 12);
	
	/**
	 * The title color.
	 */
	private Color titleColor = Color.black;
	
	/**
	 * The navigator icon.
	 */
	private Icon navigatorIcon = IconFactory.getSwingIcon("ribbon/navigator.png");
		
	/**
	 * The navigator background icon.
	 */
	private Icon navigatorBackgroundIcon = IconFactory.getSwingIcon("ribbon/navigator_bg.png");
	
	/**
	 * The navigator background hover icon.
	 */
	private Icon navigatorBackgroundHoverIcon = IconFactory.getSwingIcon("ribbon/navigator_bg_hover.png");

	/**
	 * The navigator background selected icon.
	 */
	private Icon navigatorBackgroundSelectedIcon = IconFactory.getSwingIcon("ribbon/navigator_bg_selected.png");
	
	/**
	 * The navigator combination icon.
	 */
	private CombinationIcon navigatorCombinationIcon = new CombinationIcon(navigatorIcon, navigatorBackgroundIcon);
	
	/**
	 * The navigator tooltip text string.
	 */
	private String navigatorToolTipText = "";
	
	/**
	 * The navigator popup menu.
	 */
	private JPopupMenu navigatorPopupMenu;
	
	/**
	 * The navigator label.
	 */
	private JBasicLabel navigatorLabel;
		
	/**
	 * The toggle text button group.
	 */
	private ButtonGroup toggleTextButtonGroup;
	
	/**
	 * The toggle icon button group.
	 */
	private ButtonGroup toggleIconButtonGroup;
	
	/**
	 * The tab leading component.
	 */
	private TabComponent tabLeadingComponent;
	
	/**
	 * The tab trailing component. 
	 */
	private TabComponent tabTrailingComponent;
	
	/**
	 * The shortcut action list.
	 */
	private List shortcutActionList = new ArrayList();
	
	/**
	 * The boolean value of isMinimum.
	 */
	private boolean isMinimum = false;
	
	/**
	 * The ribbon hierarchy.
	 */
	private JRibbonHierarchy ribbonHierarchy;
	
	/**
	 * 
	 * @param ribbonHierarchy
	 */
	public JRibbonTabbedPane(JRibbonHierarchy ribbonHierarchy)
	{
		this.ribbonHierarchy = ribbonHierarchy;
		
		initNavigator();
		initPopupMenu();
		initListener();
		initStyle();
		
		ribbonHierarchy.getNavigatorContainer().add(this);
	}

	private void initNavigator()
	{
		navigatorLabel = new JBasicLabel(navigatorCombinationIcon, navigatorToolTipText);
		navigatorLabel.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{
				CombinationIcon combinationIcon = (CombinationIcon) navigatorLabel.getIcon();
				combinationIcon.setLargeIcon(navigatorBackgroundHoverIcon);
				
				navigatorLabel.repaint();
			}
			
			public void mousePressed(MouseEvent e)
			{
				CombinationIcon combinationIcon = (CombinationIcon) navigatorLabel.getIcon();
				combinationIcon.setLargeIcon(navigatorBackgroundSelectedIcon);
				
				navigatorLabel.repaint();
				
				if (navigatorPopupMenu != null)
				{
					navigatorPopupMenu.show(navigatorLabel, 0, navigatorLabel.getHeight());
				}
			}
			
			public void mouseExited(MouseEvent e)
			{
				CombinationIcon combinationIcon = (CombinationIcon) navigatorLabel.getIcon();
				combinationIcon.setLargeIcon(navigatorBackgroundIcon);
				
				navigatorLabel.repaint();
			}
		}
		);
		
		tabLeadingComponent = new TabComponent();
		tabLeadingComponent.setBorder(BorderFactory.createEmptyBorder(5, 2, 10, 2));
		tabLeadingComponent.add(navigatorLabel, BorderLayout.CENTER);
		setTabLeadingComponent(tabLeadingComponent);
		
		tabTrailingComponent = new TabComponent();
		setTabTrailingComponent(tabTrailingComponent);
	}
	
	private void initPopupMenu()
	{
		navigatorPopupMenu = new JDecorationPopupMenu();
		
		JBasicMenu navigatorBarFacadeConfigMenu = new JBasicMenu(SwingLocale.getString("config_navigatorbar_facade"), IconFactory.getSwingIcon("facade.png"), SwingLocale.getString("config_navigatorbar_facade"));
		toggleTextButtonGroup = new ButtonGroup();
		
		JBasicCheckBoxMenuItem toggleLargTextMenuItem = new JBasicCheckBoxMenuItem(new ToggleFacadeAction(SwingLocale.getString("config_navigatorbar_show_large_text"), IconFactory.getSwingIcon("component/label_16.png"), SwingLocale.getString("config_navigatorbar_show_large_text"), JRibbonAction.TEXT, JRibbonAction.SHOW_LARGE));
		navigatorBarFacadeConfigMenu.add(toggleLargTextMenuItem);
		toggleTextButtonGroup.add(toggleLargTextMenuItem);
		
		JBasicCheckBoxMenuItem toggleSmallTextMenuItem = new JBasicCheckBoxMenuItem(new ToggleFacadeAction(SwingLocale.getString("config_navigatorbar_show_small_text"), IconFactory.getSwingIcon("component/label_multi_16.png"), SwingLocale.getString("config_navigatorbar_show_small_text"), JRibbonAction.TEXT, JRibbonAction.SHOW_SMALL));
		navigatorBarFacadeConfigMenu.add(toggleSmallTextMenuItem);
		toggleTextButtonGroup.add(toggleSmallTextMenuItem);
		
		JBasicCheckBoxMenuItem toggleNoTextMenuItem = new JBasicCheckBoxMenuItem(new ToggleFacadeAction(SwingLocale.getString("config_navigatorbar_show_no_text"), IconFactory.getBlankIcon(), SwingLocale.getString("config_navigatorbar_show_no_text"), JRibbonAction.TEXT, JRibbonAction.SHOW_NO));
		navigatorBarFacadeConfigMenu.add(toggleNoTextMenuItem);
		toggleTextButtonGroup.add(toggleNoTextMenuItem);
		
		navigatorBarFacadeConfigMenu.addSeparator();
		
		toggleIconButtonGroup = new ButtonGroup();
		
		JBasicCheckBoxMenuItem toggleLargIconMenuItem = new JBasicCheckBoxMenuItem(new ToggleFacadeAction(SwingLocale.getString("config_navigatorbar_show_large_icon"), IconFactory.getSwingIcon("rectangle_single.png"), SwingLocale.getString("config_navigatorbar_show_large_icon"), JRibbonAction.ICON, JRibbonAction.SHOW_LARGE));
		navigatorBarFacadeConfigMenu.add(toggleLargIconMenuItem);
		toggleIconButtonGroup.add(toggleLargIconMenuItem);
		
		JBasicCheckBoxMenuItem toggleSmallIconMenuItem = new JBasicCheckBoxMenuItem(new ToggleFacadeAction(SwingLocale.getString("config_navigatorbar_show_small_icon"), IconFactory.getSwingIcon("rectangle_multi.png"), SwingLocale.getString("config_navigatorbar_show_small_icon"), JRibbonAction.ICON, JRibbonAction.SHOW_SMALL));
		navigatorBarFacadeConfigMenu.add(toggleSmallIconMenuItem);
		toggleIconButtonGroup.add(toggleSmallIconMenuItem);
		
		JBasicCheckBoxMenuItem toggleNoIconMenuItem = new JBasicCheckBoxMenuItem(new ToggleFacadeAction(SwingLocale.getString("config_navigatorbar_show_no_icon"), IconFactory.getBlankIcon(), SwingLocale.getString("config_navigatorbar_show_no_icon"), JRibbonAction.ICON, JRibbonAction.SHOW_NO));
		navigatorBarFacadeConfigMenu.add(toggleNoIconMenuItem);
		toggleIconButtonGroup.add(toggleNoIconMenuItem);
		
		navigatorPopupMenu.add(navigatorBarFacadeConfigMenu);
		
		JBasicMenuItem toggleHeightMenuItem = new JBasicMenuItem(new ToggleHeightAction());
		navigatorPopupMenu.add(toggleHeightMenuItem);
	}
	
	private void initListener()
	{
		addMouseListener(new MouseAdapter()
		{
			public void mousePressed(MouseEvent e)
			{
				JAction shortcutAction = getShortcutAction(e);
				
				paintShortcutBar(e, shortcutAction, BUTTON_STYLE_SELECTED);
				
				if (shortcutAction != null)
				{
					shortcutAction.actionPerformed(null);
				}
			}
			
			public void mouseReleased(MouseEvent e)
			{
				JAction shortcutAction = getShortcutAction(e);
				
				paintShortcutBar(e, shortcutAction, BUTTON_STYLE_HOVER);
			}
			
			public void mouseExited(MouseEvent e)
			{
				paintShortcutBar(e, null, BUTTON_STYLE_PLAIN);
			}
			
			public void mouseClicked(MouseEvent e)
			{
				int index = indexAtLocation(e.getX(), e.getY());
				if (index < 0)
				{
					return;
				}
				
				if (SwingUtilities.isLeftMouseButton(e) && e.getClickCount() > 1)
				{
					toggleHeight();
				}
			}
		}
		);
		addMouseMotionListener(new MouseAdapter()
		{
			public void mouseMoved(MouseEvent e)
			{
				JAction shortcutAction = getShortcutAction(e);
				if (shortcutAction != null)
				{
					paintShortcutBar(e, shortcutAction, BUTTON_STYLE_HOVER);
				}
				else
				{
					paintShortcutBar(e, null, BUTTON_STYLE_PLAIN);
				}
			}
		}
		);
	}
	
	private void initStyle()
	{
		setShowTabBorder(false);
		setTabGradientColor(new Color(255, 239, 191)); // Color.white
		setTabBackground(new Color(231, 239, 248));
		setTabForeground(Color.black);
		setTabSelectionForeground(Color.black);
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public void setTitle(String title)
	{
		this.title = title;
		
		repaint();
	}
	
	public Font getTitleFont()
	{
		return titleFont;
	}
	
	public void setTitleFont(Font titleFont)
	{
		this.titleFont = titleFont;
		
		repaint();
	}
	
	public Color getTitleColor()
	{
		return titleColor;
	}
	
	public void setTitleColor(Color titleColor)
	{
		this.titleColor = titleColor;
		
		repaint();
	}
	
	public Icon getNavigatorIcon()
	{
		return navigatorIcon;
	}
	
	public void setNavigatorIcon(Icon navigatorIcon)
	{
		this.navigatorIcon = navigatorIcon;
		
		CombinationIcon combinationIcon = (CombinationIcon) navigatorLabel.getIcon();
		combinationIcon.setSmallIcon(navigatorIcon);
		
		navigatorLabel.repaint();
	}
	
	public String getNavigatorToolTipText()
	{
		return navigatorToolTipText;
	}
	
	public void setNavigatorToolTipText(String navigatorToolTipText)
	{
		this.navigatorToolTipText = navigatorToolTipText;
		
		navigatorLabel.setToolTipText(navigatorToolTipText);
	}
	
	public JPopupMenu getNavigatorPopupMenu()
	{
		return navigatorPopupMenu;
	}
	
	public void setNavigatorPopupMenu(JPopupMenu navigatorPopupMenu)
	{
		this.navigatorPopupMenu = navigatorPopupMenu;
	}
	
	public void setRibbonTrailingComponent(JComponent ribbonTrailingComponent)
	{
		int gap = 54 - ribbonTrailingComponent.getPreferredSize().height;
		tabTrailingComponent.setBorder(BorderFactory.createEmptyBorder(gap / 2, 0, gap / 2, 0));
		tabTrailingComponent.add(ribbonTrailingComponent, BorderLayout.CENTER);
	}
	
	public List getShortcutActionList()
	{
		return shortcutActionList;
	}
	
	public void setShortcutActionList(List shortcutActionList)
	{
		this.shortcutActionList = shortcutActionList;
		
		repaint();
	}
	
	public void addShortcutAction(JAction shortcutAction)
	{
		shortcutActionList.add(shortcutAction);
		
		repaint();
	}
	
	public void addShortcutAction(int index, JAction shortcutAction)
	{
		shortcutActionList.add(index, shortcutAction);
		
		repaint();
	}
	
	public void addShortcutActions(List shortcutActions)
	{
		shortcutActionList.addAll(shortcutActions);
		
		repaint();
	}
	
	public void addShortcutActions(int index, List shortcutActions)
	{
		shortcutActionList.addAll(index, shortcutActions);
		
		repaint();
	}
	
	public void removeShortcutAction(JAction shortcutAction)
	{
		shortcutActionList.remove(shortcutAction);
		
		repaint();
	}
	
	public void removeShortcutAction(int index)
	{
		shortcutActionList.remove(index);
		
		repaint();
	}
	
	public void removeShortcutActions(List shortcutActions)
	{
		shortcutActionList.removeAll(shortcutActions);
		
		repaint();
	}
	
	public JAction getShortcutAction(MouseEvent e)
	{
		if (shortcutActionList == null || shortcutActionList.isEmpty())
		{
			return null;
		}
		
		int x = e.getX();
		int y = e.getY();
		
		for (Iterator iterator = shortcutActionList.iterator(); iterator.hasNext();)
		{
			JAction shortcutAction = (JAction) iterator.next();
			
			int startX = ((Integer) shortcutAction.getValue("startX")).intValue();
			int startY = ((Integer) shortcutAction.getValue("startY")).intValue();
			
			int endX = ((Integer) shortcutAction.getValue("endX")).intValue();
			int endY = ((Integer) shortcutAction.getValue("endY")).intValue();
			
			if (x >= startX && x <= endX && y >= startY && y <= endY)
			{
				return shortcutAction;
			}
		}
		
		return null;
	}
	
	public JRibbonHierarchy getRibbonHierarchy()
	{
		return ribbonHierarchy;
	}
	
	public void setRibbonHierarchy(JRibbonHierarchy ribbonHierarchy)
	{
		this.ribbonHierarchy = ribbonHierarchy;
	}
	
	public JRibbonContainer getRibbonContainer()
	{
		return ribbonHierarchy.getRibbonContainer();
	}
	
	/**
	 * Toggles the height for the navigator bar.
	 * It will show or hide the tabbed pane content.
	 */
	public void toggleHeight()
	{
		int tabHeight = TabbedPaneManager.getTabHeight(this);
		int contentHeight = TabbedPaneManager.getMaxPreferredContentHeight(this);
		
		if (isMinimum)
		{
			setPreferredSize(new Dimension(getSize().width, tabHeight + contentHeight));
		}
		else
		{
			setPreferredSize(new Dimension(getSize().width, tabHeight));
		}
		
		ContainerManager.update(this);
		
		isMinimum = !isMinimum;
	}
	
	public void toggleFacade(int textShowValue, int iconShowValue)
	{
		for (Enumeration enumeration = toggleTextButtonGroup.getElements(); enumeration.hasMoreElements();)
		{
			AbstractButton button = (AbstractButton) enumeration.nextElement();
			ToggleFacadeAction action = (ToggleFacadeAction) button.getAction();
			if (action.getShowValue() == textShowValue)
			{
				button.doClick();
				
				break;
			}
		}
		
		for (Enumeration enumeration = toggleIconButtonGroup.getElements(); enumeration.hasMoreElements();)
		{
			AbstractButton button = (AbstractButton) enumeration.nextElement();
			ToggleFacadeAction action = (ToggleFacadeAction) button.getAction();
			if (action.getShowValue() == iconShowValue)
			{
				button.doClick();
				
				break;
			}
		}
	}
	
	/**
	 * Toggles the facade by a show type and show value.
	 * The show type values are "text" and "icon".
	 * The show value values are SHOW_SMALL, SHOW_LARGE and SHOW_NO. (See JAction definition).
	 * For example, if the showType is "icon" and the showValue is SHOW_LARGE, the component will display the icon as a large style.
	 * @param showType the show type
	 * @param showValue the show value
	 */
	public void toggleFacade(String showType, int showValue)
	{
		for (int i = 0; i < getTabCount(); i++)
		{
			JRibbonBar ribbonBar = (JRibbonBar) getComponentAt(i);
			ribbonBar.toggleFacade(showType, showValue);
		}
		
		ContainerManager.update(this);
	}
	
	private void paintShortcutBar(MouseEvent e, JAction shortcutAction, int buttonStyle)
	{
		if (shortcutActionList == null || shortcutActionList.isEmpty())
		{
			return;
		}
		
		for (Iterator iterator = shortcutActionList.iterator(); iterator.hasNext();)
		{
			JAction action = (JAction) iterator.next();
			switch (buttonStyle)
			{
				case BUTTON_STYLE_PLAIN :
				{
					action.putValue(BUTTON_STYLE, Integer.valueOf(BUTTON_STYLE_PLAIN));
					break;
				}
				case BUTTON_STYLE_HOVER :
				{
					if (action == shortcutAction)
					{
						action.putValue(BUTTON_STYLE, Integer.valueOf(BUTTON_STYLE_HOVER));
					}
					else
					{
						action.putValue(BUTTON_STYLE, Integer.valueOf(BUTTON_STYLE_PLAIN));
					}
					break;
				}
				case BUTTON_STYLE_SELECTED :
				{
					if (action == shortcutAction)
					{
						action.putValue(BUTTON_STYLE, Integer.valueOf(BUTTON_STYLE_SELECTED));
					}
					else
					{
						action.putValue(BUTTON_STYLE, Integer.valueOf(BUTTON_STYLE_PLAIN));
					}
					break;
				}
			}
		}
		
		JAction firstShortcutAction = (JAction) shortcutActionList.get(0);
		JAction lastShortcutAction = (JAction) shortcutActionList.get(shortcutActionList.size() - 1);
		
		int startX = ((Integer) firstShortcutAction.getValue("startX")).intValue();
		int startY = ((Integer) firstShortcutAction.getValue("startY")).intValue();
		
		int endX = ((Integer) lastShortcutAction.getValue("endX")).intValue();
		int endY = ((Integer) lastShortcutAction.getValue("endY")).intValue();
		
		paintImmediately(startX, startY, endX - startX, endY - startY);
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;
		Color color = g2d.getColor();
		Font font = g2d.getFont();
		
		paintBackground(g2d);
		paintTitle(g2d);
		paintButtonBar(g2d);
		
		g2d.setColor(color);
		g2d.setFont(font);
		
		super.paintComponent(g);
	}
	
	private void paintBackground(Graphics2D g2d)
	{
		int width = getWidth();
		
		JGradientPainter.fastFill(g2d, new Rectangle(0, 1, width, 4), new Color(226, 235, 244), new Color(220, 234, 236), true);
		JGradientPainter.fastFill(g2d, new Rectangle(0, 5, width, 4), new Color(213, 229, 250), new Color(216, 231, 250), true);
		JGradientPainter.fastFill(g2d, new Rectangle(0, 9, width, 19), new Color(202, 222, 247), new Color(227, 239, 253), true);
		JGradientPainter.fastFill(g2d, new Rectangle(0, 28, width, 1), new Color(219, 244, 254), new Color(219, 244, 254), true);
		JGradientPainter.fastFill(g2d, new Rectangle(0, 29, width, 1), new Color(176, 207, 247), new Color(176, 207, 247), true);
		JGradientPainter.fastFill(g2d, new Rectangle(0, 30, width, 1), new Color(219, 232, 249), new Color(219, 232, 249), true);
		JGradientPainter.fastFill(g2d, new Rectangle(0, 31, width, 23), new Color(191, 219, 255), new Color(186, 215, 253), true);
	}
	
	private void paintTitle(Graphics2D g2d)
	{
		g2d.setColor(titleColor);
		g2d.setFont(titleFont);
		
		int width = getWidth();
		int height = 28;
		
		FontMetrics fontMetrics = g2d.getFontMetrics();
		int fontWidth = fontMetrics.stringWidth(title);
		int fontHeight = fontMetrics.getHeight();
		
		int x = (width - fontWidth > 0 ? (width - fontWidth) / 2 : 0);
		int y = height / 2 + fontHeight / 2 - 4;
		
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		// g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
		g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
		g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
		
		g2d.drawString(title, x, y);
	}
	
	private void paintButtonBar(Graphics2D g2d)
	{
		int x = 47;
		int y = 4;
		
		int buttonWidth = 22;
		int buttonCount = (shortcutActionList != null ? shortcutActionList.size() : 0);
		
		int width = buttonWidth * buttonCount + 1;
		
		g2d.drawImage(IconFactory.getSwingIcon("ribbon/toolbar_bg_left.png").getImage(), x - 14, y, null);
		g2d.drawImage(IconFactory.getSwingIcon("ribbon/toolbar_bg_right.png").getImage(), x + width, y, null);
		
		JGradientPainter.fastFill(g2d, new Rectangle(x, y, width, 1), new Color(246, 249, 252), new Color(240, 245, 252), false);
		JGradientPainter.fastFill(g2d, new Rectangle(x, y + 1, width, 1), new Color(186, 204, 226), new Color(191, 208, 229), false);
		JGradientPainter.fastFill(g2d, new Rectangle(x, y + 2, width, 1), new Color(222, 231, 244), new Color(216, 227, 241), false);
		JGradientPainter.fastFill(g2d, new Rectangle(x, y + 3, width, 1), new Color(230, 238, 249), new Color(230, 238, 249), false);
		JGradientPainter.fastFill(g2d, new Rectangle(x, y + 4, width, 1), new Color(219, 231, 247), new Color(219, 231, 247), false);
		JGradientPainter.fastFill(g2d, new Rectangle(x, y + 5, width, 1), new Color(216, 229, 245), new Color(216, 229, 245), false);
		JGradientPainter.fastFill(g2d, new Rectangle(x, y + 6, width, 1), new Color(213, 226, 244), new Color(213, 226, 244), false);
		JGradientPainter.fastFill(g2d, new Rectangle(x, y + 7, width, 1), new Color(210, 224, 242), new Color(210, 224, 242), false);
		JGradientPainter.fastFill(g2d, new Rectangle(x, y + 8, width, 1), new Color(206, 222, 241), new Color(206, 222, 241), false);
		JGradientPainter.fastFill(g2d, new Rectangle(x, y + 9, width, 1), new Color(204, 220, 239), new Color(204, 220, 239), false);
		JGradientPainter.fastFill(g2d, new Rectangle(x, y + 10, width, 1), new Color(202, 218, 238), new Color(202, 218, 238), false);
		JGradientPainter.fastFill(g2d, new Rectangle(x, y + 11, width, 1), new Color(200, 216, 238), new Color(200, 216, 238), false);
		JGradientPainter.fastFill(g2d, new Rectangle(x, y + 12, width, 1), new Color(199, 215, 237), new Color(199, 215, 237), false);
		JGradientPainter.fastFill(g2d, new Rectangle(x, y + 13, width, 1), new Color(196, 214, 237), new Color(196, 214, 237), false);
		JGradientPainter.fastFill(g2d, new Rectangle(x, y + 14, width, 1), new Color(196, 214, 236), new Color(196, 214, 236), false);
		JGradientPainter.fastFill(g2d, new Rectangle(x, y + 15, width, 1), new Color(195, 213, 236), new Color(195, 213, 236), false);
		JGradientPainter.fastFill(g2d, new Rectangle(x, y + 16, width, 1), new Color(196, 214, 237), new Color(196, 214, 237), false);
		JGradientPainter.fastFill(g2d, new Rectangle(x, y + 17, width, 1), new Color(196, 213, 237), new Color(196, 213, 237), false);
		JGradientPainter.fastFill(g2d, new Rectangle(x, y + 18, width, 1), new Color(197, 214, 237), new Color(197, 214, 237), false);
		JGradientPainter.fastFill(g2d, new Rectangle(x, y + 19, width, 1), new Color(199, 215, 237), new Color(199, 215, 237), false);
		JGradientPainter.fastFill(g2d, new Rectangle(x, y + 20, width, 1), new Color(201, 216, 238), new Color(201, 216, 238), false);
		JGradientPainter.fastFill(g2d, new Rectangle(x, y + 21, width, 1), new Color(201, 217, 238), new Color(197, 214, 235), false);
		JGradientPainter.fastFill(g2d, new Rectangle(x, y + 22, width, 1), new Color(154, 179, 213), new Color(162, 185, 217), false);
		
		if (buttonCount > 0)
		{
			x += 1;
			y += 1;
			
			for (Iterator iterator = shortcutActionList.iterator(); iterator.hasNext();)
			{
				JAction shortcutAction = (JAction) iterator.next();
				
				Integer buttonStyle = (Integer) shortcutAction.getValue(BUTTON_STYLE);
				if (buttonStyle != null)
				{
					switch (buttonStyle.intValue())
					{
						case BUTTON_STYLE_PLAIN :
						{
							break;
						}
						case BUTTON_STYLE_HOVER :
						{
							g2d.drawImage(IconFactory.getSwingIcon("ribbon/button_bg_hover.png").getImage(), x, y, null);
							break;
						}
						case BUTTON_STYLE_SELECTED :
						{
							g2d.drawImage(IconFactory.getSwingIcon("ribbon/button_bg_selected.png").getImage(), x, y, null);
							break;
						}
					}
				}
				
				Icon shortcutIcon = shortcutAction.getIcon();
				if (shortcutIcon instanceof ImageIcon)
				{
					ImageIcon shortcutImageIcon = (ImageIcon) shortcutIcon;
					g2d.drawImage(shortcutImageIcon.getImage(), x + 22 / 2 - shortcutIcon.getIconWidth() / 2, y + 22 / 2 - shortcutIcon.getIconHeight() / 2, null);
				}
				
				shortcutAction.putValue("startX", Integer.valueOf(x));
				shortcutAction.putValue("startY", Integer.valueOf(y));
				
				x += buttonWidth;
				
				shortcutAction.putValue("endX", Integer.valueOf(x));
				shortcutAction.putValue("endY", Integer.valueOf(y + 22));
			}
		}
	}
	
	public class ToggleHeightAction
		extends JAction
	{
		public ToggleHeightAction()
		{
			super(SwingLocale.getString("toggle_navigatorbar_visibility"), IconFactory.getSwingIcon("toggle_size.png"), SwingLocale.getString("toggle_navigatorbar_visibility"));
		}
		
		/**
		 * Invoked when an action occurs.
		 * @param e the instance of ActionEvent
		 */
		public void actionPerformed(ActionEvent e)
		{
			toggleHeight();
		}
	}
	
	public class ToggleFacadeAction
		extends JAction
	{
		/**
		 * The show type.
		 */
		private String showType;
		
		/**
		 * The show value.
		 */
		private int showValue;
		
		/**
		 * Constructs with the specified initial text, icon, tooltip text, ribbon navigator bar, show type and show value.
		 * @param text the text string
		 * @param icon the instance of Icon
		 * @param toolTipText the tooltip text string
		 * @param ribbonNavigatorBar the instance of JRibbonNavigatorBar
		 * @param showType the show type
		 * @param showValue the show value
		 */
		public ToggleFacadeAction(String text, Icon icon, String toolTipText, String showType, int showValue)
		{
			super(text, icon, toolTipText);
			
			this.showType = showType;
			this.showValue = showValue;
		}
		
		public String getShowType()
		{
			return showType;
		}
		
		public void setShowType(String showType)
		{
			this.showType = showType;
		}
		
		public int getShowValue()
		{
			return showValue;
		}
		
		public void setShowValue(int showValue)
		{
			this.showValue = showValue;
		}
		
		/**
		 * Invoked when an action occurs.
		 * @param e the instance of ActionEvent
		 */
		public void actionPerformed(ActionEvent e)
		{
			toggleFacade(showType, showValue);
		}
	}
	
	public class TabComponent
		extends JPanel implements UIResource
	{
		public TabComponent()
		{
			setLayout(new BorderLayout());
			setOpaque(false);
		}
	}
}