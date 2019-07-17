package lessonTen.dao;

import lessonTen.connectionpool.ConnectionPool;
import lessonTen.dto.SubjectDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubjectDAOImpl implements lessonTen.dao.SubjectDAO {
    SubjectDTO subject;
    List<SubjectDTO> subjectList;
    private static final String SELECT_ALL = "select * from subject;";
    private static final String SELECT_BY_ID = "select * from subject where id_subject = ?;";
    private static final String UPDATE_SUBJECT = "update subject set name_subject = ? where id_subject = ?;";
    private static final String INSERT_INTO_SUBJECT = "insert into subject (id_subject, name_subject) values (?, ?);";
    private static final String DELETE_STUDENT_BY_ID = "delete from subject where id_subject = ?;";

    @Override
    public List<SubjectDTO> getAll() {
        try {
            Connection connection = ConnectionPool.getConnection();
            Statement st = connection.createStatement();
            subjectList = new ArrayList<>();
            ResultSet res = st.executeQuery(SELECT_ALL);
            while (res.next()) {
                subject = new SubjectDTO(res.getInt(1), res.getString(2));
                subjectList.add(subject);
            }
            ConnectionPool.releaseConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subjectList;
    }

    @Override
    public SubjectDTO getSubjectById(long id) {
        try {
            Connection connection = ConnectionPool.getConnection();
            PreparedStatement pr = connection.prepareStatement(SELECT_BY_ID);
            pr.setLong(1, id);
            ResultSet res = pr.executeQuery();
            while (res.next()) {
                subject = new SubjectDTO(res.getInt(1), res.getString(2));
            }
            ConnectionPool.releaseConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subject;
    }

    @Override
    public void updateSubjectById(SubjectDTO subjectVar) {
        try {
            Connection connection = ConnectionPool.getConnection();
            PreparedStatement pr = connection.prepareStatement(UPDATE_SUBJECT);
            pr.setString(1, subjectVar.getNameSubject());
            pr.setInt(2, subjectVar.getId());
            pr.executeUpdate();
            ConnectionPool.releaseConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertSubject(SubjectDTO subjectVar) {
        try {
            Connection connection = ConnectionPool.getConnection();
            PreparedStatement pr = connection.prepareStatement(INSERT_INTO_SUBJECT);
            pr.setInt(1, subjectVar.getId());
            pr.setString(2, subjectVar.getNameSubject());
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
            PreparedStatement pr = connection.prepareStatement(DELETE_STUDENT_BY_ID);
            pr.setLong(1, id);
            pr.executeUpdate();
            ConnectionPool.releaseConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
