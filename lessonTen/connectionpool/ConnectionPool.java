package lessonTen.connectionpool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {

    //    Creating class fields
    private String url = DbParameter.DB_Url;
    private String user = DbParameter.DB_User;
    private String password = DbParameter.DB_Password;
    private int poolSize = DbParameter.DB_Pool_Size;
    private List<Connection> freeConnections;
    private List<Connection> usedConnections = new ArrayList<>();
    private Connection connection;

    //    Creating simple conneciton pool, using collections.
    {
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
    public Connection getConnectionPool() {
        if (freeConnections.isEmpty()) {
            return null;
        } else {
            connection = freeConnections.remove(freeConnections.size() - 1);
            usedConnections.add(connection);
            return connection;
        }
    }


    public boolean releaseConnection() {
        if (usedConnections.isEmpty()) {
            return false;
        } else {
            connection = usedConnections.remove(usedConnections.size() - 1);
            freeConnections.add(connection);
            return true;
        }
    }

    public int countUsedConnections() {
        return usedConnections.size();
    }

    public int countFreeConnections() {
        return freeConnections.size();
    }
}
