package player;
import piece_basics.Robot;
import cards.*;

public class Player {
	private Robot myRobot;
	private Hand hand;
	private Program program;
	
	public Robot getRobot() {
		return myRobot;
	}
	
	public void setHand(Hand hand)
	{
		this.hand = hand;
	}
	public Hand getHand()
	{
		return hand;
	}
	
	
	public void setProgram()
	{
		// will get player to select 5 cards according to execution priority
	}
	
	public Program getProgram()
	{
		return program;
	}
	
	public Card getTopCardInProgram()
	{
		return program.getTopOfProgram();
	}
}
