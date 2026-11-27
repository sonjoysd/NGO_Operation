package main.ngooperation.mamun_2430986.Model.NonUser;

import java.io.Serializable;

public class FundingPosition implements Serializable {

    private String recordId, period, source, status;
    private double targetAmount, securedAmount;

    public FundingPosition(String recordId, String period, String source, String status, double targetAmount, double securedAmount) {
        this.recordId = recordId;
        this.period = period;
        this.source = source;
        this.status = status;
        this.targetAmount = targetAmount;
        this.securedAmount = securedAmount;
    }

    public String getRecordId() {
        return recordId;
    }

    public String getPeriod() {
        return period;
    }

    public String getSource() {
        return source;
    }

    public String getStatus() {
        return status;
    }

    public double getTargetAmount() {
        return targetAmount;
    }

    public double getSecuredAmount() {
        return securedAmount;
    }
}
