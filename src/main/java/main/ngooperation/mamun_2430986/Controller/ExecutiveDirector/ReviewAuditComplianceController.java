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
import main.ngooperation.mamun_2430986.Model.NonUser.AuditSummary;
import main.ngooperation.mamun_2430986.Model.User.ExecutiveDirector;
import main.ngooperation.mamun_2430986.Utility.AlertHelper;

import java.io.IOException;

public class ReviewAuditComplianceController {

    @FXML
    private ComboBox<String> periodCB;
    @FXML
    private TableView<AuditSummary> auditTV;
    @FXML
    private TableColumn<AuditSummary, String> auditIdTC;
    @FXML
    private TableColumn<AuditSummary, String> periodTC;
    @FXML
    private TableColumn<AuditSummary, String> areaTC;
    @FXML
    private TableColumn<AuditSummary, String> findingTC;
    @FXML
    private TableColumn<AuditSummary, String> complianceStatusTC;
    @FXML
    private ComboBox<String> auditIdCB;
    @FXML
    private TextField reviewNoteTF;

    private void switchScene(ActionEvent actionEvent, String fxmlFileName) {
        try {
            String path = "/main/ngooperation/mamun_2430986/ExecutiveDirector/" + fxmlFileName;
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
    public void logoutOnAction(ActionEvent actionEvent) {
        switchScene(actionEvent, "/main/ngooperation/LoginView.fxml");
    }

    @FXML
    public void initialize() {
        auditIdTC.setCellValueFactory(new PropertyValueFactory<>("auditId"));
        periodTC.setCellValueFactory(new PropertyValueFactory<>("period"));
        areaTC.setCellValueFactory(new PropertyValueFactory<>("area"));
        findingTC.setCellValueFactory(new PropertyValueFactory<>("finding"));
        complianceStatusTC.setCellValueFactory(new PropertyValueFactory<>("complianceStatus"));

        ObservableList<AuditSummary> all = ExecutiveDirector.loadAllAuditSummaries();

        periodCB.getItems().clear();
        periodCB.getItems().add("All");
        for (AuditSummary a : all) {
            if (!periodCB.getItems().contains(a.getPeriod())) {
                periodCB.getItems().add(a.getPeriod());
            }
        }
        periodCB.setValue("All");

        auditTV.getItems().clear();
        auditTV.getItems().addAll(all);

        auditIdCB.getItems().clear();
        for (AuditSummary a : all) {
            auditIdCB.getItems().add(a.getAuditId());
        }
    }

    @FXML
    public void filterButtonOnAction(ActionEvent actionEvent) {
        ObservableList<AuditSummary> all = ExecutiveDirector.loadAllAuditSummaries();
        String selectedPeriod = periodCB.getValue();

        auditTV.getItems().clear();
        auditIdCB.getItems().clear();

        for (AuditSummary a : all) {
            if (selectedPeriod == null || selectedPeriod.equals("All") || a.getPeriod().equals(selectedPeriod)) {
                auditTV.getItems().add(a);
                auditIdCB.getItems().add(a.getAuditId());
            }
        }

        if (auditTV.getItems().isEmpty()) {
            AlertHelper.showInfo("No audit summaries found.");
        }
    }

    @FXML
    public void saveReviewOnAction(ActionEvent actionEvent) {
        if (auditIdCB.getValue() == null || reviewNoteTF.getText().isEmpty()) {
            AlertHelper.showError("Please select an Audit ID and enter a review note.");
            return;
        }

        ExecutiveDirector.saveReviewNote(auditIdCB.getValue(), "Executive Director", reviewNoteTF.getText());
        AlertHelper.showInfo("Review note saved for " + auditIdCB.getValue() + ".");
        reviewNoteTF.clear();
    }
}
