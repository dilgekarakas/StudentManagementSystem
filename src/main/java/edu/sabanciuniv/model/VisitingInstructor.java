package edu.sabanciuniv.model;

import jakarta.persistence.Entity;

@Entity
public class VisitingInstructor extends Instructor{
    private int hourlySalary;

    public VisitingInstructor(String instructorName, String address, String phoneNumber, int hourlySalary) {
        super(instructorName, address, phoneNumber);
        this.hourlySalary = hourlySalary;
    }

    public VisitingInstructor(int hourlySalary) {
        this.hourlySalary = hourlySalary;
    }

    public VisitingInstructor() {
    }

    public int getHourlySalary() {
        return hourlySalary;
    }

    public void setHourlySalary(int hourlySalary) {
        this.hourlySalary = hourlySalary;
    }
}
