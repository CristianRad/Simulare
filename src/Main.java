import Domain.BillValidator;
import Repository.BillRepository;
import Service.BillService;
import UI.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UI/mainWindow.fxml"));
        Parent root = fxmlLoader.load();

        BillValidator billValidator = new BillValidator();
        BillRepository billRepository = new BillRepository(billValidator);
        BillService billService = new BillService(billRepository);

        billService.addBill("1",130,"Electricity","24.10.2018");
        billService.addBill("3",200,"Water","24.10.2018");
        billService.addBill("4",75,"Maintenance","05.09.2018");
        billService.addBill("5",150,"Gas","24.10.2018");
        billService.addBill("7",94,"Telephone","05.09.2018");
        billService.addBill("8",42,"Shopping","03.10.2018");
        billService.addBill("9",124,"Maintenance","24.10.2018");

        MainController mainController = fxmlLoader.getController();
        mainController.setService(billService);

        primaryStage.setTitle("Bill Manager");
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
