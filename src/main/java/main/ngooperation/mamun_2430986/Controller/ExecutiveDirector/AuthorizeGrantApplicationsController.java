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
import main.ngooperation.mamun_2430986.Model.NonUser.GrantApplication;
import main.ngooperation.mamun_2430986.Model.User.ExecutiveDirector;
import main.ngooperation.mamun_2430986.Utility.AlertHelper;

import java.io.IOException;
import java.time.LocalDate;

public class AuthorizeGrantApplicationsController {

    @FXML
    private TableView<GrantApplication> grantTV;
    @FXML
    private TableColumn<GrantApplication, String> grantIdTC;
    @FXML
    private TableColumn<GrantApplication, String> donorAgencyTC;
    @FXML
    private TableColumn<GrantApplication, String> programAreaTC;
    @FXML
    private TableColumn<GrantApplication, Double> amountTC;
    @FXML
    private TableColumn<GrantApplication, LocalDate> dateTC;
    @FXML
    private TableColumn<GrantApplication, String> statusTC;
    @FXML
    private ComboBox<String> grantIdCB;
    @FXML
    private ComboBox<String> actionCB;
    @FXML
    private TextField commentTF;

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
        grantIdTC.setCellValueFactory(new PropertyValueFactory<>("grantId"));
        donorAgencyTC.setCellValueFactory(new PropertyValueFactory<>("donorAgency"));
        programAreaTC.setCellValueFactory(new PropertyValueFactory<>("programArea"));
        amountTC.setCellValueFactory(new PropertyValueFactory<>("amount"));
        dateTC.setCellValueFactory(new PropertyValueFactory<>("date"));
        statusTC.setCellValueFactory(new PropertyValueFactory<>("status"));

        actionCB.getItems().clear();
        actionCB.getItems().add("Approve");
        actionCB.getItems().add("Reject");
        actionCB.getItems().add("Return for Correction");

        refresh();
    }

    private void refresh() {
        ArrayList<GrantApplication> list = ExecutiveDirector.loadAllGrants();
        grantTV.getItems().clear();
        grantTV.getItems().addAll(list);

        grantIdCB.getItems().clear();
        for (GrantApplication g : list) {
            grantIdCB.getItems().add(g.getGrantId());
        }
    }

    @FXML
    public void applyDecisionOnAction(ActionEvent actionEvent) {
        if (grantIdCB.getValue() == null || actionCB.getValue() == null || commentTF.getText().isEmpty()) {
            AlertHelper.showError("Please select a grant ID, decision, and enter a comment.");
            return;
        }
        if (ExecutiveDirector.applyGrantAction(grantIdCB.getValue(), actionCB.getValue(), commentTF.getText())) {
            AlertHelper.showInfo("Decision saved for " + grantIdCB.getValue() + ".");
            commentTF.clear();
            refresh();
        } else {
            AlertHelper.showError("Grant application not found.");
        }
    }
}
