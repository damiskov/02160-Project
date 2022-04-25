package animations;

public abstract class Animation {

	public static final int FRAMES_PER_SECOND = 60;
	
	private int numFrames;
	
	public Animation(int durationMs) {
		this.numFrames = (int)(durationMs/1000.0*FRAMES_PER_SECOND);
	}
	
	public abstract void initialize();
	
	public int getNumFrames() {
		return numFrames;
	}
	
	public abstract void establishNextFrame();
	
	public abstract void finalize();
}
