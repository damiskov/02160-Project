package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.MasterController;
import utils.GridBagLayoutUtils;

public class MasterView extends JFrame{
	
	
	private static final long serialVersionUID = 3L;
	
	private MasterController controller;
	
	private BoardPanel boardPanel;
	private JPanel cardPanel;
	private StatusPanel statusPanel;
	
	// for testing
	private JButton blackScreenButton;
	
	private JButton blackScreen;
	
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
		statusPanel = new StatusPanel();
		
		blackScreen = new BlackScreen(this);
		
		// temporary
		blackScreenButton = new JButton("Black screen");
		MasterView masterView = this;
		blackScreenButton.addActionListener(e -> {
			System.out.println("Button pressed");
			masterView.removeElements();
			masterView.addBlackScreen();
		});
		
		addElements();
		pack();
		
		System.out.println(getWidth());
		
		setVisible(true);
		
		// maximize the window
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
	}

	public void addElements() {
		setLayout(new GridBagLayout());
		add(boardPanel, GridBagLayoutUtils.constraint(0, 0, 0));
		add(cardPanel, GridBagLayoutUtils.constraint(0, 1, 0));
		
		GridBagConstraints spConstraint = new GridBagConstraints();
		spConstraint.gridx = 1;
		spConstraint.gridy = 0;
		spConstraint.fill = GridBagConstraints.VERTICAL;
		add(statusPanel, spConstraint);
		
		add(blackScreenButton, GridBagLayoutUtils.constraint(1, 1, 0));
		revalidate();
		repaint();
	}
	
	public void removeElements() {
		remove(boardPanel);
		remove(cardPanel);
		remove(statusPanel);
		remove(blackScreenButton);
	}
	
	public void addBlackScreen() {
		setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		add(blackScreen);
		blackScreen.setPreferredSize(new Dimension(getWidth(), getHeight()));
		revalidate();
		repaint();
	}
	
	public void removeBlackScreen() {
		remove(blackScreen);
	}
}
