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

import com.nepxion.swing.common.InstallData;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.tabbedpane.JEclipseTabbedPane;

public class DemoDataFactory
{	
	public static InstallData getRootInstallData()
	{
		return new InstallData(1, "Nepxion", IconFactory.getSwingIcon("tray_java.png"), "Nepxion Swing", false, true);
	}
	
	public static List getComponentInstallDatas()
	{
		// Button Control
		InstallData buttonControlInstallData = new InstallData(1, "Button Control", IconFactory.getSwingIcon("component/button_16.png"), "Button Control Component", false, true);		
		List buttonControlChildren = new ArrayList();
		buttonControlChildren.add(new InstallData(1, "Button", IconFactory.getSwingIcon("component/button_16.png"), "Multi-style Button ToggleButton MenuButton & SplitButton"));
		buttonControlChildren.add(new InstallData(2, "CheckBox", IconFactory.getSwingIcon("component/check_box_16.png"), "Multi-style CheckBox"));
		buttonControlChildren.add(new InstallData(3, "RadioButton", IconFactory.getSwingIcon("component/radio_button_16.png"), "Multi-style RadioButton"));
		buttonControlChildren.add(new InstallData(4, "ComboBox", IconFactory.getSwingIcon("component/combo_box_16.png"), "Multi-style ComboBox"));
		buttonControlInstallData.setChildren(buttonControlChildren);

		// Text Control
		InstallData textControlInstallData = new InstallData(2, "Text Control", IconFactory.getSwingIcon("component/text_pane_16.png"), "Text Control Component", false, false);		
		List textControlChildren = new ArrayList();
		textControlChildren.add(new InstallData(1, "TextField", IconFactory.getSwingIcon("component/text_field_16.png"), "Multi-style TextField"));
		textControlChildren.add(new InstallData(2, "TextArea", IconFactory.getSwingIcon("component/text_area_16.png"), "Multi-style TextArea"));
		textControlInstallData.setChildren(textControlChildren);		
		
		// Menu Control
		InstallData menuControlInstallData = new InstallData(3, "Menu Control", IconFactory.getSwingIcon("component/menu_16.png"), "Menu Control Component", false, true);		
		List menuControlChildren = new ArrayList();
		menuControlChildren.add(new InstallData(1, "Menu", IconFactory.getSwingIcon("component/menu_16.png"), "Multi-style Menu"));
		menuControlChildren.add(new InstallData(2, "PopupMenu", IconFactory.getSwingIcon("component/popup_menu_16.png"), "Multi-style PopupMenu"));
		menuControlInstallData.setChildren(menuControlChildren);		
		
		// Border Control
		InstallData borderControlInstallData = new InstallData(4, "Border Control", IconFactory.getSwingIcon("component/split_pane_16.png"), "Border Control Component", false, false);
		List borderControlChildren = new ArrayList();		
		borderControlInstallData.setChildren(borderControlChildren);
		
		// Container Control
		InstallData containerControlInstallData = new InstallData(5, "Container Control", IconFactory.getSwingIcon("component/internal_frame_16.png"), "Container Control Component", false, true);
		List containerControlChildren = new ArrayList();
		containerControlChildren.add(new InstallData(1, "Panel", IconFactory.getSwingIcon("component/panel_16.png"), "Multi-style Panel"));
		containerControlChildren.add(new InstallData(2, "ScrollPane", IconFactory.getSwingIcon("component/scroll_pane_16.png"), "Multi-style ScrollPane"));		
		containerControlChildren.add(new InstallData(3, "TabbedPane", IconFactory.getSwingIcon("component/tabbed_pane_16.png"), "Multi-style TabbedPane"));
		containerControlInstallData.setChildren(containerControlChildren);
		
		// Bar Control
		InstallData barControlInstallData = new InstallData(6, "Bar Control", IconFactory.getSwingIcon("component/tool_bar_16.png"), "Bar Control Component", false, false);
		List barControlChildren = new ArrayList();
		barControlChildren.add(new InstallData(1, "TaskBar", IconFactory.getSwingIcon("component/tool_bar_16.png"), "Multi-style TaskBar"));
		barControlChildren.add(new InstallData(2, "OutlookBar", IconFactory.getSwingIcon("component/tool_bar_16.png"), "Multi-style OutlookBar"));		
		barControlChildren.add(new InstallData(3, "ButtonBar", IconFactory.getSwingIcon("component/tool_bar_16.png"), "Multi-style ButtonBar"));
		barControlChildren.add(new InstallData(4, "StatusBar", IconFactory.getSwingIcon("component/tool_bar_16.png"), "Multi-style StatusBar"));
		barControlInstallData.setChildren(barControlChildren);		
		
		// Data Control
		InstallData dataControlInstallData = new InstallData(7, "Data Control", IconFactory.getSwingIcon("component/table_16.png"), "Data Control Component", false, true);
		List dataControlChildren = new ArrayList();
		dataControlChildren.add(new InstallData(1, "Tree", IconFactory.getSwingIcon("component/tree_16.png"), "Multi-style Tree"));
		dataControlChildren.add(new InstallData(2, "Table", IconFactory.getSwingIcon("component/table_16.png"), "Multi-style Table"));		
		dataControlChildren.add(new InstallData(3, "List", IconFactory.getSwingIcon("component/list_16.png"), "Multi-style List"));
		dataControlInstallData.setChildren(dataControlChildren);
		
		// Selector Control
		InstallData selectorControlInstallData = new InstallData(8, "Selector Control", IconFactory.getSwingIcon("component/file_chooser_16.png"), "Selector Control Component", false, false);
		List selectorControlChildren = new ArrayList();
		selectorControlChildren.add(new InstallData(1, "Calendar", IconFactory.getSwingIcon("component/calendar_16.png"), "Multi-style Calendar Selector"));
		selectorControlChildren.add(new InstallData(2, "Locale", IconFactory.getSwingIcon("component/locale_16.png"), "Multi-style Locale Selector"));		
		selectorControlChildren.add(new InstallData(3, "File", IconFactory.getSwingIcon("component/file_chooser_16.png"), "Multi-style File Selector"));
		selectorControlChildren.add(new InstallData(4, "Color", IconFactory.getSwingIcon("component/color_chooser_16.png"), "Multi-style Color Selector"));
		selectorControlChildren.add(new InstallData(5, "DropDown", IconFactory.getSwingIcon("component/popup_menu_16.png"), "Multi-style DropDown Selector"));		
		selectorControlChildren.add(new InstallData(6, "CheckBox", IconFactory.getSwingIcon("component/check_box_16.png"), "Multi-style CheckBox Selector"));
		selectorControlChildren.add(new InstallData(7, "RadioButton", IconFactory.getSwingIcon("component/radio_button_16.png"), "Multi-style RadioButton Selector"));		
		selectorControlInstallData.setChildren(selectorControlChildren);	
		
		// Layout Control
		InstallData layoutControlInstallData = new InstallData(9, "Layout Control", IconFactory.getSwingIcon("component/layout_16.png"), "Layout Control Component", false, true);
		List layoutControlChildren = new ArrayList();
		layoutControlChildren.add(new InstallData(1, "Table Layout", IconFactory.getSwingIcon("component/layout_16.png"), "Multi-style Table Layout"));
		layoutControlChildren.add(new InstallData(2, "Filed Layout", IconFactory.getSwingIcon("component/layout_16.png"), "Multi-style Filed Layout"));		
		layoutControlChildren.add(new InstallData(3, "Ratio Layout", IconFactory.getSwingIcon("component/layout_16.png"), "Multi-style Ratio Layout"));
		layoutControlChildren.add(new InstallData(4, "XBorder Layout", IconFactory.getSwingIcon("component/layout_16.png"), "Multi-style XBorder Layout"));
		layoutControlChildren.add(new InstallData(5, "XBox Layout", IconFactory.getSwingIcon("component/layout_16.png"), "Multi-style XBox Layout"));		
		layoutControlInstallData.setChildren(layoutControlChildren);
		
		// FrameWork Control
		InstallData frameWorkControlInstallData = new InstallData(10, "FrameWork Control", IconFactory.getSwingIcon("component/desktop_pane_16.png"), "FrameWork Control Component", false, false);
		List frameWorkControlChildren = new ArrayList();
		frameWorkControlChildren.add(new InstallData(1, "Dockable", IconFactory.getSwingIcon("component/desktop_pane_16.png"), "Dockable FrameWork"));
		frameWorkControlChildren.add(new InstallData(2, "VLDocking", IconFactory.getSwingIcon("component/desktop_pane_16.png"), "VLDocking Framework"));		
		frameWorkControlInstallData.setChildren(frameWorkControlChildren);
		
		// Advanced Control
		InstallData advancedControlInstallData = new InstallData(11, "Advanced Control", IconFactory.getSwingIcon("component/advanced_16.png"), "Advanced Control Component", false, true);
		List advancedControlChildren = new ArrayList();
		advancedControlChildren.add(new InstallData(1, "UI Defaults", IconFactory.getSwingIcon("component/ui_defaults_16.png"), "UI Defaults Explorer"));		
		advancedControlInstallData.setChildren(advancedControlChildren);
		
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
	
	public static String[] getComponentNameColumns()
	{
		String[] columns = {"Index", "Text", "Icon", "ToolTipText", "UserObject", "Selected", "Enabled", "Children"};
		return columns;
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