package cards;


public class Card
{
    private String action;
    private int num;
    public Card(String action)
    {
        this.action = action;
        setNum();
    }

    public void setNum()
    {
        this.num = 0;
    }

    public int getNum()
    {
        return num;
    }

    public String getAction()
    {
        return action;
    }

    public void executeAction() {}
}