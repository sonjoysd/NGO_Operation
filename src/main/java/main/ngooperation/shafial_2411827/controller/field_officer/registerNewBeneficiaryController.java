package main.ngooperation.shafial_2411827.controller.field_officer;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import main.ngooperation.HelloApplication;
import main.ngooperation.shafial_2411827.FieldOfficer;
import main.ngooperation.shafial_2411827.RegisterNewBeneficiary;

import java.time.LocalDate;
import java.util.ArrayList;

public class registerNewBeneficiaryController
{
    @javafx.fxml.FXML
    private TableColumn <RegisterNewBeneficiary,String> ConductCL;
    @javafx.fxml.FXML
    private TextField AdressTF;
    @javafx.fxml.FXML
    private TableColumn <RegisterNewBeneficiary,String> BeneficiresCL;
    @javafx.fxml.FXML
    private TextField ContactTF;
    @javafx.fxml.FXML
    private TextField FullNameTF;
    @javafx.fxml.FXML
    private TextField CommunityTF;
    @javafx.fxml.FXML
    private TableColumn <RegisterNewBeneficiary,String> FullNameCL;
    @javafx.fxml.FXML
    private TextArea RecordRElativeTA;
    @javafx.fxml.FXML
    private TableColumn <RegisterNewBeneficiary,String> ServicesAreaCL;
    @javafx.fxml.FXML
    private TableView<RegisterNewBeneficiary> tableView;


    FieldOfficer user1 = new FieldOfficer(1, "354grg", "xx", "343", "gfroigj", "ff", 13, LocalDate.now(), "dfd", 3.5f, "Day");

    @javafx.fxml.FXML
    public void initialize() {
        ServicesAreaCL.setCellValueFactory(new PropertyValueFactory<>("address"));
        FullNameCL.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        BeneficiresCL.setCellValueFactory(new PropertyValueFactory<>("registerId"));
        ConductCL.setCellValueFactory(new PropertyValueFactory<>("contact"));
    }

    @javafx.fxml.FXML
    public void ViewDetailsOnAction(ActionEvent actionEvent) {
        ArrayList<Object> readObjList = user1.readRegisterNewBeneficiary();

        for (Object obj: readObjList){
            if(obj instanceof RegisterNewBeneficiary reg){
                tableView.getItems().add(reg);
            }
        }

    }

    @javafx.fxml.FXML
    public void BackDashbordOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/main/ngooperation/shafial_2411827/field_officer/mainDashboardView.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Dashboard");
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void RegisterOnAction(ActionEvent actionEvent) {
        //get, validate, verify

        // int userId, String password, String userName, String phone, String role, String mail, int employeeId, LocalDate joiningDate, String designation, Float salary, String shift


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