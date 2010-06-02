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
import javax.swing.JMenuItem;
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
			JMenuItem newAction = new JMenuItem(LazyLoaderTreeController.getAddAction(lazyLoaderTree, new ElementNode("新增节点")));
			add(newAction);				
			
			JMenuItem deleteAction = new JMenuItem(LazyLoaderTreeController.getDeleteAction(lazyLoaderTree));
			add(deleteAction);				
			
			JMenuItem renameAction = new JMenuItem(LazyLoaderTreeController.getRenameAction(lazyLoaderTree));
			add(renameAction);					
			
			addSeparator();
			
			JMenuItem refreshMenuItem = new JMenuItem(LazyLoaderTreeController.getRefreshAction(lazyLoaderTree));
			add(refreshMenuItem);

			JMenuItem searchMenuItem = new JMenuItem(LazyLoaderTreeController.getSearchAction(lazyLoaderTree));
			add(searchMenuItem);
			
			addSeparator();			
			
			JMenuItem moveUpAction = new JMenuItem(LazyLoaderTreeController.getMoveUpAction(lazyLoaderTree));
			add(moveUpAction);	
			
			JMenuItem moveDownAction = new JMenuItem(LazyLoaderTreeController.getMoveDownAction(lazyLoaderTree));
			add(moveDownAction);			
			
			addSeparator();
			
			JMenuItem loadMenuItem = new JMenuItem(LazyLoaderTreeController.getLoadAction(lazyLoaderTree));
			add(loadMenuItem);
			
			JMenuItem loadChildrenMenuItem = new JMenuItem(LazyLoaderTreeController.getLoadChildrenAction(lazyLoaderTree));
			add(loadChildrenMenuItem);
			
			JMenuItem loadAllMenuItem = new JMenuItem(LazyLoaderTreeController.getLoadAllAction(lazyLoaderTree));
			add(loadAllMenuItem);
			
			addSeparator();
			
			JMenuItem cancelMenuItem = new JMenuItem(LazyLoaderTreeController.getCancelAction(lazyLoaderTree));
			add(cancelMenuItem);
			
			JMenuItem cancelChildrenMenuItem = new JMenuItem(LazyLoaderTreeController.getCancelChildrenAction(lazyLoaderTree));
			add(cancelChildrenMenuItem);
			
			JMenuItem cancelAllMenuItem = new JMenuItem(LazyLoaderTreeController.getCancelAllAction(lazyLoaderTree));
			add(cancelAllMenuItem);
			
			addSeparator();
			
			JMenuItem expandMenuItem = new JMenuItem(LazyLoaderTreeController.getExpandAction(lazyLoaderTree));
			add(expandMenuItem);
			
			JMenuItem expandChildrenMenuItem = new JMenuItem(LazyLoaderTreeController.getExpandChildrenAction(lazyLoaderTree));
			add(expandChildrenMenuItem);
			
			JMenuItem expandAllMenuItem = new JMenuItem(LazyLoaderTreeController.getExpandAllAction(lazyLoaderTree));
			add(expandAllMenuItem);
			
			addSeparator();
			
			JMenuItem collapseMenuItem = new JMenuItem(LazyLoaderTreeController.getCollapseAction(lazyLoaderTree));
			add(collapseMenuItem);
			
			JMenuItem collapseChildrenMenuItem = new JMenuItem(LazyLoaderTreeController.getCollapseChildrenAction(lazyLoaderTree));
			add(collapseChildrenMenuItem);
			
			JMenuItem collapseAllMenuItem = new JMenuItem(LazyLoaderTreeController.getCollapseAllAction(lazyLoaderTree));
			add(collapseAllMenuItem);
		}
	}
	
	public static void main(String[] args)
	{
		LookAndFeelManager.setPlasticXPLookAndFeel();
		JBasicFrame frame = new JBasicFrame();
		frame.getContentPane().add(new DemoLazyLoaderTreePanel());
		frame.setSize(800, 600);
		frame.setVisible(true);
	}
}