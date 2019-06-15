package lessonTen.dao;

import lessonTen.connectionpool.ConnectionPool;
import lessonTen.dto.SubjectDTO;
import lessonTen.connectionpool.ConnectionDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SubjectDAOImpl implements lessonTen.dao.SubjectDAO {
    SubjectDTO subject;
    List<SubjectDTO> subjectList;
    ConnectionPool connectionPool = new ConnectionPool();

    @Override
    public List<SubjectDTO> getAll() {
        try (Statement st = connectionPool.getConnectionPool().createStatement()) {
            subjectList = new ArrayList<>();
            ResultSet res = st.executeQuery("select * from subject;");
            while (res.next()) {
                subject = new SubjectDTO(res.getInt(1), res.getString(2));
                subjectList.add(subject);
            }
            connectionPool.releaseConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subjectList;
    }

    @Override
    public Object getSubjectById(long id) {
        try (Statement st = connectionPool.getConnectionPool().createStatement()) {
            ResultSet res = st.executeQuery("select * from subject where id = " + id + ";");
            while (res.next()) {
                subject = new SubjectDTO(res.getInt(1), res.getString(2));
            }
            connectionPool.releaseConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subject;
    }

    @Override
    public void updateSubjectById(SubjectDTO subjectVar) {
        try (Statement st = connectionPool.getConnectionPool().createStatement()) {
            st.executeUpdate("update subject set name_subject = '" + subjectVar.getNameSubject() + " where id = " + subjectVar.getId() + " ;");
            connectionPool.releaseConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertSubject(SubjectDTO subjectVar) {
        try (Statement st = connectionPool.getConnectionPool().createStatement()) {
            st.executeUpdate("insert into subject (name_subject) values ('" + subjectVar.getNameSubject() + ");");
            connectionPool.releaseConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(long id) {
        try (Statement st = connectionPool.getConnectionPool().createStatement()) {
            st.executeUpdate("delete from subject where id = " + id + ";");
            connectionPool.releaseConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
