package com.nepxion.cots.twaver;

import java.awt.Color;

import javax.swing.JFrame;

import twaver.GeoCoordinate;
import twaver.TDataBox;
import twaver.gis.GeographyMap;

import com.nepxion.cots.twaver.element.TNode;
import com.nepxion.cots.twaver.gis.TGisGraph;
import com.nepxion.cots.twaver.graph.TGraph;
import com.nepxion.cots.twaver.graph.TGraphBackground;
import com.nepxion.cots.twaver.graph.TGraphPointBackground;
import com.nepxion.swing.lookandfeel.LookAndFeelManager;
import com.nepxion.swing.tabbedpane.JBasicTabbedPane;

public class TGraphTest
{
	private static TGraph createGraph()
	{
		TNode node = new TNode();
		node.setName("Nepxion");
		node.setLocation(300, 300);
		
		TDataBox dataBox = new TDataBox();
		dataBox.addElement(node);
		
		TGraph graph = new TGraph();
		graph.setDataBox(dataBox);
		
		TGraphPointBackground background = new TGraphPointBackground(Color.white, TGraphBackground.BLUE_STYLE_COLOR);
		background.setTitleAlignment(TGraphPointBackground.TOP);
		background.setTitle("Nepxion Cots");
		// background.setTitleColor(Color.black);
		// background.setTitleFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		
		graph.setBackground(background);
		
		return graph;
	}
	
	private static TGisGraph createGisGraph()
	{
		TNode node = new TNode();
		node.setName("Nepxion");
		node.setGeoCoordinate(new GeoCoordinate(118.795896, 32.088683));
		
		TDataBox dataBox = new TDataBox();
		dataBox.addElement(node);
		
		TGisGraph gisGraph = new TGisGraph();
		gisGraph.setDataBox(dataBox);
		
		GeographyMap map = gisGraph.getMap();
		map.setZoom(16);
		map.setCenterPoint(new GeoCoordinate(118.795896, 32.088683));
		
		return gisGraph;
	}
	
	public static void main(String[] args)
	{
		LookAndFeelManager.setNimbusLookAndFeel();
		
		TGraph graph = createGraph();
		
		TGisGraph gisGraph = createGisGraph();
		
		JBasicTabbedPane tabbedPane = new JBasicTabbedPane();
		tabbedPane.addTab("GIS", gisGraph);
		tabbedPane.addTab("Graph", graph);
		
		JFrame frame = new JFrame();
		frame.getContentPane().add(tabbedPane);
		frame.setSize(800, 600);
		frame.setVisible(true);
	}
}