package controller;


import board.Game;
import property_changes.PropertyChangeSupport;
import view.MasterView;

public class MasterController {
	
	private ApplicationController application;
	public int playerCount;
	public String difficulty;
	
	private MasterView view;
	private Game game;
	private PropertyChangeSupport pci;
	
	
	MasterController(ApplicationController application, int playerCount, String difficulty){
		this.application = application;
		this.playerCount = playerCount; 
		this.difficulty = difficulty;
		
		pci = new PropertyChangeSupport();
		game = new Game(pci, playerCount);
		this.view = new MasterView(this, game);
		pci.addSubscriber(view);
		
		game.testPlacements();
	}

	public void display() {
		view.setVisible(true);
	}
	
	

	
}
