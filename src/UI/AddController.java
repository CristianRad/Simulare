package UI;

import Service.BillService;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddController {
    public Spinner spnId;
    public TextField txtSum;
    public TextField txtDescription;
    public TextField txtDate;
    public Button btnAdd;
    public Button btnCancel;

    public BillService billService;

    public void setService(BillService billService) {
        this.billService = billService;
    }

    public void btnAddClick(ActionEvent actionEvent) {
        try {
            String id = String.valueOf(spnId.getValue());
            int sum = Integer.parseInt(txtSum.getText());
            String description = txtDescription.getText();
            String date = txtDate.getText();

            billService.addBill(id, sum, description, date);
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
