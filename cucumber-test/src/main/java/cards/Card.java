package cards;

import piece_basics.Robot;

public class Card 
{
    private String action;
    private int num;
    
    
    
    
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
    
    public Card getOppositeCard() {
    	return null;
    }
    
    //needed in the view so no coverage
    public String getAction() {
    	return this.action;
    }


}