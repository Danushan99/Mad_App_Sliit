package com.example.anew.medicin;

public class MedicineModel {
    private String patientName;
    private String patientAddress;
    private String phoneNo;
    private String Age;
    private String medicineName;
    private String quantity;

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

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public MedicineModel(String patientName,
                         String patientAddress,
                         String phoneNo,
                         String Age,
                         String medicineName,
                         String quantity){
        this.Age = Age;
        this.patientName = patientName;
        this.patientAddress = patientAddress;
        this.phoneNo = phoneNo;
        this.medicineName = medicineName;
        this.quantity = quantity;
    }

    public MedicineModel(){

    }
}
