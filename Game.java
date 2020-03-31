/**
* Cell.java
* @author Ishaan Jaffer
*/
import java.util.ArrayList;
import java.util.Scanner;
/**
* game containing board of Board and snake of ArrayList type Snake
*/
public class Game
{
	private Board board;
	private ArrayList<Snake> snake;

	public Game()
	{
		board=new Board();
		snake=new ArrayList<Snake>();
	}
	/**
	* @param b board
	* @param s ArrayList of type Snake
	*/
	public Game(Board b, ArrayList<Snake> s)
	{
		board=b;
		snake=s;
	}
	/**
	* @param other copy constructor
	*/
	public Game(Game other)
	{
		board=other.board;
		snake=other.snake;
	}
	/**
	* @param b board
	*/
	public void setGB(Board b)
	{
		board=b;
	}
	/**
	* @param s ArrayList of type Snake
	*/
	public void setSnake(ArrayList<Snake> s)
	{
		snake.clear();
		for(int i=0;i<s.size();i++)
			snake.add(s.get(i));
	}
	/**
	* @return board
	*/
	public Board getGB()
	{
		return board;
	}
	/**
	* @return ArrayList of type Snake
	*/
	public ArrayList<Snake> getSnake()
	{
		return snake;
	}
	/**
	* @return String representation of board and snake
	*/
	public String toString()
	{
		return("Board: " + board + "\nSnake: " + snake);
	}
	/**
	* @param other type Game
	* @return true or false if this games parts are or aren't the same as the other
	*/
	public boolean equals(Game other)
	{
		boolean x=true;
		if(snake.size()==other.snake.size())
		{
			for(int i=0;i<snake.size();i++)
			{
				if((snake.get(i).equals(other.snake.get(i))))
					x=true;
				else
					x=false;
			}
		}
		else
			x=false;
		return(x&&(board.equals(other.board)));
	}
	/**
	* @param row row
	* @param col column
	* @param s ArrayList of type Snake
	* @param bool boolean variable
	* @return true or false based on whether or not the snake crosses itself
	*/
	public boolean endGame(int row, int col, ArrayList<Snake> s, boolean bool)
	{
		for(Snake x:s)
		{
			if((row==x.getRow()&&(col==x.getCol())))
				bool=true;
		}
		return bool;
	}
	/**
	* @param row row
	* @param col column
	* @param s ArrayList of type Snake
	* @param board board
	* moves the snake in given direction
	*/
	public void moveSnake(int row, int col, ArrayList<Snake> s, Board board)
	{
		s.add(0,new Snake(row,col));
		board.setBoard(row,col,"snake");
		board.setBoard(s.get(s.size()-1).getRow(),s.get(s.size()-1).getCol(),"empty");
		s.remove(s.size()-1);
	}
	/**
	* @param row row
	* @param col column
	* @param s ArrayList of type Snake
	* @param board board
	* @param food boolean variable
	* @return true or false if food is or isn't present in given cell
	*/
	public boolean foodCheck(int row, int col, ArrayList<Snake> s, Board board,  boolean food)
	{
		if(board.getBoard(row,col).equals("food"))
		{
			s.add(0,new Snake(row,col));
			board.setBoard(row,col,"snake");
			board.randomFood();
			food=true;
		}
		else
			food=false;
		return food;
	}
	/**
    * prints snake game instructions and prompts user to enter letter representing direction ('w', 's', 'a', 'd')
    * ends when snake crosses itself; user's score is length of the snake
    * @param args main method
    */ 
	public static void main(String[] args)
	{
		Scanner Input=new Scanner(System.in);
		Board gameboard =new Board();
		ArrayList<Snake> gamesnake =new ArrayList<Snake>();
		Game game =new Game(gameboard,gamesnake);
		System.out.println("\nWelcome to the Snake Game!\n");
		System.out.println("The snake (*) starts at the top left corner and can move in any direction.\nWhen it eats the food ($), the length of the snake increases.\nWhen the snake crosses itself, the game will end.");
		System.out.println("To move up, down, left, or right, use the following keys: \n");
		System.out.println("     [ w ]             [ ^ ]");
		System.out.println("[ a ][ s ][ d ]   [ < ][ v ][ > ]\n\n");
		game.getSnake().add(new Snake(0,0));
		game.getGB().setBoard(0,0,"snake");
		System.out.println(game.getGB());
		int score=1;
		int headrow=0;
		int headcol=0;
		boolean again=false;
		boolean food=false;
		while(!(again))
		{
			System.out.println("Enter direction ('w', 's', 'a', 'd'): ");
			String user=Input.nextLine();

			int row=0,col=0;
			try
			{
				if(!((user.equalsIgnoreCase("w")|| user.equalsIgnoreCase("s")|| user.equalsIgnoreCase("a")|| user.equalsIgnoreCase("d"))))
					throw new Exception("Please enter 'w', 's', 'a', or 'd'. See instructions for additional help.");
				if(user.equalsIgnoreCase("w"))
				{
					row=headrow-1;
					col=headcol;
				}
				else if(user.equalsIgnoreCase("s"))
				{
					row=headrow+1;
					col=headcol;
				}
				else if(user.equalsIgnoreCase("a"))
				{
					row=headrow;
					col=headcol-1;
				}
				else if(user.equalsIgnoreCase("d"))
				{
					row=headrow;
					col=headcol+1;
				}
				if((game.endGame(row,col,game.getSnake(),again)))
				{
					again=true;
					break;
				}
				else if(game.foodCheck(row,col,game.getSnake(),game.getGB(),food))
				{
					food=true;
					score++;
					headrow=row;
					headcol=col;
				}
				else
				{
					game.moveSnake(row,col,game.getSnake(),game.getGB());
					headrow=row;
					headcol=col;
				}
				food=false;
				System.out.println(game.getGB());  
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage()); 
			}	
		}
		System.out.println("Ah shucks, game over! Score: " + score);
	}
}