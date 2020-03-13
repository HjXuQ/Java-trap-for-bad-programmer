<%--
  Created by IntelliJ IDEA.
  User: xuhj
  Date: 2020/3/13
  Time: 2:13 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%String path = request.getContextPath();%>
</head>
<body>
<!--action这个值就是直接在localhost:8080后边进行拼接，这个肯定要加项目名称的，servlet的访问路径设置的就是项目名称加这个访问路径-->
<form action="<%=path%>/hw" method="post">
    <input type="text" value="请输入汉字" name="test">
    <input type="submit" value="提交">
</form>
</body>
</html>
