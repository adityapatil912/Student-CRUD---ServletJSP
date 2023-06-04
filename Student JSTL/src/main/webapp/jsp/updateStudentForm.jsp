<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Form</title>
<style>
/* Center the form on the page */
form {
	margin: 0 auto;
	max-width: 500px;
}

/* Style the form fields */
input[type="text"] {
	padding: 10px;
	margin-bottom: 20px;
	border: none;
	border-radius: 5px;
	box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
}

input[type="text"][readonly] {
	background-color: #eee;
}

/* Style the submit button */
input[type="submit"] {
	background-color: #4CAF50;
	color: white;
	padding: 10px 20px;
	border: none;
	border-radius: 5px;
	cursor: pointer;
}

/* Add some margin to the form fields */
form input {
	margin: 10px 0;
}

/* Align the form labels to the right */
form label {
	display: inline-block;
	text-align: right;
	width: 100px;
	margin-right: 10px;
}

/* Style the form heading */
h1 {
	text-align: center;
	margin-bottom: 20px;
}

/* Style error messages */
.error {
	color: red;
	margin-top: 5px;
}

/* Add some padding to the body */
body {
	padding: 20px;
}
</style>
</head>
<body>
	<form action="UpdateData" method="get">

		Id : <input type="text" name="id" value="${ requestScope.stud.id }"
			readonly="readonly"> <br> Name : <input type="text"
			name="uname" value="${ requestScope.stud.name }"> <br>
		Marks : <input type="text" name="marks"
			value="${ requestScope.stud.marks }"> <br> <input
			type="submit" value="UPDATE">

	</form>
</body>
</html>