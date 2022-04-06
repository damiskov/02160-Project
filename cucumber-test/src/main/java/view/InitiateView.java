package view;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;

import controller.InitiateController;

import utils.GridBagLayoutUtils;

public class InitiateView extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	private JSlider sliderPlayers;
	private JButton btnStart;
	private InitiateController controller;
	
	public InitiateView(InitiateController controller) {
		this.controller = controller;
		initGUI();
	}

	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setTitle("Select number of players");
		setLayout(new GridBagLayout());
		
		sliderPlayers = new JSlider(2,8,2);
		sliderPlayers.setMajorTickSpacing(1);
		//sliderPlayers.setPaintTicks(true);
		sliderPlayers.setPaintLabels(true);
		
		btnStart = new JButton("Start Game");
		btnStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.setPlayers(sliderPlayers.getValue());
			}
		});
		
		add(new JLabel("No. of players:"), GridBagLayoutUtils.constraint(0, 0, 5));
		add(sliderPlayers, GridBagLayoutUtils.constraint(1, 0, 5));
		add(btnStart, GridBagLayoutUtils.constraint(1, 1, 5));
		
		pack();
		setLocationRelativeTo(null);
	}
	

}
