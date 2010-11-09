package com.nepxion.swing.style.framework;

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

import javax.swing.border.Border;

public interface IStyle
{
	public Color getGradientColor(); // 渐变开始的颜色
	
	public Color getSelectionGradientColor(); // 选中渐变开始的颜色
	
	
	public Color getForeground(); // 前景色，标签文字颜色
	
	public Color getSelectionForeground(); // 选中前景色，标签文字颜色
	
	
	public Color getBackground(); // 背景色，渐变结束的颜色
	
	public Color getSelectionBackground(); // 选中背景色，渐变结束的颜色
	
	
	public Color getTabbedPaneGradientColor(); // 选项卡渐变开始的颜色
	
	public Color getTabbedPaneBackground(); // 选项卡渐变结束的颜色, 背景色
	
	
	public Color getTabbedPaneForeground(); // 选项卡前景色，标签文字颜色
	
	public Color getTabbedPaneSelectionForeground(); // 选中选项卡前景色，标签文字颜色
	
	
	public Border getBorder(); // 框架边界
	
	public Border getHeaderBorder(); // 框架头部边界
	
	public Border getLabelBorder(); // 框架标题栏边界
}