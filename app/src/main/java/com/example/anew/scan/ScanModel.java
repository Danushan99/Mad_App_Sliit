package com.example.anew.scan;

import java.sql.Time;

public class ScanModel {
    private String scanName;
    private String patientName;
    private String doctorName;
    private String patientAddress;
    private String phoneNo;
    private String Age;
    private String bookingDate;
    private String time;

    public String getScanName() {
        return scanName;
    }

    public void setScanName(String scanName) {
        this.scanName = scanName;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientAddress() {
        return patientAddress;
    }

    public void setPatientAddress(String patientAddress) {
        this.patientAddress = patientAddress;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public ScanModel(){
    }

    public ScanModel(String scanName,
                     String patientName,
                     String patientAddress,
                     String phoneNo,
                     String Age,
                     String bookingDate){
        this.scanName=scanName;
        this.Age = Age;
        this.patientName = patientName;
        this.patientAddress = patientAddress;
        this.phoneNo = phoneNo;
        this.bookingDate = bookingDate;
    }
}
