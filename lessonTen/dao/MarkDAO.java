package lessonTen.dao;

import lessonTen.dto.MarkDTO;
import java.util.List;

public interface MarkDAO {
    List getAll();

    Object getMarkById(long id);

    void setMarkById(Integer id, MarkDTO markVar);

    void setMark(MarkDTO markVar);

    void deleteById(long id);
}
