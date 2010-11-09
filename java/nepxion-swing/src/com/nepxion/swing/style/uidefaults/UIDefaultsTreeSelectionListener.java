package com.nepxion.swing.style.uidefaults;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.util.Map;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.TableModel;
import javax.swing.tree.TreePath;

import com.nepxion.swing.framework.dockable.JDockableView;
import com.nepxion.swing.handle.HandleManager;
import com.nepxion.swing.scrollpane.JBasicScrollPane;
import com.nepxion.swing.table.layoutable.TableCellRendererLayout;

public class UIDefaultsTreeSelectionListener
	implements TreeSelectionListener
{
	private UIDefaultsTable table;
	
	public void valueChanged(TreeSelectionEvent evt)
	{
		UIDefaultsTree tree = (UIDefaultsTree) evt.getSource();
		TreePath treePath = tree.getSelectionPath();
		if (treePath != null)
		{
			if (table == null)
			{
				UIDefaultsHierarchy hierarchy = (UIDefaultsHierarchy) HandleManager.getComponent(tree, UIDefaultsHierarchy.class);
				JDockableView dockableView = hierarchy.getDockableView(UIDefaultsHierarchy.CONTENT_PANE_TITLE);
				JBasicScrollPane scrollPane = (JBasicScrollPane) dockableView.getContentPane();
				table = (UIDefaultsTable) scrollPane.getViewport().getView();
			}
			
			UIDefaultsTreeNode treeNode = (UIDefaultsTreeNode) treePath.getLastPathComponent();
			Object key = treeNode.getKey();
			Object value = treeNode.getValue();
			
			if (value != null)
			{
				Map map = (Map) value;
				
				TableModel tableModel = table.getDataModel();
				if (tableModel != null && tableModel instanceof UIDefaultsTableModel)
				{
					((UIDefaultsTableModel) tableModel).setRowData(map);
				}
				else
				{
					table.setDataModel(new UIDefaultsTableModel(map));
				}
				TableCellRendererLayout layout = new TableCellRendererLayout(table);
				layout.doLayout(new int[][] { {300, 400, 100}, {}});
			}
		}
	}
}