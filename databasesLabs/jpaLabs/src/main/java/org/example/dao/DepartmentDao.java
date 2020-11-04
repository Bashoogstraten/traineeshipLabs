package org.example.dao;

import org.example.domain.Department;

import javax.persistence.EntityManager;

public class DepartmentDao {

    private final EntityManager em;

    public DepartmentDao(EntityManager em) {

        this.em = em;
    }

    public void save(Department e) {
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
    }

    public Department get(long id) {
        return em.find(Department.class, id);
    }
}
