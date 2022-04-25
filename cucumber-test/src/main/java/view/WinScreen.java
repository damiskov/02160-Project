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

public class WinScreen extends PlainColorButton {

	private static final long serialVersionUID = -7740278418036061227L;
	
	private JPanel middlePanel;
	private JLabel textLabel;

	public WinScreen(MasterView masterView, int winningPlayerNum) {
		super(masterView, new Color(0, 100, 0));
		
		setLayout(new BorderLayout());
		
		middlePanel = new JPanel();
		middlePanel.setLayout(new BoxLayout(middlePanel, BoxLayout.PAGE_AXIS));
		middlePanel.setBackground(new Color(0, 0, 0, 0));
		add(middlePanel, BorderLayout.CENTER);
		
		middlePanel.add(Box.createVerticalGlue());
		
		textLabel = new JLabel("Player " + winningPlayerNum + " won!", SwingConstants.CENTER);
		textLabel.setForeground(new Color(255, 255, 255));
		textLabel.setFont(new Font(textLabel.getFont().getName(), Font.BOLD, 80));
		textLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		middlePanel.add(textLabel);
		
		middlePanel.add(Box.createVerticalGlue());
	}

}
