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

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import sun.awt.shell.ShellFolder;

import com.nepxion.swing.border.ComplexEtchedBorder;
import com.nepxion.swing.border.ComplexSide;
import com.nepxion.swing.border.ComplexTitleBorder;
import com.nepxion.swing.button.ButtonManager;
import com.nepxion.swing.button.JFlatButton;
import com.nepxion.swing.handle.HandleManager;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.layout.filed.FiledLayout;
import com.nepxion.swing.selector.file.JFileFilter;
import com.nepxion.swing.selector.file.JFileSelector;
import com.nepxion.swing.selector.file.JFolderSelector;
import com.nepxion.swing.textfield.JBasicTextField;

public class DemoFileSelectorPanel
	extends JPanel
{
	private SelectorValuePanel selectorValuePanel;
	
	public DemoFileSelectorPanel()
	{
		setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 0));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		selectorValuePanel = new SelectorValuePanel();
		
		add(new FileSelectorPanel());
		add(new FolderSelectorPanel());
		add(selectorValuePanel);
	}
	
	public class FileSelectorPanel
		extends JPanel
	{
		public FileSelectorPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(new ComplexTitleBorder(new ComplexEtchedBorder(ComplexEtchedBorder.LOWERED, ComplexSide.NORTH), "File Selector"));
			
			JFlatButton openFileButton = new JFlatButton("Open File", IconFactory.getSwingIcon("component/file_chooser_16.png"));
			openFileButton.setDimension(new Dimension(80, 30));
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
						selectorValuePanel.setValue(file.getAbsolutePath());
					}
				}
			}
			);
			add(openFileButton);
			
			JFlatButton saveFileButton = new JFlatButton("Save File", IconFactory.getSwingIcon("component/file_chooser_16.png"));
			saveFileButton.setDimension(new Dimension(80, 30));
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
						selectorValuePanel.setValue(filePath);
					}
				}
			}
			);
			add(saveFileButton);
			
			JFlatButton openDirectoryButton = new JFlatButton("Open Directory", IconFactory.getSwingIcon("component/file_chooser_16.png"));
			openDirectoryButton.setDimension(new Dimension(110, 30));
			openDirectoryButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					JFileSelector fileSelector = new JFileSelector(HandleManager.getFrame(DemoFileSelectorPanel.this), "Open Directory");
					File file = fileSelector.openDirectory();
					if (file != null)
					{
						selectorValuePanel.setValue(file.getAbsolutePath());
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
			
			JFlatButton openFolderButton = new JFlatButton("Open Folder", IconFactory.getSwingIcon("component/file_chooser_16.png"));
			openFolderButton.setDimension(new Dimension(97, 30));
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
						selectorValuePanel.setValue(file.getAbsolutePath());
					}
				}
			}
			);
			add(openFolderButton);
			
			ButtonManager.updateUI(this);
		}
	}
	
	public class SelectorValuePanel
		extends JPanel
	{
		private JBasicTextField textField;
		
		public SelectorValuePanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(new ComplexTitleBorder(new ComplexEtchedBorder(ComplexEtchedBorder.LOWERED, ComplexSide.NORTH), "Selection Value"));
			
			textField = new JBasicTextField();
			textField.setOpaque(false);
			textField.setPreferredSize(new Dimension(225, textField.getPreferredSize().height));
			textField.setMaximumSize(new Dimension(225, textField.getPreferredSize().height));
			textField.setMinimumSize(new Dimension(225, textField.getPreferredSize().height));
			textField.setSize(new Dimension(225, textField.getPreferredSize().height));
			
			add(new JLabel("Your Selection Value"));
			add(textField);
		}
		
		public void setValue(String value)
		{
			textField.setText(value);
		}
	}
}