package com.nepxion.swing.menu;

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
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Hashtable;

import javax.swing.Icon;
import javax.swing.JPanel;
import javax.swing.MenuSelectionManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

public class JColorMenu
	extends JBasicMenu
{
	protected Border unselectedBorder;
	protected Border selectedBorder;
	protected Border activeBorder;
	
	protected Hashtable colorPanels;
	protected ColorPanel selectedColorPanel;
	
	public JColorMenu()
	{
		super();
		
		initComponents();
	}
	
	public JColorMenu(Icon icon)
	{
		super(icon);
		
		initComponents();
	}
	
	public JColorMenu(Icon icon, String toolTipText)
	{
		super(icon, toolTipText);
		
		initComponents();
	}
	
	public JColorMenu(String text)
	{
		super(text);
		
		initComponents();
	}
	
	public JColorMenu(String text, String toolTipText)
	{
		super(text, toolTipText);
		
		initComponents();
	}
	
	public JColorMenu(String text, Icon icon)
	{
		super(text, icon);
		
		initComponents();
	}
	
	public JColorMenu(String text, Icon icon, String toolTipText)
	{
		super(text, icon, toolTipText);
		
		initComponents();
	}
	
	private void initComponents()
	{
		unselectedBorder = new CompoundBorder(new MatteBorder(1, 1, 1, 1, getBackground()), new BevelBorder(BevelBorder.LOWERED, Color.white, Color.gray));
		selectedBorder = new CompoundBorder(new MatteBorder(2, 2, 2, 2, Color.red), new MatteBorder(1, 1, 1, 1, getBackground()));
		activeBorder = new CompoundBorder(new MatteBorder(2, 2, 2, 2, Color.blue), new MatteBorder(1, 1, 1, 1, getBackground()));
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(new GridLayout(8, 8));
		colorPanels = new Hashtable();
		
		int[] values = new int[] {0, 128, 192, 255};
		for (int i = 0; i < values.length; i++)
		{
			for (int j = 0; j < values.length; j++)
			{
				for (int k = 0; k < values.length; k++)
				{
					Color color = new Color(values[i], values[j], values[k]);
					ColorPanel colorPanel = new ColorPanel(color);
					panel.add(colorPanel);
					colorPanels.put(color, colorPanel);
				}
			}
		}
		add(panel);
	}
	
	public void setColor(Color c)
	{
		Object object = colorPanels.get(c);
		if (object == null)
		{
			return;
		}
		if (selectedColorPanel != null)
		{
			selectedColorPanel.setSelected(false);
		}
		selectedColorPanel = (ColorPanel) object;
		selectedColorPanel.setSelected(true);
	}
	
	public Color getColor()
	{
		if (selectedColorPanel == null)
		{
			return null;
		}
		return selectedColorPanel.getColor();
	}
	
	public void doSelection()
	{
		fireActionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, getActionCommand()));
	}
	
	public class ColorPanel
		extends JPanel implements MouseListener
	{
		protected Color color;
		protected boolean selected;
		
		public ColorPanel(Color color)
		{
			this.color = color;
			setBackground(color);
			setBorder(unselectedBorder);
			setToolTipText("R " + color.getRed() + ", G " + color.getGreen() + ", B " + color.getBlue());
			addMouseListener(this);
		}
		
		public Color getColor()
		{
			return color;
		}
		
		public Dimension getPreferredSize()
		{
			return new Dimension(15, 15);
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
				setBorder(unselectedBorder);
			}
		}
		
		public boolean isSelected()
		{
			return selected;
		}
		
		public void mousePressed(MouseEvent e)
		{
		}
		
		public void mouseClicked(MouseEvent e)
		{
		}
		
		public void mouseReleased(MouseEvent e)
		{
			setColor(color);
			MenuSelectionManager.defaultManager().clearSelectedPath();
			doSelection();
		}
		
		public void mouseEntered(MouseEvent e)
		{
			setBorder(activeBorder);
		}
		
		public void mouseExited(MouseEvent e)
		{
			setBorder(selected ? selectedBorder : unselectedBorder);
		}
	}
}