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
<h2>Personal information of the user</h2>
<p>You can change login, password, first name, last name, phone</p>

<form action="controller" method="post">
<input type="hidden" name="command" value="to_edit_user_info_page"/>

<table class="table table-bordered">
<thead class="thead-dark">
<tr>
<th>Login</th>
<th>Password</th>
<th>Firstname</th>
<th>Lastname</th>
<th>Phone</th>
<th>Actions</th>
</tr>
</thead>
<tbody>
<tr>

<td><c:out value = "${sessionScope.userByLoginAndPassword.login}"/></td>
<td><c:out value = "${sessionScope.userByLoginAndPassword.password}"/></td>
<td><c:out value = "${sessionScope.userByLoginAndPassword.name}"/></td>
<td><c:out value = "${sessionScope.userByLoginAndPassword.surname}"/></td>
<td><c:out value = "${sessionScope.userByLoginAndPassword.phone}"/></td>
<td><button type="submit" class="btn btn-danger">Edit</button></td>
</tr>
</tbody>
</table>
</form>
</div>

</body>

<div class="container">
</div>

</fmt:bundle>
