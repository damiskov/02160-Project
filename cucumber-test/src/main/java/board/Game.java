package board;

import card.Deck;
import player.Player;

public class Game {
	
	Board b;
	Difficulty difficulty;
	Player[] players;
	public void genBoard() {

		if (difficulty.getLevel()==1)
		{
			// Generate board corresponding to easy difficulty
		}
		if (difficulty.getLevel()==2)
		{
			// Generate board corresponding to medium difficulty 
		}
		if (difficulty.getLevel()==3)
		{
			// Generate board corresponding to hard difficulty
		}
	}
	
	public void displayBoard()
	{
		// Displaying board		
	}
	// Difficulty getter and setters
	
	public void setDifficulty(int d) {
		this.difficulty.setLevel(d);
	}
	public void setCurrentPlayer(int i) {
		// TODO Auto-generated method stub
		
	}
	
	// Player methods
	
	public void setPlayers(Player[] p)
	{
		if (p.length >= 1 && p.length <= 8)
		{
			this.players = p;
		}
		else
		{
			System.out.println("Invalid number of players (Should be between 1 and 8 (inclusive))");
		}
	}
	

	public Player[] getPlayers() {
		return players;
	}
}
