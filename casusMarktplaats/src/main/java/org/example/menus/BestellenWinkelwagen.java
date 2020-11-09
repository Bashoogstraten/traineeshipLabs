package org.example.menus;

import org.example.domain.Gebruiker;
import org.example.util.AdvertentieStatus;
import org.example.util.GebruikerDao;

import java.math.BigDecimal;

import static org.example.Marktplaats.*;

public class BestellenWinkelwagen {

    public void start(Gebruiker ingelogdeGebruiker) {

        while (true) {
            int aantalAdvertenties = adDao.findAllVoorKoper(ingelogdeGebruiker).size();
            BigDecimal totaal = adDao.findTotaalVoorKoper(ingelogdeGebruiker);

            System.out.println("---------------------------------------------------------------------");
            System.out.println("U heeft momenteel [" + aantalAdvertenties + "] advertenties, voor een totaalbedrag van [" + totaal + "] euro in uw winkelwagen. ");
            System.out.println("---------------------------------------------------------------------");
            System.out.println("Wilt u verdergaan met bestellen?");
            System.out.println("(1) [Ja, verdergaan met bestellen]");
            System.out.println("(2) [Nee, terug]");
            System.out.println("---------------------------------------------------------------------");

            switch (readLine()) {
                case "1":
                    adDao.findAllVoorKoper(ingelogdeGebruiker).forEach(e -> e.setAdvertentieStatus(AdvertentieStatus.VERKOCHT));
                    adDao.findAllVoorKoper(ingelogdeGebruiker).forEach(e -> e.verwijderAdvertentieUitWinkelwagen(ingelogdeGebruiker));
                    gebDao.update(ingelogdeGebruiker);
                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("U heeft de inhoud van uw winkelwagen succesvol besteld.");
                    System.out.println("Wij houden u op de hoogte van de status van uw bestelling.");
                    return;
                case "2":
                    return;
                default:
                    System.out.println("Ongeldige keuze; probeer opnieuw.");
            }
        }
    }
}
