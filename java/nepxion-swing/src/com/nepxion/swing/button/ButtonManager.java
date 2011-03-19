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

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
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
	
	private static FlatButtonUI flatButtonUI;
	private static FlatMenuButtonUI flatMenuButtonUI;	
	private static FlatSplitButtonUI flatSplitButtonUI;
	
	private static ButtonBarUI buttonBarUI;
	
	public static void updateUI(Container container)
	{
		updateUI(container, (Insets) null);
	}
	
	public static void updateUI(Container container, Insets insets)
	{
		updateUI(container, insets, HORIZONTAL);
	}
	
	public static void updateUI(Container container, boolean isFlatButtonUI)
	{
		updateUI(container, HORIZONTAL, isFlatButtonUI);
	}	
	
	public static void updateUI(Container container, int iconTextLayout)
	{
		updateUI(container, (Insets) null, iconTextLayout);
	}		
	
	public static void updateUI(Container container, Insets insets, int iconTextLayout)
	{
		updateUI(container, insets, null, iconTextLayout);
	}
	
	
	public static void updateUI(Container container, ButtonGroup buttonGroup)
	{
		updateUI(container, (Insets) null, buttonGroup);
	}
	
	public static void updateUI(Container container, Insets insets, ButtonGroup buttonGroup)
	{
		updateUI(container, insets, buttonGroup, HORIZONTAL);
	}
	
	
	public static void updateUI(Container container, Dimension dimension)
	{
		updateUI(container, dimension, null);
	}
	
	
	public static void updateUI(Container container, int iconTextLayout, boolean isFlatButtonUI)
	{
		updateUI(container, (Dimension) null, iconTextLayout, isFlatButtonUI);
	}
		
		
	public static void updateUI(Container container, ButtonGroup buttonGroup, boolean isFlatButtonUI)
	{
		updateUI(container, null, buttonGroup, isFlatButtonUI);
	}		
	
	public static void updateUI(Container container, Dimension dimension, boolean isFlatButtonUI)
	{
		updateUI(container, dimension, null, isFlatButtonUI);
	}	
		
	
	public static void updateUI(Container container, ButtonGroup buttonGroup, int iconTextLayout)
	{
		updateUI(container, (Insets) null, buttonGroup, iconTextLayout);
	}	
	
	public static void updateUI(Container container, Insets insets, ButtonGroup buttonGroup, int iconTextLayout)
	{
		updateUI(container, null, insets, buttonGroup, HORIZONTAL, false);
	}		
	
	public static void updateUI(Container container, Dimension dimension, int iconTextLayout)
	{
		updateUI(container, dimension, null, iconTextLayout); 
	}
	
	public static void updateUI(Container container, Dimension dimension, ButtonGroup buttonGroup)
	{
		updateUI(container, dimension, buttonGroup, HORIZONTAL);
	}	
	
	
	public static void updateUI(Container container, ButtonGroup buttonGroup, int iconTextLayout, boolean isFlatButtonUI)
	{
		updateUI(container, null, buttonGroup, iconTextLayout, isFlatButtonUI);
	}
	
	public static void updateUI(Container container, Dimension dimension, int iconTextLayout, boolean isFlatButtonUI)
	{
		updateUI(container, dimension, null, iconTextLayout, isFlatButtonUI);
	}
	
	public static void updateUI(Container container, Dimension dimension, ButtonGroup buttonGroup, boolean isFlatButtonUI)
	{
		updateUI(container, dimension, buttonGroup, HORIZONTAL, isFlatButtonUI);
	}
	
	public static void updateUI(Container container, Dimension dimension, ButtonGroup buttonGroup, int iconTextLayout)
	{
		updateUI(container, dimension, buttonGroup, iconTextLayout, false);
	}
	
	
	public static void updateUI(Container container, Dimension dimension, ButtonGroup buttonGroup, int iconTextLayout, boolean isFlatButtonUI)
	{
		updateUI(container, dimension, null, buttonGroup, iconTextLayout, isFlatButtonUI);
	}
		
	public static void updateUI(Container container, Dimension dimension, Insets insets, ButtonGroup buttonGroup, int iconTextLayout, boolean isFlatButtonUI)
	{
		for (int i = 0; i < container.getComponentCount(); i++)
		{
			Component component = (Component) container.getComponent(i);
			if (component instanceof AbstractButton)
			{
				AbstractButton abstractButton = (AbstractButton) component;
				if (iconTextLayout == VERTICAL)
				{
					abstractButton.setHorizontalTextPosition(CENTER);
					abstractButton.setVerticalTextPosition(BOTTOM);
				}
				else if (iconTextLayout == HORIZONTAL)
				{
					abstractButton.setHorizontalTextPosition(TRAILING);
					abstractButton.setVerticalTextPosition(CENTER);
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
				if (dimension != null)
				{
					if (container instanceof JToolBar)
					{
						JToolBar toolBar = (JToolBar) container;
						separator.setOrientation(toolBar.getOrientation() == VERTICAL ? HORIZONTAL : VERTICAL);
						separator.setLength(separator.getOrientation()== VERTICAL ? dimension.height - 8 : dimension.width - 8);
					}
					else
					{
						separator.setLength(dimension.height - 8);
					}
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
			IButtonStyle buttonStyle = (IButtonStyle) Class.forName(buttonStyleClass).newInstance();
			
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
	
	public static ButtonBarUI getButtonBarUI()
	{
		return buttonBarUI;
	}
	
	public static void setPreferenceStyle(JButton button)
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
}