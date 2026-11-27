package main.ngooperation.shafial_2411827;

import main.ngooperation.AppendableObjectOutputStream;
import main.ngooperation.Employee;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

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

        ObjectOutputStream oos = null;
        FileOutputStream fos = null;
        try {
            File file = new File("RegisterNewBeneficiary.bin");

            if (file.exists()){
                fos = new FileOutputStream(file, true);
                oos = new AppendableObjectOutputStream(fos);
            }
            else{
                fos = new FileOutputStream(file);
                oos = new ObjectOutputStream(fos);
            }

            oos.writeObject(newReg);
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public ArrayList<Object> readRegisterNewBeneficiary(){
        ArrayList<Object> readList = new ArrayList<>();

        ObjectInputStream ois = null;
        try{
            File readFile = new File("RegisterNewBeneficiary.bin");
            ois = new ObjectInputStream(new FileInputStream(readFile));
            while(true){
                Object tempObj = ois.readObject();
                readList.add(tempObj);
            }
        } catch (Exception e) {
            //
        }
    }
}
