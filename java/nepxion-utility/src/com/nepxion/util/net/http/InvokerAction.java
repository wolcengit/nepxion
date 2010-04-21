package com.nepxion.util.net.http;

/**
 * <p>Title: Nepxion Utility</p>
 * <p>Description: Nepxion Utility Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

public abstract class InvokerAction
{
    private InvokerHandle invokerHandle;

    public InvokerHandle getInvokerHandle()
    {
        return invokerHandle;
    }

    public void setInvokerHandle(InvokerHandle invokerHandle)
    {
        this.invokerHandle = invokerHandle;
    }

    public abstract Object execute();
}