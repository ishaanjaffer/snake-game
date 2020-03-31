/**
* Snake.java
* @author Ishaan Jaffer
*/
import java.util.Scanner;
/**
* snake containing row and column
*/
public class Snake
{
	private int row,col;
	/**
	* @param r row
	* @param c column
	*/
	public Snake(int r, int c)
	{
		row=r;
		col=c;
	}
	/**
	* @param other copy constructor
	*/
	public Snake(Snake other)
	{
		row=other.row;
		col=other.col;
	}
	/**
	* @param r row
	*/
	public void setRow(int r)
	{
		row=r;
	}
	/**
	* @param c column
	*/
	public void setCol(int c)
	{
		col=c;
	}
	/**
	* @return row
	*/
	public int getRow()
	{
		return row;
	}
	/**
	* @return column
	*/
	public int getCol()
	{
		return col;
	}
	/**
	* @return String representation of row and column of snake
	*/
	public String toString()
	{
		return("Row: " + row + "; Column: " + col);
	}
	/**
	* @param other type Snake
	* @return true or false if 'this' snake's parts are or aren't the same as the 'other'
	*/
	public boolean equals(Snake other)
	{
		return((row==other.row)&&(col==other.col));
	}

}