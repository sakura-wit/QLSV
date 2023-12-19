package com.example.qlsinhvien.model;

public class User {

    private String tk_user;
    private String pass_user;
    private String name_user;
    private String phone_user;
    private String address_user;

    public User(String tk_user, String pass_user, String name_user, String phone_user, String address_user) {
        this.tk_user = tk_user;
        this.pass_user = pass_user;
        this.name_user = name_user;
        this.phone_user = phone_user;
        this.address_user = address_user;
    }

    public User(String tk_user, String pass_user) {
        this.tk_user = tk_user;
        this.pass_user = pass_user;
    }

    public String getTk_user() {
        return tk_user;
    }

    public void setTk_user(String tk_user) {
        this.tk_user = tk_user;
    }

    public String getPass_user() {
        return pass_user;
    }

    public void setPass_user(String pass_user) {
        this.pass_user = pass_user;
    }

    public String getName_user() {
        return name_user;
    }

    public void setName_user(String name_user) {
        this.name_user = name_user;
    }

    public String getPhone_user() {
        return phone_user;
    }

    public void setPhone_user(String phone_user) {
        this.phone_user = phone_user;
    }

    public String getAddress_user() {
        return address_user;
    }

    public void setAddress_user(String address_user) {
        this.address_user = address_user;
    }
}
