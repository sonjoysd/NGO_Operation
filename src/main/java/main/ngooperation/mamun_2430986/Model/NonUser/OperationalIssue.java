package main.ngooperation.mamun_2430986.Model.NonUser;

import java.io.Serializable;
import java.time.LocalDate;

public class OperationalIssue implements Serializable {

    private String issueId, projectId, description, severity, status;
    private LocalDate reportedDate;

    public OperationalIssue(String issueId, String projectId, String description, String severity, String status, LocalDate reportedDate) {
        this.issueId = issueId;
        this.projectId = projectId;
        this.description = description;
        this.severity = severity;
        this.status = status;
        this.reportedDate = reportedDate;
    }

    public String getIssueId() {
        return issueId;
    }

    public String getProjectId() {
        return projectId;
    }

    public String getDescription() {
        return description;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getReportedDate() {
        return reportedDate;
    }
}
