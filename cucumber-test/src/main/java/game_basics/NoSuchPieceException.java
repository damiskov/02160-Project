package game_basics;

public class NoSuchPieceException extends RuntimeException {

	private static final long serialVersionUID = -3509969908047416400L;

	public NoSuchPieceException() {
	}

	public NoSuchPieceException(String message) {
		super(message);
	}

	public NoSuchPieceException(Throwable cause) {
		super(cause);
	}

	public NoSuchPieceException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoSuchPieceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
