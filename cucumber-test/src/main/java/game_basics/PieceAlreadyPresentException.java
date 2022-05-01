package game_basics;

public class PieceAlreadyPresentException extends RuntimeException {

	private static final long serialVersionUID = -3745588564552124678L;

	public PieceAlreadyPresentException() {
	}

	public PieceAlreadyPresentException(String message) {
		super(message);
	}

	public PieceAlreadyPresentException(Throwable cause) {
		super(cause);
	}

	public PieceAlreadyPresentException(String message, Throwable cause) {
		super(message, cause);
	}

	public PieceAlreadyPresentException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
