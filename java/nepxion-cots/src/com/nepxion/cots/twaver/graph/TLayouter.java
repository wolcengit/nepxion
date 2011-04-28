package com.nepxion.cots.twaver.graph;

/**
 * <p>Title: Nepxion Cots For TWaver</p>
 * <p>Description: Nepxion Cots Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * <p>Announcement: It depends on the commercial software of TWaver, the repository only references the trial version.</p>
 * <p>If you want to use Nepxion Cots, please contact with Serva Corporation to buy the genuine version.</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.awt.Dimension;

import twaver.Element;
import twaver.Generator;
import twaver.Group;
import twaver.SpringLayouter;

public class TLayouter
{
	private TGraph graph;
	private SpringLayouter layouter;
	
	public TLayouter(TGraph graph)
	{
		this.graph = graph;
		this.layouter = graph.getSpringLayouter();
		
		setForceSize(100);
		setStepSize(500);
		setUpdateDuration(10);
	}
	
	public int getForceSize()
	{
		return layouter.getForceSize();
	}
	
	public void setForceSize(int forceSize)
	{
		layouter.setForceSize(forceSize);
	}
	
	public int getStepSize()
	{
		return layouter.getStepSize();
	}
	
	public void setStepSize(int stepSize)
	{
		layouter.setStepSize(stepSize);
	}
	
	public int getUpdateDuration()
	{
		return layouter.getUpdateDuration();
	}
	
	public void setUpdateDuration(int updateDuration)
	{
		layouter.setUpdateDuration(updateDuration);
	}
	
	public TGraph getGraph()
	{
		return graph;
	}
	
	public SpringLayouter getSpringLayouter()
	{
		return layouter;
	}
	
	public void start()
	{
		layouter.start();
	}
	
	public void stop()
	{
		layouter.stop();
	}
	
	public void doLayout(TLayoutType layoutType, boolean isAllElementsLayouted, boolean isAnimated, int xOffset, int yOffset, final int width, final int height)
	{
		if (layoutType.equals(TLayoutType.SPRING_LAYOUT_TYPE))
		{
			layouter.start();
		}
		else if (layoutType.equals(TLayoutType.RANDOM_LAYOUT_TYPE))
		{
			layouter.stop();
			layouter.random(0, 600);
		}
		else
		{
			layouter.stop();
			
			graph.doLayout(isAllElementsLayouted ? graph.getDataBox().getAllElements().iterator() : graph.getDataBox().getSelectionModel().getAllSelectedElement().iterator(), layoutType.getType(), isAnimated, null, xOffset, yOffset, new Generator()
			{
				public Object generate(Object object)
				{
					Element element = (Element) object;
					if (element instanceof Group)
					{
						return null;
					}
					
					return new Dimension(width, height);
				}
			}
			);
		}
	}
}