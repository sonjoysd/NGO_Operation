package main.ngooperation.mamun_2430986.Controller.ProjectCoordinator;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import main.ngooperation.mamun_2430986.Model.NonUser.OperationalIssue;
import main.ngooperation.mamun_2430986.Model.User.ProjectCoordinator;
import main.ngooperation.mamun_2430986.Utility.AlertHelper;

import java.io.IOException;
import java.time.LocalDate;

public class EscalateDelaysIssuesController {

    @FXML
    private TableView<OperationalIssue> issueTV;
    @FXML
    private TableColumn<OperationalIssue, String> issueIdTC;
    @FXML
    private TableColumn<OperationalIssue, String> projectIdTC;
    @FXML
    private TableColumn<OperationalIssue, String> descriptionTC;
    @FXML
    private TableColumn<OperationalIssue, String> severityTC;
    @FXML
    private TableColumn<OperationalIssue, LocalDate> reportedDateTC;
    @FXML
    private TableColumn<OperationalIssue, String> statusTC;
    @FXML
    private ComboBox<String> issueIdCB;
    @FXML
    private ComboBox<String> severityCB;
    @FXML
    private TextField noteTF;

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
        issueIdTC.setCellValueFactory(new PropertyValueFactory<>("issueId"));
        projectIdTC.setCellValueFactory(new PropertyValueFactory<>("projectId"));
        descriptionTC.setCellValueFactory(new PropertyValueFactory<>("description"));
        severityTC.setCellValueFactory(new PropertyValueFactory<>("severity"));
        reportedDateTC.setCellValueFactory(new PropertyValueFactory<>("reportedDate"));
        statusTC.setCellValueFactory(new PropertyValueFactory<>("status"));

        severityCB.getItems().clear();
        severityCB.getItems().add("Medium");
        severityCB.getItems().add("High");
        severityCB.getItems().add("Critical");

        refresh();
    }

    private void refresh() {
        ArrayList<OperationalIssue> list = ProjectCoordinator.loadAllIssues();
        issueTV.getItems().clear();
        issueTV.getItems().addAll(list);

        issueIdCB.getItems().clear();
        for (OperationalIssue issue : list) {
            issueIdCB.getItems().add(issue.getIssueId());
        }
    }

    @FXML
    public void escalateOnAction(ActionEvent actionEvent) {
        if (issueIdCB.getValue() == null || severityCB.getValue() == null || noteTF.getText().isEmpty()) {
            AlertHelper.showError("Please select an Issue ID, severity, and enter an escalation note.");
            return;
        }

        if (ProjectCoordinator.escalateIssueToDirector(issueIdCB.getValue(), severityCB.getValue(), noteTF.getText())) {
            AlertHelper.showInfo("Issue " + issueIdCB.getValue() + " escalated to Executive Director.");
            noteTF.clear();
            refresh();
        } else {
            AlertHelper.showError("Issue not found.");
        }
    }
}
