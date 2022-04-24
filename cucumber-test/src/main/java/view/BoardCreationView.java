package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import board.Board;
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
	
	private Board newBoard;
	
	// for testing
	
	public BoardCreationView(BoardCreationController boardCreationController) {
		setController(boardCreationController);
		initGUI();
	}
	
	
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("RoboRally Board Creator");
		
		setLayout(new GridBagLayout());
		
		boardPanel = new BoardCreationPanel(12, 12, controller, newBoard);
		elements = new ElementSelectionPanel(controller);
		
		cancelButton = new JButton("Cancel");
		createButton = new JButton("Create");
		
		cancelButton.addActionListener(e -> {
			controller.initiateSetupMenu();
		}); 
		
		createButton.addActionListener(e -> {
			//call method in controller that given a board of cells creates a text file
			
		}); 
		
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
		
		add(cancelButton, GridBagLayoutUtils.constraint(1, 1, 0));
		add(createButton, GridBagLayoutUtils.constraint(1, 2, 0));
		revalidate();
		repaint();
	}
	
	private void setController(BoardCreationController boardCreationController) {
		controller = boardCreationController;
	}
	
	
	
	
}
