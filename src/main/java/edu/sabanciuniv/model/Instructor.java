package edu.sabanciuniv.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String instructorName;
    private String address;
    private String phoneNumber;

    @OneToMany
    private List<Course> courseList = new ArrayList<>();

    public Instructor(String instructorName, String address, String phoneNumber) {
        this.instructorName = instructorName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Instructor() {
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
