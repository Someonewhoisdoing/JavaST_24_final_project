<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="owntag" tagdir="/WEB-INF/tags" %>

<fmt:bundle basename="property.text" prefix="label.">

    <head>
        <title><fmt:message key="login_key"/></title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/styles.css">
    </head>

    <body class="coffee_shop_picture">

   <owntag:menu/>

    <div class="container p-3">
        <form action="${pageContext.servletContext.contextPath}/controller" method="post">
            <input type="hidden" name="command" value="login"/>
            <div class="form-group">
                <input type="text" class="form-control" name="login" value=""
                       placeholder="<fmt:message key='enter_login_key'/>"
                       pattern="([a-zA-Z0-9_]+){4,10}" required>
            </div>
            <div class="form-group">
                <input type="password" class="form-control" name="password" value=""
                       placeholder="<fmt:message key='enter_password_key'/>"
                       required>
            </div>
            <div class="form-group">
                <input type="submit" class="btn btn-primary" value="<fmt:message key='enter_key'/>">
            </div>
        </form>
    </div>

    <div class="container p-3">
        <owntag:footer/>
    </div>

    </body>


</fmt:bundle>


