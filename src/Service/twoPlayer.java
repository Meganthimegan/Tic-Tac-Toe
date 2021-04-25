package Service;

import Entities.Player;

public class twoPlayer extends basicMode{
	
	public twoPlayer(Player player1, Player player2, int rwo_length, int col_length) {
		super(player1,player2,rwo_length,col_length);
	}

	public String play(char grid[][]){
		
		//initialises grid
		super.setGrid(grid);
		
		//initialising count,count maintains total number of unfilled cells and helps
		//in deciding draw match.
		super.setCount(super.getRow_length()*super.getCol_length());
		
		//prints grid (i.e) tic tac toe table
		printGrid();
		while(super.getCount()>0)
		{
			//player1 gets first turn 
			if(super.playYourTurn(super.getPlayer1()))
				return super.winner(super.getPlayer1());
			
			//player2 gets second turn
			if(super.getCount()>0 && super.playYourTurn(super.getPlayer2()))
				return winner(super.getPlayer2());
		}
		
		//if no one got three match, then code comes here since no more empty cells were there,so its draw.
		
		return "\n It's Draw! \n"
				+super.getPlayer1().getName()+":"+super.getPlayer1().getScore()+
				"\n"+super.getPlayer2().getName()+":"+super.getPlayer2().getScore()+"\n";
	}

}
