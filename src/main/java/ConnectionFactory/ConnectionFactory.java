/**
 * In this package the connection with database is made
 */
package ConnectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * In this class the connection with database is made
 * By calling getConnection() method a connection with database is made
 */
public class ConnectionFactory {

    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static ConnectionFactory singleInstance = new ConnectionFactory();
    private ConnectionFactory(){
        try {
            Class.forName(driver);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    private Connection createConnection(){
        Connection connection = null;
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/management_application_final", "root", "Sergiucraiova12");
        }catch (SQLException e){
            e.printStackTrace();
        }
        return connection;
    }

    public static Connection getConnection(){
        return singleInstance.createConnection();
    }

}
