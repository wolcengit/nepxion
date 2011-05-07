package com.nepxion.cots.twaver.gis;

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

import java.awt.event.ActionEvent;

import javax.swing.AbstractButton;

import com.nepxion.cots.twaver.graph.TGraphKeyboardRegister;
import com.nepxion.cots.twaver.icon.TIconFactory;
import com.nepxion.swing.action.JSecurityAction;

public class TGisGraphController
{
	public static JSecurityAction getSelectAction(final TGisGraph gisGraph)
	{
		JSecurityAction action = new JSecurityAction("选择", TIconFactory.getContextIcon("select.png"), "选择")
		{
			public void execute(ActionEvent e)
			{
				AbstractButton button = (AbstractButton) e.getSource();
				if (button.isSelected())
				{
					TGisGraphManager.select(gisGraph);
				}
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getPanAction(final TGisGraph gisGraph)
	{
		JSecurityAction action = new JSecurityAction("拖动", TIconFactory.getContextIcon("pan.png"), "拖动")
		{
			public void execute(ActionEvent e)
			{
				AbstractButton button = (AbstractButton) e.getSource();
				if (button.isSelected())
				{
					TGisGraphManager.pan(gisGraph);
				}
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getZoomInAction(final TGisGraph gisGraph)
	{
		JSecurityAction action = new JSecurityAction("放大", TIconFactory.getContextIcon("zoom_in.png"), "放大")
		{
			public void execute(ActionEvent e)
			{
				AbstractButton button = (AbstractButton) e.getSource();
				if (button.isSelected())
				{
					TGisGraphManager.zoomIn(gisGraph);
				}
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getZoomOutAction(final TGisGraph gisGraph)
	{
		JSecurityAction action = new JSecurityAction("缩小", TIconFactory.getContextIcon("zoom_out.png"), "缩小")
		{
			public void execute(ActionEvent e)
			{
				AbstractButton button = (AbstractButton) e.getSource();
				if (button.isSelected())
				{
					TGisGraphManager.zoomOut(gisGraph);
				}
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getZoomResetAction(final TGisGraph gisGraph)
	{
		JSecurityAction action = new JSecurityAction("原始大小", TIconFactory.getContextIcon("zoom_reset.png"), "原始大小 Ctrl-O")
		{
			public void execute(ActionEvent e)
			{
				TGisGraphManager.zoomReset(gisGraph);
			}
		};
		TGraphKeyboardRegister.registerZoomReset(gisGraph, action);
		
		return action;
	}
	
	public static JSecurityAction getZoomBackAction(final TGisGraph gisGraph)
	{
		JSecurityAction action = new JSecurityAction("缩放后退", TIconFactory.getContextIcon("zoom.png"), "缩放后退")
		{
			public void execute(ActionEvent e)
			{
				TGisGraphManager.zoomBack(gisGraph);
			}
		};
		TGraphKeyboardRegister.registerZoomBack(gisGraph, action);
		
		return action;
	}
	
	public static JSecurityAction getNavigatorAction(final TGisGraph gisGraph)
	{
		JSecurityAction action = new JSecurityAction("导航器", TIconFactory.getContextIcon("navigator.png"), "导航器")
		{
			public void execute(ActionEvent e)
			{
				TGisGraphManager.navigator(gisGraph);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getDistanceAction(final TGisGraph gisGraph)
	{
		JSecurityAction action = new JSecurityAction("地图测量", TIconFactory.getContextIcon("distance.png"), "地图测量")
		{
			public void execute(ActionEvent e)
			{
				TGisGraphManager.distance(gisGraph);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getScaleAction(final TGisGraph gisGraph)
	{
		JSecurityAction action = new JSecurityAction("坐标和比例", TIconFactory.getContextIcon("scale.png"), "坐标和比例")
		{
			public void execute(ActionEvent e)
			{
				TGisGraphManager.scale(gisGraph);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getOverviewAction(final TGisGraph gisGraph)
	{
		JSecurityAction action = new JSecurityAction("鹰眼窗口", TIconFactory.getContextIcon("overview.png"), "鹰眼窗口")
		{
			public void execute(ActionEvent e)
			{
				TGisGraphManager.overview(gisGraph);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getMapTypeConfigAction(final TGisGraph gisGraph, final TMapType mapType)
	{
		JSecurityAction action = new JSecurityAction(mapType.toString(), "切换到 " + mapType)
		{
			public void execute(ActionEvent e)
			{
				TGisGraphManager.setMapType(gisGraph, mapType);
			}
		};
		
		return action;
	}
}