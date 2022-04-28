import environment_elements.HealthStation;
import io.cucumber.java.en.Given;

public class SDHealthStation {
	private Context context;
	
	public SDHealthStation(Context context) {
		this.context = context;
	}
	
	@Given("a health station on the board at \\({int}, {int})")
	public void a_health_station_on_the_board_at(Integer int1, Integer int2) {
	    HealthStation hs = new HealthStation();
	    context.board.initialPlacement(hs, int1, int2);
	    context.healthStation = hs;
	}
}
