package main.ngooperation.mamun_2430986.Model.User;

import main.ngooperation.Employee;
import main.ngooperation.mamun_2430986.Model.NonUser.AuditSummary;
import main.ngooperation.mamun_2430986.Model.NonUser.DonorReport;
import main.ngooperation.mamun_2430986.Model.NonUser.FundingPosition;
import main.ngooperation.mamun_2430986.Model.NonUser.GrantApplication;
import main.ngooperation.mamun_2430986.Model.NonUser.OrganizationPolicy;
import main.ngooperation.mamun_2430986.Model.NonUser.PerformanceIndicator;
import main.ngooperation.mamun_2430986.Model.NonUser.ProjectBudget;
import main.ngooperation.mamun_2430986.Model.NonUser.ReviewNote;
import main.ngooperation.mamun_2430986.Model.NonUser.RiskAlert;
import main.ngooperation.mamun_2430986.Utility.FileReadWrite;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class ExecutiveDirector extends Employee implements Serializable {

    private static final String KPI_FILE = "PerformanceIndicators.bin";
    private static final String REVIEW_NOTES_FILE = "ReviewNotes.bin";
    private static final String BUDGETS_FILE = "ProjectBudgets.bin";
    private static final String GRANTS_FILE = "GrantApplications.bin";
    private static final String DONOR_REPORTS_FILE = "DonorReports.bin";
    private static final String AUDIT_SUMMARIES_FILE = "AuditSummaries.bin";
    private static final String POLICIES_FILE = "OrganizationPolicies.bin";
    private static final String RISK_ALERTS_FILE = "RiskAlerts.bin";
    private static final String FUNDING_POSITIONS_FILE = "FundingPositions.bin";

    public ExecutiveDirector(int userId, String password, String userName, String phone, String role, String mail, int employeeId, LocalDate joiningDate, String designation, Float salary, String shift) {
        super(userId, password, userName, phone, role, mail, employeeId, joiningDate, designation, salary, shift);
    }

    public static ArrayList<PerformanceIndicator> loadAllKPIs() {
        ArrayList<PerformanceIndicator> list = new ArrayList<PerformanceIndicator>();
        for (Object obj : FileReadWrite.loadData(KPI_FILE)) {
            list.add((PerformanceIndicator) obj);
        }
        return list;
    }

    public static void saveReviewNote(String targetId, String reviewerRole, String noteText) {
        String noteId = "RN-" + (101 + FileReadWrite.loadData(REVIEW_NOTES_FILE).size());
        ReviewNote note = new ReviewNote(noteId, targetId, reviewerRole, noteText, LocalDate.now());
        FileReadWrite.append(note, REVIEW_NOTES_FILE);
    }

    public static ArrayList<ProjectBudget> loadAllBudgets() {
        ArrayList<ProjectBudget> list = new ArrayList<ProjectBudget>();
        for (Object obj : FileReadWrite.loadData(BUDGETS_FILE)) {
            list.add((ProjectBudget) obj);
        }
        return list;
    }

    public static boolean applyBudgetAction(String budgetId, String action, String comment) {
        ArrayList<ProjectBudget> all = loadAllBudgets();
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

                ArrayList<Object> raw = new ArrayList<Object>();
                for (ProjectBudget b : all) {
                    raw.add(b);
                }
                FileReadWrite.saveData(raw, BUDGETS_FILE);
                return true;
            }
        }
        return false;
    }

    public static ArrayList<GrantApplication> loadAllGrants() {
        ArrayList<GrantApplication> list = new ArrayList<GrantApplication>();
        for (Object obj : FileReadWrite.loadData(GRANTS_FILE)) {
            list.add((GrantApplication) obj);
        }
        return list;
    }

    public static boolean applyGrantAction(String grantId, String action, String comment) {
        ArrayList<GrantApplication> all = loadAllGrants();
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

                ArrayList<Object> raw = new ArrayList<Object>();
                for (GrantApplication g : all) {
                    raw.add(g);
                }
                FileReadWrite.saveData(raw, GRANTS_FILE);
                return true;
            }
        }
        return false;
    }

    public static ArrayList<DonorReport> loadAllDonorReports() {
        ArrayList<DonorReport> list = new ArrayList<DonorReport>();
        for (Object obj : FileReadWrite.loadData(DONOR_REPORTS_FILE)) {
            list.add((DonorReport) obj);
        }
        return list;
    }

    public static boolean applyDonorReportAction(String reportId, String action, String comment) {
        ArrayList<DonorReport> all = loadAllDonorReports();
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

                ArrayList<Object> raw = new ArrayList<Object>();
                for (DonorReport r : all) {
                    raw.add(r);
                }
                FileReadWrite.saveData(raw, DONOR_REPORTS_FILE);
                return true;
            }
        }
        return false;
    }

    public static ArrayList<AuditSummary> loadAllAuditSummaries() {
        ArrayList<AuditSummary> list = new ArrayList<AuditSummary>();
        for (Object obj : FileReadWrite.loadData(AUDIT_SUMMARIES_FILE)) {
            list.add((AuditSummary) obj);
        }
        return list;
    }

    public static ArrayList<OrganizationPolicy> loadAllPolicies() {
        ArrayList<OrganizationPolicy> list = new ArrayList<OrganizationPolicy>();
        for (Object obj : FileReadWrite.loadData(POLICIES_FILE)) {
            list.add((OrganizationPolicy) obj);
        }
        return list;
    }

    public static boolean applyPolicyAction(String policyId, String action, String comment) {
        ArrayList<OrganizationPolicy> all = loadAllPolicies();
        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).getPolicyId().equals(policyId)) {
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

                ArrayList<Object> raw = new ArrayList<Object>();
                for (OrganizationPolicy p : all) {
                    raw.add(p);
                }
                FileReadWrite.saveData(raw, POLICIES_FILE);
                return true;
            }
        }
        return false;
    }

    public static ArrayList<RiskAlert> loadAllRiskAlerts() {
        ArrayList<RiskAlert> list = new ArrayList<RiskAlert>();
        for (Object obj : FileReadWrite.loadData(RISK_ALERTS_FILE)) {
            list.add((RiskAlert) obj);
        }
        return list;
    }

    public static ArrayList<FundingPosition> loadAllFundingPositions() {
        ArrayList<FundingPosition> list = new ArrayList<FundingPosition>();
        for (Object obj : FileReadWrite.loadData(FUNDING_POSITIONS_FILE)) {
            list.add((FundingPosition) obj);
        }
        return list;
    }
}
