package exception;

public class RestaurantException extends Exception {
    private String message;
    private Reason reason;

    public enum Reason {
        BILL_NOT_FOUND,
        INVALID_INPUT_PARAM,
        FOOD_NOT_FOUND,
        DRINK_NOT_FOUND
    }

    public RestaurantException(String message, Reason reason) {
        this.message = message;
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "RestaurantException." + reason.toString() + ":" + message;
    }
}
