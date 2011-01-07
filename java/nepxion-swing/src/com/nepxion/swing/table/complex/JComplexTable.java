package com.nepxion.swing.table.complex;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import org.jdesktop.swingx.JXTable;
import org.jdesktop.swingx.decorator.HighlighterFactory;

import com.nepxion.swing.table.ITable;
import com.nepxion.swing.table.TableManager;

public class JComplexTable
	extends JXTable implements ITable, MouseListener
{
	private int selectedRow = -1;
	
	public JComplexTable()
	{
		super();
		
		initComponents();
	}
	
	public JComplexTable(TableModel dm)
	{
		super(dm);
		
		initComponents();
	}
	
	public JComplexTable(TableModel dm, TableColumnModel cm)
	{
		super(dm, cm);
		
		initComponents();
	}
	
	public JComplexTable(TableModel dm, TableColumnModel cm, ListSelectionModel sm)
	{
		super(dm, cm, sm);
		
		initComponents();
	}
	
	public JComplexTable(int numRows, int numColumns)
	{
		super(numRows, numColumns);
		
		initComponents();
	}
	
	public JComplexTable(Vector rowData, Vector columnNames)
	{
		super(rowData, columnNames);
		
		initComponents();
	}
	
	public JComplexTable(Object[][] rowData, Object[] columnNames)
	{
		super(rowData, columnNames);
		
		initComponents();
	}
	
	private void initComponents()
	{
		TableManager.setPreferenceStyle(this);
		
		addMouseListener(this);
		getSelectionModel().addListSelectionListener(this);
		
		addHighlighter(HighlighterFactory.createSimpleStriping()); 		
	}
	
	public int getSelectionMode()
	{
		return TableManager.getSelectionMode(this);
	}
	
	public void setSelectionMode(int mode)
	{
		TableManager.setSelectionMode(this, mode);
	}
	
	public void valueChanged(ListSelectionEvent e)
	{
		super.valueChanged(e);
		
		boolean isAdjusting = e.getValueIsAdjusting();
		if (isAdjusting)
		{
			if (getSelectedRow() == selectedRow)
			{
				return;
			}
			
			selectedRow = getSelectedRow();
			
			executeSelection(selectedRow);
		}
	}
	
	public void executeSelection(int selectedRow)
	{
		
	}
	
	public void mouseClicked(MouseEvent e)
	{
		int selectedRow = getSelectedRow();
		executeClicked(selectedRow, e);
	}
	
	public void executeClicked(int selectedRow, MouseEvent e)
	{
		if (e.getClickCount() > 1)
		{
			executeDoubleClicked(selectedRow);
		}
		else
		{
			executeClicked(selectedRow);
		}
	}
	
	public void executeClicked(int selectedRow)
	{
		
	}
	
	public void executeDoubleClicked(int selectedRow)
	{
		
	}
	
	public void mouseEntered(MouseEvent e)
	{
		
	}
	
	public void mouseExited(MouseEvent e)
	{
		
	}
	
	public void mousePressed(MouseEvent e)
	{
		
	}
	
	public void mouseReleased(MouseEvent e)
	{
		if (!e.isPopupTrigger())
		{
			return;
		}
		
		int x = e.getX();
		int y = e.getY();
		
		int selectedRow = getSelectedRow();
		if (selectedRow > -1)
		{
			executePopupMenu(selectedRow, x, y);
		}
		else
		{
			executePopupMenu(x, y);
		}
	}
	
	public void executePopupMenu(int selectedRow, int x, int y)
	{
		
	}
	
	public void executePopupMenu(int x, int y)
	{
		
	}
}