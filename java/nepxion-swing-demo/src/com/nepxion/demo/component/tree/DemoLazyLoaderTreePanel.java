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

import java.awt.BorderLayout;
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
import com.nepxion.swing.button.ButtonManager;
import com.nepxion.swing.button.JBasicButton;
import com.nepxion.swing.button.JBasicSplitButton;
import com.nepxion.swing.element.ElementNode;
import com.nepxion.swing.frame.JBasicFrame;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.layout.toolbar.ToolBarLayout;
import com.nepxion.swing.lookandfeel.LookAndFeelManager;
import com.nepxion.swing.menuitem.JBasicMenuItem;
import com.nepxion.swing.popupmenu.JDecorationPopupMenu;
import com.nepxion.swing.renderer.tree.TreeElementCellRenderer;
import com.nepxion.swing.separator.JBasicSeparator;
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
			setBorder(new ComplexTitleBorder(new ComplexEtchedBorder(ComplexEtchedBorder.LOWERED, ComplexSide.NORTH), "LazyLoader Tree"));
			
			FileTree fileTree = new FileTree();
			
			FileToolBar fileToolBar = new FileToolBar(fileTree);
			
			JLazyLoaderContainer lazyLoaderContainer = new JLazyLoaderContainer(fileTree);
			lazyLoaderContainer.add(fileToolBar, BorderLayout.NORTH);
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
					Thread.sleep(500);
				}
				catch (InterruptedException e)
				{
				}
			}
			
			return files;
		}
	}
	
	public class FileToolBar
		extends JPanel
	{
		public FileToolBar(JLazyLoaderTree lazyLoaderTree)
		{
			setLayout(new ToolBarLayout());
			setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
			
			JBasicButton newButton = new JBasicButton(LazyLoaderTreeController.getAddAction(lazyLoaderTree, new ElementNode("新增节点", IconFactory.getSwingIcon("solid/add_16.png"), "新增节点")));
			add(newButton);
			
			JBasicButton deleteButton = new JBasicButton(LazyLoaderTreeController.getDeleteAction(lazyLoaderTree));
			add(deleteButton);	
			
			JBasicButton renameButton = new JBasicButton(LazyLoaderTreeController.getRenameAction(lazyLoaderTree));
			add(renameButton);						
			
			add(new JBasicSeparator());
			
			JBasicButton refreshButton = new JBasicButton(LazyLoaderTreeController.getRefreshAction(lazyLoaderTree));
			add(refreshButton);

			JBasicButton searchButton = new JBasicButton(LazyLoaderTreeController.getSearchAction(lazyLoaderTree));
			add(searchButton);
						
			add(new JBasicSeparator());	
			
			JBasicSplitButton loadSplitButton = new JBasicSplitButton(LazyLoaderTreeController.getLoadAction(lazyLoaderTree));
			add(loadSplitButton);
			
			JDecorationPopupMenu loadPopupMenu = new JDecorationPopupMenu();
			loadSplitButton.setPopupMenu(loadPopupMenu);
			
			JBasicMenuItem loadMenuItem = new JBasicMenuItem(LazyLoaderTreeController.getLoadAction(lazyLoaderTree));
			loadPopupMenu.add(loadMenuItem);
			
			loadPopupMenu.addSeparator();
			
			JBasicMenuItem loadChildrenMenuItem = new JBasicMenuItem(LazyLoaderTreeController.getLoadChildrenAction(lazyLoaderTree));
			loadPopupMenu.add(loadChildrenMenuItem);
			
			JBasicMenuItem loadAllMenuItem = new JBasicMenuItem(LazyLoaderTreeController.getLoadAllAction(lazyLoaderTree));
			loadPopupMenu.add(loadAllMenuItem);
			
			JBasicSplitButton cancelSplitButton = new JBasicSplitButton(LazyLoaderTreeController.getCancelAction(lazyLoaderTree));
			cancelSplitButton.setText("取消");
			add(cancelSplitButton);
			
			JDecorationPopupMenu cancelPopupMenu = new JDecorationPopupMenu();
			cancelSplitButton.setPopupMenu(cancelPopupMenu);			
			
			JBasicMenuItem cancelMenuItem = new JBasicMenuItem(LazyLoaderTreeController.getCancelAction(lazyLoaderTree)); 
			cancelPopupMenu.add(cancelMenuItem);
			
			cancelPopupMenu.addSeparator();
			
			JBasicMenuItem cancelChildrenMenuItem = new JBasicMenuItem(LazyLoaderTreeController.getCancelChildrenAction(lazyLoaderTree));
			cancelPopupMenu.add(cancelChildrenMenuItem);
			
			JBasicMenuItem cancelAllMenuItem = new JBasicMenuItem(LazyLoaderTreeController.getCancelAllAction(lazyLoaderTree));			
			cancelPopupMenu.add(cancelAllMenuItem);
			
			add(new JBasicSeparator());
			
			JBasicButton moveUpAction = new JBasicButton(LazyLoaderTreeController.getMoveUpAction(lazyLoaderTree));
			add(moveUpAction);	
			
			JBasicButton moveDownAction = new JBasicButton(LazyLoaderTreeController.getMoveDownAction(lazyLoaderTree));
			add(moveDownAction);
			
			add(new JBasicSeparator());

			JBasicSplitButton expandSplitButton = new JBasicSplitButton(LazyLoaderTreeController.getExpandAction(lazyLoaderTree));
			add(expandSplitButton);
			
			JDecorationPopupMenu expandPopupMenu = new JDecorationPopupMenu();
			expandSplitButton.setPopupMenu(expandPopupMenu);			
			
			JBasicMenuItem expandMenuItem = new JBasicMenuItem(LazyLoaderTreeController.getExpandAction(lazyLoaderTree));
			expandPopupMenu.add(expandMenuItem);
			
			expandPopupMenu.addSeparator();
			
			JBasicMenuItem expandChildrenMenuItem = new JBasicMenuItem(LazyLoaderTreeController.getExpandChildrenAction(lazyLoaderTree));
			expandPopupMenu.add(expandChildrenMenuItem);
			
			JBasicMenuItem expandAllMenuItem = new JBasicMenuItem(LazyLoaderTreeController.getExpandAllAction(lazyLoaderTree));
			expandPopupMenu.add(expandAllMenuItem);
			

			JBasicSplitButton collapseSplitButton = new JBasicSplitButton(LazyLoaderTreeController.getCollapseAction(lazyLoaderTree));
			add(collapseSplitButton);
			
			JDecorationPopupMenu collapsePopupMenu = new JDecorationPopupMenu();
			collapseSplitButton.setPopupMenu(collapsePopupMenu);				
			
			JBasicMenuItem collapseMenuItem = new JBasicMenuItem(LazyLoaderTreeController.getCollapseAction(lazyLoaderTree));
			collapsePopupMenu.add(collapseMenuItem);
			
			collapsePopupMenu.addSeparator();
			
			JBasicMenuItem collapseChildrenMenuItem = new JBasicMenuItem(LazyLoaderTreeController.getCollapseChildrenAction(lazyLoaderTree));
			collapsePopupMenu.add(collapseChildrenMenuItem);
			
			JBasicMenuItem collapseAllMenuItem = new JBasicMenuItem(LazyLoaderTreeController.getCollapseAllAction(lazyLoaderTree));
			collapsePopupMenu.add(collapseAllMenuItem);
			
			ButtonManager.updateUI(this);		
		}
	}
	
	public class FilePopopMenu
		extends JDecorationPopupMenu
	{
		public FilePopopMenu(JLazyLoaderTree lazyLoaderTree)
		{		
			JBasicMenuItem newMenuItem = new JBasicMenuItem(LazyLoaderTreeController.getAddAction(lazyLoaderTree, new ElementNode("新增节点", IconFactory.getSwingIcon("solid/add_16.png"), "新增节点")));
			add(newMenuItem);				
			
			JBasicMenuItem deleteMenuItem = new JBasicMenuItem(LazyLoaderTreeController.getDeleteAction(lazyLoaderTree));
			add(deleteMenuItem);				
			
			JBasicMenuItem renameMenuItem = new JBasicMenuItem(LazyLoaderTreeController.getRenameAction(lazyLoaderTree));
			add(renameMenuItem);					
			
			addSeparator();
			
			JBasicMenuItem refreshMenuItem = new JBasicMenuItem(LazyLoaderTreeController.getRefreshAction(lazyLoaderTree));
			add(refreshMenuItem);

			JBasicMenuItem searchMenuItem = new JBasicMenuItem(LazyLoaderTreeController.getSearchAction(lazyLoaderTree));
			add(searchMenuItem);
						
			addSeparator();
		    
			JBasicMenuItem loadModeMenuItem = new JBasicMenuItem(LazyLoaderTreeController.getLoadModeAction(lazyLoaderTree));
			add(loadModeMenuItem);		    
			
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
			
			JBasicMenuItem moveUpAction = new JBasicMenuItem(LazyLoaderTreeController.getMoveUpAction(lazyLoaderTree));
			add(moveUpAction);	
			
			JBasicMenuItem moveDownAction = new JBasicMenuItem(LazyLoaderTreeController.getMoveDownAction(lazyLoaderTree));
			add(moveDownAction);
			
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