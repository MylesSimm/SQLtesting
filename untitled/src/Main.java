// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static javax.swing.DropMode.INSERT;

public class Main {
    private static Connection connection;
    public static void main(String[] args) throws SQLException {
        try {
            openDatabaseConnection();
            createData("Java", 10);
        } finally {
            closeDatabaseConnection();
        }
    }
    private static void openDatabaseConnection() throws SQLException {
        String url = "jdbc:mariadb://localhost:3306/sys";
        String user = "root";
        String password = "....";
        System.out.println("Connecting to Database...");
        connection = DriverManager.getConnection(url, user, password);
        System.out.println("Connection valid: " + connection.isValid(5));

    }

    public static void closeDatabaseConnection() throws SQLException {
        System.out.println("Closing database connection...");
        connection.close();
        System.out.println("Connection valid: " + connection.isValid(5));
    }

    private static void createData(String name, int rating) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("""
                       INSERT INTO programing_language(name, rating)
                       VALUES (?, ?)
                       """);
        statement.setString(1, name);
        statement.setInt(2, rating);
        int rowsInserted = statement.executeUpdate();
        System.out.println("Rows inserted: " + rowsInserted);
    }
    private static void searchData(String select, String from, String where) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("""
                        SELECT select
                        FROM from
                        WHERE where;
                                                                  """);
        ResultSet rs = statement.excuteQuery(); 
    }
    }
