package com.nepxion.demo;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import com.nepxion.demo.component.splash.DemoCaptionSplashDialog;
import com.nepxion.swing.chart.ChartContext;
import com.nepxion.swing.icon.IconContext;
import com.nepxion.swing.lookandfeel.LookAndFeelManager;
import com.nepxion.swing.popupmenu.PopupMenuContext;
import com.nepxion.swing.style.framework.JPlasticStyle;
import com.nepxion.swing.style.framework.StyleContext;
import com.nepxion.swing.topic.TopicContext;

public class DemoUIContext
{		
	public static void initialize()
	{			
		//注册框架风格，默认由LookAndFeel分配
		//StyleContext.registerStyle(JLiteStyle.ID);
		//StyleContext.registerStyle(JWindowsStyle.ID);
		//StyleContext.registerStyle(JEclipseStyle.ID);	
		StyleContext.registerStyle(JPlasticStyle.ID);		
		//StyleContext.registerStyle(JFervencyStyle.ID);
		//StyleContext.registerStyle(JNimbusStyle.ID);
		
		//注册是否启动装饰器，会稍微影响显示性能。默认为ThemeDecorated启动，FrameDecorated和DialogDecorated关闭
		//StyleContext.registerThemeDecorated(true);
		StyleContext.registerFrameDecorated(true);
		StyleContext.registerDialogDecorated(true);
		//StyleContext.registerTabbedPaneDecorated(false);
		
		//注册界面字体
		//FontContext.registerFont("Dialog", Font.PLAIN, 12);
		//FontContext.registerChartTitleFont("SimHei", Font.PLAIN, 18);
		//FontContext.registerChartSubTitleFont("Dialog", Font.PLAIN, 12);
		//FontContext.registerChartLabelFont("Dialog", Font.PLAIN, 12);
		//FontContext.registerChartTickLabelFont("SansSerif", Font.PLAIN, 10);
		
		//注册JFreeChart导出PDF的参数
		ChartContext.registerChartPDFAuthor("Haojun Ren");
		ChartContext.registerChartPDFSubject("Nepxion");
		
		//注册按钮风格，默认由LookAndFeel分配
		//ButtonContext.registerUI(FlatButtonUI.ID, JFlatButtonStyle.ID);
		//ButtonContext.registerUI(LiteButtonUI.ID, JAlloyLiteButtonStyle.ID);
		//ButtonContext.registerUI(LiteButtonUI.ID, JAcidLiteButtonStyle.ID);
		//ButtonContext.registerUI(LiteButtonUI.ID, JBedouinLiteButtonStyle.ID);
		//ButtonContext.registerUI(LiteButtonUI.ID, JGlassLiteButtonStyle.ID);
		//ButtonContext.registerUI(LiteButtonUI.ID, JEclipseLiteButtonStyle.ID);
		//ButtonContext.registerUI(LiteButtonUI.ID, JNimbusLiteButtonStyle.ID);
		//ButtonContext.registerUI(LiteButtonUI.ID, JBorlandLiteButtonStyle.ID);
		//ButtonContext.registerUI(LiteButtonUI.ID, JBlueLiteButtonStyle.ID);
		//ButtonContext.registerUI(LiteButtonUI.ID, JYellowLiteButtonStyle.ID);
		
		//注册按钮的Inset
		//ButtonContext.registerInset(5, 5);
		
		//注册菜单的垂直标题，默认为Nepxion
		PopupMenuContext.registerTitle("Nepxion");
		
		//注册快速寻址的图标路径，默认为空
		IconContext.registerIconFolder("com/nepxion/demo/component/icon/image/");
		
		//注册帮助主题的关于页面
		TopicContext.registerTopicComponent(new DemoCaptionSplashDialog());		
		
		//注册外观效果
		//LookAndFeelManager.setSystemLookAndFeel();
		//LookAndFeelManager.setDefaultMetalLookAndFeel();
		//LookAndFeelManager.setMetalLookAndFeel();
		//LookAndFeelManager.setWindowsLookAndFeel();
		//LookAndFeelManager.setMotifLookAndFeel();
		//LookAndFeelManager.setGTKLookAndFeel();
		//LookAndFeelManager.setNimbusLookAndFeel();
		LookAndFeelManager.setAlloyLookAndFeel();
		//LookAndFeelManager.setAcidLookAndFeel();
		//LookAndFeelManager.setBedouinLookAndFeel();
		//LookAndFeelManager.setGlassLookAndFeel();
		//LookAndFeelManager.setBorlandLookAndFeel();
		//LookAndFeelManager.setJGoodiesWindowsLookAndFeel();
		//LookAndFeelManager.setPlasticLookAndFeel();
		//LookAndFeelManager.setPlasticXPLookAndFeel();
		//LookAndFeelManager.setPlastic3DLookAndFeel();
		//LookAndFeelManager.setXPLookAndFeel();
		//LookAndFeelManager.setTinyLookAndFeel();		
	}
}