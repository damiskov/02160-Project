package board;
import player.Player;

public class BoardGenerator implements IBoardGenerator {
	Player[] players;
	Difficulty difficulty;
	
	public BoardGenerator(Difficulty difficulty,  Player[] players) {
		this.difficulty = difficulty;
		this.players = players;
	}

	@Override
	public Board genEasyBoard() {
		Board b = new Board(12,12);
		return b;
	}

	@Override
	public Board genMediumBoard() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Board genHardBoard() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
