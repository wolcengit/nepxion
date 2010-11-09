package com.nepxion.swing.wizard;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import javax.swing.Icon;
import javax.swing.JComponent;

public abstract class JStep
{
	private String title;
	private Icon image;
	private JComponent content;
	
	public JStep(String title)
	{
		this(title, null, null);
	}
	
	public JStep(String title, JComponent content)
	{
		this(title, null, content);
	}
	
	public JStep(String title, Icon image)
	{
		this(title, image, null);
	}
	
	public JStep(String title, Icon image, JComponent content)
	{
		this.title = title;
		this.image = image;
		this.content = content;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public Icon getImage()
	{
		return image;
	}
	
	public void setImage(Icon image)
	{
		this.image = image;
	}
	
	public JComponent getContent()
	{
		return content;
	}
	
	public void setContent(JComponent content)
	{
		this.content = content;
	}
	
	public abstract boolean confirm();
	
	public abstract boolean cancel();
	
	public abstract boolean previous();
	
	public abstract boolean next();
	
	public String toString()
	{
		return getTitle();
	}
}