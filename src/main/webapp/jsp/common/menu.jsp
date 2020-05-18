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
    <div class="container-fluid bg-white text-dark text-right">
        <form action="${pageContext.servletContext.contextPath}/controller" method="post">
            <input type="hidden" name="command" value="change_language"/>
            <button type="submit" class="btn btn-link" name="locale" value="en_EN">en</button>
            |
            <button type="submit" class="btn btn-link" name="locale" value="ru_RU">ru</button>
        </form>
    </div>

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

    <div class="container style='margin-top:30px'">
        <div class="row p-3 mt-3">

            <c:forEach items="${sessionScope.menuItemsPlusInfo}" var="item">
                <div class="col-sm-4">
                    <div class="card border-0">
                        <img class="rounded w-75 h-75" src="<c:url value="/static/image/cup.jpg"/>"
                             alt="Coffee paper cup image"/>
                        <div class="card-body">
                            <form action="${pageContext.request.contextPath}/controller" method="post">
                                <input type="hidden" name="command" value="add_order_item_to_basket"/>
                                <h6 class="card-title"><fmt:message key="id_key"/>: ${item.id}</h6>
                                <h6 class="card-title"><fmt:message key="title_key"/>: ${item.name}</h6>
                                <h6 class="card-title"><fmt:message key="weight_key"/>: ${item.weight}</h6>
                                <h6 class="card-title"><fmt:message key="cost_key"/>: ${item.cost}</h6>
                                <hr class="my-4">
                                <p class="card-text"><fmt:message key="ingredients_key"/>: ${item.ingredientName}</p>
                                <hr class="my-4">

                                <input type="hidden" name="id" value="${item.id}"/>
                                <input type="submit" class="btn btn-primary btn-lg"
                                       value="<fmt:message key='add_to_basket_key'/>">
                            </form>

                        </div>
                    </div>
                </div>
            </c:forEach>

        </div>
    </div>

    <div class="container">
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

    <div class="container">
        <owntag:footer/>
    </div>

    </body>

</fmt:bundle>

