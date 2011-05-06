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

import twaver.gis.TWaverGisConst;

import com.nepxion.cots.twaver.element.TType;

public class TMapType
	extends TType
{
	public static final TMapType GOOGLE_MAP_TYPE = new TMapType("Google 地图", TWaverGisConst.EXECUTOR_TYPE_GOOGLEMAP);
	public static final TMapType GOOGLE_SATELLITE_MAP_TYPE = new TMapType("Google 卫星图", TWaverGisConst.EXECUTOR_TYPE_GOOGLESATELLITEMAP);
	public static final TMapType GOOGLE_TERRAIN_MAP_TYPE = new TMapType("Google 地形图", TWaverGisConst.EXECUTOR_TYPE_GOOGLETERRAINMAP);
	public static final TMapType GOOGLE_LABEL_MAP_TYPE = new TMapType("Google 标签图", TWaverGisConst.EXECUTOR_TYPE_GOOGLELABELMAP);
	public static final TMapType MICROSOFT_BINT_MAP_TYPE = new TMapType("Microsoft 地图", TWaverGisConst.EXECUTOR_TYPE_BINGMAP);
	public static final TMapType OPENSTREET_MAP_TYPE = new TMapType("OpenStreet 地图", TWaverGisConst.EXECUTOR_TYPE_OPENSTREET);
	public static final TMapType ARCGIS_OGC_MAP_TYPE = new TMapType("ArcGIS 地图", TWaverGisConst.EXECUTOR_TYPE_ARCGIS_OGC);
	public static final TMapType ARCGIS_NOTILES_MAP_TYPE = new TMapType("ArcGIS 不分层地图", TWaverGisConst.EXECUTOR_TYPE_ARCGIS_NOTILES);
	public static final TMapType MAPINFO_OGC_MAP_TYPE = new TMapType("MapInfo 地图", TWaverGisConst.EXECUTOR_TYPE_MAPINFO_OGC);
	public static final TMapType MAPINFO_NOTILES_MAP_TYPE = new TMapType("MapInfo 不分层地图", TWaverGisConst.EXECUTOR_TYPE_MAPINFO_NOTILES);
	public static final TMapType MAPABC_MAP_TYPE = new TMapType("MapABC 地图", TWaverGisConst.EXECUTOR_TYPE_MAPABC);
	public static final TMapType TIANDITU_MAP_TYPE = new TMapType("天地图", TWaverGisConst.EXECUTOR_TYPE_TIANDITUMAP);
	public static final TMapType GEOSERVER_MAP_TYPE = new TMapType("GeoServer 地图", TWaverGisConst.EXECUTOR_TYPE_GEOSERVER);
	public static final TMapType GEOSERVER_NOTILES_MAP_TYPE = new TMapType("GeoServer 不分层地图", TWaverGisConst.EXECUTOR_TYPE_GEOSERVER_NOTILES);
	public static final TMapType GEOSERVER_CACHE_MAP_TYPE = new TMapType("GeoServer 缓存地图", TWaverGisConst.EXECUTOR_TYPE_GEOSERVER_CACHE);
	
	private int type;
	
	private TMapType(String name, int type)
	{
		super(name);
		
		this.type = type;
	}
	
	public int getType()
	{
		return type;
	}
}