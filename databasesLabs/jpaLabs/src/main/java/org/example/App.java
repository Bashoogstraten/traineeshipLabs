package org.example;

import org.example.dao.EmployeeDao;
import org.example.domain.Department;
import org.example.domain.Employee;
import org.example.domain.EmployeeStatus;
import org.example.domain.ProgrammingLanguage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.time.Instant;
import java.util.Date;

public class App {

    private final Logger log = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {

        new App().run();{
        }

    }

    private void run() {
        EntityManager em = Persistence.createEntityManagerFactory("MySQL").createEntityManager();

        EmployeeDao dao = new EmployeeDao(em);
        Employee e = new Employee("George", "Washington", EmployeeStatus.ACTIVE);
        Employee f = new Employee("Theodore", "Roosevelt", EmployeeStatus.ACTIVE);

//        dao.save(e);
        dao.saveAndDetach(e);
        dao.save(f);

        dao.updateStatus(1, EmployeeStatus.INACTIVE);
        dao.updateFirstName(2, "Teddy");
        f.setDepartment(new Department("Marketing"));
        dao.update(f);

        dao.updateBirthday(2, Date.from(Instant.now()));

        e.setMedicalRecord("Is deceased.");
        dao.update(e);
        log(e.getMedicalRecord());

//        dao.findAll().forEach(this::log);
//        dao.findByFirstName("Teddy").forEach(this::log);
//        dao.findByDepartment("Market").forEach(this::log);

        ProgrammingLanguage python = new ProgrammingLanguage("Python");
        ProgrammingLanguage java = new ProgrammingLanguage("Java");
        ProgrammingLanguage cSharp = new ProgrammingLanguage(("Csharp"));

        e = dao.getWithEmployee(e);

        e.addProgrammingLanguage(python);
        e.addProgrammingLanguage(java);

        f.addProgrammingLanguage(java);
        f.addProgrammingLanguage(cSharp);

        dao.save(e);
        dao.save(f);



//        e.setFirstName("Bastiaan");
//        e.setStatus(EmployeeStatus.INACTIVE);
//        dao.update(e);

//        dao.delete(2);

//        Employee bas = dao.get(1);
//        Employee nienke = dao.get(2);
//        log(bas);
//        log(nienke);
    }

    private void log(Object o) {
        log.debug(o.toString());
    }
}
