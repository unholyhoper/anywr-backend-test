package com.anywr.anywrbackend.dto;

import com.anywr.anywrbackend.entity.Teacher;

public class TeacherDTO {

    private String firstName;
    private String lastName;

    private String className;
    public TeacherDTO() {
    }

    public TeacherDTO(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public TeacherDTO(Teacher teacher){
        this.firstName = teacher.getFirstName();
        this.lastName = teacher.getLastName();
        if (teacher.getClassroom()!=null){
            this.className = teacher.getClassroom().getName();

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

    public static com.anywr.anywrbackend.entity.Teacher mapToEntity(TeacherDTO teacherDTO){
        return new com.anywr.anywrbackend.entity.Teacher(teacherDTO.getFirstName(), teacherDTO.getLastName());
    }
}
