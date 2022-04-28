package board;

public class NoSuchElementException extends RuntimeException {

	private static final long serialVersionUID = -3509969908047416400L;

	public NoSuchElementException() {
	}

	public NoSuchElementException(String message) {
		super(message);
	}

	public NoSuchElementException(Throwable cause) {
		super(cause);
	}

	public NoSuchElementException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoSuchElementException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
