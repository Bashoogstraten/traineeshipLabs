package org.example.domain;

import org.example.util.AdvertentieStatus;
import org.example.util.GebruikerStatus;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import static javax.persistence.CascadeType.*;

@Entity
public class Gebruiker extends AbstracteGebruiker {

    private String gebruikersnaam;
    private String wachtwoord;

    @Enumerated(value = EnumType.STRING)
    private GebruikerStatus status;

    @OneToMany(mappedBy = "aanbieder", cascade = {PERSIST, MERGE, REMOVE})
    private List<Advertentie> advertenties = new LinkedList<>();

//    private List<Advertentie> winkelwagen = new LinkedList<>();

    public Gebruiker() {
    }

    public Gebruiker(String username, String password, GebruikerStatus status) {

        this.gebruikersnaam = username;
        this.wachtwoord = password;
        this.status = status;
    }

    public long getId() {

        return id;
    }

    public String getGebruikersnaam() {

        return this.gebruikersnaam;
    }

    public String getWachtwoord() {

        return wachtwoord;
    }

    public List<Advertentie> getAdvertenties() {
        return advertenties;
    }

    public void nieuweAdvertentie(String titel, String omschrijving, Gebruiker gebruiker, BigDecimal prijs) {

        Advertentie a = new Advertentie(titel, omschrijving, gebruiker, prijs, AdvertentieStatus.BESCHIKBAAR);
        this.advertenties.add(a);

    }

    public void voegBestaandeAdvertentieToe(Advertentie a) {
        this.advertenties.add(a);
    }

    public void verwijderAdvertentie(Advertentie a) {
        this.advertenties.remove(a);
        a.setAanbieder(null);
    }

}
