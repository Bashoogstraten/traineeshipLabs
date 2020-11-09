package org.example.menus;

import org.example.domain.Advertentie;
import org.example.domain.Gebruiker;

import java.math.BigDecimal;
import java.util.Scanner;

import static org.example.Marktplaats.*;

public class BijwerkenAdvertentie {

    public void start(Gebruiker ingelogdeGebruiker, Advertentie bijwerkAdvertentie) {
        while (true) {
            System.out.println("---------------------------------------------------------------------");
            System.out.println("********************** " + getClass().getSimpleName() + " *************************");
            System.out.println("Wat wilt u doen?");
            System.out.println("(1) [Advertentie titel bijwerken]");
            System.out.println("(2) [Advertentie omschrijving bijwerken]");
            System.out.println("(3) [Advertentie prijs bijwerken]");
            System.out.println("(4) [Terug]");
            System.out.println("---------------------------------------------------------------------");

            switch (readLine()) {
                case "1":
                    bijwerkenAdvertentieTitel(ingelogdeGebruiker, bijwerkAdvertentie);
                    break;
                case "2":
                    bijwerkenAdvertentieOmschrijving(ingelogdeGebruiker,bijwerkAdvertentie);
                    break;
                case "3":
                    bijwerkenAdvertentiePrijs(ingelogdeGebruiker,bijwerkAdvertentie);
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Ongeldige keuze; probeer opnieuw.");
            }
        }
    }

    public void bijwerkenAdvertentieTitel(Gebruiker ingelogdeGebruiker, Advertentie bijwerkAdvertentie) throws IllegalArgumentException {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("---------------------------------------------------------------------");
            System.out.println("Geef de nieuwe titel voor uw advertentie: ");
            System.out.println("---------------------------------------------------------------------");
            String titel = scanner.nextLine();

            long id = bijwerkAdvertentie.getId();
            adDao.updateTitel(id, titel);

            gebDao.update(ingelogdeGebruiker);

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public void bijwerkenAdvertentieOmschrijving(Gebruiker ingelogdeGebruiker, Advertentie bijwerkAdvertentie) throws IllegalArgumentException {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("---------------------------------------------------------------------");
            System.out.println("Geef de nieuwe omschrijving voor uw advertentie: ");
            System.out.println("---------------------------------------------------------------------");
            String omschrijving = scanner.nextLine();

            long id = bijwerkAdvertentie.getId();
            adDao.updateOmschrijving(id, omschrijving);

            gebDao.update(ingelogdeGebruiker);

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public void bijwerkenAdvertentiePrijs(Gebruiker ingelogdeGebruiker, Advertentie bijwerkAdvertentie) throws IllegalArgumentException {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("---------------------------------------------------------------------");
            System.out.println("Geef de nieuwe prijs voor uw advertentie: ");
            System.out.println("---------------------------------------------------------------------");
            String prijsString = scanner.nextLine();
            BigDecimal prijs = new BigDecimal(prijsString);

            long id = bijwerkAdvertentie.getId();
            adDao.updatePrijs(id, prijs);

            gebDao.update(ingelogdeGebruiker);

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
