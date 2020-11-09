package org.example.util;

import org.example.domain.Advertentie;
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

    public Gebruiker update(Gebruiker e) {
        em.getTransaction().begin();
        Gebruiker merged = em.merge(e);
        em.getTransaction().commit();
        return merged;
    }

    public Gebruiker get(long id){
        return em.find(Gebruiker.class, id);
    }

    public Gebruiker getMetGebruikersnaam(String username) {
        TypedQuery<Gebruiker> query = em.createQuery("SELECT e FROM Gebruiker e WHERE e.gebruikersnaam = :un", Gebruiker.class);
        query.setParameter("un", username);
        return query.getSingleResult();

    }

    public void voegToeAanWinkelwagen(Advertentie a, Gebruiker koper) {
        Gebruiker aanbieder = a.getAanbieder();
        koper.voegBestaandeAdvertentieToeAanWinkelwagen(a);
        update(aanbieder);
        update(koper);
    }

    public void verwijderUitWinkelwagen(Advertentie a, Gebruiker koper) {
        Gebruiker aanbieder = a.getAanbieder();
        koper.verwijderBestaandeAdvertentieUitWinkelwagen(a);
        update(aanbieder);
        update(koper);
    }
}
