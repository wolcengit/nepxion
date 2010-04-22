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

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.SwingUtilities;

import com.nepxion.demo.common.DemoToggleContentPanel;
import com.nepxion.swing.button.ButtonManager;
import com.nepxion.swing.button.JFlatMenuButton;
import com.nepxion.swing.framework.dockable.JDockable;
import com.nepxion.swing.framework.dockable.JDockableView;
import com.nepxion.swing.framework.dockable.JFrameWorkHierarchy;
import com.nepxion.swing.framework.dockable.JFrameWorkStatusBar;
import com.nepxion.swing.framework.dockable.JFrameWorkThread;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.lookandfeel.LookAndFeelManager;
import com.nepxion.swing.menubar.JBasicMenuBar;
import com.nepxion.swing.popupmenu.JDecorationPopupMenu;
import com.nepxion.swing.progressbar.JThreadProgressBar;
import com.nepxion.swing.statusbar.JStatusBar;
import com.nepxion.swing.statusbar.JStatusItem;
import com.nepxion.swing.toolbar.JBasicToolBar;

public class DemoInitializer
{
    private JFrameWorkHierarchy frameWorkHierarchy;

    public DemoInitializer(JFrameWorkHierarchy frameWorkHierarchy)
    {
        this.frameWorkHierarchy = frameWorkHierarchy;
    }

    public void initializer()
    {
        initContentPane();
        initMenuBar();
        initToolBar();
        initStatusBar();
    }

    private void initContentPane()
    {
        JDockableView outlookBarView = new JDockableView("Explorer", IconFactory.getContextIcon("explorer.png"), DemoOutlookBar.getInstance());
        JDockableView dockableView1 = new JDockableView("ContentPane", IconFactory.getContextIcon("workspace.png"), DemoToggleContentPanel.getInstance());

        // JDockable布局说明, 实现两种布局效果
        // 1.dockable.add(xxx) 由系统平均分配尺寸，同时在伸缩的时候，实现平均自填充
        // 2.dockable.add(xxx, JDockable.yyy)
        //   JDockable.FLEXIBLE 实现固定大小，其大小通过setPaneSize(index, size);
        //   JDockable.VARY 实现自填充，不需要设置大小
        JDockable dockable = new JDockable();
        dockable.setOrientation(JDockable.HORIZONTAL_SPLIT);
        dockable.add(outlookBarView, JDockable.FLEXIBLE);
        dockable.add(dockableView1, JDockable.VARY);
        dockable.setDividerLocation(0, 170);

        frameWorkHierarchy.getDockableContainer().setContentPane(dockable);
    }

    private void initMenuBar()
    {
        JBasicMenuBar menuBar = frameWorkHierarchy.getMenuBar();
        JMenu menu = new JMenu("测试");
        menuBar.add(menu);

        JMenuItem menuItem = new JMenuItem("短线程测试", IconFactory.getContextIcon("apply.png"));
        menuItem.addActionListener(new TestAction());
        menu.add(menuItem);

        JMenuItem menuItem1 = new JMenuItem("长线程测试", IconFactory.getContextIcon("apply.png"));
        menuItem1.addActionListener(new Test1Action());
        menu.add(menuItem1);
    }

