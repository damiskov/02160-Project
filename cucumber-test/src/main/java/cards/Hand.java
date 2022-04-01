package cards;

import java.util.List;

public class Hand 
{
    private List<Card> cardList;

    public Hand(List<Card> cardList)
    {
        this.cardList = cardList;
    }

    public List<Card> getHand()
    {
        return cardList;
    }
}
