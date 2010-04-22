package com.nepxion.demo.component.popupmenu;

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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import com.nepxion.swing.border.ComplexEtchedBorder;
import com.nepxion.swing.border.ComplexSide;
import com.nepxion.swing.border.ComplexTitleBorder;
import com.nepxion.swing.button.JFlatButton;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.layout.filed.FiledLayout;
import com.nepxion.swing.popupmenu.JDecorationPopupMenu;
import com.nepxion.swing.popupmenu.JDecorationPopupMenuPainter;
import com.nepxion.swing.style.button.flat.FlatButtonUI;
import com.nepxion.swing.style.button.lite.JAcidLiteButtonStyle;
import com.nepxion.swing.style.button.lite.JAlloyLiteButtonStyle;
import com.nepxion.swing.style.button.lite.JBedouinLiteButtonStyle;
import com.nepxion.swing.style.button.lite.JBlueLiteButtonStyle;
import com.nepxion.swing.style.button.lite.JEclipseLiteButtonStyle;
import com.nepxion.swing.style.button.lite.JGlassLiteButtonStyle;
import com.nepxion.swing.style.button.lite.JNimbusLiteButtonStyle;
import com.nepxion.swing.style.button.lite.JYellowLiteButtonStyle;
import com.nepxion.swing.style.button.lite.LiteButtonUI;
import com.nepxion.swing.style.framework.IStyle;
import com.nepxion.swing.style.framework.JEclipseStyle;
import com.nepxion.swing.style.framework.JFervencyStyle;
import com.nepxion.swing.style.framework.JLiteStyle;
import com.nepxion.swing.style.framework.JNimbusStyle;
import com.nepxion.swing.style.framework.JPlasticStyle;
import com.nepxion.swing.style.framework.JWindowsStyle;

