<%--设置jsp的中文需要用这个--%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
    <meta charset="UTF-8"/>
</head>
<body>
<h2>Hello World!</h2>
<form action="/hello" method="get">
    <input name="name" type="text">
    <input name="password" type="text">
    <button type="submit">asd</button>
</form>
<form action="/hello" method="post">
    <input name="name" type="text">
    <input name="password" type="text">
    <select name="select" id="">
        <option value="chinese">中文</option>
        <option value="math">数学</option>
        <option value="english">英语</option>
    </select>
    <button type="submit">asd</button>
</form>
<div>asd</div>
</body>
</html>