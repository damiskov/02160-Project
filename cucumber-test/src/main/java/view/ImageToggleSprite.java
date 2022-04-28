package view;

import java.awt.Image;

public class ImageToggleSprite extends Sprite {
	
	private Image imageDefault;
	private Image imageAlternative;

	public ImageToggleSprite(Image imageDefault, Image imageAlternative, int x, int y, int degrees, BoardPanel canvas) {
		super(imageDefault, x, y, degrees, canvas);
		this.imageDefault = imageDefault;
		this.imageAlternative = imageAlternative;
	}
	
	@Override
	public void nextImage() {
		if (getImage() == imageDefault) {
			setImage(imageAlternative);
		} else {
			setImage(imageDefault);
		}
	}
}
