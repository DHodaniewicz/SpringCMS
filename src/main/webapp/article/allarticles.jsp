<%--
  Created by IntelliJ IDEA.
  User: danny
  Date: 16.03.2022
  Time: 20:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>Title</title>
  </head>
  <body>
  <%--@elvariable id="article" type="pl.coderslab.entity.Article"--%>
  <c:forEach items="${articles}" var="article">
    <li>${article.title} ${article.content} ${article.author.firstName} ${article.author.lastName} </li>
  </c:forEach>
  
  </body>
</html>
