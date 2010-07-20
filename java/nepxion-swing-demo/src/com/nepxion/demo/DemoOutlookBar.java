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

import com.nepxion.demo.control.application.DemoApplicationControlOutlook;
import com.nepxion.demo.control.bar.DemoBarControlOutlook;
import com.nepxion.demo.control.border.DemoBorderControlOutlook;
import com.nepxion.demo.control.button.DemoButtonControlOutlook;
import com.nepxion.demo.control.container.DemoContainerControlOutlook;
import com.nepxion.demo.control.data.DemoDataControlOutlook;
import com.nepxion.demo.control.framework.DemoFrameWorkControlOutlook;
import com.nepxion.demo.control.indicator.DemoIndicatorControlOutlook;
import com.nepxion.demo.control.layout.DemoLayoutControlOutlook;
import com.nepxion.demo.control.menu.DemoMenuControlOutlook;
import com.nepxion.demo.control.selector.DemoSelectorControlOutlook;
import com.nepxion.demo.control.text.DemoTextControlOutlook;
import com.nepxion.demo.control.thread.DemoThreadControlOutlook;
import com.nepxion.demo.control.ui.DemoUIControlOutlook;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.outlookbar.JFlatOutlookBar;

public class DemoOutlookBar
    extends JFlatOutlookBar
{
    private static DemoOutlookBar outlookBar;

    public static DemoOutlookBar getInstance()
    {
        if (outlookBar == null)
        {
            outlookBar = new DemoOutlookBar();
        }
        return outlookBar;
    }

    private DemoOutlookBar()
    {			
		addTab("Button Control", IconFactory.getSwingIcon("component/button_16.png"), makeScrollPane(new DemoButtonControlOutlook()), "Button Control Component");
		addTab("Text Control", IconFactory.getSwingIcon("component/text_pane_16.png"), makeScrollPane(new DemoTextControlOutlook()), "Text Control Component");
		addTab("Menu Control", IconFactory.getSwingIcon("component/menu_16.png"), makeScrollPane(new DemoMenuControlOutlook()), "Menu Control Component");
		addTab("Indicator Control", IconFactory.getSwingIcon("component/slider_16.png"), makeScrollPane(new DemoIndicatorControlOutlook()), "Indicator Control Component");
		addTab("Border Control", IconFactory.getSwingIcon("component/border_16.png"), makeScrollPane(new DemoBorderControlOutlook()), "Border Control Component");
		addTab("Container Control", IconFactory.getSwingIcon("component/internal_frame_16.png"), makeScrollPane(new DemoContainerControlOutlook()), "Container Control Component");
		addTab("Bar Control", IconFactory.getSwingIcon("component/tool_bar_16.png"), makeScrollPane(new DemoBarControlOutlook()), "Bar Control Component");
		addTab("Data Control", IconFactory.getSwingIcon("component/table_16.png"), makeScrollPane(new DemoDataControlOutlook()), "Data Control Component");		
		addTab("Selector Control", IconFactory.getSwingIcon("component/file_chooser_16.png"), makeScrollPane(new DemoSelectorControlOutlook()), "Selector Control Component");
		addTab("Layout Control", IconFactory.getSwingIcon("component/layout_16.png"), makeScrollPane(new DemoLayoutControlOutlook()), "Layout Control Component");
		addTab("UI Control", IconFactory.getSwingIcon("component/ui_16.png"), makeScrollPane(new DemoUIControlOutlook()), "UI Control Component");
		addTab("FrameWork Control", IconFactory.getSwingIcon("component/framework_16.png"), makeScrollPane(new DemoFrameWorkControlOutlook()), "FrameWork Control Component");
		addTab("Thread Control", IconFactory.getSwingIcon("component/thread_16.png"), makeScrollPane(new DemoThreadControlOutlook()), "Thread Control Component");
		addTab("Application Control", IconFactory.getSwingIcon("component/application_16.png"), makeScrollPane(new DemoApplicationControlOutlook()), "Application Control Component");		
        
        setAllTabsAlignment(LEFT, 5);
    }
}