package main.ngooperation.mamun_2430986.Model.User;

import javafx.collections.ObservableList;
import main.ngooperation.Employee;
import main.ngooperation.mamun_2430986.Model.NonUser.ProjectSchedule;
import main.ngooperation.mamun_2430986.Model.NonUser.StaffAssignment;
import main.ngooperation.mamun_2430986.Utility.FileReadWrite;

import java.io.Serializable;
import java.time.LocalDate;

public class ProjectCoordinator extends Employee implements Serializable {

    private static final String SCHEDULES_FILE = "ProjectSchedules.bin";
    private static final String ASSIGNMENTS_FILE = "StaffAssignments.bin";

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
}
