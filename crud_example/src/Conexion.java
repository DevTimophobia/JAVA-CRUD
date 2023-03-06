import java.sql.*;

public class Conexion {
    public static final String JDBC_URL = "jdbc:mysql://localhost:3306/crud_example";
    public static final String JDBC_USER = "admin";
    public static final String JDBC_PASWORD = "12365400";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASWORD);
    }

    public static void close (ResultSet rs) throws SQLException {
        rs.close();
    }
    public static void close (Statement stmt) throws SQLException {
        stmt.close();
    }
    public static void close (Connection conn) throws SQLException {
        conn.close();
    }
}