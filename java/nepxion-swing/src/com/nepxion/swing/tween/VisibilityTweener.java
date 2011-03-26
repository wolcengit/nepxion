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

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.Timer;

public class VisibilityTweener
	implements ActionListener
{
	private JComponent component;
	private Dimension dimension;
	
	private boolean visibleTweening = true;
	private boolean horizontalTweening = true;
	private boolean verticalTweening = true;
	
	private int frameInterval = 1;
	private int frameCount = 20;
	private int frameIndex;
	
	private Timer timer;
	
	public VisibilityTweener(JComponent component, boolean visibleTweening)
	{
		this(component, visibleTweening, true, true);
	}
	
	public VisibilityTweener(JComponent component, boolean visibleTweening, int frameInterval, int frameCount)
	{
		this(component, visibleTweening, true, true, frameInterval, frameCount);
	}
	
	public VisibilityTweener(JComponent component, boolean visibleTweening, boolean horizontalTweening, boolean verticalTweening)
	{
		this(component, visibleTweening, horizontalTweening, verticalTweening, 1, 20);
	}
	
	public VisibilityTweener(JComponent component, boolean visibleTweening, boolean horizontalTweening, boolean verticalTweening, int frameInterval, int frameCount)
	{
		this.component = component;
		this.dimension = component.getSize();
		
		this.visibleTweening = visibleTweening;
		this.horizontalTweening = horizontalTweening;
		this.verticalTweening = verticalTweening;
		
		this.frameInterval = frameInterval;
		this.frameCount = frameCount;
		
		if (visibleTweening)
		{
			this.frameIndex = 0;
			component.setSize(0, 0);
		}
		else
		{
			this.frameIndex = frameCount;
		}
		
		timer = new Timer(this.frameInterval, this);
	}
	
	public void tween()
	{
		timer.start();
		if (visibleTweening)
		{
			component.setVisible(true);
		}
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if (visibleTweening)
		{
			component.setSize(horizontalTweening ? dimension.width * frameIndex / frameCount : dimension.width, verticalTweening ? dimension.height * frameIndex / frameCount : dimension.height);
			
			if (frameIndex == frameCount)
			{
				timer.stop();
			}
			else
			{
				frameIndex++;
			}
		}
		else
		{
			component.setSize(horizontalTweening ? dimension.width * frameIndex / frameCount : dimension.width, verticalTweening ? dimension.height * frameIndex / frameCount : dimension.height);
			
			if (frameIndex == 0)
			{
				component.setVisible(false);
				
				timer.stop();
			}
			else
			{
				frameIndex--;
			}
		}
	}
}