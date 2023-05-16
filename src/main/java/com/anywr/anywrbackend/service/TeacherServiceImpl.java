package com.anywr.anywrbackend.service;

import com.anywr.anywrbackend.dto.TeacherDTO;
import com.anywr.anywrbackend.entity.Teacher;
import com.anywr.anywrbackend.exception.TeacherNotFoundException;
import com.anywr.anywrbackend.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    TeacherRepository teacherRepository;

    @Override
    public Collection<TeacherDTO> findAllTeachers() {
        return teacherRepository.findAll().stream().map(teacher -> new TeacherDTO(teacher.getFirstName(),teacher.getLastName())).collect(Collectors.toList());
    }

    @Override
    public Teacher findTeacherByID(Long id) {
        Teacher teacher =  teacherRepository.findById(id).orElseThrow(() -> new TeacherNotFoundException("Teacher " +id + " not found"));
        return teacher;
    }

    @Override
    public void addTeacher(TeacherDTO teacherDTO) {
        com.anywr.anywrbackend.entity.Teacher teacher = TeacherDTO.mapToEntity(teacherDTO);
        teacherRepository.save(teacher);
    }

    @Override
    public com.anywr.anywrbackend.entity.Teacher getTeacherByFirstNameAndLastName(String firstName, String lastName) {
        com.anywr.anywrbackend.entity.Teacher teacher = teacherRepository.findByFirstNameAndLastName(firstName,lastName);
        return teacher;
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }
}
