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
import java.awt.Component;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JPanel;
import javax.swing.plaf.UIResource;

import com.nepxion.swing.gradient.JGradientPainter;
import com.nepxion.swing.icon.IconFactory;
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
		setShowTabBorder(false);
		
		final JDecorationPopupMenu popupMenu = new JDecorationPopupMenu();
		popupMenu.add(new JBasicMenuItem("xxx"));
		popupMenu.add(new JBasicMenuItem("xxx"));
		popupMenu.add(new JBasicMenuItem("xxx"));
		popupMenu.add(new JBasicMenuItem("xxx"));
		popupMenu.add(new JBasicMenuItem("xxx"));
		popupMenu.add(new JBasicMenuItem("xxx"));
		popupMenu.add(new JBasicMenuItem("xxx"));
		
		final RibbonIcon buttonIcon = new RibbonIcon(IconFactory.getSwingIcon("ribbon_button.png"));
		final RibbonIcon buttonHoverIcon = new RibbonIcon(IconFactory.getSwingIcon("ribbon_button_hover.png"));
		final RibbonIcon buttonSelectedIcon = new RibbonIcon(IconFactory.getSwingIcon("ribbon_button_selected.png"));
		
		final JBasicLabel leadingLabel = new JBasicLabel(buttonIcon, "Nepxion Studio");
		leadingLabel.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{
				leadingLabel.setIcon(buttonHoverIcon);
			}
			
			public void mousePressed(MouseEvent e)
			{
				leadingLabel.setIcon(buttonSelectedIcon);
				
				popupMenu.show(leadingLabel, e.getX(), e.getY());
			}
			
			public void mouseExited(MouseEvent e)
			{
				leadingLabel.setIcon(buttonIcon);
			}
		}
		);
		
		LeadingPanel leadingPanel = new LeadingPanel();
		leadingPanel.add(leadingLabel, BorderLayout.CENTER);
		
		setTabLeadingComponent(leadingPanel);
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
	
	public class RibbonIcon
		implements Icon
	{
		private Icon logoIcon;
		private Icon buttonIcon;
		
		public RibbonIcon(Icon buttonIcon)
		{
			this.buttonIcon = buttonIcon;
			
			logoIcon = IconFactory.getSwingIcon("ribbon_logo.png");
		}
		
		public void paintIcon(Component c, Graphics g, int x, int y)
		{
			buttonIcon.paintIcon(c, g, x, y);
			logoIcon.paintIcon(c, g, x + getIconWidth() / 2 - logoIcon.getIconWidth() / 2, y + getIconHeight() / 2 - logoIcon.getIconHeight() / 2);
		}
		
		public int getIconWidth()
		{
			return buttonIcon.getIconWidth();
		}
		
		public int getIconHeight()
		{
			return buttonIcon.getIconHeight();
		}
	}
	
	public void paintComponent(Graphics g)
	{			
		Graphics2D g2d = (Graphics2D) g;
		Color color = g2d.getColor();
		Font font = g2d.getFont();
		
		JGradientPainter.fastFill(g2d, new Rectangle(0, 1, getWidth(), 4), new Color(226, 235, 244), new Color(220, 234, 236), true);
		JGradientPainter.fastFill(g2d, new Rectangle(0, 5, getWidth(), 4), new Color(213, 229, 250), new Color(216, 231, 250), true);
		JGradientPainter.fastFill(g2d, new Rectangle(0, 9, getWidth(), 19), new Color(202, 222, 247), new Color(227, 239, 253), true);
		JGradientPainter.fastFill(g2d, new Rectangle(0, 28, getWidth(), 1), new Color(219, 244, 254), new Color(219, 244, 254), true);
		JGradientPainter.fastFill(g2d, new Rectangle(0, 29, getWidth(), 1), new Color(176, 207, 247), new Color(176, 207, 247), true);
		JGradientPainter.fastFill(g2d, new Rectangle(0, 30, getWidth(), 1), new Color(219, 232, 249), new Color(219, 232, 249), true);
		JGradientPainter.fastFill(g2d, new Rectangle(0, 31, getWidth(), 23), new Color(191, 219, 255), new Color(186, 215, 253), true);
		
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
		
		g2d.setColor(color);
		g2d.setFont(font);
		
		super.paintComponent(g);
	}
}