package com.nepxion.demo.common;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import com.nepxion.demo.control.advanced.DemoAdvancedControlOutlook;
import com.nepxion.demo.control.bar.DemoBarControlOutlook;
import com.nepxion.demo.control.border.DemoBorderControlOutlook;
import com.nepxion.demo.control.button.DemoButtonControlOutlook;
import com.nepxion.demo.control.container.DemoContainerControlOutlook;
import com.nepxion.demo.control.data.DemoDataControlOutlook;
import com.nepxion.demo.control.framework.DemoFrameWorkControlOutlook;
import com.nepxion.demo.control.layout.DemoLayoutControlOutlook;
import com.nepxion.demo.control.menu.DemoMenuControlOutlook;
import com.nepxion.demo.control.selector.DemoSelectorControlOutlook;
import com.nepxion.demo.control.text.DemoTextControlOutlook;
import com.nepxion.swing.common.InstallData;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.popupmenu.JDecorationPopupMenu;
import com.nepxion.swing.tabbedpane.JEclipseTabbedPane;

public class DemoDataFactory
{
	private static Map componentMap;
	
	public static String[] getComponentNameDatas()
	{
		List componentInstallDatas = getComponentInstallDatas();
		String[] componentNameDatas = new String[componentInstallDatas.size()];
		int index = 0;
		for (Iterator iterator = componentInstallDatas.iterator(); iterator.hasNext();)
		{
			componentNameDatas[index] = iterator.next().toString();
			index++;
		}	
		return componentNameDatas;
	}
	
	public static String[] getComponentDescriptonDatas()
	{
		List componentInstallDatas = getComponentInstallDatas();
		String[] componentDescriptonDatas = new String[componentInstallDatas.size()];
		int index = 0;
		for (Iterator iterator = componentInstallDatas.iterator(); iterator.hasNext();)
		{
			InstallData installData = (InstallData) iterator.next();
			StringBuffer stringBuffer = new StringBuffer();
			stringBuffer.append("Index : [");
			stringBuffer.append(installData.getIndex());
			stringBuffer.append("]\t");
			stringBuffer.append("Name : [");
			stringBuffer.append(installData.getText());
			stringBuffer.append("]\t");
			stringBuffer.append("TooTipText : [");
			stringBuffer.append(installData.getToolTipText());
			stringBuffer.append("]\t");
			componentDescriptonDatas[index] = stringBuffer.toString();
			index++;
		}	
		return componentDescriptonDatas;
	}	
	
	public static List getComponentInstallDatas()
	{
		InstallData buttonControlInstallData = new InstallData(1, "Button Control", IconFactory.getSwingIcon("component/button_16.png"), "Button Control Component", "Category", false, true);
		InstallData textControlInstallData = new InstallData(2, "Text Control", IconFactory.getSwingIcon("component/text_pane_16.png"), "Text Control Component", "Category", false, false);
		InstallData menuControlInstallData = new InstallData(3, "Menu Control", IconFactory.getSwingIcon("component/menu_16.png"), "Menu Control Component", "Category", false, true);
		InstallData borderControlInstallData = new InstallData(4, "Border Control", IconFactory.getSwingIcon("component/split_pane_16.png"), "Border Control Component", "Category", false, false);
		InstallData containerControlInstallData = new InstallData(5, "Container Control", IconFactory.getSwingIcon("component/internal_frame_16.png"), "Container Control Component", "Category", false, true);
		InstallData barControlInstallData = new InstallData(6, "Bar Control", IconFactory.getSwingIcon("component/tool_bar_16.png"), "Bar Control Component", "Category", false, false);
		InstallData dataControlInstallData = new InstallData(7, "Data Control", IconFactory.getSwingIcon("component/table_16.png"), "Data Control Component", "Category", false, true);
		InstallData selectorControlInstallData = new InstallData(8, "Selector Control", IconFactory.getSwingIcon("component/file_chooser_16.png"), "Selector Control Component", "Category", false, false);
		InstallData layoutControlInstallData = new InstallData(9, "Layout Control", IconFactory.getSwingIcon("component/layout_16.png"), "Layout Control Component", "Category", false, true);
		InstallData frameWorkControlInstallData = new InstallData(10, "FrameWork Control", IconFactory.getSwingIcon("component/desktop_pane_16.png"), "FrameWork Control Component", "Category", false, false);
		InstallData advancedControlInstallData = new InstallData(11, "Advanced Control", IconFactory.getSwingIcon("component/advanced_16.png"), "Advanced Control Component", "Category", false, true);
		
		List componentInstallDatas = new ArrayList();
		componentInstallDatas.add(buttonControlInstallData);
		componentInstallDatas.add(textControlInstallData);
		componentInstallDatas.add(menuControlInstallData);
		componentInstallDatas.add(borderControlInstallData);
		componentInstallDatas.add(containerControlInstallData);
		componentInstallDatas.add(barControlInstallData);
		componentInstallDatas.add(dataControlInstallData);
		componentInstallDatas.add(selectorControlInstallData);
		componentInstallDatas.add(layoutControlInstallData);
		componentInstallDatas.add(frameWorkControlInstallData);
		componentInstallDatas.add(advancedControlInstallData);
		
		return componentInstallDatas;
	}
	
