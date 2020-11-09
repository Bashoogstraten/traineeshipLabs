package org.example;

import org.example.domain.Gebruiker;
import org.example.util.GebruikerDao;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

import static org.example.util.GebruikerStatus.ACTIEF;

public class Voorprogrammeren {

    public static void start(EntityManager em) {

        GebruikerDao gebDao = new GebruikerDao(em);

        Gebruiker e = new Gebruiker("pietje123", "wachtwoord", ACTIEF);
        Gebruiker f = new Gebruiker("TheMasterSeller", "0000", ACTIEF);
        Gebruiker g = new Gebruiker("anoniempje_11", "qwoiqjwd81928", ACTIEF);
        Gebruiker h = new Gebruiker("ShimanoMaster69", "Groepsetjes!@", ACTIEF);

        gebDao.save(e);
        gebDao.save(f);
        gebDao.save(g);
        gebDao.save(h);

        e.nieuweAdvertentie("Bianchi fiets", "Mooie racefiets, weinig op gereden.", e, new BigDecimal("499"));
        e.nieuweAdvertentie("Shimano Ultegra groepset", "Te koop wegens overstap naar Dura Ace II.", e, new BigDecimal("250"));
        e.nieuweAdvertentie("Fizik zadel", "Fijn ergonomisch zadel voor langere ritten.", e, new BigDecimal("50"));
        f.nieuweAdvertentie("Stuurlint te koop", "Lekker aan je handen, plakt goed aan je stuur.", f, new BigDecimal("7.50"));
        f.nieuweAdvertentie("Fietsbroek Castelli - maat M", "Niet veel gedragen, net iets te klein voor mij.", f, new BigDecimal("29.90"));
        g.nieuweAdvertentie("Tijdrit stuur", "Te koop omdat ik niet zo diep gebogen kan zitten.", g, new BigDecimal("65"));
        g.nieuweAdvertentie("Fietsbroek en shirt team INEOS", "Heb een hekel aan die gasten, ga er niet in rondrijden.", g, new BigDecimal("85"));
        h.nieuweAdvertentie("Fietsschoenen merk Fizik", "Zitten mij net iets te krap, maat 43.", h, new BigDecimal("70"));
        h.nieuweAdvertentie("Pinarello fietsframe carbon", "I.v.m. aanschaf nieuw frame.", h, new BigDecimal("800"));
        h.nieuweAdvertentie("Giant racefiets, aluminium frame", "Te koop omdat ik ga overstappen op carbon.", h, new BigDecimal("420"));

        gebDao.update(e);
        gebDao.update(f);
        gebDao.update(g);
        gebDao.update(h);

    }

    public static void start() {
        start(Marktplaats.em);
    }
}
