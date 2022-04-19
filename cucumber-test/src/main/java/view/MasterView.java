package view;

import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.MasterController;
import utils.GridBagLayoutUtils;

public class MasterView extends JFrame{
	
	
	private static final long serialVersionUID = 3L;
	
	private MasterController controller;
	
	private BoardPanel boardPanel;
	private JPanel cardPanel;
	
	
	public MasterView(MasterController masterController) {
		this.controller = masterController;
		initGUI();
	}

	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("RoboRally Game of " + controller.playerCount + " players on " + controller.difficulty + " difficulty");
		
		setLayout(new GridBagLayout());
		
		boardPanel = new BoardPanel(12, 12);
		cardPanel = new CardPanel();
		
		add(boardPanel, GridBagLayoutUtils.constraint(0, 0, 0));
		add(cardPanel, GridBagLayoutUtils.constraint(0, 1, 0));
		
		
		pack();
		setVisible(true);
		
		// maximize the window
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
	}
}
