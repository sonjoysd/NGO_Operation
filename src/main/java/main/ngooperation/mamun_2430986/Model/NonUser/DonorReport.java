package main.ngooperation.mamun_2430986.Model.NonUser;

import java.io.Serializable;

public class DonorReport implements Serializable {
    private static final long serialVersionUID = 1L;

    private String reportId, donorName, period, summary, status, comment;

    public DonorReport(String reportId, String donorName, String period, String summary, String status, String comment) {
        this.reportId = reportId;
        this.donorName = donorName;
        this.period = period;
        this.summary = summary;
        this.status = status;
        this.comment = comment;
    }

    public String getReportId() {
        return reportId;
    }

    public String getDonorName() {
        return donorName;
    }

    public String getPeriod() {
        return period;
    }

    public String getSummary() {
        return summary;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
