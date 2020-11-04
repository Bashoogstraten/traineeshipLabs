package databasesLabs.jdbc.lab1.util;

import java.io.IOException;
import java.io.InputStream;

public class Properties {

    static java.util.Properties prop = new java.util.Properties();

    static {
        try (InputStream file = Properties.class.getClassLoader().getResourceAsStream("database.properties")) {
            prop.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String get(String key) {
        return prop.getProperty(key);
    }
}
