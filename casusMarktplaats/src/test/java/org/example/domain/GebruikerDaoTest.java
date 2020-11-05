package org.example.domain;

import org.apache.logging.log4j.core.util.Assert;
import org.example.util.GebruikerDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import java.math.BigDecimal;

import static org.example.util.GebruikerStatus.ACTIEF;
import static org.junit.jupiter.api.Assertions.*;

class GebruikerDaoTest {

    private final EntityManager em = Persistence.createEntityManagerFactory("H2").createEntityManager();
    private final GebruikerDao target = new GebruikerDao(em);

    @Test
    void getId() {
        //if
        Gebruiker e = new Gebruiker("pietje123", "wachtwoord", ACTIEF);
        target.save(e);
        //when
        long id = e.getId();
        //then
        assertEquals(1, id);

    }

    @Test
    void getGebruikersnaam() {
        //if
        Gebruiker e = new Gebruiker("pietje123", "wachtwoord", ACTIEF);
        target.save(e);
        //when
        String gebruikersnaam = e.getGebruikersnaam();
        //then
        assertEquals("pietje123", gebruikersnaam);
    }

    @Test
    void getWachtwoord() {
        //if
        Gebruiker e = new Gebruiker("pietje123", "wachtwoord", ACTIEF);
        target.save(e);
        //when
        String wachtwoord = e.getWachtwoord();
        //then
        assertEquals("wachtwoord", wachtwoord);
    }

}