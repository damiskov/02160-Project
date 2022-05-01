package cards;

import piece_basics.Robot;

public class BackUp extends Card 
{
    public BackUp()
    {
        super("backUp");
    }

    @Override
    public void executeAction(Robot r)
    {
        r.move(-1);
    }
    @Override
    public Card getOppositeCard()
    {
    	return new Move1();
    }
}