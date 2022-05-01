package game_basics;
import java.util.Stack;

import cards.*;
import piece_basics.Robot;

public class Player {
	private Robot myRobot;
	private Hand hand;
	private String name;
	
	public void setName(String n)
	{
		this.name = n;
	}
	
	public void setRobot(Robot r)
	{
		this.myRobot = r;
	}
	
	public Robot getRobot() {
		return myRobot;
	}
	
	public void setHand(Hand hand)
	{
		this.hand = hand;
	}
	public Hand getHand()
	{
		return hand;
	}
	
	
	public void setProgram(Stack<Card> p)
	{
		// will get player to select 5 cards according to execution priority
		this.myRobot.setProgram(p);
	}
	
	public Program getProgram()
	{
		return myRobot.getProgram();
	}
	
	
	
}
