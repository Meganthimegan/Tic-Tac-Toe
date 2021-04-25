package Service;

import java.util.Scanner;

import Entities.Player;

public abstract class basicMode implements PlayerMode {

	private char grid[][];
	
	private Player player1,player2;
	
	private int count;
	
	private int row_length,col_length;
	
	public basicMode(Player player1, Player player2, int rwo_length, int col_length) {
		super();
		this.player1 = player1;
		this.player2 = player2;
		this.row_length = rwo_length;
		this.col_length = col_length;
	}
	
	public char[][] getGrid() {
		return grid;
	}
	
	public void setGrid(char[][] grid) {
		this.grid = grid;
	}

	public Player getPlayer1() {
		return player1;
	}

	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getRow_length() {
		return row_length;
	}

	public void setRow_length(int row_length) {
		this.row_length = row_length;
	}

	public int getCol_length() {
		return col_length;
	}

	public void setCol_length(int col_length) {
		this.col_length = col_length;
	}

	@Override
	public String play(char[][] grid) {
		
		return null;
	}

	protected boolean playYourTurn(Player player)
	{
		System.out.println("\n"+player.getName()+" play your turn");
		int cell[]=getRowAndCol();
		
		//assigns sign to that cell
		grid[cell[0]][cell[1]]=player.getSign();
		
		//decreases empty cell count
		count--;
		printGrid();
		
		//check for 3 consecutive matches
		if(checkRow(cell[0],player.getSign()) || checkCol(cell[1],player.getSign()) || checkDiagonal(cell[0],cell[1],player.getSign()))
			return true;
		
		return false;
	}
	
	//prints grid 
	protected void printGrid()
	{
		System.out.println();
		for(int i=0;i<row_length;i++)
		{
			for(int j=0;j<col_length;j++)
			{
				System.out.print(" "+grid[i][j]);
				if(j<col_length-1)
					System.out.print(" |");
			}
			if(i<row_length-1)
				System.out.println("\n-----------");
		}
		System.out.println();
	}
	
	//gets row and column input from user
	protected int[] getRowAndCol()
	{
		int[] cell=new int[2];
		
		Scanner input=new Scanner(System.in);
		
		//while block is executed untill user provides valid output
		while(true) {
			
		System.out.println("Enter row no:");
		int row=(input.next().trim().charAt(0))-49;
		cell[0]=row;
			
		System.out.println("Enter column no:");
		cell[1]=((int)input.next().trim().charAt(0))-49;
		
		if((cell[0]>=3 || cell[0]<0) || (cell[1]>=3 || cell[1]<0))
			System.out.println("Invalid input! Enter inputs only from 1 to 3");
		
		else if(grid[cell[0]][cell[1]]=='\u0000')
			break;
		else
		System.out.println("Invalid input! enter again");
		}
		return cell;
	}
	
	//checks for consecutive matches in row
	protected boolean checkRow(int row,char sign)
	{
		for(int col=0;col<col_length;col++)
		{
			if(grid[row][col]!=sign)
				return false;
		}
		return true;
	}
	
	//checks for consecutive matches in column
	protected boolean checkCol(int col,char sign)
	{
		for(int row=0;row<row_length;row++)
		{
			if(grid[row][col]!=sign)
				return false;
		}
		return true;
	}
	
	//checks for consecutive matches diagonaly
	protected boolean checkDiagonal(int row,int col,char sign)
	{
		//row and column value would be equal for only left to right diagonal
		if(row==col)
		{
			for(int i=0,j=0;i<row_length && j<col_length;i++,j++)
			{
				if(grid[i][j]!=sign)
					return false;
			}
			return true;
		}
		
		//checks if it is right to left diagonal
		if((row+col)==(row_length-1))
		{
			for(int i=0,j=col_length-1;i<row_length && j>=0;i++,j--)
			{
				if(grid[i][j]!=sign)
					return false;
			}
			return true;
		}
		return false;
	}
	
	protected String winner(Player player)
	{
		//score of winner would be incremented 
		player.setScore(player.getScore()+1);
		
		return "\n"+player.getName()+" won the game! \n"
				+player1.getName()+":"+player1.getScore()
				+"\n"+player2.getName()+":"+player2.getScore()+"\n";
	}

}
