package main.ngooperation.mamun_2430986.Controller.ExecutiveDirector;

import javafx.collections.ObservableList;
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
import main.ngooperation.mamun_2430986.Model.NonUser.DonorReport;
import main.ngooperation.mamun_2430986.Model.User.ExecutiveDirector;
import main.ngooperation.mamun_2430986.Utility.AlertHelper;

import java.io.IOException;

public class ApproveDonorReportsController {

    @FXML
    private TableView<DonorReport> reportTV;
    @FXML
    private TableColumn<DonorReport, String> reportIdTC;
    @FXML
    private TableColumn<DonorReport, String> donorNameTC;
    @FXML
    private TableColumn<DonorReport, String> periodTC;
    @FXML
    private TableColumn<DonorReport, String> summaryTC;
    @FXML
    private TableColumn<DonorReport, String> statusTC;
    @FXML
    private ComboBox<String> reportIdCB;
    @FXML
    private ComboBox<String> actionCB;
    @FXML
    private TextField commentTF;

    private void switchScene(ActionEvent actionEvent, String fxmlFileName) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "/main/ngooperation/mamun_2430986/ExecutiveDirector/" + fxmlFileName));
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(loader.load()));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void reviewKPIsOnAction(ActionEvent actionEvent) {
        switchScene(actionEvent, "ReviewKPIsView.fxml");
    }

    @FXML
    public void approveHighValueProjectsOnAction(ActionEvent actionEvent) {
        switchScene(actionEvent, "ApproveHighValueBudgetsView.fxml");
    }

    @FXML
    public void authorizeGrantsOnAction(ActionEvent actionEvent) {
        switchScene(actionEvent, "AuthorizeGrantApplicationsView.fxml");
    }

    @FXML
    public void approveDonorReportsOnAction(ActionEvent actionEvent) {
        switchScene(actionEvent, "ApproveDonorReportsView.fxml");
    }

    @FXML
    public void reviewAuditSummariesOnAction(ActionEvent actionEvent) {
        switchScene(actionEvent, "ReviewAuditComplianceView.fxml");
    }

    @FXML
    public void approvePoliciesOnAction(ActionEvent actionEvent) {
        switchScene(actionEvent, "ApprovePoliciesView.fxml");
    }

    @FXML
    public void monitorRisksAlertsOnAction(ActionEvent actionEvent) {
        switchScene(actionEvent, "MonitorRisksAlertsView.fxml");
    }

    @FXML
    public void reviewFundingPositionOnAction(ActionEvent actionEvent) {
        switchScene(actionEvent, "ReviewFundingPositionView.fxml");
    }

    @FXML
    public void initialize() {
        reportIdTC.setCellValueFactory(new PropertyValueFactory<>("reportId"));
        donorNameTC.setCellValueFactory(new PropertyValueFactory<>("donorName"));
        periodTC.setCellValueFactory(new PropertyValueFactory<>("period"));
        summaryTC.setCellValueFactory(new PropertyValueFactory<>("summary"));
        statusTC.setCellValueFactory(new PropertyValueFactory<>("status"));

        actionCB.getItems().clear();
        actionCB.getItems().add("Approve");
        actionCB.getItems().add("Reject");
        actionCB.getItems().add("Return for Correction");

        refresh();
    }

    private void refresh() {
        ObservableList<DonorReport> list = ExecutiveDirector.loadAllDonorReports();
        reportTV.getItems().clear();
        reportTV.getItems().addAll(list);

        reportIdCB.getItems().clear();
        for (DonorReport r : list) {
            reportIdCB.getItems().add(r.getReportId());
        }
    }

    @FXML
    public void applyDecisionOnAction(ActionEvent actionEvent) {
        if (reportIdCB.getValue() == null || actionCB.getValue() == null || commentTF.getText().isEmpty()) {
            AlertHelper.showError("Please select a report ID, decision, and enter a comment.");
            return;
        }
        if (ExecutiveDirector.applyDonorReportAction(reportIdCB.getValue(), actionCB.getValue(), commentTF.getText())) {
            AlertHelper.showInfo("Decision saved for " + reportIdCB.getValue() + ".");
            commentTF.clear();
            refresh();
        } else {
            AlertHelper.showError("Donor report not found.");
        }
    }
}
