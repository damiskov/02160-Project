package animations;

public class Triplet{
	private int red;
	private int blue;
	private int green;
	
	//Triplet is used to make making and changing colors using Color(int,int,int) method easier
	public Triplet(int red,int blue,int green) {
		this.red = red;
		this.blue = blue;
		this.green = green;
	}
	public int getRed() { return red; }
	public int getBlue() { return blue; }
	public int getGreen() { return green; }
	
	public void setRed(int red)  { this.red = red; }
	public void setBlue(int blue)  { this.blue = blue; }
	public void setGreen(int green) { this.green = green; }
	
	//Increase color values by adding two colors values
	public void increment(Triplet incrementor) {
		setRed(this.getRed()+incrementor.getRed());
		setBlue(this.getBlue()+incrementor.getGreen());
		setGreen(this.getGreen()+incrementor.getBlue());
	}
	
	//set a colors value to a fraction if something
	public void divide(int divisor) {
		setRed((int) Math.round(this.getRed()/divisor));
		setGreen((int) Math.round(this.getGreen()/divisor));
		setBlue((int) Math.round(this.getBlue()/divisor));
	}
	
	//decrease a colors values by subtracting another colors values
	public Triplet subtract(Triplet subtractant){
		return new Triplet((this.getRed()-subtractant.getRed()),
									(this.getGreen()-subtractant.getGreen()),
									(this.getBlue()-subtractant.getBlue()));
	}
	
}
