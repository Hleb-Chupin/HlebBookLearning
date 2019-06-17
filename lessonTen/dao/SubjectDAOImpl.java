package lessonTen.dao;

import lessonTen.connectionpool.ConnectionPool;
import lessonTen.dto.SubjectDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubjectDAOImpl implements lessonTen.dao.SubjectDAO {
    SubjectDTO subject;
    List<SubjectDTO> subjectList;
    private static final String SELECTALL = "select * from subject;";
    private static final String SELECTBYID = "select * from subject where id = ?;";
    private static final String UPDATESUBJECT = "update subject set name_subject = ? where id = ?;";
    private static final String INSERTINTOSUBJECT = "insert into subject (name_subject) values (?);";
    private static final String DELETESTUDENTBYID = "delete from subject where id = ?;";

    @Override
    public List<SubjectDTO> getAll() {
        try {
            Connection connection = ConnectionPool.getConnectionPool();
            Statement st = connection.createStatement();
            subjectList = new ArrayList<>();
            ResultSet res = st.executeQuery(SELECTALL);
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
    public Object getSubjectById(long id) {
        try {
            Connection connection = ConnectionPool.getConnectionPool();
            PreparedStatement pr = connection.prepareStatement(SELECTBYID);
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
            Connection connection = ConnectionPool.getConnectionPool();
            PreparedStatement pr = connection.prepareStatement(UPDATESUBJECT);
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
            Connection connection = ConnectionPool.getConnectionPool();
            PreparedStatement pr = connection.prepareStatement(INSERTINTOSUBJECT);
            pr.setString(1, subjectVar.getNameSubject());
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
            PreparedStatement pr = connection.prepareStatement(DELETESTUDENTBYID);
            pr.setLong(1, id);
            pr.executeUpdate();
            ConnectionPool.releaseConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
