package controller;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;





import board.Difficulty;

import board.Board;
import board.Game;

import cards.Card;


import player.Player;
import property_changes.ActivationPhaseEndEvent;
import property_changes.PropertyChangeSupport;
import view.CardPanel;
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
	private String[] spriteNames = {"robot1", "robot2", "robot3", "robot4", "robot5", "robot6", "robot7", "robot8"};
	
	
	MasterController(ApplicationController application, int playerCount, String difficulty, int currentPlayer){
		this.application = application;
		this.playerCount = playerCount; 
		this.difficulty = difficulty; 
		this.currentPlayer = currentPlayer;
		
		pcs = new PropertyChangeSupport();
		game = new Game(pcs, playerCount);
		
		// temporary
		//game.testPlacements();
		//
		Difficulty d = new Difficulty(setDifLevel(difficulty));
		game.begin(playerCount, d, pcs);
		setRobotNames();
		game.dealCards();
		
		this.view = new MasterView(this, game);
		pcs.addSubscriber(view);
		game.getPropertyChangeSupport().firePropertyChange(new ActivationPhaseEndEvent());

//		temporary
//		game.demo();
		
		
		
		
		//game.testPlacements();
		
		
		
		
		
		//runGame();
		
		
//		Difficulty d = new Difficulty(setDifLevel(difficulty));
//		
//		game.begin(playerCount, d, pcs);
//		
//		runGame();
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
		for (Card c : cards)
		{
			System.out.println(c.getAction());
		}
		stack.addAll(cards);
		System.out.println(stack.size());
		Player p = game.getPlayers()[currentPlayer];
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
		this.currentPlayer = this.currentPlayer+1;
		
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
    	this.currentPlayer = cp;
    }
    
    public int getCurrentPlayer() {
    	return currentPlayer;
    }
    
	private void runGame() {
		while(!(game.isOver())) {
			
			game.dealCards();
			
			while(currentPlayer < game.getNumPlayers()) {
				
				
				
			}
		
			game.activationPhase();
				
		}
		
	}
	
	public void setRobotNames() {
		for(int i = 0; i<playerCount; i++) {
			game.getRobots()[i].setSpriteName(spriteNames[i]);
		}
	}



	public void displayCardPanelControl()
	{
		CardPanel cp = new CardPanel(view, this);
		view.displayCardPanelView(cp);
		
	}
	
	
	public ArrayList<Card> getCurrentPlayerHand()
	{
		return game.getPlayers()[currentPlayer].getHand().getCardList();
	}
	
	public void checkIfEndOfProgrammingPhase(List<Card> cards)
	{
		Collections.reverse(cards);
		assignCards(cards);
		
		if (getCurrentPlayer()==playerCount-1)
		{
			// Execute activation phase
			view.removeCardPanel();
			
			game.activationPhase();
			
			
		}
		else
		{
			
			
			// incrementing current player
			// and setCardPanel (new player's hand shown)

			incrementCurrentPlayer();
			
		
			displayCardPanelControl();
		}
	}
	
	
	public void beginProgrammingPhase() {
		if (!game.isOver())
		{
			currentPlayer = 0;
			game.dealCards();
			displayCardPanelControl();
		}
		
	}
	
	
}
