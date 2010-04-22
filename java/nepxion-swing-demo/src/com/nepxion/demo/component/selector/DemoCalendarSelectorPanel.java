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
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;

import com.nepxion.swing.border.ComplexEtchedBorder;
import com.nepxion.swing.border.ComplexSide;
import com.nepxion.swing.border.ComplexTitleBorder;
import com.nepxion.swing.button.ButtonManager;
import com.nepxion.swing.button.JFlatButton;
import com.nepxion.swing.button.JFlatMenuButton;
import com.nepxion.swing.handle.HandleManager;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.layout.filed.FiledLayout;
import com.nepxion.swing.popupmenu.JDecorationPopupMenu;
import com.nepxion.swing.selector.calendar.JCalendarSelectorDialog;
import com.nepxion.swing.selector.calendar.JCalendarSelectorOptionPane;
import com.nepxion.swing.selector.calendar.JCalendarSelectorPopupMenu;
import com.nepxion.swing.selector.calendar.JDateSelectorDialog;
import com.nepxion.swing.selector.calendar.JDateSelectorOptionPane;
import com.nepxion.swing.selector.calendar.JDateSelectorPopupMenu;
import com.nepxion.swing.selector.calendar.JDateTimeSelectorDialog;
import com.nepxion.swing.selector.calendar.JDateTimeSelectorOptionPane;
import com.nepxion.swing.selector.calendar.JDateTimeSelectorPopupMenu;
import com.nepxion.swing.selector.calendar.JDaySelectorDialog;
import com.nepxion.swing.selector.calendar.JDaySelectorOptionPane;
import com.nepxion.swing.selector.calendar.JDaySelectorPopupMenu;
import com.nepxion.swing.selector.calendar.JMonthSelectorDialog;
import com.nepxion.swing.selector.calendar.JMonthSelectorOptionPane;
import com.nepxion.swing.selector.calendar.JMonthSelectorPopupMenu;
import com.nepxion.swing.selector.calendar.JTimeSelectorDialog;
import com.nepxion.swing.selector.calendar.JTimeSelectorOptionPane;
import com.nepxion.swing.selector.calendar.JTimeSelectorPopupMenu;
import com.nepxion.swing.selector.calendar.JYearSelectorDialog;
import com.nepxion.swing.selector.calendar.JYearSelectorOptionPane;
import com.nepxion.swing.selector.calendar.JYearSelectorPopupMenu;
import com.nepxion.swing.textfield.JBasicTextField;

