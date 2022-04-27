import static org.junit.Assert.assertEquals;

import board.Difficulty;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SDDifficulty {
	private Context context;
	
	int difficulty;

	public SDDifficulty(Context context) {
		this.context = context;
	}

	
	@Given("an easy difficulty")
	public void an_easy_difficulty() {
		context.d = new Difficulty(1);
	}
	
	@Given("a medium difficulty")
	public void a_medium_difficulty() {
		context.d = new Difficulty(2);
	}
	
	@Given("a hard difficulty")
	public void a_hard_difficulty() {
		context.d = new Difficulty(3);
	}
	
	@Given("a super hard difficulty")
	public void a_super_hard_difficulty() {
		context.d = new Difficulty(4);
	}
	
	@When("the difficulty level is changed to hard")
	public void the_difficulty_level_is_changed_to_hard() {
	    context.d.setLevel(3);
	}
	@Then("the difficulty level is hard")
	public void the_difficulty_level_is_hard() {
	    assertEquals(context.d.getLevel(), 3);
	}
}
