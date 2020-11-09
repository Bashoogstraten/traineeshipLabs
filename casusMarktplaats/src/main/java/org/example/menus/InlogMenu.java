package org.example.menus;

import org.example.domain.Gebruiker;

import javax.persistence.NoResultException;

import static org.example.Marktplaats.readLine;

public class InlogMenu {

    public void start() {
        while (true) {

            System.out.println("---------------------------------------------------------------------");
            System.out.println("Welkom op ReCyclist, het platform voor 2ehands fietsen en accesoires!");
            System.out.println("---------------------------------------------------------------------");
            System.out.println("Wat wil je doen?");
            System.out.println("---------------------------------------------------------------------");
            System.out.println("(1) [Inloggen] ");
            System.out.println("(2) [Account aanmaken] ");
            System.out.println("---------------------------------------------------------------------");

            try {
                switch (readLine()) {
                    case "1":
                        Gebruiker ingelogdeGebruiker = new InloggenGebruiker().start();
                        new HoofdMenu().start(ingelogdeGebruiker);
                        break;
                    case "2":
                        new AanmakenGebruiker().start();
                        break;
                    default:
                        System.out.println("Ongeldige keuze; probeer opnieuw.");
                        break;
                }

            } catch (NumberFormatException e) {
                System.out.println("Dit is ongeldige invoer. Probeer het opnieuw.");
            } catch (NoResultException e) {
                System.out.println("---------------------------------------------------------------------");
                System.out.println("Dit is geen geregistreerde gebruikersnaam. Probeer het opnieuw.");
            } catch (RuntimeException t) {
                System.out.println("Er ging iets mis... Probeer het opnieuw. ");
                System.out.println("Foutmelding: " + t.getMessage());
            } catch (Exception e) {
                System.out.println("Er ging iets vreselijk mis... ");
                System.out.println("Foutmelding: " + e.getMessage());
                System.out.println("Neem contact op met de leverancier.");
                System.out.println("Tot ziens.");
            }

        }

    }
}
