package animations;

import view.MasterView;

// An animation for displaying the win screen when a robot wins during the activation phase
public class WinScreenAnimation extends Animation {
	
	private final int winningPlayerNum;
	private final MasterView masterView;

	public WinScreenAnimation(int winningPlayerNum, MasterView masterView) {
		super(0);
		this.winningPlayerNum = winningPlayerNum;
		this.masterView = masterView;
	}

	@Override
	public void initializeAnimation() {}

	@Override
	public void establishNextFrame() {}

	@Override
	public void finalizeAnimation() {
		masterView.displayWinScreen(winningPlayerNum);
	}

}
