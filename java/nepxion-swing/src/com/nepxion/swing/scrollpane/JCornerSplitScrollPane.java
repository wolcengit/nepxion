package com.nepxion.swing.scrollpane;

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
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import com.nepxion.swing.button.ButtonManager;
import com.nepxion.swing.button.JBasicButton;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.splitpane.DividerActionListener;

public class JCornerSplitScrollPane
	extends JCornerScrollPane
{
	private JPanel horizontalToolBar;
	private JPanel verticalToolBar;
	
	private JBasicButton directLeftButton;
	private JBasicButton directRightButton;
	private JBasicButton directTopButton;
	private JBasicButton directBottomButton;
	
	public JCornerSplitScrollPane()
	{
		super();
		
		initComponents();
	}
	
	public JCornerSplitScrollPane(int vsbPolicy, int hsbPolicy)
	{
		super(vsbPolicy, hsbPolicy);
		
		initComponents();
	}
	
	public JCornerSplitScrollPane(Component view)
	{
		super(view);
		
		initComponents();
	}
	
	public JCornerSplitScrollPane(Component view, int vsbPolicy, int hsbPolicy)
	{
		super(view, vsbPolicy, hsbPolicy);
		
		initComponents();
	}
	
	private void initComponents()
	{
		directLeftButton = new JBasicButton(IconFactory.getSwingIcon("direction_west.png"), SwingLocale.getString("direct_left"));
		directRightButton = new JBasicButton(IconFactory.getSwingIcon("direction_east.png"), SwingLocale.getString("direct_right"));
		
		horizontalToolBar = new JPanel();
		horizontalToolBar.setLayout(new BoxLayout(horizontalToolBar, BoxLayout.X_AXIS));
		horizontalToolBar.add(directLeftButton);
		horizontalToolBar.add(directRightButton);
		ButtonManager.updateUI(horizontalToolBar, new Dimension(16, 16));
		
		directTopButton = new JBasicButton(IconFactory.getSwingIcon("direction_north.png"), SwingLocale.getString("direct_top"));
		directBottomButton = new JBasicButton(IconFactory.getSwingIcon("direction_south.png"), SwingLocale.getString("direct_bottom"));
		
		verticalToolBar = new JPanel();
		verticalToolBar.setLayout(new BoxLayout(verticalToolBar, BoxLayout.Y_AXIS));
		verticalToolBar.add(directTopButton);
		verticalToolBar.add(directBottomButton);
		ButtonManager.updateUI(verticalToolBar, new Dimension(16, 16));
	}
	
	public void setHorizontalSplitPane(JSplitPane horizontalSplitPane)
	{
		for (int i = 0; i < directLeftButton.getActionListeners().length; i++)
		{
			directLeftButton.removeActionListener(directLeftButton.getActionListeners()[i]);
		}
		directLeftButton.addActionListener(new DividerActionListener(horizontalSplitPane, true));
		
		for (int i = 0; i < directRightButton.getActionListeners().length; i++)
		{
			directRightButton.removeActionListener(directRightButton.getActionListeners()[i]);
		}
		directRightButton.addActionListener(new DividerActionListener(horizontalSplitPane, false));
	}
	
	public void setVerticalSplitPane(JSplitPane verticalSplitPane)
	{
		for (int i = 0; i < directTopButton.getActionListeners().length; i++)
		{
			directTopButton.removeActionListener(directTopButton.getActionListeners()[i]);
		}
		directTopButton.addActionListener(new DividerActionListener(verticalSplitPane, true));
		
		for (int i = 0; i < directBottomButton.getActionListeners().length; i++)
		{
			directBottomButton.removeActionListener(directBottomButton.getActionListeners()[i]);
		}
		directBottomButton.addActionListener(new DividerActionListener(verticalSplitPane, false));
	}
	
	public void showHorizontalToolBar()
	{
		setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_ALWAYS);
		setScrollBarCorner(JCornerScrollPane.HORIZONTAL_LEADING, horizontalToolBar);
	}
	
	public void showVerticalToolBar()
	{
		setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_ALWAYS);
		setScrollBarCorner(JCornerScrollPane.VERTICAL_BOTTOM, verticalToolBar);
	}
	
	public JPanel getHorizontalToolBar()
	{
		return horizontalToolBar;
	}
	
	public JPanel getVerticalToolBar()
	{
		return verticalToolBar;
	}
}