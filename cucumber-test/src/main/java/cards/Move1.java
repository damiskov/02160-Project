
package cards;

import piece_basics.Robot;


public class Move1 extends Card 
{
    public Move1()
    {
        super("move1");
    }

    @Override
    public void executeAction(Robot r)
    {
        r.move(1);
    }
    
    @Override
    public Card getOppositeCard() {
    	return new BackUp();
    }
}
