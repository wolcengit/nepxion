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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.filechooser.FileSystemView;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import com.nepxion.swing.border.ComplexEtchedBorder;
import com.nepxion.swing.border.ComplexSide;
import com.nepxion.swing.border.ComplexTitleBorder;
import com.nepxion.swing.common.InstallData;
import com.nepxion.swing.frame.JBasicFrame;
import com.nepxion.swing.renderer.tree.TreeDecorationCellRenderer;
import com.nepxion.swing.scrollpane.JBasicScrollPane;
import com.nepxion.swing.tree.lazyloader.AbstractLazyLoader;
import com.nepxion.swing.tree.lazyloader.JLazyLoaderTree;
import com.nepxion.swing.tree.lazyloader.LazyLoaderTreeNode;

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
			
			DefaultMutableTreeNode root = new DefaultMutableTreeNode("File System View");
			
			File[] files = fileSystemView.getRoots();
			for (int i = 0; i < files.length; i++)
			{
				FileNode fileNode = createFileNode(files[i]);
				root.add(fileNode);
			}
			
			DefaultTreeModel treeModel = new DefaultTreeModel(root);
			
			final JLazyLoaderTree lazyLoaderTree = new JLazyLoaderTree();
			lazyLoaderTree.setModel(treeModel);
//			lazyLoaderTree.setRootVisible(false);
			lazyLoaderTree.setCellRendererStyle(TreeDecorationCellRenderer.NIMBUS_STYLE);
			lazyLoaderTree.setLazyLoaderType(JLazyLoaderTree.ASYNCHRONISM);
			lazyLoaderTree.setLazyLoader(new FileLazyLoader());				
			
			JBasicScrollPane lazyLoaderTreeScrollPane = new JBasicScrollPane();
			lazyLoaderTreeScrollPane.getViewport().add(lazyLoaderTree);			
			add(lazyLoaderTreeScrollPane);

			JButton loadButton = new JButton("展开节点");
			loadButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					if (lazyLoaderTree.getSelectionTreeNode() != null)
					{	
						lazyLoaderTree.load(lazyLoaderTree.getSelectionTreeNode());
					}
				}
			}
			);
			add(loadButton);
			
			JButton loadChildrenButton = new JButton("展开子节点");
			loadChildrenButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					if (lazyLoaderTree.getSelectionTreeNode() != null)
					{	
						lazyLoaderTree.loadChildren(lazyLoaderTree.getSelectionTreeNode());
					}										
				}
			}
			);
			add(loadChildrenButton);
			
			JButton expandAllButton = new JButton("展开全部节点");
			expandAllButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					lazyLoaderTree.loadAll();
				}
			}
			);
			add(expandAllButton);			
			
			JButton collapseButton = new JButton("收缩节点");
			collapseButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					if (lazyLoaderTree.getSelectionPath() != null)
					{	
						lazyLoaderTree.collapse(lazyLoaderTree.getSelectionPath());
					}											
				}
			}
			);
			add(collapseButton);
			
			JButton collapseChildrenButton = new JButton("收缩子节点");
			collapseChildrenButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					if (lazyLoaderTree.getSelectionPath() != null)
					{	
						lazyLoaderTree.collapseChildren(lazyLoaderTree.getSelectionPath());
					}											
				}
			}
			);
			add(collapseChildrenButton);
			
			JButton collapseAllButton = new JButton("收缩全部节点");
			collapseAllButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					lazyLoaderTree.collapseAll();										
				}
			}
			);
			add(collapseAllButton);	
			
			JButton cancelButton = new JButton("取消任务");
			cancelButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					if (lazyLoaderTree.getSelectionTreeNode() != null)
					{	
						lazyLoaderTree.cancel(lazyLoaderTree.getSelectionTreeNode());
					}
			}
			}
			);		
			add(cancelButton);
			
			JButton cancelChildrenButton = new JButton("取消子节点任务");
			cancelChildrenButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					if (lazyLoaderTree.getSelectionTreeNode() != null)
					{	
						lazyLoaderTree.cancelChildren(lazyLoaderTree.getSelectionTreeNode());
					}
			}
			}
			);		
			add(cancelChildrenButton);				

			JButton cancelAllButton = new JButton("取消全部任务");
			cancelAllButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					lazyLoaderTree.cancelAll();
				}
			}
			);
			add(cancelAllButton);
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
		
		InstallData installData = new InstallData();
		installData.setText(name);
		installData.setIcon(icon);
		installData.setToolTipText(name);
		
		fileNode.setUserObject(installData);
		return fileNode;
	}
	
	public class FileNode
		extends LazyLoaderTreeNode
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
		public Object loadBackground(LazyLoaderTreeNode lazyLoaderTreeNode)
		{
			FileNode fileNode = (FileNode) lazyLoaderTreeNode;
			File file = fileNode.getFile();
			File[] files = fileSystemView.getFiles(file, true);	
			try
			{
				Thread.sleep(2000);
			}
			catch (InterruptedException e)
			{				
				return null;
			}

			return files;
		}

		public void loadForeground(Object data, LazyLoaderTreeNode lazyLoaderTreeNode)
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
	}	
	
	public static void main(String[] args)
	{
		JBasicFrame frame = new JBasicFrame();
		frame.getContentPane().add(new DemoLazyLoaderTreePanel());
		frame.setSize(1400, 768);
		frame.setVisible(true);
	}
}