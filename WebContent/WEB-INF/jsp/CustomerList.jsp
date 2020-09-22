<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Page</title>
</head>
<body>
<h1>Customer List Page</h1>
<h2>
   <a href="new">Add New Customer</a>
   &nbsp;&nbsp;&nbsp;
   <a href="list">List All Customers</a>
</h2>
<table border="1">
<tr>
  <th>Id</th>
  <th>Name</th>
  <th>Gender</th>
  <th>City</th>
  <th>Hobbies</th>
  <th colspan="2">Action</th>
  
<c:forEach var="c" items="${customerList}">
<tr>
   <td>${c.id}</td>
   <td>${c.name}</td>
   <td>${c.gender}</td>
   <td>${c.city}</td>
   <td>${c.hobbies}</td>
   <td>
   <a href="edit?id=${c.id}">Edit</a>
   &nbsp;&nbsp;&nbsp;
   <a onclick="return confirm('Are you sure you want to delete')" href="delete?id=${c.id}">Delete</a>
   </td>     
</tr>
</c:forEach>      
</table>
</body>
</html>