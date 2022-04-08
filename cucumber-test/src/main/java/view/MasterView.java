package view;

import java.awt.Dimension;

import javax.swing.JFrame;

import controller.MasterController;

public class MasterView extends JFrame{
	
	
	private static final long serialVersionUID = 3L;
	
	private MasterController controller;
	
	public MasterView(MasterController masterController) {
		this.controller = masterController;
		initGUI();
	}

	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("RoboRally Game of " + controller.playerCount + " players on " + controller.difficulty + " difficulty");
		setPreferredSize(new Dimension(800, 600));
		setLayout(null);
		pack();
	}
}
