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

@WebServlet(urlPatterns = {"/show"})
public class ShowServlet extends HttpServlet {

    public ShowServlet() {
        super();
    }

    StudentDAOImpl student = new StudentDAOImpl();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String reqMark = req.getParameter("mark");
        if (reqMark != null) {
            int showMark = Integer.parseInt(reqMark);
            List<StudentDTO> studentList = student.getStudentByIdWithMarkAndSubject(showMark);
            req.setAttribute("StudentsAndMarksList", studentList);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/showmark.jsp");
            requestDispatcher.forward(req, resp);
        }

        String reqEdit = req.getParameter("edit");
        if (reqEdit != null) {
            int showMark = Integer.parseInt(reqEdit);
            List<StudentDTO> studentList = student.getStudentByIdWithMarkAndSubject(showMark);
            req.setAttribute("StudentsAndMarksList", studentList);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/showmark.jsp");
            requestDispatcher.forward(req, resp);
        }

    }
}

