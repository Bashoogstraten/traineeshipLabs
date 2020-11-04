package databasesLabs.jdbc.lab1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

import static databasesLabs.jdbc.lab1.util.Properties.get;

public class Start {

    Logger log = LoggerFactory.getLogger(Start.class);

    public static void main(String[] args) {

        new Start().run();

    }

    public void run() {
        try (Connection connection = DriverManager.getConnection(get("url") , get("username"), get("password"));
             Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {

            Start demostart = new Start();

            //demostart.insertTransactional(connection, statement);
            //demostart.insertPreparedStatement(connection, "BS0002", "Cooking Meth 4 Dummies", "79.99");
            //demostart.deletePreparedStatement(connection, "BU8956");
            demostart.insertPreparedStatement(connection, "BS0003", "Catcher in the Rye", "14.99");
            demostart.showAllRows(statement);

        } catch (SQLException e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
    }

    private void showAllRows(Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery("select TITLE_ID, title, price from titles");

        while (resultSet.next()) {
            String TITLE_ID = resultSet.getString(1);
            String title = resultSet.getString(2);
            String price = resultSet.getString(3);

            log.debug(TITLE_ID + ", " + title + ", " + price);
        }

        ResultSetMetaData metaData = resultSet.getMetaData();
        String catalogName = metaData.getCatalogName(1);
        String columnName = metaData.getColumnName(1);
        log.debug("catalogName=" + catalogName);
        log.debug("columnName=" + columnName);
    }

    private void insertTransactional(Connection connection, Statement statement) throws SQLException {
        try {
            connection.setAutoCommit(false);

            statement.executeUpdate("INSERT INTO titles (TITLE_ID, title, price) VALUES ('BS0000', 'De geschiedenis van Bas', '19.50');");

            connection.commit();

        } catch (SQLException e) {
            log.error("Er gaat iets mis in SQL..." + e.getMessage());
            connection.rollback();
        }
    }

    private void insertPreparedStatement(Connection connection, String TITLE_ID, String title, String price) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO titles (TITLE_ID, title, price) VALUES (?,?,?)");
        preparedStatement.setString(1, TITLE_ID);
        preparedStatement.setString(2, title);
        preparedStatement.setString(3, price);

        preparedStatement.executeUpdate();

    }

    private void deletePreparedStatement(Connection connection, String TITLE_ID) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM titles where TITLE_ID=?");
        preparedStatement.setString(1, TITLE_ID);

        preparedStatement.executeUpdate();

    }

}
