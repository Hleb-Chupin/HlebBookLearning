package lessonTen.dao;

import lessonTen.dto.MarkDTO;
import lessonTen.dto.SubjectDTO;

import java.util.List;

public interface SubjectDAO {
    List getAll();

    Object getSubjectById(long id);

    void setSubjectById(Integer id, SubjectDTO subjectVar);

    void setSubject(SubjectDTO subjectVar);

    void deleteById(long id);
}
