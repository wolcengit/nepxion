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

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.nepxion.swing.border.ComplexEtchedBorder;
import com.nepxion.swing.border.ComplexSide;
import com.nepxion.swing.border.ComplexTitleBorder;
import com.nepxion.swing.button.JFlatToggleButton;
import com.nepxion.swing.button.JStyleToggleButton;
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

public class DemoToggleButtonPanel
	extends JPanel
{
	public DemoToggleButtonPanel()
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
			
			JFlatToggleButton flatStyleButton = new JFlatToggleButton("Flat Style", IconFactory.getSwingIcon("component/button_16.png"));
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
			
			JFlatToggleButton alloyStyleButton = new JFlatToggleButton("JAlloy Style", IconFactory.getSwingIcon("component/button_16.png"));
			alloyStyleButton.setUI(new LiteButtonUI(new JAlloyLiteButtonStyle()));
			add(alloyStyleButton);
			
			JFlatToggleButton acidStyleButton = new JFlatToggleButton("JAcid Style", IconFactory.getSwingIcon("component/button_16.png"));
			acidStyleButton.setUI(new LiteButtonUI(new JAcidLiteButtonStyle()));
			add(acidStyleButton);
			
			JFlatToggleButton bedouinStyleButton = new JFlatToggleButton("JBedouin Style", IconFactory.getSwingIcon("component/button_16.png"));
			bedouinStyleButton.setUI(new LiteButtonUI(new JBedouinLiteButtonStyle()));
			add(bedouinStyleButton);
			
			JFlatToggleButton glassStyleButton = new JFlatToggleButton("JGlass Style", IconFactory.getSwingIcon("component/button_16.png"));
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
			
			JFlatToggleButton eclipseStyleButton = new JFlatToggleButton("JEclipse Style", IconFactory.getSwingIcon("component/button_16.png"));
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
			
			JFlatToggleButton borlandStyleButton = new JFlatToggleButton("JBorland Style", IconFactory.getSwingIcon("component/button_16.png"));
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
			
			JFlatToggleButton nimbusStyleButton = new JFlatToggleButton("JNimbus Style", IconFactory.getSwingIcon("component/button_16.png"));
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
			
			JFlatToggleButton blueStyleButton = new JFlatToggleButton("JBlue Style", IconFactory.getSwingIcon("component/button_16.png"));
			blueStyleButton.setUI(new LiteButtonUI(new JBlueLiteButtonStyle()));
			add(blueStyleButton);	
			
			JFlatToggleButton yellowStyleButton = new JFlatToggleButton("JYellow Style", IconFactory.getSwingIcon("component/button_16.png"));
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
			
			JStyleToggleButton flatStyleButton = new JStyleToggleButton("Flat Style", IconFactory.getSwingIcon("component/button_16.png"));
			flatStyleButton.setButtonStyle(JStyleToggleButton.FLAT_STYLE);
			add(flatStyleButton);
			
			JStyleToggleButton hyperLinkStyleButton = new JStyleToggleButton("HyperLink Style", IconFactory.getSwingIcon("component/button_16.png"));
			hyperLinkStyleButton.setButtonStyle(JStyleToggleButton.HYPERLINK_STYLE);
			add(hyperLinkStyleButton);
			
			JStyleToggleButton toolBarStyleButton = new JStyleToggleButton("ToolBar Style", IconFactory.getSwingIcon("component/button_16.png"));
			toolBarStyleButton.setButtonStyle(JStyleToggleButton.TOOLBAR_STYLE);
			add(toolBarStyleButton);
			
			/*JStyleToggleButton toolBoxStyleButton = new JStyleToggleButton("ToolBox Style", IconFactory.getSwingIcon("component/button_16.png"));
			toolBoxStyleButton.setButtonStyle(JStyleToggleButton.TOOLBOX_STYLE);
			add(toolBoxStyleButton);*/			
		}
	}
}