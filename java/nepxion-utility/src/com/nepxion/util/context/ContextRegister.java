package com.nepxion.util.context;

/**
 * <p>Title: Nepxion Utility</p>
 * <p>Description: Nepxion Utility Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.net.URL;
import java.util.Properties;

import com.nepxion.util.database.pool.proxool.ProxoolContext;
import com.nepxion.util.encoder.EncoderConstants;
import com.nepxion.util.encoder.EncoderContext;
import com.nepxion.util.io.FileContext;
import com.nepxion.util.locale.LocaleContext;
import com.nepxion.util.log.LoggerContext;
import com.nepxion.util.net.http.HttpContext;
import com.nepxion.util.net.url.URLContext;
import com.nepxion.util.scheduler.quartz.QuartzContext;
import com.nepxion.util.searcher.ip.local.IPContext;
import com.nepxion.util.searcher.zone.local.ZoneConstants;

public class ContextRegister
	extends AbstractContextRegister implements ContextConstants
{
	/**
	 * The instance of Properties.
	 */
	protected Properties properties;
	
	/**
	 * The instance of URL.
	 */
	protected URL codeBase;
	
	/**
	 * Registers the context by a properties of context file.
	 * The context file is a native file.
	 * @param properties the instance of Properties
	 */
	public void initializeContext(Properties properties)
	{
		initializeContext(null, properties);
	}
	
	/**
	 * Registers the context by an url and properties of context file.
	 * The context file is a remote file.
	 * @param codeBase the instance of URL
	 * @param properties the instance of Properties
	 */
	public void initializeContext(URL codeBase, Properties properties)
	{
		this.properties = properties;
		this.codeBase = codeBase;
		
		initEncoder();
		initLocale();
		initLogger();
		initHttp();
		initURL();
		initProxool();
		initQuartz();
		initIp();
		initZone();
	}
	
	/**
	 * Initialize for the encoder config.
	 * The encoder config includes the io charset and http charset.
	 */
	private void initEncoder()
	{
		String ioCharset = properties.getProperty("ioCharset");
		if (!isValid(ioCharset))
		{
			ioCharset = EncoderConstants.DEFAULT_CHARSET;
		}
		
		String httpCharset = properties.getProperty("httpCharset");
		if (!isValid(httpCharset))
		{
			httpCharset = EncoderConstants.DEFAULT_CHARSET;
		}
		
		EncoderContext.registerIOCharset(ioCharset);
		EncoderContext.registerHttpCharset(httpCharset);
	}
	
	/**
	 * Initialize for the locale config.
	 */
	private void initLocale()
	{
		String locale = properties.getProperty("locale");
		if (isValid(locale))
		{
			LocaleContext.registerLocale(locale);
		}
	}
	
	/**
	 * Initialize for the logger config.
	 */
	private void initLogger()
	{
		String loggerEnabled = properties.getProperty("logger-3rd-enabled");
		
		boolean isLoggerEnabled = false;
		
		if (isValid(loggerEnabled))
		{
			isLoggerEnabled = loggerEnabled.equals("true");
		}
		
		if (isLoggerEnabled)
		{
			try
			{
				if (codeBase == null)
				{
					LoggerContext.register();
				}
				else
				{
					LoggerContext.register(codeBase);
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Initialize for the http config.
	 */
	private void initHttp()
	{
		String httpEnabled = properties.getProperty("http-3rd-enabled");
		
		boolean isHttpEnabled = false;
		
		if (isValid(httpEnabled))
		{
			isHttpEnabled = httpEnabled.equals("true");
		}
		
		if (isHttpEnabled)
		{
			try
			{
				if (codeBase == null)
				{
					HttpContext.register();
				}
				else
				{
					HttpContext.register(codeBase);
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Initialize for the url config.
	 */
	private void initURL()
	{
		String urlEnabled = properties.getProperty("url-3rd-enabled");
		
		boolean isURLEnabled = false;
		
		if (isValid(urlEnabled))
		{
			isURLEnabled = urlEnabled.equals("true");
		}
		
		if (isURLEnabled)
		{
			try
			{
				if (codeBase == null)
				{
					URLContext.register();
				}
				else
				{
					URLContext.register(codeBase);
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Initialize for the proxool config.
	 */
	private void initProxool()
	{
		String proxoolEnabled = properties.getProperty("proxool-3rd-enabled");
		
		boolean isProxoolEnabled = false;
		
		if (isValid(proxoolEnabled))
		{
			isProxoolEnabled = proxoolEnabled.equals("true");
		}
		
		if (isProxoolEnabled)
		{
			try
			{
				if (codeBase == null)
				{
					ProxoolContext.register();
				}
				else
				{
					ProxoolContext.register(codeBase);
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Initialize for the quartz config.
	 */
	private void initQuartz()
	{
		String quartzEnabled = properties.getProperty("quartz-3rd-enabled");
		
		boolean isQuartzEnabled = false;
		
		if (isValid(quartzEnabled))
		{
			isQuartzEnabled = quartzEnabled.equals("true");
		}
		
		if (isQuartzEnabled)
		{
			try
			{
				if (codeBase == null)
				{
					QuartzContext.register();
				}
				else
				{
					QuartzContext.register(codeBase);
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Initialize for the ip config.
	 */
	private void initIp()
	{
		String ipEnabled = properties.getProperty("ip-3rd-enabled");
		
		boolean isIpEnabled = false;
		
		if (isValid(ipEnabled))
		{
			isIpEnabled = ipEnabled.equals("true");
		}
		
		if (isIpEnabled)
		{
			try
			{
				if (codeBase == null)
				{
					IPContext.register();
				}
				else
				{
					IPContext.register(codeBase);
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Initialize for the zone config.
	 */
	private void initZone()
	{
		String zoneEnabled = properties.getProperty("zone-3rd-enabled");
		
		boolean isZoneEnabled = false;
		
		if (isValid(zoneEnabled))
		{
			isZoneEnabled = zoneEnabled.equals("true");
		}
		
		if (isZoneEnabled)
		{
			try
			{
				if (codeBase == null)
				{
					FileContext.register(ZoneConstants.CONFIG_FILE_PATH);
				}
				else
				{
					FileContext.register(codeBase, ZoneConstants.CONFIG_FILE_PATH);
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Returns true if the content valid.
	 * @param content the string
	 * @return true if the content valid
	 */
	public boolean isValid(String content)
	{
		return content != null && !content.trim().equals("");
	}
}