package cards;

import piece_basics.Robot;

public class CardCommand implements Comparable<CardCommand>{

	private Card card;
	private Robot robot;
	
	public CardCommand(Card card, Robot robot) {
		this.card = card;
		this.robot = robot;
	}
	
	public void execute() {
		System.out.println("Executing: " + card);
		System.out.println("On robot: " + robot.getRobotNumber());
		card.executeAction(robot);
	}

	@Override
	public int compareTo(CardCommand o) {
		return Integer.compare(this.card.getNum(), o.card.getNum());
	}
	
}
