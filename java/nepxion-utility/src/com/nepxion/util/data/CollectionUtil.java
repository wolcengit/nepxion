package com.nepxion.util.data;

/**
 * <p>Title: Nepxion Utility</p>
 * <p>Description: Nepxion Utility Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune хн╨ф╬Э
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class CollectionUtil
{
	public static List parseList(Object[] array)
	{
		return Arrays.asList(array);
	}
	
	public static Object[] parseArray(List list)
	{
		return list.toArray();
	}	
	
	public static Vector parseVector(Object[] array)
	{
		return new Vector(Arrays.asList(array));
	}
	
	public static Vector parseVector(List list)
	{
		return new Vector(list);
	}
	
	public static Object[] parseArray(Vector vector)
	{
		return vector.toArray();
	}	
}
