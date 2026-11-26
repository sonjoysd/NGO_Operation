package main.ngooperation.sonjoy_2411704.contoller_class.beneficiary;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class checkApplicationAndServiceController
{
    @javafx.fxml.FXML
    private TableColumn<checkApplicationAndServiceController,Integer> applicationIdTable;
    @javafx.fxml.FXML
    private TableColumn<checkApplicationAndServiceController,String> statusTable;
    @javafx.fxml.FXML
    private ComboBox<String> programCB;
    @javafx.fxml.FXML
    private ComboBox<String> statusFilterCB;
    @javafx.fxml.FXML
    private TableColumn<checkApplicationAndServiceController, LocalDate> dateTable;
    @javafx.fxml.FXML
    private TableColumn<checkApplicationAndServiceController,String> programTable;
    @javafx.fxml.FXML
    private TableView<checkApplicationAndServiceController> tableview;
    @javafx.fxml.FXML
    private TextField applicationIdTF;
    Alert a;
    Alert b;

    @javafx.fxml.FXML
    public void initialize() {
        a = new Alert(Alert.AlertType.INFORMATION);
        b = new Alert(Alert.AlertType.ERROR);

        programCB.getItems().addAll("Education Support Program","Health Support Program","Housing Support Program","Woman Empowerment Program");
        statusFilterCB.getItems().addAll("Pending","Approved","Reject");

        applicationIdTable.setCellValueFactory(new PropertyValueFactory<checkApplicationAndServiceController,Integer>("applicationId"));
        statusTable.setCellValueFactory(new PropertyValueFactory<checkApplicationAndServiceController,String>("status"));
        programTable.setCellValueFactory(new PropertyValueFactory<checkApplicationAndServiceController,String>("program"));
        dateTable.setCellValueFactory(new PropertyValueFactory<checkApplicationAndServiceController,LocalDate>("date"));


    }

    @javafx.fxml.FXML
    public void searchOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void checkApplicationAndServiceOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void skillDevelopmentProgramOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void materialAssistanceOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void updateInformationOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void communityServiceOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void reportNgoServiceProblemOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void submitServiceFeedbackOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void applyNgoProgramOnAction(ActionEvent actionEvent) {
    }
}