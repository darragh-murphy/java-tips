import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

public class ConnectionLogger {

    public static void logConnectionDetails(Connection connection) {
        try {
            if (connection != null) {
                DatabaseMetaData metaData = connection.getMetaData();
                
                System.out.println("Database URL: " + metaData.getURL());
                System.out.println("Database Product Name: " + metaData.getDatabaseProductName());
                System.out.println("Database Product Version: " + metaData.getDatabaseProductVersion());
                System.out.println("Driver Name: " + metaData.getDriverName());
                System.out.println("Driver Version: " + metaData.getDriverVersion());
                System.out.println("User Name: " + metaData.getUserName());
            } else {
                System.out.println("Connection is null. Unable to log details.");
            }
        } catch (SQLException e) {
            System.err.println("Error while retrieving connection details: " + e.getMessage());
        }
    }
}