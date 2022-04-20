package cards;

import java.util.ArrayList;

public class Program {
	
	private ArrayList<Card> program = new ArrayList<Card>();
	
	public Program()
	{
	}
	
	// getter and setter for program
	
	public void setCardList(ArrayList<Card> cardList)
	{
		this.program = cardList;
	}
	
	public ArrayList<Card> getCardList()
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
