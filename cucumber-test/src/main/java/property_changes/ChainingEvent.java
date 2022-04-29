package property_changes;

public class ChainingEvent implements IPropertyChangeEvent {

	private int robotNumber1;	
	private int robotNumber2;
	private boolean process;
	
	public ChainingEvent(int robotNumber1, int robotNumber2, boolean process) {
		this.robotNumber1 = robotNumber1;
		this.robotNumber2 = robotNumber2;
		this.process = process;
	}

	public int getRobotNumber1() {
		return robotNumber1;
	}

	public int getRobotNumber2() {
		return robotNumber2;
	}
	
	//Process indicates if the robots are getting chained or de-chained
	public boolean getProcess() {
		return process;
	}

}
