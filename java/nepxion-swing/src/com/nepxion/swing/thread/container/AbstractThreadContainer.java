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

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.JLabel;

import com.nepxion.swing.container.JContainer;
import com.nepxion.swing.panel.JInformationPanel;

public abstract class AbstractThreadContainer
	extends JContainer
{
	private String informationText;
	private Icon informationIcon;
	
	private String errorText;
	private Icon errorIcon;
	
	private JInformationPanel informationPanel;
	private AbstractThreadPanel threadPanel;
	
	public AbstractThreadContainer(JLabel animationLabel, String information)
	{
		informationPanel = new JInformationPanel();
		informationPanel.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				fireHidden();
			}
		}
		);
		
		threadPanel = new AbstractThreadPanel(animationLabel, information)
		{
			public void fireHidden()
			{
				AbstractThreadContainer.this.fireHidden();
			}
			
			public void fireCancelled()
			{
				AbstractThreadContainer.this.fireCancelled();
			}
		};
		
		setLayout(new BorderLayout());
	}
	
	public void reset()
	{
		threadPanel.reset();
	}
	
	public void start()
	{
		threadPanel.start();
	}
	
	public void start(int delayTime)
	{
		threadPanel.start(delayTime);
	}
	
	public void restart()
	{
		threadPanel.restart();
	}
	
	public void restart(int delayTime)
	{
		threadPanel.restart(delayTime);
	}
	
	public void stop()
	{
		threadPanel.stop();
	}
	
	public void finish()
	{
		threadPanel.finish();
	}
	
	public void showThread()
	{
		addComponent(threadPanel, BorderLayout.CENTER);
	}
	
	public void showInformation()
	{
		informationPanel.getLabel().setText(informationText);
		informationPanel.getLabel().setIcon(informationIcon);
		addComponent(informationPanel, BorderLayout.CENTER);
	}
	
	public void showError()
	{
		informationPanel.getLabel().setText(errorText);
		informationPanel.getLabel().setIcon(errorIcon);
		addComponent(informationPanel, BorderLayout.CENTER);
	}
	
	public JInformationPanel getInformationPanel()
	{
		return informationPanel;
	}
	
	public AbstractThreadPanel getThreadPanel()
	{
		return threadPanel;
	}
	
	public String getInformationText()
	{
		return informationText;
	}
	
	public void setInformationText(String informationText)
	{
		this.informationText = informationText;
	}
	
	public Icon getInformationIcon()
	{
		return informationIcon;
	}
	
	public void setInformationIcon(Icon informationIcon)
	{
		this.informationIcon = informationIcon;
	}
	
	public String getErrorText()
	{
		return errorText;
	}
	
	public void setErrorText(String errorText)
	{
		this.errorText = errorText;
	}
	
	public Icon getErrorIcon()
	{
		return errorIcon;
	}
	
	public void setErrorIcon(Icon errorIcon)
	{
		this.errorIcon = errorIcon;
	}
	
	public void setWidth(int width)
	{
		threadPanel.setWidth(width);
	}
	
	public void setHeight(int height)
	{
		threadPanel.setHeight(height);
	}
	
	public abstract void execute();
	
	protected abstract void fireHidden();
	
	protected abstract void fireCancelled();
}