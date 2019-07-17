<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
    <head>
        <title>
            Students
        </title>
    </head>

    <body>
             <br />
             <br />
             <br />

        <B>Список оценок студентов</B>
        <table border=1>
        <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Second Name</th>
        <th>Enrolment year</th>
        <th>Student score</th>
        <th>Edit student</th>
        <th>Delete student</th>
        <c:forEach items="${StudentsList}" var="student">

        <tr>
                <td>${student.id}</td>
                <td>${student.name}</td>
                <td>${student.secondName}</td>
                <td>${student.enrolmentYear}</td>
                <td><a href="?method=show_mark&mark=${student.id}">Show ${student.name}'s marks</a></td>
                <td><a href="show?editParam=${student.id}">Edit ${student.name}</a></td>
                <td><a href="show?deleteParam=${student.id}">Delete ${student.name}</a></td>
                </tr>
        </c:forEach>
        <tr>
        </table>

                <br />
             <br />
        <form method="POST" action="${pageContext.request.contextPath}/createProduct">
                 <table border="0">
                    <tr>
                       <td>Name</td>
                       <td><input type="text" name="code" value="${product.code}" /></td>
                    </tr>
                    <tr>
                       <td>Second Name</td>
                       <td><input type="text" name="name" value="${product.name}" /></td>
                    </tr>
                    <tr>
                       <td>Enrolment year</td>
                       <td><input type="text" name="price" value="${product.price}" /></td>
                    </tr>
                    <tr>
                       <td colspan="2">
                           <input type="submit" value="Add new student" />
                       </td>
                    </tr>
                 </table>
              </form>

        </h1>
    </body>
</html>