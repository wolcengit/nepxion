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

import com.nepxion.swing.element.ElementNode;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.tabbedpane.JEclipseTabbedPane;

public class DemoDataFactory
{	
	public static ElementNode getRootElementNode()
	{
		return new ElementNode(1, "Nepxion", IconFactory.getSwingIcon("tray_java.png"), "Nepxion Swing", false, true);
	}
	
	public static List getComponentElementNodes()
	{
		// Button Control
		ElementNode buttonControlElementNode = new ElementNode(1, "Button Control", IconFactory.getSwingIcon("component/button_16.png"), "Button Control Component", false);		
		buttonControlElementNode.setEnabled(true);
		List buttonControlChildren = new ArrayList();
		buttonControlChildren.add(new ElementNode(1, "Button", IconFactory.getSwingIcon("component/button_16.png"), "Multi-style Button ToggleButton MenuButton & SplitButton"));
		buttonControlChildren.add(new ElementNode(2, "CheckBox", IconFactory.getSwingIcon("component/check_box_16.png"), "Multi-style CheckBox"));
		buttonControlChildren.add(new ElementNode(3, "RadioButton", IconFactory.getSwingIcon("component/radio_button_16.png"), "Multi-style RadioButton"));
		buttonControlChildren.add(new ElementNode(4, "ComboBox", IconFactory.getSwingIcon("component/combo_box_16.png"), "Multi-style ComboBox"));
		buttonControlElementNode.setChildren(buttonControlChildren);

		// Text Control
		ElementNode textControlElementNode = new ElementNode(2, "Text Control", IconFactory.getSwingIcon("component/text_pane_16.png"), "Text Control Component", true);		
		textControlElementNode.setEnabled(false);
		List textControlChildren = new ArrayList();
		textControlChildren.add(new ElementNode(1, "TextField", IconFactory.getSwingIcon("component/text_field_16.png"), "Multi-style TextField"));
		textControlChildren.add(new ElementNode(2, "TextArea", IconFactory.getSwingIcon("component/text_area_16.png"), "Multi-style TextArea"));
		textControlElementNode.setChildren(textControlChildren);		
		
		// Menu Control
		ElementNode menuControlElementNode = new ElementNode(3, "Menu Control", IconFactory.getSwingIcon("component/menu_16.png"), "Menu Control Component", false);		
		menuControlElementNode.setEnabled(true);
		List menuControlChildren = new ArrayList();
		menuControlChildren.add(new ElementNode(1, "Menu", IconFactory.getSwingIcon("component/menu_16.png"), "Multi-style Menu"));
		menuControlChildren.add(new ElementNode(2, "PopupMenu", IconFactory.getSwingIcon("component/popup_menu_16.png"), "Multi-style PopupMenu"));
		menuControlElementNode.setChildren(menuControlChildren);		
		
		// Border Control
		ElementNode borderControlElementNode = new ElementNode(4, "Border Control", IconFactory.getSwingIcon("component/split_pane_16.png"), "Border Control Component", true);
		borderControlElementNode.setEnabled(false);
		List borderControlChildren = new ArrayList();		
		borderControlElementNode.setChildren(borderControlChildren);
		
		// Container Control
		ElementNode containerControlElementNode = new ElementNode(5, "Container Control", IconFactory.getSwingIcon("component/internal_frame_16.png"), "Container Control Component", false);
		containerControlElementNode.setEnabled(true);
		List containerControlChildren = new ArrayList();
		containerControlChildren.add(new ElementNode(1, "Panel", IconFactory.getSwingIcon("component/panel_16.png"), "Multi-style Panel"));
		containerControlChildren.add(new ElementNode(2, "ScrollPane", IconFactory.getSwingIcon("component/scroll_pane_16.png"), "Multi-style ScrollPane"));		
		containerControlChildren.add(new ElementNode(3, "TabbedPane", IconFactory.getSwingIcon("component/tabbed_pane_16.png"), "Multi-style TabbedPane"));
		containerControlElementNode.setChildren(containerControlChildren);
		
		// Bar Control
		ElementNode barControlElementNode = new ElementNode(6, "Bar Control", IconFactory.getSwingIcon("component/tool_bar_16.png"), "Bar Control Component", true);
		barControlElementNode.setEnabled(false);
		List barControlChildren = new ArrayList();
		barControlChildren.add(new ElementNode(1, "TaskBar", IconFactory.getSwingIcon("component/tool_bar_16.png"), "Multi-style TaskBar"));
		barControlChildren.add(new ElementNode(2, "OutlookBar", IconFactory.getSwingIcon("component/tool_bar_16.png"), "Multi-style OutlookBar"));		
		barControlChildren.add(new ElementNode(3, "ButtonBar", IconFactory.getSwingIcon("component/tool_bar_16.png"), "Multi-style ButtonBar"));
		barControlChildren.add(new ElementNode(4, "StatusBar", IconFactory.getSwingIcon("component/tool_bar_16.png"), "Multi-style StatusBar"));
		barControlElementNode.setChildren(barControlChildren);		
		
		// Data Control
		ElementNode dataControlElementNode = new ElementNode(7, "Data Control", IconFactory.getSwingIcon("component/table_16.png"), "Data Control Component", false);
		dataControlElementNode.setEnabled(true);
		List dataControlChildren = new ArrayList();
		dataControlChildren.add(new ElementNode(1, "Tree", IconFactory.getSwingIcon("component/tree_16.png"), "Multi-style Tree"));
		dataControlChildren.add(new ElementNode(2, "Table", IconFactory.getSwingIcon("component/table_16.png"), "Multi-style Table"));		
		dataControlChildren.add(new ElementNode(3, "List", IconFactory.getSwingIcon("component/list_16.png"), "Multi-style List"));
		dataControlElementNode.setChildren(dataControlChildren);
		
		// Selector Control
		ElementNode selectorControlElementNode = new ElementNode(8, "Selector Control", IconFactory.getSwingIcon("component/file_chooser_16.png"), "Selector Control Component", true);
		selectorControlElementNode.setEnabled(false);
		List selectorControlChildren = new ArrayList();
		selectorControlChildren.add(new ElementNode(1, "Calendar", IconFactory.getSwingIcon("component/calendar_16.png"), "Multi-style Calendar Selector"));
		selectorControlChildren.add(new ElementNode(2, "Locale", IconFactory.getSwingIcon("component/locale_16.png"), "Multi-style Locale Selector"));		
		selectorControlChildren.add(new ElementNode(3, "File", IconFactory.getSwingIcon("component/file_chooser_16.png"), "Multi-style File Selector"));
		selectorControlChildren.add(new ElementNode(4, "Color", IconFactory.getSwingIcon("component/color_chooser_16.png"), "Multi-style Color Selector"));
		selectorControlChildren.add(new ElementNode(5, "DropDown", IconFactory.getSwingIcon("component/popup_menu_16.png"), "Multi-style DropDown Selector"));		
		selectorControlChildren.add(new ElementNode(6, "CheckBox", IconFactory.getSwingIcon("component/check_box_16.png"), "Multi-style CheckBox Selector"));
		selectorControlChildren.add(new ElementNode(7, "RadioButton", IconFactory.getSwingIcon("component/radio_button_16.png"), "Multi-style RadioButton Selector"));		
		selectorControlElementNode.setChildren(selectorControlChildren);	
		
		// Layout Control
		ElementNode layoutControlElementNode = new ElementNode(9, "Layout Control", IconFactory.getSwingIcon("component/layout_16.png"), "Layout Control Component", false);
		layoutControlElementNode.setEnabled(true);
		List layoutControlChildren = new ArrayList();
		layoutControlChildren.add(new ElementNode(1, "Table Layout", IconFactory.getSwingIcon("component/layout_16.png"), "Multi-style Table Layout"));
		layoutControlChildren.add(new ElementNode(2, "Filed Layout", IconFactory.getSwingIcon("component/layout_16.png"), "Multi-style Filed Layout"));		
		layoutControlChildren.add(new ElementNode(3, "Ratio Layout", IconFactory.getSwingIcon("component/layout_16.png"), "Multi-style Ratio Layout"));
		layoutControlChildren.add(new ElementNode(4, "XBorder Layout", IconFactory.getSwingIcon("component/layout_16.png"), "Multi-style XBorder Layout"));
		layoutControlChildren.add(new ElementNode(5, "XBox Layout", IconFactory.getSwingIcon("component/layout_16.png"), "Multi-style XBox Layout"));		
		layoutControlElementNode.setChildren(layoutControlChildren);
		
		// FrameWork Control
		ElementNode frameWorkControlElementNode = new ElementNode(10, "FrameWork Control", IconFactory.getSwingIcon("component/desktop_pane_16.png"), "FrameWork Control Component", true);
		frameWorkControlElementNode.setEnabled(false);
		List frameWorkControlChildren = new ArrayList();
		frameWorkControlChildren.add(new ElementNode(1, "Dockable", IconFactory.getSwingIcon("component/desktop_pane_16.png"), "Dockable FrameWork"));
		frameWorkControlChildren.add(new ElementNode(2, "VLDocking", IconFactory.getSwingIcon("component/desktop_pane_16.png"), "VLDocking Framework"));		
		frameWorkControlElementNode.setChildren(frameWorkControlChildren);
		
		// Advanced Control
		ElementNode advancedControlElementNode = new ElementNode(11, "Advanced Control", IconFactory.getSwingIcon("component/advanced_16.png"), "Advanced Control Component", false);
		advancedControlElementNode.setEnabled(true);
		List advancedControlChildren = new ArrayList();
		advancedControlChildren.add(new ElementNode(1, "UI Defaults", IconFactory.getSwingIcon("component/ui_defaults_16.png"), "UI Defaults Explorer"));		
		advancedControlElementNode.setChildren(advancedControlChildren);
		
		List componentElementNodes = new ArrayList();
		componentElementNodes.add(buttonControlElementNode);
		componentElementNodes.add(textControlElementNode);
		componentElementNodes.add(menuControlElementNode);
		componentElementNodes.add(borderControlElementNode);
		componentElementNodes.add(containerControlElementNode);
		componentElementNodes.add(barControlElementNode);
		componentElementNodes.add(dataControlElementNode);
		componentElementNodes.add(selectorControlElementNode);
		componentElementNodes.add(layoutControlElementNode);
		componentElementNodes.add(frameWorkControlElementNode);
		componentElementNodes.add(advancedControlElementNode);
		
		return componentElementNodes;
	}
	
