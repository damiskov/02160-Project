package cards;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck
{  
	
    private List<Card> cards = new ArrayList<>();
    private List<Integer> numbers = new ArrayList<>();
    
    public Deck()
    {
        regenDeck();
    }
    
    public List<Card> getCards(){
    	return cards;
    }
    
    private void regenDeck()
    {
    	this.cards = new ArrayList<>();
    	// Generating base deck having different probabilities
        addToDeck("move1", 48);
        addToDeck("move2", 24);
        addToDeck("move3", 8);
        addToDeck("turnLeft", 24);
        addToDeck("turnRight", 24);
        addToDeck("uTurn", 16);
        addToDeck("backUp", 16);
        for (int i = 1; i <= cards.size(); i++)
        {

            this.numbers.add(i);
        }
    	
    }
    

    // adds a certain "action" "num" amount of times to deck
    public void addToDeck(String action, int num)
    {
    	CardFactory cf = new CardFactory();
        for (int i = 0; i < num; i++)
        {   
            this.cards.add(cf.getCard(action));
        }
    }

    // Generating a hand 

    public Hand genHand()
    {
    	regenDeck();
        // empty hand
        ArrayList<Card> hand = new ArrayList<Card>();
        // 0 - 8 (9 cards in hand)
        for (int i = 0; i < 9; i++)
        {
            // Getting random card from deck
            Random rand  = new Random();
            int x = rand.nextInt(cards.size());
            int y = rand.nextInt(numbers.size());
            
            // adding card to hand
            Card c = cards.get(x);
            c.setNum(numbers.get(y));
            
            hand.add(c);
            // removing taken card from deck
            cards.remove(x);
            // Making sure we don't get duplicate numbers
            numbers.remove(y);
        }
        //creates hand from randomly taken cards
        Hand h = new Hand();
        h.setCardList(hand);
        return h;
    }
    
    public List<Card> getDeck()
    {
    	return cards;
    }
}