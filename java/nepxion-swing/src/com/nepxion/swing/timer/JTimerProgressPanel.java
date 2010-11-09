package com.nepxion.swing.timer;

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
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.nepxion.swing.button.JClassicButton;
import com.nepxion.swing.handle.HandleManager;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.keystroke.KeyStrokeManager;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.optionpane.JBasicOptionPane;

public abstract class JTimerProgressPanel
	extends JPanel
{
	private JLabel animationLabel;
	private JTimerProgressBar timerProgressBar;
	private JLabel informationLabel;
	
	private JClassicButton hideButton;
	private JClassicButton cancelButton;
	
	private String information;
	
	public JTimerProgressPanel(JLabel animationLabel, String information)
	{
		this.animationLabel = animationLabel;
		this.information = information;
		
		initComponents();
	}
	
	private void initComponents()
	{
		LabelPanel labelPanel = new LabelPanel();
		ProgressPanel progressPanel = new ProgressPanel();
		ButtonPanel buttonPanel = new ButtonPanel();
		
		setLayout(new BorderLayout());
		add(labelPanel, BorderLayout.NORTH);
		add(progressPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
	}
	
	public class LabelPanel
		extends JPanel
	{
		public LabelPanel()
		{
			informationLabel = new JLabel(information);
			informationLabel.setIconTextGap(5);
			informationLabel.setHorizontalAlignment(JLabel.LEADING);
			
			setLayout(new FlowLayout(FlowLayout.LEADING));
			add(animationLabel);
			add(Box.createHorizontalStrut(5));
			add(informationLabel);
		}
	}
	
	public class ProgressPanel
		extends JPanel
	{
		public ProgressPanel()
		{
			timerProgressBar = new JTimerProgressBar();
			
			setLayout(new BorderLayout());
			add(Box.createHorizontalStrut(5), BorderLayout.WEST);
			add(timerProgressBar);
			add(Box.createHorizontalStrut(5), BorderLayout.EAST);
		}
	}
	
	public class ButtonPanel
		extends JPanel
	{
		public ButtonPanel()
		{
			hideButton = new JClassicButton(SwingLocale.getString("hide"), IconFactory.getSwingIcon("solid/confirm_16.png"), SwingLocale.getString("hide"));
			ActionListener hideActionListener = new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					int selectedValue = JBasicOptionPane.showConfirmDialog(HandleManager.getFrame(JTimerProgressPanel.this), SwingLocale.getString("confirm_to_hide"), SwingLocale.getString("confirm"), JBasicOptionPane.YES_NO_OPTION);
					if (selectedValue != JBasicOptionPane.YES_OPTION)
					{
						return;
					}
					stop();
					fireHidden();
				}
			};
			hideButton.addActionListener(hideActionListener);
			KeyStrokeManager.registerButtonToEnterKey(hideButton, hideActionListener);
			
			cancelButton = new JClassicButton(SwingLocale.getString("cancel"), IconFactory.getSwingIcon("solid/cancel_16.png"), SwingLocale.getString("cancel"));
			cancelButton.setFocusPainted(false);
			cancelButton.setMargin(new Insets(3, 9, 3, 9));
			ActionListener cancelActionListener = new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					int selectedValue = JBasicOptionPane.showConfirmDialog(HandleManager.getFrame(JTimerProgressPanel.this), SwingLocale.getString("confirm_to_cancel"), SwingLocale.getString("confirm"), JBasicOptionPane.YES_NO_OPTION);
					if (selectedValue != JBasicOptionPane.YES_OPTION)
					{
						return;
					}
					stop();
					fireCancelled();
				}
			};
			cancelButton.addActionListener(cancelActionListener);
			KeyStrokeManager.registerButtonToEscapeKey(cancelButton, cancelActionListener);
			
			setLayout(new FlowLayout(FlowLayout.RIGHT));
			add(hideButton);
			add(cancelButton);
		}
	}
	
	public void reset()
	{
		if (animationLabel instanceof JTimerLabel)
		{
			JTimerLabel timerAnimationLabel = (JTimerLabel) animationLabel;
			timerAnimationLabel.reset();
		}
		timerProgressBar.reset();
	}
	
	public void start()
	{
		if (animationLabel instanceof JTimerLabel)
		{
			JTimerLabel timerAnimationLabel = (JTimerLabel) animationLabel;
			timerAnimationLabel.restart(); // 不需要重复刷新
		}
		timerProgressBar.start();
	}
	
	public void start(int delayTime)
	{
		if (animationLabel instanceof JTimerLabel)
		{
			JTimerLabel timerAnimationLabel = (JTimerLabel) animationLabel;
			timerAnimationLabel.restart(); // 按照默认的时间间隔执行
		}
		timerProgressBar.start(delayTime);
	}
	
	public void restart()
	{
		if (animationLabel instanceof JTimerLabel)
		{
			JTimerLabel timerAnimationLabel = (JTimerLabel) animationLabel;
			timerAnimationLabel.restart();
		}
		timerProgressBar.restart();
	}
	
	public void restart(int delayTime)
	{
		if (animationLabel instanceof JTimerLabel)
		{
			JTimerLabel timerAnimationLabel = (JTimerLabel) animationLabel;
			timerAnimationLabel.restart();
		}
		timerProgressBar.restart(delayTime);
	}
	
	public void stop()
	{
		if (animationLabel instanceof JTimerLabel)
		{
			JTimerLabel timerLabel = (JTimerLabel) animationLabel;
			timerLabel.stop();
		}
		timerProgressBar.stop();
	}
	
	public void finish()
	{
		if (animationLabel instanceof JTimerLabel)
		{
			JTimerLabel timerLabel = (JTimerLabel) animationLabel;
			timerLabel.finish();
		}
		timerProgressBar.finish();
	}
	
	public JLabel getLabel()
	{
		return animationLabel;
	}
	
	public JTimerProgressBar getTimerProgressBar()
	{
		return timerProgressBar;
	}
	
	public JLabel getInformationLabel()
	{
		return informationLabel;
	}
	
	public JClassicButton getHideButton()
	{
		return hideButton;
	}
	
	public JClassicButton getCancelButton()
	{
		return cancelButton;
	}
	
	protected abstract void fireHidden();
	
	protected abstract void fireCancelled();
}