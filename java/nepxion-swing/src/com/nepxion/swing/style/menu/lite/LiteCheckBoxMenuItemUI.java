package com.nepxion.swing.style.menu.lite;

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

import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.icon.paint.CheckBoxIcon;
import com.nepxion.swing.style.button.IButtonStyle;
import com.nepxion.swing.style.button.IButtonUI;
import com.nepxion.swing.style.button.lite.ILiteButtonStyle;
import com.nepxion.swing.style.menu.AbstractCheckBoxMenuItemUI;

public class LiteCheckBoxMenuItemUI
	extends AbstractCheckBoxMenuItemUI implements IButtonUI
{
	public static final String PLASTIC_STYLE = "theme/checkbox/plastic/";
	public static final String NIMBUS_STYLE = "theme/checkbox/nimbus/";
	
	protected ILiteButtonStyle buttonStyle;
	
	public LiteCheckBoxMenuItemUI(IButtonStyle buttonStyle)
	{
		setButtonStyle(buttonStyle);
	}
	
	public IButtonStyle getButtonStyle()
	{
		return buttonStyle;
	}
	
	public void setButtonStyle(IButtonStyle buttonStyle)
	{
		this.buttonStyle = (ILiteButtonStyle) buttonStyle;
		
		armedIcon = new CheckBoxIcon(IconFactory.getSwingIcon(PLASTIC_STYLE + "checkbox_lower.png"), this.buttonStyle.getCheckColor(), this.buttonStyle.getFocusColor(), false, true);
		pressedIcon = new CheckBoxIcon(IconFactory.getSwingIcon(PLASTIC_STYLE + "checkbox_lower.png"), this.buttonStyle.getCheckColor(), this.buttonStyle.getFocusColor(), false, true);
		rolloverIcon = new CheckBoxIcon(IconFactory.getSwingIcon(PLASTIC_STYLE + "checkbox_raised.png"), this.buttonStyle.getCheckColor(), this.buttonStyle.getFocusColor(), false, true);
		disableIcon = new CheckBoxIcon(IconFactory.getSwingIcon(PLASTIC_STYLE + "checkbox_disable.png"), new Color(128, 128, 128), null, false, false);
		normalIcon = new CheckBoxIcon(IconFactory.getSwingIcon(PLASTIC_STYLE + "checkbox_raised.png"), this.buttonStyle.getCheckColor(), this.buttonStyle.getFocusColor(), false, false);
		
		selectionArmedIcon = new CheckBoxIcon(IconFactory.getSwingIcon(PLASTIC_STYLE + "checkbox_lower.png"), this.buttonStyle.getCheckColor(), this.buttonStyle.getFocusColor(), true, true);
		selectionPressedIcon = new CheckBoxIcon(IconFactory.getSwingIcon(PLASTIC_STYLE + "checkbox_lower.png"), this.buttonStyle.getCheckColor(), this.buttonStyle.getFocusColor(), true, true);
		selectionRolloverIcon = new CheckBoxIcon(IconFactory.getSwingIcon(PLASTIC_STYLE + "checkbox_raised.png"), this.buttonStyle.getCheckColor(), this.buttonStyle.getFocusColor(), true, true);
		selectionDisableIcon = new CheckBoxIcon(IconFactory.getSwingIcon(PLASTIC_STYLE + "checkbox_disable.png"), new Color(128, 128, 128), null, true, false);
		selectionNormalIcon = new CheckBoxIcon(IconFactory.getSwingIcon(PLASTIC_STYLE + "checkbox_raised.png"), this.buttonStyle.getCheckColor(), this.buttonStyle.getFocusColor(), true, false);
	}
}