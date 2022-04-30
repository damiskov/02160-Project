package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

// This is the panel that shows up between turns in the programming phase, with the text "Player _'s turn, click anywhere to continue"
public class BlackScreen extends PlainColorButton {

	private static final long serialVersionUID = -2388904970660794174L;

	private JPanel middlePanel;
	private JLabel textLabel;
	private JLabel subTextLabel;
	
	public BlackScreen(MasterView masterView) {
		super(masterView, new Color(0, 0, 0));
		
		addActionListener(e -> {
			this.masterView.hideBlackScreen();
		});
		
		setLayout(new BorderLayout());
		
		// middlePanel is centered in the middle of the BlackScreen and contains the two text boxes (JLabels)
		middlePanel = new JPanel();
		middlePanel.setLayout(new BoxLayout(middlePanel, BoxLayout.PAGE_AXIS));
		middlePanel.setBackground(new Color(0, 0, 0, 0));
		add(middlePanel, BorderLayout.CENTER);
		
		middlePanel.add(Box.createVerticalGlue());
		
		textLabel = new JLabel("", SwingConstants.CENTER);
		textLabel.setForeground(new Color(255, 255, 255));
		textLabel.setFont(new Font(textLabel.getFont().getName(), Font.BOLD, 50));
		textLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		middlePanel.add(textLabel);
		
		subTextLabel = new JLabel("Click anywhere to continue", SwingConstants.CENTER);
		subTextLabel.setForeground(new Color(255, 255, 255));
		subTextLabel.setFont(new Font(textLabel.getFont().getName(), Font.PLAIN, 40));
		subTextLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		middlePanel.add(subTextLabel);
		
		middlePanel.add(Box.createVerticalGlue());
		
	}
	
	public void setPlayerTurnText(int playerNum) {
		textLabel.setText("Player " + playerNum + "'s turn");
	}
}
