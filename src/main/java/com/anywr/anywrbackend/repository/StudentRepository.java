package com.anywr.anywrbackend.repository;

import com.anywr.anywrbackend.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface StudentRepository extends JpaRepository<Student,Long> {

//    Page<Student> findByClassroomNameOOrClassroomTeacherF(String name, Pageable pageable);

//    @Query(value = "SELECT s FROM Student s WHERE ( s.classroom.name like %:classroomName% or :classroomName = '') " +
//            " OR (CONCAT(s.classroom.teacher.firstName,s.classroom.teacher.lastName) LIKE %:teacherFullName% OR :teacherFullName = '') ")
    @Query(nativeQuery = true,value = "select * from student " +
            " inner join class on student.classroom_id = class.id and (class.name like :classroomName OR :classroomName like '') " +
            " inner join teacher on teacher.classroom_id = teacher.id  and (concat (teacher.first_name, ' ', teacher.last_name) like :teacherFullName OR :teacherFullName like '') ")
    List<Student> findByClassroomNameORTeacherFullName(String classroomName,String teacherFullName,Pageable pageable);
}
