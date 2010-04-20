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

import java.io.*;

public class CloneUtil
{
    public static Object getClone(Object object)
    {
        Object cloneObject = null;
        try
        {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
            ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()));
            cloneObject = ois.readObject();
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
            return null;
        }
        catch (ClassNotFoundException ex)
        {
            ex.printStackTrace();
            return null;
        }
        return cloneObject;
    }
}