	public static String[] getComponentNameColumns()
	{
		String[] columns = {"Index", "Text", "Icon", "ToolTipText", "Selected", "Enabled", "UserObject"};
		return columns;
	}
	
	public static String[] getComponentNameDatas()
	{
		List componentElementNodes = getComponentElementNodes();
		String[] componentNameDatas = new String[componentElementNodes.size()];
		int index = 0;
		for (Iterator iterator = componentElementNodes.iterator(); iterator.hasNext();)
		{
			componentNameDatas[index] = iterator.next().toString();
			index++;
		}	
		return componentNameDatas;
	}
	
	public static String[] getComponentDescriptonDatas()
	{
		List componentElementNodes = getComponentElementNodes();
		String[] componentDescriptonDatas = new String[componentElementNodes.size()];
		int index = 0;
		for (Iterator iterator = componentElementNodes.iterator(); iterator.hasNext();)
		{
			ElementNode elementNode = (ElementNode) iterator.next();
			StringBuffer stringBuffer = new StringBuffer();
			stringBuffer.append("Index : [");
			stringBuffer.append(elementNode.getIndex());
			stringBuffer.append("]\t");
			stringBuffer.append("Name : [");
			stringBuffer.append(elementNode.getText());
			stringBuffer.append("]\t");
			stringBuffer.append("TooTipText : [");
			stringBuffer.append(elementNode.getToolTipText());
			stringBuffer.append("]\t");
			componentDescriptonDatas[index] = stringBuffer.toString();
			index++;
		}	
		return componentDescriptonDatas;
	}	
    
