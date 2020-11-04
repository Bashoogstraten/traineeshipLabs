package org.example;

import org.example.domain.Advertentie;
import org.example.domain.Gebruiker;
import org.example.util.GebruikerDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.Scanner;

import static org.example.util.AdvertentieStatus.BESCHIKBAAR;

public class Marktplaats {

//    private final Logger log = LoggerFactory.getLogger(Marktplaats.class);

    public static final EntityManager em = Persistence.createEntityManagerFactory("MySQL").createEntityManager();
    public static final GebruikerDao gebDao = new GebruikerDao(em);
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        new Voorprogrammeren().start();
        new Hoofdmenu().start();


//        start.aanmakenAdvertentie(start.f);

    }
    public static String readLine() { return scanner.nextLine(); }
    public static long readLong() { return scanner.nextLong();}


    private void aanmakenAdvertentie(Gebruiker abc) throws IllegalArgumentException{

        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Geef een titel voor uw advertentie: ");
            String titel = scanner.nextLine();
            System.out.println("Geef een (korte) omschrijving voor uw advertentie: ");
            String omschrijving = scanner.nextLine();
            System.out.println("Geef een prijs voor uw advertentie: ");
            BigDecimal prijs = scanner.nextBigDecimal();


            Advertentie nieuw = new Advertentie(titel, omschrijving, abc, prijs , BESCHIKBAAR);
            abc.voegBestaandeAdvertentieToe(nieuw);

            gebDao.update(abc);

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

    }

//    private void log(Object o) {
//        log.debug(o.toString());
//    }
}
