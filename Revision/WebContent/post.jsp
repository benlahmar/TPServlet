<%@page import="com.model.Commentaire"%>
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
<link href="css/bootstrap.min.css" type="text/css" rel="styleSheet" />
<script type="text/javascript" src="js/bootstrap.min.js"></script>
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
<div class="row">
<div class="col-lg-8">
<div class="card border-primary mb-3">

<h2 class="card-header"><%= p.getTitre() %> </h2>
<div class="card-body">
<p><%= p.getContnent() %> </p>
<div class="container">
<div class="row">
<ul class="list-group col-12">
  
<% 
List<Commentaire> cs= dao.allcommentaire(p.getIdp());
for(Commentaire cm:cs)
{
%>
<li class="list-group-item d-flex justify-content-between align-items-center">
    <%=cm.getContenu() %>
    <span class="badge bg-primary rounded-pill"><%=cm.getDate() %></span>
 </li>

<%} %>
</ul>
</div>
<div class="row">
<div class="col-md-8">
<form action="Addcom"  class=" container ">
<div class="form-floating mb-3">
  <textarea class="form-control" name="contenu" placeholder="Leave a comment here" id="floatingTextarea2" style="height: 100px"></textarea>
  
</div>
<input type="hidden" name="idp" value="<%= p.getIdp()%>"/>
<input type="hidden" name="idu" value="<%= us.getId()  %>"/>
<input type="submit" class="btn btn-info" value="add"/>
</form>
</div>
</div>
</div>
<div class="card-footer bg-transparent border-success">Footer</div>
</div>
</div>
</div>
</div>
<%} %>

</div>
</body>
</html>