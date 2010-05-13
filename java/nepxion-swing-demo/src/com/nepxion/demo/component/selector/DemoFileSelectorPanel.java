package com.nepxion.demo.component.selector;

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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import sun.awt.shell.ShellFolder;

import com.nepxion.demo.common.DemoSelectionValuePanel;
import com.nepxion.swing.border.ComplexEtchedBorder;
import com.nepxion.swing.border.ComplexSide;
import com.nepxion.swing.border.ComplexTitleBorder;
import com.nepxion.swing.button.ButtonManager;
import com.nepxion.swing.button.JBasicButton;
import com.nepxion.swing.handle.HandleManager;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.layout.filed.FiledLayout;
import com.nepxion.swing.selector.file.JFileFilter;
import com.nepxion.swing.selector.file.JFileSelector;
import com.nepxion.swing.selector.file.JFolderSelector;

public class DemoFileSelectorPanel
	extends JPanel
{
	private DemoSelectionValuePanel selectionValuePanel;
	
	public DemoFileSelectorPanel()
	{
		setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 0));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		selectionValuePanel = new DemoSelectionValuePanel();
		
		add(new FileSelectorPanel());
		add(new FolderSelectorPanel());
		add(selectionValuePanel);
	}
	
	public class FileSelectorPanel
		extends JPanel
	{
		public FileSelectorPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(new ComplexTitleBorder(new ComplexEtchedBorder(ComplexEtchedBorder.LOWERED, ComplexSide.NORTH), "File Selector"));
			
			JBasicButton openFileButton = new JBasicButton("Open File", IconFactory.getSwingIcon("component/file_chooser_16.png"), "Open File");
			openFileButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					Collection officeFilterWords = new ArrayList(Arrays.asList(new String[] {"doc", "xls", "ppt"}));
					String officeFilterDescription = "Office File(*.doc, *.xls, *.ppt)";
					JFileFilter officeFileFilter = new JFileFilter(officeFilterWords, officeFilterDescription);
					
					Collection docFilterWords = new ArrayList(Arrays.asList(new String[] {"doc"}));
					String docFilterDescription = "Word File(*.doc)";
					JFileFilter docFileFilter = new JFileFilter(docFilterWords, docFilterDescription);
					
					Collection xlsFilterWords = new ArrayList(Arrays.asList(new String[] {"xls"}));
					String xlsFilterDescription = "Excel File(*.xls)";
					JFileFilter xlsFileFilter = new JFileFilter(xlsFilterWords, xlsFilterDescription);
					
					Collection pptFilterWords = new ArrayList(Arrays.asList(new String[] {"ppt"}));
					String pptFilterDescription = "PowerPoint File(*.ppt)";
					JFileFilter pptFileFilter = new JFileFilter(pptFilterWords, pptFilterDescription);
					
					JFileSelector fileSelector = new JFileSelector(HandleManager.getFrame(DemoFileSelectorPanel.this), "Open Office File");
					fileSelector.addChoosableFileFilter(officeFileFilter);
					fileSelector.addChoosableFileFilter(docFileFilter);
					fileSelector.addChoosableFileFilter(xlsFileFilter);
					fileSelector.addChoosableFileFilter(pptFileFilter);
					fileSelector.setFileFilter(officeFileFilter);
					
					File file = fileSelector.openFile();
					if (file != null)
					{
						selectionValuePanel.setValue(file.getAbsolutePath());
					}
				}
			}
			);
			add(openFileButton);
			
			JBasicButton saveFileButton = new JBasicButton("Save File", IconFactory.getSwingIcon("component/file_chooser_16.png"), "Save File");
			saveFileButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					Collection officeFilterWords = new ArrayList(Arrays.asList(new String[] {"doc", "xls", "ppt"}));
					String officeFilterDescription = "Office File(*.doc, *.xls, *.ppt)";
					JFileFilter officeFileFilter = new JFileFilter(officeFilterWords, officeFilterDescription);
					
					Collection docFilterWords = new ArrayList(Arrays.asList(new String[] {"doc"}));
					String docFilterDescription = "Word File(*.doc)";
					JFileFilter docFileFilter = new JFileFilter(docFilterWords, docFilterDescription);
					
					Collection xlsFilterWords = new ArrayList(Arrays.asList(new String[] {"xls"}));
					String xlsFilterDescription = "Excel File(*.xls)";
					JFileFilter xlsFileFilter = new JFileFilter(xlsFilterWords, xlsFilterDescription);
					
					Collection pptFilterWords = new ArrayList(Arrays.asList(new String[] {"ppt"}));
					String pptFilterDescription = "PowerPoint File(*.ppt)";
					JFileFilter pptFileFilter = new JFileFilter(pptFilterWords, pptFilterDescription);
					
					JFileSelector fileSelector = new JFileSelector(HandleManager.getFrame(DemoFileSelectorPanel.this), "Save Office File");
					fileSelector.addChoosableFileFilter(officeFileFilter);
					fileSelector.addChoosableFileFilter(docFileFilter);
					fileSelector.addChoosableFileFilter(xlsFileFilter);
					fileSelector.addChoosableFileFilter(pptFileFilter);
					fileSelector.setFileFilter(officeFileFilter);
					
					String filePath = fileSelector.saveFile(null);
					if (filePath != null)
					{
						selectionValuePanel.setValue(filePath);
					}
				}
			}
			);
			add(saveFileButton);
			
			JBasicButton openDirectoryButton = new JBasicButton("Open Directory", IconFactory.getSwingIcon("component/file_chooser_16.png"), "Open Directory");
			openDirectoryButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					JFileSelector fileSelector = new JFileSelector(HandleManager.getFrame(DemoFileSelectorPanel.this), "Open Directory");
					File file = fileSelector.openDirectory();
					if (file != null)
					{
						selectionValuePanel.setValue(file.getAbsolutePath());
					}
				}
			}
			);
			add(openDirectoryButton);
			
			ButtonManager.updateUI(this);
		}
	}
	
	public class FolderSelectorPanel
		extends JPanel
	{
		public FolderSelectorPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(new ComplexTitleBorder(new ComplexEtchedBorder(ComplexEtchedBorder.LOWERED, ComplexSide.NORTH), "Folder Selector"));
			
			JBasicButton openFolderButton = new JBasicButton("Open Folder", IconFactory.getSwingIcon("component/file_chooser_16.png"), "Open Folder");
			openFolderButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					JFolderSelector folderChooser = new JFolderSelector();
					ArrayList recentList = new ArrayList();
					// File currentFolder = folderChooser.getFileSystemView().createFileObject("fileChooserDefaultFolder");
					File currentFolder = (File) ShellFolder.get("fileChooserDefaultFolder");
					folderChooser.setCurrentDirectory(currentFolder);
					folderChooser.setRecentList(recentList);
					folderChooser.setFileHidingEnabled(true);
					
					int returnValue = folderChooser.showOpenDialog(HandleManager.getFrame(DemoFileSelectorPanel.this));
					if (returnValue == JFolderSelector.APPROVE_OPTION)
					{
						currentFolder = folderChooser.getSelectedFile();
						recentList.add(currentFolder);
						File file = folderChooser.getSelectedFile();
						selectionValuePanel.setValue(file.getAbsolutePath());
					}
				}
			}
			);
			add(openFolderButton);
			
			ButtonManager.updateUI(this);
		}
	}
}