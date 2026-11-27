package main.ngooperation.mamun_2430986.Model.NonUser;

import java.io.Serializable;
import java.time.LocalDate;

public class ResourceRequest implements Serializable {

    private String requestId, projectId, item, requestedBy, status;
    private int quantity;
    private LocalDate neededDate;

    public ResourceRequest(String requestId, String projectId, String item, String requestedBy, String status, int quantity, LocalDate neededDate) {
        this.requestId = requestId;
        this.projectId = projectId;
        this.item = item;
        this.requestedBy = requestedBy;
        this.status = status;
        this.quantity = quantity;
        this.neededDate = neededDate;
    }

    public String getRequestId() {
        return requestId;
    }

    public String getProjectId() {
        return projectId;
    }

    public String getItem() {
        return item;
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

    public int getQuantity() {
        return quantity;
    }

    public LocalDate getNeededDate() {
        return neededDate;
    }
}
