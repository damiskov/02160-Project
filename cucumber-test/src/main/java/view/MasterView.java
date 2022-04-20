package view;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	
	
	public MasterView(MasterController masterController) {
		this.controller = masterController;
		initGUI();
	}

	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("RoboRally Game of " + controller.playerCount + " players on " + controller.difficulty + " difficulty");
		
		setLayout(new GridBagLayout());
		
		boardPanel = new BoardPanel(10, 12);
		cardPanel = new CardPanel();
		
		add(boardPanel, GridBagLayoutUtils.constraint(0, 0, 0));
		add(cardPanel, GridBagLayoutUtils.constraint(0, 1, 0));
		JButton btnStart = new JButton("Start Game");
		btnStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//boardPanel.addSprite("robot", 0, 0, 0);
				//boardPanel.removeSprite("robot", 8, 8);
			}
		});
		add(btnStart, GridBagLayoutUtils.constraint(0, 2, 0));
		
		pack();
		setVisible(true);
		
		// maximize the window
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
	}
}
