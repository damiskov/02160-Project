package animations;

import java.util.List;

import view.Sprite;

public class SpritePlacementAnimation extends Animation {
	
	Sprite spriteToAdd;
	List<Sprite> renderListToAddTo;

	public SpritePlacementAnimation(Sprite sprite, List<Sprite> renderListToAddTo) {
		super(0);
		this.spriteToAdd = sprite;
		this.renderListToAddTo = renderListToAddTo;
	}

	@Override
	public void initializeAnimation() {}

	@Override
	public void establishNextFrame() {}

	@Override
	public void finalizeAnimation() {
		renderListToAddTo.add(spriteToAdd);
	}

}
