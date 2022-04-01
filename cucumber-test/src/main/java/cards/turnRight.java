package cards;

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
