package org.example.domain;

import org.example.util.AdvertentieDao;
import org.example.util.AdvertentieStatus;
import org.example.util.GebruikerDao;
import org.example.util.GebruikerStatus;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import java.math.BigDecimal;

import static org.example.util.GebruikerStatus.ACTIEF;
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
    void getAanbieder() {
        //if
        Gebruiker e = new Gebruiker("gozer", "wachtwoord", GebruikerStatus.ACTIEF);
        gebDao.save(e);
        Advertentie a = new Advertentie("test", "test", e, new BigDecimal("0"), AdvertentieStatus.BESCHIKBAAR);
        adDao.save(a);
        //when
        Gebruiker aanbieder = a.getAanbieder();
        //then
        assertEquals(e, aanbieder);

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

    @Test
    void updateAdvertentieStatusVerwijderd() {
        //if
        Gebruiker e = new Gebruiker("gozer", "wachtwoord", GebruikerStatus.ACTIEF);
        gebDao.save(e);
        Advertentie a = new Advertentie("test", "test", e, new BigDecimal("0"), AdvertentieStatus.BESCHIKBAAR);
        adDao.save(a);
        //when
        adDao.updateStatusVerwijderd(2);
        //then
        assertEquals(AdvertentieStatus.VERWIJDERD, a.getAdvertentieStatus());
    }

    @Test
    void verwijderAdvertentieUitWinkelwagen() {
        //if
        Gebruiker e = new Gebruiker("pietje123", "wachtwoord", ACTIEF);
        gebDao.save(e);
        Gebruiker f = new Gebruiker("dombo789", "wachtwoord", ACTIEF);
        gebDao.save(f);
        Advertentie a = new Advertentie("test", "test", f, new BigDecimal("0"), AdvertentieStatus.BESCHIKBAAR);
        gebDao.update(f);
        //when
        gebDao.voegToeAanWinkelwagen(a, e);
        gebDao.verwijderUitWinkelwagen(a, e);
        //then
        assertEquals(0, adDao.findAllVoorKoper(e).size());
    }

    @Test
    void verwijderBestaandeAdvertentieUitWinkelwagen() {
        //if
        Gebruiker e = new Gebruiker("pietje123", "wachtwoord", ACTIEF);
        gebDao.save(e);
        Gebruiker f = new Gebruiker("dombo789", "wachtwoord", ACTIEF);
        gebDao.save(f);
        Advertentie a = new Advertentie("test", "test", f, new BigDecimal("0"), AdvertentieStatus.BESCHIKBAAR);
        gebDao.update(f);
        //when
        gebDao.voegToeAanWinkelwagen(a, e);
        e.verwijderBestaandeAdvertentieUitWinkelwagen(a);
        gebDao.update(e);
        //then
        assertEquals(0, adDao.findAllVoorKoper(e).size());
    }

    @Test
    void findTotaalVoorVerkoper() {
        //if
        Gebruiker e = new Gebruiker("pietje123", "wachtwoord", ACTIEF);
        gebDao.save(e);
        Gebruiker f = new Gebruiker("dombo789", "wachtwoord", ACTIEF);
        gebDao.save(f);
        Advertentie a = new Advertentie("test", "test", f, new BigDecimal("90"), AdvertentieStatus.BESCHIKBAAR);
        gebDao.update(f);
        //when
        gebDao.voegToeAanWinkelwagen(a, e);
        a.setAdvertentieStatus(AdvertentieStatus.IN_WINKELWAGEN);
        BigDecimal totaal = adDao.findTotaalVoorKoper(e);
        //then
        assertEquals(new BigDecimal("90"), totaal);
    }

    @Test
    void remove() {
        //if
        Gebruiker e = new Gebruiker("gozer", "wachtwoord", GebruikerStatus.ACTIEF);
        gebDao.save(e);
        Advertentie a = new Advertentie("test", "test", e, new BigDecimal("0"), AdvertentieStatus.BESCHIKBAAR);
        adDao.save(a);
        int before = adDao.findAll().size();
        //when
        long id = a.getId();
        adDao.delete(id);
        int after = adDao.findAll().size();
        //then
        assertTrue(after == before - 1);
    }

    @Test
    void toStringTest(){
        //if
        Gebruiker e = new Gebruiker("gozer", "wachtwoord", GebruikerStatus.ACTIEF);
        gebDao.save(e);
        Advertentie a = new Advertentie("test", "test", e, new BigDecimal("0"), AdvertentieStatus.BESCHIKBAAR);
        adDao.save(a);
        //when
        System.out.println(a.toString());
        //then
        assertEquals("Advertentie {id = 2, titel = 'test', omschrijving = 'test', prijs = 0, advertentieStatus= BESCHIKBAAR}", a.toString());
    }

    @Test
    void whenAdvertentieStatusIsVERWIJDERDTheAdvertentieWillNotShowInTheAdvertentieOverzicht() {
        //if
        Gebruiker e = new Gebruiker("gozer", "wachtwoord", GebruikerStatus.ACTIEF);
        gebDao.save(e);
        Advertentie a = new Advertentie("test", "test", e, new BigDecimal("0"), AdvertentieStatus.BESCHIKBAAR);
        adDao.save(a);
        int before = adDao.findAllVoorGebruiker(e).size();
        //when
        adDao.updateStatusVerwijderd(2);
        int after = adDao.findAllVoorGebruiker(e).size();
        //then
        assertTrue(after == before - 1);
    }

    @Test
    void findByZoekterm() {
        //if
        Gebruiker e = new Gebruiker("gozer", "wachtwoord", GebruikerStatus.ACTIEF);
        Gebruiker f = new Gebruiker("gast", "wachtwoord", GebruikerStatus.ACTIEF);
        gebDao.save(e);
        gebDao.save(f);
        Advertentie a = new Advertentie("test", "test", e, new BigDecimal("0"), AdvertentieStatus.BESCHIKBAAR);
        Advertentie b = new Advertentie("test", "test", f, new BigDecimal("0"), AdvertentieStatus.BESCHIKBAAR);
        adDao.save(a);
        adDao.save(b);
        //when
        int resultaten = adDao.findByZoekterm(f, "test", AdvertentieStatus.BESCHIKBAAR).size();
        //then
        assertEquals(1, resultaten);
    }
}