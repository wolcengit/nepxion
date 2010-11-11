package com.nepxion.swing.searcher.gis.google.loc;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.nepxion.swing.button.ButtonManager;
import com.nepxion.swing.button.JBasicButton;
import com.nepxion.swing.combobox.JBasicComboBox;
import com.nepxion.swing.dimension.DimensionManager;
import com.nepxion.swing.element.ElementNode;
import com.nepxion.swing.layout.toolbar.ToolBarLayout;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.scrollpane.JBasicScrollPane;
import com.nepxion.swing.textfield.JBasicTextField;
import com.nepxion.util.locale.LocaleConstants;

public class JCellPanel
	extends JPanel
{
	private JBasicTextField cellIDTextField;
	private JBasicTextField lacTextField;
	private JBasicTextField mccTextField;
	private JBasicTextField mncTextField;
	private JBasicComboBox languageComboBox;
	
	private JLocTable table;
	
	public JCellPanel()
	{
		table = new JLocTable();
		
		setLayout(new BorderLayout());
		add(new ToolBar(), BorderLayout.NORTH);
		add(new JBasicScrollPane(table), BorderLayout.CENTER);
	}
	
	public class ToolBar
		extends JPanel
	{
		public ToolBar()
		{
			setLayout(new ToolBarLayout());
			setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
			
			cellIDTextField = new JBasicTextField();
			DimensionManager.setDimension(cellIDTextField, new Dimension(100, 23));
			
			lacTextField = new JBasicTextField();
			DimensionManager.setDimension(lacTextField, new Dimension(100, 23));
			
			mccTextField = new JBasicTextField();
			DimensionManager.setDimension(mccTextField, new Dimension(100, 23));
			
			mncTextField = new JBasicTextField();
			DimensionManager.setDimension(mncTextField, new Dimension(100, 23));
			
			Locale[] locales = LocaleConstants.LOCALE_LIST;
			ElementNode[] elementNodes = new ElementNode[locales.length];
			for (int i = 0; i < locales.length; i++)
			{
				Locale locale = locales[i];
				String text = SwingLocale.getString(locale.toString().toLowerCase());				
				elementNodes[i] = new ElementNode(text, null, text, locale);
			}
			
			languageComboBox = new JBasicComboBox(elementNodes);			
			DimensionManager.setDimension(languageComboBox, new Dimension(90, 23));
			
			JBasicButton searchButton = new JBasicButton(LocController.getSearchAction(JCellPanel.this));
			JBasicButton clearButton = new JBasicButton(LocController.getClearAction(table));
			
			add(new JLabel(SwingLocale.getString("cell_id")));
			add(cellIDTextField);
			
			add(Box.createHorizontalStrut(5));
			add(new JLabel(SwingLocale.getString("lac")));
			add(lacTextField);
			
			add(Box.createHorizontalStrut(5));
			add(new JLabel(SwingLocale.getString("mcc")));
			add(mccTextField);
			
			add(Box.createHorizontalStrut(5));
			add(new JLabel(SwingLocale.getString("mnc")));
			add(mncTextField);
			
			add(Box.createHorizontalStrut(5));
			add(new JLabel(SwingLocale.getString("language")));
			add(languageComboBox);
			
			add(searchButton);
			add(clearButton);
			
			add(Box.createHorizontalGlue());
			
			ButtonManager.updateUI(this);
		}
	}
	
	public JLocTable getLocTable()
	{
		return table;
	}
	
	public int getCellID()
	{
		return Integer.parseInt(cellIDTextField.getText());
	}
	
	public void setCellID(int cellID)
	{
		cellIDTextField.setText(cellID + "");
	}
	
	public int getLac()
	{
		return Integer.parseInt(lacTextField.getText());
	}
	
	public void setLac(int lac)
	{
		lacTextField.setText(lac + "");
	}
	
	public int getMcc()
	{
		return Integer.parseInt(mccTextField.getText());
	}
	
	public void setMcc(int mcc)
	{
		mccTextField.setText(mcc + "");
	}
	
	public int getMnc()
	{
		return Integer.parseInt(mncTextField.getText());
	}
	
	public void setMnc(int mnc)
	{
		mncTextField.setText(mnc + "");
	}
	
	public String getLanguage()
	{
		ElementNode selectedElementNode = (ElementNode) languageComboBox.getSelectedItem();
		Locale locale = (Locale) selectedElementNode.getUserObject();
		return locale.toString();
	}
	
	public void setLanguage(String language)
	{
		for (int i = 0; i < languageComboBox.getItemCount(); i++)
		{
			ElementNode selectedElementNode = (ElementNode) languageComboBox.getItemAt(i);
			Locale locale = (Locale) selectedElementNode.getUserObject();
			if (locale.toString().equals(language))
			{
				languageComboBox.setSelectedIndex(i);
				return;
			}	
		}
	}
}