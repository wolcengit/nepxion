package com.nepxion.swing.framework.ribbon.xml;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.awt.Insets;
import java.awt.LayoutManager;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;

import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.MenuElement;
import javax.swing.SwingConstants;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;

import com.nepxion.swing.button.ButtonManager;
import com.nepxion.swing.button.JBasicButton;
import com.nepxion.swing.button.JBasicMenuButton;
import com.nepxion.swing.button.JClassicButton;
import com.nepxion.swing.button.JClassicMenuButton;
import com.nepxion.swing.framework.ribbon.JRibbon;
import com.nepxion.swing.framework.ribbon.JRibbonBar;
import com.nepxion.swing.framework.ribbon.JRibbonContainer;
import com.nepxion.swing.framework.ribbon.RibbonManager;
import com.nepxion.swing.framework.ribbon.action.JRibbonAction;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.layout.table.TableLayout;
import com.nepxion.swing.lookandfeel.LookAndFeelManager;
import com.nepxion.swing.menu.JBasicMenu;
import com.nepxion.swing.menuitem.JBasicMenuItem;
import com.nepxion.swing.popupmenu.JDecorationPopupMenu;
import com.nepxion.swing.separator.JBasicSeparator;
import com.nepxion.swing.tabbedpane.ITabbedPane;
import com.nepxion.util.string.StringUtil;
import com.nepxion.util.xml.dom4j.Dom4JReader;

