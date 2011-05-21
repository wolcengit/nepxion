package com.nepxion.swing.lookandfeel;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.awt.Font;
import java.lang.reflect.InvocationTargetException;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.FontUIResource;
import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.plaf.metal.MetalLookAndFeel;

import com.l2fprod.common.swing.plaf.LookAndFeelAddons;
import com.l2fprod.common.swing.plaf.aqua.AquaLookAndFeelAddons;
import com.l2fprod.common.swing.plaf.metal.MetalLookAndFeelAddons;
import com.l2fprod.common.swing.plaf.windows.WindowsClassicLookAndFeelAddons;
import com.l2fprod.common.swing.plaf.windows.WindowsLookAndFeelAddons;
import com.nepxion.swing.button.ButtonContext;
import com.nepxion.swing.button.ButtonManager;
import com.nepxion.swing.font.FontContext;
import com.nepxion.swing.font.FontManager;
import com.nepxion.swing.style.button.flat.FlatButtonUI;
import com.nepxion.swing.style.button.flat.FlatMenuButtonUI;
import com.nepxion.swing.style.button.flat.FlatSplitButtonUI;
import com.nepxion.swing.style.button.flat.JFlatButtonStyle;
import com.nepxion.swing.style.button.lite.JAcidLiteButtonStyle;
import com.nepxion.swing.style.button.lite.JAlloyLiteButtonStyle;
import com.nepxion.swing.style.button.lite.JBedouinLiteButtonStyle;
import com.nepxion.swing.style.button.lite.JBorlandLiteButtonStyle;
import com.nepxion.swing.style.button.lite.JEclipseLiteButtonStyle;
import com.nepxion.swing.style.button.lite.JGlassLiteButtonStyle;
import com.nepxion.swing.style.button.lite.JNimbusLiteButtonStyle;
import com.nepxion.swing.style.button.lite.LiteButtonUI;
import com.nepxion.swing.style.button.lite.LiteMenuButtonUI;
import com.nepxion.swing.style.button.lite.LiteSplitButtonUI;
import com.nepxion.swing.style.framework.JLiteStyle;
import com.nepxion.swing.style.framework.JNimbusStyle;
import com.nepxion.swing.style.framework.JWindowsStyle;
import com.nepxion.swing.style.framework.StyleContext;
import com.nepxion.swing.style.framework.StyleManager;

public class LookAndFeelManager
{
	public static void setSystemLookAndFeel()
	{
		setLookAndFeel(UIManager.getSystemLookAndFeelClassName(), JLiteStyle.ID, FlatButtonUI.ID, FlatMenuButtonUI.ID, FlatSplitButtonUI.ID, JFlatButtonStyle.ID);
	}
	
	public static void setDefaultMetalLookAndFeel()
	{
		try
		{
			MetalLookAndFeel lookAndFeel = new MetalLookAndFeel();
			lookAndFeel.setCurrentTheme(new DefaultMetalTheme()
			{
				private FontUIResource uiRes = new FontUIResource("Dialog", Font.PLAIN, 12);
				
				public FontUIResource getControlTextFont()
				{
					return uiRes;
				}
				
				public FontUIResource getSystemTextFont()
				{
					return uiRes;
				}
				
				public FontUIResource getUserTextFont()
				{
					return uiRes;
				}
				
				public FontUIResource getMenuTextFont()
				{
					return uiRes;
				}
				
				public FontUIResource getWindowTitleFont()
				{
					return uiRes;
				}
				
				public FontUIResource getSubTextFont()
				{
					return uiRes;
				}
			}
			);
			UIManager.setLookAndFeel(lookAndFeel);
		}
		catch (UnsupportedLookAndFeelException e)
		{
			e.printStackTrace();
		}
		
		setStyle(JLiteStyle.ID);
		setFont();
		setButtonUI(FlatButtonUI.ID, FlatMenuButtonUI.ID, FlatSplitButtonUI.ID, JFlatButtonStyle.ID);
	}
	
	public static void setMetalLookAndFeel()
	{
		setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel", JLiteStyle.ID, FlatButtonUI.ID, FlatMenuButtonUI.ID, FlatSplitButtonUI.ID, JFlatButtonStyle.ID);
	}
	
	public static void setWindowsLookAndFeel()
	{
		setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel", JWindowsStyle.ID, FlatButtonUI.ID, FlatMenuButtonUI.ID, FlatSplitButtonUI.ID, JFlatButtonStyle.ID);
	}
	
