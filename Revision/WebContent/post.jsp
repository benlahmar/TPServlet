<%@page import="com.model.Post"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.DaoManger"%>
<%@page import="com.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="post.css" type="text/css" rel="styleSheet" />
</head>
<body>

<%
User us=(User)session.getAttribute("user");
%>
<h1>
<span>Bonjour Mr.  </span>
<%= us.getLog() %>
</h1>
<form  action="Ajoutpost">
<table>
<tr>
<td colspan="2">Add Post </td>
</tr>
<tr>
<td>titre </td>
<td><input type="text" name="titre"/> </td>
</tr>
<tr>
<td>contenu </td>
<td>
<input type="text" name="contenu"/>
<input type="hidden" name="iduser" value="<%=us.getId()%>" />
</td>
</tr>

<tr>
<td><input type="reset" value="Annuler"/>  </td><td><input type="submit" value="valider"/>  </td>
</tr>
</table>
</form>

<div>
<%
DaoManger dao=new DaoManger();
List<Post> posts=dao.findpostsByUser(us.getId());
for(Post p:posts)
{
%>
<div class="post">

<h2><%= p.getTitre() %> </h2>
<p><%= p.getContnent() %> </p>
<div class="com">
<form action="Addcom" >
<textarea rows="3" cols="20" name="contenu"></textarea>
<input type="hidden" name="idp" value="<%= p.getIdp()%>"/>
<input type="hidden" name="idu" value="<%= us.getId()  %>"/>
<input type="submit" value="add"/>
</form>
</div>

</div>
<%} %>

</div>
</body>
</html>