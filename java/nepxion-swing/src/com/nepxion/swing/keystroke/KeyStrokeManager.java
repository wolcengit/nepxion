package com.nepxion.swing.keystroke;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractButton;
import javax.swing.JComponent;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import com.nepxion.swing.button.ButtonAncestorListener;

public class KeyStrokeManager
{
	public static void registerComponent(JComponent component, ActionListener actionListener, int keyCode)
	{
		registerComponent(component, actionListener, keyCode, 0);
	}
	
	public static void registerComponent(JComponent component, ActionListener actionListener, int keyCode, int modifiers)
	{
		KeyStroke keyStroke = KeyStroke.getKeyStroke(keyCode, modifiers);
		registerComponent(component, actionListener, keyStroke);
	}
	
	public static void registerComponent(JComponent component, ActionListener actionListener, KeyStroke keyStroke)
	{
		component.registerKeyboardAction(actionListener, keyStroke, JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
	}
	
	public static void registerComponentToEnterKey(JComponent component, ActionListener actionListener)
	{
		registerComponent(component, actionListener, KeyEvent.VK_ENTER, 0);
	}
	
	public static void registerComponentToEscapeKey(JComponent component, ActionListener actionListener)
	{
		registerComponent(component, actionListener, KeyEvent.VK_ESCAPE, 0);
	}	
	
	public static void registerButton(AbstractButton button, int keyCode)
	{
		registerButton(button, button.getAction(), keyCode);
	}
	
	public static void registerButton(AbstractButton button, ActionListener actionListener, int keyCode)
	{
		registerButton(button, actionListener, keyCode, 0);
	}	
	
	public static void registerButton(AbstractButton button, int keyCode, int modifiers)
	{
		registerButton(button, button.getAction(), keyCode, modifiers);
	}
	
	public static void registerButton(AbstractButton button, ActionListener actionListener, int keyCode, int modifiers)
	{
		KeyStroke keyStroke = KeyStroke.getKeyStroke(keyCode, modifiers);
		registerButton(button, actionListener, keyStroke);
	}
	
	public static void registerButton(AbstractButton button, KeyStroke keyStroke)
	{
		registerButton(button, button.getAction(), keyStroke);
	}
	
	public static void registerButton(AbstractButton button, ActionListener actionListener, KeyStroke keyStroke)
	{
		if (button instanceof JMenuItem)
		{
			JMenuItem menuItem = (JMenuItem) button;
			menuItem.setAccelerator(keyStroke);
		}
		else
		{
			button.registerKeyboardAction(actionListener, keyStroke, JComponent.WHEN_IN_FOCUSED_WINDOW);
		}
	}
	
	public static void registerButton(AbstractButton button, int keyCode, char mnemonic)
	{
		registerButton(button, button.getAction(), keyCode, mnemonic);
	}
	
	public static void registerButton(AbstractButton button, ActionListener actionListener, int keyCode, char mnemonic)
	{
		registerButton(button, actionListener, keyCode, 0, mnemonic);
	}	
	
	public static void registerButton(AbstractButton button, int keyCode, int modifiers, char mnemonic)
	{
		registerButton(button, button.getAction(), keyCode, modifiers, mnemonic);
	}
	
	public static void registerButton(AbstractButton button, ActionListener actionListener, int keyCode, int modifiers, char mnemonic)
	{
		KeyStroke keyStroke = KeyStroke.getKeyStroke(keyCode, modifiers);
		registerButton(button, actionListener, keyStroke, mnemonic);
	}
	
	public static void registerButton(AbstractButton button, KeyStroke keyStroke, char mnemonic)
	{
		registerButton(button, button.getAction(), keyStroke, mnemonic);
	}
	
	public static void registerButton(AbstractButton button, ActionListener actionListener, KeyStroke keyStroke, char mnemonic)
	{	
		registerButton(button, actionListener, keyStroke);
		button.setMnemonic(mnemonic);
	}
	
	public static void registerButtonToEnterKey(AbstractButton button)
	{
		registerButtonToEnterKey(button, button.getAction());
	}	
	
	public static void registerButtonToEnterKey(AbstractButton button, ActionListener actionListener)
	{
		registerButton(button, actionListener, KeyEvent.VK_ENTER, 0, 'E');
		button.addAncestorListener(new ButtonAncestorListener());
	}
	
	public static void registerButtonToEscapeKey(AbstractButton button)
	{
		registerButtonToEscapeKey(button, button.getAction());
	}
	
	public static void registerButtonToEscapeKey(AbstractButton button, ActionListener actionListener)
	{
		registerButton(button, actionListener, KeyEvent.VK_ESCAPE, 0, 'C');
	}
}