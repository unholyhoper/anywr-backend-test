package com.anywr.anywrbackend.service;

import com.anywr.anywrbackend.dto.ClassDTO;
import com.anywr.anywrbackend.dto.StudentDTO;
import com.anywr.anywrbackend.entity.Class;
import com.anywr.anywrbackend.entity.Student;
import com.anywr.anywrbackend.exception.StudentNotFoundException;
import com.anywr.anywrbackend.repository.ClassRepository;
import com.anywr.anywrbackend.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;


    @Autowired
    ClassRepository classRepository;

    @Override
    public List<Student> findByClassroomNameORTeacherFullName(String classroomName, String teacherFullName, int page,int size) {
        Pageable pageable = PageRequest.of(page, size);
        return studentRepository.findByClassroomNameORTeacherFullName(classroomName,teacherFullName,pageable);
    }

    @Override
    public void addStudent(StudentDTO studentDTO) {
        Student student = new Student();
        student.setFirstName(studentDTO.getFirstName());
        student.setLastName(studentDTO.getLastName());
        studentRepository.save(student);
    }

    @Override
    public Student getStudentById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("Student "+id+" not found"));
        return student;
    }

    @Override
    public Class affectStudentToClassroom(ClassDTO classDTO) {
        Class classroom = classRepository.findClassByName(classDTO.getName());
        return classroom;
    }

    @Override
    public void updateStudent(Student student) {
        studentRepository.save(student);
    }
}
