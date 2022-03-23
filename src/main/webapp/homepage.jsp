<%--
  Created by IntelliJ IDEA.
  User: danny
  Date: 09.03.2022
  Time: 19:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>Homepage</title>
  </head>
  <body>
  <table>
    <%--@elvariable id="category" type="pl.coderslab.entity.Category"--%>
  <c:forEach items="${categoryList}" var="category">
    <tr>
      <td><a href="/all-articles/${category.id}"/> ${category.name}</td>
      <td>${category.description}</td>
    </tr>
  </c:forEach>
  </table>
  
  </body>
</html>