	public static void setMotifLookAndFeel()
	{
		setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel", JLiteStyle.ID, FlatButtonUI.ID, FlatMenuButtonUI.ID, FlatSplitButtonUI.ID, JFlatButtonStyle.ID);
	}
	
	public static void setGTKLookAndFeel()
	{
		setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel", JLiteStyle.ID, FlatButtonUI.ID, FlatMenuButtonUI.ID, FlatSplitButtonUI.ID, JFlatButtonStyle.ID);
	}
	
	public static void setNimbusLookAndFeel()
	{
		setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel", JNimbusStyle.ID, LiteButtonUI.ID, LiteMenuButtonUI.ID, LiteSplitButtonUI.ID, JNimbusLiteButtonStyle.ID);
	}
	
	public static void setAlloyLookAndFeel()
	{
		setLookAndFeel("com.incors.plaf.alloy.DefaultThemeAlloyLookAndFeel", JLiteStyle.ID, LiteButtonUI.ID, LiteMenuButtonUI.ID, LiteSplitButtonUI.ID, JAlloyLiteButtonStyle.ID);
	}
	
	public static void setAcidLookAndFeel()
	{
		setLookAndFeel("com.incors.plaf.alloy.AcidThemeAlloyLookAndFeel", JLiteStyle.ID, LiteButtonUI.ID, LiteMenuButtonUI.ID, LiteSplitButtonUI.ID, JAcidLiteButtonStyle.ID);
	}
	
	public static void setBedouinLookAndFeel()
	{
		setLookAndFeel("com.incors.plaf.alloy.BedouinThemeAlloyLookAndFeel", JLiteStyle.ID, LiteButtonUI.ID, LiteMenuButtonUI.ID, LiteSplitButtonUI.ID, JBedouinLiteButtonStyle.ID);
	}
	
	public static void setGlassLookAndFeel()
	{
		setLookAndFeel("com.incors.plaf.alloy.GlassThemeAlloyLookAndFeel", JLiteStyle.ID, LiteButtonUI.ID, LiteMenuButtonUI.ID, LiteSplitButtonUI.ID, JGlassLiteButtonStyle.ID);
	}
	
	public static void setBorlandLookAndFeel()
	{
		setLookAndFeel("com.borland.plaf.borland.BorlandLookAndFeel", JWindowsStyle.ID, LiteButtonUI.ID, LiteMenuButtonUI.ID, LiteSplitButtonUI.ID, JBorlandLiteButtonStyle.ID);
	}
	
	public static void setJGoodiesWindowsLookAndFeel()
	{
		setLookAndFeel("com.jgoodies.looks.windows.WindowsLookAndFeel", JWindowsStyle.ID, LiteButtonUI.ID, LiteMenuButtonUI.ID, LiteSplitButtonUI.ID, JEclipseLiteButtonStyle.ID);
	}
	
	public static void setPlasticLookAndFeel()
	{
		setLookAndFeel("com.jgoodies.looks.plastic.PlasticLookAndFeel", JWindowsStyle.ID, LiteButtonUI.ID, LiteMenuButtonUI.ID, LiteSplitButtonUI.ID, JEclipseLiteButtonStyle.ID);
	}
	
	public static void setPlasticXPLookAndFeel()
	{
		setLookAndFeel("com.jgoodies.looks.plastic.PlasticXPLookAndFeel", JWindowsStyle.ID, LiteButtonUI.ID, LiteMenuButtonUI.ID, LiteSplitButtonUI.ID, JEclipseLiteButtonStyle.ID);
	}
	
	public static void setPlastic3DLookAndFeel()
	{
		setLookAndFeel("com.jgoodies.looks.plastic.Plastic3DLookAndFeel", JWindowsStyle.ID, LiteButtonUI.ID, LiteMenuButtonUI.ID, LiteSplitButtonUI.ID, JEclipseLiteButtonStyle.ID);
	}
	
	public static void setXPLookAndFeel()
	{
		setLookAndFeel("com.stefankrause.xplookandfeel.XPLookAndFeel", JWindowsStyle.ID, FlatButtonUI.ID, FlatMenuButtonUI.ID, FlatSplitButtonUI.ID, JFlatButtonStyle.ID);
	}
	
