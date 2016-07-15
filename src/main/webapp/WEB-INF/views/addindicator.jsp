<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<!--[if IE 8]><html class="no-js lt-ie9" lang="en" ><![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js">
<!--<![endif]-->

<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- Fondamentale il viewport per bootstrap (essendo un framework) -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Aggiungi indicatore</title>
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
    <!-- Serve per stampare gli attributi del model (incompatibilita' jstl) -->
    <%@ page isELIgnored="false" %>
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
                <a class="navbar-brand" href="${pageContext.request.contextPath}">Progetto
                    SIW</a>
            </div>
            <div id="navbar"
                 class="collapse navbar-collapse navbar-responsive-collapse">
                <ul class="nav navbar-nav">
                    <li><a href="${pageContext.request.contextPath}">Home</a></li>
                    <li><a href="${pageContext.request.contextPath}/about">About</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="${pageContext.request.contextPath}/default">Area
                        personale <span class="sr-only">(current)</span>
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
<div class="container content">
    <div class="row">
        <div
                class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
            <c:if test="${not empty success}">
                <div class="alert alert-info">${success}</div>
            </c:if>
            <form method="POST"
                       action="${pageContext.request.contextPath}/admin/updateindicator/${examTypeId}">
                <h2 class="text-center">Aggiungi indicatore per: ${examType.name}</h2>
                <hr class="colorgraph">
                <div class="row">
                    <div class="form-group col-sm-12 col-md-12">
                        <input name="name" class="form-control input-lg"
                                    placeholder="Nome"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-12 col-md-4 col-md-offset-2">
                        <input type="submit" value="Inserisci"
                               class="btn btn-success btn-block btn-lg" tabindex="7">
                    </div>
                    <div class="col-sm-12 col-md-4">
                        <a href="${pageContext.request.contextPath}/admin/indicator/${examTypeId}" class="btn btn-primary btn-block btn-lg">
                            Lista indicatori </a>
                    </div>
                    <br/>
                </div>
            </form>
        </div>
    </div>
</div>
<footer class="footer navbar-fixed-bottom">
    <div class="container">
        <p class="footer">Progetto per il corso di Sistemi Informativi
            sul Web a.a. 2015-2016</p>
        <p class="footer">Realizzato da: Ion Chiriac e Giuseppe Matera</p>
    </div>
</footer>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="<c:url value='/resources/js/jquery-1.9.1.min.js' />"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="<c:url value='/resources/js/bootstrap.min.js' />"></script>
</body>