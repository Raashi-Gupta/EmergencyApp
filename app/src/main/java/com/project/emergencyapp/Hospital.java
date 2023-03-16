package com.project.emergencyapp;

import java.util.Arrays;

public class Hospital {
    private String name;
    private String email;
    private Long contactNumber;
    private String typeOfHospital;
    private String[] healthCareType;
    private String password;
    private String address;

    public Hospital(String name, String email, Long contactNumber, String typeOfHospital, String[] healthCareType, String password, String address) {
        this.name = name;
        this.email = email;
        this.contactNumber = contactNumber;
        this.typeOfHospital = typeOfHospital;
        this.healthCareType = healthCareType;
        this.password = password;
        this.address = address;
    }

    public Hospital() {
    }

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

    public Long getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(Long contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getTypeOfHospital() {
        return typeOfHospital;
    }

    public void setTypeOfHospital(String typeOfHospital) {
        this.typeOfHospital = typeOfHospital;
    }

    public String[] getHealthCareType() {
        return healthCareType;
    }

    public void setHealthCareType(String[] healthCareType) {
        this.healthCareType = healthCareType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", contactNumber=" + contactNumber +
                ", typeOfHospital='" + typeOfHospital + '\'' +
                ", healthCareType=" + Arrays.toString(healthCareType) +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

}
