package main.ngooperation.shafial_2411827;

public class RegisterNewBeneficiary {
    private final int registerId;
    private String fullName;
    private String contact;
    private String community;
    private String address;
    private String registerStatus;

    public RegisterNewBeneficiary(int registerId, String fullName, String contact, String community, String address, String registerStatus) {
        this.registerId = registerId;
        this.fullName = fullName;
        this.contact = contact;
        this.community = community;
        this.address = address;
        this.registerStatus = registerStatus;
    }

    public int getRegisterId() {
        return registerId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRegisterStatus() {
        return registerStatus;
    }

    public void setRegisterStatus(String registerStatus) {
        this.registerStatus = registerStatus;
    }

    @Override
    public String toString() {
        return "registerNewBeneficiary{" +
                "registerId=" + registerId +
                ", fullName='" + fullName + '\'' +
                ", contact='" + contact + '\'' +
                ", community='" + community + '\'' +
                ", address='" + address + '\'' +
                ", registerStatus='" + registerStatus + '\'' +
                '}';
    }
}
