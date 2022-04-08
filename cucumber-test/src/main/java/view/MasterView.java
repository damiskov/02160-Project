package view;

import java.awt.Dimension;

import javax.swing.JFrame;

import controller.ApplicationController;

public class MasterView extends JFrame{
	
	private ApplicationController controller;
	
	public MasterView(ApplicationController controller) {
		this.controller = controller;
		initGUI();
	}

	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("RoboRally Game");
		setPreferredSize(new Dimension(800, 600));
		
	}
}
