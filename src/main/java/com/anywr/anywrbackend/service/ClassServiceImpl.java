package com.anywr.anywrbackend.service;

import com.anywr.anywrbackend.dto.ClassDTO;
import com.anywr.anywrbackend.dto.StudentDTO;
import com.anywr.anywrbackend.entity.Class;
import com.anywr.anywrbackend.entity.Student;
import com.anywr.anywrbackend.exception.ClassNotFoundException;
import com.anywr.anywrbackend.exception.StudentNotFoundException;
import com.anywr.anywrbackend.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassServiceImpl implements ClassService {
    @Autowired
    ClassRepository classRepository;

    @Override
    public void addClassroom(ClassDTO classDTO) {
        Class classroom = new Class(classDTO.getName());
        classRepository.save(classroom);
    }

    @Override
    public ClassDTO getClassroomById(Long id) {
        Class classroom = classRepository.findById(id).orElseThrow(() -> new ClassNotFoundException("Class  "+id+" not found"));
        return new ClassDTO(classroom.getName());
    }

    @Override
    public Class getClassroomByName(String name) {
        Class classroom = classRepository.findClassByName(name);
        return classroom;
    }
}
