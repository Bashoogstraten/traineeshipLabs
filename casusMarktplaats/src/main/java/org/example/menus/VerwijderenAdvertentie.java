package org.example.menus;

import org.example.domain.Advertentie;
import org.example.domain.Gebruiker;

import static org.example.Marktplaats.*;

public class VerwijderenAdvertentie {

    public void start(Gebruiker ingelogdeGebruiker) {
        while (true) {
            System.out.println("---------------------------------------------------------------------");
            System.out.println("********************** " + getClass().getSimpleName() + " *************************");
            System.out.println("---------------------------------------------------------------------");
            System.out.println("Geef de ID van de advertentie die u wilt verwijderen: ");
            System.out.println("---------------------------------------------------------------------");
            String idString = readLine();
            long idLong = Long.parseLong(idString);
            Advertentie verwijderAdvertentie = adDao.get(idLong);
            System.out.println("Dit is de advertentie die u geselecteerd heeft om te verwijderen: ");
            System.out.println(verwijderAdvertentie.toString());
            System.out.println("---------------------------------------------------------------------");
            System.out.println("Weet u zeker dat u deze advertentie wilt verwijderen?");
            System.out.println("(1) [Ja, verwijder]" );
            System.out.println("(2) [Nee, terug naar vorige menu]");
            System.out.println("---------------------------------------------------------------------");

            switch (readLine()) {
                case "1":
                    adDao.updateStatusVerwijderd(idLong);
                    gebDao.update(ingelogdeGebruiker);
                    return;
                case "2":
                    return;
                default:
                    System.out.println("Ongeldige keuze; probeer opnieuw.");
            }
        }
    }
}
