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

import java.awt.Component;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.Icon;

import com.nepxion.demo.common.DemoDataFactory;
import com.nepxion.swing.common.InstallData;
import com.nepxion.swing.outlookbar.JFlatOutlookBar;

public class DemoOutlookBar
    extends JFlatOutlookBar
{
    private static DemoOutlookBar demoOutlookBar;

    public static DemoOutlookBar getInstance()
    {
        if (demoOutlookBar == null)
        {
            demoOutlookBar = new DemoOutlookBar();
        }
        return demoOutlookBar;
    }

    private DemoOutlookBar()
    {
    	List componentInstallDatas = DemoDataFactory.getComponentInstallDatas();
    	Map componentMap = DemoDataFactory.getComponentMap();
    	for (Iterator iterator = componentInstallDatas.iterator(); iterator.hasNext();)
    	{
    		InstallData installData = (InstallData) iterator.next();
    		String name = installData.getText();
    		Icon icon = installData.getIcon();
    		String toolTipText = installData.getToolTipText();
    		Component component = (Component) componentMap.get(name);
    		addTab(name, icon, makeScrollPane(component), toolTipText);
    	}	
        
        setAllTabsAlignment(LEFT, 5);
    }
}