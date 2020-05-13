<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<fmt:bundle basename="property.text" prefix="label.">

    <head>
        <title>Basket page</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/styles.css">
    </head>

    <body>

    <div class="container-fluid bg-white text-dark text-right">
        <form action="controller" method="post">
            <input type="hidden" name="command" value="change_language"/>
            <button type="submit" class="btn btn-link" name="locale" value="en_EN">en</button>
            |
            <button type="submit" class="btn btn-link" name="locale" value="ru_RU">ru</button>
        </form>
    </div>

    <div class="container p-3 text-dark">
        <nav class="navbar navbar-expand-sm  bg-dark navbar-dark">
            <a class="navbar-brand" href="#"><fmt:message key='logo'/></a>
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/jsp/common/home.jsp"><fmt:message
                            key="home"/></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/jsp/common/menu.jsp"><fmt:message
                            key="menu"/></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link"
                       href="${pageContext.request.contextPath}/controller?command=to_account_page"><fmt:message
                            key="account"/></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link"
                       href="${pageContext.request.contextPath}/controller?command=to_basket_page"><fmt:message
                            key="basket"/></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/jsp/common/login.jsp"><fmt:message
                            key="login"/></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/controller?command=logout"><fmt:message
                            key="logout"/></a>
                </li>
            </ul>
        </nav>
    </div>

    <div class="container p-3">
        <h3>Your order:</h3>
    </div>

    <div class="container">
        <form action="controller" method="post">
            <input type="hidden" name="command" value="make_order"/>
            <table class="table table-bordered">
                <thead class="thead-dark">
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Action</th>
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
                                <input type="hidden" name="id" value="${item.id}"/>
                                <input type="hidden" name="command" value="delete_order_item"/>
                                <button type="submit" class="btn btn-danger">Delete</button>
                            </form>
                        </td>
                    </tr>
                    </tbody>
                </c:forEach>
            </table>
            <button type="submit" class="btn btn-danger">Make order</button>
        </form>
    </div>

    </body>

    <div class="container">
    </div>

</fmt:bundle>
