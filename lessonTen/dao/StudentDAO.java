package lessonTen.dao;

import lessonTen.dto.StudentDTO;
import java.util.List;

public interface StudentDAO {
    List<StudentDTO> findAll ();
    StudentDTO findById (long id);
    void updateById (Integer id, StudentDTO student);
    void saveToDb (StudentDTO student);
    void deleteById (long id);
}
