package controller;


import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import board.Game;
import view.InitiateView;

//import application.controller.ApplicationController;
//import application.controller.LoginController;

public class ApplicationController {
	private InitiateController initiateController;

	private Game game;

	private MasterController masterController;
	
	private BoardCreationController boardCreationController;

	private void initiate() {
		initiateController = new InitiateController(this);
		initiateController.display();
		
	}
	
	public void startGame(int playerCount, String difficulty) {

		game = new Game();
		game.setDifficulty(difficulty);
//		game.setPlayers(playerCount);
		
//		game.getPlayers().length
		System.out.println("Game started with " + playerCount + " players and difficulty " + game.getDifficulty());

		//System.out.println("Game started with " + playerCount + " players.");
		masterController = new MasterController(this, playerCount, difficulty);
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