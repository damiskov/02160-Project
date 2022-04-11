package controller;

//import application.controller.ApplicationController;
//import application.controller.LoginController;

public class ApplicationController {
	private InitiateController initiateController;

	private void initiate() {
		initiateController = new InitiateController(this);
		initiateController.display();
		
	}
	
	public void startGame(int playerCount) {
		System.out.println("Game started with " + playerCount + " players.");
		
	}
	
	public static void main(String[] args) {
		ApplicationController app = new ApplicationController();
		app.initiate();
	}

	

	
}