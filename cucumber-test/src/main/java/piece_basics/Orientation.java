package piece_basics;

public enum Orientation {
	UP,
	DOWN,
	LEFT,
	RIGHT;
	
	// Only used in UI
	public int getDegrees() {
		switch(this) {
		case UP:
			return 270;
		case RIGHT:
			return 0;
		case DOWN:
			return 90;
		case LEFT:
			return 180;
		}
		return 0;	
	}
}
