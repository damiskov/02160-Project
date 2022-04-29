package view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

import cards.Card;
import cards.CardFactory;
import controller.MasterController;


public class CardPanel extends JPanel {

	private static final long serialVersionUID = 4888662845263342484L;
	
	MasterView mv;
	MasterController mc;
	
	int card_width;
	int card_height;
	int number_cards;
	int space_between_cards;

	int canvas_width;
	int canvas_height;

	private List<CardSelectionPanel> hand = new ArrayList<>();
	private List<CardSelectionPanel> orderedCards = new ArrayList<>();
	private boolean buttonPressed;
	
	
	JButton assignCardsButton;
	JButton button_b;

	public CardPanel(MasterView mv, MasterController mc) {
		System.out.println("Current Player: " + mc.getCurrentPlayer());
		System.out.println("Next Player: " + (mc.getCurrentPlayer()+1));
		
		// Gets cards from player hand and creates card panel list with becomes card panel 
		
		// setCardPanel();
		
		// Asssigning attributes
		
		this.mc = mc;
		this.mv = mv;
		
//		assignCardsButton = new AssignCardsButton(mv, Color.BLUE, mc);
		String emoji = new String(Character.toChars((int)0x1F916));
		
		assignCardsButton = new JButton("Assign to " + emoji);
		add(assignCardsButton);
		assignCardsButton.setEnabled(false);
		
		assignCardsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (mc.getCurrentPlayer()==mc.playerCount-1)
				{
					// Execute activation phase
					System.out.println("Activation phase should be executed");
				}
				else
				{
					
					
					List<Card> cards = new ArrayList<>();
					
					// Iterating over card selection panels, and mapping to card objects using cardFactory method
					CardFactory cf = new CardFactory();
					
					for (CardSelectionPanel c : orderedCards)
					{
						cards.add(cf.getCard(c.getCardID()));
					}
					
					// Assigns selected cards to robot
					
					mc.assignCards(cards);
					
	    			// incrementing current player
	//				// and setCardPanel (new player's hand shown)
	//				
					
	
					mc.incrementCurrentPlayer();
					
				
					mc.displayCardPanelControl();
				}

			}

		}); 

		setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
		
		setCardPanel();
		
		for (CardSelectionPanel csp : hand) {
			SelectionIcon selectionIcon = csp.getSelectionIcon();
			JButton cardButton = csp.getCardButton();

			cardButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("button " + cardButton.getName() + " clicked");

					if (!orderedCards.contains(csp) && orderedCards.size()<5) {
						orderedCards.add(csp);
						System.out.println("BUTTON ADDED");
					}
					else
					{
						orderedCards.remove(csp);
						System.out.println("BUTTON REMOVED");
						// empty circle
						selectionIcon.empty();
					}
					
					// update selection icon numbers
					for (int i = 0; i < orderedCards.size(); i++) {
						System.out.println(i + 1 + " -> " + orderedCards.get(i).getCardButton().getName());
						orderedCards.get(i).getSelectionIcon().setNumber(i + 1);
					}
					
					if (orderedCards.size()==5)
					{
						assignCardsButton.setEnabled(true);
					}
					else
					{
						assignCardsButton.setEnabled(false);
					}

				}

			});
		}
	}


	// Uses master controller to access current player and get program


	private void setCardPanel()
	{
		ArrayList<Card> cardHand = mc.getGame().getPlayers()[mc.getCurrentPlayer()].getHand().getCardList();
		for (Card c : cardHand)
		{
			CardSelectionPanel b = new CardSelectionPanel(c.getAction());
			hand.add(b);
			add(b);
		} 
	}
	
}
