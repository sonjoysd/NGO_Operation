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
import main.ngooperation.mamun_2430986.Model.NonUser.PerformanceIndicator;
import main.ngooperation.mamun_2430986.Model.User.ExecutiveDirector;
import main.ngooperation.mamun_2430986.Utility.AlertHelper;

import java.io.IOException;

public class ReviewKPIsController {

    @FXML
    private ComboBox<String> periodCB;
    @FXML
    private TableView<PerformanceIndicator> kpiTV;
    @FXML
    private TableColumn<PerformanceIndicator, String> idTC;
    @FXML
    private TableColumn<PerformanceIndicator, String> periodTC;
    @FXML
    private TableColumn<PerformanceIndicator, String> areaTC;
    @FXML
    private TableColumn<PerformanceIndicator, String> indicatorTC;
    @FXML
    private TableColumn<PerformanceIndicator, Double> targetTC;
    @FXML
    private TableColumn<PerformanceIndicator, Double> actualTC;
    @FXML
    private ComboBox<String> kpiIdCB;
    @FXML
    private TextField reviewNoteTF;

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
        idTC.setCellValueFactory(new PropertyValueFactory<>("indicatorId"));
        periodTC.setCellValueFactory(new PropertyValueFactory<>("period"));
        areaTC.setCellValueFactory(new PropertyValueFactory<>("programArea"));
        indicatorTC.setCellValueFactory(new PropertyValueFactory<>("indicatorName"));
        targetTC.setCellValueFactory(new PropertyValueFactory<>("target"));
        actualTC.setCellValueFactory(new PropertyValueFactory<>("actual"));

        ObservableList<PerformanceIndicator> all = ExecutiveDirector.loadAllKPIs();

        periodCB.getItems().clear();
        periodCB.getItems().add("All");
        for (PerformanceIndicator kpi : all) {
            if (!periodCB.getItems().contains(kpi.getPeriod())) {
                periodCB.getItems().add(kpi.getPeriod());
            }
        }
        periodCB.setValue("All");

        kpiTV.getItems().clear();
        kpiTV.getItems().addAll(all);

        kpiIdCB.getItems().clear();
        for (PerformanceIndicator kpi : all) {
            kpiIdCB.getItems().add(kpi.getIndicatorId());
        }
    }

    @FXML
    public void filterButtonOnAction(ActionEvent actionEvent) {
        ObservableList<PerformanceIndicator> all = ExecutiveDirector.loadAllKPIs();
        String selectedPeriod = periodCB.getValue();

        kpiTV.getItems().clear();
        kpiIdCB.getItems().clear();

        for (PerformanceIndicator kpi : all) {
            if (selectedPeriod == null || selectedPeriod.equals("All") || kpi.getPeriod().equals(selectedPeriod)) {
                kpiTV.getItems().add(kpi);
                kpiIdCB.getItems().add(kpi.getIndicatorId());
            }
        }

        if (kpiTV.getItems().isEmpty()) {
            AlertHelper.showInfo("No KPI records found.");
        }
    }

    @FXML
    public void saveReviewOnAction(ActionEvent actionEvent) {
        if (kpiIdCB.getValue() == null || reviewNoteTF.getText().isEmpty()) {
            AlertHelper.showError("Please select a KPI ID and enter a review note.");
            return;
        }

        ExecutiveDirector.saveReviewNote(kpiIdCB.getValue(), "Executive Director", reviewNoteTF.getText());
        AlertHelper.showInfo("Review note saved for " + kpiIdCB.getValue() + ".");
        reviewNoteTF.clear();
    }

}
