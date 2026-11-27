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
import main.ngooperation.mamun_2430986.Model.NonUser.ResourceRequest;
import main.ngooperation.mamun_2430986.Model.User.ProjectCoordinator;
import main.ngooperation.mamun_2430986.Utility.AlertHelper;

import java.io.IOException;
import java.time.LocalDate;

public class CoordinateProcurementController {

    @FXML
    private TextField projectIdTF;
    @FXML
    private TextField itemTF;
    @FXML
    private TextField quantityTF;
    @FXML
    private DatePicker neededDateDP;
    @FXML
    private TextField requestedByTF;
    @FXML
    private ComboBox<String> statusCB;
    @FXML
    private TableView<ResourceRequest> requestTV;
    @FXML
    private TableColumn<ResourceRequest, String> requestIdTC;
    @FXML
    private TableColumn<ResourceRequest, String> projectIdTC;
    @FXML
    private TableColumn<ResourceRequest, String> itemTC;
    @FXML
    private TableColumn<ResourceRequest, Integer> quantityTC;
    @FXML
    private TableColumn<ResourceRequest, LocalDate> neededDateTC;
    @FXML
    private TableColumn<ResourceRequest, String> statusTC;

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
        requestIdTC.setCellValueFactory(new PropertyValueFactory<>("requestId"));
        projectIdTC.setCellValueFactory(new PropertyValueFactory<>("projectId"));
        itemTC.setCellValueFactory(new PropertyValueFactory<>("item"));
        quantityTC.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        neededDateTC.setCellValueFactory(new PropertyValueFactory<>("neededDate"));
        statusTC.setCellValueFactory(new PropertyValueFactory<>("status"));

        statusCB.getItems().clear();
        statusCB.getItems().add("Requested");
        statusCB.getItems().add("Forwarded to PM");
        statusCB.getItems().add("Approved");

        refresh();
    }

    private void refresh() {
        ObservableList<ResourceRequest> list = ProjectCoordinator.loadAllResourceRequests();
        requestTV.getItems().clear();
        requestTV.getItems().addAll(list);
    }

    @FXML
    public void saveRequestOnAction(ActionEvent actionEvent) {
        if (projectIdTF.getText().isEmpty() || itemTF.getText().isEmpty()
                || quantityTF.getText().isEmpty() || neededDateDP.getValue() == null
                || requestedByTF.getText().isEmpty() || statusCB.getValue() == null) {
            AlertHelper.showError("Please fill all fields and select a date and status.");
            return;
        }

        int quantity;
        try {
            quantity = Integer.parseInt(quantityTF.getText());
        } catch (NumberFormatException e) {
            AlertHelper.showError("Quantity must be a whole number.");
            return;
        }
        if (quantity <= 0) {
            AlertHelper.showError("Quantity must be greater than zero.");
            return;
        }

        String requestId = "RES-" + System.currentTimeMillis();
        ResourceRequest request = new ResourceRequest(
                requestId,
                projectIdTF.getText(),
                itemTF.getText(),
                requestedByTF.getText(),
                statusCB.getValue(),
                quantity,
                neededDateDP.getValue()
        );

        if (ProjectCoordinator.addResourceRequest(request)) {
            AlertHelper.showInfo("Resource request saved: " + requestId);
            projectIdTF.clear();
            itemTF.clear();
            quantityTF.clear();
            requestedByTF.clear();
            neededDateDP.setValue(null);
            statusCB.setValue(null);
            refresh();
        } else {
            AlertHelper.showError("Duplicate resource request for this project, item, and date.");
        }
    }
}