    private void initToolBar()
    {
        JBasicToolBar toolBar = frameWorkHierarchy.getToolBar();

        // Basic L&F
        JRadioButtonMenuItem metalLFMenuItem = new JRadioButtonMenuItem("Metal L&F");
        metalLFMenuItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                LookAndFeelManager.setMetalLookAndFeel();
                SwingUtilities.updateComponentTreeUI(Frame.getFrames()[0]);
            }
        }
        );
        JRadioButtonMenuItem windowsLFMenuItem = new JRadioButtonMenuItem("Windows L&F");
        windowsLFMenuItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                LookAndFeelManager.setWindowsLookAndFeel();
                SwingUtilities.updateComponentTreeUI(Frame.getFrames()[0]);
            }
        }
        );
        JRadioButtonMenuItem motifLFMenuItem = new JRadioButtonMenuItem("CDE/Motif L&F");
        motifLFMenuItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                LookAndFeelManager.setMotifLookAndFeel();
                SwingUtilities.updateComponentTreeUI(Frame.getFrames()[0]);
            }
        }
        );
        JDecorationPopupMenu basicLFPopupMenu = new JDecorationPopupMenu();
        basicLFPopupMenu.add(metalLFMenuItem);
        basicLFPopupMenu.add(windowsLFMenuItem);
        basicLFPopupMenu.add(motifLFMenuItem);

        JFlatMenuButton basicLFButton = new JFlatMenuButton("Basic L&F", IconFactory.getContextIcon("lookandfeel.png"));
        basicLFButton.setPopupMenu(basicLFPopupMenu);
        toolBar.add(basicLFButton);

        // Alloy L&F
        JRadioButtonMenuItem acidThemeAlloyLFMenuItem = new JRadioButtonMenuItem("AcidThemeAlloy L&F");
        acidThemeAlloyLFMenuItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                LookAndFeelManager.setAcidLookAndFeel();
                SwingUtilities.updateComponentTreeUI(Frame.getFrames()[0]);
            }
        }
        );
        JRadioButtonMenuItem BedouinThemeAlloyLFMenuItem = new JRadioButtonMenuItem("Bedouin L&F", true);
        BedouinThemeAlloyLFMenuItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                LookAndFeelManager.setBedouinLookAndFeel();
                SwingUtilities.updateComponentTreeUI(Frame.getFrames()[0]);
            }
        }
        );
        JRadioButtonMenuItem defaultThemeAlloyLFMenuItem = new JRadioButtonMenuItem("DefaultThemeAlloy L&F");
        defaultThemeAlloyLFMenuItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                LookAndFeelManager.setAlloyLookAndFeel();
                SwingUtilities.updateComponentTreeUI(Frame.getFrames()[0]);
            }
        }
        );
        JRadioButtonMenuItem glassThemeAlloyLFMenuItem = new JRadioButtonMenuItem("GlassThemeAlloy L&F");
        glassThemeAlloyLFMenuItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                LookAndFeelManager.setGlassLookAndFeel();
                SwingUtilities.updateComponentTreeUI(Frame.getFrames()[0]);
            }
        }
        );
        JDecorationPopupMenu alloyLFPopupMenu = new JDecorationPopupMenu();
        alloyLFPopupMenu.add(acidThemeAlloyLFMenuItem);
        alloyLFPopupMenu.add(BedouinThemeAlloyLFMenuItem);
        alloyLFPopupMenu.add(defaultThemeAlloyLFMenuItem);
        alloyLFPopupMenu.add(glassThemeAlloyLFMenuItem);

        JFlatMenuButton alloyLFButton = new JFlatMenuButton("Alloy L&F", IconFactory.getContextIcon("lookandfeel.png"));
        alloyLFButton.setPopupMenu(alloyLFPopupMenu);
        toolBar.add(alloyLFButton);

        // XP L&F
        JRadioButtonMenuItem xpLFMenuItem = new JRadioButtonMenuItem("XP L&F");
        xpLFMenuItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                LookAndFeelManager.setXPLookAndFeel();
                SwingUtilities.updateComponentTreeUI(Frame.getFrames()[0]);
            }
        }
        );

        JRadioButtonMenuItem tinyLFMenuItem = new JRadioButtonMenuItem("Tiny L&F");
        tinyLFMenuItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                LookAndFeelManager.setTinyLookAndFeel();
                SwingUtilities.updateComponentTreeUI(Frame.getFrames()[0]);
            }
        }
        );

        JDecorationPopupMenu xpLFPopupMenu = new JDecorationPopupMenu();
        xpLFPopupMenu.add(xpLFMenuItem);
        xpLFPopupMenu.add(tinyLFMenuItem);

        JFlatMenuButton xpLFButton = new JFlatMenuButton("XP L&F", IconFactory.getContextIcon("lookandfeel.png"));
        xpLFButton.setPopupMenu(xpLFPopupMenu);
        toolBar.add(xpLFButton);

        // Borland L&F
        JRadioButtonMenuItem borlandLFMenuItem = new JRadioButtonMenuItem("Borland L&F");
        borlandLFMenuItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                LookAndFeelManager.setBorlandLookAndFeel();
                SwingUtilities.updateComponentTreeUI(Frame.getFrames()[0]);
            }
        }
        );

        JDecorationPopupMenu borlandLFPopupMenu = new JDecorationPopupMenu();
        borlandLFPopupMenu.add(borlandLFMenuItem);

        JFlatMenuButton borlandLFButton = new JFlatMenuButton("Borland L&F", IconFactory.getContextIcon("lookandfeel.png"));
        borlandLFButton.setPopupMenu(borlandLFPopupMenu);
        toolBar.add(borlandLFButton);

        // JGoodies L&F
        JRadioButtonMenuItem jgoodiesWindowsLFMenuItem = new JRadioButtonMenuItem("JGoodies Windows L&F");
        jgoodiesWindowsLFMenuItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                LookAndFeelManager.setJGoodiesWindowsLookAndFeel();
                SwingUtilities.updateComponentTreeUI(Frame.getFrames()[0]);
            }
        }
        );
        JRadioButtonMenuItem jgoodiesPlasticLFMenuItem = new JRadioButtonMenuItem("JGoodies Plastic L&F");
        jgoodiesPlasticLFMenuItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                LookAndFeelManager.setPlasticLookAndFeel();
                SwingUtilities.updateComponentTreeUI(Frame.getFrames()[0]);
            }
        }
        );

        JRadioButtonMenuItem jgoodiesPlasticXPLFMenuItem = new JRadioButtonMenuItem("JGoodies PlasticXP L&F");
        jgoodiesPlasticXPLFMenuItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                LookAndFeelManager.setPlasticXPLookAndFeel();
                SwingUtilities.updateComponentTreeUI(Frame.getFrames()[0]);
            }
        }
        );

        JRadioButtonMenuItem jgoodiesPlastic3DLFMenuItem = new JRadioButtonMenuItem("JGoodies Plastic3D L&F");
        jgoodiesPlastic3DLFMenuItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                LookAndFeelManager.setPlastic3DLookAndFeel();
                SwingUtilities.updateComponentTreeUI(Frame.getFrames()[0]);
            }
        }
        );

        JDecorationPopupMenu jgoodiesLFPopupMenu = new JDecorationPopupMenu();
        jgoodiesLFPopupMenu.add(jgoodiesWindowsLFMenuItem);
        jgoodiesLFPopupMenu.add(jgoodiesPlasticLFMenuItem);
        jgoodiesLFPopupMenu.add(jgoodiesPlasticXPLFMenuItem);
        jgoodiesLFPopupMenu.add(jgoodiesPlastic3DLFMenuItem);

        JFlatMenuButton jgoodiesLFButton = new JFlatMenuButton("JGoodies L&F", IconFactory.getContextIcon("lookandfeel.png"));
        jgoodiesLFButton.setPopupMenu(jgoodiesLFPopupMenu);
        toolBar.add(jgoodiesLFButton);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(metalLFMenuItem);
        buttonGroup.add(windowsLFMenuItem);
        buttonGroup.add(motifLFMenuItem);
        buttonGroup.add(acidThemeAlloyLFMenuItem);
        buttonGroup.add(BedouinThemeAlloyLFMenuItem);
        buttonGroup.add(defaultThemeAlloyLFMenuItem);
        buttonGroup.add(glassThemeAlloyLFMenuItem);
        buttonGroup.add(xpLFMenuItem);
        buttonGroup.add(tinyLFMenuItem);
        buttonGroup.add(borlandLFMenuItem);
        buttonGroup.add(jgoodiesWindowsLFMenuItem);
        buttonGroup.add(jgoodiesPlasticLFMenuItem);
        buttonGroup.add(jgoodiesPlasticXPLFMenuItem);
        buttonGroup.add(jgoodiesPlastic3DLFMenuItem);

        ButtonManager.updateUI(toolBar, new Dimension(130, 30));
    }

    private void initStatusBar()
    {
        JFrameWorkStatusBar statusBar = frameWorkHierarchy.getStatusBar();
        statusBar.addItem(120, new JStatusItem(new JLabel("StatusItem1")), JStatusBar.LEFT);
        statusBar.addItem(200, new JStatusItem(new JLabel("StatusItem2")), JStatusBar.LEFT);

        JDecorationPopupMenu popupMenu1 = new JDecorationPopupMenu();
        popupMenu1.add(new JMenuItem("save", IconFactory.getContextIcon("save.png")));
        popupMenu1.add(new JMenuItem("save all", IconFactory.getContextIcon("save_all.png")));
        JFlatMenuButton menuButton1 = new JFlatMenuButton(IconFactory.getContextIcon("save.png"));
        menuButton1.setPopupMenu(popupMenu1);
        JStatusItem statusItem = new JStatusItem(menuButton1);
        ButtonManager.updateUI(statusItem, new Dimension(50, 16));
        statusBar.addItem(50, statusItem, JStatusBar.RIGHT);

        statusBar.addItem(80, new JStatusItem(new JLabel("StatusItem3")), JStatusBar.RIGHT);
    }

    public class TestAction
        extends AbstractAction
    {
        public void actionPerformed(ActionEvent e)
        {
            JThreadProgressBar progressBar = frameWorkHierarchy.getStatusBar().getThreadProgressBar();
            progressBar.setDelayTime(30);
            progressBar.setPauseProgress(80);
            progressBar.setMaximum(100);
            progressBar.setMinimum(0);
            progressBar.setStringPainted(false);

            JFrameWorkThread thread = new JFrameWorkThread(frameWorkHierarchy, e)
            {
                public void execute()
                {
                    for (int i = 0; i < 100000; i++)
                    {
                        JLabel label = (JLabel) frameWorkHierarchy.getStatusBar().getItem(0, JFrameWorkStatusBar.LEFT).getComponent(0);
                        label.setText(i + "");
                    }
                }
            };
            thread.start();
        }
    }


    public class Test1Action
        extends AbstractAction
    {
        public void actionPerformed(ActionEvent e)
        {
            JThreadProgressBar progressBar = frameWorkHierarchy.getStatusBar().getThreadProgressBar();
            progressBar.setDelayTime(100);
            progressBar.setPauseProgress(160);
            progressBar.setMaximum(200);
            progressBar.setMinimum(5);
            progressBar.setStringPainted(true);
            JFrameWorkThread thread = new JFrameWorkThread(frameWorkHierarchy, e)
            {
                public void execute()
                {
                    for (int i = 0; i < 500000; i++)
                    {
                        JLabel label = (JLabel) frameWorkHierarchy.getStatusBar().getItem(0, JFrameWorkStatusBar.LEFT).getComponent(0);
                        label.setText(i + "");
                    }
                }
            };
            thread.start();
        }
    }
}
