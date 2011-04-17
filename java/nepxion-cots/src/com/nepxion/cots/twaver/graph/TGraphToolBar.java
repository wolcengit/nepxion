package com.nepxion.cots.twaver.graph;

/**
 * <p>Title: Nepxion Cots For TWaver</p>
 * <p>Description: Nepxion Cots Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * <p>Announcement: It depends on the commercial software of TWaver, the repository only references the trial version.</p>
 * <p>If you want to use Nepxion Cots, please contact with Serva Corporation to buy the genuine version.</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import com.nepxion.cots.twaver.element.TIconFactory;
import com.nepxion.swing.button.JBasicSplitButton;
import com.nepxion.swing.button.JClassicMenuButton;
import com.nepxion.swing.lookandfeel.LookAndFeelManager;
import com.nepxion.swing.menu.JBasicMenu;
import com.nepxion.swing.menuitem.JBasicMenuItem;
import com.nepxion.swing.popupmenu.JDecorationPopupMenu;
import com.nepxion.swing.toolbar.JBasicToolBar;

public class TGraphToolBar
	extends JBasicToolBar
{
	public TGraphToolBar(TGraph graph)
	{
		this(graph, true);
	}
	
	public TGraphToolBar(final TGraph graph, boolean showControlBar)
	{
		graph.setToolbar(this);
		
		JDecorationPopupMenu controlBarOperationPopupMenu = new JDecorationPopupMenu();
		
		JBasicMenuItem controlBarVisibleMenuItem = new JBasicMenuItem(TGraphController.getShowControlBarAction(graph));
		controlBarOperationPopupMenu.add(controlBarVisibleMenuItem);
		
		JBasicMenuItem controlBarHiddenMenuItem = new JBasicMenuItem(TGraphController.getHideControlBarAction(graph));
		controlBarOperationPopupMenu.add(controlBarHiddenMenuItem);
		
		if (showControlBar)
		{
			controlBarVisibleMenuItem.doClick();
		}
		else
		{
			controlBarHiddenMenuItem.doClick();
		}
		
		controlBarOperationPopupMenu.addSeparator();
		
		JBasicMenu toggleTabMenu = new JBasicMenu("«–ªª√Ê∞Â¿∏", "«–ªª√Ê∞Â¿∏");
		toggleTabMenu.setIcon(TIconFactory.getSwingIcon("toggle_layout.png"));
		controlBarOperationPopupMenu.add(toggleTabMenu);
		
		TGraphControlBar controlBar = (TGraphControlBar) graph.getControlBarInternalFrame().getContent();
		for (int i = 0; i < controlBar.getTabCount(); i++)
		{
			JBasicMenuItem toggleMenuItem = new JBasicMenuItem(TGraphController.getToggleControlBarAction(graph.getControlBarInternalFrame(), i));
			toggleTabMenu.add(toggleMenuItem);
		}
		
		if (LookAndFeelManager.isNimbusLookAndFeel())
		{
			JClassicMenuButton panelButton = new JClassicMenuButton("√Ê∞Â", TIconFactory.getContextIcon("pane.png"), "œ‘ æ∫Õ“˛≤ÿ≤Ÿ◊˜√Ê∞Â");
			panelButton.setPopupMenu(controlBarOperationPopupMenu);
			add(panelButton);
		}
		else
		{
			JBasicSplitButton panelButton = new JBasicSplitButton(TGraphController.getToggleControlBarAction(graph));
			panelButton.setPopupMenu(controlBarOperationPopupMenu);
			add(panelButton);
		}
	}
}