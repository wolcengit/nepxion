package com.nepxion.swing.shrinkbar;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.awt.Color;
import java.awt.TexturePaint;

import javax.swing.ImageIcon;

import com.nepxion.swing.gradient.JGradientPainter;
import com.nepxion.swing.icon.IconFactory;

public interface ShrinkContants
{
	public static final int PLACEMENT_EAST = 0;
	public static final int PLACEMENT_WEST = 1;
	
	public static final int CONTENT_PANE_TYPE_LABEL = 2;
	public static final int CONTENT_PANE_TYPE_TOOLBAR = 3;
	
	public static final ImageIcon HEADER_BACKGROUND_IMAGE_ICON = IconFactory.getSwingIcon("skin/header_background.png");
	public static final ImageIcon HEADER_BACKGROUND_LEFT_IMAGE_ICON = IconFactory.getSwingIcon("skin/header_background_left.png");
	public static final ImageIcon HEADER_BACKGROUND_RIGHT_IMAGE_ICON = IconFactory.getSwingIcon("skin/header_background_right.png");
	
	public static final ImageIcon HEADER_SHRINK_HANDLER_LEFT_IMAGE_ICON = IconFactory.getSwingIcon("skin/shrink_handler_left.png");
	public static final ImageIcon HEADER_SHRINK_HANDLER_RIGHT_IMAGE_ICON = IconFactory.getSwingIcon("skin/shrink_handler_right.png");
	public static final ImageIcon HEADER_RESIZE_HANDLER_IMAGE_ICON = IconFactory.getSwingIcon("skin/resize_handler.png");
	
	public static final TexturePaint HEADER_TEXTURE_PAINT = JGradientPainter.createTexturePaint(HEADER_BACKGROUND_IMAGE_ICON.getImage());
	
	public static final Color TITLE_COLOR = new Color(215, 215, 216);
	public static final Color SPLIT_COLOR = new Color(76, 84, 91);
	
	public static final int SHRINKED_WIDTH = 37;
}