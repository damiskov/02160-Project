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

	private Image move1, move2, move3, turnLeft, turnRight, moveBack, uTurn;
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
		number_cards = 7;
		card_width = 96;
		card_height = 133;
		space_between_cards = 10;

		canvas_width = (card_width + space_between_cards) * 9;
		canvas_height = card_height + 2 * space_between_cards;

//		setPreferredSize(new Dimension(canvas_width, canvas_height));

		// create buttons with images according to move

		setLayout(new FlowLayout());

		CardSelectionPanel b1 = new CardSelectionPanel("move1");
		hand.add(b1);
		add(b1);

		CardSelectionPanel b2 = new CardSelectionPanel("turnleft");
		hand.add(b2);
		add(b2);

		CardSelectionPanel b3 = new CardSelectionPanel("movebackward");
		hand.add(b3);
		add(b3);

		CardSelectionPanel b4 = new CardSelectionPanel("move3");
		hand.add(b4);
		add(b4);

		CardSelectionPanel b5 = new CardSelectionPanel("move2");
		hand.add(b5);
		add(b5);

		CardSelectionPanel b6 = new CardSelectionPanel("turnright");
		hand.add(b6);
		add(b6);

		CardSelectionPanel b7 = new CardSelectionPanel("uturn");
		hand.add(b7);
		add(b7);

		for (int i = 0; i < hand.size(); i++) {
			CardSelectionPanel csp = hand.get(i);
			SelectionIcon icon = csp.getSelectionIcon();

			csp.getCardButton().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {

					// refer to JButton clicked
					Object source = e.getSource();
					if (source instanceof JButton) {
						JButton btn = (JButton) source;

						System.out.println("button " + btn.getName() + " clicked");

						if (orderedCards.contains(csp)) {
							orderedCards.remove(csp);
							System.out.println("BUTTON REMOVED");
							
							// empty circle
							icon.empty();
						} else {
							orderedCards.add(csp);
							System.out.println("BUTTON ADDED");
						}

						for (int i = 0; i < orderedCards.size(); i++) {

							System.out.println(i + 1 + " -> " + orderedCards.get(i).getName());
							orderedCards.get(i).getSelectionIcon().setNumber(i + 1);

						}
					}

				}

			});

		}

//        jB.addActionListener(new TheHandler());

	}

	private Image createImage(String path, int card_width, int card_height) {

		ImageIcon image1 = new ImageIcon(path);
		Image image2 = image1.getImage().getScaledInstance(card_width, card_height, 0);

		return image2;
	}

//	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

	}
}
