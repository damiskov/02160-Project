import io.cucumber.java.en.Given;
import player.*;

public class SDHost {
	private Context context;

	public SDHost(Context context) {
		this.context = context;
	}
	
	@Given("A Host")
	public void a_host() {
	    Player p = context.player;
	    p = new Host();
	    context.host = p;
	    
	}
}
