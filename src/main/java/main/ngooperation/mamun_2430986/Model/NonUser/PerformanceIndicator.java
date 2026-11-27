package main.ngooperation.mamun_2430986.Model.NonUser;

import java.io.Serializable;

public class PerformanceIndicator implements Serializable {
    private static final long serialVersionUID = 1L;

    private String indicatorId, period, programArea, indicatorName;
    private double target, actual;

    public PerformanceIndicator(String indicatorId, String period, String programArea, String indicatorName, double target, double actual) {
        this.indicatorId = indicatorId;
        this.period = period;
        this.programArea = programArea;
        this.indicatorName = indicatorName;
        this.target = target;
        this.actual = actual;
    }

    public String getIndicatorId() {
        return indicatorId;
    }

    public String getPeriod() {
        return period;
    }

    public String getProgramArea() {
        return programArea;
    }

    public String getIndicatorName() {
        return indicatorName;
    }

    public double getTarget() {
        return target;
    }

    public double getActual() {
        return actual;
    }
}
