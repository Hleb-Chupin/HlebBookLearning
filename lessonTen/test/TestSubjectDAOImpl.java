package lessonTen.test;

import lessonTen.dao.SubjectDAOImpl;
import lessonTen.dto.SubjectDTO;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestSubjectDAOImpl {
    SubjectDAOImpl subjectDAO = new SubjectDAOImpl();
    ArrayList lst = new ArrayList();

    @Test
    public void listNotEmpty (){
        Assert.assertNotEquals(0, subjectDAO.getAll().size());
    }

    @Test
    public void gettingTheSubject(){
        String nameSubject = subjectDAO.getSubjectById(1).getNameSubject();
        Assert.assertEquals("Math", nameSubject);
    }

    @Test
    public void insertSubjectById(){
        SubjectDTO subjectDTO = new SubjectDTO(100, "Law");
        subjectDAO.insertSubject(subjectDTO);
        Assert.assertEquals(subjectDTO.getNameSubject(), subjectDAO.getSubjectById(100).getNameSubject());
        subjectDAO.deleteById(100);
    }

    @Test
    public void updateSubjectById(){
        SubjectDTO subjectDTO = new SubjectDTO(100, "Law");
        subjectDAO.insertSubject(subjectDTO);
        subjectDTO = new SubjectDTO(100, "Music");
        subjectDAO.updateSubjectById(subjectDTO);
        Assert.assertEquals(subjectDTO.getNameSubject(), subjectDAO.getSubjectById(100).getNameSubject());
        subjectDAO.deleteById(100);
    }

    @Test
    public void deleteSubjectById(){
        subjectDAO.insertSubject(new SubjectDTO(100, "Law"));
        subjectDAO.deleteById(100);
        Assert.assertNull(subjectDAO.getSubjectById(100));
    }
}