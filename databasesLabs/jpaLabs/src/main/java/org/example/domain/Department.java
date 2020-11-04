package org.example.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Department {

    @Id
    @GeneratedValue
    private long id;

    private String departmentName;

    public Department(){

    }

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }
}
