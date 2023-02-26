package exception;

public class ApplicationException extends Exception {
    private static final String REPLACED_STRING = "\\{value\\}";
    private String message = "";
    private Reason reason;

    public ApplicationException(Reason reason, String message) {
        this.message = message;
        this.reason = reason;
    }

    public ApplicationException(Reason reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return reason.getMessage().replaceAll(REPLACED_STRING, message);
    }

    public enum Reason {
        BILL_NOT_FOUND("Can not find bill with id={value}"),
        BILL_EMPTY("Bill \"{value}\" is empty"),

        COMMAND_NOT_FOUND("Can not find command \"{value}\""),
        INVALID_PARAMS("Invalid command parameter(s) \"{value}\""),
        REQUIRED_PARAMS("Required command parameter(s)"),
        DUPLICATE_PARAM("Duplicate command parameter(s) \"{value}\""),
        REDUNDANT_PARAM("Redundant command parameter \"{value}\""),
        INVALID_PARAMS_VALUE("Invalid value of parameter \"{value}\""),
        INVALID_OPTIONS("Invalid command option(s) \"{value}\""),

        FOOD_ID_NOT_FOUND("Can not find food with id={value}"),
        DRINK_ID_NOT_FOUND("Can not find drink with id={value}"),
        FOOD_NOT_FOUND("Can not find food \"{value}\""),
        DRINK_NOT_FOUND("Can not find drink \"{value}\""),

        ERROR_READING_FILE("Error occurs while reading data file because \"{value}\""),
        ERROR_WRITING_FILE("Error occurs while writing file because \"{value}\"");

        private String message;

        Reason(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