	public static Map getComponentMap()
	{
		if (componentMap == null)
		{
			componentMap = new HashMap();
			
			componentMap.put("Button Control", new DemoButtonControlOutlook());
			componentMap.put("Text Control", new DemoTextControlOutlook());
			componentMap.put("Menu Control", new DemoMenuControlOutlook());
			componentMap.put("Border Control", new DemoBorderControlOutlook());
			componentMap.put("Container Control", new DemoContainerControlOutlook());
			componentMap.put("Bar Control", new DemoBarControlOutlook());
			componentMap.put("Data Control", new DemoDataControlOutlook());
			componentMap.put("Selector Control", new DemoSelectorControlOutlook());
			componentMap.put("Layout Control", new DemoLayoutControlOutlook());
			componentMap.put("FrameWork Control", new DemoFrameWorkControlOutlook());
			componentMap.put("Advanced Control", new DemoAdvancedControlOutlook());
		}
		return componentMap;
	}
    
	public static List getEclipseTabShapeInstallDatas()
	{
		InstallData defaultShapeInstallData = new InstallData(JEclipseTabbedPane.SHAPE_DEFAULT, "Default Shape (Eclipse3X)", IconFactory.getSwingIcon("netbean/canvas_16.png"), "Default Shape (Eclipse3X)");
		InstallData windowsShapeInstallData = new InstallData(JEclipseTabbedPane.SHAPE_WINDOWS, "Windows Shape", IconFactory.getSwingIcon("netbean/canvas_16.png"), "Windows Shape");
		InstallData vsNetShapeInstallData = new InstallData(JEclipseTabbedPane.SHAPE_VSNET, "VSNet Shape", IconFactory.getSwingIcon("netbean/canvas_16.png"), "VSNet Shape");
		InstallData boxShapeInstallData = new InstallData(JEclipseTabbedPane.SHAPE_BOX, "Box Shape", IconFactory.getSwingIcon("netbean/canvas_16.png"), "Box Shape");
		InstallData office2003ShapeInstallData = new InstallData(JEclipseTabbedPane.SHAPE_OFFICE2003, "Office2003 Shape", IconFactory.getSwingIcon("netbean/canvas_16.png"), "Office2003 Shape");
		InstallData flatShapeInstallData = new InstallData(JEclipseTabbedPane.SHAPE_FLAT, "Flat Shape", IconFactory.getSwingIcon("netbean/canvas_16.png"), "Flat Shape");
		InstallData eclipseShapeInstallData = new InstallData(JEclipseTabbedPane.SHAPE_ECLIPSE, "Eclipse Shape", IconFactory.getSwingIcon("netbean/canvas_16.png"), "Eclipse Shape");
		InstallData eclipse3XShapeInstallData = new InstallData(JEclipseTabbedPane.SHAPE_ECLIPSE3X, "Eclipse3X Shape", IconFactory.getSwingIcon("netbean/canvas_16.png"), "Eclipse3X Shape");
		InstallData excelShapeInstallData = new InstallData(JEclipseTabbedPane.SHAPE_EXCEL, "Excel Shape", IconFactory.getSwingIcon("netbean/canvas_16.png"), "Excel Shape");
		InstallData roundedVSNetShapeInstallData = new InstallData(JEclipseTabbedPane.SHAPE_ROUNDED_VSNET, "VSNet Shape (Rounded Corner)", IconFactory.getSwingIcon("netbean/canvas_16.png"), "VSNet Shape (Rounded Corner)");
		InstallData roundedFlatShapeInstallData = new InstallData(JEclipseTabbedPane.SHAPE_ROUNDED_FLAT, "Flat Shape (Rounded)", IconFactory.getSwingIcon("netbean/canvas_16.png"), "Flat Shape (Rounded)");
		InstallData windowsSelectedShapeInstallData = new InstallData(JEclipseTabbedPane.SHAPE_WINDOWS_SELECTED, "Windows Shape (Selected Only)", IconFactory.getSwingIcon("netbean/canvas_16.png"), "Windows Shape (Selected Only)");
		
		List shapeInstallDatas = new ArrayList();
		shapeInstallDatas.add(defaultShapeInstallData);
		shapeInstallDatas.add(windowsShapeInstallData);
		shapeInstallDatas.add(vsNetShapeInstallData);
		shapeInstallDatas.add(boxShapeInstallData);
		shapeInstallDatas.add(office2003ShapeInstallData);
		shapeInstallDatas.add(flatShapeInstallData);
		shapeInstallDatas.add(eclipseShapeInstallData);
		shapeInstallDatas.add(eclipse3XShapeInstallData);
		shapeInstallDatas.add(excelShapeInstallData);
		shapeInstallDatas.add(roundedVSNetShapeInstallData);
		shapeInstallDatas.add(roundedFlatShapeInstallData);
		shapeInstallDatas.add(windowsSelectedShapeInstallData);
		
		return shapeInstallDatas;
	}
	
