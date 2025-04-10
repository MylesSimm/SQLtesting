import java.sql.*;


public class pets {
    private static Connection connection;
    public static void main(String[] args) throws SQLException{
        try {
            openDatabaseConnection();
            query1();
            query2();
            query3();
            query4();
            closeDatabaseConnection();
        }
        finally {

        }
    }

    private static void openDatabaseConnection() throws SQLException {
        String url = "jdbc:mariadb://localhost:3306/pets";
        String user = "root";
        String password = "...";
        System.out.println("Connecting to Database...");
        connection = DriverManager.getConnection(url, user, password);
        System.out.println("Connection valid: " + connection.isValid(5));

    }

    public static void closeDatabaseConnection() throws SQLException {
        System.out.println("Closing database connection...");
        connection.close();
        System.out.println("Connection valid: " + connection.isValid(5));
    }

    private static void query1() throws SQLException {
        System.out.println("Reading Data...");
        PreparedStatement s1 = connection.prepareStatement("""
                        SELECT owner, species, name
                        FROM pet
                        ORDER BY owner
                                                                  """);
        ResultSet rs1 = s1.executeQuery();
        String res = "";
        while(rs1.next()) {
            res = res + rs1.getString("owner") + "," + rs1.getString("species") +  "," + rs1.getString("name") + "\n";
        }
        System.out.println("Query 1 result: \n\n" + res);
    }

    private static void query2() throws SQLException {
        System.out.println("Reading Data...");
        PreparedStatement s1 = connection.prepareStatement("""
                        SELECT owner, name
                        FROM pet
                        WHERE species = "cat"
                        
                                                                  """);
        ResultSet rs1 = s1.executeQuery();
        String res = "";
        while(rs1.next()) {
            res = res + rs1.getString("owner") +  "," + rs1.getString("name") + "\n";
        }
        System.out.println("Query 2 result: \n\n" + res);
    }

    private static void query3() throws SQLException {
        System.out.println("Reading Data...");
        PreparedStatement s1 = connection.prepareStatement("""
                        SELECT owner, name
                        FROM pet
                        WHERE owner = "Butch"
                        
                                                                  """);
        ResultSet rs1 = s1.executeQuery();
        String res = "";
        while(rs1.next()) {
            res = res + rs1.getString("owner") +  "," + rs1.getString("name") + "\n";
        }
        System.out.println("Query 3 result: \n\n" + res);
    }
    private static void query4() throws SQLException {
        System.out.println("Reading Data...");
        PreparedStatement s1 = connection.prepareStatement("""
                        SELECT owner, name
                        FROM pet
                        WHERE name = "Snowball"
                        
                                                                  """);
        ResultSet rs1 = s1.executeQuery();
        String res = "";
        while(rs1.next()) {
            res = res + rs1.getString("owner") +  "," + rs1.getString("name") + "\n";
        }
        System.out.println("Query 4 result: \n\n" + res);
    }
}


