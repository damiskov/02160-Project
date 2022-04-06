
package cards;

import piece_basics.Robot;


public class back3 extends Card {
	
    public back3()
    {
        super("back3");
    }

    @Override
    public void executeAction(Robot r)
    {
        r.move(-3);
    }
    
    @Override
    public Card getOppositeCard() {
    	return new Move3();
    }
}
