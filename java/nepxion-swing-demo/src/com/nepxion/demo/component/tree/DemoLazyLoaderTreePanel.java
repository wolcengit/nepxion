package com.nepxion.demo.component.tree;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.JPanel;
import javax.swing.filechooser.FileSystemView;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

import com.nepxion.swing.border.ComplexEtchedBorder;
import com.nepxion.swing.border.ComplexSide;
import com.nepxion.swing.border.ComplexTitleBorder;
import com.nepxion.swing.element.ElementNode;
import com.nepxion.swing.frame.JBasicFrame;
import com.nepxion.swing.lookandfeel.LookAndFeelManager;
import com.nepxion.swing.menuitem.JBasicMenuItem;
import com.nepxion.swing.popupmenu.JDecorationPopupMenu;
import com.nepxion.swing.renderer.tree.TreeElementCellRenderer;
import com.nepxion.swing.tree.lazyloader.AbstractLazyLoader;
import com.nepxion.swing.tree.lazyloader.JLazyLoaderContainer;
import com.nepxion.swing.tree.lazyloader.JLazyLoaderTree;
import com.nepxion.swing.tree.lazyloader.JLazyLoaderTreeNode;
import com.nepxion.swing.tree.lazyloader.LazyLoaderTreeController;

public class DemoLazyLoaderTreePanel
	extends JPanel
{
	private FileSystemView fileSystemView = FileSystemView.getFileSystemView();
	
	public DemoLazyLoaderTreePanel()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new LazyLoaderTreePanel());
	}
	
	public class LazyLoaderTreePanel
		extends JPanel
	{
		public LazyLoaderTreePanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(new ComplexTitleBorder(new ComplexEtchedBorder(ComplexEtchedBorder.LOWERED, ComplexSide.NORTH), "File LazyLoader Tree"));
			
			FileTree fileTree = new FileTree();
			
			JLazyLoaderContainer lazyLoaderContainer = new JLazyLoaderContainer(fileTree);
			add(lazyLoaderContainer);
		}
	}
	
	private FileNode createFileNode(File file)
	{
		FileNode fileNode = new FileNode(file);
		if (file.isDirectory())
		{
			File[] files = fileSystemView.getFiles(file, false);
			if (files != null && files.length > 0)
			{
				fileNode.setLoaded(false);
				fileNode.setLeaf(false);
			}
			else
			{
				fileNode.setLoaded(true);
				fileNode.setLeaf(true);
			}
		}
		else
		{
			fileNode.setLoaded(true);
			fileNode.setLeaf(true);
		}
		String name = fileSystemView.getSystemDisplayName(file);
		Icon icon = fileSystemView.getSystemIcon(file);
		
		fileNode.setText(name);
		fileNode.setIcon(icon);
		fileNode.setToolTipText(name);
		return fileNode;
	}
	
	public class FileTree
		extends JLazyLoaderTree
	{
		private FilePopopMenu popupMenu;
		
		public FileTree()
		{
			DefaultMutableTreeNode root = new DefaultMutableTreeNode("File System View");
			
			File[] files = fileSystemView.getRoots();
			for (int i = 0; i < files.length; i++)
			{
				FileNode fileNode = createFileNode(files[i]);
				root.add(fileNode);
			}
			
			DefaultTreeModel treeModel = new DefaultTreeModel(root);
			
			setModel(treeModel);
			// setRootVisible(false);
			// setSelectionMode(SINGLE_TREE_SELECTION);
			setCellRenderer(new TreeElementCellRenderer(20));
			setLazyLoader(new FileLazyLoader(false));
			
			popupMenu = new FilePopopMenu(this);
		}
		
		public void executePopupMenu(TreeNode treeNode, int treePathCount, int x, int y)
		{
			popupMenu.show(this, x, y);
		}
	}
	
	public class FileNode
		extends JLazyLoaderTreeNode
	{
		private File file;
		
		public FileNode(File file)
		{
			this.file = file;
		}
		
		public File getFile()
		{
			return file;
		}
		
		public void setFile(File file)
		{
			this.file = file;
		}
	}
	
	public class FileLazyLoader
		extends AbstractLazyLoader
	{
		public FileLazyLoader()
		{
			super();
		}
		
		public FileLazyLoader(boolean isSynchronized)
		{
			super(isSynchronized);
		}
		
		public void loadForeground(Object data, JLazyLoaderTreeNode lazyLoaderTreeNode)
		{
			File[] files = (File[]) data;
			if (files != null && files.length > 0)
			{
				for (int i = 0; i < files.length; ++i)
				{
					FileNode fileNode = createFileNode(files[i]);
					lazyLoaderTreeNode.add(fileNode);
				}
			}
		}
		
		public Object loadBackground(JLazyLoaderTreeNode lazyLoaderTreeNode)
		{
			FileNode fileNode = (FileNode) lazyLoaderTreeNode;
			File file = fileNode.getFile();
			File[] files = fileSystemView.getFiles(file, true);
			
			if (files != null && files.length != 0)
			{	
				try
				{
					Thread.sleep(2000);
				}
				catch (InterruptedException e)
				{
				}
			}
			
			return files;
		}
	}
	
	public class FilePopopMenu
		extends JDecorationPopupMenu
	{
		public FilePopopMenu(JLazyLoaderTree lazyLoaderTree)
		{		
			JBasicMenuItem newAction = new JBasicMenuItem(LazyLoaderTreeController.getAddAction(lazyLoaderTree, new ElementNode("新增节点")));
			add(newAction);				
			
			JBasicMenuItem deleteAction = new JBasicMenuItem(LazyLoaderTreeController.getDeleteAction(lazyLoaderTree));
			add(deleteAction);				
			
			JBasicMenuItem renameAction = new JBasicMenuItem(LazyLoaderTreeController.getRenameAction(lazyLoaderTree));
			add(renameAction);					
			
			addSeparator();
			
			JBasicMenuItem refreshMenuItem = new JBasicMenuItem(LazyLoaderTreeController.getRefreshAction(lazyLoaderTree));
			add(refreshMenuItem);

			JBasicMenuItem searchMenuItem = new JBasicMenuItem(LazyLoaderTreeController.getSearchAction(lazyLoaderTree));
			add(searchMenuItem);
			
			addSeparator();			
			
			JBasicMenuItem moveUpAction = new JBasicMenuItem(LazyLoaderTreeController.getMoveUpAction(lazyLoaderTree));
			add(moveUpAction);	
			
			JBasicMenuItem moveDownAction = new JBasicMenuItem(LazyLoaderTreeController.getMoveDownAction(lazyLoaderTree));
			add(moveDownAction);			
			
			addSeparator();
			
			JBasicMenuItem loadMenuItem = new JBasicMenuItem(LazyLoaderTreeController.getLoadAction(lazyLoaderTree));
			add(loadMenuItem);
			
			JBasicMenuItem loadChildrenMenuItem = new JBasicMenuItem(LazyLoaderTreeController.getLoadChildrenAction(lazyLoaderTree));
			add(loadChildrenMenuItem);
			
			JBasicMenuItem loadAllMenuItem = new JBasicMenuItem(LazyLoaderTreeController.getLoadAllAction(lazyLoaderTree));
			add(loadAllMenuItem);
			
			addSeparator();
			
			JBasicMenuItem cancelMenuItem = new JBasicMenuItem(LazyLoaderTreeController.getCancelAction(lazyLoaderTree));
			add(cancelMenuItem);
			
			JBasicMenuItem cancelChildrenMenuItem = new JBasicMenuItem(LazyLoaderTreeController.getCancelChildrenAction(lazyLoaderTree));
			add(cancelChildrenMenuItem);
			
			JBasicMenuItem cancelAllMenuItem = new JBasicMenuItem(LazyLoaderTreeController.getCancelAllAction(lazyLoaderTree));
			add(cancelAllMenuItem);
			
			addSeparator();
			
			JBasicMenuItem expandMenuItem = new JBasicMenuItem(LazyLoaderTreeController.getExpandAction(lazyLoaderTree));
			add(expandMenuItem);
			
			JBasicMenuItem expandChildrenMenuItem = new JBasicMenuItem(LazyLoaderTreeController.getExpandChildrenAction(lazyLoaderTree));
			add(expandChildrenMenuItem);
			
			JBasicMenuItem expandAllMenuItem = new JBasicMenuItem(LazyLoaderTreeController.getExpandAllAction(lazyLoaderTree));
			add(expandAllMenuItem);
			
			addSeparator();
			
			JBasicMenuItem collapseMenuItem = new JBasicMenuItem(LazyLoaderTreeController.getCollapseAction(lazyLoaderTree));
			add(collapseMenuItem);
			
			JBasicMenuItem collapseChildrenMenuItem = new JBasicMenuItem(LazyLoaderTreeController.getCollapseChildrenAction(lazyLoaderTree));
			add(collapseChildrenMenuItem);
			
			JBasicMenuItem collapseAllMenuItem = new JBasicMenuItem(LazyLoaderTreeController.getCollapseAllAction(lazyLoaderTree));
			add(collapseAllMenuItem);
		}
	}
	
	public static void main(String[] args)
	{
		LookAndFeelManager.setAlloyLookAndFeel();
		JBasicFrame frame = new JBasicFrame();
		frame.getContentPane().add(new DemoLazyLoaderTreePanel());
		frame.setSize(800, 600);
		frame.setVisible(true);
	}
}