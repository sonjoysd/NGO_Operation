package main.ngooperation.mamun_2430986.Model.NonUser;

import java.io.Serializable;

public class OrganizationPolicy implements Serializable {

    private String policyId, title, area, draftedBy, status, comment;

    public OrganizationPolicy(String policyId, String title, String area, String draftedBy, String status, String comment) {
        this.policyId = policyId;
        this.title = title;
        this.area = area;
        this.draftedBy = draftedBy;
        this.status = status;
        this.comment = comment;
    }

    public String getPolicyId() {
        return policyId;
    }

    public String getTitle() {
        return title;
    }

    public String getArea() {
        return area;
    }

    public String getDraftedBy() {
        return draftedBy;
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
