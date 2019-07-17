package lessonTen.test;

import lessonTen.dao.StudentDAOImpl;
import lessonTen.dto.StudentDTO;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestStudentDAOImpl {
    StudentDAOImpl studentDAO = new StudentDAOImpl();
    ArrayList lst = new ArrayList();

    @Test
    public void listNotEmpty (){
        Assert.assertNotEquals(0, studentDAO.getAll().size());
    }

    @Test
    public void gettingTheStudent(){
        Assert.assertEquals("Max", studentDAO.getStudentById(1).getName());
        Assert.assertEquals("Maximov", studentDAO.getStudentById(1).getSecondName());
        Assert.assertEquals(2009, studentDAO.getStudentById(1).getEnrolmentYear());
    }

    @Test
    public void insertStudent(){
        StudentDTO studentDTO = new StudentDTO(100, "Roman", "Umnyi", 1999);
        studentDAO.insertStudent(studentDTO);
        Assert.assertEquals(studentDTO.getName(), studentDAO.getStudentById(100).getName());
        studentDAO.deleteStudentById(100);
    }

    @Test
    public void updateStudent(){
        StudentDTO studentDTO = new StudentDTO(100, "Roman", "Umnyi", 1999);
        studentDAO.insertStudent(studentDTO);
        studentDTO = new StudentDTO(100, "Mareik", "Glupyi", 1988);
        studentDAO.updateStudentById(studentDTO);
        Assert.assertEquals(studentDTO.getName(), studentDAO.getStudentById(100).getName());
        studentDAO.deleteStudentById(100);
    }

    @Test
    public void deleteStudetn(){
        studentDAO.insertStudent(new StudentDTO(100, "Roman", "Umnyi", 1999));
        studentDAO.deleteStudentById(100);
        Assert.assertNull(studentDAO.getStudentById(100));
    }
}
