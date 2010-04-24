package com.nepxion.demo.component.panel;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.nepxion.swing.border.ComplexEtchedBorder;
import com.nepxion.swing.border.ComplexSide;
import com.nepxion.swing.border.ComplexTitleBorder;
import com.nepxion.swing.dimension.DimensionManager;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.layout.filed.FiledLayout;
import com.nepxion.swing.panel.decoration.JDecorationPanel;
import com.nepxion.swing.style.framework.JAcidLiteStyle;
import com.nepxion.swing.style.framework.JEclipseStyle;
import com.nepxion.swing.style.framework.JFervencyStyle;
import com.nepxion.swing.style.framework.JNimbusStyle;
import com.nepxion.swing.style.framework.JPlasticStyle;
import com.nepxion.swing.style.framework.JWindowsStyle;
import com.nepxion.swing.textarea.JBasicTextArea;

public class DemoDecorationPanel
	extends JPanel
{
	public DemoDecorationPanel()
	{
		setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 0));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new WindowsStyleDecorationPanel());
		add(new LiteStyleDecorationPanel());
		add(new EclipseStyleDecorationPanel());
		add(new PlasticStyleDecorationPanel());
		add(new NimbusStyleDecorationPanel());		
		add(new FervencyStyleDecorationPanel());
	}
	
	public class WindowsStyleDecorationPanel
		extends JPanel
	{
		public WindowsStyleDecorationPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(new ComplexTitleBorder(new ComplexEtchedBorder(ComplexEtchedBorder.LOWERED, ComplexSide.NORTH), "JWindows Style"));
			
			JDecorationPanel windowsStyleDecorationPanel = new JDecorationPanel("JWindows Style", IconFactory.getSwingIcon("component/internal_frame_16.png"), true, new JScrollPane(new JBasicTextArea()), new JWindowsStyle());			
			DimensionManager.setDimension(windowsStyleDecorationPanel, new Dimension(200, 80));	
			add(windowsStyleDecorationPanel);					
		}
	}
	
	public class LiteStyleDecorationPanel
		extends JPanel
	{
		public LiteStyleDecorationPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(new ComplexTitleBorder(new ComplexEtchedBorder(ComplexEtchedBorder.LOWERED, ComplexSide.NORTH), "JLite Style"));
			
			JDecorationPanel liteStyleDecorationPanel = new JDecorationPanel("JLite Style", IconFactory.getSwingIcon("component/internal_frame_16.png"), true, new JScrollPane(new JBasicTextArea()), new JAcidLiteStyle());			
			DimensionManager.setDimension(liteStyleDecorationPanel, new Dimension(200, 80));	
			add(liteStyleDecorationPanel);					
		}
	}
	
	public class EclipseStyleDecorationPanel
		extends JPanel
	{
		public EclipseStyleDecorationPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(new ComplexTitleBorder(new ComplexEtchedBorder(ComplexEtchedBorder.LOWERED, ComplexSide.NORTH), "JEclipse Style"));
			
			JDecorationPanel eclipseStyleDecorationPanel = new JDecorationPanel("JEclipse Style", IconFactory.getSwingIcon("component/internal_frame_16.png"), true, new JScrollPane(new JBasicTextArea()), new JEclipseStyle());			
			DimensionManager.setDimension(eclipseStyleDecorationPanel, new Dimension(200, 80));	
			add(eclipseStyleDecorationPanel);				
		}
	}	
	
	public class PlasticStyleDecorationPanel
		extends JPanel
	{
		public PlasticStyleDecorationPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(new ComplexTitleBorder(new ComplexEtchedBorder(ComplexEtchedBorder.LOWERED, ComplexSide.NORTH), "JPlastic Style"));
			
			JDecorationPanel plasticStyleDecorationPanel = new JDecorationPanel("JPlastic Style", IconFactory.getSwingIcon("component/internal_frame_16.png"), true, new JScrollPane(new JBasicTextArea()), new JPlasticStyle());			
			DimensionManager.setDimension(plasticStyleDecorationPanel, new Dimension(200, 80));	
			add(plasticStyleDecorationPanel);	
		}
	}	
	
	public class NimbusStyleDecorationPanel
		extends JPanel
	{
		public NimbusStyleDecorationPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(new ComplexTitleBorder(new ComplexEtchedBorder(ComplexEtchedBorder.LOWERED, ComplexSide.NORTH), "JNimbus Style"));
			
			JDecorationPanel nimbusStyleDecorationPanel = new JDecorationPanel("JNimbus Style", IconFactory.getSwingIcon("component/internal_frame_16.png"), true, new JScrollPane(new JBasicTextArea()), new JNimbusStyle());			
			DimensionManager.setDimension(nimbusStyleDecorationPanel, new Dimension(200, 80));	
			add(nimbusStyleDecorationPanel);		
		}
	}	
	
	public class FervencyStyleDecorationPanel
		extends JPanel
	{
		public FervencyStyleDecorationPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(new ComplexTitleBorder(new ComplexEtchedBorder(ComplexEtchedBorder.LOWERED, ComplexSide.NORTH), "JFervency Style"));
			
			JDecorationPanel fervencyDecorationPanel = new JDecorationPanel("JFervency Style", IconFactory.getSwingIcon("component/internal_frame_16.png"), true, new JScrollPane(new JBasicTextArea()), new JFervencyStyle());			
			DimensionManager.setDimension(fervencyDecorationPanel, new Dimension(200, 80));	
			add(fervencyDecorationPanel);						
		}
	}
}