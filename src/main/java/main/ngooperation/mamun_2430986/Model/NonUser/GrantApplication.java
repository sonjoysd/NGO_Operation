package main.ngooperation.mamun_2430986.Model.NonUser;

import java.io.Serializable;
import java.time.LocalDate;

public class GrantApplication implements Serializable {

    private String grantId, donorAgency, programArea, status, comment;
    private double amount;
    private LocalDate date;

    public GrantApplication(String grantId, String donorAgency, String programArea, String status, String comment, double amount, LocalDate date) {
        this.grantId = grantId;
        this.donorAgency = donorAgency;
        this.programArea = programArea;
        this.status = status;
        this.comment = comment;
        this.amount = amount;
        this.date = date;
    }

    public String getGrantId() {
        return grantId;
    }

    public String getDonorAgency() {
        return donorAgency;
    }

    public String getProgramArea() {
        return programArea;
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

    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }
}
