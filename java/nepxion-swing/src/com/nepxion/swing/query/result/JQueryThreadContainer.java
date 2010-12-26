package com.nepxion.swing.query.result;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import com.nepxion.swing.element.ElementNode;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.thread.container.JThreadContainer;

public abstract class JQueryThreadContainer
	extends JThreadContainer
{
	private ElementNode contextElementNode;
	
	public JQueryThreadContainer(String queryTarget)
	{
		super(SwingLocale.getString("query_and_wait"));
		
		contextElementNode = new ElementNode();
		
		setInformationText(SwingLocale.getString("query") + " " + SwingLocale.getString("quotation_left") + queryTarget + SwingLocale.getString("quotation_right") + " " + SwingLocale.getString("relative_data"));
		setInformationIcon(IconFactory.getSwingIcon("banner/query_128.png"));
		setErrorText(SwingLocale.getString("query") + " " + SwingLocale.getString("quotation_left") + queryTarget + SwingLocale.getString("quotation_right") + " " + SwingLocale.getString("relative_data_exception"));
		setErrorIcon(IconFactory.getSwingIcon("banner/error_128.png"));
		setWidth(300);
		
		showInformation();
	}
	
	public ElementNode getContextElementNode()
	{
		return contextElementNode;
	}
	
	public void setContextElementNode(ElementNode contextElementNode)
	{
		this.contextElementNode = contextElementNode;
	}
	
	public boolean isLoadCache()
	{
		return false;
	}
}