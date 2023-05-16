package com.anywr.anywrbackend.repository;

import com.anywr.anywrbackend.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher,Long> {

    Teacher findByFirstNameAndLastName(String firstName,String lastName);
}
