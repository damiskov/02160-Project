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
            return new TurnLeft();
        }
        else if (action.equals("turnRight"))
        {
            return new TurnRight();
        }
        else if (action.equals("backUp"))
        {
            return new BackUp();
        }
        else /*if (action.equals("uTurn"))*/
        {
            return new UTurn();
            
        }
		//return null;
    }
}