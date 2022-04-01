package cards;
import piece_basics.Robot;

public class turnRight extends Card 
{
    public turnRight()
    {
        super("turnRight");
    }

    @Override
    public void executeAction(Robot r)
    {
        r.turnRight();
    }
}
