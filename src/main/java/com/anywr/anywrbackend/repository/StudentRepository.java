package com.anywr.anywrbackend.repository;

import com.anywr.anywrbackend.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface StudentRepository extends JpaRepository<Student,Long> {

//    Page<Student> findByClassroomNameOOrClassroomTeacherF(String name, Pageable pageable);

    @Query("SELECT s FROM Student s WHERE ( s.classroom.name like %:classroomName% or :classRoomName is null) " +
            " OR (CONCAT(s.classroom.teacher.firstName,s.classroom.teacher.lastName) LIKE %:teacherFullName% OR :teacherFullName is null) ")
    List<Student> findByClassroomNameORTeacherFullName(String classroomName,String teacherFullName,Pageable pageable);
}
