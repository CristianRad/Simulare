package Repository;

import Domain.Bill;
import Domain.BillValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BillRepository {

    private BillValidator billValidator;
    private Map<String, Bill> storage = new HashMap<>();

    /**
     * Instantiates a repository for bills.
     * @param billValidator is the validator used.
     */

    public BillRepository(BillValidator billValidator) {
        this.billValidator = billValidator;
    }

    /**
     * Adds a bill to storage.
     * @param bill is the bill to add.
     * @throws BillRepositoryException if a bill with that ID already exists.
     */

    public void insert(Bill bill) {
        if (storage.containsKey(bill.getId()))
            throw new BillRepositoryException(String.format("A bill with the ID %s already exists!", bill.getId()));
        billValidator.validate(bill);
        storage.put(bill.getId(), bill);
    }

    /**
     * @return a list of all bills.
     */

    public List<Bill> getAll() {
        return new ArrayList<>(storage.values());
    }

}
