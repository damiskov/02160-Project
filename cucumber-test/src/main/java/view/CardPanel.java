package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import utils.GridBagLayoutUtils;
import utils.ImageUtils;

public class CardPanel extends JPanel {

	private static final long serialVersionUID = 4888662845263342484L;

	int card_width;
	int card_height;
	int number_cards;
	int space_between_cards;

	int canvas_width;
	int canvas_height;

	private List<CardSelectionPanel> hand = new ArrayList<>();
	private List<CardSelectionPanel> orderedCards = new ArrayList<>();

	JButton button_b;

	public CardPanel() {

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
		for (String id: List.of("move1", "turnleft", "movebackward", "move3", "move2", "turnright", "uturn")) {
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

					if (orderedCards.contains(csp)) {
						orderedCards.remove(csp);
						System.out.println("BUTTON REMOVED");
						// empty circle
						selectionIcon.empty();
					} else {
						orderedCards.add(csp);
						System.out.println("BUTTON ADDED");
					}
					
					// update selection icon numbers
					for (int i = 0; i < orderedCards.size(); i++) {
						System.out.println(i + 1 + " -> " + orderedCards.get(i).getCardButton().getName());
						orderedCards.get(i).getSelectionIcon().setNumber(i + 1);
					}

				}

			});
		}
	}

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
