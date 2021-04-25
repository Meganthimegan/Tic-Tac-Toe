package Main;

import java.util.Scanner;

import Entities.Player;
import Service.PlayerMode;
import Service.singlePlayer;
import Service.twoPlayer;

public class playTicTacToe {

	private Scanner input=new Scanner(System.in);
	
	//playermode would be decided by user and initialised at runtime
	private PlayerMode mode;
	
	private int row_length=3,col_length=3;
	
	private char grid[][];
	
	public static void main(String[] args) {
		
		new playTicTacToe().getinput();		
	}
	
	//method to get input modes from user
	private void getinput()
	{
		System.out.println("       TIC TAC TOE      \n");
		boolean flg=true;
		while(flg)
		{
		System.out.println("Enter any of the following option:"
				+ "\n1.Dual Player mode"
				+ "\n2.Single Player mode"
				+ "\n3.Exit");
		
		//gets everything user gives as input,trims empty spaces and stores
		//only first character
		char option=input.next().trim().charAt(0);;
		
		switch(option)
		{
		case '1':executeDualPlayerMode();break;
		
		case '2':executeSingelPlayerMode();break;
		
		case '3':flg=false;break;
		
		default:System.out.println("Invalid input! enter values from 1 to 3");
		}
		}
	}
	
	private void executeSingelPlayerMode() {
		
		//gets players information
		Player[] players=getPlayers(1);
		
		//initializes mode
		this.mode=new singlePlayer(players[0],players[1],this.row_length,this.col_length);
		
		//this method starts the execution and asks for further continuation
		play();
		
	}

	private void executeDualPlayerMode()
	{		
		Player[] players=getPlayers(2);
		
		this.mode=new twoPlayer(players[0],players[1],this.row_length,this.col_length);
		
		play();
	}
	
	private Player[] getPlayers(int num)
	{
		Player[] players=new Player[2];
		players[0]=new Player();
		players[1]=new Player();
		
		System.out.println("Enter player1 name:");
		players[0].setName(input.next());
		
		//code within if block exectues only for dual players and else
		//block for single player.
		if(num==2)
		{
		System.out.println("Enter player2 name:");
		players[1].setName(input.next());
		}
		else
			players[1].setName("Computer");
		
		//getting sign from user
		System.out.println("Select sign for "+players[0].getName()+" other sign goes for "+players[1].getName()
				+ "\n1.'X'"
				+ "\n2.'O'");
		
		//this block keeps on executing untill the user enters valid input
		while(true)
		{
		char option=input.next().trim().charAt(0);
		if(option=='1')
		{
			players[0].setSign('X');
			players[1].setSign('O');
			break;
		}
		else if(option=='2')
		{
			players[0].setSign('O');
			players[1].setSign('X');
			break;
		}
		else
			System.out.println("Invalid input! Enter either 1 or 2");
		}
		
		players[0].setScore(0);
		players[1].setScore(0);
		
		return players;
	}
	
	private void play()
	{
		while(true)
		{
		this.grid=new char[row_length][col_length];
		
		//below line starts the execution.
		System.out.println(mode.play(grid));
		
		//this while block keeps on executing untill user press 0.
		System.out.println("Press any key to continue and 0 to exit");
		
		if(input.next().equals("0"))
			break;
		System.out.println("------------------------------------------");
		}

	}
}
