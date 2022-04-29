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
				List<Card> cards = new ArrayList<>();
				
				// Iterating over card selection panels, and mapping to card objects using cardFactory method
//				CardFactory cf = new CardFactory();
//				
//				for (CardSelectionPanel c : orderedCards)
//				{
//					cards.add(cf.getCard(c.getCardID()));
//				}
//				
				// Assigns selected cards to robot
				
//				mc.assignCards(cards);
//				
//				// incrementing current player
//				// and setCardPanel (new player's hand shown)
//				
//				mc.incrementCurrentPlayer();
//				setCardPanel();

			}

		}); 
		// given a hand
		// go through that hand and for each card create a button
		
//		number_cards = 7;
		// card width and height are now specified as static final variables in CardSelectionPanel
//		card_width = 96;
//		card_height = 133;
//		space_between_cards = 10;
//
//		canvas_width = (card_width + space_between_cards) * 9;
//		canvas_height = card_height + 2 * space_between_cards;
//
//		setPreferredSize(new Dimension(canvas_width, canvas_height));

		// create buttons with images according to move

		setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));

		// temporary
		for (String id: List.of("move1", "turnLeft", "backUp", "move3", "move2", "turnRight", "uTurn")) {
			CardSelectionPanel b = new CardSelectionPanel(id);
			hand.add(b); 
			add(b);
		}
		//
		
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


//	private void setCardPanel()
//	{
//		ArrayList<Card> cardHand = mc.getGame().getPlayers()[mc.getCurrentPlayer()].getHand().getCardList();
//		for (Card c : cardHand)
//		{
//			CardSelectionPanel b = new CardSelectionPanel(c.getAction());
//			hand.add(b);
//		} 
//	}
	


//	private Image createImage(String path, int card_width, int card_height) {
//
//		ImageIcon image1 = new ImageIcon(path);
//		Image image2 = image1.getImage().getScaledInstance(card_width, card_height, 0);
//
//		return image2;
//	}
//
////	
//	@Override
//	public void paintComponent(Graphics g) {
//		super.paintComponent(g);
//
//	}
}
