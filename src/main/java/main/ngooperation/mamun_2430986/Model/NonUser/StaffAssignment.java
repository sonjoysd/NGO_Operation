package main.ngooperation.mamun_2430986.Model.NonUser;

import java.io.Serializable;
import java.time.LocalDate;

public class StaffAssignment implements Serializable {

    private String assignmentId, projectId, staffName, roleTask, location, status;
    private LocalDate assignedDate;

    public StaffAssignment(String assignmentId, String projectId, String staffName, String roleTask, String location, String status, LocalDate assignedDate) {
        this.assignmentId = assignmentId;
        this.projectId = projectId;
        this.staffName = staffName;
        this.roleTask = roleTask;
        this.location = location;
        this.status = status;
        this.assignedDate = assignedDate;
    }

    public String getAssignmentId() {
        return assignmentId;
    }

    public String getProjectId() {
        return projectId;
    }

    public String getStaffName() {
        return staffName;
    }

    public String getRoleTask() {
        return roleTask;
    }

    public String getLocation() {
        return location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getAssignedDate() {
        return assignedDate;
    }
}
