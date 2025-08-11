package com.example.carepoint.Model;

public class Doctor {
    private String name;
    private String specialization;
    private String hospitalName;
    private String qualification;
    private String bmdcReg;
    private String experience;
    private int imageResId; // Assuming you use drawable resources for now

    public Doctor(String name, String specialization, String hospitalName, String qualification, String bmdcReg, String experience, int imageResId) {
        this.name = name;
        this.specialization = specialization;
        this.hospitalName = hospitalName;
        this.qualification = qualification;
        this.bmdcReg = bmdcReg;
        this.experience = experience;
        this.imageResId = imageResId;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public String getQualification() {
        return qualification;
    }

    public String getBmdcReg() {
        return bmdcReg;
    }

    public String getExperience() {
        return experience;
    }

    public int getImageResId() {
        return imageResId;
    }
}
