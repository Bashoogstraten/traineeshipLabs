package org.example;

import org.example.domain.Advertentie;
import org.example.domain.Gebruiker;
import org.example.util.AdvertentieStatus;

import java.math.BigDecimal;
import java.util.Scanner;

import static org.example.Marktplaats.*;
import static org.example.util.AdvertentieStatus.BESCHIKBAAR;

public class AdvertentieMenu {

    public void start(Gebruiker ingelogdeGebruiker) {
        while (true) {
            System.out.println("---------------------------------------------------------------------");
            System.out.println("************************* " + getClass().getSimpleName() + " ***************************");
            System.out.println("Wat wilt u doen?");
            System.out.println("(1) [Advertentie aanmaken]");
            System.out.println("(2) [Mijn advertenties beheren]");
            System.out.println("(3) [Zoeken op advertenties]");
            System.out.println("(4) [Terug]");
            System.out.println("---------------------------------------------------------------------");

            switch (readLine()) {
                case "1":
                    aanmakenAdvertentie(ingelogdeGebruiker);
                    break;
                case "2":
                    new BeherenAdvertenties().start(ingelogdeGebruiker);
                    break;
                case "3":
                    zoekenAdvertenties(ingelogdeGebruiker);
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Ongeldige keuze; probeer opnieuw.");
            }
        }
    }

    public void aanmakenAdvertentie(Gebruiker ingelogdeGebruiker) throws IllegalArgumentException {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("---------------------------------------------------------------------");
            System.out.println("Geef een titel voor uw advertentie: ");
            System.out.println("---------------------------------------------------------------------");
            String titel = scanner.nextLine();
            System.out.println("---------------------------------------------------------------------");
            System.out.println("Geef een (korte) omschrijving voor uw advertentie: ");
            System.out.println("---------------------------------------------------------------------");
            String omschrijving = scanner.nextLine();
            System.out.println("---------------------------------------------------------------------");
            System.out.println("Geef een prijs voor uw advertentie: ");
            System.out.println("---------------------------------------------------------------------");
            BigDecimal prijs = scanner.nextBigDecimal();

            Advertentie nieuw = new Advertentie(titel, omschrijving, ingelogdeGebruiker, prijs, BESCHIKBAAR);
            ingelogdeGebruiker.voegBestaandeAdvertentieToe(nieuw);

            gebDao.update(ingelogdeGebruiker);

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public void zoekenAdvertenties(Gebruiker ingelogdeGebruiker) throws IllegalArgumentException {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("---------------------------------------------------------------------");
            System.out.println("Geef een zoekterm op: ");
            System.out.println("---------------------------------------------------------------------");
            String zoekterm = scanner.nextLine();
            System.out.println("---------------------------------------------------------------------");
            System.out.println("Uw zoekterm heeft de volgende resultaten opgeleverd: ");
            System.out.println("---------------------------------------------------------------------");
            adDao.findByZoekterm(ingelogdeGebruiker, zoekterm, BESCHIKBAAR).forEach(e -> System.out.println("\t" + e));

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
