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

public class ButtonContext
	implements ButtonConstants
{	
	/**
	 * The button ui class string.
	 */
	private static String buttonUIClass;
	
	/**
	 * The menu button ui class string.
	 */
	private static String menuButtonUIClass;
	
	/**
	 * The split button ui class string.
	 */
	private static String splitButtonUIClass;
	
	/**
	 * The button style class string.
	 */
	private static String buttonStyleClass;
	
	/**
	 * The button width inset value.
	 */
	private static int buttonWidthInset = DEFAULT_BUTTON_WIDTH_INSET;
	
	/**
	 * The button height inset value.
	 */
	private static int buttonHeightInset = DEFAULT_BUTTON_HEIGHT_INSET;
	
	/**
	 * Gets the button ui class prefix string.
	 * @param buttonUIClass the button ui class string
	 * @return the button ui prefix class string
	 */
	public static String getButtonUIClassPrefix(String buttonUIClass)
	{
		if (buttonUIClass.indexOf("SplitButtonUI") > -1)
		{
			return buttonUIClass.substring(0, buttonUIClass.indexOf("SplitButtonUI"));
		}
		else if (buttonUIClass.indexOf("MenuButtonUI") > -1)
		{
			return buttonUIClass.substring(0, buttonUIClass.indexOf("MenuButtonUI"));
		}
		else if (buttonUIClass.indexOf("ButtonUI") > -1)
		{
			return buttonUIClass.substring(0, buttonUIClass.indexOf("ButtonUI"));
		}
		
		return "";
	}
	
	/**
	 * Registers the ui by a button ui class and button style class.
	 * @param buttonUIClass the button ui class string
	 * @param buttonStyleClass the button style class string
	 */
	public static void registerUI(String buttonUIClass, String buttonStyleClass)
	{
		String buttonUIPrefix = getButtonUIClassPrefix(buttonUIClass);
		
		ButtonContext.buttonUIClass = buttonUIPrefix + "ButtonUI";
		ButtonContext.menuButtonUIClass = buttonUIPrefix + "MenuButtonUI";
		ButtonContext.splitButtonUIClass = buttonUIPrefix + "SplitButtonUI";
		
		ButtonContext.buttonStyleClass = buttonStyleClass;
	}
	

	/**
	 * Registers the ui by a button ui class, menu button ui class, split button ui class and button style class.
	 * @param buttonUIClass the button ui class string
	 * @param menuButtonUIClass the menu button ui class string
	 * @param splitButtonUIClass the split button ui class string
	 * @param buttonStyleClass the button style class string
	 */
	public static void registerUI(String buttonUIClass, String menuButtonUIClass, String splitButtonUIClass, String buttonStyleClass)
	{
		ButtonContext.buttonUIClass = buttonUIClass;
		ButtonContext.menuButtonUIClass = menuButtonUIClass;
		ButtonContext.splitButtonUIClass = splitButtonUIClass;
		ButtonContext.buttonStyleClass = buttonStyleClass;
	}
	
	/**
	 * Registers the inset by a button width inset and button height inset. 
	 * @param buttonWidthInset the button width inset value
	 * @param buttonHeightInset the button height inset value
	 */
	public static void registerInset(int buttonWidthInset, int buttonHeightInset)
	{
		ButtonContext.buttonWidthInset = buttonWidthInset;
		ButtonContext.buttonHeightInset = buttonHeightInset;
	}
	
	/**
	 * Gets the button ui class.
	 * @return the the button ui class string
	 */
	public static String getButtonUIClass()
	{
		return buttonUIClass;
	}
	
	/**
	 * Gets the menu button ui class.
	 * @return the the menu button ui class string
	 */
	public static String getMenuButtonUIClass()
	{
		return menuButtonUIClass;
	}
	
	/**
	 * Gets the split button ui class.
	 * @return the the split button ui class string
	 */
	public static String getSplitButtonUIClass()
	{
		return splitButtonUIClass;
	}
	
	/**
	 * Gets the button style class.
	 * @return the the button style class string
	 */
	public static String getButtonStyleClass()
	{
		return buttonStyleClass;
	}
	
	/**
	 * Gets the button width inset.
	 * @return the button width inset value
	 */
	public static int getButtonWidthInset()
	{
		return buttonWidthInset;
	}
	
	/**
	 * Gets the button height inset.
	 * @return the button height inset value
	 */
	public static int getButtonHeightInset()
	{
		return buttonHeightInset;
	}
	
	/**
	 * Sets the priority context.
	 * If the button ui class, the menu button ui class, the split button ui class and the button style class is not null, 
	 * the context will take effect, otherwise it will take effect by the outside setting.
	 * @return the boolean value if the priority context is set.
	 */
	public static boolean setPriorityContext()
	{
		if (buttonUIClass != null && menuButtonUIClass != null && splitButtonUIClass != null && buttonStyleClass != null)
		{
			ButtonManager.setUI(buttonUIClass, menuButtonUIClass, splitButtonUIClass, buttonStyleClass);
			
			return true;
		}
		
		return false;
	}
}