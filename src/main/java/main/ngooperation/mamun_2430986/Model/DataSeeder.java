package main.ngooperation.mamun_2430986.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import main.ngooperation.mamun_2430986.Model.NonUser.AuditSummary;
import main.ngooperation.mamun_2430986.Model.NonUser.DonorReport;
import main.ngooperation.mamun_2430986.Model.NonUser.GrantApplication;
import main.ngooperation.mamun_2430986.Model.NonUser.OrganizationPolicy;
import main.ngooperation.mamun_2430986.Model.NonUser.PerformanceIndicator;
import main.ngooperation.mamun_2430986.Model.NonUser.ProjectBudget;
import main.ngooperation.mamun_2430986.Model.NonUser.RiskAlert;
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

        ObservableList<GrantApplication> grants = FXCollections.observableArrayList();
        grants.add(new GrantApplication("GR-301", "UNICEF", "Education", "Pending", "", 150000.0, LocalDate.of(2026, 3, 12)));
        grants.add(new GrantApplication("GR-302", "WHO", "Health", "Pending", "", 220000.0, LocalDate.of(2026, 3, 15)));
        grants.add(new GrantApplication("GR-303", "UNDP", "Housing", "Pending", "", 180000.0, LocalDate.of(2026, 3, 19)));
        grants.add(new GrantApplication("GR-304", "BRAC Foundation", "Empowerment", "Approved", "Authorized", 90000.0, LocalDate.of(2026, 3, 22)));
        FileReadWrite.saveData(grants, "GrantApplications.bin");

        ObservableList<DonorReport> donorReports = FXCollections.observableArrayList();
        donorReports.add(new DonorReport("DR-401", "UNICEF", "2026-Q1", "480 students supported in Q1", "Pending", ""));
        donorReports.add(new DonorReport("DR-402", "WHO", "2026-Q1", "1250 clinic visits completed", "Pending", ""));
        donorReports.add(new DonorReport("DR-403", "UNDP", "2026-Q2", "68 shelters built out of 80", "Pending", ""));
        donorReports.add(new DonorReport("DR-404", "BRAC Foundation", "2026-Q2", "310 women trained in skills", "Approved", "Verified"));
        FileReadWrite.saveData(donorReports, "DonorReports.bin");

        ObservableList<AuditSummary> audits = FXCollections.observableArrayList();
        audits.add(new AuditSummary("AUD-501", "2026-Q1", "Finance", "All expense vouchers verified", "Compliant"));
        audits.add(new AuditSummary("AUD-502", "2026-Q1", "Procurement", "Two quotes missing on PR-14", "Action Needed"));
        audits.add(new AuditSummary("AUD-503", "2026-Q2", "HR", "Staff contracts up to date", "Compliant"));
        audits.add(new AuditSummary("AUD-504", "2026-Q2", "Field Operations", "Delayed inventory reconciliation", "Under Review"));
        FileReadWrite.saveData(audits, "AuditSummaries.bin");

        ObservableList<OrganizationPolicy> policies = FXCollections.observableArrayList();
        policies.add(new OrganizationPolicy("POL-601", "Data Privacy Policy", "IT & Compliance", "HR Manager", "Pending", ""));
        policies.add(new OrganizationPolicy("POL-602", "Field Safety Guidelines", "Field Operations", "Project Manager", "Pending", ""));
        policies.add(new OrganizationPolicy("POL-603", "Procurement Threshold Rule", "Finance", "Account Officer", "Pending", ""));
        policies.add(new OrganizationPolicy("POL-604", "Leave Carryover Policy", "Human Resources", "HR Manager", "Approved", "Effective Q2"));
        FileReadWrite.saveData(policies, "OrganizationPolicies.bin");

        ObservableList<RiskAlert> alerts = FXCollections.observableArrayList();
        alerts.add(new RiskAlert("ALT-701", "PRJ-01", "Supply chain delay in northern region", "High", "Project Manager", "Open", LocalDate.of(2026, 3, 21)));
        alerts.add(new RiskAlert("ALT-702", "PRJ-02", "Donor disbursement pending signature", "Medium", "Account Officer", "Monitoring", LocalDate.of(2026, 3, 23)));
        alerts.add(new RiskAlert("ALT-703", "PRJ-03", "Monsoon flooding near shelter site", "Critical", "Project Coordinator", "Escalated", LocalDate.of(2026, 3, 25)));
        alerts.add(new RiskAlert("ALT-704", "PRJ-04", "Minor training room schedule overlap", "Low", "HR Manager", "Resolved", LocalDate.of(2026, 3, 26)));
        FileReadWrite.saveData(alerts, "RiskAlerts.bin");

        System.out.println("Seeded PerformanceIndicators.bin, ProjectBudgets.bin, GrantApplications.bin, DonorReports.bin, AuditSummaries.bin, OrganizationPolicies.bin, and RiskAlerts.bin");
    }
}
