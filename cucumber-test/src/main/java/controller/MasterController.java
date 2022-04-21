package controller;


import board.Game;
import property_changes.PropertyChangeSupport;
import view.MasterView;

public class MasterController {
	
	private ApplicationController application;
	private MasterView view;
	public int playerCount;
	public String difficulty;
	
	private Game game;
	
	
	MasterController(ApplicationController application, int playerCount, String difficulty){
		this.application = application;
		this.playerCount = playerCount; 
		this.difficulty = difficulty;
		
		PropertyChangeSupport pci = new PropertyChangeSupport();
		Game game = new Game(pci, playerCount);
		this.view = new MasterView(this, game);
		pci.addSubscriber(view);
		
		game.testPlacements();
	}

	public void display() {
		view.setVisible(true);
	}
	
	

	
}
