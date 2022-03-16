<%--
  Created by IntelliJ IDEA.
  User: danny
  Date: 16.03.2022
  Time: 19:27
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--@elvariable id="category" type="pl.coderslab.entity.Category"--%>
<html>
  <head>
    <title>Update category</title>
  </head>
  <body>
  <p>Uaktualnij kategorie: </p>
  <form:form method="post" modelAttribute="category">
    <form:hidden path="id"/>
    <form:label path="name">Podaj nazwe kategorii:</form:label>
    <form:input path="name" />
    <form:label path="description">Podaj opis kategorii:</form:label>
    <form:input path="description" />
    <input type="submit" value="Save">
  </form:form>
  </body>
</html>
