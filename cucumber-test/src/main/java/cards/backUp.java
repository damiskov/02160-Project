package cards;

import piece_basics.Robot;

public class backUp extends Card 
{
    public backUp()
    {
        super("backUp");
    }

    @Override
    public void executeAction(Robot r)
    {
        r.move(-1);
    }
}