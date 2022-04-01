package cards;

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
}