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
import main.ngooperation.mamun_2430986.Model.NonUser.ProjectMilestone;
import main.ngooperation.mamun_2430986.Model.User.ProjectCoordinator;
import main.ngooperation.mamun_2430986.Utility.AlertHelper;

import java.io.IOException;
import java.time.LocalDate;

public class TrackMilestonesController {

    @FXML
    private ComboBox<String> projectCB;
    @FXML
    private TableView<ProjectMilestone> milestoneTV;
    @FXML
    private TableColumn<ProjectMilestone, String> milestoneIdTC;
    @FXML
    private TableColumn<ProjectMilestone, String> projectIdTC;
    @FXML
    private TableColumn<ProjectMilestone, String> titleTC;
    @FXML
    private TableColumn<ProjectMilestone, LocalDate> targetDateTC;
    @FXML
    private TableColumn<ProjectMilestone, Integer> completionPercentTC;
    @FXML
    private TableColumn<ProjectMilestone, String> statusTC;
    @FXML
    private ComboBox<String> milestoneIdCB;
    @FXML
    private TextField reviewNoteTF;

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
        milestoneIdTC.setCellValueFactory(new PropertyValueFactory<>("milestoneId"));
        projectIdTC.setCellValueFactory(new PropertyValueFactory<>("projectId"));
        titleTC.setCellValueFactory(new PropertyValueFactory<>("title"));
        targetDateTC.setCellValueFactory(new PropertyValueFactory<>("targetDate"));
        completionPercentTC.setCellValueFactory(new PropertyValueFactory<>("completionPercent"));
        statusTC.setCellValueFactory(new PropertyValueFactory<>("status"));

        ObservableList<ProjectMilestone> all = ProjectCoordinator.loadAllMilestones();

        projectCB.getItems().clear();
        projectCB.getItems().add("All");
        for (ProjectMilestone m : all) {
            if (!projectCB.getItems().contains(m.getProjectId())) {
                projectCB.getItems().add(m.getProjectId());
            }
        }
        projectCB.setValue("All");

        milestoneTV.getItems().clear();
        milestoneTV.getItems().addAll(all);

        milestoneIdCB.getItems().clear();
        for (ProjectMilestone m : all) {
            milestoneIdCB.getItems().add(m.getMilestoneId());
        }
    }

    @FXML
    public void filterButtonOnAction(ActionEvent actionEvent) {
        ObservableList<ProjectMilestone> all = ProjectCoordinator.loadAllMilestones();
        String selectedProject = projectCB.getValue();

        milestoneTV.getItems().clear();
        milestoneIdCB.getItems().clear();

        for (ProjectMilestone m : all) {
            if (selectedProject == null || selectedProject.equals("All") || m.getProjectId().equals(selectedProject)) {
                milestoneTV.getItems().add(m);
                milestoneIdCB.getItems().add(m.getMilestoneId());
            }
        }

        if (milestoneTV.getItems().isEmpty()) {
            AlertHelper.showInfo("No milestones found.");
        }
    }

    @FXML
    public void saveReviewOnAction(ActionEvent actionEvent) {
        if (milestoneIdCB.getValue() == null || reviewNoteTF.getText().isEmpty()) {
            AlertHelper.showError("Please select a Milestone ID and enter a review note.");
            return;
        }

        ProjectCoordinator.saveReviewNote(milestoneIdCB.getValue(), "Project Coordinator", reviewNoteTF.getText());
        AlertHelper.showInfo("Review note saved for " + milestoneIdCB.getValue() + ".");
        reviewNoteTF.clear();
    }
}
