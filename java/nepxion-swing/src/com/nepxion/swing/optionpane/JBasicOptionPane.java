package com.nepxion.swing.optionpane;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.awt.Component;
import java.awt.Container;
import java.awt.HeadlessException;
import java.util.Locale;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import com.nepxion.swing.button.ButtonFocusListener;
import com.nepxion.swing.dialog.DialogResizer;
import com.nepxion.swing.locale.SwingLocale;

public class JBasicOptionPane
	extends JOptionPane
{
	public JBasicOptionPane()
	{
		super();
	}
	
	public JBasicOptionPane(Object message)
	{
		super(message);
	}
	
	public JBasicOptionPane(Object message, int messageType)
	{
		super(message, messageType);
	}
	
	public JBasicOptionPane(Object message, int messageType, int optionType)
	{
		super(message, messageType, optionType);
	}
	
	public JBasicOptionPane(Object message, int messageType, int optionType, Icon icon)
	{
		super(message, messageType, optionType, icon);
	}
	
	public JBasicOptionPane(Object message, int messageType, int optionType, Icon icon, Object[] options)
	{
		super(message, messageType, optionType, icon, options);
	}
	
	public JBasicOptionPane(Object message, int messageType, int optionType, Icon icon, Object[] options, Object initialValue)
	{
		super(message, messageType, optionType, icon, options, initialValue);
	}
	
	public static int showDialog(Component parentComponent, Object message, String title)
	{
		return showDialog(parentComponent, message, title, null);
	}
	
	public static int showDialog(Component parentComponent, Object message, String title, Icon icon)
	{
		return showDialog(parentComponent, message, title, icon, false);
	}
	
	public static int showDialog(Component parentComponent, Object message, String title, boolean isResizable)
	{
		return showDialog(parentComponent, message, title, null, isResizable);
	}
	
	public static int showDialog(Component parentComponent, Object message, String title, Icon icon, boolean isResizable)
	{
		return showDialog(parentComponent, message, title, icon, new Object[] {SwingLocale.getString("yes"), SwingLocale.getString("no")}, isResizable);
	}
	
	public static int showDialog(Component parentComponent, Object message, String title, Icon icon, Object[] options)
	{
		return showDialog(parentComponent, message, title, icon, options, false);
	}
	
	public static int showDialog(Component parentComponent, Object message, String title, Icon icon, Object[] options, boolean isResizable)
	{
		return showDialog(parentComponent, message, title, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, null, isResizable);
	}
	
	public static int showDialog(Component parentComponent, Object message, String title, int optionType, int messageType, Icon icon, Object[] options, Object initialValue, boolean isResizable)
	{
		int selectedValue = showOptionDialog(parentComponent, message, title, optionType, messageType, icon, options, initialValue, isResizable);
		return showDialog(selectedValue, parentComponent, message, title, optionType, messageType, icon, options, initialValue, isResizable);
	}
	
	private static int showDialog(int selectedValue, Component parentComponent, Object message, String title, int optionType, int messageType, Icon icon, Object[] options, Object initialValue, boolean isResizable)
	{
		if (selectedValue != JOptionPane.YES_OPTION)
		{
			return selectedValue;
		}
		if (message instanceof IValidation)
		{
			IValidation validation = (IValidation) message;
			if (!validation.verify())
			{
				selectedValue = showOptionDialog(parentComponent, message, title, optionType, messageType, icon, options, initialValue, isResizable);
				return showDialog(selectedValue, parentComponent, message, title, optionType, messageType, icon, options, initialValue, isResizable);
			}
		}
		return selectedValue;
	}
	
	public static int showOptionDialog(Component parentComponent, Object message, String title, int optionType, int messageType, Icon icon, Object[] options, Object initialValue, boolean isResizable)
		throws HeadlessException
	{
		JBasicOptionPane pane = new JBasicOptionPane(message, messageType, optionType, icon, options, initialValue);
		
		pane.setInitialValue(initialValue);
		pane.setComponentOrientation(((parentComponent == null) ? getRootFrame() : parentComponent).getComponentOrientation());
		
		JDialog dialog = pane.createDialog(parentComponent, title, isResizable);
		
		pane.selectInitialValue();
		dialog.show();
		dialog.dispose();
		
		Object selectedValue = pane.getValue();
		
		if (selectedValue == null)
		{
			return CLOSED_OPTION;
		}
		if (options == null)
		{
			if (selectedValue instanceof Integer)
			{
				return ((Integer) selectedValue).intValue();
			}
			return CLOSED_OPTION;
		}
		for (int counter = 0, maxCounter = options.length; counter < maxCounter; counter++)
		{
			if (options[counter].equals(selectedValue))
			{
				return counter;
			}
		}
		return CLOSED_OPTION;
	}
	
	public static String showInputDialog(Object message)
		throws HeadlessException
	{
		return showInputDialog(null, message);
	}
	
	public static String showInputDialog(Object message, Object initialSelectionValue)
	{
		return showInputDialog(null, message, initialSelectionValue);
	}
	
	public static String showInputDialog(Component parentComponent, Object message)
		throws HeadlessException
	{
		return showInputDialog(parentComponent, message, getString("OptionPane.inputDialogTitle", parentComponent), QUESTION_MESSAGE);
	}
	
	public static String showInputDialog(Component parentComponent, Object message, Object initialSelectionValue)
	{
		return (String) showInputDialog(parentComponent, message, getString("OptionPane.inputDialogTitle", parentComponent), QUESTION_MESSAGE, null, null, initialSelectionValue);
	}
	
	public static String showInputDialog(Component parentComponent, Object message, String title, int messageType)
		throws HeadlessException
	{
		return (String) showInputDialog(parentComponent, message, title, messageType, null, null, null);
	}
	
	public static Object showInputDialog(Component parentComponent, Object message, String title, int messageType, Icon icon, Object[] selectionValues, Object initialSelectionValue)
		throws HeadlessException
	{
		return (String) showInputDialog(parentComponent, message, title, messageType, icon, selectionValues, initialSelectionValue, false);
	}
	
	public static Object showInputDialog(Component parentComponent, Object message, String title, int messageType, Icon icon, Object[] selectionValues, Object initialSelectionValue, boolean isResizable)
		throws HeadlessException
	{
		JBasicOptionPane pane = new JBasicOptionPane(message, messageType, OK_CANCEL_OPTION, icon, null, null);
		
		pane.setWantsInput(true);
		pane.setSelectionValues(selectionValues);
		pane.setInitialSelectionValue(initialSelectionValue);
		pane.setComponentOrientation(((parentComponent == null) ? getRootFrame() : parentComponent).getComponentOrientation());
		
		JDialog dialog = pane.createDialog(parentComponent, title, isResizable);
		
		pane.selectInitialValue();
		dialog.show();
		dialog.dispose();
		
		Object value = pane.getInputValue();
		
		if (value == UNINITIALIZED_VALUE)
		{
			return null;
		}
		return value;
	}
	
	public static void showMessageDialog(Component parentComponent, Object message)
		throws HeadlessException
	{
		showMessageDialog(parentComponent, message, getString("OptionPane.messageDialogTitle", parentComponent), INFORMATION_MESSAGE);
	}
	
	public static void showMessageDialog(Component parentComponent, Object message, String title, int messageType)
		throws HeadlessException
	{
		showMessageDialog(parentComponent, message, title, messageType, null);
	}
	
	public static void showMessageDialog(Component parentComponent, Object message, String title, int messageType, Icon icon)
		throws HeadlessException
	{
		showOptionDialog(parentComponent, message, title, DEFAULT_OPTION, messageType, icon, null, null, false);
	}
	
	public static int showConfirmDialog(Component parentComponent, Object message)
		throws HeadlessException
	{
		return showConfirmDialog(parentComponent, message, UIManager.getString("OptionPane.titleText"), YES_NO_CANCEL_OPTION);
	}
	
	public static int showConfirmDialog(Component parentComponent, Object message, String title, int optionType)
		throws HeadlessException
	{
		return showConfirmDialog(parentComponent, message, title, optionType, QUESTION_MESSAGE);
	}
	
	public static int showConfirmDialog(Component parentComponent, Object message, String title, int optionType, int messageType)
		throws HeadlessException
	{
		return showConfirmDialog(parentComponent, message, title, optionType, messageType, null);
	}
	
	public static int showConfirmDialog(Component parentComponent, Object message, String title, int optionType, int messageType, Icon icon)
		throws HeadlessException
	{
		return showOptionDialog(parentComponent, message, title, optionType, messageType, icon, null, null, false);
	}
	
	public JDialog createDialog(Component parentComponent, String title, boolean isResizable)
		throws HeadlessException
	{
		JDialog dialog = createDialog(parentComponent, title);
		/*dialog.setResizable(true);
		if (isResizable)
		{
			dialog.addComponentListener(new ComponentSizeAdapter(dialog.getSize(), dialog.getSize(), null));
		}
		else
		{
			dialog.addComponentListener(new ComponentSizeAdapter(dialog.getSize()));
		}*/
		
		if (isResizable)
		{
			dialog.setResizable(true);
			dialog.addComponentListener(new DialogResizer(dialog.getSize(), dialog.getSize(), null));
		}
		
		Container container = (Container) getComponent(getComponentCount() - 1);
		for (int i = 0; i < container.getComponentCount(); i++)
		{
			Component component = container.getComponent(i);
			if (component instanceof JButton)
			{
				JButton button = (JButton) component;
				button.addFocusListener(new ButtonFocusListener(this));
			}
		}
		return dialog;
	}
	
	public static String getString(Object key, Component c)
	{
		Locale l = (c == null) ? Locale.getDefault() : c.getLocale();
		return UIManager.getString(key, l);
	}
}