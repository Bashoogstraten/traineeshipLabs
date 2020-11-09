package org.example.domain;

import org.example.util.AdvertentieStatus;

import javax.persistence.*;
import java.math.BigDecimal;

import static org.example.Marktplaats.gebDao;

@Entity
public class Advertentie {

    @Id
    @GeneratedValue
    private long id;

    private String titel;
    private String omschrijving;
    private BigDecimal prijs;

    @ManyToOne
    private Gebruiker aanbieder;

    @ManyToOne
    private Gebruiker koper;

    @Enumerated(value = EnumType.STRING)
    private AdvertentieStatus advertentieStatus;

    public Advertentie() {
    }

    public Advertentie(String titel, String omschrijving, Gebruiker aanbieder, BigDecimal prijs, AdvertentieStatus status) {

        this.titel = titel;
        this.omschrijving = omschrijving;
        this.aanbieder = aanbieder;
        this.prijs = prijs;
        this.advertentieStatus = status;
    }

    public long getId() {
        return id;
    }

    public String getTitel() {
        return this.titel;
    }

    public String getOmschrijving() {
        return this.omschrijving;
    }

    public BigDecimal getPrijs() {
        return this.prijs;
    }

    public AdvertentieStatus getAdvertentieStatus() {
        return this.advertentieStatus;
    }

    public Gebruiker getAanbieder() {
        return this.aanbieder;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }

    public void setPrijs(BigDecimal prijs) {
        this.prijs = prijs;
    }

    public void setAdvertentieStatus(AdvertentieStatus status) {
        this.advertentieStatus = status;
    }

    public void setKoper(Gebruiker koper) {
        this.koper = koper;
    }

    public void verwijderAdvertentieUitWinkelwagen(Gebruiker koper) {
        this.setAdvertentieStatus(AdvertentieStatus.VERKOCHT);
        gebDao.verwijderUitWinkelwagen(this,koper);
        gebDao.update(koper);
    }

    @Override
    public String toString() {
        return "Advertentie {" +
                "id = " + id +
                ", titel = '" + titel + '\'' +
                ", omschrijving = '" + omschrijving + '\'' +
                ", prijs = " + prijs +
                ", advertentieStatus= " + advertentieStatus +
                '}';
    }
}
