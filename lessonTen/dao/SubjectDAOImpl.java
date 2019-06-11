package lessonTen.dao;

import lessonTen.dto.StudentDTO;
import lessonTen.dto.SubjectDTO;
import lessonTen.util.ConnectionDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SubjectDAOImpl implements lessonTen.dao.SubjectDAO {
    private ConnectionDB conn = new ConnectionDB();
    SubjectDTO subject;
    List<SubjectDTO> subjectList;

    @Override
    public List<SubjectDTO> getAll() {
        try (Statement st = conn.connectDB().createStatement()) {
            subjectList = new ArrayList<>();
            ResultSet res = st.executeQuery("select * from subject;");
            while (res.next()) {
                subject = new SubjectDTO(res.getInt(1), res.getString(2));
                subjectList.add(subject);
            }
            conn.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subjectList;
    }

    @Override
    public Object getSubjectById(long id) {
        try (Statement st = conn.connectDB().createStatement()) {
            ResultSet res = st.executeQuery("select * from subject where id = " + id + ";");
            while (res.next()) {
                subject = new SubjectDTO(res.getInt(1), res.getString(2));
            }
            conn.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subject;
    }

    @Override
    public void insertSubjectById(SubjectDTO subjectVar) {
        try (Statement st = conn.connectDB().createStatement()) {
            st.executeUpdate("update subject set name_subject = '" + subjectVar.getNameSubject() + " where id = " + subjectVar.getId() + " ;");
            conn.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertSubject(SubjectDTO subjectVar) {
        try (Statement st = conn.connectDB().createStatement()) {
            st.executeUpdate("insert into subject (name_subject) values ('" + subjectVar.getNameSubject() + ");");
            conn.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(long id) {
        try (Statement st = conn.connectDB().createStatement()) {
            st.executeUpdate("delete from subject where id = " + id + ";");
            conn.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
