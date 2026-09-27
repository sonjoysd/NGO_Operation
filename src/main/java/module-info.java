module main.ngooperation {
    requires javafx.controls;
    requires javafx.fxml;


    opens main.ngooperation to javafx.fxml;
    exports main.ngooperation;
}