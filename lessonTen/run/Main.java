package lessonTen.run;

import lessonTen.dao.StudentDAOImpl;
import lessonTen.dto.StudentDTO;

public class Main {
    public static void main(String[] Args) {
        StudentDAOImpl student = new StudentDAOImpl();
        StudentDTO studentas = new StudentDTO("Anton", "Boris", 2010);
        student.deleteById(7);
    }
}