package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import utils.ImageUtils;

public class CardSelectionPanel extends JPanel {

	private static final long serialVersionUID = -2862362827324913955L;

	private JButton cardButton;
	private SelectionIcon selectionIcon;
	
	public CardSelectionPanel(String cardID) {
		
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
//		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		ImageIcon icon = new ImageIcon(ImageUtils.scaledImage("images/" + cardID + ".png", 96, 133));
		cardButton = new JButton(icon);
		cardButton.setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
		cardButton.setAlignmentX(Component.CENTER_ALIGNMENT);
//		cardButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		add(cardButton);
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
}
