package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class BlackScreen extends JButton {

	private MasterView masterView;
	
	private JPanel middlePanel;
	private JLabel textLabel;
	private JLabel subTextLabel;
	
	public BlackScreen(MasterView masterView) {
		this.masterView = masterView;
		addActionListener(e -> {
			this.masterView.hideBlackScreen();
		});
		
		setLayout(new BorderLayout());
		
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
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setColor(new Color(0, 0, 0));
		g2.fillRect(0, 0, masterView.getWidth(), masterView.getHeight());
	}
}
