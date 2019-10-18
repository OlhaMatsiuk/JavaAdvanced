<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Hello</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
	
	<style type="text/css">
	
	div.main{
		position: absolute;
		top: 20%;
		left: 20%;
	}
	</style>
</head>
<body>

  <div class = "main">
    <form method="post" action="/registration" enctype="multipart/form-data">
    
      <input type="text" name="firstName"/>
      <br>
       <br>
      <input type="text" name="lastName"/>
       <br>
        <br>
      <input type="number" name="age"/>
       <br>
        <br>
       <input type="file" name="photo" required/>
        <br>
         <br>
      <button type ="submit">Submit</button>
    </form>
  </div>


</body>
</html>