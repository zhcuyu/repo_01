<%--
  Created by IntelliJ IDEA.
  User: zcy
  Date: 2020/1/4
  Time: 11:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>list</title>
</head>
<body>
    <h2>查询了所有的账户信息</h2>
    ${list}
<%--遍历--%>
<%--<c:forEach items="${list}" var="account">--%>
<%--    ${user.name}--%>
<%--</c:forEach>--%>

</body>
</html>
