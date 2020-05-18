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
                       pattern="([a-zA-Z0-9_]+){3,10}" required>
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


