package main.ngooperation.mamun_2430986.Model.User;

import main.ngooperation.Employee;
import main.ngooperation.mamun_2430986.Model.NonUser.CoordinationMeeting;
import main.ngooperation.mamun_2430986.Model.NonUser.OperationalIssue;
import main.ngooperation.mamun_2430986.Model.NonUser.ProjectMilestone;
import main.ngooperation.mamun_2430986.Model.NonUser.ProjectProgressReport;
import main.ngooperation.mamun_2430986.Model.NonUser.ProjectSchedule;
import main.ngooperation.mamun_2430986.Model.NonUser.ResourceRequest;
import main.ngooperation.mamun_2430986.Model.NonUser.ReviewNote;
import main.ngooperation.mamun_2430986.Model.NonUser.RiskAlert;
import main.ngooperation.mamun_2430986.Model.NonUser.StaffAssignment;
import main.ngooperation.mamun_2430986.Utility.FileReadWrite;
import main.ngooperation.sonjoy_2411704.model_class.NGOApplication;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class ProjectCoordinator extends Employee implements Serializable {

    private static final String SCHEDULES_FILE = "ProjectSchedules.bin";
    private static final String ASSIGNMENTS_FILE = "StaffAssignments.bin";
    private static final String NGO_APPLICATIONS_FILE = "NGOApplication.bin";
    private static final String REVIEW_NOTES_FILE = "ReviewNotes.bin";
    private static final String MILESTONES_FILE = "ProjectMilestones.bin";
    private static final String RESOURCE_REQUESTS_FILE = "ResourceRequests.bin";
    private static final String MEETINGS_FILE = "CoordinationMeetings.bin";
    private static final String PROGRESS_REPORTS_FILE = "ProjectProgressReports.bin";
    private static final String ISSUES_FILE = "OperationalIssues.bin";
    private static final String RISK_ALERTS_FILE = "RiskAlerts.bin";

    public ProjectCoordinator(int userId, String password, String userName, String phone, String role, String mail, int employeeId, LocalDate joiningDate, String designation, Float salary, String shift) {
        super(userId, password, userName, phone, role, mail, employeeId, joiningDate, designation, salary, shift);
    }

    public static ArrayList<ProjectSchedule> loadAllSchedules() {
        ArrayList<ProjectSchedule> list = new ArrayList<ProjectSchedule>();
        for (Object obj : FileReadWrite.loadData(SCHEDULES_FILE)) {
            list.add((ProjectSchedule) obj);
        }
        return list;
    }

    public static boolean addSchedule(ProjectSchedule schedule) {
        ArrayList<ProjectSchedule> all = loadAllSchedules();
        for (ProjectSchedule s : all) {
            if (s.getScheduleId().equals(schedule.getScheduleId())) {
                return false;
            }
            if (s.getAssignedTeam().equals(schedule.getAssignedTeam()) && s.getPlannedDate().equals(schedule.getPlannedDate())) {
                return false;
            }
        }
        FileReadWrite.append(schedule, SCHEDULES_FILE);
        return true;
    }

    public static ArrayList<StaffAssignment> loadAllAssignments() {
        ArrayList<StaffAssignment> list = new ArrayList<StaffAssignment>();
        for (Object obj : FileReadWrite.loadData(ASSIGNMENTS_FILE)) {
            list.add((StaffAssignment) obj);
        }
        return list;
    }

    public static boolean addAssignment(StaffAssignment assignment) {
        ArrayList<StaffAssignment> all = loadAllAssignments();
        for (StaffAssignment a : all) {
            if (a.getAssignmentId().equals(assignment.getAssignmentId())) {
                return false;
            }
            if (a.getStaffName().equals(assignment.getStaffName()) && a.getAssignedDate().equals(assignment.getAssignedDate())) {
                return false;
            }
        }
        FileReadWrite.append(assignment, ASSIGNMENTS_FILE);
        return true;
    }

    public static ArrayList<NGOApplication> loadAllBeneficiaryRequests() {
        ArrayList<NGOApplication> list = new ArrayList<NGOApplication>();
        for (Object obj : FileReadWrite.loadData(NGO_APPLICATIONS_FILE)) {
            list.add((NGOApplication) obj);
        }
        return list;
    }

    public static boolean routeServiceRequest(Integer applicationId, String team, String noteText) {
        ArrayList<NGOApplication> all = loadAllBeneficiaryRequests();
        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).getApplicationID().equals(applicationId)) {
                all.get(i).setStatus("Routed to " + team);

                ArrayList<Object> raw = new ArrayList<Object>();
                for (NGOApplication app : all) {
                    raw.add(app);
                }
                FileReadWrite.saveData(raw, NGO_APPLICATIONS_FILE);

                String noteId = "RN-" + System.currentTimeMillis();
                ReviewNote note = new ReviewNote(noteId, "APP-" + applicationId, "Project Coordinator", noteText, LocalDate.now());
                FileReadWrite.append(note, REVIEW_NOTES_FILE);
                return true;
            }
        }
        return false;
    }

    public static ArrayList<ProjectMilestone> loadAllMilestones() {
        ArrayList<ProjectMilestone> list = new ArrayList<ProjectMilestone>();
        for (Object obj : FileReadWrite.loadData(MILESTONES_FILE)) {
            list.add((ProjectMilestone) obj);
        }
        return list;
    }

    public static void saveReviewNote(String targetId, String reviewerRole, String noteText) {
        String noteId = "RN-" + System.currentTimeMillis();
        ReviewNote note = new ReviewNote(noteId, targetId, reviewerRole, noteText, LocalDate.now());
        FileReadWrite.append(note, REVIEW_NOTES_FILE);
    }

    public static ArrayList<ResourceRequest> loadAllResourceRequests() {
        ArrayList<ResourceRequest> list = new ArrayList<ResourceRequest>();
        for (Object obj : FileReadWrite.loadData(RESOURCE_REQUESTS_FILE)) {
            list.add((ResourceRequest) obj);
        }
        return list;
    }

    public static boolean addResourceRequest(ResourceRequest request) {
        ArrayList<ResourceRequest> all = loadAllResourceRequests();
        for (ResourceRequest r : all) {
            if (r.getRequestId().equals(request.getRequestId())) {
                return false;
            }
            if (r.getProjectId().equals(request.getProjectId())
                    && r.getItem().equals(request.getItem())
                    && r.getNeededDate().equals(request.getNeededDate())) {
                return false;
            }
        }
        FileReadWrite.append(request, RESOURCE_REQUESTS_FILE);
        return true;
    }

    public static ArrayList<CoordinationMeeting> loadAllMeetings() {
        ArrayList<CoordinationMeeting> list = new ArrayList<CoordinationMeeting>();
        for (Object obj : FileReadWrite.loadData(MEETINGS_FILE)) {
            list.add((CoordinationMeeting) obj);
        }
        return list;
    }

    public static boolean addMeeting(CoordinationMeeting meeting) {
        ArrayList<CoordinationMeeting> all = loadAllMeetings();
        for (CoordinationMeeting m : all) {
            if (m.getMeetingId().equals(meeting.getMeetingId())) {
                return false;
            }
            if (m.getLocation().equals(meeting.getLocation()) && m.getMeetingDate().equals(meeting.getMeetingDate())) {
                return false;
            }
        }
        FileReadWrite.append(meeting, MEETINGS_FILE);
        return true;
    }

    public static ArrayList<ProjectProgressReport> loadAllProgressReports() {
        ArrayList<ProjectProgressReport> list = new ArrayList<ProjectProgressReport>();
        for (Object obj : FileReadWrite.loadData(PROGRESS_REPORTS_FILE)) {
            list.add((ProjectProgressReport) obj);
        }
        return list;
    }

    public static String compileAndSaveReport(String projectId, String period) {
        ArrayList<ProjectSchedule> schedules = loadAllSchedules();
        ArrayList<ProjectMilestone> milestones = loadAllMilestones();
        ArrayList<ResourceRequest> resources = loadAllResourceRequests();

        int scheduleCount = 0;
        for (ProjectSchedule s : schedules) {
            if (projectId.equals("All") || s.getProjectId().equals(projectId)) {
                scheduleCount++;
            }
        }

        int milestoneCount = 0;
        int completedMilestones = 0;
        for (ProjectMilestone m : milestones) {
            if (projectId.equals("All") || m.getProjectId().equals(projectId)) {
                milestoneCount++;
                if (m.getStatus().equals("Completed")) {
                    completedMilestones++;
                }
            }
        }

        int resourceCount = 0;
        for (ResourceRequest r : resources) {
            if (projectId.equals("All") || r.getProjectId().equals(projectId)) {
                resourceCount++;
            }
        }

        String summary = "Activities: " + scheduleCount + ", Milestones Completed: " + completedMilestones + "/" + milestoneCount + ", Resource Requests: " + resourceCount;
        String reportId = "PPR-" + System.currentTimeMillis();
        ProjectProgressReport report = new ProjectProgressReport(reportId, projectId, period, summary, LocalDate.now());
        FileReadWrite.append(report, PROGRESS_REPORTS_FILE);

        return "===== Project Progress Report =====" + "\n"
                + "Report ID: " + reportId + "\n"
                + "Project: " + projectId + "\n"
                + "Period: " + period + "\n"
                + "Generated: " + LocalDate.now() + "\n\n"
                + "Total Activity Schedules: " + scheduleCount + "\n"
                + "Milestones Completed: " + completedMilestones + " / " + milestoneCount + "\n"
                + "Resource Requests: " + resourceCount + "\n";
    }

    public static ArrayList<OperationalIssue> loadAllIssues() {
        ArrayList<OperationalIssue> list = new ArrayList<OperationalIssue>();
        for (Object obj : FileReadWrite.loadData(ISSUES_FILE)) {
            list.add((OperationalIssue) obj);
        }
        return list;
    }

    public static boolean escalateIssueToDirector(String issueId, String severity, String note) {
        ArrayList<OperationalIssue> all = loadAllIssues();
        for (int i = 0; i < all.size(); i++) {
            OperationalIssue issue = all.get(i);
            if (issue.getIssueId().equals(issueId)) {
                issue.setSeverity(severity);
                issue.setStatus("Escalated");

                ArrayList<Object> raw = new ArrayList<Object>();
                for (OperationalIssue item : all) {
                    raw.add(item);
                }
                FileReadWrite.saveData(raw, ISSUES_FILE);

                String alertId = "ALT-" + System.currentTimeMillis();
                RiskAlert alert = new RiskAlert(
                        alertId,
                        issue.getProjectId(),
                        issue.getDescription() + " (" + note + ")",
                        severity,
                        "Project Coordinator",
                        "Escalated",
                        LocalDate.now()
                );
                FileReadWrite.append(alert, RISK_ALERTS_FILE);
                saveReviewNote(issueId, "Project Coordinator", note);
                return true;
            }
        }
        return false;
    }
}
