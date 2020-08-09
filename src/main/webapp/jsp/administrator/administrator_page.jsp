<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="owntag" tagdir="/WEB-INF/tags" %>

<fmt:bundle basename="property.text" prefix="label.">

    <head>
        <title><fmt:message key="administrator_key"/></title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/styles.css">
    </head>

    <body>

    <owntag:menu/>

    <div class="container p-3">
        <div class="row">

            <div class="col-sm-12">
                <form action="${pageContext.request.contextPath}/controller" method="post">
                    <input type="hidden" name="command" value="users_list"/>
                    <button type="submit" class="btn btn-primary btn-block"><fmt:message
                            key="show_all_users_key"/></button>
                </form>
            </div>

            <div class="col-sm-12">
                <form action="${pageContext.request.contextPath}/controller" method="post">
                    <input type="hidden" name="page" value="${1}"/>
                    <input type="hidden" name="command" value="items_list"/>
                    <button type="submit" class="btn btn-primary btn-block"><fmt:message
                            key="show_all_menu_items_key"/></button>
                </form>
            </div>

        </div>
    </div>

    <div class="container p-3">
        <owntag:footer/>
    </div>

    </body>

</fmt:bundle>
