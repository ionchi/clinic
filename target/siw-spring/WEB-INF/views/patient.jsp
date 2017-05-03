<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<!--[if IE 8]><html class="no-js lt-ie9" lang="en" ><![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js">
<!--<![endif]-->

<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<!-- Fondamentale il viewport per bootstrap (essendo un framework) -->
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Pazienti</title>
	<!-- Bootstrap -->
	<link href="<c:url value='/resources/css/bootstrap.min.css' />"
		  rel="stylesheet" media="screen">
	<link href="<c:url value='/resources/css/main.css' />" rel="stylesheet"
		  media="screen">
	<!-- Modernizr -->
	<script src="<c:url value='/resources/js/modernizr.js' />"></script>
	<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!-- respond.js per IE8 -->
	<!--[if lt IE 9]>
	<script src="<c:url value='/resources/js/respond.min.js' />"></script>
	<![endif]-->
</head>
<header>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navbar" aria-expanded="false"
						aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar top-bar"></span> <span class="icon-bar middle-bar"></span>
					<span class="icon-bar bottom-bar"></span>
				</button>
				<a class="navbar-brand" href="${pageContext.request.contextPath}">ACME Clinic</a>
			</div>
			<div id="navbar"
				 class="collapse navbar-collapse navbar-responsive-collapse">
				<ul class="nav navbar-nav">
					<li><a href="${pageContext.request.contextPath}">Home</a></li>
					<li><a href="${pageContext.request.contextPath}/about">About</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="${pageContext.request.contextPath}/default">User Area<span class="sr-only">(current)</span>
					</a></li>
					<li><a
							href="<c:url value="${pageContext.request.contextPath}/j_spring_security_logout" />">Logout
						<span class="sr-only">(current)</span>
					</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
		<!--/.container-fluid -->
	</nav>
</header>
<body>
<div class="container content" style="background-color: #fff;">
	<h1>Pazienti</h1>
	<div align="center">
		<table class="table table-hover table-striped">
			<thead>
			<tr>
				<th>No</th>
				<th>Nome</th>
				<th>Cognome</th>
				<th>Username</th>
				<th>Password</th>
				<th>Cancella</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach var="patient" items="${patientsList}" varStatus="status">
				<tr>
					<td><b>${status.index + 1}</b></td>
					<td>${patient.firstName}</td>
					<td>${patient.lastName}</td>
					<td>${patient.username}</td>
					<td>${patient.password}</td>
					<td><a
							href="${pageContext.request.contextPath}/admin/deleteP/${patient.id}" class="btn btn-danger ">Cancella</a></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		<div>
			<a href="${pageContext.request.contextPath}/admin/addpatient"
			   class="btn btn-success">Aggiungi Paziente</a>
		</div>
		<br />
	</div>
</div>
<footer class="footer navbar-fixed-bottom">
	<div class="container">
		<p class="footer">Acme Clinic © All rights reserved </p>
	</div>
</footer>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="<c:url value='/resources/js/jquery-1.9.1.min.js' />"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="<c:url value='/resources/js/bootstrap.min.js' />"></script>
</body>
</html>
