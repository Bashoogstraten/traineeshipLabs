package databasesLabs.jdbc.lab1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StartRefactored {

    private final Logger log = LoggerFactory.getLogger(StartRefactored.class);
    private final TitlesDao dao = new TitlesDao();

    public static void main(String[] args) {
        new StartRefactored().start();
    }

    private void start() {
        dao.findAllTitles().forEach(p -> log.debug(p.toString()));
    }
}
