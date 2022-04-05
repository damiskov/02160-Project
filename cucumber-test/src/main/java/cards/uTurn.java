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
    
    @Override
    public Card getOppositeCard() {
    	return new uTurn(); //this one does not get reversed by the panel (agreed with David)
    }
}
