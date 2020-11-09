package org.example.menus;

import org.example.domain.Gebruiker;

import java.util.Scanner;

import static org.example.Marktplaats.gebDao;
import static org.example.Marktplaats.readLine;

public class InloggenGebruiker {

    public Gebruiker start() throws IllegalArgumentException {
        try {
            while (true) {
                Scanner scanner = new Scanner(System.in);

                System.out.println("---------------------------------------------------------------------");
                System.out.println("Voer om in te loggen uw gebruikersnaam in: ");
                System.out.println("---------------------------------------------------------------------");
                String bestaandeGebruikersnaam = readLine();

                Gebruiker inloggendeGebruiker = gebDao.getMetGebruikersnaam(bestaandeGebruikersnaam);

                System.out.println("---------------------------------------------------------------------");
                System.out.println("Voer nu uw wachtwoord in: ");
                System.out.println("---------------------------------------------------------------------");
                String ingevoerdWachtwoord = readLine();

                if (ingevoerdWachtwoord.equals(inloggendeGebruiker.getWachtwoord())) {
                    return gebDao.getMetGebruikersnaam(bestaandeGebruikersnaam);
                } else {
                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("Dit wachtwoord is onjuist, probeer het opnieuw.");
                }
            }

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return null;
    }
}
