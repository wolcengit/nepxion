package com.nepxion.cots.twaver.element;

/**
 * <p>Title: Nepxion Cots For TWaver</p>
 * <p>Description: Nepxion Cots Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * <p>Announcement: It depends on the commercial software of TWaver, the repository only references the trial version.</p>
 * <p>If you want to use Nepxion Cots, please contact with Serva Corporation to buy the genuine version.</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.awt.Color;

import twaver.Element;
import twaver.Group;
import twaver.TDataBox;
import twaver.TUIManager;
import twaver.TWaverConst;
import twaver.TWaverUtil;

public class TGroup
	extends Group implements TElement
{
	private boolean isMovable = true;
	private boolean isLeaf = false;
	private boolean isCategory = false;
	private boolean isSpecial = false;
	private boolean isDeletePermitted = true;
	
	public TGroup()
	{
		this("");
	}
	
	public TGroup(Object id)
	{
		super(id);
		
		initComponents();
	}
	
	public TGroup(String name)
	{
		this(name, false);
	}
	
	public TGroup(String name, boolean isExpand)
	{
		this(name, TGroupType.PARALLELOGRAM_GROUP_TYPE, isExpand);
	}
	
	public TGroup(String name, TGroupType groupType, boolean isExpand)
	{
		this(name, groupType.getType(), isExpand);
	}
	
	public TGroup(String name, int groupType, boolean isExpand)
	{
		super();
		
		setName(name);
		setGroupType(groupType);
		setExpand(isExpand);
		
		initComponents();
	}
	
	private void initComponents()
	{
		putClientProperty(TWaverConst.PROPERTYNAME_LABEL_YOFFSET, TWaverUtil.valueOf(4)); // 7
		
		putGroupAntialias(true);
		putGroupFill(true);
		putGroupFillColor(new Color(0, 0, 102, 255));
		putGroupGradient(true);
		putGroupDeep(10);
		putGroupGradientFactory(TWaverConst.GRADIENT_EXTEND_E);
		putGroup3D(true);
		putGroupAngle(45);
	}
	
	public boolean isMovable()
	{
		return isMovable;
	}
	
	public void setMovable(boolean isMovable)
	{
		this.isMovable = isMovable;
		
		if (this.isMovable)
		{
			removeAttachment("pin");
		}
		else
		{
			addAttachment("pin");
		}
	}
	
	public Element copy()
	{
		TGroup group = (TGroup) super.copy();
		
		copyProperty(group, true);
		
		return group;
	}
	
	public Element copy(Object id)
	{
		TGroup group = (TGroup) super.copy(id);
		
		copyProperty(group, true);
		
		return group;
	}
	
	public Element copy(TDataBox box)
	{
		TGroup group = (TGroup) super.copy(box);
		
		copyProperty(group, true);
		
		return group;
	}
	
	public Element copy(Object id, TDataBox box)
	{
		TGroup group = (TGroup) super.copy(id, box);
		
		copyProperty(group, true);
		
		return group;
	}
	
	public Element copyAll()
	{
		TGroup group = (TGroup) super.copy();
		
		copyProperty(group, false);
		group.setUserObject(getUserObject());
		
		return group;
	}
	
	private void copyProperty(TGroup group, boolean changeName)
	{
		if (changeName)
		{
			group.setName("复件 " + getName());
		}
	}
	
	// 子节点
	public boolean isLeaf()
	{
		return isLeaf;
	}
	
	public void setLeaf(boolean isLeaf)
	{
		this.isLeaf = isLeaf;
	}
	
	// 目录类型的节点
	public boolean isCategory()
	{
		return isCategory;
	}
	
	public void setCategory(boolean isCategory)
	{
		this.isCategory = isCategory;
	}
	
	// 特别作用的节点
	public boolean isSpecial()
	{
		return isSpecial;
	}
	
	public void setSpecial(boolean isSpecial)
	{
		this.isSpecial = isSpecial;
	}
	
	// 节点可删除
	public boolean isDeletePermitted()
	{
		return isDeletePermitted;
	}
	
	public void setDeletePermitted(boolean isDeletePermitted)
	{
		this.isDeletePermitted = isDeletePermitted;
	}
	
	// 捆绑Element ClientProperty和元数据属性，实现属性同步
	// 设置属性值，进行Element ClientProperty和元数据属性过滤
	public void putClientProperty(Object key, Object value)
	{
		if (TUIManager.isPredefinedClientPropertyKey(key.toString()))
		{
			super.putClientProperty(key, value);
		}
		else
		{
			putServiceClientProperty(key, value);
		}
	}
	
	public void putServiceClientProperty(Object key, Object value)
	{
	}
	
	// 捆绑Element ClientProperty和元数据属性，实现属性同步
	// 获取属性值，进行Element ClientProperty和元数据属性过滤
	public Object getClientProperty(Object key)
	{
		if (TUIManager.isPredefinedClientPropertyKey(key.toString()))
		{
			return super.getClientProperty(key);
		}
		else
		{
			return getServiceClientProperty(key);
		}
	}
	
	public Object getServiceClientProperty(Object key)
	{
		return null;
	}
	
	// 捆绑当名称改变时，触发Element UserObject里相对应的名称属性
	public void setName(String name)
	{
		super.setName(name);
		
		setServicecName(name);
	}
	
	public void setServicecName(String name)
	{
		
	}
	
	// 捆绑Element UserObject和VEntity对象
	public void setUserObject(Object userObject)
	{
		super.setUserObject(userObject);
		
		setServiceUserObject(userObject);
	}
	
	public void setServiceUserObject(Object userObject)
	{
	}
	
	public String toString()
	{
		return getName();
	}
}