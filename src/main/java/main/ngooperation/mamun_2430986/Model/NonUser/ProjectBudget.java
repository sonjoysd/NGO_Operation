package main.ngooperation.mamun_2430986.Model.NonUser;

import java.io.Serializable;
import java.time.LocalDate;

public class ProjectBudget implements Serializable {
    private static final long serialVersionUID = 1L;

    private String budgetId, projectId, requestedBy, status, comment;
    private double amount;
    private LocalDate date;

    public ProjectBudget(String budgetId, String projectId, String requestedBy, String status, String comment, double amount, LocalDate date) {
        this.budgetId = budgetId;
        this.projectId = projectId;
        this.requestedBy = requestedBy;
        this.status = status;
        this.comment = comment;
        this.amount = amount;
        this.date = date;
    }

    public String getBudgetId() {
        return budgetId;
    }

    public String getProjectId() {
        return projectId;
    }

    public String getRequestedBy() {
        return requestedBy;
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
