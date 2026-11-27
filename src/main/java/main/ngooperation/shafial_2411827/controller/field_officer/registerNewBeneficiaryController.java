package main.ngooperation.shafial_2411827.controller.field_officer;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import main.ngooperation.shafial_2411827.FieldOfficer;

import java.time.LocalDate;

public class registerNewBeneficiaryController
{
    @javafx.fxml.FXML
    private TableColumn ConductCL;
    @javafx.fxml.FXML
    private TextField AdressTF;
    @javafx.fxml.FXML
    private TableColumn BeneficiresCL;
    @javafx.fxml.FXML
    private TextField ContactTF;
    @javafx.fxml.FXML
    private TextField FullNameTF;
    @javafx.fxml.FXML
    private TextField CommunityTF;
    @javafx.fxml.FXML
    private TableColumn FullNameCL;
    @javafx.fxml.FXML
    private TextArea RecordRElativeTA;
    @javafx.fxml.FXML
    private TableColumn ServicesAreaCL;
    @javafx.fxml.FXML
    private TableView tableView;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void ViewDetailsOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void BackDashbordOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void RegisterOnAction(ActionEvent actionEvent) {
        //get, validate, verify

        // int userId, String password, String userName, String phone, String role, String mail, int employeeId, LocalDate joiningDate, String designation, Float salary, String shift
        FieldOfficer user1 = new FieldOfficer(1, "354grg", "xx", "343", "gfroigj", "ff", 13, LocalDate.now(), "dfd", 3.5f, "Day");

        boolean b = user1.registerNewBeneficiary(FullNameTF.getText(), ContactTF.getText(), CommunityTF.getText(), AdressTF.getText());
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        if(!b){
            a.setContentText("Register failed");
            a.showAndWait();
            return;
        }
        a.setContentText("succesfully Assign");
        a.showAndWait();

    }
}