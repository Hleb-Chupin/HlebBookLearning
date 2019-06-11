package lessonTen.dao;

import lessonTen.dto.StudentDTO;

import java.util.List;

public interface StudentDAO {
    List getAll();

    Object getStudentById(long id);

    void insertStudentById(StudentDTO studentVar);

    void insertStudent(StudentDTO studentVar);

    void deleteStudentById(long id);
}
