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

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.popupmenu.JDecorationPopupMenu;

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
		setMouseWheelEnabled(true);
	}
	
    protected JPopupMenu createPopupMenu(boolean properties, boolean copy, boolean save, boolean print, boolean zoom)
    {
    	JPopupMenu popupMenu = super.createPopupMenu(properties, copy, save, print, zoom);
    	
    	JMenuItem propertiesMenuItem = null;
    	if (properties)
		{
			propertiesMenuItem = getMenuItem(popupMenu, localizationResources.getString("Properties..."));
			propertiesMenuItem.setText(SwingLocale.getString("setting") + "    ");
			propertiesMenuItem.setIcon(IconFactory.getSwingIcon("edit.png"));
		}
    	
    	JMenuItem copyMenuItem = null;
    	if (copy)
    	{	
    		copyMenuItem = getMenuItem(popupMenu, localizationResources.getString("Copy"));
    		copyMenuItem.setIcon(IconFactory.getSwingIcon("copy.png"));
    	}
    	
    	JMenu exportMenu = null;
    	if (save)
    	{	
    		JMenuItem exportPNGMenuItem = getMenuItem(popupMenu, localizationResources.getString("Save_as..."));        
    		exportPNGMenuItem.setText("PNG " + SwingLocale.getString("image"));
    		exportPNGMenuItem.setIcon(IconFactory.getSwingIcon("image.png"));
    		
            JMenuItem exportPDFMenuItem = new JMenuItem();
            exportPDFMenuItem.setText("PDF " + SwingLocale.getString("file"));
            exportPDFMenuItem.setIcon(IconFactory.getSwingIcon("pdf.png"));
            exportPDFMenuItem.addActionListener(new ActionListener()
    		{
    			public void actionPerformed(ActionEvent e)
    			{
    				exportPDF();
    			}
    		}
    		);
            
    		exportMenu = new JMenu();
    		exportMenu.setText(SwingLocale.getString("export"));
    		exportMenu.setIcon(IconFactory.getSwingIcon("export.png"));
    		exportMenu.add(exportPDFMenuItem);
    		exportMenu.add(exportPNGMenuItem);
    	}
    	
    	JMenu zoomInMenu = null;
    	JMenu zoomOutMenu = null;
    	JMenu zoomResetMenu = null;
    	if (zoom)
    	{	
	        zoomInMenu = (JMenu) getMenuItem(popupMenu, localizationResources.getString("Zoom_In"));
	        zoomInMenu.setIcon(IconFactory.getSwingIcon("zoom_in.png"));
	        
	        zoomOutMenu = (JMenu) getMenuItem(popupMenu, localizationResources.getString("Zoom_Out"));
	        zoomOutMenu.setIcon(IconFactory.getSwingIcon("zoom_out.png"));
	        
	        zoomResetMenu = (JMenu) getMenuItem(popupMenu, localizationResources.getString("Auto_Range"));
	        zoomResetMenu.setText(SwingLocale.getString("zoom_restore"));
	        zoomResetMenu.setIcon(IconFactory.getSwingIcon("zoom.png"));
    	}
    	
    	JMenuItem printMenuItem = null;
    	if (print)
    	{	
	        printMenuItem = getMenuItem(popupMenu, localizationResources.getString("Print..."));
	        printMenuItem.setText(SwingLocale.getString("print"));
	        printMenuItem.setIcon(IconFactory.getSwingIcon("print.png"));
    	}
    	
		popupMenu.removeAll();
		
		JDecorationPopupMenu decorationPopupMenu = new JDecorationPopupMenu();
		
		if (properties)
		{	
			decorationPopupMenu.add(propertiesMenuItem);
		}
		if (copy)
		{	
			decorationPopupMenu.add(copyMenuItem);
		}
		if (save)
		{	
			decorationPopupMenu.add(exportMenu);
		}
		if(zoom)
		{	
			decorationPopupMenu.addSeparator();
			decorationPopupMenu.add(zoomInMenu);
			decorationPopupMenu.add(zoomOutMenu);
			decorationPopupMenu.add(zoomResetMenu);			
		}
		if (print)
		{	
			decorationPopupMenu.addSeparator();
			decorationPopupMenu.add(printMenuItem);
		}
		
		return decorationPopupMenu;
	}
	
	public void exportPDF()
	{
		if (chartPDFWriter == null)
		{
			chartPDFWriter = new ChartPDFWriter(JChartPanel.this);
		}
		chartPDFWriter.write(ChartContext.getChartPDFAuthor(), ChartContext.getChartPDFSubject());
	}
	
	public void exportPNG()
	{
		try
		{
			doSaveAs();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	private JMenuItem getMenuItem(JPopupMenu popupMenu, String text)
	{		
		for (int i = 0; i < popupMenu.getComponentCount(); i++)
		{
			Component component = popupMenu.getComponent(i);
			if (component instanceof JMenuItem)
			{
				JMenuItem menuItem = (JMenuItem) component;
				if (menuItem.getText().equals(text))
				{
					return menuItem;
				}	
			}	
		}
		
		return null;
	}
}