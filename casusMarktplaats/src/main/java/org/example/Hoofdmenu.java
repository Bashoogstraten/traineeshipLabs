package org.example;

import org.example.domain.Gebruiker;

import javax.persistence.NoResultException;

import static org.example.Marktplaats.gebDao;
import static org.example.Marktplaats.readLine;

public class Hoofdmenu {

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
                        break;
                    case "2":
                        new AanmakenGebruiker().start();
                        System.out.println("Je account is succesvol geregistreerd.");
                        break;
                    default:
                        System.out.println("Ongeldige keuze; probeer opnieuw.");
                        break;
                }

                System.out.println("-------------------------------------------");
                System.out.println("Voer om in te loggen uw gebruikersnaam in: ");
                System.out.println("-------------------------------------------");
                String bekendenaam = readLine();
                Gebruiker bekend = gebDao.getMetGebruikersnaam(bekendenaam);
                System.out.println("-------------------------------------------------");
                System.out.println("Welkom terug " + bekend.getGebruikersnaam() + ". ");
                System.out.println("-------------------------------------------------");
                System.out.println("Waar wilt u naartoe navigeren?");
                System.out.println("-------------------------------------------------");
                System.out.println("(1) [Advertenties]");
                System.out.println("-------------------------------------------------");

                switch (readLine()) {
                    case "1":
                        new AdvertentieMenu().start(bekend);
                        break;
                    case "2":
                        new AanmakenGebruiker().start();
                        System.out.println("Je account is succesvol geregistreerd.");
                        break;
                    default:
                        System.out.println("Ongeldige keuze; probeer opnieuw.");
                        break;
                }

            } catch (NumberFormatException e) {
                System.out.println("Dit is ongeldige invoer. Probeer het opnieuw.");
            } catch (NoResultException e) {
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
