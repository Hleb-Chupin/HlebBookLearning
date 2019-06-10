package lessonTen.dao;

import lessonTen.dto.StudentDTO;
import lessonTen.util.ConnectionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements lessonTen.dao.StudentDAO {
    private ConnectionDB conn = new ConnectionDB();
    StudentDTO student;
    List<StudentDTO> studentList;

    @Override
    public List<StudentDTO> getAll() {
        try (Statement st = conn.connectDB().createStatement()) {
            studentList = new ArrayList<>();
            ResultSet res = st.executeQuery("select * from student;");
            while (res.next()) {
                student = new StudentDTO(res.getInt(1), res.getString(2), res.getString(3), res.getInt(4));
                studentList.add(student);
            }
            conn.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentList;
    }

    @Override
    public StudentDTO getStudentById(long id) {
        try (Statement st = conn.connectDB().createStatement()) {
            ResultSet res = st.executeQuery("select * from student where id = " + id + ";");
            while (res.next()) {
                student = new StudentDTO(res.getInt(1), res.getString(2), res.getString(3), res.getInt(4));
            }
            conn.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public void setStudentById(Integer id, StudentDTO studentVar) {
        try (Statement st = conn.connectDB().createStatement()) {
            st.executeUpdate("update student set name = '" + studentVar.getName() + "', second_name = '" + studentVar.getSecondName() + "', enrolment_year = " + studentVar.getEnrolmentYear() + " where id = " + id + " ;");
            conn.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setStudent(StudentDTO studentVar) {
        try (Statement st = conn.connectDB().createStatement()) {
            st.executeUpdate("insert into student (name, second_name, enrolment_year) values ('" + studentVar.getName() + "', '" + studentVar.getSecondName() + "', " + studentVar.getEnrolmentYear() + ");");
            conn.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteStudentById(long id) {
        try (Statement st = conn.connectDB().createStatement()) {
            st.executeUpdate("delete from student where id = " + id + ";");
            conn.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
