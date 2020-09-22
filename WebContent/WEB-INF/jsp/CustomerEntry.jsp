<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Entry Page</title>
</head>
<body>
<h1>Customer Entry Page</h1>
<h2>
   <a href="new">Add New Customer</a>
   &nbsp;&nbsp;&nbsp;
   <a href="list">List All Customers</a>
</h2>
<form action="${action}" method="post">
<input type="hidden" name="id" value="${customer.id}">
<table border="1">
<tr>
   <th>Name:</th>
   <td>
      <input type="text" name="name" value="${customer.name}">
   </td>
</tr>   
<tr>
   <th>Gender:</th>
   <td>
     <input type="radio" name="gender" value="Male" <c:if test="${'Male' eq customer.gender}">checked="checked"</c:if>  />Male<br>
     <input type="radio" name="gender" value="Female" <c:if test="${'Female' eq customer.gender}">checked="checked"</c:if>  />Female<br>
     <input type="radio" name="gender" value="Others" <c:if test="${'Others' eq customer.gender}">checked="checked"</c:if>  />Others<br>
   </td>
</tr>
<tr>
   <th>City:</th>
   <td>
     <select name="city" style="width:150px">  
     <option>--select--</option>
     <c:forEach var="ct" items="${city_list}"> 
     <option  ${ct == customer.city ? 'selected' : '' }> ${ct} </option> 
        
     </c:forEach>
   
  </select>
   </td>
</tr>
<tr>
   <th>Hobbies</th>
   <td>
     <input type="checkbox" value="A" name="Listening music">Listening music<br>
     <input type="checkbox" value="B" name="Reading books">Reading books<br>
     <input type="checkbox" value="C" name="Travelling">Travelling<br>
     <input type="checkbox" value="D" name="Photograpgy">Photography<br>
     <input type="checkbox" value="E" name="Watch TV">Watch TV<br>
     <input type="checkbox" value="F" name="Ride bike">Ride bike<br>
   </td>
</tr>       
<tr>
   <td colspan="1" align="center">
   <input type="submit" value="submit"/>
   </td>
</tr>
</table>
</form>
</body>
</html>