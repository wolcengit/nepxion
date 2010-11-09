package com.nepxion.swing.dialog;

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
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class DialogResizer
	extends ComponentAdapter
{
	private Dimension dimension;
	private Dimension minimumDimension;
	private Dimension maximumDimension;
	
	public DialogResizer()
	{
		this(null);
	}
	
	public DialogResizer(Dimension dimension)
	{
		this(dimension, null, null);
	}
	
	public DialogResizer(Dimension dimension, Dimension minimumDimension, Dimension maximumDimension)
	{
		this.dimension = dimension;
		this.minimumDimension = minimumDimension;
		this.maximumDimension = maximumDimension;
	}
	
	public Dimension getDimension()
	{
		return dimension;
	}
	
	public void setDimension(Dimension dimension)
	{
		this.dimension = dimension;
	}
	
	public Dimension getMinimumDimension()
	{
		return minimumDimension;
	}
	
	public void setMinimumDimension(Dimension minimumDimension)
	{
		this.minimumDimension = minimumDimension;
	}
	
	public Dimension getMaximumDimension()
	{
		return maximumDimension;
	}
	
	public void setMaximumDimension(Dimension maximumDimension)
	{
		this.maximumDimension = maximumDimension;
	}
	
	public void componentResized(ComponentEvent e)
	{
		Component component = (Component) e.getSource();
		Dimension size = component.getSize();
		
		if (dimension == null)
		{
			return;
		}
		
		if (minimumDimension != null)
		{
			if (size.width < minimumDimension.width || size.height < minimumDimension.height)
			{
				if (size.width < minimumDimension.width)
				{
					dimension.width = minimumDimension.width;
				}
				if (size.height < minimumDimension.height)
				{
					dimension.height = minimumDimension.height;
				}
				component.setSize(dimension);
			}
		}
		
		if (maximumDimension != null)
		{
			if (size.width > maximumDimension.width || size.height > maximumDimension.height)
			{
				if (size.width > maximumDimension.width)
				{
					dimension.width = maximumDimension.width;
				}
				if (size.height > maximumDimension.height)
				{
					dimension.height = maximumDimension.height;
				}
				component.setSize(dimension);
			}
		}
		
		if (minimumDimension == null && maximumDimension == null)
		{
			component.setSize(dimension);
		}
	}
}