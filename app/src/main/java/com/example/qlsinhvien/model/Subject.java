package com.example.qlsinhvien.model;

public class Subject {
    //Các biến thông tin môn học

    //id
    private int id_subject;
    //tên môn học
    private String subject_title;
    //Số tín chỉ
    private int Number_of_credits;
    //Khoảng thời gian
    private String Time;
    //địa điểm
    private String place;
    //tài khoản
    private String tk_user;

    //tkb thứ
    private String tkb_thu;
    //tkb buổi
    private String tkb_buoi;


    public Subject(String subject_title, int number_of_credits, String time, String place, String tk_user, String tkb_thu, String tkb_buoi) {
        this.subject_title = subject_title;
        Number_of_credits = number_of_credits;
        Time = time;
        this.place = place;
        this.tk_user = tk_user;
        this.tkb_thu = tkb_thu;
        this.tkb_buoi = tkb_buoi;
    }

    public Subject(int id_subject, String subject_title, int number_of_credits, String time, String place, String tk_user, String tkb_thu, String tkb_buoi) {
        this.id_subject = id_subject;
        this.subject_title = subject_title;
        Number_of_credits = number_of_credits;
        Time = time;
        this.place = place;
        this.tk_user = tk_user;
        this.tkb_thu = tkb_thu;
        this.tkb_buoi = tkb_buoi;
    }

    public Subject(String subject_title, int number_of_credits, String time, String place, String tkb_thu, String tkb_buoi) {
        this.subject_title = subject_title;
        Number_of_credits = number_of_credits;
        Time = time;
        this.place = place;
        this.tkb_thu = tkb_thu;
        this.tkb_buoi = tkb_buoi;
    }

    public Subject(int id_subject, String subject_title, int number_of_credits, String time, String place, String tk_user) {
        this.id_subject = id_subject;
        this.subject_title = subject_title;
        Number_of_credits = number_of_credits;
        Time = time;
        this.place = place;
        this.tk_user = tk_user;
    }

    public Subject(String subject_title, int number_of_credits, String time, String place, String tk_user) {
        this.subject_title = subject_title;
        Number_of_credits = number_of_credits;
        Time = time;
        this.place = place;
        this.tk_user = tk_user;
    }

    public Subject(int id_subject, String subject_title, int number_of_credits, String time, String place) {
        this.id_subject = id_subject;
        this.subject_title = subject_title;
        Number_of_credits = number_of_credits;
        Time = time;
        this.place = place;
    }

    public Subject(String subject_title, int number_of_credits, String time, String place) {
        this.subject_title = subject_title;
        Number_of_credits = number_of_credits;
        Time = time;
        this.place = place;
    }

    public int getId_subject() {
        return id_subject;
    }

    public void setId_subject(int id_subject) {
        this.id_subject = id_subject;
    }

    public String getSubject_title() {
        return subject_title;
    }

    public void setSubject_title(String subject_title) {
        this.subject_title = subject_title;
    }

    public int getNumber_of_credits() {
        return Number_of_credits;
    }

    public void setNumber_of_credits(int number_of_credits) {
        Number_of_credits = number_of_credits;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getTk_user() {
        return tk_user;
    }

    public void setTk_user(String tk_user) {
        this.tk_user = tk_user;
    }

    public String getTkb_thu() {
        return tkb_thu;
    }

    public void setTkb_thu(String tkb_thu) {
        this.tkb_thu = tkb_thu;
    }

    public String getTkb_buoi() {
        return tkb_buoi;
    }

    public void setTkb_buoi(String tkb_buoi) {
        this.tkb_buoi = tkb_buoi;
    }
}
