package com.kiran.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kiran.Enums.BranchEnum;
import com.kiran.Enums.CourseEnum;

import java.util.Date;

public class StudentDTO {

    private String name;
    private String email;
    private Long academicYear;
    private CourseEnum courses;
    private String rollNo;
    private BranchEnum branch;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dob;

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

    public CourseEnum getCourses() {
        return courses;
    }

    public void setCourses(CourseEnum courses) {
        this.courses = courses;
    }

    public Long getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(Long academicYear) {
        this.academicYear = academicYear;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public BranchEnum getBranch() {
        return branch;
    }

    public void setBranch(BranchEnum branch) {
        this.branch = branch;
    }
}
