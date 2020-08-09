<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="owntag" tagdir="/WEB-INF/tags" %>

<fmt:bundle basename="property.text" prefix="label.">

    <head>
        <title><fmt:message key="account_key"/></title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/styles.css">
    </head>

    <body>

      <owntag:menu/>

    <div class="container p-3">
        <form action="${pageContext.request.contextPath}/controller" method="post">
            <input type="hidden" name="command" value="edit_user"/>

            <table class="table table-bordered">
                <thead class="thead-dark">
                <tr>
                    <th><fmt:message key="login_key"/></th>
                    <th><fmt:message key="name_key"/></th>
                    <th><fmt:message key="lastname_key"/></th>
                    <th><fmt:message key="phone_key"/></th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td><input type="text" name="login"
                               value="${sessionScope.userByLoginAndPassword.login}"
                               pattern="([a-zA-Z0-9_]+){4,10}" required/></td>
                    <td><input type="text" name="name" default="${request.getParameter("name")}"
                               value="${sessionScope.userByLoginAndPassword.name}" pattern="([a-zA-Z]+){1,20}"
                               required/></td>
                    <td><input type="text" name="surname" default="${request.getParameter("surname")}"
                               value="${sessionScope.userByLoginAndPassword.surname}" pattern="([a-zA-Z]+){1,20}"
                               required/></td>
                    <td><input type="text" name="phone" default="${request.getParameter("phone")}"
                               value="${sessionScope.userByLoginAndPassword.phone}" pattern="([\\+0-9]){13}"
                               required/></td>
                </tr>
                </tbody>
            </table>
            <input type="hidden" name="login" value="${sessionScope.userByLoginAndPassword.login}"/>
            <button type="submit" class="btn btn-primary"><fmt:message key="save_key"/></button>
        </form>
    </div>

    <div class="container p-3">
        <owntag:footer/>
    </div>

    </body>


</fmt:bundle>
