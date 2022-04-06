package cards;
import piece_basics.Robot;

public class TurnRight extends Card 
{
    public TurnRight()
    {
        super("turnRight");
    }

    @Override
    public void executeAction(Robot r)
    {
        r.turnRight();
    }
    
    @Override
    public Card getOppositeCard() {
    	return new TurnLeft();
    }
}
