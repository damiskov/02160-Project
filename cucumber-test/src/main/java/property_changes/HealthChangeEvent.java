package property_changes;

public class HealthChangeEvent implements IPropertyChangeEvent {

	private int health;
	private int robotNum;
	
	public HealthChangeEvent(int health, int robotNum) {
		this.health = health;
		this.robotNum = robotNum;
	}
	
	public int getHealth() {
		return health;
	}
	public int getRobotNum() {
		return robotNum;
	}
	
	
	
}
