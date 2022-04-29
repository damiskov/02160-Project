package controller;



import board.Board;
import board.Game;
import property_changes.ProgrammingPhaseBeginEvent;
import property_changes.PropertyChangeSupport;
import view.MasterView;

public class MasterController {
	
	private ApplicationController application;
	public int playerCount;
	public String difficulty;
	
	private MasterView view;
	private Game game;
	private PropertyChangeSupport pcs;
	
	private int CurrentPlayer = 0;
	
	
	MasterController(ApplicationController application, int playerCount, String difficulty){
		this.application = application;
		this.playerCount = playerCount; 
		this.difficulty = difficulty;
		
		pcs = new PropertyChangeSupport();
		game = new Game(pcs, playerCount);
		
		// temporary
		game.testPlacements();
		//
		
		
		this.view = new MasterView(this, game);
		pcs.addSubscriber(view);
		game.getPropertyChangeSupport().firePropertyChange(new ProgrammingPhaseBeginEvent());

//		// temporary
//		game.demo();
//		//
		
//		Difficulty d = new Difficulty(setDifLevel(difficulty));
//		
//		game.begin(playerCount, d, pcs);
//		
//		runGame();
	}
	
	MasterController(ApplicationController application, int playerCount, String difficulty,  Board customBoard){
		this.application = application;
		this.playerCount = playerCount; 
		this.difficulty = difficulty;
		
//		pcs = new PropertyChangeSupport();
		game = new Game(pcs, playerCount, customBoard);
		this.view = new MasterView(this, game);
//		pcs.addSubscriber(view);
		
//		game.testPlacements();
	}

	public void display() {
		view.setVisible(true);
	}
	
	public int setDifLevel(String s)
	{
		if (s.toLowerCase()=="easy") {
			return 1;
		}
		else if(s.toLowerCase()=="medium") {
			return 2;
		}
		else if(s.toLowerCase()=="hard") {
			return 3;
		}
		return 0;
	}
	
	
    public void setCurrentPlayer(int cp) {
    	this.CurrentPlayer = cp;
    }
    
    public int getCurrentPlayer() {
    	return CurrentPlayer;
    }
    
	private void runGame() {
		while(!(game.isOver())) {
			
			game.dealCards();
			
			while(CurrentPlayer < game.getNumPlayers()) {
				
				
				
			}
		
			game.activationPhase();
				
		}
		
	}

	
}
