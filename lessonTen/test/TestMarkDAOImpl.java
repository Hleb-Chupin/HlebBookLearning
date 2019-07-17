package lessonTen.test;

import lessonTen.dao.MarkDAOImpl;
import lessonTen.dto.MarkDTO;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestMarkDAOImpl {
    MarkDAOImpl markDAO = new MarkDAOImpl();
    ArrayList lst = new ArrayList();

    @Test
    public void listNotEmpty (){
        Assert.assertNotEquals(0, markDAO.getAll().size());
    }

    @Test
    public void gettingTheMark(){
        Assert.assertEquals("5", markDAO.getMarkById(1).getMark());
    }

    @Test
    public void insertMark(){
        MarkDTO markDTO = new MarkDTO(100, "5", 1,1 );
        markDAO.insertMark(markDTO);
        Assert.assertEquals(markDTO.getMark(), markDAO.getMarkById(100).getMark());
        markDAO.deleteById(100);
    }

    @Test
    public void updateMarkById(){
        MarkDTO markDTO = new MarkDTO(100, "5", 1,1 );
        markDAO.insertMark(markDTO);
        markDTO = new MarkDTO(100, "9", 2,2 );
        markDAO.updateMarkById(markDTO);
        Assert.assertEquals(markDTO.getMark(), markDAO.getMarkById(100).getMark());
        markDAO.deleteById(100);
    }

    @Test
    public void deleteById(){
        markDAO.insertMark(new MarkDTO(100, "5", 1,1 ));
        markDAO.deleteById(100);
        Assert.assertNull(markDAO.getMarkById(100));
    }
}
