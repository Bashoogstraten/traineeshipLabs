package org.example.menus;

import org.example.domain.Advertentie;
import org.example.domain.Gebruiker;

import java.math.BigDecimal;

import static org.example.Marktplaats.*;

public class WinkelwagenMenu {

    public void start(Gebruiker ingelogdeGebruiker) {
        while (true) {
            System.out.println("---------------------------------------------------------------------");
            System.out.println("************************* " + getClass().getSimpleName() + " ***************************");
            System.out.println("Wat wilt u doen?");
            System.out.println("(1) [Mijn winkelwagen inzien]");
            System.out.println("(2) [Een advertentie aan mijn winkelwagen toevoegen]");
            System.out.println("(3) [Een advertentie uit mijn winkelwagen verwijderen]");
            System.out.println("(4) [Winkelwagen bestellen]");
            System.out.println("(5) [Terug]");
            System.out.println("---------------------------------------------------------------------");

            switch (readLine()) {
                case "1":
                    System.out.println("---------------------------------------------------------------------");
                    if (adDao.findAllVoorKoper(ingelogdeGebruiker).size() == 0) {
                        System.out.println("Uw winkelwagen is momenteel leeg.");
                    } else {
                        System.out.println("De volgende advertenties bevinden zich momenteel in uw winkelwagen: ");
                        System.out.println("---------------------------------------------------------------------");
                        adDao.findAllVoorKoper(ingelogdeGebruiker).forEach(e -> System.out.println("\t" + e));
                        BigDecimal totaal = adDao.findTotaalVoorKoper(ingelogdeGebruiker);
                        System.out.println("---------------------------------------------------------------------");
                        System.out.println("Het totaalbedrag van uw winkelwagen is momenteel: " + totaal + " euro.");
                    }
                    break;
                case "2":
                    toevoegenAdvertentieWinkelwagen(ingelogdeGebruiker);
                    break;
                case "3":
                    verwijderenAdvertentieWinkelwagen(ingelogdeGebruiker);
                    break;
                case "4":
                    new BestellenWinkelwagen().start(ingelogdeGebruiker);
                    break;
                case "5":
                    return;
                default:
                    System.out.println("Ongeldige keuze; probeer opnieuw.");
            }
        }
    }

    public void toevoegenAdvertentieWinkelwagen(Gebruiker ingelogdeGebruiker) throws IllegalArgumentException {
        try {
            System.out.println("---------------------------------------------------------------------");
            System.out.println("Geef de ID van de advertentie die u aan uw winkelwagen wilt toevoegen: ");
            System.out.println("---------------------------------------------------------------------");
            String idString = readLine();
            long idLong = Long.parseLong(idString);
            Advertentie toevoegAdvertentie = adDao.get(idLong);
            gebDao.voegToeAanWinkelwagen(toevoegAdvertentie, ingelogdeGebruiker);
            adDao.updateStatusInWinkelwagen(idLong);
            gebDao.update(ingelogdeGebruiker);
            System.out.println("---------------------------------------------------------------------");
            System.out.println("De advertentie is aan uw winkelwagen toegevoegd.");
            System.out.println("Uw winkelwageninhoud is nu: ");
            System.out.println("---------------------------------------------------------------------");
            adDao.findAllVoorKoper(ingelogdeGebruiker).forEach(e -> System.out.println("\t" + e));

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public void verwijderenAdvertentieWinkelwagen(Gebruiker ingelogdeGebruiker) throws IllegalArgumentException {
        try {
            System.out.println("---------------------------------------------------------------------");
            System.out.println("Geef de ID van de advertentie die u uit uw winkelwagen wilt verwijderen: ");
            System.out.println("---------------------------------------------------------------------");
            String idString = readLine();
            long idLong = Long.parseLong(idString);
            Advertentie verwijderAdvertentie = adDao.get(idLong);
            gebDao.verwijderUitWinkelwagen(verwijderAdvertentie, ingelogdeGebruiker);
            adDao.updateStatusBeschikbaar(idLong);
            gebDao.update(ingelogdeGebruiker);
            System.out.println("---------------------------------------------------------------------");
            System.out.println("De advertentie is uit uw winkelwagen verwijderd.");
            System.out.println();
            if (adDao.findAllVoorKoper(ingelogdeGebruiker).size() == 0) {
                System.out.println("Uw winkelwagen is nu leeg.");
            } else {
                System.out.println("Uw winkelwageninhoud is nu: ");
                adDao.findAllVoorKoper(ingelogdeGebruiker).forEach(e -> System.out.println("\t" + e));
            }
            System.out.println("---------------------------------------------------------------------");

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
