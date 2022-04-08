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
	
	public void setPlayers(int value) {
		view.setVisible(false);
		application.startGame(value);
	}
	
	public void display() {
		view.setVisible(true);
	}


	

}
