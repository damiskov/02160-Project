package controller;


import board.Game;
import board.PropertyChangeSupport;
import view.MasterView;

public class MasterController {
	
	private ApplicationController application;
	private MasterView view;
	public int playerCount;
	public String difficulty;
	
	private Game game;
	
	
	MasterController(ApplicationController application ,int playerCount, String difficulty){
		this.application = application;
		this.playerCount = playerCount; 
		this.difficulty = difficulty;
		this.view = new MasterView(this);
		
		PropertyChangeSupport pci = new PropertyChangeSupport();
		pci.addSubscriber(view);
		Game game = new Game(pci);
	}

	public void display() {
		view.setVisible(true);
	}
	
	

	
}
