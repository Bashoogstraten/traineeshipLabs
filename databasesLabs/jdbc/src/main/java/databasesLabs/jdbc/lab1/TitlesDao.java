package databasesLabs.jdbc.lab1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static databasesLabs.jdbc.lab1.util.Properties.get;

public class TitlesDao {

    private final Logger log = LoggerFactory.getLogger(TitlesDao.class);

    public List<Titles>findAllTitles() {
        try (Connection connection = DriverManager.getConnection(get("url"), get("username"), get("password"));
             Statement statement = connection.createStatement()) {
            List<Titles> titles = new ArrayList<>();

            ResultSet resultSet = statement.executeQuery("select TITLE_ID, title, price from titles");

            while (resultSet.next()) {
                String TITLE_ID = resultSet.getString(1);
                String title = resultSet.getString(2);
                String price = resultSet.getString(3);

                Titles p = new Titles(TITLE_ID, title, price);
                titles.add(p);
            }

            return titles;
        } catch (SQLException e) {
            log.error("", e);
            e.printStackTrace();
            return null;
        }

    }




}
