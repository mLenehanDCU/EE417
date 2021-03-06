<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link href="styles.css" rel="stylesheet" type="text/css">
</head>
<body>
	<header>
		<nav class="header-items">
			<ul>
				<li><a href="home.html">Home</a></li>
				<li><a href="categories.html">Categories</a></li>
				<li><a href="about.html">About</a></li>
				<li class="header-item-signup">
					<table>
						<tr>
							<td>
								<form id="searchbox" action="">
									<input id="searchInput" type="text" value="Search">
								</form>
							</td>
							<td><a href="login.jsp" style="color: #ecf0f1">Login</a></td>
							<td><a href="signup.jsp" style="color: #ecf0f1">Sign-Up</a></td>
						</tr>
					</table>
				</li>
			</ul>
		</nav>
	</header>

	<div class="main">
		<div class="container">
			<div class="content-box">
				<div class="content-header">
					<ul>
						<li>Login</li>
					</ul>
				</div>
				<div class="content">
					<form method="post" action="LoginCheck">
						<table>
							<tr>
								<td>Username</td>
								<td><input type="text" name="username"></td>
							</tr>
							<tr>
								<td>Password</td>
								<td><input type="password" name="password"></td>
							</tr>
							<tr>
								<td></td>
								<td><input type="submit" name="login" value="Login">
									<input type="submit" name="signup" value="Sign Up"></td>
							</tr>
						</table>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>