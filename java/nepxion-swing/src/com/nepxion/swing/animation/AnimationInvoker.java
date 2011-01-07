package com.nepxion.swing.animation;

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

public class AnimationInvoker
	implements ActionListener
{
	private Component component;
	
	// 动画定时器
	private Timer timer;
	
	// 窗口全部展开时大小
	private Dimension dimension;
	
	// 是否横向滚动
	private boolean isHorizontalExtending = true;
	
	// 是否垂直滚动
	private boolean isVerticalExtending = true;
	
	// 动画刷新时间间隔
	private int frameInterval = 1;
	
	// 动画帧数
	private int frames = 20;
	
	// 当前动画帧
	private int frameIndex;
	
	public static void show(Component component)
	{
		show(component, true, true);
	}
	
	public static void show(Component component, int frameInterval, int frames)
	{
		show(component, frameInterval, frames, true, true);
	}
	
	public static void show(Component component, boolean isHorizontalExtending, boolean isVerticalExtending)
	{
		show(component, 1, 20, isHorizontalExtending, isVerticalExtending);
	}
	
	/**
	 * 调用此静态方法显示窗口，可以出现动画效果 被显示的窗口是任何继承自Component的窗口，包括显示模态的对话框
	 */
	public static void show(Component component, int frameInterval, int frames, boolean isHorizontalExtending, boolean isVerticalExtending)
	{
		if (component.isVisible())
		{
			return;
		}
		
		new AnimationInvoker(component, frameInterval, frames, isHorizontalExtending, isVerticalExtending).invoke();
	}
	
	// 私有构造函数，不允许直接访问
	private AnimationInvoker(Component component, int frameInterval, int frames, boolean isHorizontalExtending, boolean isVerticalExtending)
	{
		// 初始化
		this.component = component;
		this.frameInterval = frameInterval;
		this.frames = frames;
		this.isHorizontalExtending = isHorizontalExtending;
		this.isVerticalExtending = isVerticalExtending;
		
		dimension = component.getSize();
		timer = new Timer(this.frameInterval, this);
		frameIndex = 0;
		component.setSize(0, 0);
	}
	
	// 激活动画过程
	private void invoke()
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
		component.setSize(isHorizontalExtending ? dimension.width * frameIndex / frames : dimension.width, isVerticalExtending ? dimension.height * frameIndex / frames : dimension.height);
		
		if (frameIndex == frames)
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