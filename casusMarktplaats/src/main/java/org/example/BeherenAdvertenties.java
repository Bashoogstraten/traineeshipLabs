package org.example;

import org.example.domain.Advertentie;
import org.example.domain.Gebruiker;

import static org.example.Marktplaats.adDao;
import static org.example.Marktplaats.readLine;

public class BeherenAdvertenties {

    public void start(Gebruiker ingelogdeGebruiker) {
        while (true) {
            System.out.println("---------------------------------------------------------------------");
            System.out.println("*********************** " + getClass().getSimpleName() + " *************************");
            System.out.println("Wat wilt u doen?");
            System.out.println("(1) [Mijn geplaatste advertenties inzien]");
            System.out.println("(2) [Advertentie bijwerken]");
            System.out.println("(3) [Advertentie verwijderen]");
            System.out.println("(4) [Terug]");
            System.out.println("---------------------------------------------------------------------");

            switch (readLine()) {
                case "1":
                    System.out.println("---------------------------------------------------------------------");
                    adDao.findAllVoorGebruiker(ingelogdeGebruiker).forEach(e -> System.out.println("\t" + e));
                    break;
                case "2":
                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("Geef de ID van de advertentie die u wilt bijwerken: ");
                    System.out.println("---------------------------------------------------------------------");
                    String idString = readLine();
                    long idLong = Long.parseLong(idString);
                    Advertentie bijwerkAdvertentie = adDao.get(idLong);
                    new BijwerkenAdvertentie().start(ingelogdeGebruiker, bijwerkAdvertentie);
                    break;
                case "3":
                    new VerwijderenAdvertentie().start(ingelogdeGebruiker);
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Ongeldige keuze; probeer opnieuw.");
            }
        }
    }

}
