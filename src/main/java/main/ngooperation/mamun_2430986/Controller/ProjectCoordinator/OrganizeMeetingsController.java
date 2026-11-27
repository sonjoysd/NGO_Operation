package main.ngooperation.mamun_2430986.Controller.ProjectCoordinator;

import javafx.collections.ObservableList;
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
import main.ngooperation.mamun_2430986.Model.NonUser.CoordinationMeeting;
import main.ngooperation.mamun_2430986.Model.User.ProjectCoordinator;
import main.ngooperation.mamun_2430986.Utility.AlertHelper;

import java.io.IOException;
import java.time.LocalDate;

public class OrganizeMeetingsController {

    @FXML
    private TextField projectIdTF;
    @FXML
    private TextField topicTF;
    @FXML
    private DatePicker meetingDateDP;
    @FXML
    private TextField locationTF;
    @FXML
    private TextField teamTF;
    @FXML
    private ComboBox<String> statusCB;
    @FXML
    private TableView<CoordinationMeeting> meetingTV;
    @FXML
    private TableColumn<CoordinationMeeting, String> meetingIdTC;
    @FXML
    private TableColumn<CoordinationMeeting, String> projectIdTC;
    @FXML
    private TableColumn<CoordinationMeeting, String> topicTC;
    @FXML
    private TableColumn<CoordinationMeeting, LocalDate> meetingDateTC;
    @FXML
    private TableColumn<CoordinationMeeting, String> locationTC;
    @FXML
    private TableColumn<CoordinationMeeting, String> statusTC;

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
        meetingIdTC.setCellValueFactory(new PropertyValueFactory<>("meetingId"));
        projectIdTC.setCellValueFactory(new PropertyValueFactory<>("projectId"));
        topicTC.setCellValueFactory(new PropertyValueFactory<>("topic"));
        meetingDateTC.setCellValueFactory(new PropertyValueFactory<>("meetingDate"));
        locationTC.setCellValueFactory(new PropertyValueFactory<>("location"));
        statusTC.setCellValueFactory(new PropertyValueFactory<>("status"));

        statusCB.getItems().clear();
        statusCB.getItems().add("Scheduled");
        statusCB.getItems().add("Completed");
        statusCB.getItems().add("Cancelled");

        refresh();
    }

    private void refresh() {
        ObservableList<CoordinationMeeting> list = ProjectCoordinator.loadAllMeetings();
        meetingTV.getItems().clear();
        meetingTV.getItems().addAll(list);
    }

    @FXML
    public void saveMeetingOnAction(ActionEvent actionEvent) {
        if (projectIdTF.getText().isEmpty() || topicTF.getText().isEmpty()
                || meetingDateDP.getValue() == null || locationTF.getText().isEmpty()
                || teamTF.getText().isEmpty() || statusCB.getValue() == null) {
            AlertHelper.showError("Please fill all fields and select a date and status.");
            return;
        }

        String meetingId = "MTG-" + System.currentTimeMillis();
        CoordinationMeeting meeting = new CoordinationMeeting(
                meetingId,
                projectIdTF.getText(),
                topicTF.getText(),
                locationTF.getText(),
                teamTF.getText(),
                statusCB.getValue(),
                meetingDateDP.getValue()
        );

        if (ProjectCoordinator.addMeeting(meeting)) {
            AlertHelper.showInfo("Coordination meeting saved: " + meetingId);
            projectIdTF.clear();
            topicTF.clear();
            locationTF.clear();
            teamTF.clear();
            meetingDateDP.setValue(null);
            statusCB.setValue(null);
            refresh();
        } else {
            AlertHelper.showError("Meeting conflict: location is already booked on that date.");
        }
    }
}
