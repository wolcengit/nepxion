package com.nepxion.swing.chart;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPopupMenu;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.menuitem.JBasicMenuItem;

public class JChartPanel
	extends ChartPanel
{
	private ChartPDFWriter chartPDFWriter;
	
	public JChartPanel(JFreeChart chart)
	{
		super(chart);
		
		initComponents();
	}
	
	public JChartPanel(JFreeChart chart, boolean useBuffer)
	{
		super(chart, useBuffer);
		
		initComponents();
	}
	
	public JChartPanel(JFreeChart chart, boolean properties, boolean save, boolean print, boolean zoom, boolean tooltips)
	{
		super(chart, properties, save, print, zoom, tooltips);
		
		initComponents();
	}
	
	public JChartPanel(JFreeChart chart, int width, int height, int minimumDrawWidth, int minimumDrawHeight, int maximumDrawWidth, int maximumDrawHeight, boolean useBuffer, boolean properties, boolean save, boolean print, boolean zoom, boolean tooltips)
	{
		super(chart, width, height, minimumDrawWidth, minimumDrawHeight, maximumDrawWidth, maximumDrawHeight, useBuffer, properties, save, print, zoom, tooltips);
		
		initComponents();
	}
	
	public JChartPanel(JFreeChart chart, int width, int height, int minimumDrawWidth, int minimumDrawHeight, int maximumDrawWidth, int maximumDrawHeight, boolean useBuffer, boolean properties, boolean copy, boolean save, boolean print, boolean zoom, boolean tooltips)
	{
		super(chart, width, height, minimumDrawWidth, minimumDrawHeight, maximumDrawWidth, maximumDrawHeight, useBuffer, properties, copy, save, print, zoom, tooltips);
		
		initComponents();
	}
	
	private void initComponents()
	{
		initPopupMenu();
		initMouse();
	}
	
	private void initPopupMenu()
	{
		JBasicMenuItem pdfWriterMenuItem = new JBasicMenuItem(SwingLocale.getString("export_as"), SwingLocale.getString("export_as") + " PDF " + SwingLocale.getString("document"));
		pdfWriterMenuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (chartPDFWriter == null)
				{
					chartPDFWriter = new ChartPDFWriter(JChartPanel.this);
				}
				chartPDFWriter.write(ChartContext.getChartPDFAuthor(), ChartContext.getChartPDFSubject());
			}
		}
		);
		JPopupMenu popupMenu = getPopupMenu();
		int index = 0;
		if (popupMenu.getComponentCount() > 3)
		{
			index = 3;
		}
		popupMenu.add(pdfWriterMenuItem, index);
	}
	
	private void initMouse()
	{
		setMouseWheelEnabled(true);
	}
}