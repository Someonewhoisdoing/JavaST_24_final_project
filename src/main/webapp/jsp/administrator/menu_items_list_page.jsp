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

    <div class="container p-3">
        <h3><fmt:message key="list_of_menu_items_key"/></h3>
    </div>

    <div class="container">
        <table class="table table-bordered">
            <thead class="thead-dark">
            <tr>
                <th><fmt:message key="id_key"/></th>
                <th><fmt:message key="title_key"/></th>
                <th><fmt:message key="weight_key"/></th>
                <th><fmt:message key="cost_key"/></th>
                <th><fmt:message key="ingredients_key"/></th>
                <th><fmt:message key="action_key"/></th>
            </tr>
            </thead>

            <c:forEach items="${sessionScope.menuItemList}" var="item">
                <tbody>
                <tr>
                    <td><c:out value="${item.id}"/></td>
                    <td><c:out value="${item.name}"/></td>
                    <td><c:out value="${item.weight}"/></td>
                    <td><c:out value="${item.cost}"/></td>
                    <td><c:out value="${item.ingredientName}"/></td>
                    <td>
                        <form action="${pageContext.request.contextPath}/controller" method="post">
                            <input type="hidden" name="id" value="${item.id}"/>
                            <input type="hidden" name="command" value="to_add_menu_item_page"/>
                            <button type="submit" class="btn btn-primary"><fmt:message key="add_key"/></button>
                        </form>
                        <form action="${pageContext.request.contextPath}/controller" method="post">
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
