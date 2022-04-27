package animations;

import java.util.List;

import utils.ImageUtils;
import view.ImageToggleSprite;

public class SpriteRobotLaserAnimation extends Animation {
	
	private List<ImageToggleSprite> sprites;
	private int cellSize;

	public SpriteRobotLaserAnimation(int durationMs, List<ImageToggleSprite> sprites, int cellSize) {
		super(durationMs);
		this.sprites = sprites;
		this.cellSize = cellSize;
	}

	@Override
	public void initialize() {
		for(ImageToggleSprite toggleSprite : sprites) {
			toggleSprite.activate();
		}
	

	}

	@Override
	public void establishNextFrame() {
		
		//do nothing
		
	}

	@Override
	public void finalize() {
		for(ImageToggleSprite toggleSprite : sprites) {
			toggleSprite.activate();
			
			
		}
		sprites.clear();
		
	}

}
