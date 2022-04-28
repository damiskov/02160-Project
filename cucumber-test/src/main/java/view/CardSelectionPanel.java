package view;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import utils.ImageUtils;

public class CardSelectionPanel extends JPanel {

	private static final long serialVersionUID = -2862362827324913955L;
	
	private static final int cardWidth = (int) (96*0.8);
	private static final int cardHeight = (int) (133*0.8);;

	private JButton cardButton;
	private SelectionIcon selectionIcon;
	private String cardID;
	
	public CardSelectionPanel(String cardID) {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		this.cardID = cardID; 
		
		ImageIcon icon = new ImageIcon(ImageUtils.scaledImage("images/" + cardID + ".png", cardWidth, cardHeight));
		cardButton = new JButton(icon);
		cardButton.setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
		cardButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		// temporary?
		cardButton.setName(cardID);
		//
		add(cardButton);
		
		add(Box.createRigidArea(new Dimension(0, 5)));
		
		selectionIcon = new SelectionIcon();
		selectionIcon.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(selectionIcon);
	}
	
	public JButton getCardButton() {
		return cardButton;
	}
	
	public SelectionIcon getSelectionIcon() {
		return selectionIcon;
	}
	
	public String getCardID()
	{
		return cardID;
	}



}
