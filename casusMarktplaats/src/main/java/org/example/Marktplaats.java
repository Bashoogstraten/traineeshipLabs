package org.example;

import org.example.util.AdvertentieDao;
import org.example.util.GebruikerDao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.Scanner;

public class Marktplaats {

//    private final Logger log = LoggerFactory.getLogger(Marktplaats.class);

    public static final EntityManager em = Persistence.createEntityManagerFactory("MySQL").createEntityManager();
    public static final GebruikerDao gebDao = new GebruikerDao(em);
    public static final AdvertentieDao adDao = new AdvertentieDao(em);
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        new Voorprogrammeren().start();
        new InlogMenu().start();

    }

    public static String readLine() {
        return scanner.nextLine();
    }
    public static long readLong() { return scanner.nextLong(); }

//    private void log(Object o) {
//        log.debug(o.toString());
//    }
}
