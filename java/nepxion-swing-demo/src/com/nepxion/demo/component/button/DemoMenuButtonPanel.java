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
import com.nepxion.swing.button.JFlatMenuButton;
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
			
			JFlatMenuButton flatStyleButton = new JFlatMenuButton("Flat Style", IconFactory.getSwingIcon("component/button_16.png"));
			flatStyleButton.setUI(new FlatMenuButtonUI());
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
			
			JFlatMenuButton alloyStyleButton = new JFlatMenuButton("JAlloy Style", IconFactory.getSwingIcon("component/button_16.png"));
			alloyStyleButton.setUI(new LiteMenuButtonUI(new JAlloyLiteButtonStyle()));
			alloyStyleButton.setPopupMenu(DemoDataFactory.createDecorationPopupMenu());
			add(alloyStyleButton);
			
			JFlatMenuButton acidStyleButton = new JFlatMenuButton("JAcid Style", IconFactory.getSwingIcon("component/button_16.png"));
			acidStyleButton.setUI(new LiteMenuButtonUI(new JAcidLiteButtonStyle()));
			acidStyleButton.setPopupMenu(DemoDataFactory.createDecorationPopupMenu());
			add(acidStyleButton);
			
			JFlatMenuButton bedouinStyleButton = new JFlatMenuButton("JBedouin Style", IconFactory.getSwingIcon("component/button_16.png"));
			bedouinStyleButton.setUI(new LiteMenuButtonUI(new JBedouinLiteButtonStyle()));
			bedouinStyleButton.setPopupMenu(DemoDataFactory.createDecorationPopupMenu());
			add(bedouinStyleButton);
			
			JFlatMenuButton glassStyleButton = new JFlatMenuButton("JGlass Style", IconFactory.getSwingIcon("component/button_16.png"));
			glassStyleButton.setUI(new LiteMenuButtonUI(new JGlassLiteButtonStyle()));
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
			
			JFlatMenuButton eclipseStyleButton = new JFlatMenuButton("JEclipse Style", IconFactory.getSwingIcon("component/button_16.png"));
			eclipseStyleButton.setUI(new LiteMenuButtonUI(new JEclipseLiteButtonStyle()));
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
			
			JFlatMenuButton borlandStyleButton = new JFlatMenuButton("JBorland Style", IconFactory.getSwingIcon("component/button_16.png"));
			borlandStyleButton.setUI(new LiteMenuButtonUI(new JBorlandLiteButtonStyle()));
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
			
			JFlatMenuButton nimbusStyleButton = new JFlatMenuButton("JNimbus Style", IconFactory.getSwingIcon("component/button_16.png"));
			nimbusStyleButton.setUI(new LiteMenuButtonUI(new JNimbusLiteButtonStyle()));
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
			
			JFlatMenuButton blueStyleButton = new JFlatMenuButton("JBlue Style", IconFactory.getSwingIcon("component/button_16.png"));
			blueStyleButton.setUI(new LiteMenuButtonUI(new JBlueLiteButtonStyle()));
			blueStyleButton.setPopupMenu(DemoDataFactory.createDecorationPopupMenu());
			add(blueStyleButton);
			
			JFlatMenuButton yellowStyleButton = new JFlatMenuButton("JYellow Style", IconFactory.getSwingIcon("component/button_16.png"));
			yellowStyleButton.setUI(new LiteMenuButtonUI(new JYellowLiteButtonStyle()));
			yellowStyleButton.setPopupMenu(DemoDataFactory.createDecorationPopupMenu());
			add(yellowStyleButton);			
		}
	}
}