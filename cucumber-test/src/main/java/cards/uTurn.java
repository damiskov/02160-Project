package cards;
import piece_basics.Robot;

public class uTurn extends Card 
{
    public uTurn()
    {
        super("uTurn");
    }

    @Override
    public void executeAction(Robot r)
    {
        r.turnRight();
        r.turnRight();
    }
}
