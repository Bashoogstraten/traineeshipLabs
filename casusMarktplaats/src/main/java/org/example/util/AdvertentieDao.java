package org.example.util;

import org.example.domain.Advertentie;
import org.example.domain.Gebruiker;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
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

    public void delete(long id) {
        em.getTransaction().begin();
        Advertentie e = get(id);
        em.remove(e);
        em.getTransaction().commit();
    }

    public Advertentie update(Advertentie e) {
        em.getTransaction().begin();
        Advertentie merged = em.merge(e);
        em.getTransaction().commit();
        return merged;
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
}
