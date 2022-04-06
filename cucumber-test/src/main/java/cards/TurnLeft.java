package cards;
import piece_basics.Robot;

public class TurnLeft extends Card 
{
    public TurnLeft()
    {
        super("turnLeft");
    }

    @Override
    public void executeAction(Robot r)
    {
        r.turnLeft();
    }
    
    @Override
    public Card getOppositeCard() {
    	return new TurnRight();
    }
}