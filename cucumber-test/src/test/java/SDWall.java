import environment_elements.Wall;
import io.cucumber.java.en.Given;


public class SDWall{
private Context context;
	
	public SDWall(Context context) {
		this.context = context;
	}
	
	@Given("a wall on the board at \\({int}, {int})")
	public void a_wall_on_the_board_at(Integer int1, Integer int2) {
	    Wall w = new Wall();
	    context.board.initialPlacement(w, int1, int2);
	    context.wall = w;
	}

}