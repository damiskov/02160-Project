package game_basics;

public class PieceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -7743105727149369034L;

	public PieceNotFoundException() {
	}

	public PieceNotFoundException(String message) {
		super(message);
	}

	public PieceNotFoundException(Throwable cause) {
		super(cause);
	}

	public PieceNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public PieceNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
