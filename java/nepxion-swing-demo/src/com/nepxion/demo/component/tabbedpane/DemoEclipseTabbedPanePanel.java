package com.nepxion.demo.component.tabbedpane;

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
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.UIResource;

import com.nepxion.demo.common.DemoDataFactory;
import com.nepxion.swing.border.ComplexEtchedBorder;
import com.nepxion.swing.border.ComplexSide;
import com.nepxion.swing.border.ComplexTitleBorder;
import com.nepxion.swing.checkbox.JBasicCheckBox;
import com.nepxion.swing.combobox.JBasicComboBox;
import com.nepxion.swing.common.InstallData;
import com.nepxion.swing.handle.HandleManager;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.item.BasicItemListener;
import com.nepxion.swing.layout.filed.FiledLayout;
import com.nepxion.swing.optionpane.JBasicOptionPane;
import com.nepxion.swing.popupmenu.JDecorationPopupMenu;
import com.nepxion.swing.renderer.combobox.ComboBoxIconCellRenderer;
import com.nepxion.swing.tabbedpane.JEclipseTabbedPane;
import com.nepxion.util.data.CollectionUtil;

public class DemoEclipseTabbedPanePanel
	extends JPanel
{	
	private JEclipseTabbedPane eclipseTabbedPane;
	
	public DemoEclipseTabbedPanePanel()
	{
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new EclipseTabbedPanePanel(), BorderLayout.CENTER);
		add(new PublicConfigPanel(), BorderLayout.SOUTH);
	}
	
	public class EclipseTabbedPanePanel
		extends JPanel
	{
		public EclipseTabbedPanePanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(new ComplexTitleBorder(new ComplexEtchedBorder(ComplexEtchedBorder.LOWERED, ComplexSide.NORTH), "Eclipse TabbedPane"));
			
			eclipseTabbedPane = new JEclipseTabbedPane()
			{			    
			    public void removeTabAt(int index)
			    {
			        String title = getTitleAt(index);
			        int selectedValue = JBasicOptionPane.showConfirmDialog(HandleManager.getFrame(DemoEclipseTabbedPanePanel.this), "'" + title + "' is modified, sure to close it?", "Close", JBasicOptionPane.YES_NO_OPTION);
			        if (selectedValue == JBasicOptionPane.YES_OPTION)
			        {
			            super.removeTabAt(index);
			        }
			    }			    
			};	
			
			eclipseTabbedPane.addTab("Tab 1", IconFactory.getSwingIcon("component/tabbed_pane_16.png"), new PrivateConfigPanel(), "Tab 1", true);					
			eclipseTabbedPane.addTab("Tab 2", IconFactory.getSwingIcon("component/tabbed_pane_16.png"), new PrivateConfigPanel(), "Tab 2", true);
			eclipseTabbedPane.addTab("Tab 3", IconFactory.getSwingIcon("component/tabbed_pane_16.png"), new PrivateConfigPanel(), "Tab 3", true);
			eclipseTabbedPane.addTab("Tab 4", IconFactory.getSwingIcon("component/tabbed_pane_16.png"), new PrivateConfigPanel(), "Tab 4", true);
			eclipseTabbedPane.addTab("Tab 5", IconFactory.getSwingIcon("component/tabbed_pane_16.png"), new PrivateConfigPanel(), "Tab 5", true);
			eclipseTabbedPane.addTab("Tab 6", IconFactory.getSwingIcon("component/tabbed_pane_16.png"), new PrivateConfigPanel(), "Tab 6", true);
			eclipseTabbedPane.addTab("Tab 7", IconFactory.getSwingIcon("component/tabbed_pane_16.png"), new PrivateConfigPanel(), "Tab 7", true);
			eclipseTabbedPane.addTab("Tab 8", IconFactory.getSwingIcon("component/tabbed_pane_16.png"), new PrivateConfigPanel(), "Tab 8", true);
			
			JDecorationPopupMenu popupMenu = new JDecorationPopupMenu();
			eclipseTabbedPane.setPopupMenu(popupMenu, true);
			
			add(eclipseTabbedPane);	

//	        setTabPlacement(JEclipseTabbedPane.TOP);
//	        setShowTabButtons(true);
//	        setShowCloseButton(true);
//	        setShowCloseButtonOnTab(true);
//	        setHideOneTab(true);
//	        setTabEditingAllowed(true);
//	        setTabClosableAt(2, false);			
		}
	}
	
	public class PublicConfigPanel
		extends JPanel
	{		
		public PublicConfigPanel()
		{
			setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 0));
			setBorder(new ComplexTitleBorder(new ComplexEtchedBorder(ComplexEtchedBorder.LOWERED, ComplexSide.NORTH), "Public Configuration"));
			
			List tabShapeInstallDatas = DemoDataFactory.getEclipseTabShapeInstallDatas();
			
			final JBasicComboBox tabShapeComboBox = new JBasicComboBox(CollectionUtil.parseVector(tabShapeInstallDatas));
			tabShapeComboBox.setRenderer(new ComboBoxIconCellRenderer());
			tabShapeComboBox.addItemListener(new BasicItemListener()
			{
				public void itemSelectionStateChanged(ItemEvent e)
				{
					InstallData installdata = (InstallData) tabShapeComboBox.getSelectedItem();
					eclipseTabbedPane.setTabShape(installdata.getIndex());
				}
			}
			);
			add(tabShapeComboBox);
	        
	        final JBasicCheckBox showTabAreaCheckBox = new JBasicCheckBox("Show Tab Area", true);	
	        showTabAreaCheckBox.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					eclipseTabbedPane.setShowTabArea(showTabAreaCheckBox.isSelected());
				}				
			}
			);	
	        add(showTabAreaCheckBox);	        
	        
	        final JBasicCheckBox hideTabAreaCheckBox = new JBasicCheckBox("Show Tab Area If More Than One Tabs Shown", false);	
	        hideTabAreaCheckBox.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					eclipseTabbedPane.setHideOneTab(hideTabAreaCheckBox.isSelected());
				}				
			}
			);	
	        add(hideTabAreaCheckBox);	
	        
	        final JBasicCheckBox showTabContentCheckBox = new JBasicCheckBox("Show Tab Content", true);	
	        showTabContentCheckBox.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					eclipseTabbedPane.setShowTabContent(showTabContentCheckBox.isSelected());
				}				
			}
			);	
	        add(showTabContentCheckBox);		        
						
	        final JBasicCheckBox showTabButtonsCheckBox = new JBasicCheckBox("Show Tab Buttons", false);	
	        showTabButtonsCheckBox.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					eclipseTabbedPane.setShowTabButtons(showTabButtonsCheckBox.isSelected());
				}				
			}
			);	
	        add(showTabButtonsCheckBox);	
			
			final JBasicCheckBox showBoldFontCheckBox = new JBasicCheckBox("Show Bold Font In Selection Tab", false);
			showBoldFontCheckBox.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					eclipseTabbedPane.setBoldActiveTab(showBoldFontCheckBox.isSelected());
				}				
			}
			);			
			add(showBoldFontCheckBox);	
			
			final JBasicCheckBox showTabLeadingComponentCheckBox = new JBasicCheckBox("Show Tab Leading Component", false);
			showTabLeadingComponentCheckBox.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
	                if (showTabLeadingComponentCheckBox.isSelected())
					{	             
	                	Component leadingComponent = new LabelUIResource(IconFactory.getSwingIcon("logo.png"));
						eclipseTabbedPane.setTabLeadingComponent(leadingComponent);
					}
					else
					{
						eclipseTabbedPane.setTabLeadingComponent(null);
					}
				}				
			}
			);			
			add(showTabLeadingComponentCheckBox);	
			
			final JBasicCheckBox showTabTrailingComponentCheckBox = new JBasicCheckBox("Show Tab Trailing Component", false);
			showTabTrailingComponentCheckBox.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
	                if (showTabTrailingComponentCheckBox.isSelected())
					{	             
	                	Component leadingComponent = new LabelUIResource(IconFactory.getSwingIcon("logo.png"));
						eclipseTabbedPane.setTabTrailingComponent(leadingComponent);
					}
					else
					{
						eclipseTabbedPane.setTabTrailingComponent(null);
					}
				}				
			}
			);			
			add(showTabTrailingComponentCheckBox);		
			
	        final JBasicCheckBox allowEditingTabTitleCheckBox = new JBasicCheckBox("Allow Editing Tab Title", false);
	        allowEditingTabTitleCheckBox.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					eclipseTabbedPane.setTabEditingAllowed(allowEditingTabTitleCheckBox.isSelected());
				}
			}
	        );
	        add(allowEditingTabTitleCheckBox);

