package cards;
import piece_basics.Robot;

public class Move3 extends Card 
{
    public Move3()
    {
        super("move3");
    }

    @Override
    public void executeAction(Robot r)
    {
        r.move(3);
    }
    
    @Override
    public Card getOppositeCard() {
    	return new back3();
    }
}
