package lessonTen.dao;

import lessonTen.dto.MarkDTO;
import java.util.List;

public interface MarkDAO {
    List getAll();

    Object getMarkById(long id);

    void insertMarkById(MarkDTO markVar);

    void insertMark(MarkDTO markVar);

    void deleteById(long id);
}
