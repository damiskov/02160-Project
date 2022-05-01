package view;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/*
 *  This is the part of the main UI that displays the player numbers, robot icons, and robot hearts showing the health of
 *  each player's robot. It is composed of RobotStatusIndicators, and the number of these depends on the number of players in the game
 */
public class StatusPanel extends JPanel {
	
	private static final long serialVersionUID = 7879846621866023722L;
	
	private RobotStatusIndicator[] statusIndicators;

	public StatusPanel(int numPlayers) {
		statusIndicators = new RobotStatusIndicator[numPlayers];
		
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		
		for (int i = 0; i < numPlayers; i++) {
			RobotStatusIndicator rsi = new RobotStatusIndicator(i+1);
			add(rsi);
			statusIndicators[i] = rsi;
			
			add(Box.createRigidArea(new Dimension(0, 5)));
		}
		
		add(Box.createVerticalGlue());
	}
	
	public void setHealth(int robotNum, int health) {
		statusIndicators[robotNum-1].setHealth(health);
	}
}
