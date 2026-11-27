package main.ngooperation.mamun_2430986.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import main.ngooperation.mamun_2430986.Model.NonUser.PerformanceIndicator;
import main.ngooperation.mamun_2430986.Model.NonUser.ProjectBudget;
import main.ngooperation.mamun_2430986.Utility.FileReadWrite;

import java.time.LocalDate;

public class DataSeeder {

    public static void main(String[] args) {
        ObservableList<PerformanceIndicator> kpis = FXCollections.observableArrayList();
        kpis.add(new PerformanceIndicator("KPI-101", "2026-Q1", "Education", "Students Enrolled", 500.0, 480.0));
        kpis.add(new PerformanceIndicator("KPI-102", "2026-Q1", "Health", "Clinic Visits Completed", 1200.0, 1250.0));
        kpis.add(new PerformanceIndicator("KPI-103", "2026-Q2", "Housing", "Shelters Built", 80.0, 68.0));
        kpis.add(new PerformanceIndicator("KPI-104", "2026-Q2", "Empowerment", "Training Graduates", 300.0, 310.0));
        FileReadWrite.saveData(kpis, "PerformanceIndicators.bin");

        ObservableList<ProjectBudget> budgets = FXCollections.observableArrayList();
        budgets.add(new ProjectBudget("BUD-201", "PRJ-01", "Project Manager", "Pending", "", 85000.0, LocalDate.of(2026, 3, 10)));
        budgets.add(new ProjectBudget("BUD-202", "PRJ-02", "Project Manager", "Pending", "", 120000.0, LocalDate.of(2026, 3, 14)));
        budgets.add(new ProjectBudget("BUD-203", "PRJ-03", "Account Officer", "Pending", "", 65000.0, LocalDate.of(2026, 3, 18)));
        budgets.add(new ProjectBudget("BUD-204", "PRJ-04", "Project Manager", "Approved", "Approved for Q2", 95000.0, LocalDate.of(2026, 3, 20)));
        FileReadWrite.saveData(budgets, "ProjectBudgets.bin");

        System.out.println("Seeded PerformanceIndicators.bin and ProjectBudgets.bin");
    }
}
