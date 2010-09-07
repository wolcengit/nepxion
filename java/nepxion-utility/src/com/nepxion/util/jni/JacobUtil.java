package com.nepxion.util.jni;

/**
 * <p>Title: Nepxion Utility</p>
 * <p>Description: Nepxion Utility Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class JacobUtil
{
	public static void callInternetExplorer(String url)
		throws Exception
	{
		ActiveXComponent internetExplorer = null;
		try
		{
			internetExplorer = new ActiveXComponent("InternetExplorer.Application");
			internetExplorer.setProperty("Visible", new Variant(true));
			internetExplorer.setProperty("AddressBar", new Variant(true));
			internetExplorer.setProperty("StatusText", new Variant("Nepxion"));
			
			Dispatch.call(internetExplorer.getObject(), "Navigate", new Variant(url));
		}
		catch (Exception e)
		{
			throw e;
		}
		finally
		{
			if (internetExplorer != null)
			{
				internetExplorer = null;
			}
			ComThread.Release();
		}
	}
	
	public static void callWord(String filePath, boolean readOnly)
		throws Exception
	{
		ActiveXComponent word = null;
		try
		{
			word = new ActiveXComponent("Word.Application");
			word.setProperty("Visible", new Variant(true));
			
			Dispatch documents = word.getProperty("Documents").toDispatch();
			Dispatch.invoke(documents, "Open", Dispatch.Method, new Object[] {filePath, new Variant(true), new Variant(readOnly)}, new int[1]).toDispatch();
		}
		catch (Exception e)
		{
			throw e;
		}
		finally
		{
			if (word != null)
			{
				word = null;
			}
			ComThread.Release();
		}
	}
	
	public static void callExcel(String filePath, boolean readOnly)
		throws Exception
	{
		ActiveXComponent excel = null;
		try
		{
			excel = new ActiveXComponent("Excel.Application");
			excel.setProperty("Visible", new Variant(true));
			
			Dispatch workbooks = excel.getProperty("Workbooks").toDispatch();
			Dispatch.invoke(workbooks, "Open", Dispatch.Method, new Object[] {filePath, new Variant(true), new Variant(readOnly)}, new int[1]).toDispatch();
		}
		catch (Exception e)
		{
			throw e;
		}
		finally
		{
			if (excel != null)
			{
				excel = null;
			}
			ComThread.Release();
		}
	}
	
	public static void callPowerPoint(String filePath, boolean readOnly, boolean fullScreen)
		throws Exception
	{
		ActiveXComponent powerPoint = null;
		try
		{
			powerPoint = new ActiveXComponent("PowerPoint.Application");
			powerPoint.setProperty("Visible", new Variant(true));
			
			ActiveXComponent presentations = powerPoint.getPropertyAsComponent("Presentations");
			ActiveXComponent presentation = presentations.invokeGetComponent("Open", new Variant(filePath), new Variant(readOnly));
			
			if (fullScreen)
			{
				ActiveXComponent slideShowSettings = presentation.getPropertyAsComponent("SlideShowSettings");
				slideShowSettings.invoke("Run"); // 调用该对象的run函数实现全屏播放
			}
		}
		catch (Exception e)
		{
			throw e;
		}
		finally
		{
			if (powerPoint != null)
			{
				powerPoint = null;
			}
			ComThread.Release();
		}
	}
	
	public static void transformWordToHtml(String wordFilePath, String htmlFilePath)
		throws Exception
	{
		ActiveXComponent word = null;
		try
		{
			word = new ActiveXComponent("Word.Application");
			word.setProperty("Visible", new Variant(false));
			
			Dispatch documents = word.getProperty("Documents").toDispatch();
			Dispatch document = Dispatch.invoke(documents, "Open", Dispatch.Method, new Object[] {wordFilePath, new Variant(true), new Variant(false)}, new int[1]).toDispatch();
			Dispatch.invoke(document, "SaveAs", Dispatch.Method, new Object[] {htmlFilePath, new Variant(8)}, new int[1]);
			Dispatch.call(document, "Close", new Variant(false));
		}
		catch (Exception e)
		{
			throw e;
		}
		finally
		{
			if (word != null)
			{
				word.invoke("Quit", new Variant[] {});
				word = null;
			}
			ComThread.Release();
		}
	}
	
	public static void transformExcelToHtml(String excelFilePath, String htmlFilePath)
		throws Exception
	{
		ActiveXComponent excel = null;
		try
		{
			excel = new ActiveXComponent("Excel.Application");
			excel.setProperty("Visible", new Variant(false));
			
			Dispatch workbooks = excel.getProperty("Workbooks").toDispatch();
			Dispatch workbook = Dispatch.invoke(workbooks, "Open", Dispatch.Method, new Object[] {excelFilePath, new Variant(true), new Variant(false)}, new int[1]).toDispatch();
			Dispatch.invoke(workbook, "SaveAs", Dispatch.Method, new Object[] {htmlFilePath, new Variant(44)}, new int[1]);
			Dispatch.call(workbook, "Close", new Variant(false));
		}
		catch (Exception e)
		{
			throw e;
		}
		finally
		{
			if (excel != null)
			{
				excel.invoke("Quit", new Variant[] {});
				excel = null;
			}
			ComThread.Release();
		}
	}
}