package org.example.menus;

import org.example.domain.Gebruiker;

import java.util.Scanner;

import static org.example.Marktplaats.gebDao;
import static org.example.util.GebruikerStatus.ACTIEF;

public class AanmakenGebruiker {

    public void start() throws IllegalArgumentException{
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("---------------------------------------------------------------------");
            System.out.println("Kies een gebruikersnaam: ");
            System.out.println("---------------------------------------------------------------------");
            String gebruikersnaam = scanner.nextLine();
            System.out.println("---------------------------------------------------------------------");
            System.out.println("Kies een wachtwoord: ");
            System.out.println("---------------------------------------------------------------------");
            String wachtwoord = scanner.nextLine();

            Gebruiker geb = new Gebruiker(gebruikersnaam, wachtwoord, ACTIEF);
            gebDao.save(geb);
            System.out.println("---------------------------------------------------------------------");
            System.out.println("Je account is succesvol geregistreerd.");

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

    }
}
