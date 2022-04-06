package board;

import card.Deck;
=======
import java.util.List;
import java.util.Map;

import environment_elements.ChainingPanel;
import environment_elements.ConveyorBelt;
import environment_elements.Fire;
import environment_elements.Gear;
import environment_elements.Laser;
import environment_elements.OilSpill;
import environment_elements.RespawnPoint;
import environment_elements.ReversalPanel;
import piece_basics.Piece;
import piece_basics.Robot;
>>>>>>> refs/heads/main
import player.Player;

public class Game {
	Board b;
	Difficulty difficulty;
	private static final List<String> registerActorPriorityList = List.of(
			ChainingPanel.ID,
			ConveyorBelt.ID,
			Gear.ID,
			Laser.ID,
			Robot.ID,
			Fire.ID,
			OilSpill.ID,
			ReversalPanel.ID,
			RespawnPoint.ID
			/* Checkpoint.ID */
	);
	
	Board board;
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
	
	// Observer pattern
	public void activateRegisterActors() {
		Map<String, List<Piece>> executionLists = board.getPieceLists();
		for (String id: registerActorPriorityList) {
			if (executionLists.containsKey(id)) {
				for (Piece actor: executionLists.get(id)) {
					actor.performRegisterAction();
				}
			}
		}
		
	}
	public void setBoard(Board board) {
		this.board = board;
	}
	
}
