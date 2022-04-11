package board;

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
import environment_elements.Teleporter;
import piece_basics.Piece;
import piece_basics.Robot;
import player.Player;

public class Game {
	
	private static final List<String> registerActorPriorityList = List.of(
			ChainingPanel.ID,
			ConveyorBelt.ID,
			Teleporter.ID,
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
	String difficulty;
	private Player[] players;
	public void genBoard() {
		
	}
	public void setDifficulty(String d) {
		this.difficulty = d;
		
	}
	public void setCurrentPlayer(int i) {
		// TODO Auto-generated method stub
		
	}

	public Player[] getPlayers() {
		return players;
	}
	
	// Observer pattern
	public void activateRegisterActors() {
		Map<String, List<Piece>> executionLists = board.getPieceLists();
		for (String id: registerActorPriorityList) {
			if (executionLists.containsKey(id)) {
				int startsize = executionLists.get(id).size();
				for (int i = 0; i < startsize; i++) {
					Piece actor = executionLists.get(id).get(i);
					actor.performRegisterAction();
				}
			}
		}
		
	}
	public void setBoard(Board board) {
		this.board = board;
	}
	
}
