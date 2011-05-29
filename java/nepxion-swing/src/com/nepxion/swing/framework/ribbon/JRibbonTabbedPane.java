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

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.plaf.UIResource;

import com.nepxion.swing.gradient.JGradientPainter;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.icon.paint.CombinatedIcon;
import com.nepxion.swing.label.JBasicLabel;
import com.nepxion.swing.menuitem.JBasicMenuItem;
import com.nepxion.swing.popupmenu.JDecorationPopupMenu;
import com.nepxion.swing.tabbedpane.JEclipseTabbedPane;

public class JRibbonTabbedPane
	extends JEclipseTabbedPane
{
	public JRibbonTabbedPane()
	{
		super();
		
		initComponents();
	}
	
	public JRibbonTabbedPane(int tabPlacement)
	{
		super(tabPlacement);
		
		initComponents();
	}
	
	public JRibbonTabbedPane(int tabPlacement, int tabLayoutPolicy)
	{
		super(tabPlacement, tabLayoutPolicy);
		
		initComponents();
	}
	
	private void initComponents()
	{
		final JDecorationPopupMenu popupMenu = new JDecorationPopupMenu();
		popupMenu.add(new JBasicMenuItem("xxx"));
		popupMenu.add(new JBasicMenuItem("xxx"));
		popupMenu.add(new JBasicMenuItem("xxx"));
		popupMenu.add(new JBasicMenuItem("xxx"));
		popupMenu.add(new JBasicMenuItem("xxx"));
		popupMenu.add(new JBasicMenuItem("xxx"));
		popupMenu.add(new JBasicMenuItem("xxx"));

		final CombinatedIcon logoBackgroundIcon = new CombinatedIcon(IconFactory.getSwingIcon("ribbon/logo.png"), IconFactory.getSwingIcon("ribbon/logo_bg.png"));
		final CombinatedIcon logoBackgroundHoverIcon = new CombinatedIcon(IconFactory.getSwingIcon("ribbon/logo.png"), IconFactory.getSwingIcon("ribbon/logo_bg_hover.png"));
		final CombinatedIcon logoBackgroundSelectedIcon = new CombinatedIcon(IconFactory.getSwingIcon("ribbon/logo.png"), IconFactory.getSwingIcon("ribbon/logo_bg_selected.png"));
		
		final JBasicLabel leadingLabel = new JBasicLabel(logoBackgroundIcon, "Nepxion Studio");
		leadingLabel.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{
				leadingLabel.setIcon(logoBackgroundHoverIcon);
			}
			
			public void mousePressed(MouseEvent e)
			{
				leadingLabel.setIcon(logoBackgroundSelectedIcon);
				
				popupMenu.show(leadingLabel, e.getX(), e.getY());
			}
			
			public void mouseExited(MouseEvent e)
			{
				leadingLabel.setIcon(logoBackgroundIcon);
			}
		}
		);
		
		LeadingPanel leadingPanel = new LeadingPanel();
		leadingPanel.add(leadingLabel, BorderLayout.CENTER);
		
		setTabLeadingComponent(leadingPanel);
		setShowTabBorder(false);
		setTabColorProvider(new ColorProvider()
		{
			public Color getBackgroundAt(int arg0)
			{
				return Color.red;
			}

			public Color getForegroudAt(int arg0)
			{
				return Color.black;
			}

			public float getGradientRatio(int arg0)
			{
				return 0.9F;
			}	
		}
		);
		
		addMouseListener(new MouseAdapter()
		{			
			public void mousePressed(MouseEvent e)
			{
				int x = e.getX();
				int y = e.getY();
				
				if (x > startX && x < endX && y > startY && y < endY)
				{
					backgroundIcon = IconFactory.getSwingIcon("ribbon/button_bg_selected.png");
					paintImmediately(startX, startY, endX - startX, endY - startY);
				}	
			}
		}
		);
		
		addMouseMotionListener(new MouseAdapter()
		{
			public void mouseMoved(MouseEvent e)
			{
				int x = e.getX();
				int y = e.getY();
				
				if (x >= startX && x <= endX && y >= startY && y <= endY)
				{
					backgroundIcon = IconFactory.getSwingIcon("ribbon/button_bg_hover.png");
				}
				else
				{
					backgroundIcon = null;
				}
				
				paintImmediately(startX, startY, endX - startX, endY - startY);
			}
		}
		);
	}
	
	public class LeadingPanel
		extends JPanel implements UIResource
	{
		public LeadingPanel()
		{
			setBorder(BorderFactory.createEmptyBorder(5, 2, 10, 2));
			setLayout(new BorderLayout());
			setOpaque(false);
		}
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
		g2d.setColor(Color.black);
		g2d.setFont(new Font("Dialog", Font.PLAIN, 12));
		
		String title = "Nepxion Swing";
		
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

		// g2d.setColor(new Color(105, 112, 121));
		g2d.drawString(title, x, y);
	}
	
	private void paintButtonBar(Graphics2D g2d)
	{
		int x = 47;
		int y = 4;
		
		startX = x;
		startY = y;
		
		int buttonWidth = 22;
		int buttonCount = 3;
		
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
		
		x += 1;
		y += 1;
		for (int i = 0; i < buttonCount; i++)
		{
			ImageIcon foregroundIcon = IconFactory.getSwingIcon("alarm.png");
			if (backgroundIcon != null)
			{	
				g2d.drawImage(backgroundIcon.getImage(), x, y, null);
			}
			g2d.drawImage(foregroundIcon.getImage(), x + 22 / 2 - foregroundIcon.getIconWidth() / 2, y + 22 / 2 - foregroundIcon.getIconHeight() / 2, null);
			
			x += buttonWidth;
		}
		
		endX = x;
		endY = y + 22;
	}
	
	int startX = -1;
	int startY = -1;
	int endX = -1;
	int endY = -1;
	
	ImageIcon backgroundIcon = null;
}