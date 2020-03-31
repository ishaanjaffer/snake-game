/**
* Board.java
* @author Ishaan Jaffer
*/
import java.util.Scanner;
import java.lang.Math;
/**
* game board made of two-dimensional array of type Cell 
*/
public class Board
{
	private Cell[][] arr;
	public Board()
	{
		arr=new Cell[20][20];
		for(int i=0;i<20;i++)
		{
			for(int j=0;j<20;j++)
			{
				arr[i][j]=new Cell(i,j,"empty");
			}
		}
		randomFood();
	}
	/**
	* @param other copy constructor
	*/
	public Board(Board other)
	{
		arr=new Cell[20][20];
		for(int i=0;i<20;i++)
		{
			for(int j=0;j<20;j++)
			{
				arr[i][j]=new Cell(i,j,other.getBoard(i,j));
			}
		}
		randomFood();		
	}
	/**
	* @param row row
	* @param col column
	* @param info information (empty, snake, or food)
	*/
	public void setBoard(int row, int col, String info)
	{
		arr[row][col].setinfo(info);
	}
	/**
	* @param row row
	* @param col column
	* @return information stored (empty, snake, or food)
	*/
	public String getBoard(int row, int col)
	{

		return(arr[row][col].getinfo());
	}
	/**
	* @param row row
	* @param col column
	* @return symbol for information (' ' empty, '*' snake, or '$' food)
	*/
	public String display(int row, int col)
	{
		String val = "";
		if(getBoard(row,col).equals("empty"))
			val =" ";
		else if(getBoard(row,col).equals("snake"))
			val = "*";
		else if(getBoard(row,col).equals("food"))
			val = "$";
		return val;
	}
	/**
	* randomly generates food in empty cell
	*/
	public void randomFood()
	{
		boolean x=true;
		while(x)
		{
			int i=(int)(Math.random()*20);
			int j=(int)(Math.random()*20);
			if(arr[i][j].getinfo().equals("empty"))
			{
				arr[i][j].setinfo("food");
				x=false;
			}
		}
	}
	/**
	* @return 20x20 board, with ( ) representing each cell
	*/
	public String toString()
	{
		String x="";
		for(int i=0;i<20;i++)
		{
			for(int j=0;j<20;j++)
				x+=("("+display(i,j)+")");
			x+="\n";
		}
		return x;
	}
	/**
	* @param other type Board
	* @return true/false if 'arr' board is or isn't the same as 'other' board
	*/
	public boolean equals(Board other)
	{
		for(int i=0;i<20;i++)
		{
			for(int j=0;j<20;j++)
			{
				if(!arr[i][j].getinfo().equals(other.getBoard(i,j)))
					return false;
			}
		}
		return true;
	}

}