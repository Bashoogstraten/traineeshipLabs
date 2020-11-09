package org.example.domain;

import org.example.util.AdvertentieStatus;
import org.example.util.GebruikerDao;
import org.example.util.GebruikerStatus;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import java.math.BigDecimal;

import static org.example.util.GebruikerStatus.ACTIEF;
import static org.junit.jupiter.api.Assertions.*;

class GebruikerDaoTest {

    private final EntityManager em = Persistence.createEntityManagerFactory("H2").createEntityManager();
    private final GebruikerDao gebDao = new GebruikerDao(em);

    @Test
    void getGebruiker() {
        //if
        Gebruiker e = new Gebruiker("pietje123", "wachtwoord", ACTIEF);
        gebDao.save(e);
        //when
        Gebruiker get = gebDao.get(1);
        //then
        assertEquals(e, get);

    }

    @Test
    void getMetGebruikersnaam() {
        //if
        Gebruiker e = new Gebruiker("pietje123", "wachtwoord", ACTIEF);
        gebDao.save(e);
        //when
        Gebruiker get = gebDao.getMetGebruikersnaam("pietje123");
        //then
        assertEquals(e, get);

    }

    @Test
    void voegToeAanWinkelwagen() {
        //if
        Gebruiker e = new Gebruiker("pietje123", "wachtwoord", ACTIEF);
        gebDao.save(e);
        Gebruiker f = new Gebruiker("dombo789", "wachtwoord", ACTIEF);
        gebDao.save(f);
        Advertentie a = new Advertentie("test", "test", f, new BigDecimal("0"), AdvertentieStatus.BESCHIKBAAR);
        gebDao.update(f);
        //when
        gebDao.voegToeAanWinkelwagen(a, e);
        //then
        assertEquals(1, e.getWinkelwagen().size());

    }

    @Test
    void voegToeAanWinkelwagenMaarBlijfInAdvertentielijstVerkoper() {
        //if
        Gebruiker e = new Gebruiker("pietje123", "wachtwoord", ACTIEF);
        gebDao.save(e);
        Gebruiker f = new Gebruiker("dombo789", "wachtwoord", ACTIEF);
        gebDao.save(f);
        Advertentie a = new Advertentie("test", "test", f, new BigDecimal("0"), AdvertentieStatus.BESCHIKBAAR);
        gebDao.update(f);
        //when
        gebDao.voegToeAanWinkelwagen(a, e);
        //then
        assertEquals(1, f.getAdvertenties().size());

    }

    @Test
    void getId() {
        //if
        Gebruiker e = new Gebruiker("pietje123", "wachtwoord", ACTIEF);
        gebDao.save(e);
        //when
        long id = e.getId();
        //then
        assertEquals(1, id);

    }

    @Test
    void getGebruikersnaam() {
        //if
        Gebruiker e = new Gebruiker("pietje123", "wachtwoord", ACTIEF);
        gebDao.save(e);
        //when
        String gebruikersnaam = e.getGebruikersnaam();
        //then
        assertEquals("pietje123", gebruikersnaam);
    }

    @Test
    void getWachtwoord() {
        //if
        Gebruiker e = new Gebruiker("pietje123", "wachtwoord", ACTIEF);
        gebDao.save(e);
        //when
        String wachtwoord = e.getWachtwoord();
        //then
        assertEquals("wachtwoord", wachtwoord);
    }

    @Test
    void nieuweAdvertentie() {
        //if
        Gebruiker e = new Gebruiker("gozer", "wachtwoord", GebruikerStatus.ACTIEF);
        gebDao.save(e);
        //when
        e.nieuweAdvertentie("test", "test", e, new BigDecimal("0"));
        //then
        assertEquals(1, e.getAdvertenties().size());
    }

    @Test
    void voegBestaandeAdvertentieToe() {
        //if
        Gebruiker e = new Gebruiker("gozer", "wachtwoord", GebruikerStatus.ACTIEF);
        gebDao.save(e);
        Advertentie a = new Advertentie("test", "test", e, new BigDecimal("0"), AdvertentieStatus.BESCHIKBAAR);
        //when
        e.voegBestaandeAdvertentieToe(a);
        gebDao.update(e);
        //then
        assertEquals(1, e.getAdvertenties().size());
    }

    @Test
    void voegBestaandeAdvertentieToeAanWinkelwagen() {
        //if
        Gebruiker e = new Gebruiker("gozer", "wachtwoord", GebruikerStatus.ACTIEF);
        gebDao.save(e);
        Advertentie a = new Advertentie("test", "test", e, new BigDecimal("0"), AdvertentieStatus.BESCHIKBAAR);
        //when
        e.voegBestaandeAdvertentieToeAanWinkelwagen(a);
        gebDao.update(e);
        int winkelwagen = e.getWinkelwagen().size();
        //then
        assertEquals(1, winkelwagen);
    }

}