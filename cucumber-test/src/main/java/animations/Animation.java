package animations;

/*
 * A common abstract superclass for all animations used by MasterView. The main thing implemented here
 * is the numFrames field. There is a constructor used by subclasses which takes a duration, uses the
 * FRAMES_PER_SECOND constant to convert that into a number of frames, and assigns that to the numFrames field.
 * 
 * The way these animations are played using the initializeAnimation, establishNextFrame, and finalizeAnimation
 * methods is explained in the playAllAnimations method in MasterView.
 */
public abstract class Animation {

	public static final int FRAMES_PER_SECOND = 60;
	
	private int numFrames;
	
	public Animation(int durationMs) {
		this.numFrames = (int)(durationMs/1000.0*FRAMES_PER_SECOND);
	}
	
	public abstract void initializeAnimation();
	
	public int getNumFrames() {
		return numFrames;
	}
	
	public abstract void establishNextFrame();
	
	public abstract void finalizeAnimation();
	
}
