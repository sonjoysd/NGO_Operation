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

    exports main.ngooperation;
}