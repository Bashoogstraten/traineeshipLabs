package org.example.menus;

import org.example.domain.Gebruiker;

import javax.persistence.NoResultException;

import static org.example.Marktplaats.readLine;

public class HoofdMenu {

    public void start(Gebruiker ingelogdeGebruiker) {
        while (true) {

            System.out.println("---------------------------------------------------------------------");
            System.out.println("Welkom terug " + ingelogdeGebruiker.getGebruikersnaam() + ". ");
            System.out.println("---------------------------------------------------------------------");
            System.out.println("Waar wilt u naartoe navigeren?");
            System.out.println("---------------------------------------------------------------------");
            System.out.println("(1) [Advertenties]");
            System.out.println("(2) [Winkelwagen]");
            System.out.println("(3) [Uitloggen]");
            System.out.println("---------------------------------------------------------------------");

            try {
                switch (readLine()) {
                    case "1":
                        new AdvertentieMenu().start(ingelogdeGebruiker);
                        break;
                    case "2":
                        new WinkelwagenMenu().start(ingelogdeGebruiker);
                        break;
                    case "3":
                        return;
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
