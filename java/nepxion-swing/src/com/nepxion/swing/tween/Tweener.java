package com.nepxion.swing.tween;

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
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Tweener
	implements ActionListener
{		
	private Timer timer; // 动画定时器
	private int frameInterval = 1; // 动画刷新时间间隔
	private int frameCount = 20; // 动画帧数
	private int frameIndex; // 当前动画帧

	private boolean isHorizontalTweening = true; // 是否横向滚动
	private boolean isVerticalTweening = true; // 是否垂直滚动
	
	private Component component;
	private Dimension dimension; // 窗口全部展开时大小
	
	public static void tween(Component component)
	{
		tween(component, true, true);
	}
	
	public static void tween(Component component, int frameInterval, int frameCount)
	{
		tween(component, frameInterval, frameCount, true, true);
	}
	
	public static void tween(Component component, boolean isHorizontalTweening, boolean isVerticalTweening)
	{
		tween(component, 1, 20, isHorizontalTweening, isVerticalTweening);
	}
	
	/**
	 * 调用此静态方法显示窗口，可以出现动画效果。被显示的窗口是任何继承自Component的窗口，包括显示模态的对话框
	 */
	public static void tween(Component component, int frameInterval, int frameCount, boolean isHorizontalTweening, boolean isVerticalTweening)
	{
		if (component.isVisible())
		{
			return;
		}
		
		Tweener tweener = new Tweener(component, frameInterval, frameCount, isHorizontalTweening, isVerticalTweening);
		tweener.tween();
	}
	
	private Tweener(Component component, int frameInterval, int frameCount, boolean isHorizontalTweening, boolean isVerticalTweening)
	{
		this.component = component;
		this.frameInterval = frameInterval;
		this.frameCount = frameCount;
		this.isHorizontalTweening = isHorizontalTweening;
		this.isVerticalTweening = isVerticalTweening;
		
		dimension = component.getSize();
		component.setSize(0, 0);
		
		timer = new Timer(this.frameInterval, this);
		frameIndex = 0;
	}
	
	// 激活动画过程
	private void tween()
	{
		if (!component.isVisible())
		{
			timer.start();
			component.setVisible(true);
		}
	}
	
	// 动画的一帧处理方法
	public void actionPerformed(ActionEvent e)
	{
		// 计算和设置当前帧尺寸
		component.setSize(isHorizontalTweening ? dimension.width * frameIndex / frameCount : dimension.width, isVerticalTweening ? dimension.height * frameIndex / frameCount : dimension.height);
		
		if (frameIndex == frameCount)
		{
			// 最后一帧，停止时钟，释放资源
			timer.stop();
			timer = null;
			component = null;
			dimension = null;
		}
		else
		{
			// 前进一帧
			frameIndex++;
		}
	}
}