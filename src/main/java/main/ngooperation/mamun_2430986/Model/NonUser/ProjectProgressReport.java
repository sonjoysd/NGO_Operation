package main.ngooperation.mamun_2430986.Model.NonUser;

import java.io.Serializable;
import java.time.LocalDate;

public class ProjectProgressReport implements Serializable {

    private String reportId, projectId, period, summary;
    private LocalDate generatedDate;

    public ProjectProgressReport(String reportId, String projectId, String period, String summary, LocalDate generatedDate) {
        this.reportId = reportId;
        this.projectId = projectId;
        this.period = period;
        this.summary = summary;
        this.generatedDate = generatedDate;
    }

    public String getReportId() {
        return reportId;
    }

    public String getProjectId() {
        return projectId;
    }

    public String getPeriod() {
        return period;
    }

    public String getSummary() {
        return summary;
    }

    public LocalDate getGeneratedDate() {
        return generatedDate;
    }
}
