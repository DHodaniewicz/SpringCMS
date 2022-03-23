<%--
  Created by IntelliJ IDEA.
  User: danny
  Date: 23.03.2022
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>Articles</title>
  </head>
  <body>
  <table>
  <%--@elvariable id="article" type="pl.coderslab.entity.Article"--%>
  <c:forEach items="${articles}" var="article">
    <tr>
      <td>${article.title}</td>
      <td>${article.content}</td>
      <td>${article.author.lastName}</td>
    </tr>
  </c:forEach>
  </table>
  </body>
</html>
