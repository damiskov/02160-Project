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
		
		add(new RobotStatusIndicator());
		add(Box.createRigidArea(new Dimension(0, 5)));
		add(new RobotStatusIndicator());
		add(Box.createVerticalGlue());
//		
//		setPreferredSize(new Dimension(500, 800));
		
	}
}
