package G9.travel;

public class CheckInStation {
	public CheckInStation(String name)
	{
		this.name = name;
	}
	public void checkIn(TravelCard card)
	{
		card.setCheckInStatus(true);
	}
	public void message()
	{
		System.out.println("Card checked in.");
	}
	private String name;
}
