package cards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


class Deck
{
    
    List<String> actions = Arrays.asList("move1", "move2", "move3", "turnRight", "turnLeft", "backUp", "uTurn");
    List<Card> cards = new ArrayList<>();
    List<Integer> numbers = new ArrayList<>();
    


    public Deck()
    {
        // Generating base deck 
        addToDeck("move1", 48);
        addToDeck("move2", 24);
        addToDeck("move3", 8);
        addToDeck("turnLeft", 24);
        addToDeck("turnRight", 24);
        addToDeck("uTurn", 16);
        addToDeck("backUp", 16);
        for (int i = 1; i <= actions.size(); i++)
        {
            numbers.add(i);
        }

    }

    // adds a certain "action" "num" amount of times to deck
    public void addToDeck(String action, int num)
    {
        for (int i = 0; i < num; i++)
        {
            
            cards.add(new Card(action));
        }
    }

    // Generating a hand 

    public ArrayList<Card> genHand()
    {
        // empty hand
        ArrayList<Card> hand = new ArrayList();
        // 0 - 8 (9 cards in hand)
        for (int i = 0; i < 9; i++)
        {
            // Getting random card from deck
            Random rand  = new Random();
            int x = rand.nextInt(cards.size());
            int y = rand.nextInt(numbers.size());
            // adding card to hand
            Card c = cards.get(x);
            c.setNum(y);
            hand.add(c);
            // removing taken card from deck
            cards.remove(x);
            numbers.remove(y);
        }
        return hand;
    }
}