package com.nepxion.swing.daytip;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.util.Collection;

import com.l2fprod.common.swing.tips.DefaultTipModel;

public class TipModel
    extends DefaultTipModel
{
    public TipModel()
    {
        super();
    }

    public TipModel(TipModel.Tip[] tips)
    {
        super(tips);
    }

    public TipModel(Collection tips)
    {
        super(tips);
    }
}