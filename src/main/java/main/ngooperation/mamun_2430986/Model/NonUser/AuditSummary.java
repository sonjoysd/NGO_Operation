package main.ngooperation.mamun_2430986.Model.NonUser;

import java.io.Serializable;

public class AuditSummary implements Serializable {

    private String auditId, period, area, finding, complianceStatus;

    public AuditSummary(String auditId, String period, String area, String finding, String complianceStatus) {
        this.auditId = auditId;
        this.period = period;
        this.area = area;
        this.finding = finding;
        this.complianceStatus = complianceStatus;
    }

    public String getAuditId() {
        return auditId;
    }

    public String getPeriod() {
        return period;
    }

    public String getArea() {
        return area;
    }

    public String getFinding() {
        return finding;
    }

    public String getComplianceStatus() {
        return complianceStatus;
    }
}
