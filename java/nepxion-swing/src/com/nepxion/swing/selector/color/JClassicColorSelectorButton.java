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

import com.nepxion.swing.button.JClassicMenuButton;
import com.nepxion.swing.icon.paint.ColorCombinationIcon;
import com.nepxion.swing.locale.SwingLocale;

public abstract class JClassicColorSelectorButton
	extends JClassicMenuButton implements IColorSelectorComponent
{
	/**
	 * Constructs with the specified initial icon.
	 * @param icon the instance of ColorCombinationIcon
	 */
	public JClassicColorSelectorButton(ColorCombinationIcon icon)
	{
		this(icon, SwingLocale.getString("color_selector"));
	}
	
	/**
	 * Constructs with the specified initial icon and tooltip text.
	 * @param icon the instance of ColorCombinationIcon
	 * @param toolTipText the tooltip text string
	 */
	public JClassicColorSelectorButton(final ColorCombinationIcon icon, String toolTipText)
	{
		super(icon, toolTipText);
		
		JColorSelectorPopupMenu colorSelectorPopupMenu = new JColorSelectorPopupMenu()
		{
			public void executeSelection(Color color)
			{				
				ColorCombinationIcon colorCombinationIcon = (ColorCombinationIcon) getIcon();
				colorCombinationIcon.setFillColor(color);
				
				JClassicColorSelectorButton.this.executeSelection(color);
			}
		};
		colorSelectorPopupMenu.getColorSelector().setColor(icon.getFillColor());
		
		setPopupMenu(colorSelectorPopupMenu);
	}
}