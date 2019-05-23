<%--
  Created by IntelliJ IDEA.
  User: fqy
  Date: 2018/6/1
  Time: 12:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>




    <%
        System.out.println("hello JSP");

        String contextPath = request.getContextPath();
        out.write(contextPath);
    %>


    <%!
        int a = 3;
    %>

    <%= "hello" %>




    <h1>hello JSP....</h1>


    <%
        response.getWriter().write("response");
    %>
</body>
</html>