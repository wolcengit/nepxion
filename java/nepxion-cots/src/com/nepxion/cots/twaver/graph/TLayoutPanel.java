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

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.nepxion.cots.twaver.icon.TIconFactory;
import com.nepxion.swing.border.ComplexEtchedBorder;
import com.nepxion.swing.border.ComplexSide;
import com.nepxion.swing.border.ComplexTitleBorder;
import com.nepxion.swing.button.ButtonManager;
import com.nepxion.swing.button.JBasicButton;
import com.nepxion.swing.checkbox.JBasicCheckBox;
import com.nepxion.swing.combobox.JBasicComboBox;
import com.nepxion.swing.layout.table.TableLayout;

public class TLayoutPanel
	extends JPanel
{
	private JLabel typeLabel;
	private JBasicComboBox typeComboBox;
	
	private JLabel forceSizeLabel;
	private JSlider forceSizeSlider;
	
	private JLabel stepSizeLabel;
	private JSlider stepSizeSlider;
	
	private JLabel updateDurationLabel;
	private JSlider updateDurationSlider;
	
	
	private JLabel elementLabel;
	private JBasicComboBox elementComboBox;
		
	private JLabel xOffsetLabel;
	private JSlider xOffsetSlider;
	
	private JLabel yOffsetLabel;
	private JSlider yOffsetSlider;
	
	private JLabel xGapLabel;
	private JSlider xGapSlider;
	
	private JLabel yGapLabel;
	private JSlider yGapSlider;
	
	private JLabel animationLabel;
	private JBasicCheckBox animationCheckBox;
	
	private JBasicButton runButton;
	private JBasicButton stopButton;
	
	private TLayouter layouter;
	
	public TLayoutPanel(final TGraph graph)
	{
		this.layouter = new TLayouter(graph);
		
		double size1[][] = 
		{
			{0.35, 0.65},
			{22}
		};
		
		typeLabel = new JLabel("布局类型");
		
		typeComboBox = new JBasicComboBox(new TLayoutType[] {TLayoutType.SPRING_LAYOUT_TYPE, TLayoutType.CIRCULAR_LAYOUT_TYPE, TLayoutType.HIERARCHIC_LAYOUT_TYPE, TLayoutType.SYMMETRIC_LAYOUT_TYPE, TLayoutType.TREE_LAYOUT_TYPE, TLayoutType.REVERSE_TREE_LAYOUT_TYPE, TLayoutType.RANDOM_LAYOUT_TYPE});
		typeComboBox.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				doLayout(stopButton.isEnabled());
			}
		}
		);
		
		typeComboBox.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e)
			{
				if (typeComboBox.getSelectedItem() != e.getItem())
				{
					if (typeComboBox.getSelectedItem().equals(TLayoutType.SPRING_LAYOUT_TYPE))
					{
						forceSizeLabel.setVisible(true);
						forceSizeSlider.setVisible(true);
						
						stepSizeLabel.setVisible(true);
						stepSizeSlider.setVisible(true);
						
						updateDurationLabel.setVisible(true);
						updateDurationSlider.setVisible(true);
						
						
						elementLabel.setVisible(false);
						elementComboBox.setVisible(false);
						
						xOffsetLabel.setVisible(false);
						xOffsetSlider.setVisible(false);
						
						yOffsetLabel.setVisible(false);
						yOffsetSlider.setVisible(false);
						
						xGapLabel.setVisible(false);
						xGapSlider.setVisible(false);
						
						yGapLabel.setVisible(false);
						yGapSlider.setVisible(false);
						
						animationLabel.setVisible(false);
						animationCheckBox.setVisible(false);
					}
					else
					{
						forceSizeLabel.setVisible(false);
						forceSizeSlider.setVisible(false);
						
						stepSizeLabel.setVisible(false);
						stepSizeSlider.setVisible(false);
						
						updateDurationLabel.setVisible(false);
						updateDurationSlider.setVisible(false);
						
						
						elementLabel.setVisible(true);
						elementComboBox.setVisible(true);
												
						xOffsetLabel.setVisible(true);
						xOffsetSlider.setVisible(true);
						
						yOffsetLabel.setVisible(true);
						yOffsetSlider.setVisible(true);
						
						xGapLabel.setVisible(true);
						xGapSlider.setVisible(true);
						
						yGapLabel.setVisible(true);
						yGapSlider.setVisible(true);
						
						animationLabel.setVisible(true);
						animationCheckBox.setVisible(true);
					}
				}
			}
		}
		);
		
		JPanel layoutModePanel = new JPanel();
		layoutModePanel.setBorder(new ComplexTitleBorder(new ComplexEtchedBorder(ComplexEtchedBorder.LOWERED, ComplexSide.NORTH), "设置布局类型"));
		layoutModePanel.setLayout(new TableLayout(size1));
		layoutModePanel.add(typeLabel, "0, 0");
		layoutModePanel.add(typeComboBox, "1, 0");
		
		forceSizeLabel = new JLabel("平衡间距");
		
		forceSizeSlider = new JSlider(TLayouter.MINIMUM_FORCE_SIZE, TLayouter.MAXIMUM_FORCE_SIZE, layouter.getForceSize());
		forceSizeSlider.setToolTipText(forceSizeSlider.getValue() + "");
		forceSizeSlider.addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent e)
			{
				layouter.setForceSize(forceSizeSlider.getValue());
				
				forceSizeSlider.setToolTipText(forceSizeSlider.getValue() + "");
			}
		}
		);
		
		stepSizeLabel = new JLabel("平衡速度");
		
		stepSizeSlider = new JSlider(TLayouter.MINIMUM_STEP_SIZE, TLayouter.MAXIMUM_STEP_SIZE, layouter.getStepSize());
		stepSizeSlider.setToolTipText(stepSizeSlider.getValue() + "");
		stepSizeSlider.addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent e)
			{
				layouter.setStepSize(stepSizeSlider.getValue());
				
				stepSizeSlider.setToolTipText(stepSizeSlider.getValue() + "");
			}
		}
		);
		
		updateDurationLabel = new JLabel("刷新时间");
		
		updateDurationSlider = new JSlider(TLayouter.MINIMUM_UPDATE_DURATION, TLayouter.MAXIMUM_UPDATE_DURATION, layouter.getUpdateDuration());
		updateDurationSlider.setToolTipText(updateDurationSlider.getValue() + "");
		updateDurationSlider.addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent e)
			{
				layouter.setUpdateDuration(updateDurationSlider.getValue());
				
				updateDurationSlider.setToolTipText(updateDurationSlider.getValue() + "");
			}
		}
		);
		
		
		elementLabel = new JLabel("布局图元");
		
		elementComboBox = new JBasicComboBox(new String[] {"全部图元", "选中图元"});
		elementComboBox.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				doLayout(stopButton.isEnabled());
			}
		}
		);
				
		xOffsetLabel = new JLabel("左侧间距");
		
		xOffsetSlider = new JSlider(TLayouter.MINIMUM_X_OFFSET, TLayouter.MAXIMUM_X_OFFSET, TLayouter.DEFAULT_X_OFFSET);
		xOffsetSlider.setToolTipText(xOffsetSlider.getValue() + "");
		xOffsetSlider.addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent e)
			{					
				xOffsetSlider.setToolTipText(xOffsetSlider.getValue() + "");
				
				doLayout(stopButton.isEnabled());	
			}
		}
		);
		
		yOffsetLabel = new JLabel("上侧间距");
		
		yOffsetSlider = new JSlider(TLayouter.MINIMUM_Y_OFFSET, TLayouter.MAXIMUM_Y_OFFSET, TLayouter.DEFAULT_Y_OFFSET);
		yOffsetSlider.setToolTipText(yOffsetSlider.getValue() + "");
		yOffsetSlider.addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent e)
			{			
				yOffsetSlider.setToolTipText(yOffsetSlider.getValue() + "");
				
				doLayout(stopButton.isEnabled());	
			}
		}
		);
		
		xGapLabel = new JLabel("分布宽度");
		
		xGapSlider = new JSlider(TLayouter.MINIMUM_X_GAP, TLayouter.MAXIMUM_X_GAP, TLayouter.DEFAULT_X_GAP);
		xGapSlider.setToolTipText(xGapSlider.getValue() + "");
		xGapSlider.addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent e)
			{			
				xGapSlider.setToolTipText(xGapSlider.getValue() + "");	
				
				doLayout(stopButton.isEnabled());
			}
		}
		);
		
		yGapLabel = new JLabel("分布高度");
		
		yGapSlider = new JSlider(TLayouter.MINIMUM_Y_GAP, TLayouter.MAXIMUM_Y_GAP, TLayouter.DEFAULT_Y_GAP);
		yGapSlider.setToolTipText(yGapSlider.getValue() + "");
		yGapSlider.addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent e)
			{			
				yGapSlider.setToolTipText(yGapSlider.getValue() + "");	
				
				doLayout(stopButton.isEnabled());
			}
		}
		);
		
		animationLabel = new JLabel("布局效果");
		
		animationCheckBox = new JBasicCheckBox("启用动画效果", true);
		
		double size2[][] = 
		{ 
			{0.35, 0.65},
			{22, 22, 22, 22, 22, 22}
		};
		
		JPanel layoutParamPanel = new JPanel();
		layoutParamPanel.setBorder(new ComplexTitleBorder(new ComplexEtchedBorder(ComplexEtchedBorder.LOWERED, ComplexSide.NORTH), "设置布局参数"));
		layoutParamPanel.setLayout(new TableLayout(size2));
		
		layoutParamPanel.add(forceSizeLabel, "0, 0");
		layoutParamPanel.add(forceSizeSlider, "1, 0");
		layoutParamPanel.add(elementLabel, "0, 0");
		layoutParamPanel.add(elementComboBox, "1, 0");
		
		layoutParamPanel.add(stepSizeLabel, "0, 1");
		layoutParamPanel.add(stepSizeSlider, "1, 1");
		layoutParamPanel.add(xOffsetLabel, "0, 1");
		layoutParamPanel.add(xOffsetSlider, "1, 1");

		layoutParamPanel.add(updateDurationLabel, "0, 2");
		layoutParamPanel.add(updateDurationSlider, "1, 2");
		layoutParamPanel.add(yOffsetLabel, "0, 2");
		layoutParamPanel.add(yOffsetSlider, "1, 2");
		
		layoutParamPanel.add(xGapLabel, "0, 3");
		layoutParamPanel.add(xGapSlider, "1, 3");
		
		layoutParamPanel.add(yGapLabel, "0, 4");
		layoutParamPanel.add(yGapSlider, "1, 4");
		
		layoutParamPanel.add(animationLabel, "0, 5");
		layoutParamPanel.add(animationCheckBox, "1, 5");
		
		runButton = new JBasicButton("运行", TIconFactory.getContextIcon("run.png"), "运行布局");
		runButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				doLayout(true);
				
				runButton.setEnabled(false);
				stopButton.setEnabled(true);
			}
		}
		);
		
		stopButton = new JBasicButton("停止", TIconFactory.getContextIcon("stop.png"), "停止布局");
		stopButton.setEnabled(false);
		stopButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				layouter.stop();
				
				runButton.setEnabled(true);
				stopButton.setEnabled(false);
			}
		}
		);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
		buttonPanel.add(Box.createGlue());
		buttonPanel.add(runButton);
		buttonPanel.add(stopButton);
		buttonPanel.add(Box.createGlue());
		
		ButtonManager.updateUI(buttonPanel, new Dimension(55, 25));
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		add(layoutModePanel);
		add(layoutParamPanel);
		add(buttonPanel);
		
		typeComboBox.setSelectedIndex(1);
	}
	
	private void doLayout(boolean enabled)
	{
		if (enabled)
		{
			TLayoutType layoutType = (TLayoutType) typeComboBox.getSelectedItem();
			doLayout(layoutType);
		}
	}
	
	private void doLayout(TLayoutType layoutType)
	{		
		boolean isAllElementsLayouted = (elementComboBox.getSelectedIndex() == 0);
		boolean isAnimated = animationCheckBox.isSelected();
		int xOffset = xOffsetSlider.getValue(); 
		int yOffset = yOffsetSlider.getValue(); 
		int xGap = xGapSlider.getValue();
		int yGap = yGapSlider.getValue();
		
		layouter.doLayout(layoutType, isAllElementsLayouted, isAnimated, xOffset, yOffset, xGap, yGap);
	}
}