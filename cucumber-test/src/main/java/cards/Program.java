package cards;

import java.util.ArrayList;

public class Program {
	
	private ArrayList<Card> program;
	
	public Program()
	{
	}
	
	// getter and setter for program
	
	public void setProgram(ArrayList<Card> cardList)
	{
		this.program = cardList;
	}
	
	public ArrayList<Card> getProgram()
	{
		return this.program;
	}
	
	// Simulates process of taking a card from the top of a program
	
	public Card getTopOfProgram()
	{
		Card topCard = program.get(0);
		program.remove(0);
		return topCard;
	}

}
