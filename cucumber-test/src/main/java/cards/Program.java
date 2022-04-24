package cards;

import java.util.ArrayList;

public class Program {
	
	private ArrayList<Card> cardList = new ArrayList<Card>();
	
	public Program()
	{
	}
	
	// getter and setter for program
	
	public void setCardList(ArrayList<Card> cardList)
	{
		this.cardList = cardList;
	}
	
	public ArrayList<Card> getCardList()
	{
		return this.cardList;
	}
	
	// Simulates process of taking a card from the top of a program
	
	public Card getTopOfProgram()
	{
		Card topCard = cardList.get(0);
		cardList.remove(0);
		return topCard;
	}

}