//	        final JCheckBox allowDuplicateTabNames = new JCheckBox("Allow Duplicate Tab Names");
//	        allowDuplicateTabNames.setSelected(_tabbedPane.isTabEditingAllowed());
//	        allowDuplicateTabNames.addItemListener(new ItemListener() {
//	            public void itemStateChanged(ItemEvent e) {
//	                _allowDuplicateTabNames = allowDuplicateTabNames.isSelected();
//	            }
//	        }
//	        );			
		}
	}
	
	public class PrivateConfigPanel
		extends JPanel
	{		
		public PrivateConfigPanel()
		{
			setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 0));
			setBorder(new ComplexTitleBorder(new ComplexEtchedBorder(ComplexEtchedBorder.LOWERED, ComplexSide.NORTH), "Private Configuration"));	
	        
			final JBasicCheckBox showCloseButtonCheckBox = new JBasicCheckBox("Show Close Button", true);
			showCloseButtonCheckBox.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					eclipseTabbedPane.setTabClosableAt(eclipseTabbedPane.getSelectedIndex(), showCloseButtonCheckBox.isSelected());
				}				
			}
			);			
			add(showCloseButtonCheckBox);	
		}
	}	
	
    public class LabelUIResource
		extends JLabel implements UIResource
	{
		public LabelUIResource(String text)
		{
			super(text);
		}
		
		public LabelUIResource(Icon image)
		{
			super(image);
		}		
	}	
}