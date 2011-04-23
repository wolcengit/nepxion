package com.nepxion.swing.internalframe;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.swing.Icon;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

import com.nepxion.swing.container.ContainerManager;
import com.nepxion.swing.element.ElementNode;
import com.nepxion.swing.element.IElementNode;
import com.nepxion.swing.handle.HandleManager;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.selector.checkbox.JCheckBoxSelector;

public class InternalFrameManager
{
	public static void showCloseDialog(JDesktopPane desktopPane, JCheckBoxSelector checkBoxSelector)
	{
		Vector slectionElementNodes = new Vector();
		JInternalFrame[] internalFrames = desktopPane.getAllFrames();
		for (int i = 0; i < internalFrames.length; i++)
		{
			JInternalFrame internalFrame = internalFrames[i];
			String title = internalFrame.getTitle();
			String toolTipText = internalFrame.getToolTipText();
			Icon icon = internalFrame.getFrameIcon();
			IElementNode elementNode = new ElementNode(title, title, icon, toolTipText, internalFrame);
			slectionElementNodes.add(elementNode);
		}
		
		if (checkBoxSelector == null)
		{
			checkBoxSelector = new JCheckBoxSelector(HandleManager.getFrame(desktopPane), SwingLocale.getString("select_close"));
		}
		checkBoxSelector.getCheckBoxList().setListData(slectionElementNodes);
		checkBoxSelector.setVisible(true);
		checkBoxSelector.dispose();
		
		if (checkBoxSelector.isConfirmed())
		{
			List selectedComponents = checkBoxSelector.getSelectedUserObjects();
			for (Iterator iterator = selectedComponents.iterator(); iterator.hasNext();)
			{
				JInternalFrame internalFrame = (JInternalFrame) iterator.next();
				desktopPane.remove(internalFrame);
			}
			
			ContainerManager.update(desktopPane);
		}
	}
}