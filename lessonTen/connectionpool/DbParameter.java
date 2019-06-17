package lessonTen.connectionpool;

public class DBParameter {
    private DBParameter(){};

    public static final String DB_Url = "jdbc:mysql://localhost:3306/school_db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    public static final String DB_User = "root";
    public static final String DB_Password = "123";
    public static final int DB_Pool_Size = 5;
}
