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
	private static String buttonUIClass;
	private static String menuButtonUIClass;
	private static String splitButtonUIClass;
	private static String buttonStyleClass;
	
	private static int buttonWidthInset = DEFAULT_BUTTON_WIDTH_INSET;
	private static int buttonHeightInset = DEFAULT_BUTTON_HEIGHT_INSET;
	
	public static String getButtonUIPrefix(String buttonUI)
	{
		if (buttonUI.indexOf("SplitButtonUI") > -1)
		{
			return buttonUI.substring(0, buttonUI.indexOf("SplitButtonUI"));
		}
		else if (buttonUI.indexOf("MenuButtonUI") > -1)
		{
			return buttonUI.substring(0, buttonUI.indexOf("MenuButtonUI"));
		}
		else if (buttonUI.indexOf("ButtonUI") > -1)
		{
			return buttonUI.substring(0, buttonUI.indexOf("ButtonUI"));
		}
		
		return "";
	}
	
	public static void registerUI(String customButtonUIClass, String customButtonStyleClass)
	{
		String buttonUIPrefix = getButtonUIPrefix(customButtonUIClass);
		
		buttonUIClass = buttonUIPrefix + "ButtonUI";
		menuButtonUIClass = buttonUIPrefix + "MenuButtonUI";
		splitButtonUIClass = buttonUIPrefix + "SplitButtonUI";
		
		buttonStyleClass = customButtonStyleClass;
	}
	
	public static void registerUI(String customButtonUIClass, String customMenuButtonUIClass, String customSplitButtonUIClass, String customButtonStyleClass)
	{
		buttonUIClass = customButtonUIClass;
		menuButtonUIClass = customMenuButtonUIClass;
		splitButtonUIClass = customSplitButtonUIClass;
		buttonStyleClass = customButtonStyleClass;
	}
	
	public static void registerInset(int customButtonWidthInset, int customButtonHeightInset)
	{
		buttonWidthInset = customButtonWidthInset;
		buttonHeightInset = customButtonHeightInset;
	}
	
	public static String getButtonUIClass()
	{
		return buttonUIClass;
	}
	
	public static String getMenuButtonUIClass()
	{
		return menuButtonUIClass;
	}
	
	public static String getSplitButtonUIClass()
	{
		return splitButtonUIClass;
	}
	
	public static String getButtonStyleClass()
	{
		return buttonStyleClass;
	}
	
	public static int getButtonWidthInset()
	{
		return buttonWidthInset;
	}
	
	public static int getButtonHeightInset()
	{
		return buttonHeightInset;
	}
	
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