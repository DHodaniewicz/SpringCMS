<%--
  Created by IntelliJ IDEA.
  User: danny
  Date: 18.03.2022
  Time: 19:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>All authors</title>
  </head>
  <body>
  <ul>
    <c:forEach items="${allAuthors}" var="author">
      <li>${author.id} ${author.firstName} ${author.lastName}  <a href="/author/delete/${author.id}"> DELETE </a>
        <a href="/author/update/${author.id}"> UPDATE </a></li>
    </c:forEach>
  </ul>
  <a href="/author/add">  DODAJ AUTORA </a></p>
  </body>
</html>
