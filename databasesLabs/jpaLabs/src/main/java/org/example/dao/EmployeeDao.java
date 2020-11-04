package org.example.dao;

import org.example.domain.Employee;
import org.example.domain.EmployeeStatus;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

public class EmployeeDao {

    private final EntityManager em;

    public EmployeeDao(EntityManager em) {
        this.em = em;
    }

    public void save(Employee e) {
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
    }

    public void saveAndDetach(Employee e) {
        em.getTransaction().begin();
        em.persist(e);
        em.detach(e);
        em.getTransaction().commit();
    }

    private void detach() {
        em.flush();
        em.clear();
    }

    public void delete(long id) {
        em.getTransaction().begin();
        Employee e = get(id);
        em.remove(e);
        em.getTransaction().commit();
    }

    public Employee update(Employee e) {
        em.getTransaction().begin();
        Employee merged = em.merge(e);
        em.getTransaction().commit();
        return merged;
    }

    public Employee updateFirstName(long id, String firstName) {
        Employee e = get(id);
        if (e != null) {
            em.getTransaction().begin();
            e.setFirstName(firstName);
            em.getTransaction().commit();
        }
        return e;
    }

    public Employee updateLastName(long id, String lastName) {
        Employee e = get(id);
        if (e != null) {
            em.getTransaction().begin();
            e.setLastName(lastName);
            em.getTransaction().commit();
        }
        return e;
    }

    public Employee updateStatus(long id, EmployeeStatus status) {
        Employee e = get(id);
        if (e != null) {
            em.getTransaction().begin();
            e.setStatus(status);
            em.getTransaction().commit();
        }
        return e;
    }

    public Employee updateBirthday(long id, Date birthday) {
        Employee e = get(id);
        if (e != null) {
            em.getTransaction().begin();
            e.setBirthday(birthday);
            em.getTransaction().commit();
        }
        return e;
    }

    public Employee getWithEmployee(Employee e){

        long id = e.getId();
        return em.find(Employee.class, id);
    }

    public Employee get(long id) {

        return em.find(Employee.class, id);
    }

    public List<Employee> findAll() {
        TypedQuery<Employee> query = em.createQuery("SELECT e FROM Employee e ", Employee.class);
        return query.getResultList();
    }

    public List<Employee> findByFirstName(String firstName) {
        TypedQuery<Employee> query = em.createQuery("select e from Employee e where e.firstName = :firstarg", Employee.class);
        query.setParameter("firstarg", firstName);
        return query.getResultList();
    }

    public List<Employee> findByDepartment(String depName) {
        TypedQuery<Employee> query = em.createQuery("select e from Employee e JOIN e.department as d where d.departmentName LIKE :firstarg", Employee.class);
        query.setParameter("firstarg", "%" + depName + "%");
        return query.getResultList();
    }
}
