package main.ngooperation.mamun_2430986.Model.User;

import javafx.collections.ObservableList;
import main.ngooperation.Employee;
import main.ngooperation.mamun_2430986.Model.NonUser.DonorReport;
import main.ngooperation.mamun_2430986.Model.NonUser.GrantApplication;
import main.ngooperation.mamun_2430986.Model.NonUser.PerformanceIndicator;
import main.ngooperation.mamun_2430986.Model.NonUser.ProjectBudget;
import main.ngooperation.mamun_2430986.Model.NonUser.ReviewNote;
import main.ngooperation.mamun_2430986.Utility.FileReadWrite;

import java.io.Serializable;
import java.time.LocalDate;

public class ExecutiveDirector extends Employee implements Serializable {

    private static final String KPI_FILE = "PerformanceIndicators.bin";
    private static final String REVIEW_NOTES_FILE = "ReviewNotes.bin";
    private static final String BUDGETS_FILE = "ProjectBudgets.bin";
    private static final String GRANTS_FILE = "GrantApplications.bin";
    private static final String DONOR_REPORTS_FILE = "DonorReports.bin";

    public ExecutiveDirector(int userId, String password, String userName, String phone, String role, String mail, int employeeId, LocalDate joiningDate, String designation, Float salary, String shift) {
        super(userId, password, userName, phone, role, mail, employeeId, joiningDate, designation, salary, shift);
    }

    public static ObservableList<PerformanceIndicator> loadAllKPIs() {
        return FileReadWrite.loadData(PerformanceIndicator.class, KPI_FILE);
    }

    public static void saveReviewNote(String targetId, String reviewerRole, String noteText) {
        String noteId = "RN-" + System.currentTimeMillis();
        ReviewNote note = new ReviewNote(noteId, targetId, reviewerRole, noteText, LocalDate.now());
        FileReadWrite.append(note, REVIEW_NOTES_FILE);
    }

    public static ObservableList<ProjectBudget> loadAllBudgets() {
        return FileReadWrite.loadData(ProjectBudget.class, BUDGETS_FILE);
    }

    public static boolean applyBudgetAction(String budgetId, String action, String comment) {
        ObservableList<ProjectBudget> all = FileReadWrite.loadData(ProjectBudget.class, BUDGETS_FILE);
        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).getBudgetId().equals(budgetId)) {
                String newStatus;
                if (action.equals("Approve")) {
                    newStatus = "Approved";
                } else if (action.equals("Reject")) {
                    newStatus = "Rejected";
                } else {
                    newStatus = "Returned for Correction";
                }
                all.get(i).setStatus(newStatus);
                all.get(i).setComment(comment);
                FileReadWrite.saveData(all, BUDGETS_FILE);
                return true;
            }
        }
        return false;
    }

    public static ObservableList<GrantApplication> loadAllGrants() {
        return FileReadWrite.loadData(GrantApplication.class, GRANTS_FILE);
    }

    public static boolean applyGrantAction(String grantId, String action, String comment) {
        ObservableList<GrantApplication> all = FileReadWrite.loadData(GrantApplication.class, GRANTS_FILE);
        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).getGrantId().equals(grantId)) {
                String newStatus;
                if (action.equals("Approve")) {
                    newStatus = "Approved";
                } else if (action.equals("Reject")) {
                    newStatus = "Rejected";
                } else {
                    newStatus = "Returned for Correction";
                }
                all.get(i).setStatus(newStatus);
                all.get(i).setComment(comment);
                FileReadWrite.saveData(all, GRANTS_FILE);
                return true;
            }
        }
        return false;
    }

    public static ObservableList<DonorReport> loadAllDonorReports() {
        return FileReadWrite.loadData(DonorReport.class, DONOR_REPORTS_FILE);
    }

    public static boolean applyDonorReportAction(String reportId, String action, String comment) {
        ObservableList<DonorReport> all = FileReadWrite.loadData(DonorReport.class, DONOR_REPORTS_FILE);
        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).getReportId().equals(reportId)) {
                String newStatus;
                if (action.equals("Approve")) {
                    newStatus = "Approved";
                } else if (action.equals("Reject")) {
                    newStatus = "Rejected";
                } else {
                    newStatus = "Returned for Correction";
                }
                all.get(i).setStatus(newStatus);
                all.get(i).setComment(comment);
                FileReadWrite.saveData(all, DONOR_REPORTS_FILE);
                return true;
            }
        }
        return false;
    }
}
