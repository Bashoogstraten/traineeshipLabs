package org.example;

import org.example.domain.Gebruiker;
import org.example.util.GebruikerStatus;

import java.util.Scanner;

import static org.example.Marktplaats.gebDao;
import static org.example.util.GebruikerStatus.ACTIEF;

public class AanmakenGebruiker {

    public void start() throws IllegalArgumentException{
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Kies een gebruikersnaam: ");
            String gebruikersnaam = scanner.nextLine();
            System.out.println("Kies een wachtwoord: ");
            String wachtwoord = scanner.nextLine();

            Gebruiker geb = new Gebruiker(gebruikersnaam, wachtwoord, ACTIEF);
            gebDao.save(geb);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

    }
}