public class DemoDecorationPopupMenuPanel
	extends JPanel
{
	public DemoDecorationPopupMenuPanel()
	{
		setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 0));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new WindowsStylePopupMenuPanel());
		add(new LiteStylePopupMenuPanel());
		add(new EclipseStylePopupMenuPanel());
		add(new PlasticStylePopupMenuPanel());
		add(new NimbusStylePopupMenuPanel());		
		add(new FervencyStylePopupMenuPanel());
	}
	
	public class WindowsStylePopupMenuPanel
		extends JPanel
	{
		public WindowsStylePopupMenuPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(new ComplexTitleBorder(new ComplexEtchedBorder(ComplexEtchedBorder.LOWERED, ComplexSide.NORTH), "JWindows Style for PopupMenu"));

			JFlatButton flatStyleButton = new JFlatButton("Windows Style", IconFactory.getSwingIcon("component/popup_menu_16.png"));
			flatStyleButton.setDimension(new Dimension(110, 30));
			flatStyleButton.setUI(new FlatButtonUI());
			createPopupMenu(flatStyleButton, "JWindows", new JWindowsStyle());
			add(flatStyleButton);					
		}
	}
	
	public class LiteStylePopupMenuPanel
		extends JPanel
	{
		public LiteStylePopupMenuPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(new ComplexTitleBorder(new ComplexEtchedBorder(ComplexEtchedBorder.LOWERED, ComplexSide.NORTH), "JLite Style for PopupMenu"));
			
			JFlatButton alloyStyleButton = new JFlatButton("Lite Style", IconFactory.getSwingIcon("component/popup_menu_16.png"));
			alloyStyleButton.setDimension(new Dimension(80, 30));
			alloyStyleButton.setUI(new LiteButtonUI(new JAlloyLiteButtonStyle()));
			createPopupMenu(alloyStyleButton, "JLite", new JLiteStyle());
			add(alloyStyleButton);
			
			JFlatButton acidStyleButton = new JFlatButton("Lite Style", IconFactory.getSwingIcon("component/popup_menu_16.png"));
			acidStyleButton.setDimension(new Dimension(80, 30));
			acidStyleButton.setUI(new LiteButtonUI(new JAcidLiteButtonStyle()));
			createPopupMenu(acidStyleButton, "JLite", new JLiteStyle());
			add(acidStyleButton);
			
			JFlatButton bedouinStyleButton = new JFlatButton("Lite Style", IconFactory.getSwingIcon("component/popup_menu_16.png"));
			bedouinStyleButton.setDimension(new Dimension(80, 30));
			bedouinStyleButton.setUI(new LiteButtonUI(new JBedouinLiteButtonStyle()));
			createPopupMenu(bedouinStyleButton, "JLite", new JLiteStyle());
			add(bedouinStyleButton);
			
			JFlatButton glassStyleButton = new JFlatButton("Lite Style", IconFactory.getSwingIcon("component/popup_menu_16.png"));
			glassStyleButton.setDimension(new Dimension(80, 30));
			glassStyleButton.setUI(new LiteButtonUI(new JGlassLiteButtonStyle()));
			createPopupMenu(glassStyleButton, "JLite", new JLiteStyle());
			add(glassStyleButton);						
		}
	}
	
	public class EclipseStylePopupMenuPanel
		extends JPanel
	{
		public EclipseStylePopupMenuPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(new ComplexTitleBorder(new ComplexEtchedBorder(ComplexEtchedBorder.LOWERED, ComplexSide.NORTH), "JEclipse Style for PopupMenu"));
			
			JFlatButton eclipseStyleButton = new JFlatButton("Eclipse Style", IconFactory.getSwingIcon("component/popup_menu_16.png"));
			eclipseStyleButton.setDimension(new Dimension(108, 30));
			eclipseStyleButton.setUI(new LiteButtonUI(new JEclipseLiteButtonStyle()));
			createPopupMenu(eclipseStyleButton, "JEclipse", new JEclipseStyle());
			add(eclipseStyleButton);			
		}
	}	
	
	public class PlasticStylePopupMenuPanel
		extends JPanel
	{
		public PlasticStylePopupMenuPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(new ComplexTitleBorder(new ComplexEtchedBorder(ComplexEtchedBorder.LOWERED, ComplexSide.NORTH), "JPlastic Style for PopupMenu"));
			
			JFlatButton eclipseStyleButton = new JFlatButton("JPlastic Style", IconFactory.getSwingIcon("component/popup_menu_16.png"));
			eclipseStyleButton.setDimension(new Dimension(108, 30));
			eclipseStyleButton.setUI(new LiteButtonUI(new JEclipseLiteButtonStyle()));
			createPopupMenu(eclipseStyleButton, "JPlastic", new JPlasticStyle());
			add(eclipseStyleButton);
		}
	}	
	
	public class NimbusStylePopupMenuPanel
		extends JPanel
	{
		public NimbusStylePopupMenuPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(new ComplexTitleBorder(new ComplexEtchedBorder(ComplexEtchedBorder.LOWERED, ComplexSide.NORTH), "Nimbus Style for PopupMenu"));
			
			JFlatButton nimbusStyleButton = new JFlatButton("JNimbus Style", IconFactory.getSwingIcon("component/popup_menu_16.png"));
			nimbusStyleButton.setDimension(new Dimension(110, 30));
			nimbusStyleButton.setUI(new LiteButtonUI(new JNimbusLiteButtonStyle()));
			createPopupMenu(nimbusStyleButton, "JNimbus", new JNimbusStyle());
			add(nimbusStyleButton);			
		}
	}	
	
	public class FervencyStylePopupMenuPanel
		extends JPanel
	{
		public FervencyStylePopupMenuPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(new ComplexTitleBorder(new ComplexEtchedBorder(ComplexEtchedBorder.LOWERED, ComplexSide.NORTH), "Fervency Style for PopupMenu"));
			
			JFlatButton blueStyleButton = new JFlatButton("JBlue Style", IconFactory.getSwingIcon("component/popup_menu_16.png"));
			blueStyleButton.setDimension(new Dimension(92, 30));
			blueStyleButton.setUI(new LiteButtonUI(new JBlueLiteButtonStyle()));
			createPopupMenu(blueStyleButton, "JNimbus", new JFervencyStyle());
			add(blueStyleButton);	
			
			JFlatButton yellowStyleButton = new JFlatButton("JYellow Style", IconFactory.getSwingIcon("component/popup_menu_16.png"));
			yellowStyleButton.setDimension(new Dimension(104, 30));
			yellowStyleButton.setUI(new LiteButtonUI(new JYellowLiteButtonStyle()));
			createPopupMenu(yellowStyleButton, "JNimbus", new JFervencyStyle());
			add(yellowStyleButton);						
		}
	}
	
	public void createPopupMenu(final JFlatButton button, String text, IStyle style)
	{
		final PopupMenu popupMenu = new PopupMenu();
		popupMenu.setPainter(new JDecorationPopupMenuPainter(text, style));
		button.addMouseListener(new MouseAdapter()
		{
			public void mouseReleased(MouseEvent e)
			{
				int x = e.getX();
				int y = e.getY();
				popupMenu.show(button, x, y);
			}
		}
		);
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