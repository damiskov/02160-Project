package property_changes;

public class RobotLaserEvent implements IPropertyChangeEvent {
	
	private int shooterRobotNumber;
	private int targetRobotNumber;
	
	public RobotLaserEvent(int shooterRobotNumber, int targetRobotNumber) {
		this.shooterRobotNumber = shooterRobotNumber;
		this.targetRobotNumber = targetRobotNumber;
	}
	
	public int getShooterRobotNumber() {
		return shooterRobotNumber;
	}
	
	public int getTargetRobotNumber() {
		return targetRobotNumber;
	}
	
	

}
