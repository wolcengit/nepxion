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

import java.awt.Container;
import java.awt.Insets;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;

import javax.swing.Icon;
import javax.swing.SwingConstants;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;

import com.nepxion.swing.button.ButtonManager;
import com.nepxion.swing.button.JClassicButton;
import com.nepxion.swing.framework.ribbon.JRibbon;
import com.nepxion.swing.framework.ribbon.JRibbonAction;
import com.nepxion.swing.framework.ribbon.JRibbonBar;
import com.nepxion.swing.framework.ribbon.JRibbonContainer;
import com.nepxion.swing.framework.ribbon.RibbonManager;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.scrollpane.JAutoRollScrollPane;
import com.nepxion.swing.tabbedpane.ITabbedPane;
import com.nepxion.util.xml.dom4j.Dom4JReader;

public class Dom4JRibbonParser
	implements Dom4JRibbonConstants, SwingConstants
{
	private JRibbonContainer ribbonContainer;
	private ITabbedPane tabbedPane;
	
	private Insets buttonInsets = BUTTON_INSETS;
	private int[] buttonLayoutParameters = BUTTON_LAYOUT_PARAMETERS;
	
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
				Element ribbonBarElement = (Element) childElementObject;
				
				parseRibbonBarAttribute(ribbonBarElement);
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
		
		tabbedPane.addTab(title, icon, new JAutoRollScrollPane(ribbonBar), toolTipText, isClosable);
		
		parseRibbonElement(element, ribbonBar);
	}
	
	public void parseRibbonElement(Element element, JRibbonBar ribbonBar)
	{
		for (Iterator elementIterator = element.elementIterator(); elementIterator.hasNext();)
		{
			Object childElementObject = elementIterator.next();
			if (childElementObject instanceof Element)
			{
				Element ribbonElement = (Element) childElementObject;
				
				parseRibbonAttribute(ribbonElement, ribbonBar);
			}
		}
	}
	
	public void parseRibbonAttribute(Element element, JRibbonBar ribbonBar)
	{
		JRibbon ribbon = new JRibbon();
		
		String title = null;
		Icon icon = null;
		String toolTipText = null;
		
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
		}
		
		ribbon.setTitle(title);
		ribbon.setIcon(icon);
		ribbon.setToolTipText(toolTipText);
		
		ribbonBar.add(ribbon);
		
		parseButtonElement(element, ribbon);
	}
	
	public void parseButtonElement(Element element, JRibbon ribbon)
	{
		for (Iterator elementIterator = element.elementIterator(); elementIterator.hasNext();)
		{
			Object childElementObject = elementIterator.next();
			if (childElementObject instanceof Element)
			{
				Element ribbonElement = (Element) childElementObject;
				
				parseButtonAttribute(ribbonElement, ribbon);
			}
		}
		
		ButtonManager.updateUI(ribbon.getContainer(), buttonInsets, buttonLayoutParameters);
	}
	
	public void parseButtonAttribute(Element element, JRibbon ribbon)
	{
		Container container = ribbon.getContainer();
		
		String text1 = null;
		String text2 = null;
		Icon icon = null;
		String toolTipText = null;
		Class clazz = null;
		
		for (Iterator attributeIterator = element.attributeIterator(); attributeIterator.hasNext();)
		{
			Attribute attribute = (Attribute) attributeIterator.next();
			String attributeName = attribute.getName().trim();
			String attributeText = attribute.getText().trim();
			
			if (attributeName.equals(TAG_TEXT1))
			{
				text1 = attributeText;
			}
			else if (attributeName.equals(TAG_TEXT2))
			{
				text2 = attributeText;
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
		
		JRibbonAction ribbonAction = RibbonManager.createRibbonAction(ButtonManager.getStyleText(text1, text2), icon, toolTipText, ribbonContainer, clazz);
		JClassicButton button = new JClassicButton(ribbonAction);
		
		container.add(button);
	}
	
	public Insets getButtonInsets()
	{
		return buttonInsets;
	}
	
	public void setButtonInsets(Insets buttonInsets)
	{
		this.buttonInsets = buttonInsets;
	}
	
	public int[] getButtonLayoutParameters()
	{
		return buttonLayoutParameters;
	}
	
	public void setButtonLayoutParameters(int[] buttonLayoutParameters)
	{
		this.buttonLayoutParameters = buttonLayoutParameters;
	}
}