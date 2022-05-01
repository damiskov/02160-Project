package game_basics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import cards.Card;
import cards.CardCommand;
import cards.Deck;
import environment_elements.ChainingPanel;
import environment_elements.ConveyorBelt;
import environment_elements.Fire;
import environment_elements.Gear;
import environment_elements.HealthStation;
import environment_elements.Laser;
import environment_elements.OilSpill;
import environment_elements.RespawnPoint;
import environment_elements.ReversalPanel;
import environment_elements.Teleporter;
import piece_basics.Piece;
import piece_basics.Robot;
import property_changes.GameWinEvent;
import property_changes.IPropertyChangeEvent;
import property_changes.ActivationPhaseEndEvent;
import property_changes.PropertyChangeSupport;

public class Game {
	
	private static final List<String> registerActorPriorityList = List.of(
			ChainingPanel.ID,
			ConveyorBelt.ID,
			Teleporter.ID,
			Gear.ID,
			HealthStation.ID,
			Laser.ID,
			Robot.ID,
			Fire.ID,
			OilSpill.ID,
			ReversalPanel.ID,
			RespawnPoint.ID
	);
	
	private Board board;
	private Difficulty difficulty;
	private Player[] players;
	private PropertyChangeSupport propertyChangeSupport;
	private int numPlayers;
	private Deck deck;
	private Robot[] robots;
	private boolean over = false;
	private int winningPlayerNumber;
	
	public Game(PropertyChangeSupport pcs, int numPlayers) {
		this.propertyChangeSupport = pcs;
		this.numPlayers = numPlayers;

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
	
	/*  Observer pattern
	 *  Executes the perforRegistorAction of all 
	 *  the register actors on the board with the correct priority
	 */
	public void activateRegisterActors() {
		Map<String, List<Piece>> executionLists = board.getPieceLists();
		for (String id: registerActorPriorityList) {
			if (executionLists.containsKey(id)) {
				ArrayList<Piece> toExecute = new ArrayList<>(executionLists.get(id));
				for (Piece actor : toExecute) {
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
	
	public void firePropertyChange(IPropertyChangeEvent event) {
		propertyChangeSupport.firePropertyChange(event);
	}

	public Board getBoard() {
		return board;
	}
	
	public boolean isOver() {
		return over;
	}
	
	public void finishGame(int winningPlayerNumber) {
		over = true;
		this.winningPlayerNumber = winningPlayerNumber;
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
			players[i].setRobot(new Robot(i+1));
			robots[i] = players[i].getRobot();
		}
	}
	
	public Robot[] getRobots() {
		return this.robots;
	}
	 
	//makes the board for the game
	public void genBoard(Difficulty d, Robot[] r) {
		BoardFactory bf = new BoardFactory();
		Board b = bf.generateBoard(d, r, this);
		this.board = b;
	}
	
	//gives a hand for all of the players
	public void dealCards() {
		for(int i = 0; i < players.length; i++) {
			players[i].setHand(deck.genHand());
		}
	}
	
	//Sets up the game
	public void begin(int n, Difficulty d, PropertyChangeSupport pcs) {
		setPlayers(n);
		setRobots(n);
		
		genBoard(d, getRobots());
		deck = new Deck();
	}

	
	public void activationPhase() {
		ArrayList<CardCommand> order = new ArrayList<CardCommand>();
		
		//iterates through the programs (5 because 5 cards)
		activationPhaseLoop:
		for(int j = 0; j < 5; j++) {
			
			//creates an array of CardCommands to execute the cards in the right order
			for(int i = 0; i < players.length; i++) {
				Robot r = players[i].getRobot();
				Card topCard = r.getProgram().getTopOfProgram();
				CardCommand cc = new CardCommand(topCard, r);
				order.add(cc);
			}
	
			Collections.sort(order);
			
			//executes the moves
			for(CardCommand cc : order) {
				cc.execute();
				if (over) {
					break activationPhaseLoop;
				}
			}
			
			order.clear();
			activateRegisterActors();
		}
		
		
		if (over) {
			firePropertyChange(new GameWinEvent(winningPlayerNumber));
		}
		
		
		firePropertyChange(new ActivationPhaseEndEvent());
	
	}
	



}

		
