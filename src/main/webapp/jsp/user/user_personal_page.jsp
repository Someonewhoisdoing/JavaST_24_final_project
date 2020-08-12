<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="owntag" tagdir="/WEB-INF/tags" %>

<fmt:bundle basename="property.text" prefix="label.">

    <head>
        <title><fmt:message key="user_key"/></title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/styles.css">
    </head>

    <body>

      <owntag:menu/>

    <div class="container p-3">
        <form action="${pageContext.request.contextPath}/jsp/user/edit_personal_information.jsp" method="post">
            <input type="hidden" name="command" value="to_edit_user_info_page"/>

            <table class="table table-bordered">
                <thead class="thead-dark">
                <tr>
                    <th><fmt:message key="login_key"/></th>
                    <th><fmt:message key="name_key"/></th>
                    <th><fmt:message key="lastname_key"/></th>
                    <th><fmt:message key="phone_key"/></th>
                    <th><fmt:message key="action_key"/></th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td><c:out value="${sessionScope.user.login}"/></td>
                    <td><c:out value="${sessionScope.user.name}"/></td>
                    <td><c:out value="${sessionScope.user.surname}"/></td>
                    <td><c:out value="${sessionScope.user.phone}"/></td>
                    <td>
                        <button type="submit" class="btn btn-primary"><fmt:message key="edit_key"/></button>
                    </td>
                </tr>
                </tbody>
            </table>
        </form>
    </div>

    <div class="container p-3">
        <owntag:footer/>
    </div>

    </body>

</fmt:bundle>
