package lessonTen.dao;

import lessonTen.dto.StudentDTO;

import java.util.List;

public interface StudentDAO {
    List getAll();

    Object getStudentById(long id);

    void setStudentById(Integer id, StudentDTO studentVar);

    void setStudent(StudentDTO studentVar);

    void deleteStudentById(long id);
}
