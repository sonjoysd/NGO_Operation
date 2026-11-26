package main.ngooperation.sonjoy_2411704.model_class;

import java.io.Serializable;
import java.time.LocalDate;

public class NGOApplication implements Serializable {
    private Integer beneficiaryId,phoneNum,applicationID;
    private String beneficiaryName,programType;
    private LocalDate requestDate;
    private  String status;

    public NGOApplication(Integer beneficiaryId, Integer phoneNum, Integer applicationID, String beneficiaryName, String programType, LocalDate requestDate, String status) {
        this.beneficiaryId = beneficiaryId;
        this.phoneNum = phoneNum;
        this.applicationID = applicationID;
        this.beneficiaryName = beneficiaryName;
        this.programType = programType;
        this.status = status;
        this.requestDate = requestDate;

    }

    public Integer getBeneficiaryId() {
        return beneficiaryId;
    }

    public Integer getPhoneNum() {
        return phoneNum;
    }

    public Integer getApplicationID() {
        return applicationID;
    }

    public String getBeneficiaryName() {
        return beneficiaryName;
    }

    public String getProgramType() {
        return programType;
    }

    public LocalDate getRequestDate() {
        return requestDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setRequestDate(LocalDate requestDate) {
        this.requestDate = requestDate;
    }

    public void setProgramType(String programType) {
        this.programType = programType;
    }

    public void setBeneficiaryName(String beneficiaryName) {
        this.beneficiaryName = beneficiaryName;
    }

    @Override
    public String toString() {
        return "NGOApplication{" +
                "beneficiaryId=" + beneficiaryId +
                ", phoneNum=" + phoneNum +
                ", applicationID=" + applicationID +
                ", beneficiaryName='" + beneficiaryName + '\'' +
                ", programType='" + programType + '\'' +
                ", requestDate=" + requestDate +
                ", status='" + status + '\'' +
                '}';
    }
}
