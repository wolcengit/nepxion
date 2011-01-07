package com.nepxion.util.database.pool.proxool;

/**
 * <p>Title: Nepxion Utility</p>
 * <p>Description: Nepxion Utility Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ProxoolConnectionPool
	implements ProxoolConstants
{
	private static Log log = LogFactory.getLog(ProxoolConnectionPool.class);
	
	public static Connection getDefaultConnection()
		throws SQLException, ClassNotFoundException
	{
		return getConnection(DEFAULT_ALIAS);
	}
	
	public static Connection getConnection(String alias)
		throws SQLException, ClassNotFoundException
	{
		Connection connection = null;
		try
		{
			Class.forName(PROXOOL_DRIVER);
			connection = DriverManager.getConnection(PREFIX + alias);
		}
		catch (SQLException e)
		{
			log.fatal(e);
			throw e;
		}
		catch (ClassNotFoundException e)
		{
			log.fatal(e);
			throw e;
		}
		
		return connection;
	}
}