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

import java.awt.event.ActionEvent;

import javax.swing.AbstractButton;

import com.nepxion.cots.twaver.element.TGroupType;
import com.nepxion.cots.twaver.icon.TIconFactory;
import com.nepxion.swing.action.JSecurityAction;

public class TGraphController
{
	public static JSecurityAction getSelectAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("选择", TIconFactory.getContextIcon("select.png"), "选择")
		{
			public void execute(ActionEvent e)
			{
				AbstractButton button = (AbstractButton) e.getSource();
				if (button.isSelected())
				{
					TGraphManager.select(graph);
				}
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getPanAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("拖动", TIconFactory.getContextIcon("pan.png"), "拖动")
		{
			public void execute(ActionEvent e)
			{
				AbstractButton button = (AbstractButton) e.getSource();
				if (button.isSelected())
				{
					TGraphManager.pan(graph);
				}
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getLazyMoveAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("延迟拖动", TIconFactory.getContextIcon("lazy_move.png"), "延迟拖动")
		{
			public void execute(ActionEvent e)
			{
				AbstractButton button = (AbstractButton) e.getSource();
				if (button.isSelected())
				{
					TGraphManager.layzMove(graph);
				}
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getZoomInAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("放大", TIconFactory.getContextIcon("zoom_in.png"), "放大 Ctrl +")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.zoomIn(graph);
			}
		};
		TGraphKeyboardRegister.registerZoomIn(graph, action);
		
		return action;
	}
	
	public static JSecurityAction getZoomOutAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("缩小", TIconFactory.getContextIcon("zoom_out.png"), "缩小 Ctrl -")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.zoomOut(graph);
			}
		};
		TGraphKeyboardRegister.registerZoomOut(graph, action);
		
		return action;
	}
	
	public static JSecurityAction getZoomInRectangleAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("矩形拉框放大", TIconFactory.getContextIcon("zoom_in_rectangle.png"), "矩形拉框放大")
		{
			public void execute(ActionEvent e)
			{
				AbstractButton button = (AbstractButton) e.getSource();
				if (button.isSelected())
				{
					TGraphManager.zoomInRectangle(graph);
				}
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getZoomResetAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("原始大小", TIconFactory.getContextIcon("zoom_reset.png"), "原始大小 Ctrl-O")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.zoomReset(graph);
			}
		};
		TGraphKeyboardRegister.registerZoomReset(graph, action);
		
