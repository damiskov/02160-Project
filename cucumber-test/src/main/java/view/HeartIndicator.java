package view;

import java.awt.FlowLayout;

import javax.swing.JPanel;

/* 
 * This is the row of hearts displayed for each robot. It is composed of three HeartLabels, and it is itself contained
 * within RobotStatusIndicator
 */
public class HeartIndicator extends JPanel {

	private static final long serialVersionUID = 8951516382973753055L;
	
	private int maxHealth;
	private HeartLabel[] hearts;
	
	public HeartIndicator(int maxHealth) {
		this.maxHealth = maxHealth;
		
		setLayout(new FlowLayout(FlowLayout.LEFT, 4, 4));
		
		hearts = new HeartLabel[maxHealth];
		
		for (int i = 0; i < maxHealth; i++) {
			HeartLabel hl = new HeartLabel();
			hearts[i] = hl;
			add(hl);
		}
	}
	
	public void setHealth(int health) {
		for (int i = 0; i < health; i++) {
			hearts[i].fill();
		}
		for (int i = health; i < maxHealth; i++) {
			hearts[i].empty();
		}
	}
}
