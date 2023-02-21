package exception;

public class RestaurantException extends Exception {
    private String message;
    private Reason reason;

    public enum Reason {
        BILL_NOT_FOUND,
        INVALID_INPUT_PARAM,
        ITEM_NOT_FOUND,
        DRINK_NOT_FOUND,
        ERROR_READING_FILE,
        ERROR_WRITING_FILE
    }

    public RestaurantException(Reason reason, String message) {
        this.message = message;
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "RestaurantException." + reason.toString() + ":" + message;
    }
}
