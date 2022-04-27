package property_changes;

public class HealthChangeEvent implements IPropertyChangeEvent {

	private int health;
	private int robotNum;
	
	public HealthChangeEvent(int robotNum, int health) {
		this.robotNum = robotNum;
		this.health = health;
	}
	
	public int getRobotNum() {
		return robotNum;
	}
	
	public int getHealth() {
		return health;
	}
	
	
	
}
