package com.nepxion.net.http.apache;

/**
 * <p>Title: Nepxion Server</p>
 * <p>Description: Nepxion Server Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nepxion.util.encode.EncodeUtil;

public class ApacheServlet
	extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException
	{
		doExecute(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException
	{	
		doExecute(request, response);
	}
	
	private void doExecute(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException	
	{		
		request.setCharacterEncoding("GBK");		
		response.setCharacterEncoding("GBK");		
		response.setContentType("text/xml");
		
		String target = EncodeUtil.formatGBK(request.getParameter("target"));
		String entity = EncodeUtil.formatGBK(request.getParameter("entity"));
		
		PrintWriter out = response.getWriter();
		out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		out.println("<records>");
		out.println("<record index=\"" + 1 + "\" target=\"" + target + "响应" + "\" entity=\"" + entity + "响应" + "\"/>");
		out.println("</records>");		
	}
}