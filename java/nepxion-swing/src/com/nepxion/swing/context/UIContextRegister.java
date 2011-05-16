package com.nepxion.swing.context;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.net.URL;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.nepxion.swing.button.ButtonConstants;
import com.nepxion.swing.button.ButtonContext;
import com.nepxion.swing.chart.ChartConstants;
import com.nepxion.swing.chart.ChartContext;
import com.nepxion.swing.font.FontConstants;
import com.nepxion.swing.font.FontContext;
import com.nepxion.swing.icon.IconContext;
import com.nepxion.swing.lookandfeel.LookAndFeelManager;
import com.nepxion.swing.popupmenu.PopupMenuConstants;
import com.nepxion.swing.popupmenu.PopupMenuContext;
import com.nepxion.swing.style.framework.StyleContext;
import com.nepxion.swing.topic.TopicContext;

public class UIContextRegister
	extends AbstractContextRegister implements UIContextConstants
{
	private static Log log = LogFactory.getLog(UIContextRegister.class);
		
	private Properties properties;
	
	public void initializeContext(Properties properties)
	{
		this.properties = properties;
		
		log.info("---- UI Context Initialization Start ----");
		
		initStyle();
		initDecorated();
		initFont();
		initPDF();
		initButtonUI();
		initButtonInset();
		initPopupMenuTitle();
		initIconPath();
		initTopicComponent();		
		initLookAndFeel();
		
		log.info("----- UI Context Initialization End -----");
	}
	
	public void initializeContext(Properties properties, URL codeBase)
	{
		initializeContext(properties);
	}
	
	// 注册框架风格，默认由LookAndFeel分配
	private void initStyle()
	{		
		String style = properties.getProperty("style");
		String customStyle = properties.getProperty("customStyle");
		if (!isValid(style) && !isValid(customStyle))
		{
			style = DEFAULT_STYLE;
		}
		
		if (isValid(style))
		{
			style = DEFAULT_STYLE_PACKAGE + "." + style;
		}
		
		if (isValid(style))
		{
			StyleContext.registerStyle(style);
		}
		else if (isValid(customStyle))
		{
			StyleContext.registerStyle(customStyle);
		}
		
		log.info("Parameter - style : [" + style + "]");
		log.info("Parameter - customStyle : [" + customStyle + "]");
	}
	
	// 注册是否启动装饰器，会稍微影响显示性能。默认为ThemeDecorated和TabbedPaneDecorated启动，FrameDecorated和DialogDecorated关闭
	private void initDecorated()
	{		
		String themeDecorated = properties.getProperty("themeDecorated");
		String frameDecorated = properties.getProperty("frameDecorated");
		String dialogDecorated = properties.getProperty("dialogDecorated");
		String tabbedPaneDecorated = properties.getProperty("tabbedPaneDecorated");
		
		boolean isThemeDecorated = true;
		boolean isFrameDecorated = false;
		boolean isDialogDecorated = false;
		boolean isTabbedPaneDecorated = true;
		
		if (isValid(themeDecorated))
		{
			isThemeDecorated = themeDecorated.equals("true");
		}
		
		if (isValid(frameDecorated))
		{
			isFrameDecorated = frameDecorated.equals("true");
		}
		
		if (isValid(dialogDecorated))
		{
			isDialogDecorated = dialogDecorated.equals("true");
		}
		
		if (isValid(tabbedPaneDecorated))
		{
			isTabbedPaneDecorated = tabbedPaneDecorated.equals("true");
		}
		
		StyleContext.registerThemeDecorated(isThemeDecorated);
		StyleContext.registerFrameDecorated(isFrameDecorated);
		StyleContext.registerDialogDecorated(isDialogDecorated);
		StyleContext.registerTabbedPaneDecorated(isTabbedPaneDecorated);
		
		log.info("Parameter - isThemeDecorated : [" + isThemeDecorated + "]");
		log.info("Parameter - isFrameDecorated : [" + isFrameDecorated + "]");
		log.info("Parameter - isDialogDecorated : [" + isDialogDecorated + "]");
		log.info("Parameter - isTabbedPaneDecorated : [" + isTabbedPaneDecorated + "]");
	}
	
	// 注册界面字体
	private void initFont()
	{		
		String fontName = properties.getProperty("fontName");
		int fontStyle = -1;
		int fontSize = -1;
		
		if (!isValid(fontName))
		{
			fontName = FontConstants.DEFAULT_FONT_NAME;
		}
		try
		{
			fontStyle = Integer.parseInt(properties.getProperty("fontStyle"));
			fontSize = Integer.parseInt(properties.getProperty("fontSize"));
		}
		catch (Exception e)
		{
			fontStyle = FontConstants.DEFAULT_FONT_STYLE;
			fontSize = FontConstants.DEFAULT_FONT_SIZE;
		}
		
		String chartTitleFontName = properties.getProperty("chartTitleFontName");
		int chartTitleFontStyle = -1;
		int chartTitleFontSize = -1;
		
		if (!isValid(chartTitleFontName))
		{
			chartTitleFontName = FontConstants.DEFAULT_CHART_TITLE_FONT_NAME;
		}
		try
		{
			chartTitleFontStyle = Integer.parseInt(properties.getProperty("chartTitleFontStyle"));
			chartTitleFontSize = Integer.parseInt(properties.getProperty("chartTitleFontSize"));
		}
		catch (Exception e)
		{
			chartTitleFontStyle = FontConstants.DEFAULT_CHART_TITLE_FONT_STYLE;
			chartTitleFontSize = FontConstants.DEFAULT_CHART_TITLE_FONT_SIZE;
		}
		
		String chartSubTitleFontName = properties.getProperty("chartSubTitleFontName");
		int chartSubTitleFontStyle = -1;
		int chartSubTitleFontSize = -1;
		
		if (!isValid(chartSubTitleFontName))
		{
			chartSubTitleFontName = FontConstants.DEFAULT_CHART_SUB_TITLE_FONT_NAME;
		}
		try
		{
			chartSubTitleFontStyle = Integer.parseInt(properties.getProperty("chartSubTitleFontStyle"));
			chartSubTitleFontSize = Integer.parseInt(properties.getProperty("chartSubTitleFontSize"));
		}
		catch (Exception e)
		{
			chartSubTitleFontStyle = FontConstants.DEFAULT_CHART_SUB_TITLE_FONT_STYLE;
			chartSubTitleFontSize = FontConstants.DEFAULT_CHART_SUB_TITLE_FONT_SIZE;
		}
		
		String chartLabelFontName = properties.getProperty("chartLabelFontName");
		int chartLabelFontStyle = -1;
		int chartLabelFontSize = -1;
		
		if (!isValid(chartLabelFontName))
		{
			chartLabelFontName = FontConstants.DEFAULT_CHART_LABEL_FONT_NAME;
		}
		try
		{
			chartLabelFontStyle = Integer.parseInt(properties.getProperty("chartLabelFontStyle"));
			chartLabelFontSize = Integer.parseInt(properties.getProperty("chartLabelFontSize"));
		}
		catch (Exception e)
		{
			chartLabelFontStyle = FontConstants.DEFAULT_CHART_LABEL_FONT_STYLE;
			chartLabelFontSize = FontConstants.DEFAULT_CHART_LABEL_FONT_SIZE;
		}
		
		String chartTickLabelFontName = properties.getProperty("chartTickLabelFontName");
		int chartTickLabelFontStyle = -1;
		int chartTickLabelFontSize = -1;
		
		if (!isValid(chartTickLabelFontName))
		{
			chartTickLabelFontName = FontConstants.DEFAULT_CHART_TICK_LABEL_FONT_NAME;
		}
		try
		{
			chartTickLabelFontStyle = Integer.parseInt(properties.getProperty("chartTickLabelFontStyle"));
			chartTickLabelFontSize = Integer.parseInt(properties.getProperty("chartTickLabelFontSize"));
		}
		catch (Exception e)
		{
			chartTickLabelFontStyle = FontConstants.DEFAULT_CHART_TICK_LABEL_FONT_STYLE;
			chartTickLabelFontSize = FontConstants.DEFAULT_CHART_TICK_LABEL_FONT_SIZE;
		}
		
		FontContext.registerFont(fontName, fontStyle, fontSize);
		FontContext.registerChartTitleFont(chartTitleFontName, chartTitleFontStyle, chartTitleFontSize);
		FontContext.registerChartSubTitleFont(chartSubTitleFontName, chartSubTitleFontStyle, chartSubTitleFontSize);
		FontContext.registerChartLabelFont(chartLabelFontName, chartLabelFontStyle, chartLabelFontSize);
		FontContext.registerChartTickLabelFont(chartTickLabelFontName, chartTickLabelFontStyle, chartTickLabelFontSize);
		
		log.info("Parameter - fontName : [" + fontName + "]");
		log.info("Parameter - fontStyle : [" + fontStyle + "]");
		log.info("Parameter - fontSize : [" + fontSize + "]");			
		log.info("Parameter - chartTitleFontName : [" + chartTitleFontName + "]");
		log.info("Parameter - chartTitleFontStyle : [" + chartTitleFontStyle + "]");
		log.info("Parameter - chartTitleFontSize : [" + chartTitleFontSize + "]");			
		log.info("Parameter - chartSubTitleFontName : [" + chartSubTitleFontName + "]");
		log.info("Parameter - chartSubTitleFontStyle : [" + chartSubTitleFontStyle + "]");
		log.info("Parameter - chartSubTitleFontSize : [" + chartSubTitleFontSize + "]");			
		log.info("Parameter - chartLabelFontName : [" + chartLabelFontName + "]");
		log.info("Parameter - chartLabelFontStyle : [" + chartLabelFontStyle + "]");
		log.info("Parameter - chartLabelFontSize : [" + chartLabelFontSize + "]");
		log.info("Parameter - chartTickLabelFontName : [" + chartTickLabelFontName + "]");
		log.info("Parameter - chartTickLabelFontStyle : [" + chartTickLabelFontStyle + "]");
		log.info("Parameter - chartTickLabelFontSize : [" + chartTickLabelFontSize + "]");
	}
	
	// 注册JFreeChart导出PDF的参数
	private void initPDF()
	{
		String chartPDFAuthor = properties.getProperty("chartPDFAuthor");
		if (!isValid(chartPDFAuthor))
		{
			chartPDFAuthor = ChartConstants.DEFAULT_CHART_PDF_AUTHOR;
		}
		
		String chartPDFSubject = properties.getProperty("chartPDFSubject");
		if (!isValid(chartPDFSubject))
		{
			chartPDFSubject = ChartConstants.DEFAULT_CHART_PDF_SUBJECT;
		}
		
		ChartContext.registerChartPDFAuthor(chartPDFAuthor);
		ChartContext.registerChartPDFSubject(chartPDFSubject);
		
		log.info("Parameter - chartPDFAuthor : [" + chartPDFAuthor + "]");
		log.info("Parameter - chartPDFSubject : [" + chartPDFSubject + "]");
	}
	
	// 注册按钮风格，默认由LookAndFeel分配	
	private void initButtonUI()
	{		
		String buttonUI = properties.getProperty("buttonUI");       // Example : "LiteButtonUI";	
		String buttonStyle = properties.getProperty("buttonStyle"); // Example : "JAlloyLiteButtonStyle";
		
		String customButtonUI = properties.getProperty("customButtonUI");       // Example : "com.nepxion.swing.style.button.lite.LiteButtonUI";	 
		String customButtonStyle = properties.getProperty("customButtonStyle"); // Example : "com.nepxion.swing.style.button.lite.JAlloyLiteButtonStyle";
		
		if (isValid(buttonUI))
		{
			String buttonUIPrefix = ButtonContext.getButtonUIClassPrefix(buttonUI);
			buttonUI = DEFAULT_BUTTON_STYLE_PACKAGE + "." + buttonUIPrefix.toLowerCase() + "." + buttonUIPrefix + "ButtonUI";
			
			if (isValid(buttonStyle))
			{
				buttonStyle = DEFAULT_BUTTON_STYLE_PACKAGE + "." + buttonUIPrefix.toLowerCase() + "." + buttonStyle;
			}
		}
		else if (isValid(customButtonUI))
		{
			if (isValid(buttonStyle))
			{
				throw new IllegalArgumentException("It can't be specified ButtonStyle for '" + buttonStyle + "' when using custom ButtonUI");
			}
			else if (isValid(customButtonStyle))
			{
				String buttonUIPrefix = ButtonContext.getButtonUIClassPrefix(customButtonUI);
				
				customButtonUI = buttonUIPrefix + "ButtonUI";
			}
		}
		
		if (buttonUI != null)
		{	
			ButtonContext.registerUI(buttonUI, buttonStyle != null ? buttonStyle : customButtonStyle);
		}
		else if (customButtonUI != null)
		{
			ButtonContext.registerUI(customButtonUI, buttonStyle != null ? buttonStyle : customButtonStyle);
		}
		
		log.info("Parameter - buttonUI : [" + buttonUI + "]");
		log.info("Parameter - buttonStyle : [" + buttonStyle + "]");
		log.info("Parameter - customButtonUI : [" + customButtonUI + "]");
		log.info("Parameter - customButtonStyle : [" + customButtonStyle + "]");
	}
	
	// 注册按钮的Inset
	private void initButtonInset()
	{
		int buttonWidthInset = -1;
		int buttonHeightInset = -1;
		try
		{
			buttonWidthInset = Integer.parseInt(properties.getProperty("buttonWidthInset"));
			buttonHeightInset = Integer.parseInt(properties.getProperty("buttonHeightInset"));
		}
		catch (Exception e)
		{
			buttonWidthInset = ButtonConstants.DEFAULT_BUTTON_WIDTH_INSET;
			buttonHeightInset = ButtonConstants.DEFAULT_BUTTON_HEIGHT_INSET;
		}
		
		ButtonContext.registerInset(buttonWidthInset, buttonHeightInset);
		
		log.info("Parameter - buttonWidthInset : [" + buttonWidthInset + "]");
		log.info("Parameter - buttonHeightInset : [" + buttonHeightInset + "]");
	}
	
	// 注册菜单的垂直标题，默认为Nepxion
	private void initPopupMenuTitle()
	{
		String popupMenuTitle = properties.getProperty("popupMenuTitle");
		if (!isValid(popupMenuTitle))
		{
			popupMenuTitle = PopupMenuConstants.DEFAULT_TITLE;
		}
		
		PopupMenuContext.registerTitle(popupMenuTitle);
		
		log.info("Parameter - popupMenuTitle : [" + popupMenuTitle + "]");
	}
	
	// 注册快速寻址的图标路径，默认为空
	private void initIconPath()
	{
		String iconPath = properties.getProperty("iconPath");
		if (!isValid(iconPath))
		{
			iconPath = DEFAULT_ICON_PATH;
		}
		
		IconContext.registerIconFolder(iconPath);
		
		log.info("Parameter - iconPath : [" + iconPath + "]");
	}
	
	//注册帮助主题 的关于页面
	private void initTopicComponent()
	{
		String topicComponent = properties.getProperty("topicComponent");
		
		TopicContext.registerTopicComponent(topicComponent);
		
		log.info("Parameter - topicComponent : [" + topicComponent + "]");
	}
	
	// 注册外观效果
	private void initLookAndFeel()
	{
		String lookAndFeel = properties.getProperty("lookAndFeel");
		String customLookAndFeel = properties.getProperty("customLookAndFeel");
		if (!isValid(lookAndFeel) && !isValid(customLookAndFeel))
		{
			lookAndFeel = DEFAULT_LOOK_ADN_FEEL;
		}
		
		if (isValid(lookAndFeel))
		{
			LookAndFeelManager.invokeLookAndFeel(lookAndFeel);
		}
		else if (isValid(customLookAndFeel))
		{
			LookAndFeelManager.setLookAndFeel(customLookAndFeel);
		}
		
		log.info("Parameter - lookAndFeel : [" + lookAndFeel + "]");
		log.info("Parameter - customLookAndFeel : [" + customLookAndFeel + "]");
	}
	
	public boolean isValid(String content)
	{
		return content != null && !content.trim().equals("");
	}
}