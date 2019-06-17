package lessoneleven;

import lessonTen.dao.StudentDAOImpl;
import lessonTen.dto.StudentDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyFirstServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter pr = resp.getWriter();
        pr.println("<B>Список оценок студентов</B>");
        pr.println("<table border=1>");

        StudentDAOImpl student = new StudentDAOImpl();
        for (int i = 1; i < 7; i++) {
            for (StudentDTO o : student.getStudentByIdWithMarkAndSubject(i)) {
                pr.println("<tr>");
                pr.println("<td>" + o.getId() + "</td>");
                pr.println("<td>" + o.getName() + "</td>");
                pr.println("<td>" + o.getSecondName() + "</td>");
                pr.println("<td>" + o.getSubjectName() + "</td>");
                pr.println("<td>" + o.getMark() + "</td>");
                pr.println("</tr>");
            }
        }
        pr.println("</table>");
    }
}

