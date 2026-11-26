package main.ngooperation;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class Employee extends User implements Serializable {
    protected final int employeeId;
    protected String designation;
    protected final LocalDate joiningDate;
    protected Float salary;
    protected String shift;

    public Employee(int userId, String password, String userName, String phone, String role, String mail, int employeeId, LocalDate joiningDate, String designation, Float salary, String shift) {
        super(userId, password, userName, phone, role, mail);
        this.employeeId = employeeId;
        this.joiningDate = joiningDate;
        this.designation = designation;
        this.salary = salary;
        this.shift = shift;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getDesignation() {
        return designation;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public Float getSalary() {
        return salary;
    }

    public String getShift() {
        return shift;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    @Override
    public String toString() {
        return "Employee{" +
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
}
