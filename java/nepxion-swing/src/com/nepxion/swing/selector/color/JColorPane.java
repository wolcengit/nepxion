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
import java.awt.Graphics;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.nepxion.swing.button.ButtonManager;
import com.nepxion.swing.button.JBasicButton;
import com.nepxion.swing.button.JBasicToggleButton;
import com.nepxion.swing.handle.HandleManager;
import com.nepxion.swing.layout.filed.FiledLayout;
import com.nepxion.swing.layout.table.TableLayout;

public class JColorPane
	extends JPanel
{
	private List colors = new ArrayList();
	
	public Color selectedColor;
	
	private JPanel buttonPanel;
	
	public JColorPane()
	{
		initColors();
		
		setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.CENTER, 0));
		add(new JLabel(new HandleIcon(148, 12)));
		
		double[][] size = 
		{ 
			{18, 18, 18, 18, 18, 18, 18, 18}, 
			{22, 18, 18, 18, 18, 18, 22}
		};
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new TableLayout(size));
		
		JBasicToggleButton autoColorButton = new JBasicToggleButton(new AutoColorIcon(144, 22), "×Ô¶¯Ñ¡É«");
		autoColorButton.setForeground(new Color(0, 0, 0));
		autoColorButton.addActionListener(new ColorPickAction());
		buttonPanel.add(autoColorButton, "0, 0, 7, 0");
		
		int rowIndex = 0;
		int columnIndex = -1;
		for (int i = 0; i < colors.size(); i++)
		{
			ColorBean color = (ColorBean) colors.get(i);
			JBasicToggleButton button = new JBasicToggleButton(new ColorIcon(color.getColor(), 12, 12), color.getName());
			button.setForeground(color.getColor());
			button.addActionListener(new ColorPickAction());
			
			columnIndex++;
			if (i % 8 == 0)
			{
				rowIndex++;
				columnIndex = 0;
			}
			buttonPanel.add(button, columnIndex + ", " + rowIndex);
		}
		
		JBasicButton otherColorButton = new JBasicButton(new ChooserColorIcon(144, 22), "ÆäËûÑÕÉ«");
		otherColorButton.addActionListener(new ChooserColorAction());
		buttonPanel.add(otherColorButton, "0, 6, 7, 6");
		
		ButtonManager.updateUI(buttonPanel, new Dimension(18, 18), new ButtonGroup());
		
		add(buttonPanel);
	}
	
	private void initColors()
	{
		colors.add(new ColorBean("ºÚÉ«", new Color(0, 0, 0)));
		colors.add(new ColorBean("ºÖÉ«", new Color(153, 51, 0)));
		colors.add(new ColorBean("éÏé­ÂÌ", new Color(51, 51, 0)));
		colors.add(new ColorBean("ÉîÂÌ", new Color(0, 51, 0)));
		colors.add(new ColorBean("Éî»ÒÀ¶", new Color(0, 51, 102)));
		colors.add(new ColorBean("ÉîÀ¶", new Color(0, 0, 128)));
		colors.add(new ColorBean("µåÀ¶", new Color(51, 51, 153)));
		colors.add(new ColorBean("»ÒÉ«-80%", new Color(51, 51, 51)));
		
		colors.add(new ColorBean("Éîºì", new Color(128, 0, 0)));
		colors.add(new ColorBean("½Û»Æ", new Color(255, 102, 0)));
		colors.add(new ColorBean("Éî»Æ", new Color(128, 128, 0)));
		colors.add(new ColorBean("ÂÌÉ«", new Color(0, 128, 0)));
		colors.add(new ColorBean("ÇàÉ«", new Color(0, 128, 128)));
		colors.add(new ColorBean("À¶É«", new Color(0, 0, 255)));
		colors.add(new ColorBean("À¶»Ò", new Color(102, 102, 153)));
		colors.add(new ColorBean("»ÒÉ«-50%", new Color(128, 128, 128)));
		
		colors.add(new ColorBean("ºìÉ«", new Color(255, 0, 0)));
		colors.add(new ColorBean("Ç³½Û»Æ", new Color(255, 153, 0)));
		colors.add(new ColorBean("Ëá³ÈÉ«", new Color(153, 204, 0)));
		colors.add(new ColorBean("º£ÂÌ", new Color(51, 153, 102)));
		colors.add(new ColorBean("±¦Ê¯À¶", new Color(51, 204, 204)));
		colors.add(new ColorBean("Ç³À¶", new Color(51, 102, 255)));
		colors.add(new ColorBean("×ÏÉ«", new Color(128, 0, 128)));
		colors.add(new ColorBean("»ÒÉ«-40%", new Color(153, 153, 153)));
		
		colors.add(new ColorBean("·Ûºì", new Color(255, 0, 255)));
		colors.add(new ColorBean("½ðÉ«", new Color(255, 204, 0)));
		colors.add(new ColorBean("»ÆÉ«", new Color(255, 255, 0)));
		colors.add(new ColorBean("ÏÊÂÌ", new Color(0, 255, 0)));
		colors.add(new ColorBean("ÇàÂÌ", new Color(0, 255, 255)));
		colors.add(new ColorBean("ÌìÀ¶", new Color(0, 204, 255)));
		colors.add(new ColorBean("Ã·ºì", new Color(153, 51, 102)));
		colors.add(new ColorBean("»ÒÉ«-25%", new Color(192, 192, 192)));
		
		colors.add(new ColorBean("Ãµ¹åºì", new Color(255, 153, 204)));
		colors.add(new ColorBean("×Ø»Æ", new Color(255, 204, 153)));
		colors.add(new ColorBean("Ç³»Æ", new Color(255, 255, 153)));
		colors.add(new ColorBean("Ç³ÂÌ", new Color(204, 255, 204)));
		colors.add(new ColorBean("Ç³ÇàÂÌ", new Color(204, 255, 255)));
		colors.add(new ColorBean("µ­À¶", new Color(153, 204, 255)));
		colors.add(new ColorBean("µ­×Ï", new Color(204, 153, 255)));
		colors.add(new ColorBean("°×É«", new Color(255, 255, 255)));
	}
	
	public void setColor(Color color)
	{
		selectedColor = color;
		for (int i = 1; i < buttonPanel.getComponentCount(); i++)
		{
			Component component = buttonPanel.getComponent(i);
			if (component instanceof JBasicToggleButton)
			{
				JBasicToggleButton button = (JBasicToggleButton) component;
				Color buttonColor = button.getForeground();
				if (buttonColor.toString().equals(color.toString()))
				{
					button.setSelected(true);
					return;
				}
			}
		}
	}
	
	public Color getColor()
	{
		return selectedColor;
	}
	
	public class ColorPickAction
		implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			JBasicToggleButton toggleButton = (JBasicToggleButton) e.getSource();
			selectedColor = toggleButton.getForeground();
			
			/*Window window = HandleFactory.getWindow(JColorPane.this);
			if (window != null)
			{
				window.setVisible(false);
			}*/			 
		}
	}
	
	public class ChooserColorAction
		implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Window window = HandleManager.getWindow(JColorPane.this);
			if (window != null)
			{
				window.setVisible(false);
			}
			
			JBasicButton button = (JBasicButton) e.getSource();
			button.getModel().setRollover(false);
			
			selectedColor = JColorChooser.showDialog(window, "ÑÕÉ«Ê°Ñ¡Æ÷", selectedColor);
			doChooser();
		}
	}
	
	public void doChooser()
	{
		
	}
	
	public class ColorBean
	{
		private String name;
		private Color color;
		
		public ColorBean(String name, Color color)
		{
			this.name = name;
			this.color = color;
		}
		
		public String getName()
		{
			return name;
		}
		
		public Color getColor()
		{
			return color;
		}
	}
	
	public class HandleIcon
		implements Icon
	{
		private int w;
		private int h;
		
		public HandleIcon(int w, int h)
		{
			this.w = w;
			this.h = h;
		}
		
		public void paintIcon(Component c, Graphics g, int x, int y)
		{
			g.setColor(Color.gray);
			g.fillRect(0, 2, 148, 7);
		}
		
		public int getIconWidth()
		{
			return w;
		}
		
		public int getIconHeight()
		{
			return h;
		}
	}
	
	public class AutoColorIcon
		implements Icon
	{
		private int w;
		private int h;
		
		public AutoColorIcon(int w, int h)
		{
			this.w = w;
			this.h = h;
		}
		
		public void paintIcon(Component c, Graphics g, int x, int y)
		{
			g.setColor(Color.gray);
			g.drawRect(2, 2, 139, 17);
			g.drawRect(5, 5, 11, 11);
			g.setColor(Color.black);
			g.fillRect(6, 6, 10, 10);
			g.drawString("×Ô¶¯", w / 2 - 21 / 2, h / 2 + 11 / 2);
		}
		
		public int getIconWidth()
		{
			return w;
		}
		
		public int getIconHeight()
		{
			return h;
		}
	}
	
	public class ChooserColorIcon
		implements Icon
	{
		private int w;
		private int h;
		
		public ChooserColorIcon(int w, int h)
		{
			this.w = w;
			this.h = h;
		}
		
		public void paintIcon(Component c, Graphics g, int x, int y)
		{
			g.setColor(Color.gray);
			g.drawRect(2, 2, 139, 17);
			g.setColor(Color.black);
			g.drawString("ÆäËûÑÕÉ«...", w / 2 - 58 / 2, h / 2 + 11 / 2);
		}
		
		public int getIconWidth()
		{
			return w;
		}
		
		public int getIconHeight()
		{
			return h;
		}
	}
	
	public class ColorIcon
		implements Icon
	{
		private Color color;
		private int w;
		private int h;
		
		public ColorIcon(Color color, int w, int h)
		{
			this.color = color;
			this.w = w;
			this.h = h;
		}
		
		public void paintIcon(Component c, Graphics g, int x, int y)
		{
			g.setColor(Color.gray);
			g.drawRect(x, y, w - 1, h - 1);
			g.setColor(color);
			g.fillRect(x + 1, y + 1, w - 2, h - 2);
		}
		
		public Color getColor()
		{
			return color;
		}
		
		public void setColor(Color color)
		{
			this.color = color;
		}
		
		public int getIconWidth()
		{
			return w;
		}
		
		public int getIconHeight()
		{
			return h;
		}
	}
}