package view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import utils.ImageUtils;

// This is a panel containing a single card image, its priority, and its selection status (SelectionIcon). CardPanel has nine of these
public class CardSelectionPanel extends JPanel {

	private static final long serialVersionUID = -2862362827324913955L;
	
	private static final int cardWidth = (int) (191*0.4);
	private static final int cardHeight = (int) (266*0.4);;

	private JButton cardButton;
	private JLabel priorityLabel;
	private SelectionIcon selectionIcon;
	private String cardID;
	private int cardNum;
	
	public CardSelectionPanel(String cardID, int cardNum) {
		this.cardID = cardID; 
		this.cardNum = cardNum;
		
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		ImageIcon icon = new ImageIcon(ImageUtils.scaledImage("/" + cardID + ".png", cardWidth, cardHeight));
		cardButton = new JButton(icon);
		cardButton.setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
		cardButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(cardButton);
		
		add(Box.createRigidArea(new Dimension(0, 5)));
		
		priorityLabel = new JLabel(String.valueOf(cardNum));
		priorityLabel.setFont(new Font(priorityLabel.getFont().getName(), Font.BOLD | Font.ITALIC, 14));
		priorityLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(priorityLabel);
		
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

	public int getCardNum() {
		return cardNum;
	}

	public void setCardNum(int cardNum) {
		this.cardNum = cardNum;
	}




}
