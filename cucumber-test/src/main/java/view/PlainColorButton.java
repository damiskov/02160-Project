package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;

public class PlainColorButton extends JButton {

	private static final long serialVersionUID = 7870457398446646061L;

	protected final MasterView masterView;
	private Color color;


	public PlainColorButton(MasterView masterView, Color color) {
		this.masterView = masterView;
		this.color = color;
	}


	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setColor(color);
		g2.fillRect(0, 0, masterView.getWidth(), masterView.getHeight());
	}

}