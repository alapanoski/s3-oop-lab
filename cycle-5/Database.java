import java.sql.*;

public class Database {

    private static final String url = "jdbc:postgresql://localhost:5432/s3_oop_lab";
    private static final String user = "postgres";
    private static final String password = "postgres";

    public static void main(String[] args) {

        Connection connection = null;
        Statement stmt = null;

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");

            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM PROGRAM;");

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int cycle = rs.getInt("cycle");
                int module = rs.getInt("module");
                System.out.println("ID = " + id);
                System.out.println("NAME = " + name);
                System.out.println("CYCLE = " + cycle);
                System.out.println("MODULE = " + module);
                System.out.println();
            }

            rs.close();
            stmt.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e);
            System.exit(0);
        }
        System.out.println("JDBC operations completed successfully");
    }
}