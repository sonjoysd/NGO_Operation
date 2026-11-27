package main.ngooperation.mamun_2430986.Utility;

import javafx.scene.control.Alert;

public class AlertHelper {

    public static void showError(String errorText) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(errorText);
        alert.showAndWait();
    }

    public static void showInfo(String infoText) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(infoText);
        alert.showAndWait();
    }
}
