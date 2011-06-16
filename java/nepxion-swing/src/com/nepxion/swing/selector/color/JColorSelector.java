package com.nepxion.swing.selector.color;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.MenuElement;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import com.nepxion.swing.border.LineBorder;
import com.nepxion.swing.button.ButtonManager;
import com.nepxion.swing.button.JBasicButton;
import com.nepxion.swing.handle.HandleManager;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.icon.paint.ColorIcon;
import com.nepxion.swing.layout.filed.FiledLayout;
import com.nepxion.swing.separator.JBasicSeparator;
import com.nepxion.swing.style.button.lite.JYellowLiteButtonStyle;
import com.nepxion.swing.style.button.lite.LiteButtonUI;

public class JColorSelector
	extends JPanel implements SwingConstants
{	
	public static final int ALL = 0;
	public static final int TOP = 1;
	public static final int CENTER = 2;
	public static final int BOTTOM = 3;

	protected Border selectedBorder = BorderFactory.createCompoundBorder(new LineBorder(new Color(239, 72, 16)), new LineBorder(new Color(255, 226, 148)));
	protected Border hoverBorder = BorderFactory.createCompoundBorder(new LineBorder(new Color(242, 148, 54)), new LineBorder(new Color(255, 226, 148)));

	protected List colorList;
	protected Map colorItemMap;
	
	protected ColorItem selectedColorItem;
	protected Color selectedColor;
	
	public JColorSelector()
	{
		initColors();
		initComponents();
	}
	
	private void initColors()
	{
		colorList = new ArrayList();
		
		colorList.add(new Color(255, 255, 255));
		colorList.add(new Color(0, 0, 0));
		colorList.add(new Color(238, 236, 225));
		colorList.add(new Color(31, 73, 125));
		colorList.add(new Color(79, 129, 189));
		colorList.add(new Color(192, 80, 77));
		colorList.add(new Color(155, 187, 90));
		colorList.add(new Color(128, 100, 162));
		colorList.add(new Color(75, 172, 198));
		colorList.add(new Color(247, 150, 70));
		
		colorList.add(new Color(242, 242, 242));
		colorList.add(new Color(127, 127, 127));
		colorList.add(new Color(221, 217, 195));
		colorList.add(new Color(198, 217, 241));
		colorList.add(new Color(219, 229, 241));
		colorList.add(new Color(242, 219, 219));
		colorList.add(new Color(234, 241, 221));
		colorList.add(new Color(229, 223, 236));
		colorList.add(new Color(218, 238, 243));
		colorList.add(new Color(253, 233, 217));
		
		colorList.add(new Color(217, 217, 217));
		colorList.add(new Color(89, 89, 89));
		colorList.add(new Color(196, 188, 150));
		colorList.add(new Color(141, 179, 226));
		colorList.add(new Color(184, 204, 228));
		colorList.add(new Color(229, 184, 183));
		colorList.add(new Color(214, 227, 188));
		colorList.add(new Color(204, 192, 217));
		colorList.add(new Color(182, 221, 232));
		colorList.add(new Color(251, 212, 180));
		
		colorList.add(new Color(191, 191, 191));
		colorList.add(new Color(64, 64, 64));
		colorList.add(new Color(148, 138, 84));
		colorList.add(new Color(84, 141, 212));
		colorList.add(new Color(149, 179, 215));
		colorList.add(new Color(217, 149, 148));
		colorList.add(new Color(194, 214, 155));
		colorList.add(new Color(178, 161, 199));
		colorList.add(new Color(146, 205, 220));
		colorList.add(new Color(250, 191, 143));
		
		colorList.add(new Color(166, 166, 166));
		colorList.add(new Color(38, 38, 38));
		colorList.add(new Color(74, 68, 42));
		colorList.add(new Color(23, 54, 93));
		colorList.add(new Color(54, 95, 145));
		colorList.add(new Color(148, 54, 52));
		colorList.add(new Color(118, 146, 60));
		colorList.add(new Color(95, 73, 122));
		colorList.add(new Color(49, 132, 155));
		colorList.add(new Color(227, 108, 10));
		
		colorList.add(new Color(128, 128, 128));
		colorList.add(new Color(13, 13, 13));
		colorList.add(new Color(29, 27, 17));
		colorList.add(new Color(15, 36, 62));
		colorList.add(new Color(36, 64, 97));
		colorList.add(new Color(99, 36, 35));
		colorList.add(new Color(79, 98, 40));
		colorList.add(new Color(64, 49, 82));
		colorList.add(new Color(33, 88, 104));
		colorList.add(new Color(152, 72, 6));
		
		colorList.add(new Color(192, 0, 0));
		colorList.add(new Color(255, 0, 0));
		colorList.add(new Color(255, 192, 0));
		colorList.add(new Color(255, 255, 0));
		colorList.add(new Color(146, 208, 80));
		colorList.add(new Color(0, 176, 80));
		colorList.add(new Color(0, 176, 240));
		colorList.add(new Color(0, 112, 192));
		colorList.add(new Color(0, 32, 96));
		colorList.add(new Color(112, 48, 160));
		
		colorItemMap = new LinkedHashMap();
	}
	
	private void initComponents()
	{
		setBorder(BorderFactory.createEmptyBorder(0, 1, 0, 1));
		setBackground(Color.white);
		setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 2));
		
		JPanel themePanel = createThemePanel();
		add(themePanel);
		
		JPanel standardPanel = createStandardPanel();
		add(standardPanel);
		
		JPanel buttonPanel = createButtonPanel();
		add(buttonPanel);
	}
	
	private JPanel createThemePanel()
	{
		JPanel labelPanel = createLabelPanel("主题颜色");
		
		JPanel topPanel = new JPanel();
		topPanel.setBackground(Color.white);
		topPanel.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
		topPanel.setLayout(new GridLayout(1, 10, 4, 0));
		
		for (int i = 0; i < 10; i++)
		{	
			Color color = (Color) colorList.get(i);
			
			int borderStyle = ALL;
			
			ColorItem colorItem = new ColorItem(color, borderStyle);
			topPanel.add(colorItem);
			
			colorItemMap.put(color, colorItem);
		}
		
		JPanel centerPanel = new JPanel();
		centerPanel.setBackground(Color.white);
		centerPanel.setBorder(BorderFactory.createEmptyBorder(2, 2, 0, 2));
		centerPanel.setLayout(new GridLayout(5, 10, 4, 0));
		
		for (int i = 10; i < 60; i++)
		{	
			Color color = (Color) colorList.get(i);
			
			int borderStyle = ALL;

			if (i / 10 == 1)
			{
				borderStyle = TOP;
			}
			else if (i / 10 == 5)
			{
				borderStyle = BOTTOM;
			}
			else
			{
				borderStyle = CENTER;
			}
			
			ColorItem colorItem = new ColorItem(color, borderStyle);
			centerPanel.add(colorItem);
			
			colorItemMap.put(color, colorItem);
		}
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.white);
		panel.setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 0));
		panel.add(labelPanel);
		panel.add(topPanel);
		panel.add(centerPanel);
		
		return panel;
	}
	
	private JPanel createStandardPanel()
	{
		JPanel labelPanel = createLabelPanel("标准颜色");
		
		JPanel topPanel = new JPanel();
		topPanel.setBackground(Color.white);
		topPanel.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
		topPanel.setLayout(new GridLayout(1, 10, 4, 0));
		
		for (int i = 60; i < 70; i++)
		{	
			Color color = (Color) colorList.get(i);
			
			int borderStyle = ALL;
			
			ColorItem colorItem = new ColorItem(color, borderStyle);
			topPanel.add(colorItem);
			
			colorItemMap.put(color, colorItem);
		}
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.white);
		panel.setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 0));
		panel.add(labelPanel);
		panel.add(topPanel);
		
		return panel;
	}
	
	private JPanel createButtonPanel()
	{
		JBasicButton noColorButton = new JBasicButton("无颜色", new ColorIcon(null, new Color(226, 228, 231), 16, 16), "无颜色");
		noColorButton.setUI(new LiteButtonUI(new JYellowLiteButtonStyle()));
		ButtonManager.setButtonLayout(noColorButton, new int[] {HORIZONTAL, LEFT});
		noColorButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				hideParent();
				
				setColor(new Color(255, 255, 255, 0));
				
				executeSelection();
			}
		}
		);
		
		JBasicButton otherColorColorButton = new JBasicButton("其他颜色...", IconFactory.getSwingIcon("palette.png"), "其他颜色...");
		otherColorColorButton.setUI(new LiteButtonUI(new JYellowLiteButtonStyle()));
		ButtonManager.setButtonLayout(otherColorColorButton, new int[] {HORIZONTAL, LEFT});
		otherColorColorButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{			
				hideParent();
				
				setColor(JColorChooser.showDialog(HandleManager.getFrame(JColorSelector.this), "颜色拾选器", selectedColor));
				
				executeSelection();
			}
		}
		);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.white);
		panel.setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 0));
		panel.add(noColorButton);
		panel.add(new JBasicSeparator(JBasicSeparator.HORIZONTAL, JBasicSeparator.LOWERED_STYLE, 22));
		panel.add(otherColorColorButton);
		
		return panel;
	}
	
	private JPanel createLabelPanel(String title)
	{
		JLabel label = new JLabel(title);
		label.setBorder(BorderFactory.createEmptyBorder(0, 7, 0, 0));
		
		JPanel labelPanel = new JPanel();
		labelPanel.setBackground(new Color(239, 243, 246));
		labelPanel.setPreferredSize(new Dimension(labelPanel.getPreferredSize().width, 22));
		labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.X_AXIS));
		labelPanel.add(label);
		
		return labelPanel;
	}
	
	private void hideParent()
	{
		Component component = HandleManager.getComponent(this, MenuElement.class);
		if (component != null)
		{
			component.setVisible(false);
		}
	}
	
	public Color getColor()
	{
		return selectedColor;
	}
	
	public void setColor(Color color)
	{				
		this.selectedColor = color;
		
		if (color == null)
		{
			return;
		}	
		
		for (Iterator iterator = colorItemMap.values().iterator(); iterator.hasNext();)
		{
			ColorItem colorItem = (ColorItem) iterator.next();
			
			if (colorItem.getColor().equals(color))
			{
				colorItem.setSelected(true);
			}
			else
			{
				colorItem.setSelected(false);
			}
		}
	}
	
	public class ColorItem
		extends JPanel implements MouseListener
	{
		protected Color color;
		protected boolean selected;
		
		protected LineBorder normalBorder = new LineBorder(new Color(227, 228, 232));
		
		public ColorItem(Color color, int borderStyle)
		{
			this.color = color;
			
			switch (borderStyle)
			{
				case ALL :
					break;
				case TOP :
					normalBorder.setColor(null, SOUTH);
					break;
				case CENTER :
					normalBorder.setColor(null, NORTH);
					normalBorder.setColor(null, SOUTH);
					break;
				case BOTTOM :
					normalBorder.setColor(null, NORTH);
					break;					
			}
			
			
			setBackground(color);
			setBorder(normalBorder);
			setToolTipText("R " + color.getRed() + ", G " + color.getGreen() + ", B " + color.getBlue());
			
			addMouseListener(this);
		}
		
		public Color getColor()
		{
			return color;
		}
		
		public Dimension getPreferredSize()
		{
			return new Dimension(13, 13);
		}
		
		public Dimension getMaximumSize()
		{
			return getPreferredSize();
		}
		
		public Dimension getMinimumSize()
		{
			return getPreferredSize();
		}
		
		public void setSelected(boolean selected)
		{
			this.selected = selected;
			
			if (selected)
			{
				setBorder(selectedBorder);
			}
			else
			{
				setBorder(normalBorder);
			}
		}
		
		public boolean isSelected()
		{
			return selected;
		}
		
		public void mouseClicked(MouseEvent e)
		{
		}
		
		public void mousePressed(MouseEvent e)
		{			
			hideParent();
			
			setColor(color);
			
			executeSelection();
		}
		
		public void mouseReleased(MouseEvent e)
		{
		}
		
		public void mouseEntered(MouseEvent e)
		{
			setBorder(hoverBorder);
		}
		
		public void mouseExited(MouseEvent e)
		{
			setBorder(selected ? selectedBorder : normalBorder);
		}
	}
	
	public void executeSelection()
	{
		
	}
}