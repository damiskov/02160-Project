package controller;


import board.Board;
import board.Game;
import property_changes.PropertyChangeSupport;
import view.MasterView;

public class MasterController {
	
	private ApplicationController application;
	public int playerCount;
	public String difficulty;
	
	private MasterView view;
	private Game game;
	private PropertyChangeSupport pcs;
	
	
	MasterController(ApplicationController application, int playerCount, String difficulty){
		this.application = application;
		this.playerCount = playerCount; 
		this.difficulty = difficulty;
		
		pcs = new PropertyChangeSupport();
		game = new Game(pcs, playerCount);
		this.view = new MasterView(this, game);
		pcs.addSubscriber(view);
		
		game.testPlacements();
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
	
	

	
}
