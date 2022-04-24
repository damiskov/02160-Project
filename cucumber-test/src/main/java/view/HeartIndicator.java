package view;

import java.awt.FlowLayout;

import javax.swing.JPanel;

public class HeartIndicator extends JPanel {

	private static final long serialVersionUID = 8951516382973753055L;
	
	private int maxHealth;
	private int currentHealth;
	private HeartLabel[] hearts;
	
	public HeartIndicator(int maxHealth) {
		setLayout(new FlowLayout(FlowLayout.LEFT, 4, 4));
		
		this.currentHealth = maxHealth;
		this.maxHealth = maxHealth;
		
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
		currentHealth = health;
	}
}
