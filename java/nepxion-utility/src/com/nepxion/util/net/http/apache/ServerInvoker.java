package com.nepxion.util.net.http.apache;

/**
 * <p>Title: Nepxion Utility</p>
 * <p>Description: Nepxion Utility Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nepxion.util.io.IOUtil;

public class ServerInvoker
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
    
    public void doExecute(HttpServletRequest request, HttpServletResponse response)
    	throws ServletException, IOException
    {
        try
        {            
        	Object requestObject = IOUtil.read(request.getInputStream());        	
        	
        	Object responseObject = invoke(requestObject, request, response); 
            
            IOUtil.write(response.getOutputStream(), responseObject);        	
        }
        catch (ClassNotFoundException e)
        {        	
        	e.printStackTrace();
        	throw new IOException(e.toString());            
        }
    }

    public Object invoke(Object requestObject, HttpServletRequest request, HttpServletResponse response)
    {
    	return null;
    }
}