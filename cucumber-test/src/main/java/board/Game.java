package board;

import java.util.List;
import java.util.Map;

import piece_basics.IRegisterActor;
import player.Player;

public class Game {
	
	private static final List<String> priorityList = List.of(
			"chaining panel",
			"conveyor_belt",
			"gear",
			"laser",
			"robot",
			"fire",
			"oil_spill",
			"reversal_panel",
			"respawn_point",
			"checkpoint"
	);
	
	Board board;
	String difficulty;
	Player[] players;
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
		Map<String, List<IRegisterActor>> executionLists = board.getExecutionLists();
		for (String id: priorityList) {
			if (executionLists.containsKey(id)) {
				for (IRegisterActor actor: executionLists.get(id)) {
					actor.performRegisterAction();
				}
			}
		}
		
	}
}
