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

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.nepxion.swing.button.ButtonManager;
import com.nepxion.swing.button.JBasicButton;
import com.nepxion.swing.combobox.JBasicComboBox;
import com.nepxion.swing.dimension.DimensionManager;
import com.nepxion.swing.layout.toolbar.ToolBarLayout;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.scrollpane.JBasicScrollPane;
import com.nepxion.swing.textfield.number.JNumberTextField;
import com.nepxion.util.searcher.gis.google.loc.LocConstants;

public class JCoordinatePanel
	extends JPanel
{
	private JNumberTextField latitudeTextField;
	private JNumberTextField longitudeTextField;
	private JBasicComboBox languageComboBox;
	
	private JLocTable table;
	
	public JCoordinatePanel()
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
			
			latitudeTextField = new JNumberTextField(11, 7, -215D, 215D);
			DimensionManager.setDimension(latitudeTextField, new Dimension(100, 23));
			
			longitudeTextField = new JNumberTextField(11, 7, -215D, 215D);
			DimensionManager.setDimension(longitudeTextField, new Dimension(100, 23));
			
			languageComboBox = new JBasicComboBox(new String[] {LocConstants.LANGUAGE_ZH_CN, LocConstants.LANGUAGE_EN_GB});
			DimensionManager.setDimension(languageComboBox, new Dimension(70, 23));
			
			JBasicButton searchButton = new JBasicButton(LocController.getSearchAction(JCoordinatePanel.this));
			JBasicButton clearButton = new JBasicButton(LocController.getClearAction(table));
			
			add(new JLabel(SwingLocale.getString("latitude")));
			add(latitudeTextField);
			
			add(Box.createHorizontalStrut(5));
			add(new JLabel(SwingLocale.getString("longitude")));
			add(longitudeTextField);
			
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
	
	public double getLatitude()
	{
		return Double.parseDouble(latitudeTextField.getText());
	}
	
	public void setLatitude(double latitude)
	{
		latitudeTextField.setText(latitude + "");
	}
	
	public double getLongitude()
	{
		return Double.parseDouble(longitudeTextField.getText());
	}
	
	public void setLongitude(double longitude)
	{
		longitudeTextField.setText(longitude + "");
	}
	
	public String getLanguage()
	{
		return languageComboBox.getSelectedItem().toString();
	}
	
	public void setLanguage(String language)
	{
		languageComboBox.setSelectedItem(language);
	}
}