	public static List getEclipseTabShapeElementNodes()
	{
		ElementNode defaultShapeElementNode = new ElementNode(JEclipseTabbedPane.SHAPE_DEFAULT, "Default Shape (Eclipse3X)", IconFactory.getSwingIcon("netbean/canvas_16.png"), "Default Shape (Eclipse3X)");
		ElementNode windowsShapeElementNode = new ElementNode(JEclipseTabbedPane.SHAPE_WINDOWS, "Windows Shape", IconFactory.getSwingIcon("netbean/canvas_16.png"), "Windows Shape");
		ElementNode vsNetShapeElementNode = new ElementNode(JEclipseTabbedPane.SHAPE_VSNET, "VSNet Shape", IconFactory.getSwingIcon("netbean/canvas_16.png"), "VSNet Shape");
		ElementNode boxShapeElementNode = new ElementNode(JEclipseTabbedPane.SHAPE_BOX, "Box Shape", IconFactory.getSwingIcon("netbean/canvas_16.png"), "Box Shape");
		ElementNode office2003ShapeElementNode = new ElementNode(JEclipseTabbedPane.SHAPE_OFFICE2003, "Office2003 Shape", IconFactory.getSwingIcon("netbean/canvas_16.png"), "Office2003 Shape");
		ElementNode flatShapeElementNode = new ElementNode(JEclipseTabbedPane.SHAPE_FLAT, "Flat Shape", IconFactory.getSwingIcon("netbean/canvas_16.png"), "Flat Shape");
		ElementNode eclipseShapeElementNode = new ElementNode(JEclipseTabbedPane.SHAPE_ECLIPSE, "Eclipse Shape", IconFactory.getSwingIcon("netbean/canvas_16.png"), "Eclipse Shape");
		ElementNode eclipse3XShapeElementNode = new ElementNode(JEclipseTabbedPane.SHAPE_ECLIPSE3X, "Eclipse3X Shape", IconFactory.getSwingIcon("netbean/canvas_16.png"), "Eclipse3X Shape");
		ElementNode excelShapeElementNode = new ElementNode(JEclipseTabbedPane.SHAPE_EXCEL, "Excel Shape", IconFactory.getSwingIcon("netbean/canvas_16.png"), "Excel Shape");
		ElementNode roundedVSNetShapeElementNode = new ElementNode(JEclipseTabbedPane.SHAPE_ROUNDED_VSNET, "VSNet Shape (Rounded Corner)", IconFactory.getSwingIcon("netbean/canvas_16.png"), "VSNet Shape (Rounded Corner)");
		ElementNode roundedFlatShapeElementNode = new ElementNode(JEclipseTabbedPane.SHAPE_ROUNDED_FLAT, "Flat Shape (Rounded)", IconFactory.getSwingIcon("netbean/canvas_16.png"), "Flat Shape (Rounded)");
		ElementNode windowsSelectedShapeElementNode = new ElementNode(JEclipseTabbedPane.SHAPE_WINDOWS_SELECTED, "Windows Shape (Selected Only)", IconFactory.getSwingIcon("netbean/canvas_16.png"), "Windows Shape (Selected Only)");
		
		List shapeElementNodes = new ArrayList();
		shapeElementNodes.add(defaultShapeElementNode);
		shapeElementNodes.add(windowsShapeElementNode);
		shapeElementNodes.add(vsNetShapeElementNode);
		shapeElementNodes.add(boxShapeElementNode);
		shapeElementNodes.add(office2003ShapeElementNode);
		shapeElementNodes.add(flatShapeElementNode);
		shapeElementNodes.add(eclipseShapeElementNode);
		shapeElementNodes.add(eclipse3XShapeElementNode);
		shapeElementNodes.add(excelShapeElementNode);
		shapeElementNodes.add(roundedVSNetShapeElementNode);
		shapeElementNodes.add(roundedFlatShapeElementNode);
		shapeElementNodes.add(windowsSelectedShapeElementNode);
		
		return shapeElementNodes;
	}
}