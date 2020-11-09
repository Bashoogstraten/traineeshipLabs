package org.example.util;

import org.example.domain.Advertentie;
import org.example.domain.Gebruiker;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import static org.example.util.AdvertentieStatus.*;

public class AdvertentieDao {

    private final EntityManager em;

    public AdvertentieDao(EntityManager em) {
        this.em = em;
    }

    public void save(Advertentie e) {
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
    }

    public void delete(long id) {
        em.getTransaction().begin();
        Advertentie e = get(id);
        em.remove(e);
        em.getTransaction().commit();
    }

    public void updateTitel(long id, String titel) {
        Advertentie e = get(id);
        if (e != null) {
            em.getTransaction().begin();
            e.setTitel(titel);
            em.getTransaction().commit();
        }
    }

    public void updateOmschrijving(long id, String omschrijving) {
        Advertentie e = get(id);
        if (e != null) {
            em.getTransaction().begin();
            e.setOmschrijving(omschrijving);
            em.getTransaction().commit();
        }
    }

    public void updatePrijs(long id, BigDecimal prijs) {
        Advertentie e = get(id);
        if (e != null) {
            em.getTransaction().begin();
            e.setPrijs(prijs);
            em.getTransaction().commit();
        }
    }

    public void updateStatusVerwijderd(long id) {
        Advertentie e = get(id);
        if (e != null) {
            em.getTransaction().begin();
            e.setAdvertentieStatus(VERWIJDERD);
            em.getTransaction().commit();
        }
    }

    public void updateStatusInWinkelwagen(long id) {
        Advertentie e = get(id);
        if (e != null) {
            em.getTransaction().begin();
            e.setAdvertentieStatus(IN_WINKELWAGEN);
            em.getTransaction().commit();
        }
    }

    public void updateStatusBeschikbaar(long id) {
        Advertentie e = get(id);
        if (e != null) {
            em.getTransaction().begin();
            e.setAdvertentieStatus(BESCHIKBAAR);
            em.getTransaction().commit();
        }
    }

    public Advertentie get(long id) {

        return em.find(Advertentie.class, id);
    }

    public List<Advertentie> findAll() {
        TypedQuery<Advertentie> query = em.createQuery("SELECT e FROM Advertentie e ", Advertentie.class);
        return query.getResultList();
    }

    public List<Advertentie> findAllVoorGebruiker(Gebruiker abc) {
        AdvertentieStatus status = VERWIJDERD;
        TypedQuery<Advertentie> query = em.createQuery("SELECT e FROM Advertentie e WHERE e.aanbieder = :gb AND e.advertentieStatus <> :status", Advertentie.class);
        query.setParameter("gb", abc);
        query.setParameter("status", status);
        return query.getResultList();
    }

    public List<Advertentie> findAllVoorKoper(Gebruiker abc) {
        AdvertentieStatus status = VERWIJDERD;
        TypedQuery<Advertentie> query = em.createQuery("SELECT e FROM Advertentie e WHERE e.koper = :gb AND e.advertentieStatus <> :status", Advertentie.class);
        query.setParameter("gb", abc);
        query.setParameter("status", status);
        return query.getResultList();
    }

    public BigDecimal findTotaalVoorKoper(Gebruiker abc) {
        AdvertentieStatus status = IN_WINKELWAGEN;
        TypedQuery<Advertentie> query = em.createQuery("SELECT e FROM Advertentie e WHERE e.koper = :gb AND e.advertentieStatus = :status", Advertentie.class);
        query.setParameter("gb", abc);
        query.setParameter("status", status);
        List<Advertentie> winkelwagenlijst = query.getResultList();
        List<BigDecimal> prijslijst = winkelwagenlijst.stream().map(Advertentie::getPrijs).collect(Collectors.toList());
        BigDecimal totaal = prijslijst.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
        return totaal;
    }

    public List<Advertentie> findByZoekterm(Gebruiker ingelogdegebruiker, String zoekterm, AdvertentieStatus status) {
        TypedQuery<Advertentie> query = em.createQuery("select e from Advertentie e WHERE e.aanbieder <> :ingelogdegebruiker AND e.titel LIKE :firstarg AND e.advertentieStatus = :status", Advertentie.class);
        query.setParameter("ingelogdegebruiker", ingelogdegebruiker);
        query.setParameter("firstarg", "%" + zoekterm + "%");
        query.setParameter("status", status);
        return query.getResultList();

    }

}
