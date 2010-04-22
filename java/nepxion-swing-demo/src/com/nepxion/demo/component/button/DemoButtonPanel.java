package com.nepxion.demo.component.button;

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

import com.nepxion.swing.border.ComplexEtchedBorder;
import com.nepxion.swing.border.ComplexSide;
import com.nepxion.swing.border.ComplexTitleBorder;
import com.nepxion.swing.button.JFlatButton;
import com.nepxion.swing.button.JStyleButton;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.layout.filed.FiledLayout;
import com.nepxion.swing.style.button.flat.FlatButtonUI;
import com.nepxion.swing.style.button.lite.JAcidLiteButtonStyle;
import com.nepxion.swing.style.button.lite.JAlloyLiteButtonStyle;
import com.nepxion.swing.style.button.lite.JBedouinLiteButtonStyle;
import com.nepxion.swing.style.button.lite.JBlueLiteButtonStyle;
import com.nepxion.swing.style.button.lite.JBorlandLiteButtonStyle;
import com.nepxion.swing.style.button.lite.JEclipseLiteButtonStyle;
import com.nepxion.swing.style.button.lite.JGlassLiteButtonStyle;
import com.nepxion.swing.style.button.lite.JNimbusLiteButtonStyle;
import com.nepxion.swing.style.button.lite.JYellowLiteButtonStyle;
import com.nepxion.swing.style.button.lite.LiteButtonUI;

