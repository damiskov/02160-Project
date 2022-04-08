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
		this.view = new InitiateView(this);
	}
	
	public void setParameters(int playerCount, String difficulty) {
		view.setVisible(false);
		application.startGame(playerCount, difficulty);
	}
	
	public void display() {
		view.setVisible(true);
	}


	

}
