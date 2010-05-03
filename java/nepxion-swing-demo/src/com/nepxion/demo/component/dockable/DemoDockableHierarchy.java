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
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

import com.nepxion.demo.DemoHierarchyController;
import com.nepxion.demo.common.DemoComponentFactory;
import com.nepxion.demo.swing.scrollpane.DemoBarScrollPanePanel;
import com.nepxion.swing.framework.dockable.FrameWorkManager;
import com.nepxion.swing.framework.dockable.JDockable;
import com.nepxion.swing.framework.dockable.JDockableSplitPane;
import com.nepxion.swing.framework.dockable.JDockableTabbedPane;
import com.nepxion.swing.framework.dockable.JDockableView;
import com.nepxion.swing.framework.dockable.JFrameWorkHierarchy;
import com.nepxion.swing.framework.dockable.JFrameWorkStatusBar;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.menubar.JBasicMenuBar;
import com.nepxion.swing.menuitem.JLiteCheckBoxMenuItem;
import com.nepxion.swing.textarea.JBasicTextArea;
import com.nepxion.swing.toolbar.JBasicToolBar;

public class DemoDockableHierarchy
	extends JFrameWorkHierarchy
{
    public final static String EXPLORER_TITLE = "Explorer";
    public final static String CONTENT_PANE_TITLE = "ContentPane";
    
    public DemoDockableHierarchy()
    {
        initContentPane();
        initMenuBar();
        initToolBar();
        initStatusBar();
    }
    
    private void initContentPane()
    {
//    	JDockableView explorerView = new JDockableView(EXPLORER_TITLE, IconFactory.getSwingIcon("explorer.png"), new JPanel());
//		JDockableView contentPaneView = new JDockableView(CONTENT_PANE_TITLE, IconFactory.getSwingIcon("content_pane.png"), new JPanel());
//		
//		JDockable dockable = new JDockable();
//		dockable.setOrientation(JDockable.HORIZONTAL_SPLIT);
//		dockable.add(explorerView, JDockable.FLEXIBLE);
//		dockable.add(contentPaneView, JDockable.VARY);
//		
//		dockable.setDividerLocation(0, 170);
//		
//		getDockableContainer().setContentPane(dockable);
    	
        JDockableView treeView = new JDockableView("Tree View", IconFactory.getSwingIcon("component/tree_16.png"), new JScrollPane(DemoComponentFactory.getTree()));
        JDockableView tableView = new JDockableView("Table View", IconFactory.getSwingIcon("component/table_16.png"), new JScrollPane(DemoComponentFactory.getTable()));
        JDockableView textAreaView = new JDockableView("TextArea View", IconFactory.getSwingIcon("component/text_area_16.png"), new JScrollPane(new JBasicTextArea()));
        JDockableView dockableView3 = new JDockableView("Docking Panel4", IconFactory.getContextIcon("apply.png"), new JTextArea());

        // ππ‘ÏdockableView4
        JDockableSplitPane splitPane = new JDockableSplitPane();
        splitPane.setOrientation(JDockableSplitPane.VERTICAL_SPLIT);

        JDockableTabbedPane tabbedPane1 = new JDockableTabbedPane();
        tabbedPane1.setTabPlacement(JDockableTabbedPane.TOP);
        tabbedPane1.addTab("TextArea1", new JTextArea());

        JDockableTabbedPane tabbedPane2 = new JDockableTabbedPane();
        tabbedPane2.setTabPlacement(JDockableTabbedPane.BOTTOM);
        tabbedPane2.setVerticalTabPlacement(JDockableTabbedPane.BOTTOM);

        tabbedPane2.addTab("TextArea2", new JTextArea(), true);
        tabbedPane2.addTab("TextArea3", new JTextArea());
        tabbedPane2.addTab("TextArea4", new JTextArea(), true);

        splitPane.add(tabbedPane1);
        splitPane.add(tabbedPane2);
        ////////////////////////

        JDockableView dockableView4 = new JDockableView("Docking Panel5", IconFactory.getContextIcon("apply.png"), splitPane);
        JDockableView dockableView5 = new JDockableView("Docking Panel6", IconFactory.getContextIcon("apply.png"), new DemoBarScrollPanePanel());

        JDockable dockable = new JDockable();
        dockable.setOrientation(JDockable.VERTICAL_SPLIT);
        dockable.add(treeView, JDockable.FLEXIBLE);
        dockable.add(tableView, JDockable.FLEXIBLE);
        dockable.add(textAreaView, JDockable.VARY);
        dockable.setDividerLocation(0, 150);
        dockable.setDividerLocation(1, 80);

        JDockable dockable2 = new JDockable();
        dockable2.setOrientation(JDockable.VERTICAL_SPLIT);
        dockable2.add(dockableView3);
        dockable2.add(dockableView4);

        JDockable dockable1 = new JDockable();
        dockable1.setOrientation(JDockable.HORIZONTAL_SPLIT);
        dockable1.add(dockable, JDockable.FLEXIBLE);
        dockable1.add(dockableView5, JDockable.VARY);
        dockable1.add(dockable2, JDockable.FLEXIBLE);
        dockable1.setDividerLocation(0, 200);
        dockable1.setDividerLocation(2, 300); 
        
        getDockableContainer().setContentPane(dockable1);
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