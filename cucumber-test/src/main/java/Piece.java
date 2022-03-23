
public abstract class Piece {
	private Position position;
	
	public int getX() {
		return position.getX();
	}
	public void setX(int x) {
		this.position.setX(x);
	}
	public int getY() {
		return position.getY();
	}
	public void setY(int y) {
		this.position.setY(y);
	}
}
