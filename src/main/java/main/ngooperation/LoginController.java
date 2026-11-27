package main.ngooperation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private ComboBox<String> userCB;

    @FXML
    public void initialize() {
        userCB.getItems().clear();
        userCB.getItems().add("Beneficiary");
        userCB.getItems().add("Account Officer");
        userCB.getItems().add("Executive Director");
        userCB.getItems().add("Project Coordinator");
        userCB.getItems().add("Field Officer");
        userCB.getItems().add("Auditor");
        userCB.getItems().add("Human Resources Manager");
        userCB.getItems().add("Project Manager");
    }

    @FXML
    public void loginOnAction(ActionEvent actionEvent) {
        String selectedUser = userCB.getValue();
        if (selectedUser == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please select a user.");
            alert.showAndWait();
            return;
        }

        String fxmlPath = "";
        if (selectedUser.equals("Beneficiary")) {
            fxmlPath = "/main/ngooperation/sonjoy_2411704/beneficiary/beneficiary.view.fxml";
        } else if (selectedUser.equals("Account Officer")) {
            fxmlPath = "/main/ngooperation/sonjoy_2411704/accountOfficer/accountOfficer.view.fxml";
        } else if (selectedUser.equals("Executive Director")) {
            fxmlPath = "/main/ngooperation/mamun_2430986/ExecutiveDirector/ExecutiveDirectorView.fxml";
        } else if (selectedUser.equals("Project Coordinator")) {
            fxmlPath = "/main/ngooperation/mamun_2430986/ProjectCoordinator/ProjectCoordinatorView.fxml";
        } else if (selectedUser.equals("Field Officer")) {
            fxmlPath = "/main/ngooperation/shafial_2411827/field_officer/mainDashboardView.fxml";
        } else if (selectedUser.equals("Auditor")) {
            fxmlPath = "/main/ngooperation/shafial_2411827/auditor/deshbord.fxml";
        } else if (selectedUser.equals("Human Resources Manager")) {
            fxmlPath = "/main/ngooperation/dilir_2411754/Human_Resources_Manager/HRManagerView.fxml";
        } else if (selectedUser.equals("Project Manager")) {
            fxmlPath = "/main/ngooperation/dilir_2411754/Project_Manager/ProjectManagerView.fxml";
        }

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(loader.load()));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Could not open dashboard for " + selectedUser + ".");
            alert.showAndWait();
        }
    }
}
