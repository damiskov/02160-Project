package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Action;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import cards.Card;
import cards.CardFactory;

import controller.MasterController;

public class AssignCardsButton extends JButton {

	private static final long serialVersionUID = 7870457398446646061L;

	protected final MasterView masterView;
	private MasterController mc;
	private Color color;
	private JLabel textLabel;


	public AssignCardsButton(MasterView masterView, Color color, MasterController mc) {
		this.masterView = masterView;
		this.mc = mc;
		this.color = color;
		
		setLayout(new BorderLayout());
		
		JPanel middlePanel = new JPanel();
		middlePanel.setLayout(new BoxLayout(middlePanel, BoxLayout.PAGE_AXIS));
		middlePanel.setBackground(new Color(0, 0, 0, 0));
		add(middlePanel, BorderLayout.CENTER);
		
		middlePanel.add(Box.createVerticalGlue());
		textLabel = new JLabel("", SwingConstants.CENTER);
		textLabel.setForeground(new Color(255, 255, 255));
		textLabel.setFont(new Font(textLabel.getFont().getName(), Font.BOLD, 50));
		textLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		middlePanel.add(textLabel);
	}
	
	// Mapping card selection panels to cards, so that a program can be assigned to a robot
	public void cardSelectionPanelToCards(int player, List<CardSelectionPanel> program)
	{
		List<Card> cards = new ArrayList<Card>();
		
		// Iterating over card selection panels, and mapping to card objects using cardFactory method
		
		for (CardSelectionPanel c : program)
		{
			cards.add(CardFactory.getCard(c.getCardID()));
		}
		
		mc.assignCards(player, cards);
		
	}


	

}