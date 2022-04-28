package view;

public class SpriteNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -8560229501535504895L;

	public SpriteNotFoundException() {
	}

	public SpriteNotFoundException(String message) {
		super(message);
	}

	public SpriteNotFoundException(Throwable cause) {
		super(cause);
	}

	public SpriteNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public SpriteNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
