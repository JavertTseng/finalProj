package finalProj.exception;

public class InsufficientPointsException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public InsufficientPointsException(String message) {
		super(message);
	}
}
