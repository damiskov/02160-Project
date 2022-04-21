package view;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import utils.ImageUtils;

public class RobotStatusIndicator extends JPanel {
	
	private static final long serialVersionUID = 7744319983490682363L;
	
	private JLabel robotIcon;
	private HeartIndicator heartIndicator;

	public RobotStatusIndicator(int playerNumber) {
		setLayout(new FlowLayout());
		
		String imageFilepath = "images/robot" + playerNumber + ".png";
		robotIcon = new JLabel(new ImageIcon(ImageUtils.scaledImage(imageFilepath, 50, 50)));
		add(robotIcon);
		
		heartIndicator = new HeartIndicator(5);
		add(heartIndicator);
		
		setMaximumSize(new Dimension(getMaximumSize().width, robotIcon.getMaximumSize().height));
	}
	
	public void setHealth(int health) {
		heartIndicator.setHealth(health);
	}
}
