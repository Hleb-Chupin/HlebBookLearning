package lessonTen.dao;

import lessonTen.connectionpool.ConnectionPool;
import lessonTen.dto.SubjectDTO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SubjectDAOImpl implements lessonTen.dao.SubjectDAO {
    SubjectDTO subject;
    List<SubjectDTO> subjectList;

    @Override
    public List<SubjectDTO> getAll() {
        try {
            Connection connection = ConnectionPool.getConnectionPool();
            Statement st = connection.createStatement();
            subjectList = new ArrayList<>();
            ResultSet res = st.executeQuery("select * from subject;");
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
            Statement st = connection.createStatement();
            ResultSet res = st.executeQuery("select * from subject where id = " + id + ";");
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
            Statement st = connection.createStatement();
            st.executeUpdate("update subject set name_subject = '" + subjectVar.getNameSubject() + " where id = " + subjectVar.getId() + " ;");
            ConnectionPool.releaseConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertSubject(SubjectDTO subjectVar) {
        try {
            Connection connection = ConnectionPool.getConnectionPool();
            Statement st = connection.createStatement();
            st.executeUpdate("insert into subject (name_subject) values ('" + subjectVar.getNameSubject() + ");");
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
            st.executeUpdate("delete from subject where id = " + id + ";");
            ConnectionPool.releaseConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
