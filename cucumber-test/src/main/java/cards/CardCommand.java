package cards;

import piece_basics.Robot;

/*  Implements comparable<CardCommand> to allow us to sort the top card 
 *  of all player's programs
 */
public class CardCommand implements Comparable<CardCommand>{ 

	private Card card;
	private Robot robot;
	
	public Card getCard() {
		return card;
	}
	
	/* The command pattern is used to execute the programs of the robots 
	 * A card command has a robot and a card which are used to execute
	 * the card on the robot 
	 */
	public CardCommand(Card card, Robot robot) {
		this.card = card;
		this.robot = robot;
	}
	
	public void execute() {
		System.out.println("Executing: " + card);
		System.out.println("On robot: " + robot.getRobotNumber());
		card.executeAction(robot);
	}

	//Allows us to sort the top cards of the programs and later execute them in order 
	@Override
	public int compareTo(CardCommand o) {
		return Integer.compare(this.card.getNum(), o.card.getNum());
	}
	
}