		return action;
	}
	
	public static JSecurityAction getZoomToOverviewAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("适应屏幕", "适应屏幕")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.zoomToOverview(graph);
			}
		};
		TGraphKeyboardRegister.registerZoomToOverview(graph, action);
		
		return action;
	}
	
	public static JSecurityAction getZoomBackAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("缩放后退", "缩放后退")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.zoomBack(graph);
			}
		};
		TGraphKeyboardRegister.registerZoomBack(graph, action);
		
		return action;
	}
	
	public static JSecurityAction getMagnifierAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("放大镜", TIconFactory.getContextIcon("magnifier.png"), "放大镜")
		{
			public void execute(ActionEvent e)
			{
				AbstractButton button = (AbstractButton) e.getSource();
				if (button.isSelected())
				{
					TGraphManager.magnifier(graph);
				}
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getScaleAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("坐标和比例", TIconFactory.getContextIcon("scale.png"), "坐标和比例")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.scale(graph);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getFullScreenAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("全屏切换", TIconFactory.getContextIcon("fullscreen.png"), "全屏切换 F10")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.fullScreen(graph);
				if (e.getSource() instanceof AbstractButton)
				{
					AbstractButton button = (AbstractButton) e.getSource();
					button.getModel().setRollover(false);
				}
			}
		};
		TGraphKeyboardRegister.registerFullScreen(graph, action);
		
		return action;
	}
	
	public static JSecurityAction getOverviewAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("鹰眼窗口", TIconFactory.getContextIcon("overview.png"), "鹰眼窗口")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.overview(graph);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getAddAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("新建", TIconFactory.getContextIcon("new.png"), "新建图元 Ctrl+N")
		{
			public void execute(ActionEvent e)
			{
				graph.getAdapter().addElement();
			}
		};
		TGraphKeyboardRegister.registerNew(graph, action);
		
		return action;
	}
	
	public static JSecurityAction getDeleteAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("删除", TIconFactory.getContextIcon("delete.png"), "删除图元 Delete")
		{
			public void execute(ActionEvent e)
			{
				graph.getAdapter().deleteElement();
			}
		};
		TGraphKeyboardRegister.registerDelete(graph, action);
		
		return action;
	}
	
	public static JSecurityAction getClearAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("清空", TIconFactory.getContextIcon("clear.png"), "清空图元")
		{
			public void execute(ActionEvent e)
			{
				graph.getAdapter().clear();
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getRefreshAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("刷新", TIconFactory.getContextIcon("refresh.png"), "刷新 F5")
		{
			public void execute(ActionEvent e)
			{
				graph.getAdapter().refresh();
			}
		};
		TGraphKeyboardRegister.registerRefresh(graph, action);
		
		return action;
	}
	
	public static JSecurityAction getRenameAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("重命名", TIconFactory.getContextIcon("rename.png"), "重命名图元")
		{
			public void execute(ActionEvent e)
			{
				graph.getAdapter().renameElement();
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getSaveAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("保存", TIconFactory.getContextIcon("save.png"), "保存 Ctrl+S")
		{
			public void execute(ActionEvent e)
			{
				graph.getAdapter().save();
			}
		};
		TGraphKeyboardRegister.registerSave(graph, action);
		
		return action;
	}
	
	public static JSecurityAction getPropertyAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("属性", TIconFactory.getContextIcon("config.png"), "属性")
		{
			public void execute(ActionEvent e)
			{
				graph.getAdapter().modifyElement();
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getCopyAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("拷贝", TIconFactory.getContextIcon("copy.png"), "拷贝图元 Ctrl+C")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.copy(graph);
			}
		};
		TGraphKeyboardRegister.registerCopy(graph, action);
		
		return action;
	}
	
	public static JSecurityAction getPasteAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("粘帖", TIconFactory.getContextIcon("paste.png"), "粘帖图元 Ctrl+V")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.paste(graph);
			}
		};
		TGraphKeyboardRegister.registerPaste(graph, action);
		
		return action;
	}
	
	public static JSecurityAction getSelectAllAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("全选", TIconFactory.getContextIcon("select_all.png"), "全选图元 Ctrl+A")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.selectAll(graph);
			}
		};
		TGraphKeyboardRegister.registerSelectAll(graph, action);
		
		return action;
	}
	
	public static JSecurityAction getUndoAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("撤消", TIconFactory.getContextIcon("undo.png"), "撤消 Ctrl+Z")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.undo(graph);
			}
		};
		TGraphKeyboardRegister.registerUndo(graph, action);
		
		return action;
	}
	
	public static JSecurityAction getRedoAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("重做", TIconFactory.getContextIcon("redo.png"), "重做 Ctrl+Y")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.redo(graph);
			}
		};
		TGraphKeyboardRegister.registerRedo(graph, action);
		
		return action;
	}
	
	public static JSecurityAction getLabelConfigAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("标签设置", TIconFactory.getContextIcon("label.png"), "标签设置")
		{
			public void execute(ActionEvent e)
			{
				graph.getAdapter().labelConfig();
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getGroupTypeConfigAction(final TGraph graph, final TGroupType groupType)
	{
		JSecurityAction action = new JSecurityAction(groupType.toString(), "以" + groupType + "显示")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.setGroupType(graph, groupType);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getGroupExpandAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("组全部展开", "组全部展开")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.setGroupExpand(graph, true);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getGroupCollapseAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("组全部收缩", "组全部收缩")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.setGroupExpand(graph, false);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getLockAllAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("锁定全部节点", "锁定全部节点")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.setMovable(graph, false);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getUnLockAllAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("解锁全部节点", "解锁全部节点")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.setMovable(graph, true);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getLockSelectionAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("锁定选中节点", "锁定选中节点")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.lockSelection(graph, false);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getUnLockSelectionAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("解锁选中节点", "解锁选中节点")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.lockSelection(graph, true);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getHideChildrenAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("显示和隐藏子节点", TIconFactory.getContextIcon("hide.png"), "显示和隐藏子节点")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.hideChildren(graph);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getLayoutAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("布局器窗口", TIconFactory.getContextIcon("layout.png"), "布局器窗口")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.layout(graph);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getAlignLeftAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("左边对齐", TIconFactory.getContextIcon("align_left.png"), "左边对齐")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.alignLeft(graph);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getAlignVerticalCenterAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("纵向中央对齐", TIconFactory.getContextIcon("align_vertical_center.png"), "纵向中央对齐")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.alignVerticalCenter(graph);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getAlignRightAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("右边对齐", TIconFactory.getContextIcon("align_right.png"), "右边对齐")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.alignRight(graph);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getAlignTopAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("顶部对齐", TIconFactory.getContextIcon("align_top.png"), "顶部对齐")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.alignTop(graph);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getAlignHorizontalCenterAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("横向中央对齐", TIconFactory.getContextIcon("align_horizontal_center.png"), "横向中央对齐")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.alignHorizontalCenter(graph);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getAlignBottoJSecurityAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("底部对齐", TIconFactory.getContextIcon("align_bottom.png"), "底部对齐")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.alignBottom(graph);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getPileToLeftAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("左边堆列", TIconFactory.getContextIcon("pile_to_left.png"), "左边堆列")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.pileToLeft(graph);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getPileToRightAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("右边堆列", TIconFactory.getContextIcon("pile_to_right.png"), "右边堆列")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.pileToRight(graph);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getPileToTopAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("顶部堆列", TIconFactory.getContextIcon("pile_to_top.png"), "顶部堆列")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.pileToTop(graph);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getPileToBottoJSecurityAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("底部堆列", TIconFactory.getContextIcon("pile_to_bottom.png"), "底部堆列")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.pileToBottom(graph);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getSameWidthAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("等宽", TIconFactory.getContextIcon("same_width.png"), "等宽")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.sameWidth(graph);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getSameHeightAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("等高", TIconFactory.getContextIcon("same_height.png"), "等高")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.sameHeight(graph);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getSameHorizontalSpaceAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("横向等距", TIconFactory.getContextIcon("same_horizontal_space.png"), "横向等距")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.sameHorizontalSpace(graph);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getSameVerticalSpaceAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("纵向等距", TIconFactory.getContextIcon("same_vertical_space.png"), "纵向等距")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.sameVerticalSpace(graph);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getMoveToUpAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("上移一层", TIconFactory.getContextIcon("move_to_up.png"), "上移一层")
		{
			public void execute(ActionEvent e)
			{
				
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getMoveToDownAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("下移一层", TIconFactory.getContextIcon("move_to_down.png"), "下移一层")
		{
			public void execute(ActionEvent e)
			{
				
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getMoveToTopAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("移至最顶层", TIconFactory.getContextIcon("move_to_top.png"), "移至最顶层")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.moveToTop(graph);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getMoveToBottoJSecurityAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("移至最底层", TIconFactory.getContextIcon("move_to_bottom.png"), "移至最底层")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.moveToBottom(graph);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getImportAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("导入", TIconFactory.getContextIcon("import.png"), "导入XML文件 Ctrl+M")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.importXML(graph);
			}
		};
		TGraphKeyboardRegister.registerImport(graph, action);
		
		return action;
	}
	
	public static JSecurityAction getExportXMLAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("数据文件", TIconFactory.getContextIcon("xml.png"), "导出数据文件")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.exportXML(graph);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getExportExcelAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("表格文件", TIconFactory.getContextIcon("excel.png"), "导出表格文件")
		{
			public void execute(ActionEvent e)
			{
				
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getExportSVGAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("矢量文件", TIconFactory.getContextIcon("svg.png"), "矢量文件")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.exportSVG(graph);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getExportImageAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("图片文件", TIconFactory.getContextIcon("image.png"), "导出图片文件")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.exportImage(graph);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getStatAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("统计", TIconFactory.getContextIcon("stat.png"), "统计")
		{
			public void execute(ActionEvent e)
			{
				graph.getAdapter().stat();
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getPrintAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("打印", TIconFactory.getContextIcon("print.png"), "打印")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.print(graph);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getShowControlBarAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("显示操作面板", TIconFactory.getSwingIcon("toggle_size.png"), "显示操作面板")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.toggleControlBar(graph, true);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getHideControlBarAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("隐藏操作面板", TIconFactory.getSwingIcon("close_item.png"), "隐藏操作面板")
		{
			public void execute(ActionEvent e)
			{
				TGraphManager.toggleControlBar(graph, false);
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getToggleControlBarAction(final TGraph graph)
	{
		JSecurityAction action = new JSecurityAction("面板", TIconFactory.getContextIcon("pane.png"), "显示和隐藏操作面板")
		{
			public void execute(ActionEvent e)
			{
				if (graph.getControlBarInternalFrame().isVisible())
				{
					TGraphManager.toggleControlBar(graph, false);
				}
				else
				{
					TGraphManager.toggleControlBar(graph, true);
				}
			}
		};
		
		return action;
	}
	
	public static JSecurityAction getToggleControlBarAction(final TInternalFrame controlBarInternalFrame, final int selectedIndex)
	{
		final TGraphControlBar controlBar = (TGraphControlBar) controlBarInternalFrame.getContent();
		String title = controlBar.getTitleAt(selectedIndex);
		
		JSecurityAction action = new JSecurityAction(title, "切换到" + title)
		{
			public void execute(ActionEvent e)
			{
				if (!controlBarInternalFrame.isVisible())
				{
					controlBarInternalFrame.tween(true);
				}
				
				controlBar.setSelectedIndex(selectedIndex);
			}
		};
		
		return action;
	}
}