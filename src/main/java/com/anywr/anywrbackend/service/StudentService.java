package com.anywr.anywrbackend.service;

import com.anywr.anywrbackend.dto.ClassDTO;
import com.anywr.anywrbackend.dto.StudentDTO;
import com.anywr.anywrbackend.entity.Class;
import com.anywr.anywrbackend.entity.Student;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StudentService {
    List<Student> findByClassroomNameORTeacherFullName(String classroomName, String teacherFullName, int page,int size);

    public void addStudent(StudentDTO studentDTO);

    public Student getStudentById(Long id);

    Class affectStudentToClassroom(ClassDTO classDTO);

    void updateStudent(Student student);
}
