package UI;

import Domain.Bill;
import Service.BillService;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainController {

    public TableView tblBills;
    public TableColumn colBillId;
    public TableColumn colBillSum;
    public TableColumn colBillDescription;
    public TableColumn colBillDate;
    public Button btnAddBill;
    public Button btnTotalSum;

    public BillService billService;

    private ObservableList<Bill> bills = FXCollections.observableArrayList();

    public void setService(BillService billService) {
        this.billService = billService;
    }

    @FXML
    public void initialize() {
        Platform.runLater(() -> {
            bills.addAll(billService.getAllBills());
            tblBills.setItems(bills);
        });
    }

    public void btnAddBillClick(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("Add.fxml"));

            Scene scene = new Scene(fxmlLoader.load(),235,200);
            Stage stage = new Stage();
            stage.setTitle("Add Bill");
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            AddController controller = fxmlLoader.getController();
            controller.setService(billService);
            stage.showAndWait();

            bills.clear();
            bills.addAll(billService.getAllBills());
        } catch (IOException error) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new window: Add Bill", error);
        }
    }

    public void btnTotalSumClick(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("TotalSum.fxml"));

            Scene scene = new Scene(fxmlLoader.load(),280,280);
            Stage stage = new Stage();
            stage.setTitle("Total sum per day");
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            TotalSumController controller = fxmlLoader.getController();
            controller.setService(billService);
            stage.showAndWait();

            bills.clear();
            bills.addAll(billService.getAllBills());
        } catch (IOException error) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new window: Total sum per day", error);
        }
    }

}
