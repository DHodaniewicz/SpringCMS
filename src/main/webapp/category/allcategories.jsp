<%--
  Created by IntelliJ IDEA.
  User: danny
  Date: 09.03.2022
  Time: 20:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>Categories</title>
  </head>
  <body>
  <ul>
  <c:forEach items="${allCategories}" var="category">
    <li>${category.id} ${category.name}  <a href="/category/delete/${category.id}"> DELETE </a>
      <a href="/category/update/${category.id}"> UPDATE </a></li>
  </c:forEach>
  </ul>

  <a href="/category/add">  DODAJ KATEGORIE </a></p>
  </body>
</html>
