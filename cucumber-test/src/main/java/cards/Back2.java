
package cards;

import piece_basics.Robot;


public class Back2 extends Card {
	
    public Back2()
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
