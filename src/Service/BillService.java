package Service;

import Domain.Bill;
import Repository.BillRepository;

import java.util.List;

public class BillService {

    private BillRepository billRepository;

    /**
     * Instantiates a service for bills.
     * @param billRepository is the repository used.
     */

    public BillService(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    /**
     * Adds a bill.
     * @param id is the ID of the bill to add.
     * @param sum is the sum of the bill to add.
     * @param description is the description of the bill to add.
     * @param date is the date of the bill to add.
     */

    public void addBill(String id, int sum, String description, String date) {
        Bill bill = new Bill(id, sum, description, date);
        billRepository.insert(bill);
    }

    /**
     * @return a list of all bills.
     */

    public List<Bill> getAllBills() {
        return billRepository.getAll();
    }

}
