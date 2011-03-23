package com.nepxion.swing.framework.ribbon.xml;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.awt.Insets;

import javax.swing.SwingConstants;

public interface Dom4JRibbonConstants
	extends SwingConstants
{
	public static final String CONFIG_FILE_PATH = "context/ribbon.xml";
	
	public static final String TAG_NAME = "name";
	public static final String TAG_TITLE = "title";
	public static final String TAG_TEXT1 = "text1";
	public static final String TAG_TEXT2 = "text2";
	public static final String TAG_ICON = "icon";
	public static final String TAG_TOOL_TIP_TEXT = "tooltip";
	public static final String TAG_CLOSABLE = "closable";
	public static final String TAG_CLASS = "class";
	
	public static final Insets BUTTON_INSETS = new Insets(5, 5, 5, 5);
	public static final int[] BUTTON_LAYOUT_PARAMETERS = new int[] {VERTICAL, CENTER};
}