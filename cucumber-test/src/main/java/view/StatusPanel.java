package view;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class StatusPanel extends JPanel {
	
	private static final long serialVersionUID = 7879846621866023722L;
	
	private RobotStatusIndicator[] statusIndicators;

	public StatusPanel() {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		// temporary, for testing
		RobotStatusIndicator rsi1 = new RobotStatusIndicator();
		rsi1.setHealth(4);
		add(rsi1);
		
		add(Box.createRigidArea(new Dimension(0, 5)));
		
		RobotStatusIndicator rsi2 = new RobotStatusIndicator();
		rsi2.setHealth(0);
		add(rsi2);
		
		add(Box.createVerticalGlue());
//		
//		setPreferredSize(new Dimension(500, 800));
		
	}
}
