package lesson_ten.Util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Mark_DAO implements lesson_ten.Base.Mark_DAO {
    ConnectionDB conn = new ConnectionDB();

    @Override
    public void getAll() {
        try (Statement st = conn.connectDB().createStatement()) {
            ResultSet res = st.executeQuery("select * from mark");
            while (res.next()) {
                System.out.println(res.getInt("mark"));
            }
            if (conn.connectDB() != null) {
                conn.closeConnection();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getMarkById(Integer num) {
        try (Statement st = conn.connectDB().createStatement()) {
            ResultSet res = st.executeQuery("select * from mark where idMark = " + num);
            while (res.next()) {
                System.out.println(res.getString("mark"));
            }
            if (conn.connectDB() != null) {
                conn.closeConnection();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setMarkById() {

    }

    @Override
    public void deleteMarkById() {

    }
}
