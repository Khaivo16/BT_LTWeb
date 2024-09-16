<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Enter Information</title>
</head>
<body>

	<style>
@import
	url('https://fonts.googleapis.com/css2?family=Montserrat:wght@300;400;500&display=swap')
	;

* {
	box-sizing: border-box;
}

body {
	text-align: center;
	font-family: 'Montserrat', sans-serif;
	font-size: 17px;
}

#wrapper {
	display: flex;
	justify-content: center;
	align-items: center;
	min-height: 80vh;
}

form {
	border: 1px solid #dadce0;
	border-radius: 5px;
	padding: 30px;
}

h3 {
	text-align: center;
	font-size: 24px;
	font-weight: 500;
}

p{
	text-align: center;
	font-size: 18px;
	font-weight: 500;
}

.form-group {
	margin-bottom: 15px;
	position: relative;
}

input, select {
	height: 50px;
	width: 300px;
	outline: none;
	border: 1px solid #dadce0;
	padding: 10px;
	border-radius: 5px;
	font-size: inherit;
	color: #202124;
	transition: all 0.3s ease-in-out;
}

button {
	height: 50px;
	width: 300px;
	outline: none;
	border: 1px solid #dadce0;
	padding: 10px;
	border-radius: 5px;
	font-size: inherit;
	color: #202124;
	transition: all 0.3s ease-in-out;
}

label {
	position: absolute;
	left: 10px;
	top: -10px; /* Đặt label cố định phía trên */
	font-size: 12px;
	font-weight: 600;
	background: #fff;
	color: #1a73e8;
	transition: all 0.3s ease-in-out;
}

.form-group input:focus, .form-group select:focus {
	border: 2px solid #1a73e8;
}

.form-group input:focus+label, .form-group input:valid+label {
	top: -10px;
	font-size: 12px;
	font-weight: 600;
	color: #1a73e8;
	background-color: white;
}

input#btn-signup {
	background: #1a73e8;
	color: #fff;
	cursor: pointer;
}

input#btn-signup:hover {
	opacity: 0.85;
}

button#btn-login {
	background: #1a73e8;
	color: #fff;
	cursor: pointer;
}

button#btn-login:hover {
	opacity: 0.85;
}
</style>

	<div id="wrapper">
		<form action="/login_register/Info/home" method="post">
			<h3>Information</h3>
			<p>Please fill in Information here.</p>

			<div class="form-group">
				<input type="text" name="fullname" required> 
                <label for="fullname">Fullname</label>
			</div>

			<div class="form-group">
				<label for="roleid">RoleID</label>
				<select name="roleid" id="roleid" required>
					<option value="">--Chọn vai trò--</option>
					<option value="1">User</option>
					<option value="2">Admin</option>
					<option value="3">Manager</option>
				</select>
			</div>

			<div class="form-group">
				<input type="text" name="phone" required> 
                <label for="phone">PhoneNumber</label>
			</div>

			<input type="submit" value="Submit" id="btn-signup"> <br>

			<button type="button" id="btn-login"
				onclick="window.location.href='login.jsp'">Cancel</button>
		</form>
	</div>

</body>
</html>
