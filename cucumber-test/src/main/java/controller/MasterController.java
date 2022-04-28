package controller;


import java.util.List;
import java.util.Stack;

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
	
	
	MasterController(ApplicationController application, int playerCount, String difficulty, int currentPlayer){
		this.application = application;
		this.playerCount = playerCount; 
		this.difficulty = difficulty; 
		this.currentPlayer = currentPlayer;
		
		pcs = new PropertyChangeSupport();
		game = new Game(pcs, playerCount);
		this.view = new MasterView(this, game);
		pcs.addSubscriber(view);
		
		game.testPlacements();
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
	
	public int getCurrentPlayer()
	{
		return currentPlayer;
	}
	
	
	public Game getGame()
	{
		return game;
	}



	

	
}
