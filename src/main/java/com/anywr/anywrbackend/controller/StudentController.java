package com.anywr.anywrbackend.controller;

import com.anywr.anywrbackend.dto.StudentDTO;
import com.anywr.anywrbackend.entity.Student;
import com.anywr.anywrbackend.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping
    public ResponseEntity<Collection<StudentDTO>> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        Collection<StudentDTO> studentDTOS = students.stream()
                .map(student -> new StudentDTO(student.getFirstName(), student.getLastName())).collect(Collectors.toList());

        return new ResponseEntity<>(studentDTOS, HttpStatus.OK);


    }

}
