package main.ngooperation;

import java.io.Serializable;

public abstract class User implements Serializable {
    protected final int userId;
    private String password;
    protected String UserName;
    protected String phone;
    protected String role;
    protected String mail;

    public User(int userId, String password, String userName, String phone, String role, String mail) {
        this.userId = userId;
        this.password = password;
        UserName = userName;
        this.phone = phone;
        this.role = role;
        this.mail = mail;
    }

    public int getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return UserName;
    }

    public String getPhone() {
        return phone;
    }

    public String getRole() {
        return role;
    }

    public String getMail() {
        return mail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", UserName='" + UserName + '\'' +
                ", phone='" + phone + '\'' +
                ", role='" + role + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}
