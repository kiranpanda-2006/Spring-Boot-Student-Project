package com.kiran.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kiran.Enums.BranchEnum;
import com.kiran.Enums.CourseEnum;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private Long academicYear;
    private CourseEnum courses;
    private String rollNo;
    private BranchEnum branch;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dob;
    private boolean deleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(Long academicYear) {
        this.academicYear = academicYear;
    }

    public CourseEnum getCourses() {
        return courses;
    }

    public void setCourses(CourseEnum courses) {
        this.courses = courses;
    }

    public BranchEnum getBranch() {
        return branch;
    }

    public void setBranch(BranchEnum branch) {
        this.branch = branch;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }
}
