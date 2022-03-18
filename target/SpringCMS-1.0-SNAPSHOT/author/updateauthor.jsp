<%--
  Created by IntelliJ IDEA.
  User: danny
  Date: 18.03.2022
  Time: 20:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
  <head>
    <title>Update author</title>
  </head>
  <body>
  <%--@elvariable id="author" type="pl.coderslab.entity.Author"--%>
  <form:form method="post" modelAttribute="author">
    <form:hidden path="id"/>
    <form:label path="firstName">Podaj imie autora:</form:label>
    <form:input path="firstName" />
    <form:errors path="firstName" cssClass="error" element="div" />
    <form:label path="lastName">Podaj nazwisko autora:</form:label>
    <form:input path="lastName" />
    <form:errors path="lastName" cssClass="error" element="div" />
    <input type="submit" value="Save">
  </form:form>
  </body>
</html>
