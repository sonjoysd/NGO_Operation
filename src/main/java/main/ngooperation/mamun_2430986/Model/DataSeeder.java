package main.ngooperation.mamun_2430986.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import main.ngooperation.mamun_2430986.Model.NonUser.PerformanceIndicator;
import main.ngooperation.mamun_2430986.Utility.FileReadWrite;

public class DataSeeder {

    public static void main(String[] args) {
        ObservableList<PerformanceIndicator> kpis = FXCollections.observableArrayList();
        kpis.add(new PerformanceIndicator("KPI-101", "2026-Q1", "Education", "Students Enrolled", 500.0, 480.0));
        kpis.add(new PerformanceIndicator("KPI-102", "2026-Q1", "Health", "Clinic Visits Completed", 1200.0, 1250.0));
        kpis.add(new PerformanceIndicator("KPI-103", "2026-Q2", "Housing", "Shelters Built", 80.0, 68.0));
        kpis.add(new PerformanceIndicator("KPI-104", "2026-Q2", "Empowerment", "Training Graduates", 300.0, 310.0));
        FileReadWrite.saveData(kpis, "PerformanceIndicators.bin");

        System.out.println("Seeded PerformanceIndicators.bin");
    }
}
