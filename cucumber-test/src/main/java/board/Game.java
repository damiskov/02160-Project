package board;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import cards.Card;
import cards.Deck;
import environment_elements.ChainingPanel;
import environment_elements.Checkpoint;
import environment_elements.ConveyorBelt;
import environment_elements.FinalCheckpoint;
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
	Deck deck;
	private Robot[] robots;
	
	
	public Game(PropertyChangeSupport pcs, int numPlayers) {
		this.propertyChangeSupport = pcs;
		this.numPlayers = numPlayers;
		
		// temporary
		board = new Board(12, 12, pcs);
	} 
	
	
	public void setDifficulty(int i) {
		this.difficulty.setLevel(i);
		
	}
//	public void setCurrentPlayer(int i) {
//		// TODO Auto-generated method stub
//		
//	}
	
	


	
	
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
		board.initialPlacement(r1, 0, 0);
		Robot r2 = new Robot();
		board.initialPlacement(r2, 0, 3);
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
		board.initialPlacement(new FinalCheckpoint(1), 1, 3);
		board.initialPlacement(new Fire(), 2, 3);
		board.initialPlacement(new HealthStation(), 3, 3);
		board.initialPlacement(new OilSpill(), 4, 3);
		board.initialPlacement(new Pit(), 5, 3);
		RespawnPoint rp = new RespawnPoint();
		r2.setRespawnPoint(rp);
		board.initialPlacement(rp, 6, 3);
		board.initialPlacement(new ReversalPanel(), 7, 3);
		board.initialPlacement(new Teleporter(), 8, 3);
		board.initialPlacement(new Wall(), 9, 3);
		
//		r1.move(1);
		
		r2.turnRight();
//		r2.move(1);
		
//		r1.move(1);
//		r1.turnRight();
//		r1.move(1);
//		r1.turnRight();
//		r1.move(1);
//		r1.turnRight();
//		r1.move(1);
//		r1.turnRight();
		
	
//		activateRegisterActors();
//		r2.move(2);
//		r2.turnLeft();
//		r2.move(-2);
//		r2.turnLeft();
//		r2.move(-1);
//		r2.turnLeft();
//		r2.move(-1);
//		r2.turnLeft();
//		r2.move(-1);
//		r2.turnLeft();
//		r2.move(-1);
		
		//r1.move(1);
		//r1.turnLeft();
		//r1.move(1);
		
		
		
	}

	public int getNumPlayers() {
		return numPlayers;
	}
	
	//creates the players and names them and puts them in a list
	public void setPlayers(int num_players) {
		for (int i = 0; i < num_players; i++ ) {
			
			players[i] = new Player();
			String playerN = String.valueOf(i);
			players[i].setName("Player " + playerN);
			
		}
	}
	
	public Player[] getPlayers() {
		return players;
	}
	
	//creates the robots and associates them to a player (also puts them in a list)
	public void setRobots() {
		for (int i = 0; i < players.length; i++ ) {
			players[i].setRobot(new Robot());			
		}
	}
	
	public Robot[] getRobots() {
		return this.robots;
	}
	 
	//makes the board for the game
	public void genBoard(Difficulty d, Robot[] r, PropertyChangeSupport pcs) {
		Board b = BoardFactory.generateBoard(d, r, pcs);
		this.board = b;
	}
	
	//gives a hand for all of the players
	public void dealCards() {
		for(int i = 0; i < players.length; i++) {
			players[i].setHand(deck.genHand());
		}
	}
	
	//initial stuff that we need for the game 
	public void Begin(int n, Difficulty d, PropertyChangeSupport pcs) {
		setPlayers(n);
		setRobots();
		
		genBoard(d, getRobots(), pcs);
	}
	
	/*
	 * ADD PLAYERS CHOOSING THE CARDS METHODS
	 */
	
	public void activationPhase() {
		ArrayList order = new ArrayList();
		ArrayList orderNum = new ArrayList();
		
		//iterates through the programs (5 because 5 cards)
		for(int j = 0; j < 5; j++) {
			//creates two arrays, one with all of the cards, one with all of the numbers
			//the indices of the cards match to the ones of the numbers and also to the players
			for(int i = 0; i < players.length; i++) {
				order.add(players[i].getRobot().getProgram().getTopOfProgram());
				orderNum.add(players[i].getRobot().getProgram().getTopOfProgram().getNum());
			}
			
			for(int k = 0; k < order.size(); k++) {
				//finds the index of the maximum
				int max = (int) Collections.max(orderNum);
				int dex = orderNum.indexOf(max);
				
				//executes the card that has the max number
				Card exNow = ((Card) order.get(dex));
				exNow.executeAction(players[dex].getRobot());
				
				//remove the max in the number array and the corresponding car
				order.remove(dex);
				orderNum.remove(dex);
			}
			//activates the register actors
			activateRegisterActors();
		}
	}
	
	
	
}