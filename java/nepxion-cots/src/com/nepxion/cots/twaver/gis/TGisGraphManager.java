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

import twaver.gis.GeographyMap;
import twaver.gis.utils.GisInputHandlerFactory;
import twaver.gis.utils.GisToolkits;

import com.nepxion.cots.twaver.graph.TGraph;

public class TGisGraphManager
{
    // 选择模式
    public static void select(TGisGraph gisGraph)
    {
        GeographyMap map = gisGraph.getMap();
        if (map != null)
        {
            gisGraph.setInteractionMode(GisInputHandlerFactory.createDefaultMode(gisGraph, map));
            
            //GisInputHandlerFactory.createSelectMode(gisGraph, map);
        }
    }

    // 拖动模式
    public static void pan(TGisGraph gisGraph)
    {
        GeographyMap map = gisGraph.getMap();
        if (map != null)
        {
            gisGraph.setInteractionMode(GisInputHandlerFactory.createPanMode(gisGraph, map));
            gisGraph.getCanvas().setCursor(TGraph.PAN_CURSOR);
        }
    }

    // 放大
    public static void zoomIn(TGisGraph gisGraph)
    {
        GeographyMap map = gisGraph.getMap();
        if (map != null)
        {
            gisGraph.setInteractionMode(GisInputHandlerFactory.createZoomMode(gisGraph, map,GeographyMap.MAPMODE_ZOOMIN));
            gisGraph.getCanvas().setCursor(TGraph.ZOOM_IN_CURSOR);
        }
    }

    // 缩小
    public static void zoomOut(TGisGraph gisGraph)
    {
        GeographyMap map = gisGraph.getMap();
        if (map != null)
        {
            gisGraph.setInteractionMode(GisInputHandlerFactory.createZoomMode(gisGraph, map,GeographyMap.MAPMODE_ZOOMOUT));
            gisGraph.getCanvas().setCursor(TGraph.ZOOM_OUT_CURSOR);
        }
    }

    // 拉框放大模式
    public static void zoomInRectangle(TGisGraph gisGraph)
    {
        GeographyMap map = gisGraph.getMap();
        if (map != null)
        {
            gisGraph.setInteractionMode(GisInputHandlerFactory.createZoomMode(gisGraph, map, GeographyMap.MAPMODE_ZOOMIN_BYSCALE));
            gisGraph.getCanvas().setCursor(TGraph.ZOOM_IN_RECTANGLE_CURSOR);
        }
    }

    // 实际大小
    public static void zoomReset(TGisGraph gisGraph)
    {
        GeographyMap map = gisGraph.getMap();
        if (map != null)
        {
            gisGraph.setInteractionMode(GisInputHandlerFactory.createResetMode(gisGraph, map));
        }
    }

    // 缩放后退
    public static void zoomBack(TGisGraph gisGraph)
    {
        GeographyMap map = gisGraph.getMap();
        if (map != null)
        {
            GisToolkits.goBack(gisGraph, map);
        }
    }

    // 测量地图
    public static void distance(TGisGraph gisGraph)
    {
        GeographyMap map = gisGraph.getMap();
        if (map != null)
        {
            gisGraph.setInteractionMode(GisInputHandlerFactory.createDistanceMode(gisGraph, map));
        }
    }

    // 坐标和比例显示
    public static void scale(TGisGraph gisGraph)
    {
//        MInternalFrame scaleInternalFrame = gisGraph.getScaleInternalFrame();
//        if (scaleInternalFrame == null)
//        {
//            MGisScaleBar scaleBar = new MGisScaleBar(gisGraph);
//            scaleBar.setPreferredSize(new Dimension(500, 20));
//            scaleInternalFrame = new MInternalFrame(gisGraph, "坐标和比例", IconFactory.getGraphicsIcon("scale.png"), scaleBar);
//
//            scaleInternalFrame.setResizable(false);
//            gisGraph.getLayeredPane().add(scaleInternalFrame);
//            gisGraph.setScaleInternalFrame(scaleInternalFrame);
//            scaleInternalFrame.setLocation(0, gisGraph.getViewport().getHeight() - scaleInternalFrame.getHeight() + 2);
//        }
//        if (!scaleInternalFrame.isVisible())
//        {
//            AnimationInvoker.show(scaleInternalFrame, 1, 20, true, false);
//        }
//        else
//        {
//            scaleInternalFrame.setVisible(false);
//        }
    }

    // 鹰眼展示
    public static void overview(TGisGraph view)
    {
//        MOverview overview = view.getOverview();
//		if (overview == null)
//		{
//			overview = new MOverview(view, "鹰眼", new Dimension(150, 150), IconFactory.getGraphicsIcon("overview.png"));
//			view.getLayeredPane().add(overview);
//			view.setOverview(overview);
//			overview.setLocation(view.getViewport().getWidth() - overview.getWidth() + 2, view.getViewport().getHeight() - overview.getHeight() + 2);
//		}
//		if (!overview.isVisible())
//		{
//			overview.setVisible(true);
//			// AnimationInvoker.show(overview, 1, 20, true, true);
//		}
//		else
//		{
//			overview.setVisible(false);
//		}
    }

    public static void config(TGisGraph gisGraph)
    {
//        MGisConfigPane configPane = gisGraph.getConfigPane();
//        JVerifyOptionPane.showDialog(HandleFactory.getFrame(gisGraph), configPane, "设置", null, new Object[] {"关闭"});
    }
}