package main.ngooperation.mamun_2430986.Model.User;

import javafx.collections.ObservableList;
import main.ngooperation.Employee;
import main.ngooperation.mamun_2430986.Model.NonUser.ProjectSchedule;
import main.ngooperation.mamun_2430986.Model.NonUser.ReviewNote;
import main.ngooperation.mamun_2430986.Model.NonUser.StaffAssignment;
import main.ngooperation.mamun_2430986.Utility.FileReadWrite;
import main.ngooperation.sonjoy_2411704.model_class.NGOApplication;

import java.io.Serializable;
import java.time.LocalDate;

public class ProjectCoordinator extends Employee implements Serializable {

    private static final String SCHEDULES_FILE = "ProjectSchedules.bin";
    private static final String ASSIGNMENTS_FILE = "StaffAssignments.bin";
    private static final String NGO_APPLICATIONS_FILE = "NGOApplication.bin";
    private static final String REVIEW_NOTES_FILE = "ReviewNotes.bin";

    public ProjectCoordinator(int userId, String password, String userName, String phone, String role, String mail, int employeeId, LocalDate joiningDate, String designation, Float salary, String shift) {
        super(userId, password, userName, phone, role, mail, employeeId, joiningDate, designation, salary, shift);
    }

    public static ObservableList<ProjectSchedule> loadAllSchedules() {
        return FileReadWrite.loadData(ProjectSchedule.class, SCHEDULES_FILE);
    }

    public static boolean addSchedule(ProjectSchedule schedule) {
        ObservableList<ProjectSchedule> all = FileReadWrite.loadData(ProjectSchedule.class, SCHEDULES_FILE);
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

    public static ObservableList<StaffAssignment> loadAllAssignments() {
        return FileReadWrite.loadData(StaffAssignment.class, ASSIGNMENTS_FILE);
    }

    public static boolean addAssignment(StaffAssignment assignment) {
        ObservableList<StaffAssignment> all = FileReadWrite.loadData(StaffAssignment.class, ASSIGNMENTS_FILE);
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

    public static ObservableList<NGOApplication> loadAllBeneficiaryRequests() {
        return FileReadWrite.loadData(NGOApplication.class, NGO_APPLICATIONS_FILE);
    }

    public static boolean routeServiceRequest(Integer applicationId, String team, String noteText) {
        ObservableList<NGOApplication> all = FileReadWrite.loadData(NGOApplication.class, NGO_APPLICATIONS_FILE);
        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).getApplicationID().equals(applicationId)) {
                all.get(i).setStatus("Routed to " + team);
                FileReadWrite.saveData(all, NGO_APPLICATIONS_FILE);
                String noteId = "RN-" + System.currentTimeMillis();
                ReviewNote note = new ReviewNote(noteId, "APP-" + applicationId, "Project Coordinator", noteText, LocalDate.now());
                FileReadWrite.append(note, REVIEW_NOTES_FILE);
                return true;
            }
        }
        return false;
    }
}
