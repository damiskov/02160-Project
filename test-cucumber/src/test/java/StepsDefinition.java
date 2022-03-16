import G9.travel.TravelCard;

import static org.junit.Assert.assertEquals;

import G9.travel.CheckInStation;
import G9.travel.ResponseMessage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepsDefinition {
	
	TravelCard card = new TravelCard();
	CheckInStation station;
	ResponseMessage message = new ResponseMessage();
	
	@Given("a travel card with balace {int}")
	public void a_travel_card_with_balace(Integer int1) {
	    card.setBalance(int1);
	}
	@Given("check-in status is false")
	public void check_in_status_is_false() {
	    card.setCheckInStatus(false);
	}
	@Given("a check-in automaton at {string}")
	public void a_check_in_automaton_at(String string) {
		station = new CheckInStation(string);
	}
	@When("check-in")
	public void check_in() {
	    station.checkIn(card);
	    message.setMessage("Checked-in");
	    
	}
	@Then("automaton displays message that the card is checked in")
	public void automaton_displays_message_that_the_card_is_checked_in() {
	    assertEquals(message.getMessage(), "Checked-in");
	}

}
