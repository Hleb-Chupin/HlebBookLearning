package lessonTen.run;

import lessonTen.connectionpool.ConnectionPool;
import lessonTen.dao.MarkDAO;
import lessonTen.dao.MarkDAOImpl;
import lessonTen.dao.StudentDAOImpl;
import lessonTen.dao.SubjectDAOImpl;
import lessonTen.dto.MarkDTO;
import lessonTen.dto.StudentDTO;
import lessonTen.dto.SubjectDTO;

import java.util.List;

public class Main {
    public static void main(String[] Args) {
        StudentDAOImpl student = new StudentDAOImpl();
//        for (StudentDTO o : student.getAll()) {
//            System.out.println(o.getName());
//        }
        MarkDAOImpl mark = new MarkDAOImpl();
        for (MarkDTO o : mark.getAll()) {
            System.out.println(o.getMark());
        }
//        SubjectDAOImpl subject = new SubjectDAOImpl();
//        for (SubjectDTO o : subject.getAll()) {
//            System.out.println(o.getNameSubject());
//        }
////        for (StudentDTO o : student.getStudentByIdWithMarkAndSubject(1)){
//            System.out.println(o.getName() + ", " + o.getSecondName() + ", " + o.getSubjectName()+ ", " + o.getMark());
//        }
    }
}