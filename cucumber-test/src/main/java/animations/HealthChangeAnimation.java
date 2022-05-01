package animations;

import view.StatusPanel;

// An animation for changing the health displayed for a single robot in the StatusPanel
public class HealthChangeAnimation extends Animation {
	
	private StatusPanel statusPanel;
	private int robotNumber;
	private int newHealth;

	public HealthChangeAnimation(StatusPanel statusPanel, int robotNumber, int newHealth) {
		super(0);
		this.statusPanel = statusPanel;
		this.robotNumber = robotNumber;
		this.newHealth = newHealth;
	}

	@Override
	public void initializeAnimation() {}

	@Override
	public void establishNextFrame() {}

	@Override
	public void finalizeAnimation() {
		statusPanel.setHealth(robotNumber, newHealth);
	}

}
