import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Stack;

import board.Position;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import piece_basics.Orientation;
import piece_basics.Robot;
import cards.Back2;
import cards.Back3;
import cards.Card;
import cards.Move1;
import cards.Move2;
import cards.Move3;
import cards.TurnLeft;
import cards.TurnRight;
import cards.UTurn;

public class SDRobot {
	private Context context;
	
	public SDRobot(Context context) {
		this.context = context;
	}
	
	@Given("a robot on the board at \\({int}, {int})")
	public void a_robot_on_the_board_at(Integer int1, Integer int2) {
		Robot r = new Robot();
		context.board.initialPlacement(r, int1, int2);
	    context.robot = r;
	}
	
	@Given("a robot for the first player on the board at \\({int}, {int})")
	public void a_robot_for_the_first_player_on_the_board_at(Integer int1, Integer int2) {
		context.game.setRobots(2);
	    Robot r = context.game.getPlayers()[0].getRobot();
	    context.board.initialPlacement(r, new Position(int1, int2));
	    context.robot = r;
	}
	
	@Given("a robot for the second player on the board at \\({int}, {int})")
	public void a_robot_for_the_second_player_on_the_board_at(Integer int1, Integer int2) {
	    Robot r2 = context.game.getPlayers()[1].getRobot();
	    context.board.initialPlacement(r2, new Position(int1, int2));
	    context.robot2 = r2;
	}
	
	@Given("two robots on the board")
	public void two_robots_on_the_board() {
		Robot r = new Robot();
		context.board.initialPlacement(r, 1, 3);
	    context.robot = r;
	    Robot r2 = new Robot();
		context.board.initialPlacement(r2, 4, 7);
	    context.robot2 = r2;
	}
	
	@Given("a second robot on the board at \\({int}, {int})")
	public void a_second_robot_on_the_board_at(Integer int1, Integer int2) {
		Robot r = new Robot();
		context.board.initialPlacement(r, int1, int2);
	    context.robot2 = r;
	}
	
	@Given("a program for the robot")
	public void a_program_for_the_robot() {
		Stack<Card> gram = new Stack<Card>();
		gram.addAll(Arrays.asList(new Move2(), new Move3(), new Move1(), new TurnLeft(), new TurnRight()));
		context.robot.setProgram(gram);
	}
	
	@Given("a program for the robot with uTurns")
	public void a_program_for_the_robot_with_u_turns() {
		Stack<Card> gram = new Stack<Card>();
		gram.addAll(Arrays.asList(new UTurn(), new UTurn(), new UTurn(), new UTurn(), new UTurn()));
		context.robot.setProgram(gram);
	}
	
	@Given("a program for the robot full of move1s")
	public void a_program_for_the_robot_full_for_move1s() {
		Stack<Card> gram = new Stack<Card>();
		Card uno = new Move1();
		uno.setNum(3);
		Card dos = new Move1();
		dos.setNum(3);
		Card tres = new Move1();
		tres.setNum(3);
		Card cuatro = new Move1();
		cuatro.setNum(3);
		Card cinco = new Move1();
		cinco.setNum(3);
		gram.addAll(Arrays.asList(uno, dos, tres, cuatro, cinco));
		context.robot.setProgram(gram);
	}
	
	@Given("a program for the second robot full of move1s")
	public void a_program_for_the_second_robot_full_of_move1s() {
		Stack<Card> gram = new Stack<Card>();
		Card uno = new Move1();
		uno.setNum(2);
		Card dos = new Move1();
		dos.setNum(2);
		Card tres = new Move1();
		tres.setNum(2);
		Card cuatro = new Move1();
		cuatro.setNum(2);
		Card cinco = new Move1();
		cinco.setNum(2);
		gram.addAll(Arrays.asList(uno, dos, tres, cuatro, cinco));
		context.robot2.setProgram(gram);
	}
	
	@Given("an already reversed program for the robot")
	public void an_already_reversed_program_for_the_robot() {
		Stack<Card> gram = new Stack<Card>();
		gram.addAll(Arrays.asList(new Back2(), new Back3(), new Back2(), new Back3(), new Back2()));
		context.robot.setProgram(gram);
	}

	@Given("a robot on the board at \\({int}, {int}) facing {string}")
	public void a_robot_on_the_board_at_facing(Integer int1, Integer int2, String string) {
	    Robot r = new Robot();
	    switch (string.toLowerCase()) {
	    case "up":
	    	r.setOrientation(Orientation.UP); break;
	    case "right":
	    	r.setOrientation(Orientation.RIGHT); break;
	    case "down":
	    	r.setOrientation(Orientation.DOWN); break;
	    case "left":
	    	r.setOrientation(Orientation.LEFT); break;
    	default:
    		throw new IllegalArgumentException("Invalid orientation");
	    }
	    context.board.initialPlacement(r, int1, int2);
	    context.robot = r;
	}
	
	@Given("a second robot on the board at \\({int}, {int}) facing {string}")
	public void a_second_robot_on_the_board_at_facing(Integer int1, Integer int2, String string) {
	    Robot r = new Robot();
	    switch (string.toLowerCase()) {
	    case "up":
	    	r.setOrientation(Orientation.UP); break;
	    case "right":
	    	r.setOrientation(Orientation.RIGHT); break;
	    case "down":
	    	r.setOrientation(Orientation.DOWN); break;
	    case "left":
	    	r.setOrientation(Orientation.LEFT); break;
    	default:
    		throw new IllegalArgumentException("Invalid orientation");
	    }
	    context.board.initialPlacement(r, int1, int2);
	    context.robot2 = r;
	    
	}
	

