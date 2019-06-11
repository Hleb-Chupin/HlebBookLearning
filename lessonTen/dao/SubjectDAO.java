package lessonTen.dao;

import lessonTen.dto.MarkDTO;
import lessonTen.dto.SubjectDTO;

import java.util.List;

public interface SubjectDAO {
    List getAll();

    Object getSubjectById(long id);

    void insertSubjectById(SubjectDTO subjectVar);

    void insertSubject(SubjectDTO subjectVar);

    void deleteById(long id);
}
