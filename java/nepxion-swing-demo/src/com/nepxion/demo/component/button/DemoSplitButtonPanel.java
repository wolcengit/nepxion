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

import com.nepxion.demo.common.DemoDataFactory;
import com.nepxion.swing.border.ComplexEtchedBorder;
import com.nepxion.swing.border.ComplexSide;
import com.nepxion.swing.border.ComplexTitleBorder;
import com.nepxion.swing.button.JBasicSplitButton;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.layout.filed.FiledLayout;
import com.nepxion.swing.style.button.flat.FlatSplitButtonUI;
import com.nepxion.swing.style.button.lite.JAcidLiteButtonStyle;
import com.nepxion.swing.style.button.lite.JAlloyLiteButtonStyle;
import com.nepxion.swing.style.button.lite.JBedouinLiteButtonStyle;
import com.nepxion.swing.style.button.lite.JBlueLiteButtonStyle;
import com.nepxion.swing.style.button.lite.JBorlandLiteButtonStyle;
import com.nepxion.swing.style.button.lite.JEclipseLiteButtonStyle;
import com.nepxion.swing.style.button.lite.JGlassLiteButtonStyle;
import com.nepxion.swing.style.button.lite.JNimbusLiteButtonStyle;
import com.nepxion.swing.style.button.lite.JYellowLiteButtonStyle;
import com.nepxion.swing.style.button.lite.LiteSplitButtonUI;

public class DemoSplitButtonPanel
	extends JPanel
{
	public DemoSplitButtonPanel()
	{
		setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 0));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new FlatStyleButtonPanel());
		add(new AlloyStyleButtonPanel());
		add(new EclipseStyleButtonPanel());
		add(new BorlandStyleButtonPanel());
		add(new NimbusStyleButtonPanel());
		add(new ColorStyleButtonPanel());
	}
	
	public class FlatStyleButtonPanel
		extends JPanel
	{
		public FlatStyleButtonPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(new ComplexTitleBorder(new ComplexEtchedBorder(ComplexEtchedBorder.LOWERED, ComplexSide.NORTH), "Flat ButtonUI"));
			
			JBasicSplitButton flatStyleButton = new JBasicSplitButton("JFlat Style", IconFactory.getSwingIcon("component/button_16.png"));
			flatStyleButton.setUI(new FlatSplitButtonUI());
			flatStyleButton.setPopupMenu(DemoDataFactory.createDecorationPopupMenu());
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
			
			JBasicSplitButton alloyStyleButton = new JBasicSplitButton("JAlloy Style", IconFactory.getSwingIcon("component/button_16.png"));
			alloyStyleButton.setUI(new LiteSplitButtonUI(new JAlloyLiteButtonStyle()));
			alloyStyleButton.setPopupMenu(DemoDataFactory.createDecorationPopupMenu());
			add(alloyStyleButton);
			
			JBasicSplitButton acidStyleButton = new JBasicSplitButton("JAcid Style", IconFactory.getSwingIcon("component/button_16.png"));
			acidStyleButton.setUI(new LiteSplitButtonUI(new JAcidLiteButtonStyle()));
			acidStyleButton.setPopupMenu(DemoDataFactory.createDecorationPopupMenu());
			add(acidStyleButton);
			
			JBasicSplitButton bedouinStyleButton = new JBasicSplitButton("JBedouin Style", IconFactory.getSwingIcon("component/button_16.png"));
			bedouinStyleButton.setUI(new LiteSplitButtonUI(new JBedouinLiteButtonStyle()));
			bedouinStyleButton.setPopupMenu(DemoDataFactory.createDecorationPopupMenu());
			add(bedouinStyleButton);
			
			JBasicSplitButton glassStyleButton = new JBasicSplitButton("JGlass Style", IconFactory.getSwingIcon("component/button_16.png"));
			glassStyleButton.setUI(new LiteSplitButtonUI(new JGlassLiteButtonStyle()));
			glassStyleButton.setPopupMenu(DemoDataFactory.createDecorationPopupMenu());
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
			
			JBasicSplitButton eclipseStyleButton = new JBasicSplitButton("JEclipse Style", IconFactory.getSwingIcon("component/button_16.png"));
			eclipseStyleButton.setUI(new LiteSplitButtonUI(new JEclipseLiteButtonStyle()));
			eclipseStyleButton.setPopupMenu(DemoDataFactory.createDecorationPopupMenu());
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
			
			JBasicSplitButton borlandStyleButton = new JBasicSplitButton("JBorland Style", IconFactory.getSwingIcon("component/button_16.png"));
			borlandStyleButton.setUI(new LiteSplitButtonUI(new JBorlandLiteButtonStyle()));
			borlandStyleButton.setPopupMenu(DemoDataFactory.createDecorationPopupMenu());
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
			
			JBasicSplitButton nimbusStyleButton = new JBasicSplitButton("JNimbus Style", IconFactory.getSwingIcon("component/button_16.png"));
			nimbusStyleButton.setUI(new LiteSplitButtonUI(new JNimbusLiteButtonStyle()));
			nimbusStyleButton.setPopupMenu(DemoDataFactory.createDecorationPopupMenu());
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
			
			JBasicSplitButton blueStyleButton = new JBasicSplitButton("JBlue Style", IconFactory.getSwingIcon("component/button_16.png"));
			blueStyleButton.setUI(new LiteSplitButtonUI(new JBlueLiteButtonStyle()));
			blueStyleButton.setPopupMenu(DemoDataFactory.createDecorationPopupMenu());
			add(blueStyleButton);
			
			JBasicSplitButton yellowStyleButton = new JBasicSplitButton("JYellow Style", IconFactory.getSwingIcon("component/button_16.png"));
			yellowStyleButton.setUI(new LiteSplitButtonUI(new JYellowLiteButtonStyle()));
			yellowStyleButton.setPopupMenu(DemoDataFactory.createDecorationPopupMenu());
			add(yellowStyleButton);			
		}
	}
}