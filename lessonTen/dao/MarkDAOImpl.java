package lessonTen.dao;

import lessonTen.connectionpool.ConnectionPool;
import lessonTen.dto.MarkDTO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MarkDAOImpl implements lessonTen.dao.MarkDAO {
    MarkDTO mark;
    List<MarkDTO> markList;


    @Override
    public List<MarkDTO> getAll() {
        try {
            Connection connection = ConnectionPool.getConnectionPool();
            Statement st = connection.createStatement();
            markList = new ArrayList<>();
            ResultSet res = st.executeQuery("select * from mark;");
            while (res.next()) {
                mark = new MarkDTO(res.getInt(1), res.getString(2), res.getInt(3), res.getInt(4));
                markList.add(mark);
            }
            ConnectionPool.releaseConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return markList;
    }

    @Override
    public MarkDTO getMarkById(long id) {
        try {
            Connection connection = ConnectionPool.getConnectionPool();
            Statement st = connection.createStatement();
            ResultSet res = st.executeQuery("select * from mark where id = " + id + ";");
            while (res.next()) {
                mark = new MarkDTO(res.getInt(1), res.getString(2), res.getInt(3), res.getInt(4));
            }
            ConnectionPool.releaseConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mark;
    }

    @Override
    public void updateMarkById(MarkDTO markVar) {
        try {
            Connection connection = ConnectionPool.getConnectionPool();
            Statement st = connection.createStatement();
            st.executeUpdate("update mark set mark = " + markVar.getMark() + ", id_subject = " + markVar.getIdSubject() + ", id_student = " + markVar.getIdStudent() + " where id = " + markVar.getId() + " ;");
            ConnectionPool.releaseConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertMark(MarkDTO markVar) {
        try {
            Connection connection = ConnectionPool.getConnectionPool();
            Statement st = connection.createStatement();
            st.executeUpdate("insert into mark (mark, id_subject, id_student) values (" + markVar.getMark() + ", " + markVar.getIdSubject() + ", " + markVar.getIdStudent() + ");");
            ConnectionPool.releaseConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(long id) {
        try {
            Connection connection = ConnectionPool.getConnectionPool();
            Statement st = connection.createStatement();
            st.executeUpdate("delete from mark where id = " + id + ";");
            ConnectionPool.releaseConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}