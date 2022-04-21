package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import board.Game;
import board.IBoard;
import board.PropertyChangeEvent;
import controller.MasterController;
import utils.GridBagLayoutUtils;

public class MasterView extends JFrame implements PropertyChangeListener {
	
	private static final long serialVersionUID = 3L;
	
	private MasterController controller;
	
	private BoardPanel boardPanel;
	private JPanel cardPanel;
	private StatusPanel statusPanel;
	
	// for testing
	private JButton blackScreenButton;
	
	private BlackScreen blackScreen;
	
	public MasterView(MasterController masterController, Game game) {
		this.controller = masterController;
		initGUI(game.getBoard());
	}

	private void initGUI(IBoard board) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("RoboRally Game of " + controller.playerCount + " players on " + controller.difficulty + " difficulty");
		
		setLayout(new GridBagLayout());
		
		boardPanel = new BoardPanel(board);
		cardPanel = new CardPanel();
		statusPanel = new StatusPanel();
		
		blackScreen = new BlackScreen(this);
		
		// temporary
		blackScreenButton = new JButton("Black screen");
		MasterView masterView = this;
		blackScreenButton.addActionListener(e -> {
			masterView.displayBlackScreen(2);
		});
		
		addElements();
		pack();
		
		setVisible(true);
		
		// maximize the window
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
	}
	
	public void displayBlackScreen(int playerTurn) {
		removeElements();
		addBlackScreen(playerTurn);
	}
	
	public void hideBlackScreen() {
		removeBlackScreen();
		addElements();
	}

	private void addElements() {
		setLayout(new GridBagLayout());
		add(boardPanel, GridBagLayoutUtils.constraint(0, 0, 10));
		add(cardPanel, GridBagLayoutUtils.constraint(0, 1, 10));
		
		GridBagConstraints spConstraint = new GridBagConstraints();
		spConstraint.gridx = 1;
		spConstraint.gridy = 0;
		spConstraint.fill = GridBagConstraints.VERTICAL;
		add(statusPanel, spConstraint);
		
		add(blackScreenButton, GridBagLayoutUtils.constraint(1, 1, 0));
		revalidate();
		repaint();
	}
	
	private void removeElements() {
		remove(boardPanel);
		remove(cardPanel);
		remove(statusPanel);
		remove(blackScreenButton);
	}
	
	private void addBlackScreen(int playerTurn) {
		setLayout(new BorderLayout());
		add(blackScreen, BorderLayout.CENTER);
		blackScreen.setPlayerTurnText(playerTurn);
		revalidate();
		repaint();
	}
	
	private void removeBlackScreen() {
		remove(blackScreen);
	}

	@Override
	public void propertyChange(PropertyChangeEvent pci) {
		boardPanel.propertyChange(pci);
		
	}
}
