package lessonTen.dao;

import lessonTen.connectionpool.ConnectionPool;
import lessonTen.dto.StudentDTO;
import lessonTen.connectionpool.ConnectionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements lessonTen.dao.StudentDAO {
    StudentDTO student;
    List<StudentDTO> studentList;
    ConnectionPool connectionPool = new ConnectionPool();

    @Override
    public List<StudentDTO> getAll() {
        try (Statement st = connectionPool.getConnectionPool().createStatement()) {
            studentList = new ArrayList<>();
            ResultSet res = st.executeQuery("select * from student;");
            while (res.next()) {
                student = new StudentDTO(res.getInt(1), res.getString(2), res.getString(3), res.getInt(4));
                studentList.add(student);
            }
            connectionPool.releaseConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentList;
    }

    @Override
    public List<StudentDTO> getStudentByIdWithMarkAndSubject(int id) {
        try (Statement st = connectionPool.getConnectionPool().createStatement()) {
            studentList = new ArrayList<>();
            ResultSet res = st.executeQuery("select name, second_name, mark, name_subject from mark left join student on mark.id_student = student.id left join subject on mark.id_subject = subject.id_subject where id = " + id + ";");
            while (res.next()) {
                student = new StudentDTO(res.getString(1), res.getString(2), res.getInt(3), res.getString(4));
                studentList.add(student);
            }
            connectionPool.releaseConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentList;    }

    @Override
    public StudentDTO getStudentById(long id) {
        try (Statement st = connectionPool.getConnectionPool().createStatement()) {
            ResultSet res = st.executeQuery("select * from student where id = " + id + ";");
            while (res.next()) {
                student = new StudentDTO(res.getInt(1), res.getString(2), res.getString(3), res.getInt(4));
            }
            connectionPool.releaseConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public void updateStudentById(StudentDTO studentVar) {
        try (Statement st = connectionPool.getConnectionPool().createStatement()) {
            st.executeUpdate("update student set name = '" + studentVar.getName() + "', second_name = '" + studentVar.getSecondName() + "', enrolment_year = " + studentVar.getEnrolmentYear() + " where id = " + studentVar.getId() + " ;");
            connectionPool.releaseConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertStudent(StudentDTO studentVar) {
        try (Statement st = connectionPool.getConnectionPool().createStatement()) {
            st.executeUpdate("insert into student (name, second_name, enrolment_year) values ('" + studentVar.getName() + "', '" + studentVar.getSecondName() + "', " + studentVar.getEnrolmentYear() + ");");
            connectionPool.releaseConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteStudentById(long id) {
        try (Statement st = connectionPool.getConnectionPool().createStatement()) {
            st.executeUpdate("delete from student where id = " + id + ";");
            connectionPool.releaseConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
