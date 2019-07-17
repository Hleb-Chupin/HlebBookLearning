<%@ page import="lessonTen.dao.StudentDAOImpl" %>
<%@ page import="lessonTen.dto.StudentDTO" %>
<%@ page import="javax.servlet.http.HttpServletResponse" %>
<%@ page import="javax.servlet.http.HttpServlet" %>
<%@ page import="java.io.PrintWriter" %>


<html>
    <head>
        <title>
            Hello World Servlet
        </title>
    </head>

    <body>
             <br />
             <br />
             <br />


        <form name = "read" method = "GET">
             Please check this button if you need to <b>READ</b> all the students from our School database:
             <input type = "button" <%StudentDAOImpl student = new StudentDAOImpl();
                     PrintWriter pr = resp.getWriter();
                                                for (int i = 1; i < 7; i++) {
                                                             for (StudentDTO o : student.getStudentByIdWithMarkAndSubject(i)) {%>
                                                                 <%=o.getId();%>
                                                                 <%=o.getName();%>
                                                                 <%=o.getSecondName();%>
                                                                 <%=o.getSubjectName();%>
                                                                 <%=o.getMark();%>
                                                             <%}
                                                         }%>value="Read data">
             <br />
          </form>
          
        <form action = "update.jsp" method = "GET">
        Please check this button if you need to <b>UPDATE</b> the data from our School database: <input type = "submit" value="Update data">
        <br />
        </form>
                    
                    
        <form action = "read.jsp" method = "GET">
        Please check this button if you need to <b>DELETE</b> the data from our School database: <input type = "submit" value="Delete data">
        <br />
        </form>


        <h1>
            <%
        String name = request.getParameter("name");
        if (name == null || name.length() == 0) {
            %>
            Hello, world !
            <%            } else {
            %>
            Hello, world ! I'm <%= name%>
            <%
        }
            %>
        </h1>
    </body>
</html>