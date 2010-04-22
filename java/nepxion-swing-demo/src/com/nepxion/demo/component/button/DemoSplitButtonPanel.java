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
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import com.nepxion.swing.border.ComplexEtchedBorder;
import com.nepxion.swing.border.ComplexSide;
import com.nepxion.swing.border.ComplexTitleBorder;
import com.nepxion.swing.button.JFlatSplitButton;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.layout.filed.FiledLayout;
import com.nepxion.swing.popupmenu.JDecorationPopupMenu;
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
			
			JFlatSplitButton flatStyleButton = new JFlatSplitButton("Flat Style", IconFactory.getSwingIcon("component/button_16.png"));
			flatStyleButton.setUI(new FlatSplitButtonUI());
			flatStyleButton.setPopupMenu(new PopupMenu());
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
			
			JFlatSplitButton alloyStyleButton = new JFlatSplitButton("JAlloy Style", IconFactory.getSwingIcon("component/button_16.png"));
			alloyStyleButton.setUI(new LiteSplitButtonUI(new JAlloyLiteButtonStyle()));
			alloyStyleButton.setPopupMenu(new PopupMenu());
			add(alloyStyleButton);
			
			JFlatSplitButton acidStyleButton = new JFlatSplitButton("JAcid Style", IconFactory.getSwingIcon("component/button_16.png"));
			acidStyleButton.setUI(new LiteSplitButtonUI(new JAcidLiteButtonStyle()));
			acidStyleButton.setPopupMenu(new PopupMenu());
			add(acidStyleButton);
			
			JFlatSplitButton bedouinStyleButton = new JFlatSplitButton("JBedouin Style", IconFactory.getSwingIcon("component/button_16.png"));
			bedouinStyleButton.setUI(new LiteSplitButtonUI(new JBedouinLiteButtonStyle()));
			bedouinStyleButton.setPopupMenu(new PopupMenu());
			add(bedouinStyleButton);
			
			JFlatSplitButton glassStyleButton = new JFlatSplitButton("JGlass Style", IconFactory.getSwingIcon("component/button_16.png"));
			glassStyleButton.setUI(new LiteSplitButtonUI(new JGlassLiteButtonStyle()));
			glassStyleButton.setPopupMenu(new PopupMenu());
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
			
			JFlatSplitButton eclipseStyleButton = new JFlatSplitButton("JEclipse Style", IconFactory.getSwingIcon("component/button_16.png"));
			eclipseStyleButton.setUI(new LiteSplitButtonUI(new JEclipseLiteButtonStyle()));
			eclipseStyleButton.setPopupMenu(new PopupMenu());
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
			
			JFlatSplitButton borlandStyleButton = new JFlatSplitButton("JBorland Style", IconFactory.getSwingIcon("component/button_16.png"));
			borlandStyleButton.setUI(new LiteSplitButtonUI(new JBorlandLiteButtonStyle()));
			borlandStyleButton.setPopupMenu(new PopupMenu());
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
			
			JFlatSplitButton nimbusStyleButton = new JFlatSplitButton("JNimbus Style", IconFactory.getSwingIcon("component/button_16.png"));
			nimbusStyleButton.setUI(new LiteSplitButtonUI(new JNimbusLiteButtonStyle()));
			nimbusStyleButton.setPopupMenu(new PopupMenu());
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
			
			JFlatSplitButton blueStyleButton = new JFlatSplitButton("JBlue Style", IconFactory.getSwingIcon("component/button_16.png"));
			blueStyleButton.setUI(new LiteSplitButtonUI(new JBlueLiteButtonStyle()));
			blueStyleButton.setPopupMenu(new PopupMenu());
			add(blueStyleButton);
			
			JFlatSplitButton yellowStyleButton = new JFlatSplitButton("JYellow Style", IconFactory.getSwingIcon("component/button_16.png"));
			yellowStyleButton.setUI(new LiteSplitButtonUI(new JYellowLiteButtonStyle()));
			yellowStyleButton.setPopupMenu(new PopupMenu());
			add(yellowStyleButton);			
		}
	}
	
	public class PopupMenu
		extends JDecorationPopupMenu
	{
		public PopupMenu()
		{			
			JMenu menu1 = new JMenu("Menu");
			menu1.setIcon(IconFactory.getSwingIcon("component/menu_16.png"));
			menu1.add(new JMenuItem("MenuItem", IconFactory.getSwingIcon("component/menu_16.png")));
			menu1.add(new JMenuItem("MenuItem", IconFactory.getSwingIcon("component/menu_16.png")));
			add(menu1);
						
			JMenu menu2 = new JMenu("Menu");
			menu2.setIcon(IconFactory.getSwingIcon("component/popup_menu_16.png"));
			menu2.add(new JMenuItem("MenuItem", IconFactory.getSwingIcon("component/popup_menu_16.png")));
			menu2.add(new JMenuItem("MenuItem", IconFactory.getSwingIcon("component/popup_menu_16.png")));
			add(menu2);
			
			addSeparator();
			
			JMenu menu3 = new JMenu("Menu");
			menu3.setIcon(IconFactory.getSwingIcon("component/list_16.png"));
			menu3.add(new JMenuItem("MenuItem", IconFactory.getSwingIcon("component/list_16.png")));
			menu3.add(new JMenuItem("MenuItem", IconFactory.getSwingIcon("component/list_16.png")));
			add(menu3);
		}
	}
}