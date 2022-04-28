package board;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import cards.Card;
import cards.Deck;
import environment_elements.ChainingPanel;
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
import property_changes.ProgrammingPhaseBeginEvent;
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
	
	// TODO: Add game finish scenario
	private boolean over = false;
	
	
	public Game(PropertyChangeSupport pcs, int numPlayers) {
		this.propertyChangeSupport = pcs;
		this.numPlayers = numPlayers;
		
		// temporary
		board = new Board(12, 12, this);
	} 
	
	public void setDeck(Deck d) {
		this.deck = d;
	}
	public void setDifficulty(Difficulty d) {
		this.difficulty = d;
		
	}
	
	public Difficulty getDifficulty() {
		return this.difficulty;
		
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

	public Board getBoard() {
		return board;
	}
	
	public boolean isOver() {
		return over;
	}
	
	public void finishGame() {
		over = true;
	}
	
	// temporary
	public void testPlacements() {
		Robot r1 = new Robot();
		board.initialPlacement(r1, 5, 2);
		Robot r2 = new Robot();
		board.initialPlacement(r2, 7, 3);
		Robot r3 = new Robot();
		board.initialPlacement(r3, 1, 0);
		board.initialPlacement(new Robot(), 3, 0);
		board.initialPlacement(new Robot(), 9, 0);
		board.initialPlacement(new Robot(), 5, 0);
		board.initialPlacement(new Robot(), 10, 0);
		board.initialPlacement(new Robot(), 11, 0);
		
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
		r1.setRespawnPoint(rp);
		board.initialPlacement(rp, 6, 3);
		board.initialPlacement(new ReversalPanel(), 7, 3);
		
		Teleporter t1 = new Teleporter();
		board.initialPlacement(t1, 8, 3);
		Teleporter t2 = new Teleporter();
		board.initialPlacement(t2, 8, 10);
		t1.setSending(true);
		t1.setReceiving(t2);
		
		board.initialPlacement(new Wall(), 9, 3);
		
		r1.move(1);
		
		r2.turnRight();
		r2.move(1);
		activateRegisterActors();
		
		r2.turnLeft();
		r2.turnLeft();
		r2.move(2);
		r2.turnLeft();
		activateRegisterActors();
		
		r1.turnLeft();
		r1.turnLeft();
		r1.move(1);
		r1.turnRight();
		r1.move(2);
		r1.turnRight();
		r1.move(1);
		activateRegisterActors();
		
		
	


		propertyChangeSupport.firePropertyChange(new ProgrammingPhaseBeginEvent());


		
		
		
	}

	public int getNumPlayers() {
		return numPlayers;
	}
	
	//creates the players and names them and puts them in a list
	public void setPlayers(int num_players) {
		 players = new Player[num_players];
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
	public void setRobots(int num) {
		robots = new Robot[num];
		for (int i = 0; i < players.length; i++ ) {
			players[i].setRobot(new Robot());
			robots[i] = players[i].getRobot();
		}
	}
	
	public Robot[] getRobots() {
		return this.robots;
	}
	 
	//makes the board for the game
	public void genBoard(Difficulty d, Robot[] r) {
		Board b = BoardFactory.generateBoard(d, r, this);
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
		setRobots(n);
		
		genBoard(d, getRobots());
	}
	
	/*
	 * ADD PLAYERS CHOOSING THE CARDS METHODS
	 */
	
	public void activationPhase() {
		ArrayList<Card> order = new ArrayList<>();
		ArrayList<Integer> orderNum = new ArrayList<>();
		
		//iterates through the programs (5 because 5 cards)
		activationPhaseLoop:
		for(int j = 0; j < 5; j++) {
			System.out.println(players[1].getRobot().getProgram().getCardList());
			//creates two arrays, one with all of the cards, one with all of the numbers
			//the indices of the cards match to the ones of the numbers and also to the players
			for(int i = 0; i < players.length; i++) {
				order.add(players[i].getRobot().getProgram().getTopOfProgram());
				orderNum.add(players[i].getRobot().getProgram().getTopOfProgram().getNum());
			}
			
			for(int k = 0; k < order.size(); k++) {
				//finds the index of the maximum
				int max = (int) Collections.max(orderNum);
				int idx = orderNum.indexOf(max);
				
				//executes the card that has the max number
				Card exNow = ((Card) order.get(idx));
				exNow.executeAction(players[idx].getRobot());
				
				//remove the max in the number array and the corresponding car
				order.remove(idx);
				orderNum.remove(idx);
				
				if (over) {
					break activationPhaseLoop;
				}
			}
			//activates the register actors
			activateRegisterActors();
		}
	}
	
	
	
}