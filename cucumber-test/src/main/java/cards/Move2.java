package cards;
import piece_basics.Robot;

public class Move2 extends Card 
{
    public Move2()
    {
        super("move2");
    }

    @Override
    public void executeAction(Robot r)
    {
        r.move(2);
    }
    
    @Override
    public Card getOppositeCard() {
    	return new Back2();
    }
}
