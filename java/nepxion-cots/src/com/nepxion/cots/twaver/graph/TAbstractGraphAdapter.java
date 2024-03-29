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

import java.util.List;

public abstract class TAbstractGraphAdapter
	implements TGraphAdapter
{
	private TGraph graph;
	
	public TAbstractGraphAdapter(TGraph graph)
	{
		this.graph = graph;
		
		graph.setAdapter(this);
	}
	
	public boolean addElementPermitted()
	{
		return true;
	}
	
	public void addElement()
	{
		
	}
	
	
	public boolean modifyElementPermitted()
	{
		return true;
	}
	
	public void modifyElement()
	{
		
	}
	
	
	public boolean renameElementPermitted()
	{
		return true;
	}
	
	public void renameElement()
	{
		
	}
	

	public boolean deleteElementPermitted()
	{
		return true;
	}

	public void deleteElement()
	{
		
	}
	
	
	public boolean deleteElementsPermitted()
	{
		return true;
	}
	
	public void deleteElements()
	{
		
	}
	

	public boolean refreshPermitted()
	{
		return true;
	}
	
	public List refresh()
	{
		return null;
	}
	
	
	public boolean clearPermitted()
	{
		return true;
	}
	
	public boolean clear()
	{
		return true;
	}
	
	
	public boolean savePermitted()
	{
		return true;
	}
	
	public List save()
	{
		return null;
	}
	
	
	public TGraph getGraph()
	{
		return graph;
	}
}