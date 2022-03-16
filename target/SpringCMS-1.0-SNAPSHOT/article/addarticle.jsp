<%--
  Created by IntelliJ IDEA.
  User: danny
  Date: 16.03.2022
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>Add article</title>
  </head>
  <body>
  <%--@elvariable id="article" type="pl.coderslab.entity.Article"--%>
  <form method="post" modelAttribute="article">
        <form:label path="title">Podaj tytul artykułu:</form:label>
        <form:input path="title" />
  </form>
  </body>
</html>
