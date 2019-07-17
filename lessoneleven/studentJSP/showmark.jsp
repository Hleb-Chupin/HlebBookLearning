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

        <B>The score list</B>
                     <br />
                     <br />
        <table border=1>
        <tr>
        <th>id</th>
        <th>Name</th>
        <th>Second Name</th>
        <th>Mark</th>
        <th>Subject</th>
        <th>Edit student</th>
        <th>Delete student</th>
        <c:forEach items="${StudentsAndMarksList}" var="student">

        <tr>
                <td>${student.markId}</td>
                <td>${student.name}</td>
                <td>${student.secondName}</td>
                <td>${student.mark}</td>
                <td>${student.subjectName}</td>
                <td><a href="index?editParam=${student.id}">Edit mark</a></td>
                <td><a href="index?deleteParam=${student.id}">Delete mark</a></td>
                </tr>
        </c:forEach>
        <tr>
        </table>
                             <br />
                     <br />
                <a href="">Go to first page</a>
        </h1>
    </body>
</html>