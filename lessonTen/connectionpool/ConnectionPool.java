package lessonTen.connectionpool;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {

    //    Creating class fields
    private static String url = DBParameter.DB_Url;
    private static String user = DBParameter.DB_User;
    private static String password = DBParameter.DB_Password;
    private static int poolSize = DBParameter.DB_Pool_Size;
    private static List<Connection> freeConnections;
    private static List<Connection> usedConnections = new ArrayList<>();

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
    public static Connection getConnection() {
        if (freeConnections.isEmpty()) {
            return null;
        } else {
            Connection connection = freeConnections.remove(freeConnections.size() - 1);
            usedConnections.add(connection);
            return connection;
        }
    }


    public static boolean releaseConnection(Connection currentConnection) {
        if (usedConnections.isEmpty()) {
            return false;
        } else {
            usedConnections.remove(currentConnection);
            freeConnections.add(currentConnection);
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
