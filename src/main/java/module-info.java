module NGO.Operation {
    requires javafx.base;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens main.ngooperation to javafx.fxml;
    opens main.ngooperation.shafial_2411827.controller.field_officer to javafx.fxml;
    opens main.ngooperation.shafial_2411827.controller.auditor to javafx.fxml;
    opens main.ngooperation.sonjoy_2411704.contoller_class.account_officer to javafx.fxml;
    opens main.ngooperation.sonjoy_2411704.contoller_class.beneficiary to javafx.fxml;
    opens main.ngooperation.sonjoy_2411704.model_class to javafx.base;
    opens main.ngooperation.mamun_2430986.Controller.ExecutiveDirector to javafx.fxml;
    opens main.ngooperation.mamun_2430986.Controller.ProjectCoordinator to javafx.fxml;
    // Enable in Step 3 once Model classes exist:
    // opens main.ngooperation.mamun_2430986.Model to javafx.base;

    exports main.ngooperation;
}