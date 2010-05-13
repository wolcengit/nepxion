package com.nepxion.demo.component.dockable;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;

import com.nepxion.demo.DemoHierarchyController;
import com.nepxion.demo.common.DemoComponentFactory;
import com.nepxion.demo.common.DemoDataFactory;
import com.nepxion.swing.framework.dockable.FrameWorkManager;
import com.nepxion.swing.framework.dockable.JDockable;
import com.nepxion.swing.framework.dockable.JDockableView;
import com.nepxion.swing.framework.dockable.JFrameWorkHierarchy;
import com.nepxion.swing.framework.dockable.JFrameWorkStatusBar;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.menubar.JBasicMenuBar;
import com.nepxion.swing.menuitem.JLiteCheckBoxMenuItem;
import com.nepxion.swing.selector.checkbox.JCheckBoxPanel;
import com.nepxion.swing.selector.radiobutton.JRadioButtonPanel;
import com.nepxion.swing.textarea.JBasicTextArea;
import com.nepxion.swing.toolbar.JBasicToolBar;

public class DemoDockableHierarchy
	extends JFrameWorkHierarchy
{
    public final static String TREE_TITLE = "Tree View";
    public final static String TABLE_TITLE = "Table View";
    public final static String TEXT_AREA_TITLE = "TextArea View";   
    public final static String TABBED_PANE_TITLE = "TabbedPane View";   
    public final static String LIST_TITLE = "List View"; 
    public final static String CHECK_BOX_SELECTOR_TITLE = "CheckBox Selector View";    
    public final static String RADIO_BUTTON_SELECTOR_TITLE = "RadioButton Selector View";        
    
    public DemoDockableHierarchy()
    {
        initContentPane();
        initMenuBar();
        initToolBar();
        initStatusBar();
    }
    
    private void initContentPane()
    {    	
        JDockableView treeView = new JDockableView(TREE_TITLE, IconFactory.getSwingIcon("component/tree_16.png"), new JScrollPane(DemoComponentFactory.getTree()));
        JDockableView tableView = new JDockableView(TABLE_TITLE, IconFactory.getSwingIcon("component/table_16.png"), new JScrollPane(DemoComponentFactory.getTable()));
        JDockableView textAreaView = new JDockableView(TEXT_AREA_TITLE, IconFactory.getSwingIcon("component/text_area_16.png"), new JScrollPane(new JBasicTextArea("TextArea View")));
        
        JDockable leftDockable = new JDockable();
        leftDockable.setOrientation(JDockable.VERTICAL_SPLIT);
        leftDockable.add(treeView, JDockable.FLEXIBLE);
        leftDockable.add(tableView, JDockable.FLEXIBLE);
        leftDockable.add(textAreaView, JDockable.VARY);
        leftDockable.setDividerLocation(0, 250);
        leftDockable.setDividerLocation(1, 200);
        
        JDockableView tabbedPaneView = new JDockableView(TABBED_PANE_TITLE, IconFactory.getSwingIcon("component/tabbed_pane_16.png"), DemoComponentFactory.getTabbedPane());
        
        JDockableView listView = new JDockableView(LIST_TITLE, IconFactory.getSwingIcon("component/list_16.png"), new JScrollPane(DemoComponentFactory.getList()));
        JDockableView checkBoxSelectorView = new JDockableView(CHECK_BOX_SELECTOR_TITLE, IconFactory.getSwingIcon("component/check_box_16.png"), new JCheckBoxPanel(DemoDataFactory.getComponentInstallDatas()));
        JDockableView radioButtonSelectorView = new JDockableView(RADIO_BUTTON_SELECTOR_TITLE, IconFactory.getSwingIcon("component/radio_button_16.png"), new JRadioButtonPanel(DemoDataFactory.getComponentInstallDatas()));
        
        JDockable rightDockable = new JDockable();
        rightDockable.setOrientation(JDockable.VERTICAL_SPLIT);
        rightDockable.add(listView);
        rightDockable.add(checkBoxSelectorView); 
        rightDockable.add(radioButtonSelectorView);
        
//        JDockableSplitPane splitPane = new JDockableSplitPane();
//        splitPane.setOrientation(JDockableSplitPane.VERTICAL_SPLIT);
//
//        JDockableTabbedPane tabbedPane1 = new JDockableTabbedPane();
//        tabbedPane1.setTabPlacement(JDockableTabbedPane.TOP);
//        tabbedPane1.addTab("TextArea1", new JTextArea());
//
//        JDockableTabbedPane tabbedPane2 = new JDockableTabbedPane();
//        tabbedPane2.setTabPlacement(JDockableTabbedPane.BOTTOM);
//        tabbedPane2.setVerticalTabPlacement(JDockableTabbedPane.BOTTOM);
//
//        tabbedPane2.addTab("TextArea2", new JTextArea(), true);
//        tabbedPane2.addTab("TextArea3", new JTextArea());
//        tabbedPane2.addTab("TextArea4", new JTextArea(), true);
//
//        splitPane.add(tabbedPane1);
//        splitPane.add(tabbedPane2);
//
//        JDockableView dockableView4 = new JDockableView("Docking Panel5", IconFactory.getContextIcon("apply.png"), splitPane);

        JDockable dockable = new JDockable();
        dockable.setOrientation(JDockable.HORIZONTAL_SPLIT);
        dockable.add(leftDockable, JDockable.FLEXIBLE);
        dockable.add(tabbedPaneView, JDockable.VARY);
        dockable.add(rightDockable, JDockable.FLEXIBLE);
        dockable.setDividerLocation(0, 200);
        dockable.setDividerLocation(2, 300); 
        
        getDockableContainer().setContentPane(dockable);
    }

    private void initMenuBar()
    {
        JBasicMenuBar menuBar = getMenuBar();
        
        JMenu menu = FrameWorkManager.getToggleMenu(this);
        ((JLiteCheckBoxMenuItem) menu.getMenuComponent(1)).doClick();
        menuBar.add(menu);
        
        JMenu helpMenu = new JMenu("Help");
        helpMenu.setMnemonic('H');
        menuBar.add(helpMenu);

        JMenuItem aboutMenuItem = new JMenuItem(DemoHierarchyController.getAboutAction());
        aboutMenuItem.setMnemonic('A');
        aboutMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));        
        helpMenu.add(aboutMenuItem);
    }

    private void initToolBar()
    {
        JBasicToolBar toolBar = getToolBar();
    }

    private void initStatusBar()
    {
        JFrameWorkStatusBar statusBar = getStatusBar();
    }
}