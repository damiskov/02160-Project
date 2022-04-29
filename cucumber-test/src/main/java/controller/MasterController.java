package controller;
import java.util.List;
import java.util.Stack;





import board.Difficulty;

import board.Board;
import board.Game;

import cards.Card;

import player.Player;
import property_changes.PropertyChangeSupport;
import view.MasterView;

public class MasterController {
	
	private ApplicationController application;
	public int playerCount;
	public String difficulty;
	private int currentPlayer;
	
	private MasterView view;
	private Game game;
	private PropertyChangeSupport pcs;
	
	private int CurrentPlayer = 0;
	
	
	MasterController(ApplicationController application, int playerCount, String difficulty, int currentPlayer){
		this.application = application;
		this.playerCount = playerCount; 
		this.difficulty = difficulty; 
		this.currentPlayer = currentPlayer;
		
		pcs = new PropertyChangeSupport();
		game = new Game(pcs, playerCount);
		this.view = new MasterView(this, game);
		pcs.addSubscriber(view);
		
		//game.testPlacements();
		
		Difficulty d = new Difficulty(setDifLevel(difficulty));
		
		game.begin(playerCount, d, pcs);
		
		runGame();
	}
	
	MasterController(ApplicationController application, int playerCount, String difficulty,  Board b){
		this.application = application;
		this.playerCount = playerCount; 
		this.difficulty = difficulty;
		
//		pcs = new PropertyChangeSupport();
		game = new Game(pcs, playerCount, b);
		this.view = new MasterView(this, game);
//		pcs.addSubscriber(view);
		
//		game.testPlacements();
		
		//game.begin(playerCount, new Difficulty(setDifLevel(difficulty)), pcs);
	}

	public void display() {
		view.setVisible(true);
	}
	
	public void assignCards(List<Card> cards)
	{
		Stack<Card> stack = new Stack<Card>();
		stack.addAll(cards);
		Player p = game.getPlayers()[this.currentPlayer];
		p.getRobot().setProgram(stack);
	}
	
//	public int getCurrentPlayer()
//	{
//		return currentPlayer;
//	}
	
	
	public Game getGame()
	{
		return game;
	}

	public void incrementCurrentPlayer() {
		currentPlayer++;
		
	}




	public int setDifLevel(String s)
	{
		if (s.toLowerCase()=="easy") {
			return 1;
		}
		else if(s.toLowerCase()=="medium") {
			return 2;
		}
		else if(s.toLowerCase()=="hard") {
			return 3;
		}
		return 0;
	}

	
	
    public void setCurrentPlayer(int cp) {
    	this.CurrentPlayer = cp;
    }
    
    public int getCurrentPlayer() {
    	return CurrentPlayer;
    }
    
	private void runGame() {
		while(!(game.isOver())) {
			
			game.dealCards();
			
			while(CurrentPlayer < game.getNumPlayers()) {
				
				
				
			}
		
			game.activationPhase();
				
		}
		
	}

	
}
