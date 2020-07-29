<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="owntag" tagdir="/WEB-INF/tags" %>

<fmt:bundle basename="property.text" prefix="label.">

    <head>
        <title><fmt:message key="basket_key"/></title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/styles.css">
    </head>

    <body>

      <owntag:menu/>

    <div class="container p-3">
            <table class="table table-bordered">
                <thead class="thead-dark">
                <tr>
                    <th><fmt:message key="id_key"/></th>
                    <th><fmt:message key="title_key"/></th>
                    <th><fmt:message key="cost_key"/></th>
                    <th><fmt:message key="action_key"/></th>
                </tr>
                </thead>

                <c:forEach items="${sessionScope.orderItemList}" var="item">
                    <tbody>
                    <tr>
                        <td><c:out value="${item.id}"/></td>
                        <td><c:out value="${item.name}"/></td>
                        <td><c:out value="${item.price}"/></td>
                        <td>
                            <form action="${pageContext.request.contextPath}/controller" method="post">
                                <input type="hidden" name="command" value="delete_order_item_from_basket"/>
                                <input type="hidden" name="id" value="${item.id}"/>
                                <button type="submit" class="btn btn-primary"><fmt:message key="delete_key"/></button>
                            </form>
                        </td>
                    </tr>
                    </tbody>
                </c:forEach>
            </table>

            <form action="controller" method="post">
            <input type="hidden" name="command" value="make_order_and_show_order_info"/>
            <button type="submit" class="btn btn-primary"><fmt:message key="make_order_key"/></button>
            </form>
    </div>

    <div class="container p-3">
        <owntag:footer/>
    </div>

    </body>

</fmt:bundle>
