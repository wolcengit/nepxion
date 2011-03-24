package com.nepxion.swing.button;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.StringTokenizer;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import com.nepxion.swing.buttonbar.JBasicButtonBar;
import com.nepxion.swing.dimension.DimensionManager;
import com.nepxion.swing.font.FontContext;
import com.nepxion.swing.lookandfeel.LookAndFeelManager;
import com.nepxion.swing.separator.JBasicSeparator;
import com.nepxion.swing.style.button.AbstractButtonUI;
import com.nepxion.swing.style.button.IButtonStyle;
import com.nepxion.swing.style.button.IButtonUI;
import com.nepxion.swing.style.button.flat.FlatButtonUI;
import com.nepxion.swing.style.button.flat.FlatMenuButtonUI;
import com.nepxion.swing.style.button.flat.FlatSplitButtonUI;
import com.nepxion.swing.style.buttonbar.ButtonBarUI;

public class ButtonManager
	implements SwingConstants
{
	private static IButtonUI buttonUI;
	private static IButtonUI menuButtonUI;
	private static IButtonUI splitButtonUI;
	private static IButtonStyle buttonStyle;
	
	private static FlatButtonUI flatButtonUI;
	private static FlatMenuButtonUI flatMenuButtonUI;	
	private static FlatSplitButtonUI flatSplitButtonUI;
	
	private static ButtonBarUI buttonBarUI;
	
	public static void setPreferenceStyle(AbstractButton button)
	{
		if (LookAndFeelManager.isNimbusLookAndFeel())
		{
			button.setMargin(new Insets(0, 0, 0, 0));
		}
		else
		{
			button.setMargin(new Insets(3, 9, 3, 9));
			
			button.setFocusPainted(false);
		}
	}
	
	public static void updateUI(Container container)
	{
		updateUI(container, (Insets) null);
	}
	
	public static void updateUI(Container container, Insets insets)
	{
		updateUI(container, insets, new int[] {HORIZONTAL, CENTER});
	}
	
	public static void updateUI(Container container, boolean isFlatButtonUI)
	{
		updateUI(container, new int[] {HORIZONTAL, CENTER}, isFlatButtonUI);
	}	
	
	public static void updateUI(Container container, int[] layout)
	{
		updateUI(container, (Insets) null, layout);
	}		
	
	public static void updateUI(Container container, Insets insets, int[] layout)
	{
		updateUI(container, insets, null, layout);
	}
	
	
	public static void updateUI(Container container, ButtonGroup buttonGroup)
	{
		updateUI(container, (Insets) null, buttonGroup);
	}
	
	public static void updateUI(Container container, Insets insets, ButtonGroup buttonGroup)
	{
		updateUI(container, insets, buttonGroup, new int[] {HORIZONTAL, CENTER});
	}
	
	
	public static void updateUI(Container container, Dimension dimension)
	{
		updateUI(container, dimension, false);
	}
	
	
	public static void updateUI(Container container, int[] layout, boolean isFlatButtonUI)
	{
		updateUI(container, (Dimension) null, layout, isFlatButtonUI);
	}
		
		
	public static void updateUI(Container container, ButtonGroup buttonGroup, boolean isFlatButtonUI)
	{
		updateUI(container, null, buttonGroup, isFlatButtonUI);
	}		
	
	public static void updateUI(Container container, Dimension dimension, boolean isFlatButtonUI)
	{
		updateUI(container, dimension, (ButtonGroup) null, isFlatButtonUI);
	}	
		
	
	public static void updateUI(Container container, ButtonGroup buttonGroup, int[] layout)
	{
		updateUI(container, (Insets) null, buttonGroup, layout);
	}	
	
	public static void updateUI(Container container, Insets insets, ButtonGroup buttonGroup, int[] layout)
	{
		updateUI(container, null, insets, buttonGroup, layout, false);
	}		
	
	public static void updateUI(Container container, Dimension dimension, int[] layout)
	{
		updateUI(container, dimension, null, layout);
	}
	
	public static void updateUI(Container container, Dimension dimension, ButtonGroup buttonGroup)
	{
		updateUI(container, dimension, buttonGroup, new int[] {HORIZONTAL, CENTER});
	}	
	
	
	public static void updateUI(Container container, ButtonGroup buttonGroup, int[] layout, boolean isFlatButtonUI)
	{
		updateUI(container, null, buttonGroup, layout, isFlatButtonUI);
	}
	
	public static void updateUI(Container container, Dimension dimension, int[] layout, boolean isFlatButtonUI)
	{
		updateUI(container, dimension, null, layout, isFlatButtonUI);
	}
	
	public static void updateUI(Container container, Dimension dimension, ButtonGroup buttonGroup, boolean isFlatButtonUI)
	{
		updateUI(container, dimension, buttonGroup, new int[] {HORIZONTAL, CENTER}, isFlatButtonUI);
	}
	
	public static void updateUI(Container container, Dimension dimension, ButtonGroup buttonGroup, int[] layout)
	{
		updateUI(container, dimension, buttonGroup, layout, false);
	}
	
	
	public static void updateUI(Container container, Dimension dimension, ButtonGroup buttonGroup, int[] layout, boolean isFlatButtonUI)
	{
		updateUI(container, dimension, null, buttonGroup, layout, isFlatButtonUI);
	}
		
	public static void updateUI(Container container, Dimension dimension, Insets insets, ButtonGroup buttonGroup, int[] layout, boolean isFlatButtonUI)
	{
		for (int i = 0; i < container.getComponentCount(); i++)
		{
			Component component = (Component) container.getComponent(i);
			if (component instanceof AbstractButton)
			{
				AbstractButton abstractButton = (AbstractButton) component;
				
				int iconTextLayout = layout[0];
				int horizontalAlignment = layout[1];
				if (iconTextLayout == VERTICAL)
				{
					abstractButton.setHorizontalTextPosition(CENTER);
					abstractButton.setVerticalTextPosition(BOTTOM);
				}
				else if (iconTextLayout == HORIZONTAL)
				{
					abstractButton.setHorizontalTextPosition(TRAILING);
					abstractButton.setVerticalTextPosition(CENTER);
					
					abstractButton.setHorizontalAlignment(horizontalAlignment);
				}
				
				if (container instanceof JToolBar)
				{
					abstractButton.setFocusPainted(false);					
				}
				
				if (insets != null)
				{
					abstractButton.setMargin(insets);
				}	
				
				abstractButton.setFont(FontContext.getFont());
				
				if (component instanceof JBasicSplitButton)
				{
					JBasicSplitButton button = (JBasicSplitButton) component;
					if (isFlatButtonUI)
					{
						if (flatSplitButtonUI == null)
						{
							flatSplitButtonUI = new FlatSplitButtonUI();
						}	
						button.setUI(flatSplitButtonUI);
					}
					else
					{
						button.setUI((AbstractButtonUI) splitButtonUI);
					}
					if (dimension != null)
					{
						button.setDimension(new Dimension(dimension.width + 5, dimension.height));
					}
				}
				else if (component instanceof JBasicMenuButton)
				{
					JBasicMenuButton button = (JBasicMenuButton) component;
					if (isFlatButtonUI)
					{
						if (flatMenuButtonUI == null)
						{
							flatMenuButtonUI = new FlatMenuButtonUI();
						}							
						button.setUI(flatMenuButtonUI);
					}
					else
					{
						button.setUI((AbstractButtonUI) menuButtonUI);
					}
					if (dimension != null)
					{
						if (container instanceof JToolBar)
						{
							JToolBar toolBar = (JToolBar) container;
							if (toolBar.getOrientation() == VERTICAL)
							{
								button.setDimension(dimension);
							}
							else
							{
								button.setDimension(new Dimension(dimension.width + 5, dimension.height));
							}
						}
						else
						{
							button.setDimension(new Dimension(dimension.width + 5, dimension.height));
						}
					}
				}
				else if (component instanceof JBasicButton)
				{
					JBasicButton button = (JBasicButton) component;
					if (isFlatButtonUI)
					{
						if (flatButtonUI == null)
						{
							flatButtonUI = new FlatButtonUI();
						}							
						button.setUI(flatButtonUI);
					}
					else
					{
						button.setUI((AbstractButtonUI) buttonUI);
					}
					if (dimension != null)
					{
						button.setDimension(dimension);
					}
				}
				else if (component instanceof JBasicToggleButton)
				{
					JBasicToggleButton button = (JBasicToggleButton) component;
					if (isFlatButtonUI)
					{
						if (flatButtonUI == null)
						{
							flatButtonUI = new FlatButtonUI();
						}							
						button.setUI(flatButtonUI);
					}
					else
					{
						button.setUI((AbstractButtonUI) buttonUI);
					}
					if (dimension != null)
					{
						button.setDimension(dimension);
					}
					if (buttonGroup != null)
					{
						buttonGroup.add(button);
					}
				}
				else
				{
					if (dimension != null)
					{
						DimensionManager.setDimension(abstractButton, dimension);
					}
				}
			}
			else if (component instanceof JBasicSeparator)
			{
				JBasicSeparator separator = (JBasicSeparator) component;
				Dimension size = null;
				if (dimension != null)
				{
					size = dimension;
				}
				else
				{
					size = container.getPreferredSize();
				}
				
				if (container instanceof JToolBar)
				{
					// JToolBar toolBar = (JToolBar) container;
					// separator.setOrientation(toolBar.getOrientation() == VERTICAL ? HORIZONTAL : VERTICAL);
					separator.setLength(separator.getOrientation()== VERTICAL ? size.height - 8 : size.width - 8);
				}
				else
				{
					separator.setLength(size.height - 8);
				}
			}
		}
	}
	
	public static void updateUI(JBasicButtonBar buttonBar)
	{
		buttonBar.setUI(buttonBarUI);
	}
	
	public static void setUI(String buttonUIClass, String menuButtonUIClass, String splitButtonUIClass, String buttonStyleClass)
	{
		try
		{
			buttonStyle = (IButtonStyle) Class.forName(buttonStyleClass).newInstance();
			
			Constructor buttonUIConstructor = Class.forName(buttonUIClass).getConstructor(new Class[] {IButtonStyle.class});
			buttonUI = (IButtonUI) buttonUIConstructor.newInstance(new Object[] {buttonStyle});
			
			Constructor menuButtonUIConstructor = Class.forName(menuButtonUIClass).getConstructor(new Class[] {IButtonStyle.class});
			menuButtonUI = (IButtonUI) menuButtonUIConstructor.newInstance(new Object[] {buttonStyle});
			
			Constructor splitButtonUIConstructor = Class.forName(splitButtonUIClass).getConstructor(new Class[] {IButtonStyle.class});
			splitButtonUI = (IButtonUI) splitButtonUIConstructor.newInstance(new Object[] {buttonStyle});
			
			buttonBarUI = new ButtonBarUI((AbstractButtonUI) buttonUI);
		}
		catch (SecurityException e)
		{
			e.printStackTrace();
		}
		catch (IllegalArgumentException e)
		{
			e.printStackTrace();
		}
		catch (InstantiationException e)
		{
			e.printStackTrace();
		}
		catch (IllegalAccessException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (NoSuchMethodException e)
		{
			e.printStackTrace();
		}
		catch (InvocationTargetException e)
		{
			e.printStackTrace();
		}
	}
	
	public static IButtonUI getButtonUI()
	{
		return buttonUI;
	}
	
	public static IButtonUI getMenuButtonUI()
	{
		return menuButtonUI;
	}
	
	public static IButtonUI getSplitButtonUI()
	{
		return splitButtonUI;
	}
	
	public static IButtonStyle getButtonStyle()
	{
		return buttonStyle;
	}
	
	public static ButtonBarUI getButtonBarUI()
	{
		return buttonBarUI;
	}
	
	/**
	 * XML : "&#x0A;" -> HTML: "\n"
	 * XML : "&amp;nbsp;" -> HTML : "&nbsp;"
	 * @param text
	 * @return
	 */
	public static String getStyleText(String text)
	{
		String delimiter = "\n";
		
		if (text.indexOf(delimiter) > -1)
		{
			String html = "<html>";
			
			StringTokenizer stringTokenizer = new StringTokenizer(text, delimiter);
			while (stringTokenizer.hasMoreTokens())
			{
				String next = stringTokenizer.nextToken();
				html += "<p align=center>" + next + "</p>";
			}
			
			html += "</html>";

			return html;
		}
		else
		{
			return text;
		}
	}
}