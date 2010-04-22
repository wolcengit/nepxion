package com.nepxion.demo.component.selector;

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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.nepxion.swing.border.ComplexEtchedBorder;
import com.nepxion.swing.border.ComplexSide;
import com.nepxion.swing.border.ComplexTitleBorder;
import com.nepxion.swing.button.ButtonManager;
import com.nepxion.swing.button.JFlatButton;
import com.nepxion.swing.handle.HandleManager;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.layout.filed.FiledLayout;
import com.nepxion.swing.selector.locale.JLocaleSelectorDialog;
import com.nepxion.swing.selector.locale.JLocaleSelectorOptionPane;
import com.nepxion.swing.selector.locale.JLocaleSelectorPopupMenu;
import com.nepxion.swing.textfield.JBasicTextField;

public class DemoLocaleSelectorPanel
	extends JPanel
{
	private SelectorValuePanel selectorValuePanel;
	
	public DemoLocaleSelectorPanel()
	{
		setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 0));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		selectorValuePanel = new SelectorValuePanel();
		
		add(new LocaleSelectorPanel());
		add(selectorValuePanel);
	}
	
	public class LocaleSelectorPanel
		extends JPanel
	{
		public LocaleSelectorPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(new ComplexTitleBorder(new ComplexEtchedBorder(ComplexEtchedBorder.LOWERED, ComplexSide.NORTH), "Locale Selector"));
			
			JFlatButton dialogStyleButton = createDialogStyleButton();
			dialogStyleButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					final JLocaleSelectorDialog dialog = new JLocaleSelectorDialog(HandleManager.getFrame(DemoLocaleSelectorPanel.this))
					{
						public boolean confirm()
						{
							Locale locale = getLocaleSelector().getLocale();
							if (locale == null)
							{
								return false;
							}
							selectorValuePanel.setValue(locale.toString());
							return true;
						}
						
						public boolean cancel()
						{
							return true;
						}
					};
					
					dialog.setVisible(true);
				}
			}
			);
			add(dialogStyleButton);
			
			JFlatButton optionPaneStyleButton = createOptionPaneStyleButton();
			optionPaneStyleButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					JLocaleSelectorOptionPane optionPane = new JLocaleSelectorOptionPane(HandleManager.getFrame(DemoLocaleSelectorPanel.this));
					int selectedValue = optionPane.showLocaleDialog();
					if (selectedValue == JLocaleSelectorOptionPane.OK_OPTION)
					{
						Locale locale = optionPane.getLocaleSelector().getLocale();
						if (locale == null)
						{
							return;
						}
						selectorValuePanel.setValue(locale.toString());
					}
				}
			}
			);
			add(optionPaneStyleButton);
			
			JFlatButton popupMenuStyleButton = createPopupMenuStyleButton();
			JLocaleSelectorPopupMenu popupMenu = new JLocaleSelectorPopupMenu(popupMenuStyleButton)
			{
				public boolean confirm()
				{
					Locale locale = getLocaleSelector().getLocale();
					if (locale == null)
					{
						return false;
					}
					selectorValuePanel.setValue(locale.toString());
					return true;
				}
				
				public boolean cancel()
				{
					return true;
				}
			};
			add(popupMenuStyleButton);
			
			ButtonManager.updateUI(this);
		}
	}
	
	private JFlatButton createDialogStyleButton()
	{
		JFlatButton button = new JFlatButton("Dialog Style", IconFactory.getSwingIcon("component/dialog_16.png"));
		button.setDimension(new Dimension(95, 30));
		return button;
	}
	
	private JFlatButton createOptionPaneStyleButton()
	{
		JFlatButton button = new JFlatButton("OptionPane Style", IconFactory.getSwingIcon("component/option_pane_16.png"));
		button.setDimension(new Dimension(125, 30));
		return button;
	}
	
	private JFlatButton createPopupMenuStyleButton()
	{
		JFlatButton button = new JFlatButton("PopupMenu Style", IconFactory.getSwingIcon("component/popup_menu_16.png"));
		button.setDimension(new Dimension(125, 30));	
		return button;
	}	
	
	public class SelectorValuePanel
		extends JPanel
	{
		private JBasicTextField textField;
		
		public SelectorValuePanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(new ComplexTitleBorder(new ComplexEtchedBorder(ComplexEtchedBorder.LOWERED, ComplexSide.NORTH), "Selection Value"));
			
			textField = new JBasicTextField();
			textField.setOpaque(false);
			textField.setPreferredSize(new Dimension(225, textField.getPreferredSize().height));
			textField.setMaximumSize(new Dimension(225, textField.getPreferredSize().height));
			textField.setMinimumSize(new Dimension(225, textField.getPreferredSize().height));
			textField.setSize(new Dimension(225, textField.getPreferredSize().height));
			
			add(new JLabel("Your Selection Value"));
			add(textField);
		}
		
		public void setValue(String value)
		{
			textField.setText(value);
		}
	}
}