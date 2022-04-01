package cards;

public class Move1 extends Card 
{
    public Move1()
    {
        super("move1");
    }

    @Override
    public void executeAction(Robot r)
    {
        r.move(1);
    }
}
