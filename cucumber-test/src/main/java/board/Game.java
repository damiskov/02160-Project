package board;
import cards.Deck;
import java.util.List;
import java.util.Map;

import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

import environment_elements.ChainingPanel;
import environment_elements.Checkpoint;
import environment_elements.ConveyorBelt;
import environment_elements.Fire;
import environment_elements.Gear;
import environment_elements.HealthStation;
import environment_elements.Laser;
import environment_elements.OilSpill;
import environment_elements.Pit;
import environment_elements.RespawnPoint;
import environment_elements.ReversalPanel;
import environment_elements.Teleporter;
import environment_elements.Wall;
import piece_basics.Orientation;
import piece_basics.Piece;
import piece_basics.Robot;
import player.Player;
import property_changes.PropertyChangeSupport;

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
	private Difficulty difficulty;
	private Player[] players;
	PropertyChangeSupport propertyChangeSupport;
	int numPlayers;
	
	public Game() {}
	
	public Game(PropertyChangeSupport pcs, int numPlayers) {
		this.propertyChangeSupport = pcs;
		this.numPlayers = numPlayers;
		
		// temporary
		board = new Board(12, 12, this);
	}
	
	
	public void genBoard() {
		
	}
	public void setDifficulty(int i) {
		this.difficulty.setLevel(i);
		
	}
//	public void setCurrentPlayer(int i) {
//		// TODO Auto-generated method stub
//		
//	}
	
	public void setPlayers(int num_players) {
		for (int i = 0; i < num_players; i++ ) {
			
			players[i] = new Player();
			
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


	public PropertyChangeSupport getPropertyChangeSupport() {
		return propertyChangeSupport;
	}

	public IBoard getBoard() {
		return board;
	}
	
	// temporary
	public void testPlacements() {
		Robot r1 = new Robot();
		board.initialPlacement(r1, 0, 3);
//		r1.turnLeft();
//		r1.turnLeft();
//		r1.turnLeft();
//		r1.turnLeft();
//		r1.turnRight();
//		r1.turnRight();
//		r1.turnRight();
//		r1.turnRight();
		board.initialPlacement(new Robot(), 1, 0);
		board.initialPlacement(new Robot(), 2, 0);
		board.initialPlacement(new Robot(), 3, 0);
		board.initialPlacement(new Robot(), 4, 0);
		board.initialPlacement(new Robot(), 5, 0);
		board.initialPlacement(new Robot(), 6, 0);
		board.initialPlacement(new Robot(), 7, 0);
		
		board.initialPlacement(new ConveyorBelt(Orientation.RIGHT), 0, 1);
		board.initialPlacement(new ConveyorBelt(Orientation.DOWN), 1, 1);
		board.initialPlacement(new ConveyorBelt(Orientation.LEFT), 2, 1);
		board.initialPlacement(new ConveyorBelt(Orientation.UP), 3, 1);
		
		board.initialPlacement(new Gear(true), 0, 2);
		board.initialPlacement(new Gear(false), 1, 2);
		
		board.initialPlacement(new ChainingPanel(), 0, 3);
		board.initialPlacement(new Checkpoint(0), 1, 3);
		board.initialPlacement(new Fire(), 2, 3);
		board.initialPlacement(new HealthStation(), 3, 3);
		board.initialPlacement(new OilSpill(), 4, 3);
		board.initialPlacement(new Pit(), 5, 3);
		RespawnPoint rp = new RespawnPoint();
		r1.setRespawnPoint(rp);
		board.initialPlacement(rp, 6, 3);
		board.initialPlacement(new ReversalPanel(), 7, 3);
		board.initialPlacement(new Teleporter(), 8, 3);
		board.initialPlacement(new Wall(), 9, 3);
		
	
		activateRegisterActors();
		r1.move(1);
		
		//r1.move(1);
		//r1.turnLeft();
		//r1.move(1);
		
		
		
	}

	public int getNumPlayers() {
		return numPlayers;
	}
	
}