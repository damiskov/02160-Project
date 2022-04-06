
package cards;

import piece_basics.Robot;


public class back2 extends Card {
	
    public back2()
    {
        super("back2");
    }

    @Override
    public void executeAction(Robot r)
    {
        r.move(-2);
    }
    
    @Override
    public Card getOppositeCard() {
    	return new Move2();
    }
}
