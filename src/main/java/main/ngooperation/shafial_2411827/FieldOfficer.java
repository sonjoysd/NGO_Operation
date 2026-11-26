package main.ngooperation.shafial_2411827;

import main.ngooperation.Employee;

import java.io.Serializable;
import java.time.LocalDate;

public class FieldOfficer extends Employee implements Serializable {

    public FieldOfficer(int userId, String password, String userName, String phone, String role, String mail, int employeeId, LocalDate joiningDate, String designation, Float salary, String shift) {
        super(userId, password, userName, phone, role, mail, employeeId, joiningDate, designation, salary, shift);
    }

    @Override
    public String toString() {
        return "fieldOfficer{" +
                "employeeId=" + employeeId +
                ", designation='" + designation + '\'' +
                ", joiningDate=" + joiningDate +
                ", salary=" + salary +
                ", shift='" + shift + '\'' +
                ", userId=" + userId +
                ", UserName='" + UserName + '\'' +
                ", phone='" + phone + '\'' +
                ", role='" + role + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }

    public boolean registerNewBeneficiary(String fullName, String contactNumber, String community, String address){
        if(fullName == null || contactNumber == null || community == null || address == null){
            return false;
        }

        RegisterNewBeneficiary newReg = new RegisterNewBeneficiary(1, fullName, contactNumber, community, address, "Pending");
        return true;

    }
}
