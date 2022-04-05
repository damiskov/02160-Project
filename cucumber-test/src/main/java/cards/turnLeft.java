package cards;
import piece_basics.Robot;

public class turnLeft extends Card 
{
    public turnLeft()
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
    	return new turnRight();
    }
}