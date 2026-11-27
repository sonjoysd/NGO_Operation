package main.ngooperation.mamun_2430986.Controller.ExecutiveDirector;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ReviewKPIsController {

    @FXML
    private ComboBox<String> periodCB;
    @FXML
    private TableView kpiTV;
    @FXML
    private TableColumn idTC;
    @FXML
    private TableColumn periodTC;
    @FXML
    private TableColumn areaTC;
    @FXML
    private TableColumn indicatorTC;
    @FXML
    private TableColumn targetTC;
    @FXML
    private TableColumn actualTC;
    @FXML
    private ComboBox<String> kpiIdCB;
    @FXML
    private TextField reviewNoteTF;

    @FXML
    public void initialize() {
    }

    @FXML
    public void filterButtonOnAction(ActionEvent actionEvent) {
    }

    @FXML
    public void saveReviewOnAction(ActionEvent actionEvent) {
    }

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
}
