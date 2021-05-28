package Ex09;

public class FieldUtil {
    public static void checkNullOrEmptyOrBlank(String field, String label) {
        if(field == null) {
            throw new NullPointerException(label + " should not be null.");
        }
        if(field.isEmpty() || field.isBlank()) {
            throw new IllegalArgumentException(label + " should not be empty or blank.");
        }
    }
}