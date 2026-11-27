package main.ngooperation.shafial_2411827.controller.field_officer;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import main.ngooperation.AppendableObjectOutputStream;
import main.ngooperation.HelloApplication;
import main.ngooperation.shafial_2411827.FieldActivities;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class submitfiledactivitisController
{
    @javafx.fxml.FXML
    private ComboBox <String>ProjectCB;
    @javafx.fxml.FXML
    private DatePicker PreparedonDP;
    @javafx.fxml.FXML
    private DatePicker ProjectStartDP;
    @javafx.fxml.FXML
    private TableView <FieldActivities> tableView;
    @javafx.fxml.FXML
    private ComboBox <String>ServicesAreaCB;
    @javafx.fxml.FXML
    private ComboBox <String>ReportTypeCB;
    @javafx.fxml.FXML
    private DatePicker PeriodEndDP;
    @javafx.fxml.FXML
    private TableColumn <FieldActivities,String> projectTC;
    @javafx.fxml.FXML
    private TableColumn <FieldActivities,String> ServicesTC;
    @javafx.fxml.FXML
    private TableColumn <FieldActivities,String> resultTC;
    @javafx.fxml.FXML
    private TableColumn<FieldActivities, LocalDate> startDateTC;
    @javafx.fxml.FXML
    private TableColumn <FieldActivities, LocalDate>projectEndTC;
    @javafx.fxml.FXML
    private TextArea resultLabel;

    ArrayList<FieldActivities> activityList;

    @javafx.fxml.FXML
    public void initialize() {

        activityList= new ArrayList<>();

        ProjectCB.getItems().addAll("Educational","Water and Sanitation","Gender Equality");
        ServicesAreaCB.getItems().addAll("Health","Nutrition","Livelihood");
        ReportTypeCB.getItems().addAll("Short","Long","Medium");

        projectTC.setCellValueFactory(new PropertyValueFactory<>("project"));
        ServicesTC.setCellValueFactory(new PropertyValueFactory<>("servicesArea"));
        resultTC.setCellValueFactory(new PropertyValueFactory<>("summarizedResult"));
        startDateTC.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        projectEndTC.setCellValueFactory(new PropertyValueFactory<>("endDate"));
    }


    @javafx.fxml.FXML
    public void SubmitOnAction(ActionEvent actionEvent) {

        FieldActivities newActivity= new FieldActivities(
                ProjectCB.getValue(),
                ReportTypeCB.getValue(),
                ServicesAreaCB.getValue(),
                resultLabel.getText(),
                ProjectStartDP.getValue(),
                PeriodEndDP.getValue(),
                PreparedonDP.getValue()
        );

        File file=new File("FieldActivities.bin");

        FileOutputStream fos;
        ObjectOutputStream oos;

        try{
            if (file.exists()){
                fos= new FileOutputStream(file,true);
                oos=new AppendableObjectOutputStream(fos);
            }
            else{
                fos=new FileOutputStream(file);
                oos=new ObjectOutputStream(fos);
            }

            oos.writeObject(newActivity);
            activityList.add(newActivity);
            oos.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    @javafx.fxml.FXML
    public void BackDashbordOnAction(ActionEvent actionEvent) {

            try {
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/main/ngooperation/shafial_2411827/field_officer/mainDashboardView.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                stage.setTitle("Dashboard");
                stage.setScene(scene);
                stage.show();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }



    @javafx.fxml.FXML
    public void ReviewOnAction(ActionEvent actionEvent) {

        File file=new File("FieldActivities.bin");

        FileInputStream fis;
        ObjectInputStream ois;

        try{
            fis=new FileInputStream(file);
            ois=new ObjectInputStream(fis);
             while(true){
                 try{
                     FieldActivities a= (FieldActivities) ois.readObject();
                     tableView.getItems().add(a);
                 }
                 catch (Exception e) {
                     e.printStackTrace();
                     ois.close();
                     break;
                 }
             }
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}