package org.example;

import org.example.domain.Advertentie;
import org.example.domain.Gebruiker;
import org.example.util.AdvertentieDao;
import org.example.util.GebruikerDao;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import static org.assertj.core.api.Assertions.assertThat;

class VerwijderenAdvertentieIT {

    private final EntityManager em = Persistence.createEntityManagerFactory("H2").createEntityManager();

    @Test
    void verwijderAdvertentie() {
        Voorprogrammeren.start(em);

        GebruikerDao gebDao = new GebruikerDao(em);
        AdvertentieDao adDao = new AdvertentieDao(em);
        Gebruiker ingelogdeGebruiker = gebDao.getMetGebruikersnaam("pietje123");

        // new VerwijderenAdvertentie().start(ingelogdeGebruiker);

        long idLong = Long.parseLong("6");
        Advertentie verwijderAdvertentie = adDao.get(idLong);
        System.out.println("Dit is de advertentie die u geselecteerd heeft om te verwijderen: ");
        System.out.println(verwijderAdvertentie.toString());

        int before = adDao.findAll().size();

        ingelogdeGebruiker.verwijderAdvertentie(verwijderAdvertentie);
        adDao.delete(verwijderAdvertentie);
        gebDao.update(ingelogdeGebruiker);

        int after = adDao.findAll().size();

        assertThat(before - after).isEqualTo(1);
    }
}
