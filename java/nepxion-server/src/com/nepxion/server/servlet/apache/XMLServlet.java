package com.nepxion.server.servlet.apache;

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

public class XMLServlet
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
		request.setCharacterEncoding("GB2312");		
		response.setCharacterEncoding("GB2312");		
		response.setContentType("text/xml");
		
		String name = request.getParameter("name");
		String value = request.getParameter("value");
		
		PrintWriter out = response.getWriter();
		out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		out.println("<records>");
		out.println("<record index=\"" + 1 + "\" name=\"" + name + "\" value=\"" + value + "\"/>");
		out.println("</records>");		
	}
}