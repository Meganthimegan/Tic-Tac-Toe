package Entities;

public class Player {

	private String name;
	
	private int score;
	
	private char sign;

	public Player()
	{
		
	}
	
	public Player(String name, int score, char sign) {
		super();
		this.name = name;
		this.score = score;
		this.sign = sign;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public char getSign() {
		return sign;
	}

	public void setSign(char sign) {
		this.sign = sign;
	}
	
	
}
