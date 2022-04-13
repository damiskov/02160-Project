package cards;

import java.util.ArrayList;
import java.util.List;

public class Hand 
{
    private ArrayList<Card> cardList;

    public Hand()
    {

    }

    public ArrayList<Card> getHand()
    {
        return cardList;
    }
    
    public void setHand(ArrayList<Card> cardList)
    {
    	this.cardList = cardList;
    }
    
    
}
