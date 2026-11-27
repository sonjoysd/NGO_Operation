package main.ngooperation.mamun_2430986.Controller.ProjectCoordinator;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import main.ngooperation.mamun_2430986.Model.NonUser.ProjectProgressReport;
import main.ngooperation.mamun_2430986.Model.User.ProjectCoordinator;
import main.ngooperation.mamun_2430986.Utility.AlertHelper;

import java.io.IOException;
import java.time.LocalDate;

public class CompileProgressInfoController {

    @FXML
    private ComboBox<String> projectCB;
    @FXML
    private ComboBox<String> periodCB;
    @FXML
    private TextArea reportTA;
    @FXML
    private TableView<ProjectProgressReport> reportTV;
    @FXML
    private TableColumn<ProjectProgressReport, String> reportIdTC;
    @FXML
    private TableColumn<ProjectProgressReport, String> projectIdTC;
    @FXML
    private TableColumn<ProjectProgressReport, String> periodTC;
    @FXML
    private TableColumn<ProjectProgressReport, LocalDate> generatedDateTC;
    @FXML
    private TableColumn<ProjectProgressReport, String> summaryTC;

    private void switchScene(ActionEvent actionEvent, String fxmlFileName) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "/main/ngooperation/mamun_2430986/ProjectCoordinator/" + fxmlFileName));
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
    public void initialize() {
        reportIdTC.setCellValueFactory(new PropertyValueFactory<>("reportId"));
        projectIdTC.setCellValueFactory(new PropertyValueFactory<>("projectId"));
        periodTC.setCellValueFactory(new PropertyValueFactory<>("period"));
        generatedDateTC.setCellValueFactory(new PropertyValueFactory<>("generatedDate"));
        summaryTC.setCellValueFactory(new PropertyValueFactory<>("summary"));

        projectCB.getItems().clear();
        projectCB.getItems().add("All");
        projectCB.getItems().add("PRJ-01");
        projectCB.getItems().add("PRJ-02");
        projectCB.getItems().add("PRJ-03");
        projectCB.getItems().add("PRJ-04");

        periodCB.getItems().clear();
        periodCB.getItems().add("2026-Q1");
        periodCB.getItems().add("2026-Q2");
        periodCB.getItems().add("2026-Q3");
        periodCB.getItems().add("2026-Q4");

        refresh();
    }

    private void refresh() {
        ObservableList<ProjectProgressReport> list = ProjectCoordinator.loadAllProgressReports();
        reportTV.getItems().clear();
        reportTV.getItems().addAll(list);
    }

    @FXML
    public void generateReportOnAction(ActionEvent actionEvent) {
        if (projectCB.getValue() == null || periodCB.getValue() == null) {
            AlertHelper.showError("Please select both a project and a reporting period.");
            return;
        }

        String text = ProjectCoordinator.compileAndSaveReport(projectCB.getValue(), periodCB.getValue());
        reportTA.setText(text);
        AlertHelper.showInfo("Project progress report generated and saved.");
        refresh();
    }
}
