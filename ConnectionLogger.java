import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class ConnectionLogger {

    // A Set to keep track of logged connections
    private static final Set<Integer> loggedConnections = new HashSet<>();

    public static void logConnectionDetails(Connection connection) {
        try {
            if (connection != null) {
                // Use the connection's hash code as a unique identifier
                int connectionId = System.identityHashCode(connection);

                // Check if this connection has already been logged
                if (loggedConnections.contains(connectionId)) {
                    System.out.println("Connection details already logged for this connection.");
                    return;
                }

                // Log connection details
                DatabaseMetaData metaData = connection.getMetaData();
                System.out.println("Logging details for a new connection:");
                System.out.println("Database URL: " + metaData.getURL());
                System.out.println("Database Product Name: " + metaData.getDatabaseProductName());
                System.out.println("Database Product Version: " + metaData.getDatabaseProductVersion());
                System.out.println("Driver Name: " + metaData.getDriverName());
                System.out.println("Driver Version: " + metaData.getDriverVersion());
                System.out.println("User Name: " + metaData.getUserName());

                // Add this connection to the logged set
                loggedConnections.add(connectionId);
            } else {
                System.out.println("Connection is null. Unable to log details.");
            }
        } catch (SQLException e) {
            System.err.println("Error while retrieving connection details: " + e.getMessage());
        }
    }
}