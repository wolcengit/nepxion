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
import java.util.Iterator;
import java.util.List;

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
import com.nepxion.swing.tabbedpane.JEclipseTabbedPane;

public class DemoDataFactory
{	
	public static List getComponentInstallDatas()
	{
		InstallData buttonControlInstallData = new InstallData(1, "Button Control", IconFactory.getSwingIcon("component/button_16.png"), "Button Control Component", DemoButtonControlOutlook.class.getName(), false, true);
		
		List buttonControlChildren = new ArrayList();
		buttonControlChildren.add(new InstallData(1, "Button", IconFactory.getSwingIcon("component/button_32.png"), "Multi-style Button ToggleButton MenuButton & SplitButton"));
		buttonControlChildren.add(new InstallData(2, "CheckBox", IconFactory.getSwingIcon("component/check_box_32.png"), "Multi-style CheckBox"));
		buttonControlInstallData.setChildren(buttonControlChildren);
		
		InstallData textControlInstallData = new InstallData(2, "Text Control", IconFactory.getSwingIcon("component/text_pane_16.png"), "Text Control Component", DemoTextControlOutlook.class.getName(), false, false);
		InstallData menuControlInstallData = new InstallData(3, "Menu Control", IconFactory.getSwingIcon("component/menu_16.png"), "Menu Control Component", DemoMenuControlOutlook.class.getName(), false, true);
		InstallData borderControlInstallData = new InstallData(4, "Border Control", IconFactory.getSwingIcon("component/split_pane_16.png"), "Border Control Component", DemoBorderControlOutlook.class.getName(), false, false);
		InstallData containerControlInstallData = new InstallData(5, "Container Control", IconFactory.getSwingIcon("component/internal_frame_16.png"), "Container Control Component", DemoContainerControlOutlook.class.getName(), false, true);
		InstallData barControlInstallData = new InstallData(6, "Bar Control", IconFactory.getSwingIcon("component/tool_bar_16.png"), "Bar Control Component", DemoBarControlOutlook.class.getName(), false, false);
		InstallData dataControlInstallData = new InstallData(7, "Data Control", IconFactory.getSwingIcon("component/table_16.png"), "Data Control Component", DemoDataControlOutlook.class.getName(), false, true);
		InstallData selectorControlInstallData = new InstallData(8, "Selector Control", IconFactory.getSwingIcon("component/file_chooser_16.png"), "Selector Control Component", DemoSelectorControlOutlook.class.getName(), false, false);
		InstallData layoutControlInstallData = new InstallData(9, "Layout Control", IconFactory.getSwingIcon("component/layout_16.png"), "Layout Control Component", DemoLayoutControlOutlook.class.getName(), true);
		InstallData frameWorkControlInstallData = new InstallData(10, "FrameWork Control", IconFactory.getSwingIcon("component/desktop_pane_16.png"), "FrameWork Control Component", DemoFrameWorkControlOutlook.class.getName(), false, false);
		InstallData advancedControlInstallData = new InstallData(11, "Advanced Control", IconFactory.getSwingIcon("component/advanced_16.png"), "Advanced Control Component", DemoAdvancedControlOutlook.class.getName(), false, true);
		
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
}