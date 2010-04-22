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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.nepxion.swing.border.ComplexEtchedBorder;
import com.nepxion.swing.border.ComplexSide;
import com.nepxion.swing.border.ComplexTitleBorder;
import com.nepxion.swing.checkbox.JBasicCheckBox;
import com.nepxion.swing.handle.HandleManager;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.layout.filed.FiledLayout;
import com.nepxion.swing.optionpane.JBasicOptionPane;
import com.nepxion.swing.popupmenu.JDecorationPopupMenu;
import com.nepxion.swing.tabbedpane.JFlatTabbedPane;

public class DemoFlatTabbedPanePanel
	extends JPanel
{	
	public DemoFlatTabbedPanePanel()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new FlatTabbedPanePanel());
	}
	
	public class FlatTabbedPanePanel
		extends JPanel
	{
		public FlatTabbedPanePanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(new ComplexTitleBorder(new ComplexEtchedBorder(ComplexEtchedBorder.LOWERED, ComplexSide.NORTH), "Flat TabbedPane"));
			
			final JFlatTabbedPane flatTabbedPane = new JFlatTabbedPane()
			{
			    public void removeTabAt(int index)
			    {
			        String title = getTitleAt(index);
			        if (isHint(index))
			        {
			            int selectedValue = JBasicOptionPane.showConfirmDialog(HandleManager.getFrame(DemoFlatTabbedPanePanel.this), "'" + title + "' is modified, sure to close it?", "Close", JBasicOptionPane.YES_NO_OPTION);
			            if (selectedValue == JBasicOptionPane.YES_OPTION)
			            {
			                super.removeTabAt(index);
			            }				        				        	
			        }
			        else
			        {
			        	super.removeTabAt(index);
			        }
			    }				
			};		
			
			flatTabbedPane.addTab("Tab 1", IconFactory.getSwingIcon("component/tabbed_pane_16.png"), new JScrollPane(new ConfigPanel(flatTabbedPane)), "Tab 1", true);					
			flatTabbedPane.addTab("Tab 2", IconFactory.getSwingIcon("component/tabbed_pane_16.png"), new JScrollPane(new ConfigPanel(flatTabbedPane)), "Tab 2", true);
			flatTabbedPane.addTab("Tab 3", IconFactory.getSwingIcon("component/tabbed_pane_16.png"), new JScrollPane(new ConfigPanel(flatTabbedPane)), "Tab 3", true);
			flatTabbedPane.addTab("Tab 4", IconFactory.getSwingIcon("component/tabbed_pane_16.png"), new JScrollPane(new ConfigPanel(flatTabbedPane)), "Tab 4", true);
			flatTabbedPane.addTab("Tab 5", IconFactory.getSwingIcon("component/tabbed_pane_16.png"), new JScrollPane(new ConfigPanel(flatTabbedPane)), "Tab 5", true);
			flatTabbedPane.addTab("Tab 6", IconFactory.getSwingIcon("component/tabbed_pane_16.png"), new JScrollPane(new ConfigPanel(flatTabbedPane)), "Tab 6", true);
			flatTabbedPane.addTab("Tab 7", IconFactory.getSwingIcon("component/tabbed_pane_16.png"), new JScrollPane(new ConfigPanel(flatTabbedPane)), "Tab 7", true);
			flatTabbedPane.addTab("Tab 8", IconFactory.getSwingIcon("component/tabbed_pane_16.png"), new JScrollPane(new ConfigPanel(flatTabbedPane)), "Tab 8", true);
			
			JDecorationPopupMenu popupMenu = new JDecorationPopupMenu();
			flatTabbedPane.setPopupMenu(popupMenu, true);
			
			add(flatTabbedPane);			
		}
	}
	
	public class ConfigPanel
		extends JPanel
	{
		public ConfigPanel(final JFlatTabbedPane flatTabbedPane)
		{
			setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 0));
			setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
			
			final JBasicCheckBox closableCheckBox = new JBasicCheckBox("Show Close Button", true);
			closableCheckBox.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					flatTabbedPane.setTabClosableAt(flatTabbedPane.getSelectedIndex(), closableCheckBox.isSelected());
				}				
			}
			);			
			add(closableCheckBox);	
			
			final JBasicCheckBox drawCenterCheckBox = new JBasicCheckBox("Close Button - Draw Center", true);
			drawCenterCheckBox.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					flatTabbedPane.setDrawCenter(flatTabbedPane.getSelectedIndex(), drawCenterCheckBox.isSelected());
				}				
			}
			);				
			add(drawCenterCheckBox);	
			
			final JBasicCheckBox drawBorderCheckBox = new JBasicCheckBox("Close Button - Draw Border", true);
			drawBorderCheckBox.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					flatTabbedPane.setDrawBorder(flatTabbedPane.getSelectedIndex(), drawBorderCheckBox.isSelected());
				}				
			}
			);				
			add(drawBorderCheckBox);		
			
			final JBasicCheckBox hintCheckBox = new JBasicCheckBox("Show hint before closing", false);
			hintCheckBox.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					flatTabbedPane.setHint(flatTabbedPane.getSelectedIndex(), hintCheckBox.isSelected());
				}				
			}
			);			
			add(hintCheckBox);	
			
			final JBasicCheckBox marginCheckBox = new JBasicCheckBox("Margin (=3) between Close Button & Icon", false);
			marginCheckBox.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					flatTabbedPane.setMargin(flatTabbedPane.getSelectedIndex(), marginCheckBox.isSelected() ? 3 : 0);
				}				
			}
			);				
			add(marginCheckBox);			
		}
	}
}