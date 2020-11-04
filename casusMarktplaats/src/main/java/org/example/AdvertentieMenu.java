package org.example;

import org.example.domain.Advertentie;
import org.example.domain.Gebruiker;

import java.math.BigDecimal;
import java.util.Scanner;

import static org.example.Marktplaats.gebDao;
import static org.example.Marktplaats.readLine;
import static org.example.util.AdvertentieStatus.BESCHIKBAAR;

public class AdvertentieMenu {

    public void start(Gebruiker ingelogdeGebruiker) {
        while (true) {
            System.out.println("********* " + getClass().getSimpleName() + " *********");
            System.out.println("Wat wilt u doen?");
            System.out.println("(1) [Advertentie aanmaken]");
            System.out.println("(2) [Naar mijn persoonlijke advertentieoverzicht]");
            System.out.println("(3) [Terug]");

            switch (readLine()) {
                case "1":
                    aanmakenAdvertentie(ingelogdeGebruiker);
                    break;
                case "2":
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Ongeldige keuze; probeer opnieuw.");
            }
        }
    }

    public void aanmakenAdvertentie(Gebruiker ingelogdeGebruiker) throws IllegalArgumentException {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Geef een titel voor uw advertentie: ");
            String titel = scanner.nextLine();
            System.out.println("Geef een (korte) omschrijving voor uw advertentie: ");
            String omschrijving = scanner.nextLine();
            System.out.println("Geef een prijs voor uw advertentie: ");
            BigDecimal prijs = scanner.nextBigDecimal();

            Advertentie nieuw = new Advertentie(titel, omschrijving, ingelogdeGebruiker, prijs, BESCHIKBAAR);
            ingelogdeGebruiker.voegBestaandeAdvertentieToe(nieuw);

            gebDao.update(ingelogdeGebruiker);

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
