package com.example.demo.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"cname"}, name = "no_constraint"))

public class StudentDto {

    @Id

    private Integer sid; // Use Integer instead of int to allow null values

    private String sname;
    private String semail;
    private String cname; // Assuming this is the course name

    @OneToOne
    private CourseDto courseDto;

    // Getters and setters

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSemail() {
        return semail;
    }

    public void setSemail(String semail) {
        this.semail = semail;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public CourseDto getCourseDto() {
        return courseDto;
    }

    public void setCourseDto(CourseDto courseDto) {
        this.courseDto = courseDto;
    }

    @Override
    public String toString() {
        return "StudentDto [sid=" + sid + ", sname=" + sname + ", semail=" + semail + ", cname=" + cname + "]";
    }
}
