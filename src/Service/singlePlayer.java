package Service;

import java.util.Random;
import Entities.Player;

public class singlePlayer extends basicMode{
	
	public singlePlayer(Player player1, Player player2, int rwo_length, int col_length) {
		super(player1,player2,rwo_length,col_length);
	}
	
	public String play(char[][] grid) {
		
		//initialises grid
		super.setGrid(grid);
		
		//initialising count,count maintains total number of unfilled cells and helps
		//in deciding draw match.
		super.setCount(super.getRow_length()*super.getCol_length());
		
		printGrid();
		
		while(super.getCount()>0)
		{
			if(super.playYourTurn(super.getPlayer1()))
				return super.winner(super.getPlayer1());
			//computer plays by decides randomised cells
			if(super.getCount()>0 && randomGenerator(super.getPlayer2()))
				return winner(super.getPlayer2());
		}
		
		return "\n It's Draw! \n"
				+super.getPlayer1().getName()+":"+super.getPlayer1().getScore()+
				"\n"+super.getPlayer2().getName()+":"+super.getPlayer2().getScore()+"\n";

	}
	
	private boolean randomGenerator(Player player)
	{
		Random random=new Random();
		
		System.out.println("Computers turn:");
		int cell[]=new int[2];
		
		//keep paused for a second, just for pleasent feel
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		while(true)
		{
		//generating random row and column
		cell[0]=random.nextInt()%super.getRow_length();
		cell[1]=random.nextInt()%super.getRow_length();
		
		//checks for limits and empty cell
		if((cell[0]<3 && cell[0]>=0) && (cell[1]<3 && cell[1]>=0))
			if(super.getGrid()[cell[0]][cell[1]]=='\u0000')
				break;
		
		}
		
		//assigning players sign to that cell
		super.getGrid()[cell[0]][cell[1]]=player.getSign();
		
		//decreasing count (i.e) count of empty cells
		super.setCount(super.getCount()-1);
		printGrid();
		
		//checking for match horizondaly,vertically and diagonaly
		//returns true if match is found
		if(checkRow(cell[0],player.getSign()) || checkCol(cell[1],player.getSign()) || checkDiagonal(cell[0],cell[1],player.getSign()))
			return true;
		
		return false;
	}
	
}
