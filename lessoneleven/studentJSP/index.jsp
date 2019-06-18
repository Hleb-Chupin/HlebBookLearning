<html>
    <head>
        <title>
            Hello World Servlet
        </title>
    </head>

    <body>
        <form name='f1' method='post' action='addactionurl'>
        input elements
        </form>

        <form name='f2' method='post' action='updateactionurl'>
        input elemets
        </form>

        <form name='3' method='post' action='deleteactionurl'>
        input elements
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