public class Dom4JRibbonParser
	implements Dom4JRibbonConstants, SwingConstants
{
	private JRibbonContainer ribbonContainer;
	private ITabbedPane tabbedPane;
	
	public Dom4JRibbonParser(JRibbonContainer ribbonContainer, ITabbedPane tabbedPane)
	{
		this.ribbonContainer = ribbonContainer;
		this.tabbedPane = tabbedPane;
	}
	
	public void parse(String text)
		throws DocumentException
	{
		Document document = Dom4JReader.getDocument(text);
		parse(document);
	}
	
	public void parseFormat(String text)
		throws DocumentException, UnsupportedEncodingException
	{
		Document document = Dom4JReader.getFormatDocument(text);
		parse(document);
	}
	
	public void parse(File file)
		throws DocumentException, FileNotFoundException, UnsupportedEncodingException
	{
		Document document = Dom4JReader.getDocument(file);
		parse(document);
	}
	
	public void parseFormat(File file)
		throws DocumentException, FileNotFoundException, UnsupportedEncodingException
	{
		Document document = Dom4JReader.getFormatDocument(file);
		parse(document);
	}
	
	public void parse(InputStream inputStream)
		throws DocumentException
	{
		Document document = Dom4JReader.getDocument(inputStream);
		parse(document);
	}
	
	public void parseFormat(InputStream inputStream)
		throws DocumentException, UnsupportedEncodingException
	{
		Document document = Dom4JReader.getFormatDocument(inputStream);
		parse(document);
	}
	
	public void parse(Document document)
	{
		Element rootElement = document.getRootElement();
		parseRibbonBarElement(rootElement);
	}
	
	public void parseRibbonBarElement(Element element)
	{
		for (Iterator elementIterator = element.elementIterator(); elementIterator.hasNext();)
		{
			Object childElementObject = elementIterator.next();
			if (childElementObject instanceof Element)
			{
				Element childElement = (Element) childElementObject;
				
				parseRibbonBarAttribute(childElement);
			}
		}
	}
	
	public void parseRibbonBarAttribute(Element element)
	{
		JRibbonBar ribbonBar = new JRibbonBar(ribbonContainer);
		
		String title = null;
		Icon icon = null;
		String toolTipText = null;
		boolean isClosable = false;
		
		for (Iterator attributeIterator = element.attributeIterator(); attributeIterator.hasNext();)
		{
			Attribute attribute = (Attribute) attributeIterator.next();
			String attributeName = attribute.getName().trim();
			String attributeText = attribute.getText().trim();
			
			if (attributeName.equals(TAG_TITLE))
			{
				title = attributeText;
			}
			else if (attributeName.equals(TAG_ICON))
			{
				if (attributeText != null && !attributeText.equals(""))
				{
					icon = IconFactory.getContextIcon(attributeText);
				}
			}
			else if (attributeName.equals(TAG_TOOL_TIP_TEXT))
			{
				toolTipText = attributeText;
			}
			else if (attributeName.equals(TAG_CLOSABLE))
			{
				if (attributeText != null && !attributeText.equals(""))
				{
					isClosable = Boolean.valueOf(attributeText);
				}
			}
		}
		
		tabbedPane.addTab(title, icon, ribbonBar, toolTipText, isClosable);
		
		parseRibbonElement(element, ribbonBar);
	}
	
	public void parseRibbonElement(Element element, JRibbonBar ribbonBar)
	{
		for (Iterator elementIterator = element.elementIterator(); elementIterator.hasNext();)
		{
			Object childElementObject = elementIterator.next();
			if (childElementObject instanceof Element)
			{
				Element childElement = (Element) childElementObject;
				
				parseRibbonAttribute(childElement, ribbonBar);
			}
		}
	}
	
	public void parseRibbonAttribute(Element element, JRibbonBar ribbonBar)
	{
		JRibbon ribbon = new JRibbon();
		
		String title = null;
		Icon icon = null;
		String toolTipText = null;
		LayoutManager layout = null;
		int[] buttonLayout = BUTTON_LAYOUT;
		Insets buttonInsets = BUTTON_INSETS;
		
		for (Iterator attributeIterator = element.attributeIterator(); attributeIterator.hasNext();)
		{
			Attribute attribute = (Attribute) attributeIterator.next();
			String attributeName = attribute.getName().trim();
			String attributeText = attribute.getText().trim();
			
			if (attributeName.equals(TAG_TITLE))
			{
				title = attributeText;
			}
			else if (attributeName.equals(TAG_ICON))
			{
				if (attributeText != null && !attributeText.equals(""))
				{
					icon = IconFactory.getContextIcon(attributeText);
				}
			}
			else if (attributeName.equals(TAG_TOOL_TIP_TEXT))
			{
				toolTipText = attributeText;
			}
			else if (attributeName.equals(TAG_LAYOUT))
			{
				if (!attributeText.trim().equals(""))
				{	
					String layoutClass = attributeText.substring(0, attributeText.indexOf("("));
					
					if (layoutClass.indexOf("TableLayout") > -1)
					{
						String layoutParameters = attributeText.substring(attributeText.indexOf("{"), attributeText.lastIndexOf("}") + 1);
						
						double[][] size = StringUtil.parseDouble2Array(layoutParameters);
						
						layout = new TableLayout(size);
					}
				}
			}
			else if (attributeName.equals(TAG_BUTTON_LAYOUT))
			{
				buttonLayout = StringUtil.parseIntArray(attributeText);
			}
			else if (attributeName.equals(TAG_BUTTON_INSETS))
			{
				attributeText = StringUtils.deleteWhitespace(attributeText);
				
				String[] stringArray = attributeText.split(",");
				buttonInsets = new Insets(Integer.parseInt(stringArray[0]), Integer.parseInt(stringArray[1]), Integer.parseInt(stringArray[2]), Integer.parseInt(stringArray[3]));	
			}
		}
		
		ribbon.setTitle(title);
		ribbon.setIcon(icon);
		ribbon.setToolTipText(toolTipText);
		
		if (layout != null)
		{
			ribbon.getContainer().setLayout(layout);
		}
		ribbonBar.getRibbonView().add(ribbon);
		
		parseButtonElement(element, ribbon);
		
		ButtonManager.updateUI(ribbon.getContainer(), buttonInsets, buttonLayout);
	}
	
	public void parseButtonElement(Element element, JRibbon ribbon)
	{
		for (Iterator elementIterator = element.elementIterator(); elementIterator.hasNext();)
		{
			Object childElementObject = elementIterator.next();
			if (childElementObject instanceof Element)
			{
				Element childElement = (Element) childElementObject;

				parseButtonAttribute(childElement, ribbon);
			}
		}
	}
	
	public void parseButtonAttribute(Element element, JRibbon ribbon)
	{		
		String name = null;
		String text = null;
		Icon icon = null;
		String toolTipText = null;
		String ribbonName = null;
		String ribbonTitle = null;
		Icon ribbonIcon = null;
		String ribbonToolTipText = null;
		int orientation = 1;
		String constraints = null;
		Class clazz = null;
		
		for (Iterator attributeIterator = element.attributeIterator(); attributeIterator.hasNext();)
		{
			Attribute attribute = (Attribute) attributeIterator.next();
			String attributeName = attribute.getName().trim();
			String attributeText = attribute.getText().trim();
			
			if (attributeName.equals(TAG_NAME))
			{
				name = attributeText;
			}
			else if (attributeName.equals(TAG_TEXT))
			{
				text = attributeText;
			}
			else if (attributeName.equals(TAG_ICON))
			{
				if (attributeText != null && !attributeText.equals(""))
				{
					icon = IconFactory.getContextIcon(attributeText);
				}
			}
			else if (attributeName.equals(TAG_TOOL_TIP_TEXT))
			{
				toolTipText = attributeText;
			}
			else if (attributeName.equals(TAG_RIBBON_NAME))
			{
				ribbonName = attributeText;
			}
			else if (attributeName.equals(TAG_RIBBON_TITLE))
			{
				ribbonTitle = attributeText;
			}
			else if (attributeName.equals(TAG_RIBBON_ICON))
			{
				if (attributeText != null && !attributeText.equals(""))
				{
					ribbonIcon = IconFactory.getContextIcon(attributeText);
				}
			}
			else if (attributeName.equals(TAG_RIBBON_TOOL_TIP_TEXT))
			{
				ribbonToolTipText = attributeText;
			}
			else if (attributeName.equals(TAG_ORIENTATION))
			{
				orientation = Integer.parseInt(attributeText);
			}
			else if (attributeName.equals(TAG_CONSTRAINTS))
			{
				constraints = attributeText;
			}
			else if (attributeName.equals(TAG_CLASS))
			{
				try
				{
					clazz = Class.forName(attributeText);
				}
				catch (ClassNotFoundException e)
				{
					e.printStackTrace();
				}
			}
		}
		
		if (ribbonName == null || ribbonName.trim().equals(""))
		{
			ribbonName = name;
		}	
		if (ribbonTitle == null || ribbonTitle.trim().equals(""))
		{
			ribbonTitle = toolTipText;
		}
		if (ribbonToolTipText == null || ribbonToolTipText.trim().equals(""))
		{
			ribbonToolTipText = toolTipText;
		}
		
		JComponent component = null;
		if (!element.getName().equals(TAG_SEPARATOR))
		{	
			if (element.elements().size() == 0)
			{
				JRibbonAction ribbonAction = createRibbonAction(name, text, icon, toolTipText, ribbonName, ribbonTitle, ribbonIcon, ribbonToolTipText, clazz);				                                           
				if (LookAndFeelManager.isNimbusLookAndFeel())
				{	
					component = new JClassicButton(ribbonAction);
				}
				else
				{
					component = new JBasicButton(ribbonAction);
				}
			}
			else
			{
				JDecorationPopupMenu popupMenu = new JDecorationPopupMenu();
				
				if (LookAndFeelManager.isNimbusLookAndFeel())
				{	
					component = new JClassicMenuButton(ButtonManager.getStyleText(text), icon, toolTipText);
					((JClassicMenuButton) component).setShowArrowRight(false);	
					((JClassicMenuButton) component).setPopupMenu(popupMenu);
				}
				else
				{
					component = new JBasicMenuButton(ButtonManager.getStyleText(text), icon, toolTipText);	
					((JBasicMenuButton) component).setPopupMenu(popupMenu);
				}
				
				parseMenuElement(element, popupMenu);
			}
		}
		else
		{
			component = new JBasicSeparator();
			((JBasicSeparator) component).setOrientation(orientation);
		}
		
		if (constraints != null)
		{
			ribbon.getContainer().add(component, constraints);
		}
		else
		{			
			ribbon.getContainer().add(component);
		}
	}
	
	public void parseMenuElement(Element element, MenuElement menu)
	{
		for (Iterator elementIterator = element.elementIterator(); elementIterator.hasNext();)
		{
			Object childElementObject = elementIterator.next();
			if (childElementObject instanceof Element)
			{
				Element childElement = (Element) childElementObject;
				
				parseMenuAttribute(childElement, menu);
			}
		}
	}
	
	public void parseMenuAttribute(Element element, MenuElement menu)
	{
		String name = null;
		String text = null;
		Icon icon = null;
		String toolTipText = null;
		String ribbonName = null;
		String ribbonTitle = null;
		Icon ribbonIcon = null;
		String ribbonToolTipText = null;
		Class clazz = null;
		
		for (Iterator attributeIterator = element.attributeIterator(); attributeIterator.hasNext();)
		{
			Attribute attribute = (Attribute) attributeIterator.next();
			String attributeName = attribute.getName().trim();
			String attributeText = attribute.getText().trim();
			
			if (attributeName.equals(TAG_NAME))
			{
				name = attributeText;
			}
			else if (attributeName.equals(TAG_TEXT))
			{
				text = attributeText;
			}
			else if (attributeName.equals(TAG_ICON))
			{
				if (attributeText != null && !attributeText.equals(""))
				{
					icon = IconFactory.getContextIcon(attributeText);
				}
			}
			else if (attributeName.equals(TAG_TOOL_TIP_TEXT))
			{
				toolTipText = attributeText;
			}
			else if (attributeName.equals(TAG_RIBBON_NAME))
			{
				ribbonName = attributeText;
			}
			else if (attributeName.equals(TAG_RIBBON_TITLE))
			{
				ribbonTitle = attributeText;
			}
			else if (attributeName.equals(TAG_RIBBON_ICON))
			{
				if (attributeText != null && !attributeText.equals(""))
				{
					ribbonIcon = IconFactory.getContextIcon(attributeText);
				}
			}
			else if (attributeName.equals(TAG_RIBBON_TOOL_TIP_TEXT))
			{
				ribbonToolTipText = attributeText;
			}			
			else if (attributeName.equals(TAG_CLASS))
			{
				try
				{
					clazz = Class.forName(attributeText);
				}
				catch (ClassNotFoundException e)
				{
					e.printStackTrace();
				}
			}
		}
		
		if (ribbonName == null || ribbonName.trim().equals(""))
		{
			ribbonName = name;
		}	
		if (ribbonTitle == null || ribbonTitle.trim().equals(""))
		{
			ribbonTitle = toolTipText;
		}
		if (ribbonToolTipText == null || ribbonToolTipText.trim().equals(""))
		{
			ribbonToolTipText = toolTipText;
		}
		
		if (!element.getName().equals(TAG_SEPARATOR))
		{	
			MenuElement childMenu = null;
			if (element.elements().size() == 0)
			{
				JRibbonAction ribbonAction = createRibbonAction(name, text, icon, toolTipText, ribbonName, ribbonTitle, ribbonIcon, ribbonToolTipText, clazz);	
				
				childMenu = new JBasicMenuItem(ribbonAction);
			}
			else
			{
				childMenu = new JBasicMenu(ButtonManager.getStyleText(text), icon, toolTipText);
				
				parseMenuElement(element, childMenu);
			}
			
			((JComponent) menu).add((JComponent) childMenu);
		}
		else
		{
			if (menu instanceof JDecorationPopupMenu)
			{
				((JDecorationPopupMenu) menu).addSeparator();
			}
			else if (menu instanceof JBasicMenu)
			{
				((JBasicMenu) menu).addSeparator();
			}
		}		
	}
	
	public JRibbonAction createRibbonAction(String name, String text, Icon icon, String toolTipText, String ribbonName, String ribbonTitle, Icon ribbonIcon, String ribbonToolTipText, Class clazz)
	{
		return RibbonManager.createRibbonAction(name, ButtonManager.getStyleText(text), icon, toolTipText, ribbonName, ribbonTitle, ribbonIcon, ribbonToolTipText, ribbonContainer, clazz);
	}
}