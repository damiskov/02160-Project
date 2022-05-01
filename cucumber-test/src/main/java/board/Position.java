package board;

import java.util.Objects;

import piece_basics.Orientation;

public class Position {
	private int x;
	private int y;
	
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public void incrX(int delta) {
		this.x += delta;
	}
	public void incrY(int delta) {
		this.y += delta;
	}
	
	//helper methods for next()
	//returns position of a given distance from self in x direction (negative direction works too)
	public Position nextX(int distance) {
		return new Position(this.getX()+distance, this.getY());
	}
	//same but in y direction
	public Position nextY(int distance) {
		return new Position(this.getX(), this.getY()+distance);
	}
	//Return position in a given orientation and distance from self
	public Position next(Orientation direction, int distance) {
		switch(direction) {
		case UP:
			return this.nextY(distance);
		case DOWN:
			return this.nextY(-distance);
		case RIGHT:
			return this.nextX(distance);
		case LEFT:
			return this.nextX(-distance);
		}
		return(this);
	}
	
	public Position subtract(Position other) {
		return new Position(this.x - other.x, this.y - other.y);
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Position))
			return false;
		Position other = (Position) obj;
		return x == other.x && y == other.y;
	}
	@Override
	public String toString() {
		return "Position [x=" + x + ", y=" + y + "]";
	}
}
