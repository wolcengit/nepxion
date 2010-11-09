package com.nepxion.swing.button;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.SwingUtilities;

public class JBasicSplitButton
    extends JBasicMenuButton
{
	public JBasicSplitButton()
    {
        super();
        
        initComponents();
    }

    public JBasicSplitButton(Action action)
    {
        super(action);
        
        initComponents();
    }

    public JBasicSplitButton(String text)
    {
        super(text);
        
        initComponents();
    }

    public JBasicSplitButton(Icon icon)
    {
        super(icon);
        
        initComponents();
    }
    
    public JBasicSplitButton(Icon icon, String toolTipText)
    {
        super(icon);
               
        initComponents();
        
        setToolTipText(toolTipText);        
    }    
    
    public JBasicSplitButton(String text, String toolTipText)
    {
        super(text);
               
        initComponents();
        
        setToolTipText(toolTipText);        
    }       
    
    public JBasicSplitButton(String text, Icon icon, String toolTipText)
    {
        super(text, icon);
               
        initComponents();
        
        setToolTipText(toolTipText);        
    }     

    public JBasicSplitButton(String text, Icon icon)
    {
        super(text, icon);
        
        initComponents();
    }
    
    private void initComponents()
    {
    	widthInset += 3;
    }    

    public void mousePressed(MouseEvent e)
    {
        BasicButtonModel buttonModel = (BasicButtonModel) getModel();
        if (!buttonModel.isEnabled())
        {
            return;
        }

        if (SwingUtilities.isLeftMouseButton(e) && e.getX() > getSize().width - 13 && e.getX() < getSize().width)
        {
            if (popupMenu != null)
            {
                popupMenu.show(this, 0, getSize().height);
            }
            buttonModel.setActionButtonPressed(false);
        }
        else
        {
            buttonModel.setActionButtonPressed(true);
        }
    }

    protected void fireActionPerformed(ActionEvent e)
    {
        BasicButtonModel buttonModel = (BasicButtonModel) getModel();
        if (buttonModel.isActionButtonPressed())
        {
            super.fireActionPerformed(e);
        }
    }
}