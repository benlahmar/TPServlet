<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="cc" uri="/WEB-INF/auth.tld" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.frm{
background-color: rgba(11,44,77,0.6);
border: groove 2px;
border-radius:10px;
box-shadow: 5px 5px 5px 5px; 
width: 300px;
padding: 5px;
margin: 5px;
}
</style>
</head>
<body>
<cc:Auth lang="fr" />
<hr/>
<cc:Auth lang="en" />
</body>
</html>