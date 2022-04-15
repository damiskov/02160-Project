package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JButton;

public class BlackScreen extends JButton {

	MasterView masterView;
	
	public BlackScreen(MasterView masterView) {
		this.masterView = masterView;
		addActionListener(e -> {
			this.masterView.removeBlackScreen();
			this.masterView.addElements();
		});
	}
	
	@Override
	public void paintComponent(Graphics g) {
		// TODO: Add text specifying whose turn it is
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setColor(new Color(0, 0, 0));
		g2.fillRect(0, 0, masterView.getWidth(), masterView.getHeight());
	}
}
