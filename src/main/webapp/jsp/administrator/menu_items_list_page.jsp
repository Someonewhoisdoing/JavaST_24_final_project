<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="owntag" tagdir="/WEB-INF/tags" %>

<fmt:bundle basename="property.text" prefix="label.">

    <head>
        <title><fmt:message key="list_of_menu_items_key"/></title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/styles.css">
    </head>

    <body>

     <owntag:menu/>

    <div class="container p-3">
        <h3><fmt:message key="list_of_menu_items_key"/></h3>
    </div>

    <div class="container">
        <table class="table table-bordered">
            <thead class="thead-dark">
            <tr>
                <th><fmt:message key="id_key"/></th>
                <th><fmt:message key="order_id_key"/></th>
                <th><fmt:message key="title_key"/></th>
                <th><fmt:message key="weight_key"/></th>
                <th><fmt:message key="cost_key"/></th>
                <th><fmt:message key="action_key"/></th>
            </tr>
            </thead>

            <c:forEach items="${sessionScope.itemList}" var="item">
            <c:set var="count" value="${pageScope.count+1}"/>
                <tbody>
                <tr>
                    <td><c:out value="${item.id}"/></td>
                    <td><c:out value="${item.orderId}"/></td>
                    <td><c:out value="${item.name}"/></td>
                    <td><c:out value="${item.weight}"/></td>
                    <td><c:out value="${item.cost}"/></td>
                    <td>
                        <form action="${pageContext.request.contextPath}/jsp/administrator/edit_menu_item.jsp?id=${count}&page=${param.page}" method="post">
                            <input type="hidden" name="id" value="${item.id}"/>
                            <input type="hidden" name="command" value="to_edit_menu_item_page"/>
                            <button type="submit" class="btn btn-primary"><fmt:message key="edit_key"/></button>
                        </form>
                    </td>
                </tr>
                </tbody>
            </c:forEach>
        </table>
    </div>

    <div class="container p-3">
        <div class="btn-group btn-group-lg">
            <form action="${pageContext.request.contextPath}/controller" method="post">
                <input type="hidden" name="command" value="items_list"/>
                <button type="submit" class="btn btn-link p-3" name="page" value="1">1</button>
            </form>
            <form action="${pageContext.request.contextPath}/controller" method="post">
                <input type="hidden" name="command" value="items_list"/>
                <button type="submit" class="btn btn-link p-3" name="page" value="2">2</button>
            </form>
            <form action="${pageContext.request.contextPath}/controller" method="post">
                <input type="hidden" name="command" value="items_list"/>
                <button type="submit" class="btn btn-link p-3" name="page" value="3">3</button>
            </form>
        </div>
    </div>

    <div class="container p-3">
        <owntag:footer/>
    </div>

    </body>


</fmt:bundle>
