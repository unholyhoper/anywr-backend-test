package com.anywr.anywrbackend.service;

import com.anywr.anywrbackend.dto.ClassDTO;
import com.anywr.anywrbackend.entity.Class;
public interface ClassService {


    public void addClassroom(ClassDTO classDTO);

    public ClassDTO getClassroomById(Long id);

    public Class getClassroomByName(String name);

}
