<%@page import="com.jsp.ecommerce_jee_project.entity.ProductOwner"%>
<%@page import="java.util.List"%>
<%@page
	import="com.jsp.ecommerce_jee_project.dao.impl.ProductOwnerDaoImpl"%>
<%@page import="com.jsp.ecommerce_jee_project.dao.ProductOwnerDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Owner-Details</title>
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/8.2.0/mdb.min.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
</head>
<body>
	<%
		ProductOwnerDao dao = new ProductOwnerDaoImpl();
		
	    List<ProductOwner> owners=dao.getAllVerifiedProductOwnerDao();
	%>

	<table class="table">
		<thead>
			<tr>
				<th scope="col">Owner-Id</th>
				<th scope="col">Owner-Name</th>
				<th scope="col">Owner-Email</th>
				<th scope="col">Owner-Verification</th>
			</tr>
		</thead>
		<tbody>
			<%for(ProductOwner owner:owners){%>
			<tr>
				<td><%=owner.getOwnerId()%></td>
				<td><%=owner.getOwnerName()%></td>
				<td><%=owner.getOwnerEmail()%></td>
				<td><%=owner.getOwnerVerify()%>  <a href="ownerUnVerify?id=<%=owner.getOwnerId()%>">unverify</a></td>
			</tr>
			<%}%>
		</tbody>
	</table>
</body>
</html>