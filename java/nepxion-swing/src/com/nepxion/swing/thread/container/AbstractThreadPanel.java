package com.nepxion.swing.thread.container;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.awt.Color;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.nepxion.swing.layout.table.TableLayout;
import com.nepxion.swing.scrollpane.JBasicScrollPane;
import com.nepxion.swing.timer.JTimerProgressBar;
import com.nepxion.swing.timer.JTimerProgressPanel;

public abstract class AbstractThreadPanel
	extends JBasicScrollPane
{
	private JPanel panel;
	private JTimerProgressPanel progressPanel;
	
	public AbstractThreadPanel(JLabel animationLabel, String information)
	{
		progressPanel = new JTimerProgressPanel(animationLabel, information)
		{
			public void fireHidden()
			{
				AbstractThreadPanel.this.fireHidden();
			}
			
			public void fireCancelled()
			{
				AbstractThreadPanel.this.fireCancelled();
			}
		};
		
		double[][] size = 
		{ 
			{TableLayout.FILL, TableLayout.PREFERRED, TableLayout.FILL}, 
			{TableLayout.FILL, TableLayout.PREFERRED, TableLayout.FILL}
		};
		panel = new JPanel();
		panel.setLayout(new TableLayout(size));
		panel.add(progressPanel, "1, 1");
		
		setBackgound(panel, Color.white);
		
		getViewport().add(panel);
	}
	
	public void reset()
	{
		progressPanel.reset();
	}
	
	public void start()
	{
		progressPanel.start();
	}
	
	public void start(int delayTime)
	{
		progressPanel.start(delayTime);
	}
	
	public void restart()
	{
		progressPanel.restart();
	}
	
	public void restart(int delayTime)
	{
		progressPanel.restart(delayTime);
	}
	
	public void stop()
	{
		progressPanel.stop();
	}
	
	public void finish()
	{
		progressPanel.finish();
	}
	
	public JTimerProgressPanel getProgressPanel()
	{
		return progressPanel;
	}
	
	public JTimerProgressBar getProgressBar()
	{
		return progressPanel.getTimerProgressBar();
	}
	
	public void setWidth(int width)
	{
		if (panel.getLayout() instanceof TableLayout)
		{
			TableLayout tableLayout = (TableLayout) panel.getLayout();
			tableLayout.setColumn(1, width);
		}
	}
	
	public void setHeight(int height)
	{
		if (panel.getLayout() instanceof TableLayout)
		{
			TableLayout tableLayout = (TableLayout) panel.getLayout();
			tableLayout.setRow(1, height);
		}
	}
	
	private void setBackgound(JComponent component, Color background)
	{
		for (int i = 0; i < component.getComponentCount(); i++)
		{
			JComponent childComponent = (JComponent) component.getComponent(i);
			if (childComponent instanceof JPanel)
			{
				setBackgound(childComponent, background);
			}
		}
		component.setBackground(background);
	}
	
	protected abstract void fireHidden();
	
	protected abstract void fireCancelled();
}