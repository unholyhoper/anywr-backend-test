package com.anywr.anywrbackend.service;

import com.anywr.anywrbackend.dto.TeacherDTO;
import com.anywr.anywrbackend.entity.Teacher;

import java.util.Collection;

public interface TeacherService {

    Collection<TeacherDTO> findAllTeachers();

    Teacher findTeacherByID(Long id);

    void addTeacher(TeacherDTO teacherDTO);

    com.anywr.anywrbackend.entity.Teacher getTeacherByFirstNameAndLastName(String firstName, String lastName);

    void updateTeacher(Teacher teacher);
}
