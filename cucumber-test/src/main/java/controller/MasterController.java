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
	
	private MasterView view;
	private Game game;
	private PropertyChangeSupport pcs;
	
	
	MasterController(ApplicationController application, int playerCount, String difficulty){
		this.application = application;
		this.playerCount = playerCount; 
		this.difficulty = difficulty;
		
		pcs = new PropertyChangeSupport();
		game = new Game(pcs, playerCount);
		this.view = new MasterView(this, game);
		pcs.addSubscriber(view);
		
		game.testPlacements();
	}

	public void display() {
		view.setVisible(true);
	}
	
	public void assignCards(Player player, List<Card> cards)
	{
		Stack<Card> stack = new Stack<Card>();
		stack.addAll(cards);
		player.getRobot().setProgram(stack);
	}
	

	
}
