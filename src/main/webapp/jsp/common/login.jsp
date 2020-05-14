<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="owntag" tagdir="/WEB-INF/tags" %>

<fmt:bundle basename="property.text" prefix="label.">

    <head>
        <title>Login page</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/styles.css">
    </head>

    <body class="coffee_shop_picture">
    <div class="container-fluid bg-white text-dark text-right">
        <a href="${pageContext.request.contextPath}/controller?command=change_language">ru</a> | <a
            href="${pageContext.request.contextPath}/controller?command=change_language">en</a>
    </div>

    <div class="container p-3 text-dark">
        <nav class="navbar navbar-expand-sm  bg-dark navbar-dark">
            <a class="navbar-brand" href="#"><fmt:message key='logo'/></a>
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/jsp/common/home.jsp"><fmt:message
                            key="home"/></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/jsp/common/menu.jsp"><fmt:message
                            key="menu"/></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link"
                       href="${pageContext.request.contextPath}/controller?command=to_account_page"><fmt:message
                            key="account"/></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link"
                       href="${pageContext.request.contextPath}/controller?command=to_basket_page"><fmt:message
                            key="basket"/></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/jsp/common/login.jsp"><fmt:message
                            key="login"/></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/controller?command=logout"><fmt:message
                            key="logout"/></a>
                </li>
            </ul>
        </nav>
    </div>

    <div class="container p-3">
        <form action="controller" method="post">
            <input type="hidden" name="command" value="login"/>
            <div class="form-group">
                <input type="text" class="form-control" name="login" value="" placeholder="Enter Login" required>
            </div>
            <div class="form-group">
                <input type="password" class="form-control" name="password" value="" placeholder="Enter Password"
                       required></br>
            </div>
            <div class="form-group">
                <input type="submit" class="btn btn-dark" value="Enter">
            </div>
        </form>
    </div>

    </body>

    <div class="container">
        <owntag:footer/>
    </div>

</fmt:bundle>


