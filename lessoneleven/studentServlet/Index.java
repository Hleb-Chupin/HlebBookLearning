package lessoneleven.studentServlet;

import lessonTen.dao.StudentDAOImpl;
import lessonTen.dto.StudentDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("")
public class Index extends HttpServlet {

    public Index() {
        super();
    }

    StudentDAOImpl student = new StudentDAOImpl();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String showMark = "show_mark";

        String reqMethod = req.getParameter("method");
        if (reqMethod != null) {
            if (reqMethod.equals(showMark)) {
                int mark = Integer.parseInt(req.getParameter("mark"));
                List<StudentDTO> studentList = student.getStudentByIdWithMarkAndSubject(mark);
                req.setAttribute("StudentsAndMarksList", studentList);
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/showmark.jsp");
                requestDispatcher.forward(req, resp);
            }
        } else {
            List<StudentDTO> studentsList = student.getAll();
            req.setAttribute("StudentsList", studentsList);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");
            requestDispatcher.forward(req, resp);

        }
    }
}
