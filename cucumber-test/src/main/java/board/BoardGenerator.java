package board;
import player.Player;

public class BoardGenerator implements IBoardGenerator {
	private int difficulty;
	Player[] players;
	
	public BoardGenerator(int difficulty,  Player[] players) {
		this.difficulty = difficulty;
		this.players = players;
	}

	@Override
	public Board genEasyBoard() {
		// TODO Auto-generated method stub
		return null;
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
