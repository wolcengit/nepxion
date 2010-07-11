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

import com.nepxion.util.log.Logger;

public class ProxoolConnectionPool
	implements ProxoolConstants
{
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
			Logger.fatal(ProxoolConnectionPool.class, e);
			throw e;
		}
		catch (ClassNotFoundException e)
		{
			Logger.fatal(ProxoolConnectionPool.class, e);
			throw e;
		}
		return connection;
	}
}