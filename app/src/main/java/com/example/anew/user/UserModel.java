package com.example.anew.user;

public class UserModel {
    private String name;
    private String email;
    private String phoneNo;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserModel(){
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
        this.password = password;
    }

    public UserModel(String name, String email, String phoneNo, String password){
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
        this.password = password;
    }
}
