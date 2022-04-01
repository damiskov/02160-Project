package cards;

public class CardFactory
{
    public Card getCard(String action)
    {
        if (action.equals("move1"))
        {
            return new Move1();
        }
        else if (action.equals("move2"))
        {
            return new Move2();
        }
        else if (action.equals("move3"))
        {
            return new Move3();
        }
        else if (action.equals("turnLeft"))
        {
            return new turnLeft();
        }
        else if (action.equals("turnRight"))
        {
            return new turnRight();
        }
        else if (action.equals("backUp"))
        {
            return new backUp();
        }
        else if (action.equals("uTurn"))
        {
            return new uTurn();
            
        }
		return null;
    }
}