package com.anywr.anywrbackend.dto;

import com.anywr.anywrbackend.entity.Student;

public class StudentDTO {

    private String firstName;
    private String lastName;

    private String className;

    public StudentDTO() {
    }

    public StudentDTO(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public StudentDTO(Student student){
        this.firstName = student.getFirstName();
        this.lastName = student.getLastName();
        if (student.getClassroom()!=null){
            this.className = student.getClassroom().getName();
        }
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
