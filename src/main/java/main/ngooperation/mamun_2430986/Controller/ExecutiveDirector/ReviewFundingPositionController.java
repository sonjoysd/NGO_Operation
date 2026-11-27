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
import main.ngooperation.mamun_2430986.Model.NonUser.FundingPosition;
import main.ngooperation.mamun_2430986.Model.User.ExecutiveDirector;
import main.ngooperation.mamun_2430986.Utility.AlertHelper;

import java.io.IOException;

public class ReviewFundingPositionController {

    @FXML
    private ComboBox<String> periodCB;
    @FXML
    private TableView<FundingPosition> fundingTV;
    @FXML
    private TableColumn<FundingPosition, String> recordIdTC;
    @FXML
    private TableColumn<FundingPosition, String> periodTC;
    @FXML
    private TableColumn<FundingPosition, String> sourceTC;
    @FXML
    private TableColumn<FundingPosition, Double> targetAmountTC;
    @FXML
    private TableColumn<FundingPosition, Double> securedAmountTC;
    @FXML
    private TableColumn<FundingPosition, String> statusTC;
    @FXML
    private ComboBox<String> recordIdCB;
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
        recordIdTC.setCellValueFactory(new PropertyValueFactory<>("recordId"));
        periodTC.setCellValueFactory(new PropertyValueFactory<>("period"));
        sourceTC.setCellValueFactory(new PropertyValueFactory<>("source"));
        targetAmountTC.setCellValueFactory(new PropertyValueFactory<>("targetAmount"));
        securedAmountTC.setCellValueFactory(new PropertyValueFactory<>("securedAmount"));
        statusTC.setCellValueFactory(new PropertyValueFactory<>("status"));

        ObservableList<FundingPosition> all = ExecutiveDirector.loadAllFundingPositions();

        periodCB.getItems().clear();
        periodCB.getItems().add("All");
        for (FundingPosition f : all) {
            if (!periodCB.getItems().contains(f.getPeriod())) {
                periodCB.getItems().add(f.getPeriod());
            }
        }
        periodCB.setValue("All");

        fundingTV.getItems().clear();
        fundingTV.getItems().addAll(all);

        recordIdCB.getItems().clear();
        for (FundingPosition f : all) {
            recordIdCB.getItems().add(f.getRecordId());
        }
    }

    @FXML
    public void filterButtonOnAction(ActionEvent actionEvent) {
        ObservableList<FundingPosition> all = ExecutiveDirector.loadAllFundingPositions();
        String selectedPeriod = periodCB.getValue();

        fundingTV.getItems().clear();
        recordIdCB.getItems().clear();

        for (FundingPosition f : all) {
            if (selectedPeriod == null || selectedPeriod.equals("All") || f.getPeriod().equals(selectedPeriod)) {
                fundingTV.getItems().add(f);
                recordIdCB.getItems().add(f.getRecordId());
            }
        }

        if (fundingTV.getItems().isEmpty()) {
            AlertHelper.showInfo("No funding records found.");
        }
    }

    @FXML
    public void saveReviewOnAction(ActionEvent actionEvent) {
        if (recordIdCB.getValue() == null || reviewNoteTF.getText().isEmpty()) {
            AlertHelper.showError("Please select a Record ID and enter a review note.");
            return;
        }

        ExecutiveDirector.saveReviewNote(recordIdCB.getValue(), "Executive Director", reviewNoteTF.getText());
        AlertHelper.showInfo("Review note saved for " + recordIdCB.getValue() + ".");
        reviewNoteTF.clear();
    }
}
