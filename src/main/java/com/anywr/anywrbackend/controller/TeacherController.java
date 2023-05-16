package com.anywr.anywrbackend.controller;

import com.anywr.anywrbackend.dto.ClassDTO;
import com.anywr.anywrbackend.dto.TeacherDTO;
import com.anywr.anywrbackend.entity.Teacher;
import com.anywr.anywrbackend.service.ClassService;
import com.anywr.anywrbackend.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.anywr.anywrbackend.entity.Class;
import java.util.Collection;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @Autowired
    ClassService classService;

    @GetMapping
    public ResponseEntity<Collection<TeacherDTO>> getAllTeachers() {
        Collection<TeacherDTO> teacherDTOS = teacherService.findAllTeachers();
        return new ResponseEntity<>(teacherDTOS, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherDTO> getTeacherById(@PathVariable Long id) {
        Teacher teacher = teacherService.findTeacherByID(id);
        TeacherDTO teacherDTO = new TeacherDTO(teacher.getFirstName(),teacher.getLastName());
        return new ResponseEntity<>(teacherDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TeacherDTO> createTeacher(@RequestBody TeacherDTO teacherDTO) {
        teacherService.addTeacher(teacherDTO);
        return new ResponseEntity<>(teacherDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeacherDTO> affectTeacherToClass(@PathVariable Long id,@RequestBody ClassDTO classDTO) {
        Teacher teacher = teacherService.findTeacherByID(id);
        Class classroom = classService.getClassroomByName(classDTO.getName());
        teacher.setClassroom(classroom);
        teacherService.updateTeacher(teacher);

        return new ResponseEntity<>(new TeacherDTO(teacher),HttpStatus.OK);

    }


}
