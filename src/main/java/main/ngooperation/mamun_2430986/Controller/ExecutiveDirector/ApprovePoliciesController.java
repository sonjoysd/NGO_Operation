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
import main.ngooperation.mamun_2430986.Model.NonUser.OrganizationPolicy;
import main.ngooperation.mamun_2430986.Model.User.ExecutiveDirector;
import main.ngooperation.mamun_2430986.Utility.AlertHelper;

import java.io.IOException;

public class ApprovePoliciesController {

    @FXML
    private TableView<OrganizationPolicy> policyTV;
    @FXML
    private TableColumn<OrganizationPolicy, String> policyIdTC;
    @FXML
    private TableColumn<OrganizationPolicy, String> titleTC;
    @FXML
    private TableColumn<OrganizationPolicy, String> areaTC;
    @FXML
    private TableColumn<OrganizationPolicy, String> draftedByTC;
    @FXML
    private TableColumn<OrganizationPolicy, String> statusTC;
    @FXML
    private ComboBox<String> policyIdCB;
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
        policyIdTC.setCellValueFactory(new PropertyValueFactory<>("policyId"));
        titleTC.setCellValueFactory(new PropertyValueFactory<>("title"));
        areaTC.setCellValueFactory(new PropertyValueFactory<>("area"));
        draftedByTC.setCellValueFactory(new PropertyValueFactory<>("draftedBy"));
        statusTC.setCellValueFactory(new PropertyValueFactory<>("status"));

        actionCB.getItems().clear();
        actionCB.getItems().add("Approve");
        actionCB.getItems().add("Reject");
        actionCB.getItems().add("Return for Correction");

        refresh();
    }

    private void refresh() {
        ArrayList<OrganizationPolicy> list = ExecutiveDirector.loadAllPolicies();
        policyTV.getItems().clear();
        policyTV.getItems().addAll(list);

        policyIdCB.getItems().clear();
        for (OrganizationPolicy p : list) {
            policyIdCB.getItems().add(p.getPolicyId());
        }
    }

    @FXML
    public void applyDecisionOnAction(ActionEvent actionEvent) {
        if (policyIdCB.getValue() == null || actionCB.getValue() == null || commentTF.getText().isEmpty()) {
            AlertHelper.showError("Please select a policy ID, decision, and enter a comment.");
            return;
        }
        if (ExecutiveDirector.applyPolicyAction(policyIdCB.getValue(), actionCB.getValue(), commentTF.getText())) {
            AlertHelper.showInfo("Decision saved for " + policyIdCB.getValue() + ".");
            commentTF.clear();
            refresh();
        } else {
            AlertHelper.showError("Policy not found.");
        }
    }
}
