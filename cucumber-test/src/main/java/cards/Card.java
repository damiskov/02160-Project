package cards;

import piece_basics.Robot;

public class Card 
{
    private String action;
    private int num;
       
    //for the name of the card
    public Card(String action)
    {
        this.action = action;  
    }


	public void setNum(int num)
    {
        this.num = num;
    }

    public int getNum()
    {
        return num;
    }
   
    public void executeAction(Robot r) {   
    }
    
    //needed to reverse the card by using the reversal panel
    public Card getOppositeCard() {
    	return null;
    }
    
    //needed in the view so no coverage
    public String getAction() {
    	return this.action;
    }

}