package main.ngooperation.shafial_2411827;

import java.io.Serializable;
import java.time.LocalDate;

public class FieldActivities implements Serializable {
    private String project, reportType, servicesArea, summarizedResult;
    private LocalDate startDate, endDate, preparedOn;

    public FieldActivities(String project, String reportType, String servicesArea, String summarizedResult, LocalDate startDate, LocalDate endDate, LocalDate preparedOn) {
        this.project = project;
        this.reportType = reportType;
        this.servicesArea = servicesArea;
        this.summarizedResult = summarizedResult;
        this.startDate = startDate;
        this.endDate = endDate;
        this.preparedOn = preparedOn;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public String getServicesArea() {
        return servicesArea;
    }

    public void setServicesArea(String servicesArea) {
        this.servicesArea = servicesArea;
    }

    public String getSummarizedResult() {
        return summarizedResult;
    }

    public void setSummarizedResult(String summarizedResult) {
        this.summarizedResult = summarizedResult;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDate getPreparedOn() {
        return preparedOn;
    }

    public void setPreparedOn(LocalDate preparedOn) {
        this.preparedOn = preparedOn;
    }

    @Override
    public String toString() {
        return "FieldActivities{" +
                "project='" + project + '\'' +
                ", reportType='" + reportType + '\'' +
                ", servicesArea='" + servicesArea + '\'' +
                ", summarizedResult='" + summarizedResult + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", preparedOn=" + preparedOn +
                '}';
    }
}
