package com.nepxion.cots.twaver.graph;

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

import java.util.ArrayList;
import java.util.List;

import javax.swing.ListModel;

import com.nepxion.swing.element.ElementNode;
import com.nepxion.swing.handle.HandleManager;
import com.nepxion.swing.selector.checkbox.JCheckBoxSelector;

public class TExportDataConfig
{
	private JCheckBoxSelector selector;
	
	public TExportDataConfig(TGraph graph)
	{
		List elementNodes = new ArrayList();
		elementNodes.add(new ElementNode("保存图元编号", null, "保存图元编号", true));
		elementNodes.add(new ElementNode("保存图层", null, "保存图层", false));
		elementNodes.add(new ElementNode("保存告警状态 (应用于告警图形系统)", null, "保存告警状态 (应用于告警图形系统)", false));
		elementNodes.add(new ElementNode("保存当前子网 (应用于多级网络系统)", null, "保存当前子网 (应用于多级网络系统)", false));
		
		selector = new JCheckBoxSelector(HandleManager.getFrame(graph), "导出参数设置", elementNodes);
		selector.getCheckBoxListPanel().getList().setFixedCellHeight(22);
	}
	
	public JCheckBoxSelector getSelector()
	{
		return selector;
	}
	
	public boolean isSaveElementID()
	{
		return isElementNodeSelected(0);
	}
	
	public boolean isSaveLayers()
	{		
		return isElementNodeSelected(1);
	}
	
	public boolean isSaveAlarmState()
	{		
		return isElementNodeSelected(2);
	}
	
	public boolean isSaveCurrentSubNetwork()
	{		
		return isElementNodeSelected(3);
	}
	
	private boolean isElementNodeSelected(int index)
	{
		ListModel listModel = selector.getCheckBoxListPanel().getList().getModel();
		
		ElementNode elementNode = (ElementNode) listModel.getElementAt(index);
		
		return elementNode.isSelected();
	}
}