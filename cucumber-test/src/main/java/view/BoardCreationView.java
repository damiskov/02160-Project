package view;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.BoardCreationController;
import controller.MasterController;
import utils.GridBagLayoutUtils;

public class BoardCreationView extends JFrame{
	
	
	
		
	private static final long serialVersionUID = 5L;
	
	private BoardCreationController controller;
	
	
//	private BoardPanel boardPanel;
	private BoardCreationPanel boardPanel;
	private ElementSelectionPanel elements;
	private JButton cancelButton;
	private JButton createButton;
	
	// for testing
	
	public BoardCreationView(BoardCreationController boardCreationController) {
		this.controller = boardCreationController;
		initGUI();
	}
	
	
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("RoboRally Board Creator");
		
		setLayout(new GridBagLayout());
		
		boardPanel = new BoardCreationPanel(12, 12, controller);
		elements = new ElementSelectionPanel(controller);
		
		cancelButton = new JButton("Cancel");
		createButton = new JButton("Create");
		
		addElements();
		pack();
		
		setVisible(true);
		
		// maximize the window
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
	}
	
	private void addElements() {
		setLayout(new GridBagLayout());
		add(boardPanel, GridBagLayoutUtils.constraint(0, 0, 10));
		add(elements, GridBagLayoutUtils.constraint(1, 0, 10));
		
//		GridBagConstraints spConstraint = new GridBagConstraints();
//		spConstraint.gridx = 1;
//		spConstraint.gridy = 0;
//		spConstraint.fill = GridBagConstraints.VERTICAL;
//		add(elementSelectionPanel, spConstraint);
		
		add(cancelButton, GridBagLayoutUtils.constraint(1, 1, 0));
		add(createButton, GridBagLayoutUtils.constraint(1, 2, 0));
		revalidate();
		repaint();
	}
	
	private void removeElements() {
		remove(boardPanel);
	}
	
	
	
	
}
