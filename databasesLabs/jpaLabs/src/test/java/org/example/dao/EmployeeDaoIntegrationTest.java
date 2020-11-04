package org.example.dao;

import org.example.domain.Department;
import org.example.domain.Employee;
import org.example.domain.EmployeeStatus;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeDaoIntegrationTest {

    private EntityManager em = Persistence.createEntityManagerFactory("H2").createEntityManager();
    private EmployeeDao target = new EmployeeDao(em);

    @Test
    void save() {
        target.save(new Employee("Test", "Case", EmployeeStatus.ACTIVE));
        Employee employee = target.get(1);

        assertThat(employee.getId()).isEqualTo(1);
    }

    @Test
    void delete(){
        target.save(new Employee("Bas", "Hoogstraten", EmployeeStatus.ACTIVE));
        target.delete(1);



    }

}