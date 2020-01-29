<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: rlecoint2018
  Date: 29/01/2020
  Time: 11:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
hello
<c:forEach items="${lstCategorie}" var="category">
    <h1>Hello</h1>
    <%--    <option value="${category.no_categorie}">${category.libelle}</option>--%>
</c:forEach>
</body>
</html>
