package lessonTen.dao;

import lessonTen.dto.MarkDTO;
import java.util.List;

public interface MarkDAO {
    List getAll();

    Object getMarkById(long id);

    void updateMarkById(MarkDTO markVar);

    void insertMark(MarkDTO markVar);

    void deleteById(long id);
}
