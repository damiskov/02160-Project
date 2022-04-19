package controller;

import view.InitiateView;

//import application.controller.ApplicationController;
//import application.model.Session;
//import application.view.LoginView;

public class InitiateController {

	private ApplicationController application;
	private InitiateView view;
	
	public InitiateController(ApplicationController application) {
		this.application = application;
		// create a new view of the setup window
		this.view = new InitiateView(this);
	}
	
	public void setGameParameters(int num_players, String difficulty) {
		view.setVisible(false);
		application.startGame(num_players, difficulty);
	}
	
	
	public void display() {
		view.setVisible(true);
	}


	

}
