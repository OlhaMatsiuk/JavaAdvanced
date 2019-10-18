<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Cabinet</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
		
			<c:if test="${mode == 'VIEW'}">
				<h3>${student.firstName}</h3>
				<br>
				<h3>${student.lastName}</h3>
				<br>
				<h3>${student.age}</h3>
				<br>
				<h3><img src="data:image/jpeg;base64,${photo}"> </h3>
			</c:if>
	</div>

</body>
</html>