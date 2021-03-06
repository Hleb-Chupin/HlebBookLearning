package lessonTen.dao;

import lessonTen.connectionpool.ConnectionPool;
import lessonTen.dto.MarkDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MarkDAOImpl implements lessonTen.dao.MarkDAO {
    MarkDTO mark;
    List<MarkDTO> markList;
    private static final String SELECT_ALL = "select * from mark;";
    private static final String SELECT_BY_ID = "select * from mark where id_mark = ?;";
    private static final String UPDATE_MARK = "update mark set mark = ?, id_subject = ?, id_student = ? where id_mark = ?;";
    private static final String INSERT_INTO_MARK = "insert into mark (id_mark, mark, id_subject, id_student) values (?, ?, ?, ?);";
    private static final String DELETE_MARK_BY_ID = "delete from mark where id_mark = ?;";


    @Override
    public List<MarkDTO> getAll() {
        try {
            Connection connection = ConnectionPool.getConnection();
            Statement st = connection.createStatement();
            markList = new ArrayList<>();
            ResultSet res = st.executeQuery(SELECT_ALL);
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
            Connection connection = ConnectionPool.getConnection();
            PreparedStatement pr = connection.prepareStatement(SELECT_BY_ID);
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
            Connection connection = ConnectionPool.getConnection();
            PreparedStatement pr = connection.prepareStatement(UPDATE_MARK);
            pr.setString(1, markVar.getMark());
            pr.setInt(2, markVar.getIdStudent());
            pr.setInt(3, markVar.getIdSubject());
            pr.setInt(4, markVar.getId());
            pr.executeUpdate();
            ConnectionPool.releaseConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertMark(MarkDTO markVar) {
        try {
            Connection connection = ConnectionPool.getConnection();
            PreparedStatement pr = connection.prepareStatement(INSERT_INTO_MARK);
            pr.setInt(1, markVar.getId());
            pr.setString(2, markVar.getMark());
            pr.setInt(3, markVar.getIdSubject());
            pr.setInt(4, markVar.getIdStudent());
            pr.executeUpdate();
            ConnectionPool.releaseConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(long id) {
        try {
            Connection connection = ConnectionPool.getConnection();
            PreparedStatement pr = connection.prepareStatement(DELETE_MARK_BY_ID);
            pr.setLong(1, id);
            pr.executeUpdate();
            ConnectionPool.releaseConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}