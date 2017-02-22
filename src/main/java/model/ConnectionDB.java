package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rafa
 */
public class ConnectionDB {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://35.163.178.255:3306/ServicioREST?noAccessToProcedureBodies=true";
    private static final String USER = "dam";
    private static final String PASSWD = "dam";
    
    private static Connection con = null;
    
    private ConnectionDB() {}
    
    public static Connection getConnection() {
        if (con == null) {
            try {
                Class.forName(JDBC_DRIVER);
                con = DriverManager.getConnection(DB_URL, USER, PASSWD);
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
            }
            return con;
        }
        else
            return con;
    }
}
