<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<fmt:bundle basename="property.text" prefix = "label.">

<head>
<title>User personal page</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/styles.css">
</head>

<body>
<div class="container-fluid bg-white text-dark text-right">
<form action="controller" method="post">
<input type="hidden" name="command" value="change_language"/>
<button type="submit" class="btn btn-link" name="locale" value="en_EN">en</button>|<button type="submit" class="btn btn-link" name="locale" value="ru_RU">ru</button>
</form>
</div>

<div class="container p-3 text-dark">
<nav class="navbar navbar-expand-sm  bg-dark navbar-dark">
<a class="navbar-brand" href="#"><fmt:message key='logo'/></a>
<ul class="navbar-nav">
<li class="nav-item">
<a class="nav-link" href="${pageContext.request.contextPath}/jsp/common/home.jsp"><fmt:message key="home"/></a>
</li>
<li class="nav-item">
<a class="nav-link" href="${pageContext.request.contextPath}/jsp/common/menu.jsp"><fmt:message key="menu"/></a>
</li>
<li class="nav-item">
<a class="nav-link" href="${pageContext.request.contextPath}/controller?command=to_account_page"><fmt:message key="account"/></a>
</li>
<li class="nav-item">
<a class="nav-link" href="${pageContext.request.contextPath}/controller?command=to_basket_page"><fmt:message key="basket"/></a>
</li>
<li class="nav-item">
<a class="nav-link" href="${pageContext.request.contextPath}/jsp/common/login.jsp"><fmt:message key="login"/></a>
</li>
<li class="nav-item">
<a class="nav-link" href="${pageContext.request.contextPath}/controller?command=logout"><fmt:message key="logout"/></a>
</li>
</ul>
</nav>
</div>

<div class="container">
<h2>Edit personal information of the user</h2>
<p>You can change login, password, name, surname, phone</p>

<form action="controller" method="post">
<input type="hidden" name="command" value="edit_user"/>

<table class="table table-bordered">
<thead class="thead-dark">
<tr>
<th>Login</th>
<th>Password</th>
<th>Firstname</th>
<th>Lastname</th>
<th>Phone</th>
</tr>
</thead>
<tbody>
<tr>
<td><input type="text" name="login" default="${request.getParameter("login")}" placeholder="${sessionScope.userByLoginAndPassword.login}" required/></td>
<td><input type="text" name="password" default="${request.getParameter("password")}" placeholder="${sessionScope.userByLoginAndPassword.password}" required/></td>
<td><input type="text" name="name" default="${request.getParameter("name")}" placeholder="${sessionScope.userByLoginAndPassword.name}" required/></td>
<td><input type="text" name="surname" default="${request.getParameter("surname")}" placeholder="${sessionScope.userByLoginAndPassword.surname}" required/></td>
<td><input type="text" name="phone" default="${request.getParameter("phone")}" placeholder="${sessionScope.userByLoginAndPassword.phone}" required/></td>
</tr>
</tbody>
</table>
<input type="hidden" name="login" value="${request.getParameter("currentUser.getLogin()")}"/>
<button type="submit" class="btn btn-dark">Save</button>
</form>
</div>

</body>

<div class="container">
</div>

</fmt:bundle>
