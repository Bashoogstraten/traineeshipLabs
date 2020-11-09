package org.example.domain;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.example.util.AdvertentieStatus;
import org.example.util.GebruikerStatus;

import javax.persistence.*;
import java.math.BigDecimal;

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

    public String getTitel() { return this.titel; }

    public String getOmschrijving() { return this.omschrijving; }

    public BigDecimal getPrijs() { return this.prijs; }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }

    public void setPrijs(BigDecimal prijs) {
        this.prijs = prijs;
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

    public void setAanbieder(Gebruiker aanbieder) {
        this.aanbieder = aanbieder;
    }
}