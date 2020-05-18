<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="owntag" tagdir="/WEB-INF/tags" %>

<fmt:bundle basename="property.text" prefix="label.">

    <head>
        <title><fmt:message key="list_of_all_users_key"/></title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/styles.css">
    </head>

    <body>

    <div class="container p-3">
        <div class="btn-group">
            <form action="${pageContext.request.contextPath}/controller" method="post">
                <input type="hidden" name="command" value="back_to_home_page"/>
                <button type="submit" class="btn btn-link"><fmt:message
                        key="home_key"/></button>
            </form>

            <form action="${pageContext.request.contextPath}/controller" method="post">
                <input type="hidden" name="command" value="to_menu_page"/>
                <button type="submit" class="btn btn-link" name="page" value="1"><fmt:message
                        key="menu_key"/></button>
            </form>

            <form action="${pageContext.request.contextPath}/controller" method="post">
                <input type="hidden" name="command" value="to_account_page"/>
                <button type="submit" class="btn btn-link"><fmt:message key="account_key"/></button>
            </form>

            <form action="${pageContext.request.contextPath}/controller" method="post">
                <input type="hidden" name="command" value="to_basket_page"/>
                <button type="submit" class="btn btn-link"><fmt:message key="basket_key"/></button>
            </form>

            <form action="${pageContext.request.contextPath}/controller" method="post">
                <input type="hidden" name="command" value="login"/>
                <button type="submit" class="btn btn-link"><fmt:message key="login_key"/></button>
            </form>

            <form action="${pageContext.request.contextPath}/controller" method="post">
                <input type="hidden" name="command" value="logout"/>
                <button type="submit" class="btn btn-link"><fmt:message key="logout_key"/></button>
            </form>
        </div>
    </div>

    <div class="container p-3">
        <h3><fmt:message key="list_of_all_users_key"/></h3>
    </div>

    <div class="container">
        <table class="table table-bordered">
            <thead class="thead-dark">
            <tr>
                <th><fmt:message key="id_key"/></th>
                <th><fmt:message key="login_key"/></th>
                <th><fmt:message key="password_key"/></th>
                <th><fmt:message key="name_key"/></th>
                <th><fmt:message key="lastname_key"/></th>
                <th><fmt:message key="phone_key"/></th>
            </tr>
            </thead>

            <c:forEach items="${requestScope.users}" var="user">
                <c:if test="${user.role == 2}">
                    <tbody>
                    <tr>
                        <td><c:out value="${user.id}"/></td>
                        <td><c:out value="${user.login}"/></td>
                        <td><c:out value="${user.password}"/></td>
                        <td><c:out value="${user.name}"/></td>
                        <td><c:out value="${user.surname}"/></td>
                        <td><c:out value="${user.phone}"/></td>
                    </tr>
                    </tbody>
                </c:if>
            </c:forEach>
        </table>
    </div>

    <div class="container p-3">
        <owntag:footer/>
    </div>

    </body>


</fmt:bundle>
