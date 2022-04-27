package view;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import board.Game;
import board.Position;
import controller.MasterController;
import property_changes.GameWinEvent;
import property_changes.HealthChangeEvent;
import property_changes.IPropertyChangeEvent;
import property_changes.PropertyChangeListener;
import utils.GridBagLayoutUtils;





public class MasterView extends JFrame implements PropertyChangeListener {
	
	private static final long serialVersionUID = 3L;
	
	private MasterController controller;
	
	private BoardPanel boardPanel;
	private JPanel cardPanel;
	private StatusPanel statusPanel;
	
	// for testing
	private JButton blackScreenButton;
	private JButton winScreenButton;
	//
	
	private BlackScreen blackScreen;
	
	public MasterView(MasterController masterController, Game game) {
		this.controller = masterController;
		initGUI(game);
	}

	private void initGUI(Game game) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("RoboRally Game of " + controller.playerCount + " players on " + controller.difficulty + " difficulty");
		
		setLayout(new GridBagLayout());
		
		boardPanel = new BoardPanel(game.getBoard());
		cardPanel = new CardPanel(this, controller);
		statusPanel = new StatusPanel(game.getNumPlayers());
		
		blackScreen = new BlackScreen(this);
		
		// temporary
		blackScreenButton = new JButton("Black screen");
		blackScreenButton.addActionListener(e -> displayBlackScreen(2));
		winScreenButton = new JButton("Move robot 2 forward");
		winScreenButton.addActionListener(e -> game.getBoard().getRobotAt(new Position(0, 3)).move(1));
		// Button for assign programs to robots
		
		addElements();
		pack();
		
		setVisible(true);
		
		// maximize the window
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
	}
	
	private void displayWinScreen(int winningPlayerNum) {
		removeElements();
		addWinScreen(winningPlayerNum);
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
		
		// temporary
		add(blackScreenButton, GridBagLayoutUtils.constraint(1, 1, 0));
		add(winScreenButton, GridBagLayoutUtils.constraint(2, 1, 0));

		// 
		
		revalidate();
		repaint();
	}
	
	private void removeElements() {
		remove(boardPanel);
		remove(cardPanel);
		remove(statusPanel);
		
		// temporary
		remove(blackScreenButton);
		remove(winScreenButton);
		//
	}
	
	private void addBlackScreen(int playerTurn) {
		setLayout(new BorderLayout());
		add(blackScreen, BorderLayout.CENTER);
		blackScreen.setPlayerTurnText(playerTurn);
		revalidate();
		repaint();
	}
	
	private void addWinScreen(int winningPlayerNum) {
		setLayout(new BorderLayout());
		add(new WinScreen(this, winningPlayerNum), BorderLayout.CENTER);
		revalidate();
		repaint();
	}
	
	private void removeBlackScreen() {
		remove(blackScreen);
	}

	@Override
	public void propertyChange(IPropertyChangeEvent pce) {
		if (pce instanceof HealthChangeEvent) {
			HealthChangeEvent hce = (HealthChangeEvent) pce;
			statusPanel.setHealth(hce.getRobotNum(), hce.getHealth());
		} else if (pce instanceof GameWinEvent) {
			GameWinEvent gwe = (GameWinEvent) pce;
			displayWinScreen(gwe.getWinningPlayerNum());
		} else {
			boardPanel.propertyChange(pce);
		}	
	
	}

//	public void addAssignCardsButton() {
//		setLayout(new BorderLayout());
//		add(assignCardsButton, GridBagLayoutUtils.constraint(1, 2, 0));
//		revalidate();
//		repaint();
//		
//	}
//
//	public void removeAssignCardsButton() {
//		remove(assignCardsButton);
//		
//	}
//	
//	public void displayAssignCardsButton(List<CardSelectionPanel> cards)
//	{
//		if (cards.size()==5)
//		{
//			
//		}
//			
//		
//	}
}
