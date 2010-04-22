package com.nepxion.demo;

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
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import com.nepxion.demo.common.DemoToggleContentPanel;
import com.nepxion.swing.framework.dockable.JDockable;
import com.nepxion.swing.framework.dockable.JDockableView;
import com.nepxion.swing.framework.dockable.JFrameWorkHierarchy;
import com.nepxion.swing.framework.dockable.JFrameWorkStatusBar;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.menubar.JBasicMenuBar;
import com.nepxion.swing.toolbar.JBasicToolBar;

public class DemoHierarchy
	extends JFrameWorkHierarchy
{
    public final static String EXPLORER_TITLE = "Explorer";
    public final static String CONTENT_PANE_TITLE = "ContentPane";
    
    public DemoHierarchy()
    {
        initContentPane();
        initMenuBar();
        initToolBar();
        initStatusBar();
    }
    
    private void initContentPane()
    {
    	JDockableView explorerView = new JDockableView(EXPLORER_TITLE, IconFactory.getSwingIcon("explorer.png"), DemoOutlookBar.getInstance());        
        JDockableView contentPaneView = new JDockableView(CONTENT_PANE_TITLE, IconFactory.getSwingIcon("content_pane.png"), DemoToggleContentPanel.getInstance());

        JDockable dockable = new JDockable();
        dockable.setOrientation(JDockable.HORIZONTAL_SPLIT);
        dockable.add(explorerView, JDockable.FLEXIBLE);
        dockable.add(contentPaneView, JDockable.VARY);
        
        dockable.setDividerLocation(0, 170);
                                
        getDockableContainer().setContentPane(dockable);
    }

    private void initMenuBar()
    {
        JBasicMenuBar menuBar = getMenuBar();
        
        JMenu menu = new JMenu("Help");
        menuBar.add(menu);

        JMenuItem clearMenuItem = new JMenuItem("Test");
		clearMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_MASK));	
		clearMenuItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
            	
            }
        }
		);  
		menu.add(clearMenuItem);
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