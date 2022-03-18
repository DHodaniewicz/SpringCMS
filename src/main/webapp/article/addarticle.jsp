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
  <form:form method="post" modelAttribute="article" action="/article/add">
    <p>
    <form:label path="title">Podaj tytuł artykulu:</form:label>
    <form:input path="title" />
    </p>
    <p>
    <form:label path="content">Podaj zawartosc artykulu:</form:label>
    <form:input path="content" />
    </p>
    <p>
    <form:select itemValue="id" itemLabel="firstName"
                 path="author.id" items="${availableAuthors}"/>
    </p>
    <p>
      <form:select path="categories" itemLabel="name"
                   itemValue="id" items="${availableCategories}" multiple="true" />
    </p>
    <p><input type="submit" value="Save"></p>
  </form:form>

  </body>
</html>
