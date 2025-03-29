// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) {
        Connection connection = null;
        String url = "Jbdc:mariadb://localhost:3306/test";
        String user = "root";
        String password = "root";
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException) {
            e.printStackTrace();
        }
        System.out.println("Successfully connected");
        
        }
    }
