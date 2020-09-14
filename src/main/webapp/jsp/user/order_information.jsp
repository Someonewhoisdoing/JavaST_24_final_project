<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="owntag" tagdir="/WEB-INF/tags" %>

<fmt:bundle basename="property.text" prefix="label.">

    <head>
        <title><fmt:message key="order_key"/></title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/styles.css">
    </head>

    <body>

     <owntag:menu/>

    <div class="container p-3">
        <h3><fmt:message key="your_order_key"/></h3>
    </div>

    <div class="container">
        <table class="table table-bordered">
            <thead class="thead-dark">
            <tr>
                <th><fmt:message key="id_key"/></th>
                <th><fmt:message key="date_key"/></th>
                <th><fmt:message key="name_key"/></th>
                <th><fmt:message key="list_of_drinks_key"/></th>
                <th><fmt:message key="final_price_key"/></th>
            </tr>
            </thead>

            <c:forEach items="${sessionScope.order.items}" var="item">
                <tbody>
                <tr>
                    <td><c:out value="${item.id}"/></td>
                    <td><c:out value="${order.date}"/></td>
                    <td><c:out value="${item.name}"/></td>
                    <td><c:out value="${item.weight}"/></td>
                    <td><c:out value="${item.cost}"/></td>
                </tr>
                </tbody>
            </c:forEach>
        </table>
    </div>

    <div class="container p-3">
        <owntag:footer/>
    </div>

    </body>

</fmt:bundle>
