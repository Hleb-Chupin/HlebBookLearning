package lessonTen.test;

import lessonTen.connectionpool.ConnectionDB;
import lessonTen.connectionpool.ConnectionPoolException;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;

public class TestConnectionDB {
    private String DB_Url = "jdbc:mysql://localhost:3306/school_db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    public static final String DB_User = "root";
    public static final String DB_Password = "123";
    ConnectionDB connectionDB = new ConnectionDB();
    Connection connection;


    @Test
    public void testConnectionIsNotEmpty() throws ConnectionPoolException {
        connection = connectionDB.getConnection(DB_Url, DB_User, DB_Password);
        Assert.assertNotNull(connection);
    }

    @Test
    public void testConnectionCloses(){
        connectionDB.closeConnection();
        Assert.assertNull(connection);
    }
}
