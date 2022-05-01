package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import utils.ImageUtils;

// This is the circle beneath every card and its priority indicating its selection status
public class SelectionIcon extends JLayeredPane {

	private static final long serialVersionUID = 7083580741010664302L;
	
	private static final int iconSize = 40;
	
	private static final ImageIcon emptyCircle = new ImageIcon(ImageUtils.scaledImage("/empty_circle.png", iconSize, iconSize));
	private static final ImageIcon fullCircle = new ImageIcon(ImageUtils.scaledImage("/green_circle.png", iconSize, iconSize));
	
	private JLabel circleLabel;
	private JLabel numberLabel;

	public SelectionIcon() {
		setPreferredSize(new Dimension(iconSize, iconSize));
		setMaximumSize(new Dimension(iconSize, iconSize));
		
		circleLabel = new JLabel(emptyCircle);
		circleLabel.setBounds(0, 0, iconSize, iconSize);
		add(circleLabel, JLayeredPane.DEFAULT_LAYER);
		
		numberLabel = new JLabel("", JLabel.CENTER);
		numberLabel.setFont(new Font(numberLabel.getFont().getName(), Font.BOLD, 16));
		numberLabel.setForeground(Color.WHITE);
		numberLabel.setBounds(0, 0, iconSize, iconSize);
		add(numberLabel, JLayeredPane.DEFAULT_LAYER);
		moveToFront(numberLabel);
	}
	
	// make the circle white and remove the number, used when deselecting a card
	public void empty() {
		circleLabel.setIcon(emptyCircle);
		numberLabel.setText("");
	}
	
	// make the circle green and add a number, used when selecting a card
	public void setNumber(int number) {
		circleLabel.setIcon(fullCircle);
		numberLabel.setText(String.valueOf(number));
	}
}
