package Repository;

public class BillRepositoryException extends RuntimeException {

    public BillRepositoryException(String message) {
        super("BillRepositoryException: " + message);
    }

}
