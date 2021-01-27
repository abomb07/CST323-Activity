<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hello</title>
</head>
<body>
	<div align="center">
		<h3>CST323 Activity Application.</h3>
		<br>
		<form:form class="form-inline" method="POST" modelAttribute="user"
			action="adduser">

			<div class="form-group">
				<form:label path="firstName">First Name:</form:label>
				<form:input path="firstName" class="form-control" />
				<form:errors path="firstName" />
			</div>
			<div class="form-group">
				<form:label path="lastName">Last Name:</form:label>
				<form:input path="lastName" class="form-control" />
				<form:errors path="lastName" />
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>

			<form:errors path="*" />
		</form:form>
	</div>
</body>
</html>