package main.ngooperation.mamun_2430986.Model.NonUser;

import java.io.Serializable;
import java.time.LocalDate;

public class RiskAlert implements Serializable {

    private String alertId, projectId, description, severity, raisedBy, status;
    private LocalDate date;

    public RiskAlert(String alertId, String projectId, String description, String severity, String raisedBy, String status, LocalDate date) {
        this.alertId = alertId;
        this.projectId = projectId;
        this.description = description;
        this.severity = severity;
        this.raisedBy = raisedBy;
        this.status = status;
        this.date = date;
    }

    public String getAlertId() {
        return alertId;
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

    public String getRaisedBy() {
        return raisedBy;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDate() {
        return date;
    }
}
