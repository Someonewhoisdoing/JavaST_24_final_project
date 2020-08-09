<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="owntag" tagdir="/WEB-INF/tags" %>

<fmt:bundle basename="property.text" prefix="label.">

    <head>
        <title><fmt:message key="menu_key"/></title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/styles.css">
    </head>

    <body>

     <owntag:menu/>

    <div class="container style='margin-top:30px'">
        <div class="row p-3 mt-3">

            <c:forEach items="${sessionScope.itemsInfo}" var="item">
                <div class="col-sm-4">
                    <div class="card border-0">
                        <img class="rounded w-75 h-75" src="<c:url value="/static/image/cup.jpg"/>"
                             alt="Coffee paper cup image"/>
                        <div class="card-body">

                            <form action="${pageContext.request.contextPath}/controller" method="post">
                                <input type="hidden" name="command" value="add_order_item_to_basket"/>
                                <h6 class="card-title"><fmt:message key="id_key"/>: ${item.id}</h6>
                                <h6 class="card-title"><fmt:message key="order_id_key"/>: ${item.orderId}</h6>
                                <h6 class="card-title"><fmt:message key="title_key"/>: ${item.name}</h6>
                                <h6 class="card-title"><fmt:message key="weight_key"/>: ${item.weight}</h6>
                                <h6 class="card-title"><fmt:message key="cost_key"/>: ${item.cost}</h6>

                                <input type="hidden" name="id" value="${item.id}"/>

<c:if test="${sessionScope.userByLoginAndPassword.role == 2}">
                                <input type="submit" class="btn btn-primary btn-lg"
                                       value="<fmt:message key='add_to_basket_key'/>">
</c:if>
                            </form>
                        </div>
                    </div>
                </div>
            </c:forEach>

        </div>
    </div>

    <div class="container p-3">
        <div class="btn-group btn-group-lg">
            <form action="controller" method="post">
                <input type="hidden" name="command" value="to_menu_page"/>
                <button type="submit" class="btn btn-link p-3" name="page" value="1">1</button>
            </form>
            <form action="controller" method="post">
                <input type="hidden" name="command" value="to_menu_page"/>
                <button type="submit" class="btn btn-link p-3" name="page" value="2">2</button>
            </form>
            <form action="controller" method="post">
                <input type="hidden" name="command" value="to_menu_page"/>
                <button type="submit" class="btn btn-link p-3" name="page" value="3">3</button>
            </form>
        </div>
    </div>

    <div class="container p-3">
        <owntag:footer/>
    </div>

    </body>

</fmt:bundle>

