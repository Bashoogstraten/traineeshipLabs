package org.example.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Employee {

    @Id
    @GeneratedValue
    private long id;

    private String firstName;
    private String lastName;

    @Enumerated(value = EnumType.STRING)
    private EmployeeStatus status;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Department department;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<ProgrammingLanguage> language = new LinkedList<>();

    @Temporal(value = TemporalType.DATE)
    private Date birthday;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    private String medicalRecord;

    public Employee() {
    }

    public Employee(String firstName, String lastName, EmployeeStatus status) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public String getMedicalRecord() {
        return medicalRecord;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setStatus(EmployeeStatus status) {
        this.status = status;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void addProgrammingLanguage(ProgrammingLanguage language){
        this.language.add(language);
    }

    public void setMedicalRecord(String medicalRecord){
        this.medicalRecord = medicalRecord;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id = " + id +
                ", name = '" + firstName + " " + lastName + '\'' +
                '}';
    }
}
