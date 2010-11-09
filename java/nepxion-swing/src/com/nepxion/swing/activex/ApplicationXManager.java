package com.nepxion.swing.activex;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import com.nepxion.util.jni.JacobUtil;

public class ApplicationXManager
{
	public static void callInternetExplorer(String url)
		throws Exception
	{
		JacobUtil.callInternetExplorer(url);
	}
	
	public static void callWord(String filePath, boolean readOnly)
		throws Exception
	{
		JacobUtil.callWord(filePath, readOnly);
	}
	
	public static void callExcel(String filePath, boolean readOnly)
		throws Exception
	{
		JacobUtil.callExcel(filePath, readOnly);
	}
	
	public static void callPowerPoint(String filePath, boolean readOnly, boolean fullScreen)
		throws Exception
	{
		JacobUtil.callPowerPoint(filePath, readOnly, fullScreen);
	}
	
	public static void transformWordToHtml(String wordFilePath, String htmlFilePath)
		throws Exception
	{
		JacobUtil.transformWordToHtml(wordFilePath, htmlFilePath);
	}
	
	public static void transformExcelToHtml(String excelFilePath, String htmlFilePath)
		throws Exception
	{
		JacobUtil.transformWordToHtml(excelFilePath, htmlFilePath);
	}
}