public class DemoButtonPanel
	extends JPanel
{
	public DemoButtonPanel()
	{
		setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 0));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new FlatStyleButtonPanel());
		add(new AlloyStyleButtonPanel());
		add(new EclipseStyleButtonPanel());
		add(new BorlandStyleButtonPanel());
		add(new NimbusStyleButtonPanel());		
		add(new ColorStyleButtonPanel());
		add(new StyleButtonPanel());	
	}
	
	public class FlatStyleButtonPanel
		extends JPanel
	{
		public FlatStyleButtonPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(new ComplexTitleBorder(new ComplexEtchedBorder(ComplexEtchedBorder.LOWERED, ComplexSide.NORTH), "Flat ButtonUI"));

			JFlatButton flatStyleButton = new JFlatButton("Flat Style", IconFactory.getSwingIcon("component/button_16.png"));
			flatStyleButton.setDimension(new Dimension(80, 30));
			flatStyleButton.setUI(new FlatButtonUI());
			add(flatStyleButton);					
		}
	}
	
	public class AlloyStyleButtonPanel
		extends JPanel
	{
		public AlloyStyleButtonPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(new ComplexTitleBorder(new ComplexEtchedBorder(ComplexEtchedBorder.LOWERED, ComplexSide.NORTH), "Alloy ButtonUI"));
			
			JFlatButton alloyStyleButton = new JFlatButton("JAlloy Style", IconFactory.getSwingIcon("component/button_16.png"));
			alloyStyleButton.setDimension(new Dimension(92, 30));
			alloyStyleButton.setUI(new LiteButtonUI(new JAlloyLiteButtonStyle()));
			add(alloyStyleButton);
			
			JFlatButton acidStyleButton = new JFlatButton("JAcid Style", IconFactory.getSwingIcon("component/button_16.png"));
			acidStyleButton.setDimension(new Dimension(90, 30));
			acidStyleButton.setUI(new LiteButtonUI(new JAcidLiteButtonStyle()));
			add(acidStyleButton);
			
			JFlatButton bedouinStyleButton = new JFlatButton("JBedouin Style", IconFactory.getSwingIcon("component/button_16.png"));
			bedouinStyleButton.setDimension(new Dimension(110, 30));
			bedouinStyleButton.setUI(new LiteButtonUI(new JBedouinLiteButtonStyle()));
			add(bedouinStyleButton);
			
			JFlatButton glassStyleButton = new JFlatButton("JGlass Style", IconFactory.getSwingIcon("component/button_16.png"));
			glassStyleButton.setDimension(new Dimension(100, 30));
			glassStyleButton.setUI(new LiteButtonUI(new JGlassLiteButtonStyle()));
			add(glassStyleButton);						
		}
	}
	
	public class EclipseStyleButtonPanel
		extends JPanel
	{
		public EclipseStyleButtonPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(new ComplexTitleBorder(new ComplexEtchedBorder(ComplexEtchedBorder.LOWERED, ComplexSide.NORTH), "Eclipse ButtonUI"));
			
			JFlatButton eclipseStyleButton = new JFlatButton("JEclipse Style", IconFactory.getSwingIcon("component/button_16.png"));
			eclipseStyleButton.setDimension(new Dimension(108, 30));
			eclipseStyleButton.setUI(new LiteButtonUI(new JEclipseLiteButtonStyle()));
			add(eclipseStyleButton);			
		}
	}	
	
	public class BorlandStyleButtonPanel
		extends JPanel
	{
		public BorlandStyleButtonPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(new ComplexTitleBorder(new ComplexEtchedBorder(ComplexEtchedBorder.LOWERED, ComplexSide.NORTH), "Borland ButtonUI"));
			
			JFlatButton borlandStyleButton = new JFlatButton("JBorland Style", IconFactory.getSwingIcon("component/button_16.png"));
			borlandStyleButton.setDimension(new Dimension(110, 30));
			borlandStyleButton.setUI(new LiteButtonUI(new JBorlandLiteButtonStyle()));
			add(borlandStyleButton);			
		}
	}
	
	public class NimbusStyleButtonPanel
		extends JPanel
	{
		public NimbusStyleButtonPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(new ComplexTitleBorder(new ComplexEtchedBorder(ComplexEtchedBorder.LOWERED, ComplexSide.NORTH), "Nimbus ButtonUI"));
			
			JFlatButton nimbusStyleButton = new JFlatButton("JNimbus Style", IconFactory.getSwingIcon("component/button_16.png"));
			nimbusStyleButton.setDimension(new Dimension(110, 30));
			nimbusStyleButton.setUI(new LiteButtonUI(new JNimbusLiteButtonStyle()));
			add(nimbusStyleButton);			
		}
	}	
	
	public class ColorStyleButtonPanel
		extends JPanel
	{
		public ColorStyleButtonPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(new ComplexTitleBorder(new ComplexEtchedBorder(ComplexEtchedBorder.LOWERED, ComplexSide.NORTH), "Color ButtonUI"));
			
			JFlatButton blueStyleButton = new JFlatButton("JBlue Style", IconFactory.getSwingIcon("component/button_16.png"));
			blueStyleButton.setDimension(new Dimension(92, 30));
			blueStyleButton.setUI(new LiteButtonUI(new JBlueLiteButtonStyle()));
			add(blueStyleButton);	
			
			JFlatButton yellowStyleButton = new JFlatButton("JYellow Style", IconFactory.getSwingIcon("component/button_16.png"));
			yellowStyleButton.setDimension(new Dimension(104, 30));
			yellowStyleButton.setUI(new LiteButtonUI(new JYellowLiteButtonStyle()));
			add(yellowStyleButton);						
		}
	}		
	
	public class StyleButtonPanel
		extends JPanel
	{
		public StyleButtonPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(new ComplexTitleBorder(new ComplexEtchedBorder(ComplexEtchedBorder.LOWERED, ComplexSide.NORTH), "Style ButtonUI"));
			
			JStyleButton flatStyleButton = new JStyleButton("Flat Style", IconFactory.getSwingIcon("component/button_16.png"));
			flatStyleButton.setDimension(new Dimension(80, 30));
			flatStyleButton.setButtonStyle(JStyleButton.FLAT_STYLE);
			add(flatStyleButton);
			
			JStyleButton hyperLinkStyleButton = new JStyleButton("HyperLink Style", IconFactory.getSwingIcon("component/button_16.png"));
			hyperLinkStyleButton.setDimension(new Dimension(110, 30));
			hyperLinkStyleButton.setButtonStyle(JStyleButton.HYPERLINK_STYLE);
			add(hyperLinkStyleButton);
			
			JStyleButton toolBarStyleButton = new JStyleButton("ToolBar Style", IconFactory.getSwingIcon("component/button_16.png"));
			toolBarStyleButton.setDimension(new Dimension(100, 30));
			toolBarStyleButton.setButtonStyle(JStyleButton.TOOLBAR_STYLE);
			add(toolBarStyleButton);
			
			JStyleButton toolBoxStyleButton = new JStyleButton("ToolBox Style", IconFactory.getSwingIcon("component/button_16.png"));
			toolBoxStyleButton.setDimension(new Dimension(100, 30));
			toolBoxStyleButton.setButtonStyle(JStyleButton.TOOLBOX_STYLE);
			add(toolBoxStyleButton);			
		}
	}
}