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

import java.awt.Component;
import java.awt.Insets;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import com.nepxion.swing.border.ButtonBorder;
import com.nepxion.swing.icon.paint.ArrowIcon;
import com.nepxion.swing.lookandfeel.LookAndFeelManager;

/**
 * A table cell renderer for table headings - uses one of three JButton
 * instances to indicate the sort order for the table column.
 */
public class SortButtonRenderer
	implements TableCellRenderer, SwingConstants
{
	/**
	 * Useful constant indicating NO sorting.
	 */
	public static final int NONE = 0;
	
	/**
	 * Useful constant indicating ASCENDING (that is, arrow pointing down)
	 * sorting in the table.
	 */
	public static final int DOWN = 1;
	
	/**
	 * Useful constant indicating DESCENDING (that is, arrow pointing up)
	 * sorting in the table.
	 */
	public static final int UP = 2;
	
	/**
	 * The current pressed column (-1 for no column).
	 */
	private int pressedColumn = -1;
	
	/**
	 * The three buttons that are used to render the table header cells.
	 */
	private JButton normalButton;
	
	/**
	 * The three buttons that are used to render the table header cells.
	 */
	private JButton ascendingButton;
	
	/**
	 * The three buttons that are used to render the table header cells.
	 */
	private JButton descendingButton;
	
	/**
	 * Used to allow the class to work out whether to use the buttuns or labels.
	 * Labels are required when using the aqua look and feel cos the buttons
	 * won't fit.
	 */
	private boolean useLabels;
	
	/**
	 * The normal label (only used with MacOSX).
	 */
	private JLabel normalLabel;
	
	/**
	 * The ascending label (only used with MacOSX).
	 */
	private JLabel ascendingLabel;
	
	/**
	 * The descending label (only used with MacOSX).
	 */
	private JLabel descendingLabel;
	
	/**
	 * Creates a new button renderer.
	 */
	public SortButtonRenderer()
	{
		this.pressedColumn = -1;
		this.useLabels = LookAndFeelManager.isNimbusLookAndFeel() || LookAndFeelManager.isAquaLookAndFeel();

		final Icon northArrowIcon = new ArrowIcon(4, NORTH); // new ArrowEtchedIcon(NORTH);
		final Icon southArrowIcon = new ArrowIcon(4, SOUTH); // new ArrowEtchedIcon(SOUTH);
		// final Color background = UIManager.getColor("Panel.background");
		
		if (this.useLabels)
		{
			final Border border = new ButtonBorder(ButtonBorder.BORDER_RAISED);
			
			this.normalLabel = new JLabel();
			this.normalLabel.setBorder(border);
			this.normalLabel.setHorizontalAlignment(CENTER);
			
			this.ascendingLabel = new JLabel();
			this.ascendingLabel.setHorizontalAlignment(CENTER);
			this.ascendingLabel.setHorizontalTextPosition(LEFT);
			this.ascendingLabel.setIcon(northArrowIcon);
			this.ascendingLabel.setBorder(border);
			this.ascendingLabel.setIconTextGap(8);
			
			this.descendingLabel = new JLabel();
			this.descendingLabel.setHorizontalAlignment(CENTER);
			this.descendingLabel.setHorizontalTextPosition(LEFT);
			this.descendingLabel.setIcon(southArrowIcon);
			this.descendingLabel.setBorder(border);
			this.descendingLabel.setIconTextGap(8);
		}
		else
		{
			final Insets insets = new Insets(0, 0, 0, 0);
			final Border border = UIManager.getBorder("TableHeader.cellBorder");
			
			this.normalButton = new JButton();	
			this.normalButton.setMargin(insets);
			this.normalButton.setBorder(border);
			//this.normalButton.setBackground(background);
			
			this.ascendingButton = new JButton();
			this.ascendingButton.setHorizontalTextPosition(LEFT);
			this.ascendingButton.setIcon(northArrowIcon);
			this.ascendingButton.setPressedIcon(northArrowIcon);
			this.ascendingButton.setMargin(insets);
			this.ascendingButton.setBorder(border);
			this.ascendingButton.setIconTextGap(8);
			//this.ascendingButton.setBackground(background);
			
			this.descendingButton = new JButton();
			this.descendingButton.setHorizontalTextPosition(LEFT);
			this.descendingButton.setIcon(southArrowIcon);
			this.descendingButton.setPressedIcon(southArrowIcon);
			this.descendingButton.setMargin(insets);
			this.descendingButton.setBorder(border);
			this.descendingButton.setIconTextGap(8);
			//this.descendingButton.setBackground(background);
		}
	}
	
	/**
	 * Returns the renderer component.
	 * @param table the table.
	 * @param value the value.
	 * @param isSelected selected?
	 * @param hasFocus focussed?
	 * @param row the row.
	 * @param column the column.
	 * @return the renderer.
	 */
	public Component getTableCellRendererComponent(final JTable table, final Object value, final boolean isSelected, final boolean hasFocus, final int row, final int column)
	{		
		if (table == null)
		{
			throw new NullPointerException("Table can't be null");
		}
		
		final JComponent component;
		final SortableTableModel model = (SortableTableModel) table.getModel();
		final int cc = table.convertColumnIndexToModel(column);
		final boolean isSorting = (model.getSortingColumn() == cc);
		final boolean isAscending = model.isAscending();
		
		final JTableHeader header = table.getTableHeader();
		final boolean isPressed = (cc == this.pressedColumn);
		
		if (this.useLabels)
		{
			final JLabel label = getRendererLabel(isSorting, isAscending);
			label.setText((value == null) ? "" : value.toString());
			component = label;
		}
		else
		{
			final JButton button = getRendererButton(isSorting, isAscending);
			button.setText((value == null) ? "" : value.toString());
			button.getModel().setPressed(isPressed);
			button.getModel().setArmed(isPressed);
			component = button;
		}
		
		if (header != null)
		{
			component.setForeground(header.getForeground());
			component.setBackground(header.getBackground());
			component.setFont(header.getFont());
		}
		
		return component;
	}
	
	/**
	 * Returns the correct button component.
	 * @param isSorting whether the render component represents the sort column.
	 * @param isAscending whether the model is ascending.
	 * @return either the ascending, descending or normal button.
	 */
	private JButton getRendererButton(final boolean isSorting, final boolean isAscending)
	{
		if (isSorting)
		{
			if (isAscending)
			{
				return this.ascendingButton;
			}
			else
			{
				return this.descendingButton;
			}
		}
		else
		{
			return this.normalButton;
		}
	}
	
	/**
	 * Returns the correct label component.
	 * @param isSorting whether the render component represents the sort column.
	 * @param isAscending whether the model is ascending.
	 * @return either the ascending, descending or normal label.
	 */
	private JLabel getRendererLabel(final boolean isSorting, final boolean isAscending)
	{
		if (isSorting)
		{
			if (isAscending)
			{
				return this.ascendingLabel;
			}
			else
			{
				return this.descendingLabel;
			}
		}
		else
		{
			return this.normalLabel;
		}
	}
	
	/**
	 * Sets the pressed column.
	 * @param column the column.
	 */
	public void setPressedColumn(final int column)
	{
		this.pressedColumn = column;
	}	
}