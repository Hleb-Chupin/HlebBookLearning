package lessonTen.connectionpool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {

    //    Creating class fields
    private static String url = DbParameter.DB_Url;
    private static String user = DbParameter.DB_User;
    private static String password = DbParameter.DB_Password;
    private static int poolSize = DbParameter.DB_Pool_Size;
    private static List<Connection> freeConnections;
    private static List<Connection> usedConnections = new ArrayList<>();
    private static Connection connection;

    //    Creating simple conneciton pool, using collections.
    static {
        freeConnections = new ArrayList<>(poolSize);
        for (int i = 0; i < poolSize; i++) {
            try {
                freeConnections.add(new ConnectionDB().getConnection(url, user, password));
            } catch (ConnectionPoolException e){
                e.printStackTrace();
            }
        }

    }

    //    Getting the connection.
    public static Connection getConnectionPool() {
        if (freeConnections.isEmpty()) {
            return null;
        } else {
            connection = freeConnections.remove(freeConnections.size() - 1);
            usedConnections.add(connection);
            return connection;
        }
    }


    public static boolean releaseConnection() {
        if (usedConnections.isEmpty()) {
            return false;
        } else {
            connection = usedConnections.remove(usedConnections.size() - 1);
            freeConnections.add(connection);
            return true;
        }
    }

    public static int countUsedConnections() {
        return usedConnections.size();
    }

    public static int countFreeConnections() {
        return freeConnections.size();
    }
}
