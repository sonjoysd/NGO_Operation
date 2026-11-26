package main.ngooperation.sonjoy_2411704.contoller_class.beneficiary;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import main.ngooperation.sonjoy_2411704.model_class.NGOApplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ApplyForNgoSupportProgramController
{
    @javafx.fxml.FXML
    private TextField beneficiaryIdTF;
    @javafx.fxml.FXML
    private TextField phoneNumTF;
    @javafx.fxml.FXML
    private TextField beneficiaryNameTF;
    @javafx.fxml.FXML
    private ComboBox<String> programTypeCB;
    @javafx.fxml.FXML
    private TextField houseHoldInfoTF;
    @javafx.fxml.FXML
    private DatePicker requestDateDP;
    @javafx.fxml.FXML
    private TextField applicationIdTF;
    Alert a;
    Alert b;
    @javafx.fxml.FXML
    public void initialize() {
        a = new Alert(Alert.AlertType.INFORMATION);
        b = new Alert(Alert.AlertType.ERROR);
        programTypeCB.getItems().addAll("Education Support Program","Health Support Program","Housing Support Program","Woman Empowerment Program");


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
    public void submitOnAction(ActionEvent actionEvent) {
        NGOApplication newApplication = new NGOApplication(Integer.parseInt(beneficiaryIdTF.getText()),
                Integer.parseInt(phoneNumTF.getText()),
                Integer.parseInt(applicationIdTF.getText()),
                beneficiaryNameTF.getText(),
                programTypeCB.getValue(),
                requestDateDP.getValue(),
                "Pending"
                );


        File file = new File("NGOApplication.bin");

        FileInputStream fis;
        FileOutputStream fos;

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