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

import twaver.TDataBox;
import twaver.gis.GeographyMap;
import twaver.gis.GisNetworkAdapter;

import com.nepxion.cots.twaver.element.TType;
import com.nepxion.cots.twaver.graph.TGraph;
import com.nepxion.cots.twaver.graph.TGraphToolBar;

public class TGisGraph
	extends TGraph
{
	private GisNetworkAdapter gisAdapter;
	
//	private MGisConfigPane configPane;
	
	public TGisGraph()
	{
		this(new TDataBox());
	}
	
	public TGisGraph(TDataBox dataBox)
	{
		this(dataBox, null);
	}
	
	public TGisGraph(TType type)
	{
		this(new TDataBox(), type);
	}
	
	public TGisGraph(TDataBox dataBox, TType type)
	{
		super(dataBox, type);
		
		initComponents();
	}
	
	private void initComponents()
	{
		gisAdapter = new GisNetworkAdapter(this);
		gisAdapter.installAdapter();
		
		new TGraphToolBar(this);
		new TGisGraphControlBarGenerator(this);
	}
	
	public GeographyMap getMap()
	{
		return gisAdapter.getMap();
	}
	
//	public MGisConfigPane getConfigPane()
//	{
//		if (configPane == null)
//		{
//			configPane = new MGisConfigPane();
//		}
//		
//		return configPane;
//	}
}