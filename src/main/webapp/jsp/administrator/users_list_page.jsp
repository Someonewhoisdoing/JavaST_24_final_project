<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@ taglib prefix="owntag" tagdir="/WEB-INF/tags"%>

<fmt:bundle basename="property.text" prefix = "label.">

<head>
<title>List of users page</title>
<meta charset="UTF-8">
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
<a class="nav-link" href="${pageContext.request.contextPath}/jsp/common/login.jsp"><fmt:message key="login"/></a>
</li>
<li class="nav-item">
<a class="nav-link" href="${pageContext.request.contextPath}/controller?command=logout"><fmt:message key="logout"/></a>
</li>
</ul>
</nav>
</div>

<div class="container p-3">
<h3>List of all users:</h3>
</div>

<div class="container">
<table class="table table-bordered">
<thead class="thead-dark">
<tr>
<th>Id</th>
<th>Login</th>
<th>Password</th>
<th>Firstname</th>
<th>Lastname</th>
<th>Phone</th>
<th>Action</th>
</tr>
</thead>

<c:forEach items="${requestScope.users}" var="user">
<c:if test="${user.role == 2}">
<tbody>
<tr>
<td><c:out value = "${user.id}"/></td>
<td><c:out value = "${user.login}"/></td>
<td><c:out value = "${user.password}"/></td>
<td><c:out value = "${user.name}"/></td>
<td><c:out value = "${user.surname}"/></td>
<td><c:out value = "${user.phone}"/></td>
<td>
<form action="${pageContext.request.contextPath}/controller" method="post">
<input type="hidden" name="id" value="${user.id}"/>
<input type="hidden" name="command" value="block_user"/>
<button type="submit" class="btn btn-danger">Block</button>
</form>
</td>
</tr>
</tbody>
</c:if>
</c:forEach>
</table>
</div>

</body>

<div class="container">
<owntag:footer/>
</div>

</fmt:bundle>
