package lessonTen.dao;

import lessonTen.dto.StudentDTO;

import java.util.List;

public interface StudentDAO {
    List getAll();

    List getStudentByIdWithMarkAndSubject(int id);

    Object getStudentById(long id);

    void updateStudentById(StudentDTO studentVar);

    void insertStudent(StudentDTO studentVar);

    void deleteStudentById(long id);
}
