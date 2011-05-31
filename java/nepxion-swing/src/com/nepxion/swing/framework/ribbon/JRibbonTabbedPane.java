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
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.plaf.UIResource;

import com.nepxion.swing.action.JAction;
import com.nepxion.swing.gradient.JGradientPainter;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.icon.paint.CombinatedIcon;
import com.nepxion.swing.label.JBasicLabel;
import com.nepxion.swing.tabbedpane.JEclipseTabbedPane;

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
	 * The navigator icon.
	 */
	private Icon navigatorIcon = IconFactory.getSwingIcon("ribbon/navigator.png");
	
	/**
	 * The navigator background icon.
	 */
	private CombinatedIcon navigatorBackgroundIcon = new CombinatedIcon(navigatorIcon, IconFactory.getSwingIcon("ribbon/navigator_bg.png"));
	
	/**
	 * The navigator background hover icon.
	 */
	private CombinatedIcon navigatorBackgroundHoverIcon = new CombinatedIcon(navigatorIcon, IconFactory.getSwingIcon("ribbon/navigator_bg_hover.png"));

	/**
	 * The navigator background selected icon.
	 */
	private CombinatedIcon navigatorBackgroundSelectedIcon = new CombinatedIcon(navigatorIcon, IconFactory.getSwingIcon("ribbon/navigator_bg_selected.png"));

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
	 * The popup menu of navigator.
	 */
	private JPopupMenu popupMenu;
	
	/**
	 * The action list of tool bar.
	 */
	private List actionList = new ArrayList();
	
	public JRibbonTabbedPane()
	{		
		initStyle();
		initNavigator();
		initToolBar();
	}
	
	private void initStyle()
	{
		setShowTabBorder(false);
		setTabGradientColor(new Color(255, 239, 191)); // Color.white
		setTabBackground(new Color(231, 239, 248));
		setTabForeground(Color.black);
		setTabSelectionForeground(Color.black);
	}
	
	private void initNavigator()
	{		
		final JBasicLabel navigatorLabel = new JBasicLabel(navigatorBackgroundIcon, "Nepxion Studio");
		navigatorLabel.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{
				navigatorLabel.setIcon(navigatorBackgroundHoverIcon);
			}
			
			public void mousePressed(MouseEvent e)
			{
				navigatorLabel.setIcon(navigatorBackgroundSelectedIcon);
				
				if (popupMenu != null)
				{	
					popupMenu.show(navigatorLabel, 0, navigatorLabel.getHeight());
				}
			}
			
			public void mouseExited(MouseEvent e)
			{
				navigatorLabel.setIcon(navigatorBackgroundIcon);
			}
		}
		);
		
		NavigatorPanel navigatorPanel = new NavigatorPanel();
		navigatorPanel.add(navigatorLabel, BorderLayout.CENTER);
		setTabLeadingComponent(navigatorPanel);
	}
	
	private void initToolBar()
	{
		addMouseListener(new MouseAdapter()
		{			
			public void mousePressed(MouseEvent e)
			{			
				JAction action = getAction(e);
				
				paintToolBar(e, action, BUTTON_STYLE_SELECTED);
				
				if (action != null)
				{
					action.actionPerformed(null);
				}
			}
			
			public void mouseReleased(MouseEvent e)
			{
				JAction action = getAction(e);
				
				paintToolBar(e, action, BUTTON_STYLE_HOVER);
			}
			
			public void mouseExited(MouseEvent e)
			{							
				paintToolBar(e, null, BUTTON_STYLE_PLAIN);
			}
		}
		);
		addMouseMotionListener(new MouseAdapter()
		{
			public void mouseMoved(MouseEvent e)
			{
				JAction action = getAction(e);
				if (action != null)
				{
					paintToolBar(e, action, BUTTON_STYLE_HOVER);
				}
				else
				{
					paintToolBar(e, null, BUTTON_STYLE_PLAIN);
				}
			}
		}
		);
	}
	
	private JAction getAction(MouseEvent e)
	{
		if (actionList == null || actionList.isEmpty())
		{
			return null;
		}
		
		int x = e.getX();
		int y = e.getY();
		
		for (Iterator iterator = actionList.iterator(); iterator.hasNext();)
		{
			JAction action = (JAction) iterator.next();
			
			int startX = ((Integer) action.getValue("startX")).intValue();
			int startY = ((Integer) action.getValue("startY")).intValue();
			
			int endX = ((Integer) action.getValue("endX")).intValue();
			int endY = ((Integer) action.getValue("endY")).intValue();
			
			if (x >= startX && x <= endX && y >= startY && y <= endY)
			{
				return action;
			}	
		}	
		
		return null;
	}
		
	private void paintToolBar(MouseEvent e, JAction action, int buttonStyle)
	{
		if (actionList == null || actionList.isEmpty())
		{
			return;
		}
				
		for (Iterator iterator = actionList.iterator(); iterator.hasNext();)
		{
			JAction a = (JAction) iterator.next();
			switch (buttonStyle)
			{
				case BUTTON_STYLE_PLAIN :
				{
					a.putValue(BUTTON_STYLE, Integer.valueOf(BUTTON_STYLE_PLAIN));
					break;
				}
				case BUTTON_STYLE_HOVER :
				{
					if (a == action)
					{	
						a.putValue(BUTTON_STYLE, Integer.valueOf(BUTTON_STYLE_HOVER));
					}
					else
					{
						a.putValue(BUTTON_STYLE, Integer.valueOf(BUTTON_STYLE_PLAIN));
					}
					break;
				}	
				case BUTTON_STYLE_SELECTED :
				{
					if (a == action)
					{	
						a.putValue(BUTTON_STYLE, Integer.valueOf(BUTTON_STYLE_SELECTED));
					}
					else
					{
						a.putValue(BUTTON_STYLE, Integer.valueOf(BUTTON_STYLE_PLAIN));
					}
					break;
				}
			}
		}
		
		JAction firstAction = (JAction) actionList.get(0);
		JAction lastAction = (JAction) actionList.get(actionList.size() - 1);
		
		int startX  = ((Integer) firstAction.getValue("startX")).intValue();
		int startY = ((Integer) firstAction.getValue("startY")).intValue();
		
		int endX = ((Integer) lastAction.getValue("endX")).intValue();
		int endY = ((Integer) lastAction.getValue("endY")).intValue();
		
		paintImmediately(startX, startY, endX - startX, endY - startY);
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
	
	public JPopupMenu getPopupMenu()
	{
		return popupMenu;
	}
	
	public void setPopupMenu(JPopupMenu popupMenu)
	{
		this.popupMenu = popupMenu;
	}
	
	public List getActionList()
	{
		return actionList;
	}
	
	public void setActionList(List actionList)
	{
		this.actionList = actionList;
		
		repaint();
	}
	
	public void addAction(JAction action)
	{
		actionList.add(action);
		
		repaint();
	}
	
	public void addAction(int index, JAction action)
	{
		actionList.add(index, action);
		
		repaint();
	}
	
	public void addActions(List actions)
	{
		actionList.addAll(actions);
		
		repaint();
	}
	
	public void addActions(int index, List actions)
	{
		actionList.addAll(index, actions);
		
		repaint();
	}
	
	public void removeAction(JAction action)
	{
		actionList.remove(action);
		
		repaint();
	}
	
	public void removeAction(int index)
	{
		actionList.remove(index);
		
		repaint();
	}
	
	public void removeActions(List actions)
	{
		actionList.removeAll(actions);
		
		repaint();
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
		int buttonCount = (actionList != null ? actionList.size() : 0);
		
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
			
			for (Iterator iterator = actionList.iterator(); iterator.hasNext();)
			{
				JAction action = (JAction) iterator.next();
				
				Integer buttonStyle = (Integer) action.getValue(BUTTON_STYLE);
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
				
				Icon actionIcon = action.getIcon();
				if (actionIcon instanceof ImageIcon)
				{
					ImageIcon actionImageIcon = (ImageIcon) actionIcon;
					g2d.drawImage(actionImageIcon.getImage(), x + 22 / 2 - actionIcon.getIconWidth() / 2, y + 22 / 2 - actionIcon.getIconHeight() / 2, null);
				}
				
				action.putValue("startX", Integer.valueOf(x));
				action.putValue("startY", Integer.valueOf(y));
				
				x += buttonWidth;
				
				action.putValue("endX", Integer.valueOf(x));
				action.putValue("endY", Integer.valueOf(y + 22));
			}
		}
	}
	
	public class NavigatorPanel
		extends JPanel implements UIResource
	{
		public NavigatorPanel()
		{
			setBorder(BorderFactory.createEmptyBorder(5, 2, 10, 2));
			setLayout(new BorderLayout());
			setOpaque(false);
		}
	}
}