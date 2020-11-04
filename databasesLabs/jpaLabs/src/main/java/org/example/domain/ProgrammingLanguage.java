package org.example.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.LinkedList;
import java.util.List;

@Entity
public class ProgrammingLanguage {

    @Id
    @GeneratedValue
    private long id;

    private String language;

    @ManyToMany(mappedBy = "language")
    private List<Employee> employees = new LinkedList<>();

    public ProgrammingLanguage(){

    }

    public ProgrammingLanguage(String language){
        this.language = language;
    }

    public long getId() {

        return id;
    }

}
