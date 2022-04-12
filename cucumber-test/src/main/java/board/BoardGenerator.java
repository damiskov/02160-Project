package board;
import player.Player;

public class BoardGenerator{
	Player[] players;
	Difficulty difficulty;
	
	public BoardGenerator(Difficulty difficulty,  Player[] players) {
		this.difficulty = difficulty;
		this.players = players;
	}
	

}
