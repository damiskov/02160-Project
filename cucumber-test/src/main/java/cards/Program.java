package cards;

import java.util.ArrayList;

public class Program {
	
	private ArrayList<Card> cardList;
	
	public Program(ArrayList<Card> cardList)
	{
		this.cardList = cardList;
	}
	
	// Simulates process of taking a card from the top of a program
	
	public Card getTopOfProgram()
	{
		Card topCard = cardList.get(0);
		cardList.remove(0);
		return topCard;
	}

}
