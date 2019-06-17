package lessonTen.dao;

import lessonTen.connectionpool.ConnectionPool;
import lessonTen.dto.MarkDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MarkDAOImpl implements lessonTen.dao.MarkDAO {
    MarkDTO mark;
    List<MarkDTO> markList;
    private static final String SELECTALL = "select * from mark;";
    private static final String SELECTBYID = "select * from mark where id = ?;";
    private static final String UPDATEMARK = "update mark set mark = ?, id_subject = ?, id_student = ? where id = ?;";
    private static final String INSERTINTOMARK = "insert into mark (mark, id_subject, id_student) values (?, ?, ?);";
    private static final String DELETEMARKBYID = "delete from mark where id = ?;";


    @Override
    public List<MarkDTO> getAll() {
        try {
            Connection connection = ConnectionPool.getConnectionPool();
            Statement st = connection.createStatement();
            markList = new ArrayList<>();
            ResultSet res = st.executeQuery(SELECTALL);
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
            PreparedStatement pr = connection.prepareStatement(SELECTBYID);
            pr.setLong(1, id);
            ResultSet res = pr.executeQuery();
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
            PreparedStatement pr = connection.prepareStatement(UPDATEMARK);
            pr.setString(1, markVar.getMark());
            pr.setInt(2, markVar.getIdStudent());
            pr.setInt(3, markVar.getIdSubject());
            pr.setInt(4, markVar.getIdStudent());
            pr.setInt(5, markVar.getId());
            pr.executeUpdate();
            ConnectionPool.releaseConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertMark(MarkDTO markVar) {
        try {
            Connection connection = ConnectionPool.getConnectionPool();
            PreparedStatement pr = connection.prepareStatement(INSERTINTOMARK);
            pr.setString(1, markVar.getMark());
            pr.setInt(2, markVar.getIdSubject());
            pr.setInt(3, markVar.getIdStudent());
            pr.executeUpdate();
            ConnectionPool.releaseConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(long id) {
        try {
            Connection connection = ConnectionPool.getConnectionPool();
            PreparedStatement pr = connection.prepareStatement(DELETEMARKBYID);
            pr.setLong(1, id);
            pr.executeUpdate();
            ConnectionPool.releaseConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}