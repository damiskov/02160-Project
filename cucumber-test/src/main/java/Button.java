
public class Button {
	
	private Boolean pressed = false;
	
	public Button()
	{
		System.out.println("I am a button");
	}

	public void press()
	{
		this.pressed = true;
	}
}
