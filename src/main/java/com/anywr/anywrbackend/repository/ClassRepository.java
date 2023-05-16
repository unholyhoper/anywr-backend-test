package com.anywr.anywrbackend.repository;

import com.anywr.anywrbackend.entity.Class;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRepository extends JpaRepository<Class,Long> {

    Class findClassByName(String name);
}
