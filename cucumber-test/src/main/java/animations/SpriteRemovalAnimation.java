package animations;

import board.Position;
import view.BoardPanel;

public class SpriteRemovalAnimation extends Animation {
	
	private BoardPanel boardPanel;
	private Position posToRemoveAt;

	public SpriteRemovalAnimation(Position posToRemoveAt, BoardPanel boardPanel) {
		super(0);
		this.posToRemoveAt = posToRemoveAt;
		this.boardPanel = boardPanel;
	}

	@Override
	public void initializeAnimation() {}

	@Override
	public void establishNextFrame() {}

	@Override
	public void finalizeAnimation() {
		boardPanel.geteElementSpriteList().remove(boardPanel.getEElementSpriteAtPosition(posToRemoveAt));
	}

}
