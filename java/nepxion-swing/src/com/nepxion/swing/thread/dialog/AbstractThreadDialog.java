package com.nepxion.swing.thread.dialog;

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
import java.awt.Container;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ComponentListener;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.nepxion.swing.border.ShadowBorder;
import com.nepxion.swing.dialog.DialogResizer;
import com.nepxion.swing.dialog.JBasicDialog;
import com.nepxion.swing.timer.JTimerProgressPanel;

public abstract class AbstractThreadDialog
	extends JBasicDialog
{
	private JTimerProgressPanel progressPanel;
	
	private JLabel animationLabel;
	private String information;
	
	public AbstractThreadDialog(Frame owner, String title, JLabel animationLabel, String information)
	{
		super(owner, title, null);
		
		this.animationLabel = animationLabel;
		this.information = information;
		
		initComponents();
	}
	
	public AbstractThreadDialog(Dialog owner, String title, JLabel animationLabel, String information)
	{
		super(owner, title, null);
		
		this.animationLabel = animationLabel;
		this.information = information;
		
		initComponents();
	}
	
	private void initComponents()
	{
		progressPanel = new JTimerProgressPanel(animationLabel, information)
		{
			public void fireCancelled()
			{
				AbstractThreadDialog.this.fireCancelled();
			}
			
			public void fireHidden()
			{
				AbstractThreadDialog.this.fireHidden();
			}
		};
		
		progressPanel.setPreferredSize(new Dimension(330, progressPanel.getPreferredSize().height + 10 + getDecoratedInset()));
		progressPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		JPanel layoutPanel = new JPanel();
		layoutPanel.setLayout(new BorderLayout());
		layoutPanel.add(progressPanel, BorderLayout.CENTER);
		
		if (!JDialog.isDefaultLookAndFeelDecorated())
		{
			layoutPanel.setBorder(new ShadowBorder());
		}
		
		Container container = getContentPane();
		container.setLayout(new BorderLayout());
		container.add(layoutPanel, BorderLayout.CENTER);
		
		setDefaultCloseOperation(JBasicDialog.DO_NOTHING_ON_CLOSE);
		setUndecorated(true);
		setResizable(false);
		
		for (int i = 0; i < getComponentListeners().length; i++)
		{
			ComponentListener componentListener = getComponentListeners()[i];
			if (componentListener instanceof DialogResizer)
			{
				removeComponentListener(componentListener);
				break;
			}
		}
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
	
	public abstract void execute();
	
	protected abstract void fireHidden();
	
	protected abstract void fireCancelled();
}