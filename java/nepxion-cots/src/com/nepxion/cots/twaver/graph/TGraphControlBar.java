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

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;

import com.nepxion.cots.twaver.element.TDataBoxUndoRedoAdapter;
import com.nepxion.cots.twaver.element.TGroupType;
import com.nepxion.cots.twaver.icon.TIconFactory;
import com.nepxion.swing.action.JSecurityAction;
import com.nepxion.swing.button.ButtonManager;
import com.nepxion.swing.button.JBasicButton;
import com.nepxion.swing.button.JBasicMenuButton;
import com.nepxion.swing.button.JBasicToggleButton;
import com.nepxion.swing.layout.table.TableLayout;
import com.nepxion.swing.menuitem.JBasicMenuItem;
import com.nepxion.swing.outlookbar.JFlatOutlook;
import com.nepxion.swing.outlookbar.JFlatOutlookBar;
import com.nepxion.swing.popupmenu.JDecorationPopupMenu;

public class TGraphControlBar
	extends JFlatOutlookBar
{
	private TGraph graph;
	
	private GraphToolBar graphToolBar;
	private NodeOperationToolBar nodeOperationToolBar;
	private NodeEditionToolBar nodeEditionToolBar;
	private IOToolBar ioToolBar;
	
	public TGraphControlBar(TGraph graph)
	{
		this.graph = graph;
		
		graphToolBar = new GraphToolBar();
		nodeOperationToolBar = new NodeOperationToolBar();
		nodeEditionToolBar = new NodeEditionToolBar();
		ioToolBar = new IOToolBar();
		
		addTab("视图操作", null, makeScrollPane(graphToolBar), "切换到视图操作");
		addTab("图元操作", null, makeScrollPane(nodeOperationToolBar), "切换到图元操作");
		// addTab("图元编辑", null, makeScrollPane(nodeEditionToolBar), "切换到图元编辑");
		addTab("输入输出", null, makeScrollPane(ioToolBar), "切换到输入输出");
		
		/*setEnableRename(true);
		setEnableCopyPaste(true);
		setEnableUndoRedo(true);*/
		
		setEnableImport(false);
	}
	
	public GraphToolBar getGraphToolBar()
	{
		return graphToolBar;
	}
	
	public NodeOperationToolBar getNodeOperationToolBar()
	{
		return nodeOperationToolBar;
	}
	
	public NodeEditionToolBar getNodeEditionToolBar()
	{
		return nodeEditionToolBar;
	}
	
	public IOToolBar getIOToolBar()
	{
		return ioToolBar;
	}
	
	public TGraph getGraph()
	{
		return graph;
	}
	
	public class GraphToolBar
		extends JPanel
	{
		private JFlatOutlook graphOutlook;
		
		public GraphToolBar()
		{
			double[][] size = 
			{
				{30, 30},
				{TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL}
			};
			
			graphOutlook = new JFlatOutlook();
			graphOutlook.setLayout(new TableLayout(size));
			
			JBasicToggleButton selectButton = new JBasicToggleButton(TGraphController.getSelectAction(graph));
			selectButton.setSelected(true);
			selectButton.setText("");
			graphOutlook.add(selectButton, "0, 0");
			
			JBasicToggleButton panButton = new JBasicToggleButton(TGraphController.getPanAction(graph));
			panButton.setText("");
			graphOutlook.add(panButton, "0, 1");
			
			JBasicToggleButton lazeMoveButton = new JBasicToggleButton(TGraphController.getLazyMoveAction(graph));
			lazeMoveButton.setText("");
			graphOutlook.add(lazeMoveButton, "1, 1");
			
			JBasicButton zoomInButton = new JBasicButton(TGraphController.getZoomInAction(graph));
			zoomInButton.setText("");
			graphOutlook.add(zoomInButton, "0, 2");
			
			JBasicButton zoomOutButton = new JBasicButton(TGraphController.getZoomOutAction(graph));
			zoomOutButton.setText("");
			graphOutlook.add(zoomOutButton, "1, 2");
			
			JBasicToggleButton zoomInRectangleButton = new JBasicToggleButton(TGraphController.getZoomInRectangleAction(graph));
			zoomInRectangleButton.setText("");
			graphOutlook.add(zoomInRectangleButton, "0, 3");
			
			JBasicButton zoomResetButton = new JBasicButton(TGraphController.getZoomResetAction(graph));
			zoomResetButton.setText("");
			graphOutlook.add(zoomResetButton, "1, 3");
			
			JBasicToggleButton magnifierButton = new JBasicToggleButton(TGraphController.getMagnifierAction(graph));
			magnifierButton.setText("");
			graphOutlook.add(magnifierButton, "0, 4");
			
			JDecorationPopupMenu zoomPopupMenu = new JDecorationPopupMenu();
			
			JBasicMenuItem zoomToOverviewMenuItem = new JBasicMenuItem(TGraphController.getZoomToOverviewAction(graph));
			zoomPopupMenu.add(zoomToOverviewMenuItem);
			
			zoomPopupMenu.addSeparator();
			
			JBasicMenuItem zoomBackMenuItem = new JBasicMenuItem(TGraphController.getZoomBackAction(graph));
			zoomPopupMenu.add(zoomBackMenuItem);
			
			JBasicMenuButton zoomButton = new JBasicMenuButton(TIconFactory.getContextIcon("zoom.png"));
			zoomButton.setPopupMenu(zoomPopupMenu);
			graphOutlook.add(zoomButton, "1, 4");
			
			JBasicToggleButton scaleButton = new JBasicToggleButton(TGraphController.getScaleAction(graph));
			scaleButton.setText("");
			scaleButton.setGrouped(false);
			graphOutlook.add(scaleButton, "0, 5");
			
			JBasicButton fullscreenButton = new JBasicButton(TGraphController.getFullScreenAction(graph));
			fullscreenButton.setText("");
			graphOutlook.add(fullscreenButton, "1, 5");
			
			JBasicToggleButton overviewButton = new JBasicToggleButton(TGraphController.getOverviewAction(graph));
			overviewButton.setText("");
			overviewButton.setGrouped(false);
			graphOutlook.add(overviewButton, "0, 6");
			
			ButtonManager.updateUI(graphOutlook, new Dimension(25, 25), new ButtonGroup());
			
			add(graphOutlook);
		}
		
		public JFlatOutlook getGraphOutlook()
		{
			return graphOutlook;
		}
	}
	
	private JBasicButton addButton;
	
	public JBasicButton getAddButton()
	{
		return addButton;
	}
	
	private JBasicButton deleteButton;
	
	public JBasicButton getDeleteButton()
	{
		return deleteButton;
	}
	
	private JBasicButton copyButton;
	
	public JBasicButton getCopyButton()
	{
		return copyButton;
	}
	
	private JBasicButton pasteButton;
	
	public JBasicButton getPasteButton()
	{
		return pasteButton;
	}
	
	private JBasicButton renameButton;
	
	public JBasicButton getRenameButton()
	{
		return renameButton;
	}
	
	private JBasicButton undoButton;
	
	public JBasicButton getUndoButton()
	{
		return undoButton;
	}
	
	private JBasicButton redoButton;
	
	public JBasicButton getRedoButton()
	{
		return redoButton;
	}
	
	private JBasicButton labelConfigButton;
	
	public JBasicButton getLabelConfigButton()
	{
		return labelConfigButton;
	}
	
	private JBasicToggleButton layoutButton;
	
	public JBasicToggleButton getLayoutButton()
	{
		return layoutButton;
	}
	
	public class NodeOperationToolBar
		extends JPanel
	{
		private JFlatOutlook nodeOperationOutlook;
		
		public NodeOperationToolBar()
		{
			double[][] size = 
			{
				{30, 30},
				{TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL}
			};
			
			nodeOperationOutlook = new JFlatOutlook();
			nodeOperationOutlook.setLayout(new TableLayout(size));
			
			/*addButton = new JBasicButton(TGraphController.getAddAction(graph));
			addButton.setText("");
			nodeOperationOutlook.add(addButton, "0, 0");
			
			deleteButton = new JBasicButton(TGraphController.getDeleteAction(graph));
			deleteButton.setText("");
			nodeOperationOutlook.add(deleteButton, "1, 0");
			
			copyButton = new JBasicButton(TGraphController.getCopyAction(graph));
			copyButton.setText("");
			nodeOperationOutlook.add(copyButton, "0, 1");
			
			pasteButton = new JBasicButton(TGraphController.getPasteAction(graph));
			pasteButton.setText("");
			nodeOperationOutlook.add(pasteButton, "1, 1");
			
			renameButton = new JBasicButton(TGraphController.getRenameAction(graph));
			renameButton.setText("");
			nodeOperationOutlook.add(renameButton, "0, 2");
			
			JBasicButton selectAllButton = new JBasicButton(TGraphController.getSelectAllAction(graph));
			selectAllButton.setText("");
			nodeOperationOutlook.add(selectAllButton, "1, 2");
			
			undoButton = new JBasicButton(TGraphController.getUndoAction(graph));
			undoButton.setText("");
			undoButton.setEnabled(false);
			nodeOperationOutlook.add(undoButton, "0, 3");
			
			redoButton = new JBasicButton(TGraphController.getRedoAction(graph));
			redoButton.setText("");
			redoButton.setEnabled(false);
			nodeOperationOutlook.add(redoButton, "1, 3");
			
			// 默认关闭“撤消”和“重做”功能
			// new TDataBoxUndoRedoAdapter(graph, undoButton, redoButton);
			
			labelConfigButton = new JBasicButton(TGraphController.getLabelConfigAction(graph));
			labelConfigButton.setText("");
			nodeOperationOutlook.add(labelConfigButton, "0, 4");
			
			JDecorationPopupMenu groupPopupMenu = new JDecorationPopupMenu();
			
			TGroupType[] groupTypes = new TGroupType[] {TGroupType.RECTANGLE_GROUP_TYPE, TGroupType.ROUND_RECTANGLE_GROUP_TYPE, TGroupType.ROUND_GROUP_TYPE, TGroupType.OCTAGON_GROUP_TYPE, TGroupType.PARALLELOGRAM_GROUP_TYPE, TGroupType.ELLIPSE_GROUP_TYPE};
			for (int i = 0; i < groupTypes.length; i++)
			{
				TGroupType groupType = groupTypes[i];
				
				JBasicMenuItem groupShapeMenuItem = new JBasicMenuItem(TGraphController.getGroupTypeConfigAction(graph, groupType));
				groupPopupMenu.add(groupShapeMenuItem);
			}
			
			groupPopupMenu.addSeparator();
			
			JBasicMenuItem expandAllMenuItem = new JBasicMenuItem(TGraphController.getGroupExpandAction(graph));
			groupPopupMenu.add(expandAllMenuItem);
			
			JBasicMenuItem collapseAllMenuItem = new JBasicMenuItem(TGraphController.getGroupCollapseAction(graph));
			groupPopupMenu.add(collapseAllMenuItem);
			
			JBasicMenuButton groupButton = new JBasicMenuButton(TIconFactory.getContextIcon("group.png"));
			groupButton.setPopupMenu(groupPopupMenu);
			groupButton.setToolTipText("组设置");
			nodeOperationOutlook.add(groupButton, "1, 4");
			
			layoutButton = new JBasicToggleButton(TGraphController.getLayoutAction(graph));
			layoutButton.setText("");
			layoutButton.setGrouped(false);
			nodeOperationOutlook.add(layoutButton, "0, 5");
			
			JBasicButton hideChildrenButton = new JBasicButton(TGraphController.getHideChildrenAction(graph));
			hideChildrenButton.setText("");
			nodeOperationOutlook.add(hideChildrenButton, "1, 5");
			
			JDecorationPopupMenu lockPopupMenu = new JDecorationPopupMenu();
			
			JBasicMenuItem lockAllMenuItem = new JBasicMenuItem(TGraphController.getLockAllAction(graph));
			lockPopupMenu.add(lockAllMenuItem);
			
			JBasicMenuItem unLockAllMenuItem = new JBasicMenuItem(TGraphController.getUnLockAllAction(graph));
			lockPopupMenu.add(unLockAllMenuItem);
			
			lockPopupMenu.addSeparator();
			
			JBasicMenuItem lockSelectionMenuItem = new JBasicMenuItem(TGraphController.getLockSelectionAction(graph));
			lockPopupMenu.add(lockSelectionMenuItem);
			
			JBasicMenuItem unLockSelectionMenuItem = new JBasicMenuItem(TGraphController.getUnLockSelectionAction(graph));
			lockPopupMenu.add(unLockSelectionMenuItem);
			
			JBasicMenuButton lockButton = new JBasicMenuButton(TIconFactory.getContextIcon("lock.png"));
			lockButton.setPopupMenu(lockPopupMenu);
			lockButton.setToolTipText("锁定和解锁节点");
			nodeOperationOutlook.add(lockButton, "0, 6");*/
			
			layoutButton = new JBasicToggleButton(TGraphController.getLayoutAction(graph));
			layoutButton.setText("");
			layoutButton.setGrouped(false);
			nodeOperationOutlook.add(layoutButton, "0, 0");
			
			JBasicButton hideChildrenButton = new JBasicButton(TGraphController.getHideChildrenAction(graph));
			hideChildrenButton.setText("");
			nodeOperationOutlook.add(hideChildrenButton, "1, 0");
						
			JDecorationPopupMenu lockPopupMenu = new JDecorationPopupMenu();
			
			JBasicMenuItem lockAllMenuItem = new JBasicMenuItem(TGraphController.getLockAllAction(graph));
			lockPopupMenu.add(lockAllMenuItem);
			
			JBasicMenuItem unLockAllMenuItem = new JBasicMenuItem(TGraphController.getUnLockAllAction(graph));
			lockPopupMenu.add(unLockAllMenuItem);
			
			lockPopupMenu.addSeparator();
			
			JBasicMenuItem lockSelectionMenuItem = new JBasicMenuItem(TGraphController.getLockSelectionAction(graph));
			lockPopupMenu.add(lockSelectionMenuItem);
			
			JBasicMenuItem unLockSelectionMenuItem = new JBasicMenuItem(TGraphController.getUnLockSelectionAction(graph));
			lockPopupMenu.add(unLockSelectionMenuItem);
			
			JBasicMenuButton lockButton = new JBasicMenuButton(TIconFactory.getContextIcon("lock.png"));
			lockButton.setPopupMenu(lockPopupMenu);
			lockButton.setToolTipText("锁定和解锁节点");
			nodeOperationOutlook.add(lockButton, "0, 1");
			
			JDecorationPopupMenu groupPopupMenu = new JDecorationPopupMenu();
			
			TGroupType[] groupTypes = new TGroupType[] {TGroupType.RECTANGLE_GROUP_TYPE, TGroupType.ROUND_RECTANGLE_GROUP_TYPE, TGroupType.ROUND_GROUP_TYPE, TGroupType.OCTAGON_GROUP_TYPE, TGroupType.PARALLELOGRAM_GROUP_TYPE, TGroupType.ELLIPSE_GROUP_TYPE};
			for (int i = 0; i < groupTypes.length; i++)
			{
				TGroupType groupType = groupTypes[i];
				
				JBasicMenuItem groupShapeMenuItem = new JBasicMenuItem(TGraphController.getGroupTypeConfigAction(graph, groupType));
				groupPopupMenu.add(groupShapeMenuItem);
			}
			
			groupPopupMenu.addSeparator();
			
			JBasicMenuItem expandAllMenuItem = new JBasicMenuItem(TGraphController.getGroupExpandAction(graph));
			groupPopupMenu.add(expandAllMenuItem);
			
			JBasicMenuItem collapseAllMenuItem = new JBasicMenuItem(TGraphController.getGroupCollapseAction(graph));
			groupPopupMenu.add(collapseAllMenuItem);
			
			JBasicMenuButton groupButton = new JBasicMenuButton(TIconFactory.getContextIcon("group.png"));
			groupButton.setPopupMenu(groupPopupMenu);
			groupButton.setToolTipText("组设置");
			nodeOperationOutlook.add(groupButton, "1, 1");
			
			JDecorationPopupMenu alignPopupMenu = new JDecorationPopupMenu();
			
			JBasicMenuItem alignLeftMenuItem = new JBasicMenuItem(TGraphController.getAlignLeftAction(graph));
			alignPopupMenu.add(alignLeftMenuItem);
			
			JBasicMenuItem alignVerticalCenterMenuItem = new JBasicMenuItem(TGraphController.getAlignVerticalCenterAction(graph));
			alignPopupMenu.add(alignVerticalCenterMenuItem);
			
			JBasicMenuItem alignRightMenuItem = new JBasicMenuItem(TGraphController.getAlignRightAction(graph));
			alignPopupMenu.add(alignRightMenuItem);
			
			alignPopupMenu.addSeparator();
			
			JBasicMenuItem alignTopMenuItem = new JBasicMenuItem(TGraphController.getAlignTopAction(graph));
			alignPopupMenu.add(alignTopMenuItem);
			
			JBasicMenuItem alignHorizontalCenterMenuItem = new JBasicMenuItem(TGraphController.getAlignHorizontalCenterAction(graph));
			alignPopupMenu.add(alignHorizontalCenterMenuItem);
			
			JBasicMenuItem alignBottomMenuItem = new JBasicMenuItem(TGraphController.getAlignBottoJSecurityAction(graph));
			alignPopupMenu.add(alignBottomMenuItem);
			
			JBasicMenuButton alignButton = new JBasicMenuButton(TIconFactory.getContextIcon("align_vertical_center.png"));
			alignButton.setPopupMenu(alignPopupMenu);
			alignButton.setToolTipText("图元对齐");
			nodeOperationOutlook.add(alignButton, "0, 2");
			
			JDecorationPopupMenu pilePopupMenu = new JDecorationPopupMenu();
			
			JBasicMenuItem pileToLeftMenuItem = new JBasicMenuItem(TGraphController.getPileToLeftAction(graph));
			pilePopupMenu.add(pileToLeftMenuItem);
			
			JBasicMenuItem pileToRightMenuItem = new JBasicMenuItem(TGraphController.getPileToRightAction(graph));
			pilePopupMenu.add(pileToRightMenuItem);
			
			pilePopupMenu.addSeparator();
			
			JBasicMenuItem pileToTopMenuItem = new JBasicMenuItem(TGraphController.getPileToTopAction(graph));
			pilePopupMenu.add(pileToTopMenuItem);
			
			JBasicMenuItem pileToBottomMenuItem = new JBasicMenuItem(TGraphController.getPileToBottoJSecurityAction(graph));
			pilePopupMenu.add(pileToBottomMenuItem);
			
			JBasicMenuButton pileButton = new JBasicMenuButton(TIconFactory.getContextIcon("pile_to_top.png"));
			pileButton.setPopupMenu(pilePopupMenu);
			pileButton.setToolTipText("图元堆列");
			nodeOperationOutlook.add(pileButton, "1, 2");
			
			JDecorationPopupMenu sameSizePopupMenu = new JDecorationPopupMenu();
			
			JBasicMenuItem sameWidthMenuItem = new JBasicMenuItem(TGraphController.getSameWidthAction(graph));
			sameSizePopupMenu.add(sameWidthMenuItem);
			
			JBasicMenuItem sameHeightMenuItem = new JBasicMenuItem(TGraphController.getSameHeightAction(graph));
			sameSizePopupMenu.add(sameHeightMenuItem);
			
			sameSizePopupMenu.addSeparator();
			
			JBasicMenuItem evenHorizontalSpaceMenuItem = new JBasicMenuItem(TGraphController.getSameHorizontalSpaceAction(graph));
			sameSizePopupMenu.add(evenHorizontalSpaceMenuItem);
			
			JBasicMenuItem evenVerticalSpaceMenuItem = new JBasicMenuItem(TGraphController.getSameVerticalSpaceAction(graph));
			sameSizePopupMenu.add(evenVerticalSpaceMenuItem);
			
			JBasicMenuButton sameSizeButton = new JBasicMenuButton(TIconFactory.getContextIcon("same_horizontal_space.png"));
			sameSizeButton.setPopupMenu(sameSizePopupMenu);
			sameSizeButton.setToolTipText("图元尺寸和距离调整");
			nodeOperationOutlook.add(sameSizeButton, "0, 3");
			
			JDecorationPopupMenu layerPopupMenu = new JDecorationPopupMenu();
			
			JBasicMenuItem moveToUpMenuItem = new JBasicMenuItem(TGraphController.getMoveToUpAction(graph));
			layerPopupMenu.add(moveToUpMenuItem);
			
			JBasicMenuItem moveToDownMenuItem = new JBasicMenuItem(TGraphController.getMoveToDownAction(graph));
			layerPopupMenu.add(moveToDownMenuItem);
			
			layerPopupMenu.addSeparator();
			
			JBasicMenuItem moveToTopMenuItem = new JBasicMenuItem(TGraphController.getMoveToTopAction(graph));
			layerPopupMenu.add(moveToTopMenuItem);
			
			JBasicMenuItem moveToBottomMenuItem = new JBasicMenuItem(TGraphController.getMoveToBottoJSecurityAction(graph));
			layerPopupMenu.add(moveToBottomMenuItem);
			
			JBasicMenuButton layerButton = new JBasicMenuButton(TIconFactory.getContextIcon("move_to_up.png"));
			layerButton.setPopupMenu(layerPopupMenu);
			layerButton.setToolTipText("图元图层调整");
			nodeOperationOutlook.add(layerButton, "1, 3");
			
			ButtonManager.updateUI(nodeOperationOutlook, new Dimension(25, 25), new ButtonGroup());
			
			add(nodeOperationOutlook);
		}
		
		public JFlatOutlook getNodeOperationOutlook()
		{
			return nodeOperationOutlook;
		}
	}
	
	public class NodeEditionToolBar
		extends JPanel
	{
		private JFlatOutlook nodeEditionOutlook;
		
		public NodeEditionToolBar()
		{
			double[][] size = 
			{
				{30, 30},
				{TableLayout.FILL, TableLayout.FILL}
			};
			
			nodeEditionOutlook = new JFlatOutlook();
			nodeEditionOutlook.setLayout(new TableLayout(size));
			
			JDecorationPopupMenu alignPopupMenu = new JDecorationPopupMenu();
			
			JBasicMenuItem alignLeftMenuItem = new JBasicMenuItem(TGraphController.getAlignLeftAction(graph));
			alignPopupMenu.add(alignLeftMenuItem);
			
			JBasicMenuItem alignVerticalCenterMenuItem = new JBasicMenuItem(TGraphController.getAlignVerticalCenterAction(graph));
			alignPopupMenu.add(alignVerticalCenterMenuItem);
			
			JBasicMenuItem alignRightMenuItem = new JBasicMenuItem(TGraphController.getAlignRightAction(graph));
			alignPopupMenu.add(alignRightMenuItem);
			
			alignPopupMenu.addSeparator();
			
			JBasicMenuItem alignTopMenuItem = new JBasicMenuItem(TGraphController.getAlignTopAction(graph));
			alignPopupMenu.add(alignTopMenuItem);
			
			JBasicMenuItem alignHorizontalCenterMenuItem = new JBasicMenuItem(TGraphController.getAlignHorizontalCenterAction(graph));
			alignPopupMenu.add(alignHorizontalCenterMenuItem);
			
			JBasicMenuItem alignBottomMenuItem = new JBasicMenuItem(TGraphController.getAlignBottoJSecurityAction(graph));
			alignPopupMenu.add(alignBottomMenuItem);
			
			JBasicMenuButton alignButton = new JBasicMenuButton(TIconFactory.getContextIcon("align_vertical_center.png"));
			alignButton.setPopupMenu(alignPopupMenu);
			alignButton.setToolTipText("图元对齐");
			nodeEditionOutlook.add(alignButton, "0, 0");
			
			JDecorationPopupMenu pilePopupMenu = new JDecorationPopupMenu();
			
			JBasicMenuItem pileToLeftMenuItem = new JBasicMenuItem(TGraphController.getPileToLeftAction(graph));
			pilePopupMenu.add(pileToLeftMenuItem);
			
			JBasicMenuItem pileToRightMenuItem = new JBasicMenuItem(TGraphController.getPileToRightAction(graph));
			pilePopupMenu.add(pileToRightMenuItem);
			
			pilePopupMenu.addSeparator();
			
			JBasicMenuItem pileToTopMenuItem = new JBasicMenuItem(TGraphController.getPileToTopAction(graph));
			pilePopupMenu.add(pileToTopMenuItem);
			
			JBasicMenuItem pileToBottomMenuItem = new JBasicMenuItem(TGraphController.getPileToBottoJSecurityAction(graph));
			pilePopupMenu.add(pileToBottomMenuItem);
			
			JBasicMenuButton pileButton = new JBasicMenuButton(TIconFactory.getContextIcon("pile_to_top.png"));
			pileButton.setPopupMenu(pilePopupMenu);
			pileButton.setToolTipText("图元堆列");
			nodeEditionOutlook.add(pileButton, "1, 0");
			
			JDecorationPopupMenu sameSizePopupMenu = new JDecorationPopupMenu();
			
			JBasicMenuItem sameWidthMenuItem = new JBasicMenuItem(TGraphController.getSameWidthAction(graph));
			sameSizePopupMenu.add(sameWidthMenuItem);
			
			JBasicMenuItem sameHeightMenuItem = new JBasicMenuItem(TGraphController.getSameHeightAction(graph));
			sameSizePopupMenu.add(sameHeightMenuItem);
			
			sameSizePopupMenu.addSeparator();
			
			JBasicMenuItem evenHorizontalSpaceMenuItem = new JBasicMenuItem(TGraphController.getSameHorizontalSpaceAction(graph));
			sameSizePopupMenu.add(evenHorizontalSpaceMenuItem);
			
			JBasicMenuItem evenVerticalSpaceMenuItem = new JBasicMenuItem(TGraphController.getSameVerticalSpaceAction(graph));
			sameSizePopupMenu.add(evenVerticalSpaceMenuItem);
			
			JBasicMenuButton sameSizeButton = new JBasicMenuButton(TIconFactory.getContextIcon("same_horizontal_space.png"));
			sameSizeButton.setPopupMenu(sameSizePopupMenu);
			sameSizeButton.setToolTipText("图元尺寸和距离调整");
			nodeEditionOutlook.add(sameSizeButton, "0, 1");
			
			JDecorationPopupMenu layerPopupMenu = new JDecorationPopupMenu();
			
			JBasicMenuItem moveToUpMenuItem = new JBasicMenuItem(TGraphController.getMoveToUpAction(graph));
			layerPopupMenu.add(moveToUpMenuItem);
			
			JBasicMenuItem moveToDownMenuItem = new JBasicMenuItem(TGraphController.getMoveToDownAction(graph));
			layerPopupMenu.add(moveToDownMenuItem);
			
			layerPopupMenu.addSeparator();
			
			JBasicMenuItem moveToTopMenuItem = new JBasicMenuItem(TGraphController.getMoveToTopAction(graph));
			layerPopupMenu.add(moveToTopMenuItem);
			
			JBasicMenuItem moveToBottomMenuItem = new JBasicMenuItem(TGraphController.getMoveToBottoJSecurityAction(graph));
			layerPopupMenu.add(moveToBottomMenuItem);
			
			JBasicMenuButton layerButton = new JBasicMenuButton(TIconFactory.getContextIcon("move_to_up.png"));
			layerButton.setPopupMenu(layerPopupMenu);
			layerButton.setToolTipText("图元图层调整");
			nodeEditionOutlook.add(layerButton, "1, 1");
			
			ButtonManager.updateUI(nodeEditionOutlook, new Dimension(25, 25));
			
			add(nodeEditionOutlook);
		}
		
		public JFlatOutlook getnodeEditionOutlook()
		{
			return nodeEditionOutlook;
		}
	}
	
	private JBasicButton importButton;
	
	public JBasicButton getImportButton()
	{
		return importButton;
	}
	
	private JBasicButton statButton;
	
	public JBasicButton getStatButton()
	{
		return statButton;
	}
	
	private JBasicMenuItem exportXMLMenuItem;
	
	public JBasicMenuItem getExportXMLMenuItem()
	{
		return exportXMLMenuItem;
	}
	
	public class IOToolBar
		extends JPanel
	{
		private JFlatOutlook ioOutlook;
		
		public IOToolBar()
		{
			double[][] size = 
			{
				{30, 30},
				{TableLayout.FILL, TableLayout.FILL}
			};
			
			ioOutlook = new JFlatOutlook();
			ioOutlook.setLayout(new TableLayout(size));
			
			importButton = new JBasicButton(TGraphController.getImportAction(graph));
			importButton.setText("");
			ioOutlook.add(importButton, "0, 0");
			
			JDecorationPopupMenu exportPopupMenu = new JDecorationPopupMenu();
			
			exportXMLMenuItem = new JBasicMenuItem(TGraphController.getExportXMLAction(graph));
			exportPopupMenu.add(exportXMLMenuItem);
			
			exportPopupMenu.addSeparator();
			
			JBasicMenuItem exportSVGMenuItem = new JBasicMenuItem(TGraphController.getExportSVGAction(graph));
			exportPopupMenu.add(exportSVGMenuItem);
			
			JBasicMenuItem exportImageMenuItem = new JBasicMenuItem(TGraphController.getExportImageAction(graph));
			exportPopupMenu.add(exportImageMenuItem);
			
			JBasicMenuButton exportButton = new JBasicMenuButton(TIconFactory.getContextIcon("export.png"));
			exportButton.setPopupMenu(exportPopupMenu);
			exportButton.setToolTipText("导出");
			ioOutlook.add(exportButton, "1, 0");
			
			/*statButton = new JBasicButton(TGraphController.getStatAction(graph));
			statButton.setText("");
			ioOutlook.add(statButton, "0, 1");
			
			JBasicButton printButton = new JBasicButton(TGraphController.getPrintAction(graph));
			printButton.setText("");
			ioOutlook.add(printButton, "1, 1");*/
			
			JBasicButton printButton = new JBasicButton(TGraphController.getPrintAction(graph));
			printButton.setText("");
			ioOutlook.add(printButton, "0, 1");
			
			ButtonManager.updateUI(ioOutlook, new Dimension(25, 25));
			
			add(ioOutlook);
		}
		
		public JFlatOutlook getIOOutlook()
		{
			return ioOutlook;
		}
	}
	
	public void setEnableAdd(boolean enabled)
	{
		((JSecurityAction) addButton.getAction()).setPermitted(enabled);
	}
	
	public void setEnableDelete(boolean enabled)
	{
		((JSecurityAction) deleteButton.getAction()).setPermitted(enabled);
		// graph.setEnableDeleteWithKeyboard(enabled);
	}
	
	public void setEnableCopyPaste(boolean enabled)
	{
		((JSecurityAction) copyButton.getAction()).setPermitted(enabled);
		((JSecurityAction) pasteButton.getAction()).setPermitted(enabled);
		// graph.setEnableCopyPasteWithKeyboard(enabled);
	}
	
	public void setEnableRename(boolean enabled)
	{
		((JSecurityAction) renameButton.getAction()).setPermitted(enabled);
		TGraphManager.setElementLabelEditable(graph, enabled);
	}
	
	public void setEnableUndoRedo(boolean enabled)
	{
		((JSecurityAction) undoButton.getAction()).setPermitted(enabled);
		((JSecurityAction) redoButton.getAction()).setPermitted(enabled);
		// graph.setEnableUndoRedoWithKeyboard(enabled);
		if (enabled)
		{
			new TDataBoxUndoRedoAdapter(graph.getDataBox(), undoButton, redoButton);
		}
		else
		{
			List undoRedoListeners = graph.getDataBox().getUndoRedoManager().getUndoRedoListeners();
			undoRedoListeners = new ArrayList(undoRedoListeners);
			for (Iterator iterator = undoRedoListeners.iterator(); iterator.hasNext();)
			{
				Object undoRedoAdapterObject = iterator.next();
				if (undoRedoAdapterObject instanceof TDataBoxUndoRedoAdapter)
				{
					TDataBoxUndoRedoAdapter undoRedoAdapter = (TDataBoxUndoRedoAdapter) undoRedoAdapterObject;
					graph.getDataBox().getUndoRedoManager().removeUndoRedoListener(undoRedoAdapter);
				}
			}
		}
	}
	
	public void setEnableLabelConfig(boolean enabled)
	{
		((JSecurityAction) labelConfigButton.getAction()).setPermitted(enabled);
	}
	
	public void setEnableLayout(boolean enabled)
	{
		((JSecurityAction) layoutButton.getAction()).setPermitted(enabled);
	}
	
	public void setEnableImport(boolean enabled)
	{
		((JSecurityAction) importButton.getAction()).setPermitted(enabled);
	}
	
	public void setEnableExportXML(boolean enabled)
	{
		((JSecurityAction) exportXMLMenuItem.getAction()).setPermitted(enabled);
	}
	
	public void setEnableStat(boolean enabled)
	{
		((JSecurityAction) statButton.getAction()).setPermitted(enabled);
	}
}