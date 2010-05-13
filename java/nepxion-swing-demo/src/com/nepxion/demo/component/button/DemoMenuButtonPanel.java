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

import com.nepxion.demo.common.DemoComponentFactory;
import com.nepxion.swing.border.ComplexEtchedBorder;
import com.nepxion.swing.border.ComplexSide;
import com.nepxion.swing.border.ComplexTitleBorder;
import com.nepxion.swing.button.JBasicMenuButton;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.layout.filed.FiledLayout;
import com.nepxion.swing.style.button.flat.FlatMenuButtonUI;
import com.nepxion.swing.style.button.lite.JAcidLiteButtonStyle;
import com.nepxion.swing.style.button.lite.JAlloyLiteButtonStyle;
import com.nepxion.swing.style.button.lite.JBedouinLiteButtonStyle;
import com.nepxion.swing.style.button.lite.JBlueLiteButtonStyle;
import com.nepxion.swing.style.button.lite.JBorlandLiteButtonStyle;
import com.nepxion.swing.style.button.lite.JEclipseLiteButtonStyle;
import com.nepxion.swing.style.button.lite.JGlassLiteButtonStyle;
import com.nepxion.swing.style.button.lite.JNimbusLiteButtonStyle;
import com.nepxion.swing.style.button.lite.JYellowLiteButtonStyle;
import com.nepxion.swing.style.button.lite.LiteMenuButtonUI;

public class DemoMenuButtonPanel
	extends JPanel
{
	public DemoMenuButtonPanel()
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
			
			JBasicMenuButton flatStyleButton = new JBasicMenuButton("JFlat Style", IconFactory.getSwingIcon("component/button_16.png"), "JFlat Style");
			flatStyleButton.setUI(new FlatMenuButtonUI());
			flatStyleButton.setPopupMenu(DemoComponentFactory.createDecorationPopupMenu());
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
			
			JBasicMenuButton alloyStyleButton = new JBasicMenuButton("JAlloy Style", IconFactory.getSwingIcon("component/button_16.png"), "JAlloy Style");
			alloyStyleButton.setUI(new LiteMenuButtonUI(new JAlloyLiteButtonStyle()));
			alloyStyleButton.setPopupMenu(DemoComponentFactory.createDecorationPopupMenu());
			add(alloyStyleButton);
			
			JBasicMenuButton acidStyleButton = new JBasicMenuButton("JAcid Style", IconFactory.getSwingIcon("component/button_16.png"), "JAcid Style");
			acidStyleButton.setUI(new LiteMenuButtonUI(new JAcidLiteButtonStyle()));
			acidStyleButton.setPopupMenu(DemoComponentFactory.createDecorationPopupMenu());
			add(acidStyleButton);
			
			JBasicMenuButton bedouinStyleButton = new JBasicMenuButton("JBedouin Style", IconFactory.getSwingIcon("component/button_16.png"), "JBedouin Style");
			bedouinStyleButton.setUI(new LiteMenuButtonUI(new JBedouinLiteButtonStyle()));
			bedouinStyleButton.setPopupMenu(DemoComponentFactory.createDecorationPopupMenu());
			add(bedouinStyleButton);
			
			JBasicMenuButton glassStyleButton = new JBasicMenuButton("JGlass Style", IconFactory.getSwingIcon("component/button_16.png"), "JGlass Style");
			glassStyleButton.setUI(new LiteMenuButtonUI(new JGlassLiteButtonStyle()));
			glassStyleButton.setPopupMenu(DemoComponentFactory.createDecorationPopupMenu());
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
			
			JBasicMenuButton eclipseStyleButton = new JBasicMenuButton("JEclipse Style", IconFactory.getSwingIcon("component/button_16.png"), "JEclipse Style");
			eclipseStyleButton.setUI(new LiteMenuButtonUI(new JEclipseLiteButtonStyle()));
			eclipseStyleButton.setPopupMenu(DemoComponentFactory.createDecorationPopupMenu());
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
			
			JBasicMenuButton borlandStyleButton = new JBasicMenuButton("JBorland Style", IconFactory.getSwingIcon("component/button_16.png"), "JBorland Style");
			borlandStyleButton.setUI(new LiteMenuButtonUI(new JBorlandLiteButtonStyle()));
			borlandStyleButton.setPopupMenu(DemoComponentFactory.createDecorationPopupMenu());
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
			
			JBasicMenuButton nimbusStyleButton = new JBasicMenuButton("JNimbus Style", IconFactory.getSwingIcon("component/button_16.png"), "JNimbus Style");
			nimbusStyleButton.setUI(new LiteMenuButtonUI(new JNimbusLiteButtonStyle()));
			nimbusStyleButton.setPopupMenu(DemoComponentFactory.createDecorationPopupMenu());
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
			
			JBasicMenuButton blueStyleButton = new JBasicMenuButton("JBlue Style", IconFactory.getSwingIcon("component/button_16.png"), "JBlue Style");
			blueStyleButton.setUI(new LiteMenuButtonUI(new JBlueLiteButtonStyle()));
			blueStyleButton.setPopupMenu(DemoComponentFactory.createDecorationPopupMenu());
			add(blueStyleButton);
			
			JBasicMenuButton yellowStyleButton = new JBasicMenuButton("JYellow Style", IconFactory.getSwingIcon("component/button_16.png"), "JYellow Style");
			yellowStyleButton.setUI(new LiteMenuButtonUI(new JYellowLiteButtonStyle()));
			yellowStyleButton.setPopupMenu(DemoComponentFactory.createDecorationPopupMenu());
			add(yellowStyleButton);			
		}
	}
}