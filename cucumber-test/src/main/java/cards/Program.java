package cards;

import java.util.Stack;

public class Program {
	
	private Stack<Card> cardList = new Stack<Card>();
	
	public Program()
	{}
	
	// getter and setter for program
		public void setCardList(Stack<Card> cardList)
	{
		this.cardList=cardList;
	}
	
	public Stack<Card> getCardList()
	{
		return this.cardList;
	}
	
	// Simulates process of taking a card from the top of a program	
	public Card getTopOfProgram()
	{
		return cardList.pop();
	}

}
