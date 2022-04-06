package cards;
import piece_basics.Robot;

public class UTurn extends Card 
{
    public UTurn()
    {
        super("uTurn");
    }

    @Override
    public void executeAction(Robot r)
    {
        r.turnRight();
        r.turnRight();
    }
    
    @Override
    public Card getOppositeCard() {
    	return new UTurn(); //this one does not get reversed by the panel (agreed with David)
    }
}
