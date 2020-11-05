package org.example.domain;

import org.example.util.AdvertentieDao;
import org.example.util.AdvertentieStatus;
import org.example.util.GebruikerDao;
import org.example.util.GebruikerStatus;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class AdvertentieDaoTest {

    private final EntityManager em = Persistence.createEntityManagerFactory("H2").createEntityManager();
    private final GebruikerDao gebDao = new GebruikerDao(em);
    private final AdvertentieDao adDao = new AdvertentieDao(em);

    @Test
    void getId() {
        //if
        Gebruiker e = new Gebruiker("gozer", "wachtwoord", GebruikerStatus.ACTIEF);
        gebDao.save(e);
        Advertentie a = new Advertentie("test", "test", e, new BigDecimal("0"), AdvertentieStatus.BESCHIKBAAR);
        adDao.save(a);
        //when
        long id = a.getId();
        //then
        assertEquals(2, id);

    }

    @Test
    void updateAdvertentieTitel() {
        //if
        Gebruiker e = new Gebruiker("gozer", "wachtwoord", GebruikerStatus.ACTIEF);
        gebDao.save(e);
        Advertentie a = new Advertentie("test", "test", e, new BigDecimal("0"), AdvertentieStatus.BESCHIKBAAR);
        adDao.save(a);
        //when
        adDao.updateTitel(2, "nieuwe titel");
        //then
        assertEquals("nieuwe titel", a.getTitel());
    }

    @Test
    void updateAdvertentieOmschrijving() {
        //if
        Gebruiker e = new Gebruiker("gozer", "wachtwoord", GebruikerStatus.ACTIEF);
        gebDao.save(e);
        Advertentie a = new Advertentie("test", "test", e, new BigDecimal("0"), AdvertentieStatus.BESCHIKBAAR);
        adDao.save(a);
        //when
        adDao.updateOmschrijving(2, "nieuwe omschrijving");
        //then
        assertEquals("nieuwe omschrijving", a.getOmschrijving());
    }

    @Test
    void updateAdvertentiePrijs() {
        //if
        Gebruiker e = new Gebruiker("gozer", "wachtwoord", GebruikerStatus.ACTIEF);
        gebDao.save(e);
        Advertentie a = new Advertentie("test", "test", e, new BigDecimal("0"), AdvertentieStatus.BESCHIKBAAR);
        adDao.save(a);
        //when
        adDao.updatePrijs(2, new BigDecimal("20"));
        //then
        assertEquals(new BigDecimal("20"), a.getPrijs());
    }
}