	public static JDecorationPopupMenu createDecorationPopupMenu()
	{
		JDecorationPopupMenu decorationPopupMenu = new JDecorationPopupMenu();
		
		JMenu menu1 = new JMenu("Menu");
		menu1.setIcon(IconFactory.getSwingIcon("component/menu_16.png"));
		menu1.add(new JMenuItem("MenuItem", IconFactory.getSwingIcon("component/menu_16.png")));
		menu1.add(new JMenuItem("MenuItem", IconFactory.getSwingIcon("component/menu_16.png")));
		decorationPopupMenu.add(menu1);
		
		JMenu menu2 = new JMenu("Menu");
		menu2.setIcon(IconFactory.getSwingIcon("component/popup_menu_16.png"));
		menu2.add(new JMenuItem("MenuItem", IconFactory.getSwingIcon("component/popup_menu_16.png")));
		menu2.add(new JMenuItem("MenuItem", IconFactory.getSwingIcon("component/popup_menu_16.png")));
		decorationPopupMenu.add(menu2);
		
		decorationPopupMenu.addSeparator();
		
		JMenu menu3 = new JMenu("Menu");
		menu3.setIcon(IconFactory.getSwingIcon("component/list_16.png"));
		menu3.add(new JMenuItem("MenuItem", IconFactory.getSwingIcon("component/list_16.png")));
		menu3.add(new JMenuItem("MenuItem", IconFactory.getSwingIcon("component/list_16.png")));
		decorationPopupMenu.add(menu3);
		
		return decorationPopupMenu;
	}	
}