package controller;


import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import board.Board;

//import application.controller.ApplicationController;
//import application.controller.LoginController;

public class ApplicationController {
	private InitiateController initiateController;

	private MasterController masterController;
	
	private BoardCreationController boardCreationController;


	public void initiate() {
		initiateController = new InitiateController(this);
		initiateController.display();
		
	}
	
	public void startGame(int playerCount, String difficulty) {

		
//		game.getPlayers().length

//		System.out.println("Game started with " + playerCount + " players and difficulty " + difficulty);

		//System.out.println("Game started with " + playerCount + " players.");
		masterController = new MasterController(this, playerCount, difficulty, 0);
		masterController.display();

	}
	
	public void startCustomGame(int numPlayers, Board newBoard){
		masterController = new MasterController(this, numPlayers, "customgame", 0);
		masterController.display();
	}
	
	public void startBoardCreationUI() {
		
		boardCreationController = new BoardCreationController(this);
		boardCreationController.display();
		
	}
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// do nothing, use default look and feel
		}
		
		ApplicationController app = new ApplicationController();
		app.initiate();
	}

	

	
}