package board;

import card.Deck;
import player.Player;

public class Game {
	
	Board b;
	String difficulty;
	Player[] players;
	int currentPlayer;
	Deck gameDeck;
	
	// Board methods
	
	public void genBoard() {
		if (difficulty.equals("easy"))
		{
			// Generate board corresponding to easy difficulty
		}
		if (difficulty.equals("medium"))
		{
			// Generate board corresponding to medium difficulty 
		}
		if (difficulty.equals("hard"))
		{
			// Generate board corresponding to hard difficulty
		}
	}
	
	public void displayBoard()
	{
		// Displaying board
		
	}
	
	// Difficulty getter and setters
	
	public void setDifficulty(String d) {
		this.difficulty = d;
	}
	
	public void getDifficulty()
	{
		System.out.println(difficulty);
	}
	
	// Player methods
	
	public void setPlayers(Player[] p)
	{
		if (p.length >= 2 && p.length <= 8)
		{
			this.players = p;
		}
		else
		{
			System.out.println("Invalid number of players (Should be between 2 and 8 (inclusive))");
		}
	}
	
	public int getCurrentPlayer()
	{
		return currentPlayer;
	}
	
	public void setCurrentPlayer(int p)
	{
		this.currentPlayer = p;
	}
}
