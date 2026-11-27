package main.ngooperation.mamun_2430986.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import main.ngooperation.mamun_2430986.Model.NonUser.AuditSummary;
import main.ngooperation.mamun_2430986.Model.NonUser.CoordinationMeeting;
import main.ngooperation.mamun_2430986.Model.NonUser.DonorReport;
import main.ngooperation.mamun_2430986.Model.NonUser.FundingPosition;
import main.ngooperation.mamun_2430986.Model.NonUser.GrantApplication;
import main.ngooperation.mamun_2430986.Model.NonUser.OperationalIssue;
import main.ngooperation.mamun_2430986.Model.NonUser.OrganizationPolicy;
import main.ngooperation.mamun_2430986.Model.NonUser.PerformanceIndicator;
import main.ngooperation.mamun_2430986.Model.NonUser.ProjectBudget;
import main.ngooperation.mamun_2430986.Model.NonUser.ProjectMilestone;
import main.ngooperation.mamun_2430986.Model.NonUser.ProjectProgressReport;
import main.ngooperation.mamun_2430986.Model.NonUser.ProjectSchedule;
import main.ngooperation.mamun_2430986.Model.NonUser.ResourceRequest;
import main.ngooperation.mamun_2430986.Model.NonUser.RiskAlert;
import main.ngooperation.mamun_2430986.Model.NonUser.StaffAssignment;
import main.ngooperation.mamun_2430986.Utility.FileReadWrite;
import main.ngooperation.sonjoy_2411704.model_class.NGOApplication;

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

        ObservableList<FundingPosition> funding = FXCollections.observableArrayList();
        funding.add(new FundingPosition("FND-801", "2026-Q1", "International Grants", "Strong", 300000.0, 290000.0));
        funding.add(new FundingPosition("FND-802", "2026-Q1", "Corporate Sponsors", "Moderate", 150000.0, 110000.0));
        funding.add(new FundingPosition("FND-803", "2026-Q2", "Individual Donors", "At Risk", 120000.0, 75000.0));
        funding.add(new FundingPosition("FND-804", "2026-Q2", "Government Co-Fund", "Stable", 200000.0, 185000.0));
        FileReadWrite.saveData(funding, "FundingPositions.bin");

        ObservableList<ProjectSchedule> schedules = FXCollections.observableArrayList();
        schedules.add(new ProjectSchedule("SCH-101", "PRJ-01", "School Kit Distribution", "Sylhet", "Team Alpha", "Planned", LocalDate.of(2026, 4, 5)));
        schedules.add(new ProjectSchedule("SCH-102", "PRJ-02", "Mobile Health Camp", "Khulna", "Team Beta", "In Progress", LocalDate.of(2026, 4, 8)));
        schedules.add(new ProjectSchedule("SCH-103", "PRJ-03", "Shelter Site Survey", "Rajshahi", "Team Gamma", "Planned", LocalDate.of(2026, 4, 12)));
        FileReadWrite.saveData(schedules, "ProjectSchedules.bin");

        ObservableList<StaffAssignment> assignments = FXCollections.observableArrayList();
        assignments.add(new StaffAssignment("ASG-201", "PRJ-01", "Kamal Hasan", "Field Verification", "Sylhet", "Assigned", LocalDate.of(2026, 4, 5)));
        assignments.add(new StaffAssignment("ASG-202", "PRJ-02", "Nusrat Jahan", "Clinic Coordination", "Khulna", "Active", LocalDate.of(2026, 4, 8)));
        assignments.add(new StaffAssignment("ASG-203", "PRJ-03", "Tariqul Islam", "Resource Handover", "Rajshahi", "Assigned", LocalDate.of(2026, 4, 12)));
        FileReadWrite.saveData(assignments, "StaffAssignments.bin");

        ObservableList<NGOApplication> applications = FXCollections.observableArrayList();
        applications.add(new NGOApplication(1001, 1711000001, 5001, "Rahim Uddin", "Education Support Program", LocalDate.of(2026, 3, 20), "Pending"));
        applications.add(new NGOApplication(1002, 1711000002, 5002, "Fatema Begum", "Health Support Program", LocalDate.of(2026, 3, 22), "Pending"));
        applications.add(new NGOApplication(1003, 1711000003, 5003, "Karim Mia", "Housing Support Program", LocalDate.of(2026, 3, 25), "Pending"));
        applications.add(new NGOApplication(1004, 1711000004, 5004, "Salma Akter", "Woman Empowerment Program", LocalDate.of(2026, 3, 27), "Routed to Empowerment Team"));
        FileReadWrite.saveData(applications, "NGOApplication.bin");

        ObservableList<ProjectMilestone> milestones = FXCollections.observableArrayList();
        milestones.add(new ProjectMilestone("MS-401", "PRJ-01", "School Supplies Delivered", "Completed", LocalDate.of(2026, 3, 25), 100));
        milestones.add(new ProjectMilestone("MS-402", "PRJ-02", "Health Clinic Setup", "On Track", LocalDate.of(2026, 4, 15), 70));
        milestones.add(new ProjectMilestone("MS-403", "PRJ-03", "Shelter Foundation Work", "Delayed", LocalDate.of(2026, 4, 20), 40));
        milestones.add(new ProjectMilestone("MS-404", "PRJ-04", "Women Training Cohort 1", "On Track", LocalDate.of(2026, 4, 30), 60));
        FileReadWrite.saveData(milestones, "ProjectMilestones.bin");

        ObservableList<ResourceRequest> resourceRequests = FXCollections.observableArrayList();
        resourceRequests.add(new ResourceRequest("RES-501", "PRJ-01", "School Notebooks", "Kamal Hasan", "Requested", 500, LocalDate.of(2026, 4, 10)));
        resourceRequests.add(new ResourceRequest("RES-502", "PRJ-02", "Medical First-Aid Kits", "Nusrat Jahan", "Forwarded to PM", 120, LocalDate.of(2026, 4, 14)));
        resourceRequests.add(new ResourceRequest("RES-503", "PRJ-03", "Tarpaulin Sheets", "Tariqul Islam", "Approved", 200, LocalDate.of(2026, 4, 18)));
        FileReadWrite.saveData(resourceRequests, "ResourceRequests.bin");

        ObservableList<CoordinationMeeting> meetings = FXCollections.observableArrayList();
        meetings.add(new CoordinationMeeting("MTG-601", "PRJ-01", "Q2 Kickoff Alignment", "Room A", "Team Alpha", "Scheduled", LocalDate.of(2026, 4, 3)));
        meetings.add(new CoordinationMeeting("MTG-602", "PRJ-02", "Field Clinic Logistics", "Room B", "Team Beta", "Completed", LocalDate.of(2026, 4, 6)));
        meetings.add(new CoordinationMeeting("MTG-603", "PRJ-03", "Shelter Material Review", "Sylhet Hub", "Team Gamma", "Scheduled", LocalDate.of(2026, 4, 11)));
        FileReadWrite.saveData(meetings, "CoordinationMeetings.bin");

        ObservableList<ProjectProgressReport> progressReports = FXCollections.observableArrayList();
        progressReports.add(new ProjectProgressReport("PPR-701", "PRJ-01", "2026-Q1", "Activities: 1, Milestones Completed: 1/1, Resource Requests: 1", LocalDate.of(2026, 3, 28)));
        progressReports.add(new ProjectProgressReport("PPR-702", "PRJ-02", "2026-Q1", "Activities: 1, Milestones Completed: 0/1, Resource Requests: 1", LocalDate.of(2026, 3, 29)));
        FileReadWrite.saveData(progressReports, "ProjectProgressReports.bin");

        ObservableList<OperationalIssue> issues = FXCollections.observableArrayList();
        issues.add(new OperationalIssue("ISS-801", "PRJ-01", "Vendor delayed school book delivery by 10 days", "Medium", "Open", LocalDate.of(2026, 3, 24)));
        issues.add(new OperationalIssue("ISS-802", "PRJ-03", "Monsoon flooded access road to shelter site", "High", "Open", LocalDate.of(2026, 3, 26)));
        issues.add(new OperationalIssue("ISS-803", "PRJ-02", "Shortage of portable medical kits", "High", "Open", LocalDate.of(2026, 3, 27)));
        FileReadWrite.saveData(issues, "OperationalIssues.bin");

        System.out.println("Seeded all Executive Director and Project Coordinator .bin files.");
    }
}
