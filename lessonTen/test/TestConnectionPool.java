package lessonTen.test;

import lessonTen.connectionpool.ConnectionPool;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;

public class TestConnectionPool {
    Connection connection;

    @Test
    public void testConnectionPoolIsNotEmpty() {
        connection = ConnectionPool.getConnection();
        Assert.assertNotNull(connection);
        ConnectionPool.releaseConnection(connection);
    }

    @Test
    public void testConnectionPoolGetsConnection(){
        connection = ConnectionPool.getConnection();
        int expected = 4;
        Assert.assertEquals(expected, ConnectionPool.countFreeConnections());
        ConnectionPool.releaseConnection(connection);
    }

    @Test
    public void testConnectionPoolGivesConnection(){
        connection = ConnectionPool.getConnection();
        int expected = 1;
        Assert.assertEquals(expected, ConnectionPool.countUsedConnections());
        ConnectionPool.releaseConnection(connection);
    }


    @Test
    public void testConnectionPoolReleasedConnection(){
        connection = ConnectionPool.getConnection();
        ConnectionPool.releaseConnection(connection);
        int expected = 5;
        Assert.assertEquals(expected, ConnectionPool.countFreeConnections());
    }
}
