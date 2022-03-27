package board;
import player.Player;

public class BoardGenerator {
	private Difficulty difficulty;
	int numObstacles;
	Player[] players;
	
	public BoardGenerator(Difficulty difficulty, int numObstacles, Player[] players) {
		this.difficulty = difficulty;
		this.numObstacles = numObstacles;
		this.players = players;
	}
	
	public Board Generate()
	{
		return new Board();
	}
	

}
