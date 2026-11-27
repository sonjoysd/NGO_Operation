package main.ngooperation.mamun_2430986.Model.NonUser;

import java.io.Serializable;
import java.time.LocalDate;

public class ProjectSchedule implements Serializable {

    private String scheduleId, projectId, activity, location, assignedTeam, status;
    private LocalDate plannedDate;

    public ProjectSchedule(String scheduleId, String projectId, String activity, String location, String assignedTeam, String status, LocalDate plannedDate) {
        this.scheduleId = scheduleId;
        this.projectId = projectId;
        this.activity = activity;
        this.location = location;
        this.assignedTeam = assignedTeam;
        this.status = status;
        this.plannedDate = plannedDate;
    }

    public String getScheduleId() {
        return scheduleId;
    }

    public String getProjectId() {
        return projectId;
    }

    public String getActivity() {
        return activity;
    }

    public String getLocation() {
        return location;
    }

    public String getAssignedTeam() {
        return assignedTeam;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getPlannedDate() {
        return plannedDate;
    }
}
