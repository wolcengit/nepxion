package com.nepxion.swing.query;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import com.nepxion.swing.framework.dockable.JDockable;
import com.nepxion.swing.framework.dockable.JDockableView;
import com.nepxion.swing.framework.dockable.JFrameWorkHierarchy;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.query.condition.JQueryCondition;
import com.nepxion.swing.query.result.JQueryResult;

public class JQueryHierarchy
	extends JFrameWorkHierarchy
{
	public final static String QUERY_CONDITION_TITLE = SwingLocale.getString("query_condition");
	public final static String QUERY_RESULT_TITLE = SwingLocale.getString("query_result");
	
	private JQueryCondition queryCondition;
	private JQueryResult queryResult;
	
	public JQueryHierarchy()
	{
		initContentPane();
		initBar();
	}
	
	private void initContentPane()
	{
		queryCondition = new JQueryCondition();
		queryResult = new JQueryResult();
		
		JDockableView queryConditionView = new JDockableView(QUERY_CONDITION_TITLE, IconFactory.getSwingIcon("edit.png"), queryCondition);
		JDockableView queryResultView = new JDockableView(QUERY_RESULT_TITLE, IconFactory.getSwingIcon("query.png"), queryResult);
		
		queryConditionView.setClosable(false);
		queryResultView.setClosable(false);
		
		JDockable dockable = new JDockable();
		dockable.setOrientation(JDockable.HORIZONTAL_SPLIT);
		dockable.add(queryConditionView, JDockable.FLEXIBLE);
		dockable.add(queryResultView, JDockable.VARY);
		
		QueryManager.setPreferenceStyle(dockable);
		
		getDockableContainer().setContentPane(dockable);
	}
	
	private void initBar()
	{
		getBarContainer().setVisible(false);
		getStatusBarContainer().setVisible(false);
	}
	
	public JQueryCondition getQueryCondition()
	{
		return queryCondition;
	}
	
	public JQueryResult getQueryResult()
	{
		return queryResult;
	}
}