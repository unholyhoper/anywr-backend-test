package com.anywr.anywrbackend.controller;

import com.anywr.anywrbackend.dto.ClassDTO;
import com.anywr.anywrbackend.dto.StudentDTO;
import com.anywr.anywrbackend.entity.Class;
import com.anywr.anywrbackend.entity.Student;
import com.anywr.anywrbackend.service.ClassService;
import com.anywr.anywrbackend.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    StudentService studentService;
    @Autowired
    ClassService classService;

    @GetMapping
    public ResponseEntity<Collection<StudentDTO>> getAllStudents(
            @RequestParam(defaultValue = "") String className,
            @RequestParam(defaultValue = "") String teacherFullName,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        List<Student> students = studentService.findByClassroomNameORTeacherFullName(className, teacherFullName, page, size);
        Collection<StudentDTO> studentDTOS = students.stream()
                .map(student -> new StudentDTO(student)).collect(Collectors.toList());
        return new ResponseEntity<>(studentDTOS, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StudentDTO> addStudent(@RequestBody StudentDTO studentDTO) {
        this.studentService.addStudent(studentDTO);
        return new ResponseEntity<>(studentDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable Long id) {
        Student student = studentService.getStudentById(id);
        StudentDTO studentDTO = new StudentDTO(student);
        return new ResponseEntity<>(studentDTO, HttpStatus.OK);
    }

    @PutMapping ("/{id}")
    public ResponseEntity<StudentDTO> affectStudentToClass(@PathVariable Long id ,@RequestBody ClassDTO classDTO){
        Class classroom = classService.getClassroomByName(classDTO.getName());
        Student student = studentService.getStudentById(id);
        student.setClassroom(classroom);
        studentService.updateStudent(student);
        return new ResponseEntity<>(new StudentDTO(student),HttpStatus.OK);
    }

}
