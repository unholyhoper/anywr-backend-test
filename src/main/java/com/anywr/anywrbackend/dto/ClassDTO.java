package com.anywr.anywrbackend.dto;

import com.anywr.anywrbackend.entity.Class;

public class ClassDTO {
    private String name;

    public ClassDTO() {
    }

    public ClassDTO(String name) {
        this.name = name;
    }

    public ClassDTO(Class classroom){
        this.name = classroom.getName();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
