package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import piece_basics.Robot;
import utils.ImageUtils;

/* 
 * This is a panel containing a single player number label, robot icon, and row of hearts (HeartIndicators) corresponding to the robot.
 * StatusPanel is composed of these, and the number depends on the number of players in the game
 */
public class RobotStatusIndicator extends JPanel {
	
	private static final long serialVersionUID = 7744319983490682363L;
	
	private JLabel playerNumberLabel;
	private JLabel robotIcon;
	private HeartIndicator heartIndicator;

	public RobotStatusIndicator(int playerNumber) {
		setLayout(new FlowLayout());
		
		playerNumberLabel = new JLabel("Player " + playerNumber);
		playerNumberLabel.setFont(new Font(playerNumberLabel.getFont().getName(), Font.BOLD, 18));
		add(playerNumberLabel);
		
		String imageFilepath = "images/robot" + playerNumber + ".png";
		robotIcon = new JLabel(new ImageIcon(ImageUtils.scaledImage(imageFilepath, 50, 50)));
		add(robotIcon);
		
		heartIndicator = new HeartIndicator(Robot.MAX_ROBOT_HEALTH);
		add(heartIndicator);
		
		setMaximumSize(new Dimension(getMaximumSize().width, robotIcon.getMaximumSize().height));
	}
	
	public void setHealth(int health) {
		heartIndicator.setHealth(health);
	}
}
