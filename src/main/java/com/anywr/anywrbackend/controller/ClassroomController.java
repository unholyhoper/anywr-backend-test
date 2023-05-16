package com.anywr.anywrbackend.controller;

import com.anywr.anywrbackend.dto.ClassDTO;
import com.anywr.anywrbackend.dto.StudentDTO;
import com.anywr.anywrbackend.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/classes")
public class ClassroomController {

    @Autowired
    ClassService classService;

    @PostMapping
    public ResponseEntity<ClassDTO> addClass(@RequestBody ClassDTO classDTO) {
        this.classService.addClassroom(classDTO);
        return new ResponseEntity<>(classDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClassDTO> getStudentById(@PathVariable Long id) {
        ClassDTO classDTO = classService.getClassroomById(id);
        return new ResponseEntity<>(classDTO, HttpStatus.OK);
    }
}