	public static void setTinyLookAndFeel()
	{
		setLookAndFeel("de.muntjak.tinylookandfeel.TinyLookAndFeel", JWindowsStyle.ID, FlatButtonUI.ID, FlatMenuButtonUI.ID, FlatSplitButtonUI.ID, JFlatButtonStyle.ID);
	}
	
	public static void setLookAndFeel(String lookAndFeel)
	{
		setLookAndFeel(lookAndFeel, null, null, null, null, null);
	}
	
	public static void setLookAndFeel(String lookAndFeel, String style, String buttonUI, String menuButtonUI, String splitButtonUI, String buttonStyle)
	{
		try
		{
			UIManager.setLookAndFeel(lookAndFeel);
		}
		catch (Exception e)
		{
			setSystemLookAndFeel();
		}
		
		setStyle(style);
		setFont();
		setButtonUI(buttonUI, menuButtonUI, splitButtonUI, buttonStyle);
	}
	
	public static void invokeLookAndFeel(String lookAndFeel)
	{
		try
		{
			Class.forName("com.nepxion.swing.lookandfeel.LookAndFeelManager").getMethod("set" + lookAndFeel, null).invoke(null, null);
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (SecurityException e)
		{
			e.printStackTrace();
		}
		catch (NoSuchMethodException e)
		{
			e.printStackTrace();
		}
		catch (InvocationTargetException e)
		{
			e.printStackTrace();
		}
		catch (IllegalArgumentException e)
		{
			e.printStackTrace();
		}
		catch (IllegalAccessException e)
		{
			e.printStackTrace();
		}
	}
	
	public static boolean isNimbusLookAndFeel()
	{
		return UIManager.getLookAndFeel().getID().equals("Nimbus");
	}
	
	public static void addonMetalLookAndFeel()
	{
		try
		{
			LookAndFeelAddons.setAddon(MetalLookAndFeelAddons.class);
		}
		catch (IllegalAccessException e)
		{
			e.printStackTrace();
		}
		catch (InstantiationException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void addonWindowsLookAndFeel()
	{
		try
		{
			LookAndFeelAddons.setAddon(WindowsClassicLookAndFeelAddons.class);
		}
		catch (IllegalAccessException e)
		{
			e.printStackTrace();
		}
		catch (InstantiationException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void addonLunaLookAndFeel()
	{
		try
		{
			UIManager.put("win.xpstyle.name", "luna");
			LookAndFeelAddons.setAddon(WindowsLookAndFeelAddons.class);
		}
		catch (IllegalAccessException e)
		{
			e.printStackTrace();
		}
		catch (InstantiationException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void addonHomesteadLookAndFeel()
	{
		try
		{
			UIManager.put("win.xpstyle.name", "homestead");
			LookAndFeelAddons.setAddon(WindowsLookAndFeelAddons.class);
		}
		catch (IllegalAccessException e)
		{
			e.printStackTrace();
		}
		catch (InstantiationException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void addonMetallicLookAndFeel()
	{
		try
		{
			UIManager.put("win.xpstyle.name", "metallic");
			LookAndFeelAddons.setAddon(WindowsLookAndFeelAddons.class);
		}
		catch (IllegalAccessException e)
		{
			e.printStackTrace();
		}
		catch (InstantiationException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void addonGlossyLookAndFeel()
	{
		try
		{
			LookAndFeelAddons.setAddon(AquaLookAndFeelAddons.class);
		}
		catch (IllegalAccessException e)
		{
			e.printStackTrace();
		}
		catch (InstantiationException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void setStyle(String styleClass)
	{
		if (!StyleContext.setPriorityContext())
		{
			StyleManager.setStyle(styleClass);
		}
		
		StyleManager.setThemeDecorated(StyleContext.isThemeDecorated());
		
		if (StyleContext.isFrameDecorated())
		{
			StyleManager.setFrameDecorated(StyleContext.isFrameDecorated());
		}
		
		if (StyleContext.isDialogDecorated())
		{
			StyleManager.setDialogDecorated(StyleContext.isDialogDecorated());
		}
	}
	
	public static void setButtonUI(String buttonUIClass, String menuButtonUIClass, String splitButtonUIClass, String buttonStyleClass)
	{
		if (!ButtonContext.setPriorityContext())
		{
			ButtonManager.setUI(buttonUIClass, menuButtonUIClass, splitButtonUIClass, buttonStyleClass);
		}
	}
	
	public static void setFont()
	{
		FontManager.setFont(FontContext.getFont());
	}
}