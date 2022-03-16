<%--
  Created by IntelliJ IDEA.
  User: danny
  Date: 09.03.2022
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
  <head>
    <title>Add category</title>
  </head>
  <body>
  <%--@elvariable id="category" type="pl.coderslab.entity.Category"--%>
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
