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


        <form action = "read.jsp" method = "GET">
             Please check this button if you need to <b>READ</b> the data from our School database: <input type = "submit" value="Read data">
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