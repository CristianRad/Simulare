package UI;

import Domain.Bill;
import Service.BillService;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TotalSumController {

    public TextField txtDate;
    public TextField txtTotalSum;
    public Button btnCalculate;
    public Button btnCancel;

    public BillService billService;

    public void setService(BillService billService) {
        this.billService = billService;
    }

    public void btnCalculateClick(ActionEvent actionEvent) {
        try {
            String date = txtDate.getText();
            int sum = 0;

            for (Bill bill : billService.getAllBills())
                if (bill.getDate().equals(date))
                    sum += bill.getSum();

            System.out.println(sum);
            txtTotalSum.setText(Integer.toString(sum));
            btnCancelClick(actionEvent);
        } catch (RuntimeException error) {
            Common.showValidationError(error.getMessage());
        }
    }

    public void btnCancelClick(ActionEvent actionEvent) {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }

}
