package Ex09;

public class GroupException extends Exception {
    public GroupException() {
        super("Invalid group format.");
    }
    public GroupException(String message) {
        super(message);
    }
}