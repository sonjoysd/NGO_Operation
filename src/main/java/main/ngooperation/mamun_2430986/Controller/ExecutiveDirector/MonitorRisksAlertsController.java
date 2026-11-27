package main.ngooperation.mamun_2430986.Controller.ExecutiveDirector;

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
import main.ngooperation.mamun_2430986.Model.NonUser.RiskAlert;
import main.ngooperation.mamun_2430986.Model.User.ExecutiveDirector;
import main.ngooperation.mamun_2430986.Utility.AlertHelper;

import java.io.IOException;

public class MonitorRisksAlertsController {

    @FXML
    private ComboBox<String> severityCB;
    @FXML
    private TableView<RiskAlert> riskTV;
    @FXML
    private TableColumn<RiskAlert, String> alertIdTC;
    @FXML
    private TableColumn<RiskAlert, String> projectIdTC;
    @FXML
    private TableColumn<RiskAlert, String> descriptionTC;
    @FXML
    private TableColumn<RiskAlert, String> severityTC;
    @FXML
    private TableColumn<RiskAlert, String> raisedByTC;
    @FXML
    private TableColumn<RiskAlert, String> statusTC;
    @FXML
    private ComboBox<String> alertIdCB;
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
        alertIdTC.setCellValueFactory(new PropertyValueFactory<>("alertId"));
        projectIdTC.setCellValueFactory(new PropertyValueFactory<>("projectId"));
        descriptionTC.setCellValueFactory(new PropertyValueFactory<>("description"));
        severityTC.setCellValueFactory(new PropertyValueFactory<>("severity"));
        raisedByTC.setCellValueFactory(new PropertyValueFactory<>("raisedBy"));
        statusTC.setCellValueFactory(new PropertyValueFactory<>("status"));

        severityCB.getItems().clear();
        severityCB.getItems().add("All");
        severityCB.getItems().add("Low");
        severityCB.getItems().add("Medium");
        severityCB.getItems().add("High");
        severityCB.getItems().add("Critical");
        severityCB.setValue("All");

        ArrayList<RiskAlert> all = ExecutiveDirector.loadAllRiskAlerts();
        riskTV.getItems().clear();
        riskTV.getItems().addAll(all);

        alertIdCB.getItems().clear();
        for (RiskAlert r : all) {
            alertIdCB.getItems().add(r.getAlertId());
        }
    }

    @FXML
    public void filterButtonOnAction(ActionEvent actionEvent) {
        ArrayList<RiskAlert> all = ExecutiveDirector.loadAllRiskAlerts();
        String selectedSeverity = severityCB.getValue();

        riskTV.getItems().clear();
        alertIdCB.getItems().clear();

        for (RiskAlert r : all) {
            if (selectedSeverity == null || selectedSeverity.equals("All") || r.getSeverity().equals(selectedSeverity)) {
                riskTV.getItems().add(r);
                alertIdCB.getItems().add(r.getAlertId());
            }
        }

        if (riskTV.getItems().isEmpty()) {
            AlertHelper.showInfo("No risk alerts found.");
        }
    }

    @FXML
    public void saveReviewOnAction(ActionEvent actionEvent) {
        if (alertIdCB.getValue() == null || reviewNoteTF.getText().isEmpty()) {
            AlertHelper.showError("Please select an Alert ID and enter a review note.");
            return;
        }

        ExecutiveDirector.saveReviewNote(alertIdCB.getValue(), "Executive Director", reviewNoteTF.getText());
        AlertHelper.showInfo("Review note saved for " + alertIdCB.getValue() + ".");
        reviewNoteTF.clear();
    }
}
