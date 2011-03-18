package com.nepxion.swing.font;

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
import java.io.InputStream;
import java.util.Enumeration;

import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

import com.nepxion.util.io.FileUtil;

public class FontManager
{
	public static final String SWING_FONT_FOLDER = "com/nepxion/swing/font/";
	
	public static void setCustomFont(String fontFileName, int fontStyle, int fontSize)
	{
		setCustomFont(fontFileName, fontStyle, fontSize, true);
	}
	
	public static void setCustomFont(String fontFileName, int fontStyle, int fontSize, boolean classLoader)
	{
		Font font = null;
		String fontPath = SWING_FONT_FOLDER + fontFileName;
		try
		{
			InputStream inputStream = FileUtil.getInputStream(fontPath, classLoader);
			font = Font.createFont(Font.TRUETYPE_FONT, inputStream);
			font = font.deriveFont(fontStyle, fontSize);
			inputStream.close();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			font = FontContext.getFont();
		}
		
		setFont(font);
	}
	
	public static void setFont(String fontName, int fontStyle, int fontSize)
	{
		Font font = new Font(fontName, fontStyle, fontSize);

		setFont(font);
	}
		
	public static void setFont(Font font)
	{		
		FontUIResource fontUIResource = new FontUIResource(font);
		for (Enumeration enumeration = UIManager.getDefaults().keys(); enumeration.hasMoreElements();)
		{
			Object key = enumeration.nextElement();
			Object value = UIManager.get(key);
			if (value instanceof FontUIResource)
			{
				UIManager.getDefaults().remove(key);
				UIManager.getDefaults().put(key, fontUIResource);
			}
		}
	}
}