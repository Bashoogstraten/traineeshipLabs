package org.example.util;

import org.example.domain.Advertentie;
import org.example.domain.Gebruiker;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.List;

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

    public void saveAndDetach(Advertentie e) {
        em.getTransaction().begin();
        em.persist(e);
        em.detach(e);
        em.getTransaction().commit();
    }

    private void detach() {
        em.flush();
        em.clear();
    }

    public void delete(Advertentie e) {
        em.getTransaction().begin();
        em.remove(e);
        em.getTransaction().commit();
    }

    public Advertentie update(Advertentie e) {
        em.getTransaction().begin();
        Advertentie merged = em.merge(e);
        em.getTransaction().commit();
        return merged;
    }

    public Advertentie updateTitel(long id, String titel) {
        Advertentie e = get(id);
        if (e != null) {
            em.getTransaction().begin();
            e.setTitel(titel);
            em.getTransaction().commit();
        }
        return e;
    }

    public Advertentie updateOmschrijving(long id, String omschrijving) {
        Advertentie e = get(id);
        if (e != null) {
            em.getTransaction().begin();
            e.setOmschrijving(omschrijving);
            em.getTransaction().commit();
        }
        return e;
    }

    public Advertentie updatePrijs(long id, BigDecimal prijs) {
        Advertentie e = get(id);
        if (e != null) {
            em.getTransaction().begin();
            e.setPrijs(prijs);
            em.getTransaction().commit();
        }
        return e;
    }

    public Advertentie getMetAdvertentie(Gebruiker e){

        long id = e.getId();
        return em.find(Advertentie.class, id);
    }

    public Advertentie get(long id) {

        return em.find(Advertentie.class, id);
    }

    public List<Advertentie> findAll() {
        TypedQuery<Advertentie> query = em.createQuery("SELECT e FROM Advertentie e ", Advertentie.class);
        return query.getResultList();
    }

    public List<Advertentie> findAllVoorGebruiker(Gebruiker abc) {
        TypedQuery<Advertentie> query = em.createQuery("SELECT e FROM Advertentie e WHERE e.aanbieder = :gb", Advertentie.class);
        query.setParameter("gb", abc);
        return query.getResultList();
    }

    public List<Advertentie> findByZoekterm(Gebruiker ingelogdegebruiker, String zoekterm, AdvertentieStatus status) {
        TypedQuery<Advertentie> query = em.createQuery("select e from Advertentie e WHERE e.aanbieder <> :ingelogdegebruiker AND e.titel LIKE :firstarg AND e.advertentieStatus = :status", Advertentie.class);
        query.setParameter("ingelogdegebruiker", ingelogdegebruiker);
        query.setParameter("firstarg", "%" + zoekterm + "%");
        query.setParameter("status", status);
        return query.getResultList();
    }

}
