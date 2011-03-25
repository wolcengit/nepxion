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

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.plaf.UIResource;

import com.jidesoft.icons.JideIconsFactory;
import com.jidesoft.swing.SimpleScrollPane;
import com.nepxion.swing.button.ButtonManager;
import com.nepxion.swing.button.JBasicButton;
import com.nepxion.swing.style.button.lite.LiteButtonUI;

public class JAutoRollScrollPane
	extends SimpleScrollPane implements SwingConstants
{	
	public JAutoRollScrollPane(Component view, int vsbPolicy, int hsbPolicy)
	{
		super(view, vsbPolicy, hsbPolicy);
		
		initComponents();
	}
	
	public JAutoRollScrollPane(Component view)
	{
		super(view);
		
		initComponents();
	}
	
	public JAutoRollScrollPane(int vsbPolicy, int hsbPolicy)
	{
		super(vsbPolicy, hsbPolicy);
		
		initComponents();
	}
	
	public JAutoRollScrollPane()
	{
		super();
		
		initComponents();
	}
	
	private void initComponents()
	{					
		setScrollUpButton(new JAutoRollScrollButton(SwingConstants.NORTH));
		setScrollDownButton(new JAutoRollScrollButton(SwingConstants.SOUTH));
		setScrollLeftButton(new JAutoRollScrollButton(SwingConstants.WEST));
		setScrollRightButton(new JAutoRollScrollButton(SwingConstants.EAST));
		setRepeatDelay(15);

		// setViewportBorder(BorderManager.createLineBorder(Color.gray, 0, 0, 0, 0));
		
		ScrollPaneManager.setPreferenceStyle(this);
	}
	
	public class JAutoRollScrollButton
		extends JBasicButton implements MouseListener, ActionListener, UIResource
	{
		private int direction;
		private Timer timer;
		
		public JAutoRollScrollButton(final int direction)
		{
			this.direction = direction;
			
			switch (direction)
			{
				case NORTH:
					setIcon(JideIconsFactory.getImageIcon(JideIconsFactory.Arrow.UP));
					break;
				case SOUTH:
					setIcon(JideIconsFactory.getImageIcon(JideIconsFactory.Arrow.DOWN));
					break;
				case WEST:
					setIcon(JideIconsFactory.getImageIcon(JideIconsFactory.Arrow.LEFT));
					break;
				case EAST:
					setIcon(JideIconsFactory.getImageIcon(JideIconsFactory.Arrow.RIGHT));
					break;
			}
						
			setUI(new LiteButtonUI(ButtonManager.getButtonStyle())
			{
				public void paint(Graphics g, JComponent c)
				{
					super.paint(g, c);
					
					g.setColor(Color.gray);
					
					Border viewportBorder = getViewportBorder();
					
					if (viewportBorder != null && viewportBorder instanceof CompoundBorder)
					{	
						switch (direction)
						{
							case NORTH:
								g.drawLine(0, 0, getWidth() - 1, 0);
								g.drawLine(0, 0, 0, getHeight() - 1);
								g.drawLine(getWidth() - 1, 0, getWidth() - 1, getHeight() - 1);
								break;
							case SOUTH:
								g.drawLine(0, getHeight() - 1, getWidth() - 1, getHeight() - 1);
								g.drawLine(0, 0, 0, getHeight() - 1);
								g.drawLine(getWidth() - 1, 0, getWidth() - 1, getHeight() - 1);								
								break;
							case WEST:
								g.drawLine(0, 0, getWidth() - 1, 0);
								g.drawLine(0, 0, 0, getHeight() - 1);
								g.drawLine(0, getHeight() - 1, getWidth() - 1, getHeight() - 1);
								break;
							case EAST:
								g.drawLine(0, 0, getWidth() - 1, 0);
								g.drawLine(getWidth() - 1, 0, getWidth() - 1, getHeight() - 1);
								g.drawLine(0, getHeight() - 1, getWidth() - 1, getHeight() - 1);
								break;
						}						
					}
					else
					{
						g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
					}
				}
			}
			);
			
			setDimension(new Dimension(10, 10));
			
			addActionListener(this);
			addMouseListener(this);
		}
		
		public void actionPerformed(ActionEvent e)
		{
			scroll(getViewport(), direction);
			
			updateButtonState();
		}
		
		public void mouseClicked(MouseEvent e)
		{
		}
		
		public void mousePressed(MouseEvent e)
		{
			if (!isScrollOnRollover())
			{
				startTimer(e, 500);
			}
			else
			{
				updateTimer(e);
			}
		}
		
		public void mouseReleased(MouseEvent e)
		{
			if (!isScrollOnRollover())
			{
				stopTimer();
			}
			else
			{
				updateTimer(e);
			}
		}
		
		public void mouseEntered(MouseEvent e)
		{
			if (isScrollOnRollover())
			{
				startTimer(e, 500);
			}
		}
		
		private void updateTimer(MouseEvent e)
		{
			if (timer != null)
			{
				timer.setDelay(getDelay(e));
			}
		}
		
		private void startTimer(MouseEvent e, int initDelay)
		{
			stopTimer();
			
			timer = new Timer(getDelay(e), this);
			timer.setInitialDelay(initDelay);
			timer.start();
		}
		
		private void stopTimer()
		{
			if (timer != null)
			{
				timer.stop();
				timer = null;
			}
		}
		
		private int getDelay(MouseEvent e)
		{
			if (isScrollOnRollover())
			{
				return SwingUtilities.isLeftMouseButton(e) ? getRepeatDelay() : getRepeatDelay() * 2;
			}
			else
			{
				return getRepeatDelay();
			}
		}
		
		public void mouseExited(MouseEvent e)
		{
			if (isScrollOnRollover())
			{
				stopTimer();
			}
		}
	}
}