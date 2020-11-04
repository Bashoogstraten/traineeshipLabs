package org.example.util;

import org.example.domain.Gebruiker;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class GebruikerDao {

    private final EntityManager em;

    public GebruikerDao(EntityManager em) {
        this.em = em;
    }

    public void save(Gebruiker e) {
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
    }

    public void saveAndDetach(Gebruiker e) {
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
        Gebruiker e = get(id);
        em.remove(e);
        em.getTransaction().commit();
    }

    public Gebruiker update(Gebruiker e) {
        em.getTransaction().begin();
        Gebruiker merged = em.merge(e);
        em.getTransaction().commit();
        return merged;
    }

    public Gebruiker get(long id){
        return em.find(Gebruiker.class, id);
    }

    public Gebruiker getMetGebruiker(Gebruiker e) {

        long id = e.getId();
        return em.find(Gebruiker.class, id);
    }

    public Gebruiker getMetGebruikersnaam(String username) {
        TypedQuery<Gebruiker> query = em.createQuery("SELECT e FROM Gebruiker e WHERE e.gebruikersnaam = :un", Gebruiker.class);
        query.setParameter("un", username);
        return query.getSingleResult();

    }

    public List<Gebruiker> findAll() {
        TypedQuery<Gebruiker> query = em.createQuery("SELECT e FROM Gebruiker e ", Gebruiker.class);
        return query.getResultList();
    }
}
