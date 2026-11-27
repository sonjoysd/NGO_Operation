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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import main.ngooperation.mamun_2430986.Model.User.ProjectCoordinator;
import main.ngooperation.mamun_2430986.Utility.AlertHelper;
import main.ngooperation.sonjoy_2411704.model_class.NGOApplication;

import java.io.IOException;
import java.time.LocalDate;

public class ReviewServiceRequestsController {

    @FXML
    private ComboBox<String> programCB;
    @FXML
    private TableView<NGOApplication> requestTV;
    @FXML
    private TableColumn<NGOApplication, Integer> applicationIdTC;
    @FXML
    private TableColumn<NGOApplication, String> beneficiaryNameTC;
    @FXML
    private TableColumn<NGOApplication, String> programTypeTC;
    @FXML
    private TableColumn<NGOApplication, LocalDate> requestDateTC;
    @FXML
    private TableColumn<NGOApplication, String> statusTC;
    @FXML
    private ComboBox<Integer> applicationIdCB;
    @FXML
    private ComboBox<String> routeTeamCB;
    @FXML
    private TextField noteTF;

    private void switchScene(ActionEvent actionEvent, String fxmlFileName) {
        try {
            String path = "/main/ngooperation/mamun_2430986/ProjectCoordinator/" + fxmlFileName;
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
    public void logoutOnAction(ActionEvent actionEvent) {
        switchScene(actionEvent, "/main/ngooperation/LoginView.fxml");
    }

    @FXML
    public void initialize() {
        applicationIdTC.setCellValueFactory(new PropertyValueFactory<>("applicationID"));
        beneficiaryNameTC.setCellValueFactory(new PropertyValueFactory<>("beneficiaryName"));
        programTypeTC.setCellValueFactory(new PropertyValueFactory<>("programType"));
        requestDateTC.setCellValueFactory(new PropertyValueFactory<>("requestDate"));
        statusTC.setCellValueFactory(new PropertyValueFactory<>("status"));

        programCB.getItems().clear();
        programCB.getItems().add("All");
        programCB.getItems().add("Education Support Program");
        programCB.getItems().add("Health Support Program");
        programCB.getItems().add("Housing Support Program");
        programCB.getItems().add("Woman Empowerment Program");
        programCB.setValue("All");

        routeTeamCB.getItems().clear();
        routeTeamCB.getItems().add("Education Team");
        routeTeamCB.getItems().add("Health Team");
        routeTeamCB.getItems().add("Housing Team");
        routeTeamCB.getItems().add("Empowerment Team");

        refresh();
    }

    private void refresh() {
        ObservableList<NGOApplication> all = ProjectCoordinator.loadAllBeneficiaryRequests();
        String selectedProgram = programCB.getValue();

        requestTV.getItems().clear();
        applicationIdCB.getItems().clear();

        for (NGOApplication app : all) {
            if (selectedProgram == null || selectedProgram.equals("All") || app.getProgramType().equals(selectedProgram)) {
                requestTV.getItems().add(app);
                applicationIdCB.getItems().add(app.getApplicationID());
            }
        }
    }

    @FXML
    public void filterButtonOnAction(ActionEvent actionEvent) {
        refresh();
        if (requestTV.getItems().isEmpty()) {
            AlertHelper.showInfo("No beneficiary service requests found.");
        }
    }

    @FXML
    public void routeAndSaveOnAction(ActionEvent actionEvent) {
        if (applicationIdCB.getValue() == null || routeTeamCB.getValue() == null || noteTF.getText().isEmpty()) {
            AlertHelper.showError("Please select an Application ID, route team, and enter a review note.");
            return;
        }

        if (ProjectCoordinator.routeServiceRequest(applicationIdCB.getValue(), routeTeamCB.getValue(), noteTF.getText())) {
            AlertHelper.showInfo("Application " + applicationIdCB.getValue() + " routed to " + routeTeamCB.getValue() + ".");
            noteTF.clear();
            refresh();
        } else {
            AlertHelper.showError("Application not found.");
        }
    }
}
