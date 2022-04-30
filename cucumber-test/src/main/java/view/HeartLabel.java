package view;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import utils.ImageUtils;

// A single heart in the StatusPanel section of the UI. HeartIndicator is composed of three of these
public class HeartLabel extends JLabel {

	private static final long serialVersionUID = -7229470799707830165L;
	
	private static ImageIcon fullHeart = new ImageIcon(ImageUtils.scaledImage("images/heart.png", 30, 30));
	private static ImageIcon emptyHeart = new ImageIcon(ImageUtils.scaledImage("images/empty_heart.png", 30, 30));
	
	public HeartLabel() {
		setIcon(fullHeart);
	}
	
	public void fill() {
		setIcon(fullHeart);
	}
	
	public void empty() {
		setIcon(emptyHeart);
	}
}
