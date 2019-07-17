package lessonTen.dao;

import lessonTen.connectionpool.ConnectionPool;
import lessonTen.dto.StudentDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements lessonTen.dao.StudentDAO {
    StudentDTO student;
    List<StudentDTO> studentList;
    private static final String SELECT_ALL = "select * from student;";
    private static final String SELECT_ALL_STUDENTS_WITH_MARK_AND_SUBJECT_BY_ID = "select id_mark, name, second_name, mark, name_subject from mark left join student on mark.id_student = student.id left join subject on mark.id_subject = subject.id_subject where id = ?;";
    private static final String SELECT_BY_ID = "select * from student where id = ?;";
    private static final String UPDATE_STUDENT = "update student set name = ?, second_name = ?, enrolment_year = ? where id = ?;";
    private static final String INSERT_INTO_STUDENT = "insert into student (id, name, second_name, enrolment_year) values (?, ?, ?, ?);";
    private static final String DELETE_STUDENT_BY_ID = "delete from student where id = ?;";

    @Override
    public List<StudentDTO> getAll() {
        try {
            Connection connection = ConnectionPool.getConnection();
            Statement st = connection.createStatement();
            studentList = new ArrayList<>();
            ResultSet res = st.executeQuery(SELECT_ALL);
            while (res.next()) {
                student = new StudentDTO(res.getInt(1), res.getString(2), res.getString(3), res.getInt(4));
                studentList.add(student);
            }
            ConnectionPool.releaseConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentList;
    }


    @Override
    public List<StudentDTO> getStudentByIdWithMarkAndSubject(int id) {
        try {
            Connection connection = ConnectionPool.getConnection();
            PreparedStatement st = connection.prepareStatement(SELECT_ALL_STUDENTS_WITH_MARK_AND_SUBJECT_BY_ID);
            st.setInt(1, id);
            ResultSet res = st.executeQuery();
            studentList = new ArrayList<>();
            while (res.next()) {
                student = new StudentDTO(res.getInt(1), res.getString(2), res.getString(3), res.getInt(4), res.getString(5));
                studentList.add(student);
            }
            ConnectionPool.releaseConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentList;
    }


    @Override
    public StudentDTO getStudentById(long id) {
        try {
            Connection connection = ConnectionPool.getConnection();
            PreparedStatement st = connection.prepareStatement(SELECT_BY_ID);
            st.setLong(1, id);
            ResultSet res = st.executeQuery();
            while (res.next()) {
                student = new StudentDTO(res.getInt(1), res.getString(2), res.getString(3), res.getInt(4));
            }
            ConnectionPool.releaseConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public void updateStudentById(StudentDTO studentVar) {
        try {
            Connection connection = ConnectionPool.getConnection();
            PreparedStatement st = connection.prepareStatement(UPDATE_STUDENT);
            st.setString(1, studentVar.getName());
            st.setString(2, studentVar.getSecondName());
            st.setInt(3, studentVar.getEnrolmentYear());
            st.setInt(4, studentVar.getId());
            st.executeUpdate();
            ConnectionPool.releaseConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void insertStudent(StudentDTO studentVar) {
        try {
            Connection connection = ConnectionPool.getConnection();
            PreparedStatement st = connection.prepareStatement(INSERT_INTO_STUDENT);
            st.setInt(1, studentVar.getId());
            st.setString(2, studentVar.getName());
            st.setString(3, studentVar.getSecondName());
            st.setInt(4, studentVar.getEnrolmentYear());
            st.executeUpdate();
            ConnectionPool.releaseConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteStudentById(long id) {
        try {
            Connection connection = ConnectionPool.getConnection();
            PreparedStatement st = connection.prepareStatement(DELETE_STUDENT_BY_ID);
            st.setLong(1, id);
            st.executeUpdate();
            ConnectionPool.releaseConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
