package com.nepxion.swing.table.sortable;

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
import java.awt.event.MouseMotionListener;
import javax.swing.table.JTableHeader;

/**
 * Captures mouse clicks on a table header, with the intention of triggering a
 * sort.
 */
public class SortableTableHeaderListener
	implements MouseListener, MouseMotionListener
{
	
	/** A reference to the table model. */
	private SortableTableModel model;
	
	/** The header renderer. */
	private SortButtonRenderer renderer;
	
	/**
	 * The index of the column that is sorted - used to determine the state of
	 * the renderer.
	 */
	private int sortColumnIndex;
	
	/**
	 * Standard constructor.
	 * @param model the model.
	 * @param renderer the renderer.
	 */
	public SortableTableHeaderListener(final SortButtonRenderer renderer)
	{
		this(null, renderer);
	}
	
	/**
	 * Standard constructor.
	 * @param model the model.
	 * @param renderer the renderer.
	 */
	public SortableTableHeaderListener(final SortableTableModel model, final SortButtonRenderer renderer)
	{
		this.model = model;
		this.renderer = renderer;
	}
	
	/**
	 * Sets the table model for the listener.
	 * @param model the model.
	 */
	public void setTableModel(final SortableTableModel model)
	{
		this.model = model;
	}
	
	/**
	 * Handle a mouse press event - if the user is NOT resizing a column and NOT
	 * dragging a column then give visual feedback that the column header has
	 * been pressed.
	 * @param e the mouse event.
	 */
	public void mousePressed(final MouseEvent e)
	{		
		final JTableHeader header = (JTableHeader) e.getComponent();
		
		if (header.getResizingColumn() == null)
		{ // resizing takes precedence over sorting
			if (header.getDraggedDistance() < 1)
			{ // dragging also takes precedence over sorting
				final int columnIndex = header.columnAtPoint(e.getPoint());
				final int modelColumnIndex = header.getTable().convertColumnIndexToModel(columnIndex);
				if (this.model.isSortable(modelColumnIndex))
				{
					this.sortColumnIndex = header.getTable().convertColumnIndexToModel(columnIndex);
					this.renderer.setPressedColumn(this.sortColumnIndex);
					header.repaint();
					if (header.getTable().isEditing())
					{
						header.getTable().getCellEditor().stopCellEditing();
					}
				}
				else
				{
					this.sortColumnIndex = -1;
				}
			}
		}
		
	}
	
	/**
	 * If the user is dragging or resizing, then we clear the sort column.
	 * @param e the mouse event.
	 */
	public void mouseDragged(final MouseEvent e)
	{		
		final JTableHeader header = (JTableHeader) e.getComponent();
		
		if ((header.getDraggedDistance() > 0) || (header.getResizingColumn() != null))
		{
			this.renderer.setPressedColumn(-1);
			this.sortColumnIndex = -1;
		}
	}
	
	/**
	 * This event is ignored (not required).
	 * @param e the mouse event.
	 */
	public void mouseEntered(final MouseEvent e)
	{
		// not required
	}
	
	/**
	 * This event is ignored (not required).
	 * @param e the mouse event.
	 */
	public void mouseClicked(final MouseEvent e)
	{
		// not required
	}
	
	/**
	 * This event is ignored (not required).
	 * @param e the mouse event.
	 */
	public void mouseMoved(final MouseEvent e)
	{
		// not required
	}
	
	/**
	 * This event is ignored (not required).
	 * @param e the mouse event.
	 */
	public void mouseExited(final MouseEvent e)
	{
		// not required
	}
	
	/**
	 * When the user releases the mouse button, we attempt to sort the table.
	 * @param e the mouse event.
	 */
	public void mouseReleased(final MouseEvent e)
	{		
		final JTableHeader header = (JTableHeader) e.getComponent();	
		
		if (header.getResizingColumn() == null)
		{ // resizing takes precedence over sorting
			if (this.sortColumnIndex != -1)
			{
				final SortableTableModel model = (SortableTableModel) header.getTable().getModel();
				final int columnIndex = model.getSortingColumn();				
				boolean ascending = true;
				if (this.sortColumnIndex == columnIndex)
				{	
					ascending = !model.isAscending();
				}
				model.setAscending(ascending);
				model.sort(this.sortColumnIndex, ascending);
				
				this.renderer.setPressedColumn(-1); // clear
				header.repaint();
			}
		}
	}
}