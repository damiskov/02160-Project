package controller;


import view.MasterView;

public class MasterController {
	
	private ApplicationController application;
	private MasterView view;
	public int playerCount;
	public String difficulty;
	
	
	MasterController(ApplicationController application ,int playerCount, String difficulty){
		this.application = application;
		this.playerCount = playerCount; 
		this.difficulty = difficulty;
		this.view = new MasterView(this);
	}

	public void display() {
		view.setVisible(true);
	}

	
}
