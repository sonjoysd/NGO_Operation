package main.ngooperation.sonjoy_2411704.model_class;

import main.ngooperation.Employee;

import java.time.LocalDate;

public class AccountOfficer extends Employee {
    public AccountOfficer(int userId, String password, String userName, String phone, String role, String mail, int employeeId, LocalDate joiningDate, String designation, Float salary, String shift) {
        super(userId, password, userName, phone, role, mail, employeeId, joiningDate, designation, salary, shift);
    }

}
