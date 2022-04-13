package view;

import java.awt.FlowLayout;

import javax.swing.JPanel;

public class HeartIndicator extends JPanel {

	private static final long serialVersionUID = 8951516382973753055L;
	
	private int maxHealth;
	private int currentHealth;
	private HeartLabel[] hearts;
	
	public HeartIndicator(int health) {
		setLayout(new FlowLayout(FlowLayout.LEFT, 4, 4));
		
		this.currentHealth = health;
		this.maxHealth = health;
		
		hearts = new HeartLabel[health];
		
		for (int i = 0; i < health; i++) {
			HeartLabel hl = new HeartLabel();
			hearts[i] = hl;
			add(hl);
		}
	}
	
	public void setHealth(int health) {
		for (int i = 0; i < health-1; i++) {
			hearts[i].fill();
		}
		for (int i = health; i < maxHealth; i++) {
			hearts[i].empty();
		}
		currentHealth = health;
	}
}
