package app.util;
import java.sql.*;
import java.util.TimeZone;

public class UtilConnection {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testDB?serverTimezone=" + TimeZone.getDefault().getID();
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static Connection utilConnection;

    private UtilConnection() {}

    public static synchronized Connection getUtilConnection() throws ClassNotFoundException, SQLException {
        if(utilConnection == null) {
            Class.forName(JDBC_DRIVER);
            utilConnection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        }
        return  utilConnection;
    }
}
