package com.nepxion.swing.searcher.zone.local;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import javax.swing.tree.DefaultTreeModel;

import org.dom4j.DocumentException;

import com.nepxion.swing.element.ElementNode;
import com.nepxion.swing.renderer.tree.TreeElementCellRenderer;
import com.nepxion.swing.tree.JBasicTree;
import com.nepxion.swing.tree.xml.Dom4JTreeParser;
import com.nepxion.util.io.FileContext;
import com.nepxion.util.searcher.zone.local.ZoneConstants;

public class JZoneTree
	extends JBasicTree implements ZoneConstants
{
	public JZoneTree()
	{
		this(FileContext.getContent(CONFIG_FILE_PATH));
	}
	
	public JZoneTree(String content)
	{
		Dom4JTreeParser parser = new Dom4JTreeParser();
		parser.setNameTag("code");
		parser.setTextTag("name");
		
		ElementNode root = null;
		try
		{
			root = parser.parse(content);
		}
		catch (DocumentException e)
		{
			e.printStackTrace();
		}
		DefaultTreeModel treeModel = new DefaultTreeModel(root);
		setModel(treeModel);
		setCellRenderer(new TreeElementCellRenderer(TreeElementCellRenderer.NIMBUS_STYLE, 20));
		setSelectionMode(JBasicTree.SINGLE_TREE_SELECTION);
	}
}