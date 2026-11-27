package main.ngooperation.mamun_2430986.Model.NonUser;

import java.io.Serializable;
import java.time.LocalDate;

public class ProjectMilestone implements Serializable {

    private String milestoneId, projectId, title, status;
    private LocalDate targetDate;
    private int completionPercent;

    public ProjectMilestone(String milestoneId, String projectId, String title, String status, LocalDate targetDate, int completionPercent) {
        this.milestoneId = milestoneId;
        this.projectId = projectId;
        this.title = title;
        this.status = status;
        this.targetDate = targetDate;
        this.completionPercent = completionPercent;
    }

    public String getMilestoneId() {
        return milestoneId;
    }

    public String getProjectId() {
        return projectId;
    }

    public String getTitle() {
        return title;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public int getCompletionPercent() {
        return completionPercent;
    }
}
