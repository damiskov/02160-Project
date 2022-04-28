package view;

import java.awt.Image;


public class SingleImageSprite extends Sprite {

	public SingleImageSprite(Image image, int x, int y, int degrees, BoardPanel canvas) {
		super(image, x, y, degrees, canvas);
	}

	@Override
	public void nextImage() {}

}