	@Given("a third robot on the board at \\({int}, {int}) facing {string}")
	public void a_third_robot_on_the_board_at_facing(Integer int1, Integer int2, String string) {
	    Robot r = new Robot();
	    switch (string.toLowerCase()) {
	    case "up":
	    	r.setOrientation(Orientation.UP); break;
	    case "right":
	    	r.setOrientation(Orientation.RIGHT); break;
	    case "down":
	    	r.setOrientation(Orientation.DOWN); break;
	    case "left":
	    	r.setOrientation(Orientation.LEFT); break;
    	default:
    		throw new IllegalArgumentException("Invalid orientation");
	    }
	    context.board.initialPlacement(r, int1, int2);
	    context.robot3 = r;
	}
	
	@When("the robot moves to \\({int}, {int})")
	public void the_robot_moves_to(Integer int1, Integer int2) {
	    context.board.setPosition(context.robot, new Position(int1, int2));
	}
	
	@When("the first robot moves to \\({int}, {int})")
	public void the_first_robot_moves_to(Integer int1, Integer int2) {
		context.board.setPosition(context.robot, new Position(int1, int2));
	}
	
	@Then("the robot is at \\({int}, {int})")
	public void the_robot_is_at(Integer int1, Integer int2) {
		assertEquals(new Position(int1, int2), context.robot.calculatePosition());
	}
	
	@Then("the first robot is at \\({int}, {int})")
	public void the_first_robot_is_at(Integer int1, Integer int2) {
		assertEquals(new Position(int1, int2), context.robot.calculatePosition());
	}
	
	
	
	@Then("the second robot is at \\({int}, {int})")
	public void the_second_robot_is_at(Integer int1, Integer int2) {
		assertEquals(new Position(int1, int2), context.robot2.calculatePosition());
	}
	
	@Then("the third robot is at \\({int}, {int})")
	public void the_third_robot_is_at(Integer int1, Integer int2) {
		assertEquals(new Position(int1, int2), context.robot3.calculatePosition());
	}
	
	@When("the robot tries to move one step")
	public void the_robot_tries_to_move_one_step(){
		context.robot.move(1);
	}
	
	@When("the robot tries to move two steps")
	public void the_robot_tries_to_move_two_steps(){
		context.robot.move(1);
	}
	
	@When("the robot tries to move three steps")
	public void the_robot_tries_to_move_three_steps() {
		context.robot.move(1);
	}

	
	@Then("the robot stays at \\({int}, {int})")
	public void the_robot_stays_at(Integer int1, Integer int2) {
		assertEquals(new Position(int1, int2), context.robot.calculatePosition());	
	}

	
	
	@When("one robot moves")
	public void one_robot_moves() {
	    context.robot.move(1);
	    

	}
	
	@When("the robot moves {int} step")
	public void the_robot_moves_step(Integer int1) {
		context.robot.move(int1);
	}
	@When("the robot tries to move {int} steps")
	public void the_robot_tries_to_move_steps(Integer int1) {
		context.robot.move(int1);
	}
	
	@When("the first robot moves {int} step")
	public void the_first_robot_moves_step(Integer int1) {
		context.robot.move(int1);
	}
	
	@When("the first robot reboots")
	public void one_robot_reboots() {
	    context.robot.reboot();
	}
	
	@Then("the robot is at \\({int}, {int}) and facing {string}")
	public void the_robot_is_at_and_facing(Integer int1, Integer int2, String string) {
	    assertEquals(new Position(int1, int2), context.robot.calculatePosition());
	    Orientation o = null;
	    switch (string.toLowerCase()) {
	    case "up":
	    	o = Orientation.UP; break;
	    case "right":
	    	o = Orientation.RIGHT; break;
	    case "down":
	    	o = Orientation.DOWN; break;
	    case "left":
	    	o = Orientation.LEFT; break;
    	default:
    		throw new IllegalArgumentException("Invalid orientation");
	    }
	    assertEquals(o, context.robot.getOrientation());
	}
	
	@Given("a robot on the board")
	public void a_robot_on_the_board() {
	    context.robot = new Robot();
	    context.robot.setOrientation(Orientation.UP);
		context.board.initialPlacement(context.robot, new Position(5,5));
	}
	
	@When("the robot takes enough damage to kill it")
	public void the_robot_takes_enough_damage_to_kill_it() {
	    for (int i = 0; i < 3; i++) {
	    	context.robot.takeDamage();
	    }
	}
	

	@Then("the second robot takes damage")
	public void the_second_robot_takes_damage() {
	    assertEquals(2, context.robot2.getHealth());
	}
	@Then("the second robot does not take damage")
	public void the_second_robot_does_not_take_damage() {
		assertEquals(3, context.robot2.getHealth());
	}
	
	@Then("the robot moves to \\({int}, {int}) and turns {string}")
	public void the_robot_moves_to_and_turns(Integer int1, Integer int2, String string) {
	    context.robot.shiftX(1);
	    Orientation o = null;
	    switch (string.toLowerCase()) {
	    case "right":
	    	o = (context.robot.getOrientation()); break;
	    case "left":
	    	o = (context.robot.getOrientation()); break;
    	default:
    		throw new IllegalArgumentException("Invalid orientation");
	    }
	    assertEquals(o, context.robot.getOrientation());
	}
	
	@Then("the robot is at five, five")
	public void the_robot_is_at_five_five() {
	    assertEquals(context.robot.getX(), 5);
	    assertEquals(context.robot.getY(), 5);

	}

}
