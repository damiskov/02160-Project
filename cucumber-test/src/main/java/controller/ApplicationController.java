package controller;

//import application.controller.ApplicationController;
//import application.controller.LoginController;

public class ApplicationController {
	private InitiateController initiateController;
	private MasterController masterController;

	private void initiate() {
		initiateController = new InitiateController(this);
		initiateController.display();
		
	}
	
	public void startGame(int playerCount, String difficulty) {
		//System.out.println("Game started with " + playerCount + " players.");
		masterController = new MasterController(this, playerCount, difficulty);
		masterController.display();
	}
	
	public static void main(String[] args) {
		ApplicationController app = new ApplicationController();
		app.initiate();
	}

	

	
}