public class DemoCalendarSelectorPanel
	extends JPanel
{
	private SelectorValuePanel selectorValuePanel;
	
	public DemoCalendarSelectorPanel()
	{
		setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 0));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		selectorValuePanel = new SelectorValuePanel();
		
		add(new CalendarSelectorPanel());
		add(new DateTimeSelectorPanel());
		add(new DateSelectorPanel());
		add(new YearSelectorPanel());
		add(new MonthSelectorPanel());
		add(new DaySelectorPanel());
		add(new TimeSelectorPanel());
		add(selectorValuePanel);
	}
	
	public class CalendarSelectorPanel
		extends JPanel
	{
		public CalendarSelectorPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(new ComplexTitleBorder(new ComplexEtchedBorder(ComplexEtchedBorder.LOWERED, ComplexSide.NORTH), "Calendar Selector"));
						
			JFlatButton dialogStyleButton = createDialogStyleButton();
			dialogStyleButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{					
					final JCalendarSelectorDialog dialog = new JCalendarSelectorDialog(HandleManager.getFrame(DemoCalendarSelectorPanel.this))
					{
						public boolean confirm()
						{
							Date date = getCalendarSelector().getDate();
							if (date == null)
							{
								return false;
							}	
							selectorValuePanel.setValue(date.toString());
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
					JCalendarSelectorOptionPane optionPane = new JCalendarSelectorOptionPane(HandleManager.getFrame(DemoCalendarSelectorPanel.this));
					int selectedValue = optionPane.showCalendarDialog();
					if (selectedValue == JCalendarSelectorOptionPane.OK_OPTION)
					{
						Date date = optionPane.getCalendarSelector().getDate();
						if (date == null)
						{
							return;
						}	
						selectorValuePanel.setValue(date.toString());
					}
				}
			}
			);			
			add(optionPaneStyleButton);
			
			JFlatButton popupMenuStyleButton = createPopupMenuStyleButton();	
			JCalendarSelectorPopupMenu popupMenu = new JCalendarSelectorPopupMenu(popupMenuStyleButton)
			{
				public boolean confirm()
				{
					Date date = getCalendarSelector().getDate();
					if (date == null)
					{
						return false;
					}	
					selectorValuePanel.setValue(date.toString());
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
	
	public class DateTimeSelectorPanel
		extends FormatPanel
	{		
		public DateTimeSelectorPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(new ComplexTitleBorder(new ComplexEtchedBorder(ComplexEtchedBorder.LOWERED, ComplexSide.NORTH), "Date Time Selector"));
			
			JFlatButton dialogStyleButton = createDialogStyleButton();
			dialogStyleButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					final JDateTimeSelectorDialog dialog = new JDateTimeSelectorDialog(HandleManager.getFrame(DemoCalendarSelectorPanel.this))
					{
						public boolean confirm()
						{
							Date date = getDateTimeSelector().getDate();
							if (date == null)
							{
								return false;
							}
							selectorValuePanel.setValue(date.toString());
							return true;
						}
						
						public boolean cancel()
						{
							return true;
						}
					};
					dialog.getDateTimeSelector().setFormat(getDateFormat(), getTimeFormat());
					
					dialog.setVisible(true);
				}
			});
			add(dialogStyleButton);
			
			JFlatButton optionPaneStyleButton = createOptionPaneStyleButton();
			optionPaneStyleButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					JDateTimeSelectorOptionPane optionPane = new JDateTimeSelectorOptionPane(HandleManager.getFrame(DemoCalendarSelectorPanel.this));
					optionPane.getDateTimeSelector().setFormat(getDateFormat(), getTimeFormat());
					int selectedValue = optionPane.showDateDialog();					
					if (selectedValue == JCalendarSelectorOptionPane.OK_OPTION)
					{
						Date date = optionPane.getDateTimeSelector().getDate();
						if (date == null)
						{
							return;
						}	
						selectorValuePanel.setValue(date.toString());
					}
				}
			}
			);			
			add(optionPaneStyleButton);
			
			JFlatButton popupMenuStyleButton = createPopupMenuStyleButton();	
			final JDateTimeSelectorPopupMenu popupMenu = new JDateTimeSelectorPopupMenu(popupMenuStyleButton)
			{
				public boolean confirm()
				{					
					Date date = getDateTimeSelector().getDate();
					if (date == null)
					{
						return false;
					}	
					selectorValuePanel.setValue(date.toString());
					return true;
				}
				
				public boolean cancel()
				{
					return true;
				}	
				
				public void showPopupMenu()
				{
					super.showPopupMenu();
					getDateTimeSelector().setFormat(getDateFormat(), getTimeFormat());
				}				
			};			
			add(popupMenuStyleButton);				
			
			JFlatMenuButton dateFormatButton = createFormatButton(this, new String[] {"yyyy-MM-dd", "MM/dd/yyyy", "MMMMM d, yyyy", }, true);
			add(dateFormatButton);
			
			JFlatMenuButton timeFormatButton = createFormatButton(this, new String[] {"HH:mm:ss",  "HH:mm:ss:SSS", "hh:mm:ss a", "hh:mm:ss:SSS a"}, false);
			add(timeFormatButton);			
			
			ButtonManager.updateUI(this);
		}
	}	
	
	public class DateSelectorPanel
		extends FormatPanel
	{		
		public DateSelectorPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(new ComplexTitleBorder(new ComplexEtchedBorder(ComplexEtchedBorder.LOWERED, ComplexSide.NORTH), "Date Selector"));
		
			JFlatButton dialogStyleButton = createDialogStyleButton();
			dialogStyleButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{					
					final JDateSelectorDialog dialog = new JDateSelectorDialog(HandleManager.getFrame(DemoCalendarSelectorPanel.this))
					{						
						public boolean confirm()
						{													
							Date date = getDateSelector().getDate();
							if (date == null)
							{
								return false;
							}	
							selectorValuePanel.setValue(date.toString());
							return true;
						}
						
						public boolean cancel()
						{
							return true;
						}						
					};
					dialog.getDateSelector().setFormat(getDateFormat());
					
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
					JDateSelectorOptionPane optionPane = new JDateSelectorOptionPane(HandleManager.getFrame(DemoCalendarSelectorPanel.this));
					optionPane.getDateSelector().setFormat(getDateFormat());
					int selectedValue = optionPane.showDateDialog();					
					if (selectedValue == JCalendarSelectorOptionPane.OK_OPTION)
					{
						Date date = optionPane.getDateSelector().getDate();
						if (date == null)
						{
							return;
						}	
						selectorValuePanel.setValue(date.toString());
					}
				}
			}
			);			
			add(optionPaneStyleButton);
			
			JFlatButton popupMenuStyleButton = createPopupMenuStyleButton();	
			final JDateSelectorPopupMenu popupMenu = new JDateSelectorPopupMenu(popupMenuStyleButton)
			{
				public boolean confirm()
				{					
					Date date = getDateSelector().getDate();
					if (date == null)
					{
						return false;
					}	
					selectorValuePanel.setValue(date.toString());
					return true;
				}
				
				public boolean cancel()
				{
					return true;
				}	
				
				public void showPopupMenu()
				{
					super.showPopupMenu();
					getDateSelector().setFormat(getDateFormat());
				}				
			};			
			add(popupMenuStyleButton);			
			
			JFlatMenuButton dateFormatButton = createFormatButton(this, new String[] {"yyyy-MM-dd", "MM/dd/yyyy", "MMMMM d, yyyy"}, true);
			add(dateFormatButton);
			
			ButtonManager.updateUI(this);			
		}
	}

	public class YearSelectorPanel
		extends JPanel
	{
		public YearSelectorPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(new ComplexTitleBorder(new ComplexEtchedBorder(ComplexEtchedBorder.LOWERED, ComplexSide.NORTH), "Year Selector"));
			
			JFlatButton dialogStyleButton = createDialogStyleButton();
			dialogStyleButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					final JYearSelectorDialog dialog = new JYearSelectorDialog(HandleManager.getFrame(DemoCalendarSelectorPanel.this))
					{
						public boolean confirm()
						{
							int year = getYearSelector().getYear();
							selectorValuePanel.setValue(year + "");
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
					JYearSelectorOptionPane optionPane = new JYearSelectorOptionPane(HandleManager.getFrame(DemoCalendarSelectorPanel.this));
					int selectedValue = optionPane.showYearDialog();
					if (selectedValue == JCalendarSelectorOptionPane.OK_OPTION)
					{
						int year = optionPane.getYearSelector().getYear();
						selectorValuePanel.setValue(year + "");
					}
				}
			}
			);
			add(optionPaneStyleButton);
			
			JFlatButton popupMenuStyleButton = createPopupMenuStyleButton();
			JYearSelectorPopupMenu popupMenu = new JYearSelectorPopupMenu(popupMenuStyleButton)
			{
				public boolean confirm()
				{
					int year = getYearSelector().getYear();
					selectorValuePanel.setValue(year + "");
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
	
	public class MonthSelectorPanel
		extends JPanel
	{
		public MonthSelectorPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(new ComplexTitleBorder(new ComplexEtchedBorder(ComplexEtchedBorder.LOWERED, ComplexSide.NORTH), "Month Selector"));
			
			JFlatButton dialogStyleButton = createDialogStyleButton();
			dialogStyleButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					final JMonthSelectorDialog dialog = new JMonthSelectorDialog(HandleManager.getFrame(DemoCalendarSelectorPanel.this))
					{
						public boolean confirm()
						{
							int month = getMonthSelector().getMonth();
							selectorValuePanel.setValue(month + "");
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
					JMonthSelectorOptionPane optionPane = new JMonthSelectorOptionPane(HandleManager.getFrame(DemoCalendarSelectorPanel.this));
					int selectedValue = optionPane.showMonthDialog();
					if (selectedValue == JCalendarSelectorOptionPane.OK_OPTION)
					{
						int month = optionPane.getMonthSelector().getMonth();
						selectorValuePanel.setValue(month + "");
					}
				}
			}
			);
			add(optionPaneStyleButton);
			
			JFlatButton popupMenuStyleButton = createPopupMenuStyleButton();
			JMonthSelectorPopupMenu popupMenu = new JMonthSelectorPopupMenu(popupMenuStyleButton)
			{
				public boolean confirm()
				{
					int month = getMonthSelector().getMonth();
					selectorValuePanel.setValue(month + "");
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
	
	public class DaySelectorPanel
		extends JPanel
	{
		public DaySelectorPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(new ComplexTitleBorder(new ComplexEtchedBorder(ComplexEtchedBorder.LOWERED, ComplexSide.NORTH), "Day Selector"));
			
			JFlatButton dialogStyleButton = createDialogStyleButton();
			dialogStyleButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					final JDaySelectorDialog dialog = new JDaySelectorDialog(HandleManager.getFrame(DemoCalendarSelectorPanel.this))
					{
						public boolean confirm()
						{
							int day = getDaySelector().getDay();
							selectorValuePanel.setValue(day + "");
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
					JDaySelectorOptionPane optionPane = new JDaySelectorOptionPane(HandleManager.getFrame(DemoCalendarSelectorPanel.this));
					int selectedValue = optionPane.showDayDialog();
					if (selectedValue == JCalendarSelectorOptionPane.OK_OPTION)
					{
						int day = optionPane.getDaySelector().getDay();
						selectorValuePanel.setValue(day + "");
					}
				}
			}
			);
			add(optionPaneStyleButton);
			
			JFlatButton popupMenuStyleButton = createPopupMenuStyleButton();
			JDaySelectorPopupMenu popupMenu = new JDaySelectorPopupMenu(popupMenuStyleButton)
			{
				public boolean confirm()
				{
					int day = getDaySelector().getDay();
					selectorValuePanel.setValue(day + "");
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
	
	public class TimeSelectorPanel
		extends FormatPanel
	{		
		public TimeSelectorPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(new ComplexTitleBorder(new ComplexEtchedBorder(ComplexEtchedBorder.LOWERED, ComplexSide.NORTH), "Time Selector"));
			
			JFlatButton dialogStyleButton = createDialogStyleButton();
			dialogStyleButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					final JTimeSelectorDialog dialog = new JTimeSelectorDialog(HandleManager.getFrame(DemoCalendarSelectorPanel.this))
					{
						public boolean confirm()
						{
							Date time = getTimeSelector().getTime();
							if (time == null)
							{
								return false;
							}	
							selectorValuePanel.setValue(time.toString());
							return true;
						}
						
						public boolean cancel()
						{
							return true;
						}
					};
					dialog.getTimeSelector().setFormat(getDateFormat().equals("Null") ? "" : getDateFormat() + " " + getTimeFormat());
					
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
					JTimeSelectorOptionPane optionPane = new JTimeSelectorOptionPane(HandleManager.getFrame(DemoCalendarSelectorPanel.this));
					optionPane.getTimeSelector().setFormat(getDateFormat().equals("Null") ? "" : getDateFormat() + " " + getTimeFormat());
					int selectedValue = optionPane.showTimeDialog();
					if (selectedValue == JCalendarSelectorOptionPane.OK_OPTION)
					{
						Date time = optionPane.getTimeSelector().getTime();
						if (time == null)
						{
							return;
						}							
						selectorValuePanel.setValue(time.toString());
					}
				}
			}
			);
			add(optionPaneStyleButton);
			
			JFlatButton popupMenuStyleButton = createPopupMenuStyleButton();
			JTimeSelectorPopupMenu popupMenu = new JTimeSelectorPopupMenu(popupMenuStyleButton)
			{
				public boolean confirm()
				{
					Date time = getTimeSelector().getTime();
					if (time == null)
					{
						return false;
					}	
					selectorValuePanel.setValue(time.toString());
					return true;
				}
				
				public boolean cancel()
				{
					return true;
				}
				
				public void showPopupMenu()
				{
					super.showPopupMenu();
					getTimeSelector().setFormat(getDateFormat().equals("Null") ? "" : getDateFormat() + " " + getTimeFormat());
				}					
			};
			add(popupMenuStyleButton);				
			
			JFlatMenuButton dateFormatButton = createFormatButton(this, new String[] {"yyyy-MM-dd", "MM/dd/yyyy", "MMMMM d, yyyy", "Null"}, true);
			add(dateFormatButton);
			
			JFlatMenuButton timeFormatButton = createFormatButton(this, new String[] {"HH:mm:ss",  "HH:mm:ss:SSS", "hh:mm:ss a", "hh:mm:ss:SSS a", "Null"}, false);
			add(timeFormatButton);
			
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
	
	private JFlatMenuButton createFormatButton(final FormatPanel panel, String[] formatList, final boolean isDateFormat)
	{
		JFlatMenuButton button = new JFlatMenuButton(isDateFormat ? "Date Format" : "Time Format", IconFactory.getSwingIcon("component/button_16.png"));
		button.setDimension(new Dimension(112, 30));
		
		JDecorationPopupMenu popupMenu = new JDecorationPopupMenu();
		ButtonGroup buttonGroup = new ButtonGroup();
		for (int i = 0; i < formatList.length; i++)
		{
			final JRadioButtonMenuItem menuItem = new JRadioButtonMenuItem(formatList[i]);
			menuItem.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					if (isDateFormat)
					{	
						panel.setDateFormat(menuItem.getText());
					}
					else
					{
						panel.setTimeFormat(menuItem.getText());
					}	
				}
			}
			);				
			popupMenu.add(menuItem);
			buttonGroup.add(menuItem);
			if (i == 0)
			{
				menuItem.doClick();
			}
		}		
		button.setPopupMenu(popupMenu);	
		return button;
	}
	
	public class FormatPanel
		extends JPanel
	{
		private String dateFormat;
		private String timeFormat;
		
		public FormatPanel()
		{			
		}
		
		public String getDateFormat()
		{
			return dateFormat;
		}
		
		public void setDateFormat(String dateFormat)
		{
			this.dateFormat = dateFormat;
		}
		
		public String getTimeFormat()
		{
			return timeFormat;
		}
		
		public void setTimeFormat(String timeFormat)
		{
			this.timeFormat = timeFormat;
		}		
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