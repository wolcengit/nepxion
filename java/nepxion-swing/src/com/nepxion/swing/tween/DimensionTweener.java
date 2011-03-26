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

public class DimensionTweener
	implements ActionListener
{
	private JComponent component;
	private Dimension dimension;
	private Dimension componentDimension;
	
	private boolean zoomIn = true;
	private boolean horizontalTweening = true;
	private boolean verticalTweening = true;
	
	private int frameInterval = 1;
	private int frameCount = 20;
	private int frameIndex = 0;
	
	private Timer timer;
	
	public DimensionTweener(JComponent component, Dimension dimension, boolean zoomIn)
	{
		this(component, dimension, zoomIn, true, true);
	}
	
	public DimensionTweener(JComponent component, Dimension dimension, boolean zoomIn, int frameInterval, int frameCount)
	{
		this(component, dimension, zoomIn, true, true, frameInterval, frameCount);
	}
	
	public DimensionTweener(JComponent component, Dimension dimension, boolean zoomIn, boolean horizontalTweening, boolean verticalTweening)
	{
		this(component, dimension, zoomIn, horizontalTweening, verticalTweening, 1, 20);
	}
	
	public DimensionTweener(JComponent component, Dimension dimension, boolean zoomIn, boolean horizontalTweening, boolean verticalTweening, int frameInterval, int frameCount)
	{
		if (zoomIn)
		{
			if (component.getSize().width > dimension.width || component.getSize().height > dimension.height)
			{
				throw new IllegalArgumentException("Invalid dimension inputting to zoom in");
			}
		}
		else
		{
			if (component.getSize().width < dimension.width || component.getSize().height < dimension.height)
			{
				throw new IllegalArgumentException("Invalid dimension inputting to zoom out");
			}
		}
		
		this.component = component;
		this.dimension = dimension;
		this.componentDimension = component.getSize();
			
		this.zoomIn = zoomIn;
		this.horizontalTweening = horizontalTweening;
		this.verticalTweening = verticalTweening;
		
		this.frameInterval = frameInterval;
		this.frameCount = frameCount;
		
		timer = new Timer(this.frameInterval, this);
	}
	
	public void tween()
	{
		timer.start();
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if (zoomIn)
		{
			component.setSize(new Dimension(horizontalTweening ? componentDimension.width + (dimension.width - componentDimension.width) * frameIndex / frameCount : componentDimension.width, verticalTweening ? componentDimension.height + (dimension.height - componentDimension.height) * frameIndex / frameCount : componentDimension.height));
		}
		else
		{
			component.setSize(new Dimension(horizontalTweening ? componentDimension.width + (dimension.width - componentDimension.width) * frameIndex / frameCount : componentDimension.width, verticalTweening ? componentDimension.height + (dimension.height - componentDimension.height) * frameIndex / frameCount : componentDimension.height));
		}
		
		if (frameIndex == frameCount)
		{				
			timer.stop();
		}
		else
		{
			frameIndex++;
		}
	}
}