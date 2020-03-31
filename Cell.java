/**
* Cell.java
* @author Ishaan Jaffer
*/

import java.util.Scanner;
/**
* cell containing row, column, and information (empty, snake, or food)
*/
public class Cell
{
	private int row, col;
	private String info;
	/**
	* @param r row
	* @param c column
	* @param i information (empty, snake, or food)
	*/
	public Cell(int r, int c, String i)
	{
		row=r;
		col=c;
		info=i;
	}
	/**
	* @param other copy constructor
	*/
	public Cell(Cell other)
	{
		row=other.row;
		col=other.col;
		info=other.info;
	}
	/**
	* @param r row
	*/
	public void setrow(int r)
	{
		row=r;
	}
	/**
	* @param c column
	*/
	public void setcol(int c)
	{
		col=c;
	}
	/**
	* @param i information (empty, snake, or food)
	*/
	public void setinfo(String i)
	{
		info=i;
	}
	/**
	* @return row
	*/
	public int getrow()
	{
		return row;
	}
	/**
	* @return column
	*/
	public int getcol()
	{
		return col;
	}
	/**
	* @return information (empty, snake, or food)
	*/
	public String getinfo()
	{
		return info;
	}
	/**
	* @return String representation of row, column, and info (empty, snake, or food)
	*/
	public String toString()
	{
		return("Row: " + row + "; Column: " + col + "; Info: " + info);
	}
	/**
	* @param other type Cell
	* @return true or false if 'this' cell's parts are or aren't the same as the 'other'
	*/
	public boolean equals(Cell other)
	{
		return((this.row==other.row)&&(this.col==other.col)&&(this.info.equals(other.info)));
	}
}