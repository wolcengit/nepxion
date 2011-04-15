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
	
	private boolean horizontalTweening = true;
	private boolean verticalTweening = true;
	private boolean visibleTweening = true;
	
	private int frameInterval = 1;
	private int frameCount = 20;
	private int frameIndex;
	
	private Timer timer;
	
	public VisibilityTweener(JComponent component)
	{
		this(component, true, true);
	}
	
	public VisibilityTweener(JComponent component, int frameInterval, int frameCount)
	{
		this(component, true, true, frameInterval, frameCount);
	}
	
	public VisibilityTweener(JComponent component, boolean horizontalTweening, boolean verticalTweening)
	{
		this(component, horizontalTweening, verticalTweening, 1, 20);
	}
	
	public VisibilityTweener(JComponent component, boolean horizontalTweening, boolean verticalTweening, int frameInterval, int frameCount)
	{
		this.component = component;
		this.dimension = component.getSize();
		
		this.horizontalTweening = horizontalTweening;
		this.verticalTweening = verticalTweening;
		
		this.frameInterval = frameInterval;
		this.frameCount = frameCount;
				
		timer = new Timer(this.frameInterval, this);
	}
	
	public void tween(boolean visibleTweening)
	{		
		this.visibleTweening = visibleTweening;
		
		if (visibleTweening)
		{
			frameIndex = 0;
			
			component.setSize(0, 0);
			component.setVisible(true);
		}
		else
		{
			frameIndex = frameCount;
		}
		
		timer.start();
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
	
	public Dimension getDimension()
	{
		return dimension;
	}

	public void setDimension(Dimension dimension)
	{
		this.dimension = dimension;
	}
	
	public boolean isHorizontalTweening()
	{
		return horizontalTweening;
	}

	public void setHorizontalTweening(boolean horizontalTweening)
	{
		this.horizontalTweening = horizontalTweening;
	}

	public boolean isVerticalTweening()
	{
		return verticalTweening;
	}

	public void setVerticalTweening(boolean verticalTweening)
	{
		this.verticalTweening = verticalTweening;
	}

	public int getFrameInterval()
	{
		return frameInterval;
	}

	public void setFrameInterval(int frameInterval)
	{
		this.frameInterval = frameInterval;
		
		timer.setDelay(this.frameInterval);
	}

	public int getFrameCount()
	{
		return frameCount;
	}

	public void setFrameCount(int frameCount)
	{
		this.frameCount = frameCount;
	}
}