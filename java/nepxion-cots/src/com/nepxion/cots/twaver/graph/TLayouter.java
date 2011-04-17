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

import twaver.Element;
import twaver.Generator;
import twaver.Group;
import twaver.SpringLayouter;

import com.nepxion.cots.twaver.element.TIconFactory;
import com.nepxion.swing.border.ComplexEtchedBorder;
import com.nepxion.swing.border.ComplexSide;
import com.nepxion.swing.border.ComplexTitleBorder;
import com.nepxion.swing.button.ButtonManager;
import com.nepxion.swing.button.JBasicButton;
import com.nepxion.swing.checkbox.JBasicCheckBox;
import com.nepxion.swing.combobox.JBasicComboBox;
import com.nepxion.swing.layout.table.TableLayout;

public class TLayouter
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
	
	private JLabel widthLabel;
	private JSlider widthSlider;
	
	private JLabel heightLabel;
	private JSlider heightSlider;
	
	private JLabel xOffsetLabel;
	private JSlider xOffsetSlider;
	
	private JLabel yOffsetLabel;
	private JSlider yOffsetSlider;
	
	private JLabel animationLabel;
	private JBasicCheckBox animationCheckBox;
	
	private JBasicButton runButton;
	private JBasicButton stopButton;
	
	private TGraph graph;
	private SpringLayouter layouter;
	
	public TLayouter(final TGraph graph)
	{
		this.graph = graph;
		this.layouter = graph.getSpringLayouter();
		
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
						
						widthLabel.setVisible(false);
						widthSlider.setVisible(false);
						
						heightLabel.setVisible(false);
						heightSlider.setVisible(false);
						
						xOffsetLabel.setVisible(false);
						xOffsetSlider.setVisible(false);
						
						yOffsetLabel.setVisible(false);
						yOffsetSlider.setVisible(false);
						
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
						
						widthLabel.setVisible(true);
						widthSlider.setVisible(true);
						
						heightLabel.setVisible(true);
						heightSlider.setVisible(true);	
						
						xOffsetLabel.setVisible(true);
						xOffsetSlider.setVisible(true);
						
						yOffsetLabel.setVisible(true);
						yOffsetSlider.setVisible(true);
						
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
		
		layouter.setForceSize(100);
		layouter.setStepSize(500);
		layouter.setUpdateDuration(10);
		
		forceSizeLabel = new JLabel("平衡间距");
		
		forceSizeSlider = new JSlider(10, 500, layouter.getForceSize());
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
		
		stepSizeSlider = new JSlider(1, 1000, layouter.getStepSize());
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
		
		updateDurationSlider = new JSlider(1, 500, layouter.getUpdateDuration());
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
		
		widthLabel = new JLabel("分布宽度");
		
		widthSlider = new JSlider(1, 200, 20);
		widthSlider.setToolTipText(widthSlider.getValue() + "");
		widthSlider.addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent e)
			{			
				widthSlider.setToolTipText(widthSlider.getValue() + "");	
				
				doLayout(stopButton.isEnabled());
			}
		}
		);
		
		heightLabel = new JLabel("分布高度");
		
		heightSlider = new JSlider(1, 200, 20);
		heightSlider.setToolTipText(heightSlider.getValue() + "");
		heightSlider.addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent e)
			{			
				heightSlider.setToolTipText(heightSlider.getValue() + "");	
				
				doLayout(stopButton.isEnabled());
			}
		}
		);
		
		xOffsetLabel = new JLabel("左侧间距");
		
		xOffsetSlider = new JSlider(0, 800, 150);
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
		
		yOffsetSlider = new JSlider(0, 800, 150);
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
		layoutParamPanel.add(widthLabel, "0, 1");
		layoutParamPanel.add(widthSlider, "1, 1");

		layoutParamPanel.add(updateDurationLabel, "0, 2");
		layoutParamPanel.add(updateDurationSlider, "1, 2");
		layoutParamPanel.add(heightLabel, "0, 2");
		layoutParamPanel.add(heightSlider, "1, 2");
		
		layoutParamPanel.add(xOffsetLabel, "0, 3");
		layoutParamPanel.add(xOffsetSlider, "1, 3");
		
		layoutParamPanel.add(yOffsetLabel, "0, 4");
		layoutParamPanel.add(yOffsetSlider, "1, 4");
		
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
		if (layoutType.equals(TLayoutType.SPRING_LAYOUT_TYPE))
		{
			layouter.start();
		}
		else if (layoutType.equals(TLayoutType.RANDOM_LAYOUT_TYPE))
		{
			layouter.stop();
			layouter.random(0, 600);
		}
		else
		{
			layouter.stop();
			
			graph.doLayout(elementComboBox.getSelectedIndex() == 0 ? graph.getDataBox().getAllElements().iterator() : graph.getDataBox().getSelectionModel().getAllSelectedElement().iterator(), layoutType.getType(), animationCheckBox.isSelected(), null, xOffsetSlider.getValue(), yOffsetSlider.getValue(), new Generator()
			{
				public Object generate(Object object)
				{
					Element element = (Element) object;
					if (element instanceof Group)
					{
						return null;
					}
					
					return new Dimension(widthSlider.getValue(), heightSlider.getValue());
				}
			}
			);
		}
	}
}