package main.ngooperation.mamun_2430986.Controller.ProjectCoordinator;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import main.ngooperation.mamun_2430986.Model.NonUser.StaffAssignment;
import main.ngooperation.mamun_2430986.Model.User.ProjectCoordinator;
import main.ngooperation.mamun_2430986.Utility.AlertHelper;

import java.io.IOException;
import java.time.LocalDate;

public class CoordinateFieldStaffController {

    @FXML
    private TextField projectIdTF;
    @FXML
    private TextField staffNameTF;
    @FXML
    private TextField roleTaskTF;
    @FXML
    private TextField locationTF;
    @FXML
    private DatePicker assignedDateDP;
    @FXML
    private ComboBox<String> statusCB;
    @FXML
    private TableView<StaffAssignment> assignmentTV;
    @FXML
    private TableColumn<StaffAssignment, String> assignmentIdTC;
    @FXML
    private TableColumn<StaffAssignment, String> projectIdTC;
    @FXML
    private TableColumn<StaffAssignment, String> staffNameTC;
    @FXML
    private TableColumn<StaffAssignment, String> roleTaskTC;
    @FXML
    private TableColumn<StaffAssignment, LocalDate> assignedDateTC;
    @FXML
    private TableColumn<StaffAssignment, String> statusTC;

    private void switchScene(ActionEvent actionEvent, String fxmlFileName) {
        try {
            String path = "/main/ngooperation/mamun_2430986/ProjectCoordinator/" + fxmlFileName;
            if (fxmlFileName.startsWith("/")) {
                path = fxmlFileName;
            }
            FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(loader.load()));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void prepareSchedulesOnAction(ActionEvent actionEvent) {
        switchScene(actionEvent, "PrepareActivitySchedulesView.fxml");
    }

    @FXML
    public void coordinateStaffOnAction(ActionEvent actionEvent) {
        switchScene(actionEvent, "CoordinateFieldStaffView.fxml");
    }

    @FXML
    public void reviewServiceRequestsOnAction(ActionEvent actionEvent) {
        switchScene(actionEvent, "ReviewServiceRequestsView.fxml");
    }

    @FXML
    public void trackMilestonesOnAction(ActionEvent actionEvent) {
        switchScene(actionEvent, "TrackMilestonesView.fxml");
    }

    @FXML
    public void coordinateProcurementOnAction(ActionEvent actionEvent) {
        switchScene(actionEvent, "CoordinateProcurementView.fxml");
    }

    @FXML
    public void organizeMeetingsOnAction(ActionEvent actionEvent) {
        switchScene(actionEvent, "OrganizeMeetingsView.fxml");
    }

    @FXML
    public void compileProgressOnAction(ActionEvent actionEvent) {
        switchScene(actionEvent, "CompileProgressInfoView.fxml");
    }

    @FXML
    public void escalateIssuesOnAction(ActionEvent actionEvent) {
        switchScene(actionEvent, "EscalateDelaysIssuesView.fxml");
    }

    @FXML
    public void logoutOnAction(ActionEvent actionEvent) {
        switchScene(actionEvent, "/main/ngooperation/LoginView.fxml");
    }

    @FXML
    public void initialize() {
        assignmentIdTC.setCellValueFactory(new PropertyValueFactory<>("assignmentId"));
        projectIdTC.setCellValueFactory(new PropertyValueFactory<>("projectId"));
        staffNameTC.setCellValueFactory(new PropertyValueFactory<>("staffName"));
        roleTaskTC.setCellValueFactory(new PropertyValueFactory<>("roleTask"));
        assignedDateTC.setCellValueFactory(new PropertyValueFactory<>("assignedDate"));
        statusTC.setCellValueFactory(new PropertyValueFactory<>("status"));

        statusCB.getItems().clear();
        statusCB.getItems().add("Assigned");
        statusCB.getItems().add("Active");
        statusCB.getItems().add("Completed");

        refresh();
    }

    private void refresh() {
        ArrayList<StaffAssignment> list = ProjectCoordinator.loadAllAssignments();
        assignmentTV.getItems().clear();
        assignmentTV.getItems().addAll(list);
    }

    @FXML
    public void saveAssignmentOnAction(ActionEvent actionEvent) {
        if (projectIdTF.getText().isEmpty() || staffNameTF.getText().isEmpty()
                || roleTaskTF.getText().isEmpty() || locationTF.getText().isEmpty()
                || assignedDateDP.getValue() == null || statusCB.getValue() == null) {
            AlertHelper.showError("Please fill all fields and select a date and status.");
            return;
        }

        String assignmentId = "ASG-" + (201 + ProjectCoordinator.loadAllAssignments().size());
        StaffAssignment assignment = new StaffAssignment(
                assignmentId,
                projectIdTF.getText(),
                staffNameTF.getText(),
                roleTaskTF.getText(),
                locationTF.getText(),
                statusCB.getValue(),
                assignedDateDP.getValue()
        );

        if (ProjectCoordinator.addAssignment(assignment)) {
            AlertHelper.showInfo("Field staff assignment saved: " + assignmentId);
            projectIdTF.clear();
            staffNameTF.clear();
            roleTaskTF.clear();
            locationTF.clear();
            assignedDateDP.setValue(null);
            statusCB.setValue(null);
            refresh();
        } else {
            AlertHelper.showError("Assignment conflict: this staff member is already assigned on that date.");
        }
    }
}
