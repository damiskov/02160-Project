package view;

public class Triplet<Integer>{
	private int red;
	private int blue;
	private int green;
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
	
	public void increment(Triplet<Integer> incrementor) {
		setRed(this.getRed()+incrementor.getRed());
		setBlue(this.getBlue()+incrementor.getGreen());
		setGreen(this.getGreen()+incrementor.getBlue());
	}
	
	public void divide(int divisor) {
		setRed((int) Math.round(this.getRed()/divisor));
		setGreen((int) Math.round(this.getGreen()/divisor));
		setBlue((int) Math.round(this.getBlue()/divisor));
	}
	
	public Triplet<Integer> subtract(Triplet<Integer> subtractant){
		return new Triplet<Integer>((this.getRed()-subtractant.getRed()),
									(this.getGreen()-subtractant.getGreen()),
									(this.getBlue()-subtractant.getBlue()));
	}
	
}
