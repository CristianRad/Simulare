package Domain;

public class BillValidatorException extends RuntimeException {

    public BillValidatorException(String message) {
        super("BillValidatorException: " + message);
    }

}
