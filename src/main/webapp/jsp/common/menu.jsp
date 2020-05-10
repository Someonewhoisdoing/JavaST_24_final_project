<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<fmt:bundle basename="property.text" prefix="label.">

    <head>
        <title>Menu page</title>
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

    <div class="container style='margin-top:30px'">
        <div class="row p-3 mt-3">

            <c:forEach items="${requestScope.menuItemsPlusInfo}" var="item">
                <div class="col-sm-4">
                    <div class="card border-0">
                        <img class="rounded w-75 h-75" src="<c:url value="/static/image/cup.jpg"/>"
                             alt="Coffee paper cup image"/>
                        <div class="card-body">
                            <h4 class="card-title">${item.id}</h4>
                            <h4 class="card-title">${item.name}</h4>
                            <h4 class="card-title">${item.weight}</h4>
                            <h4 class="card-title">${item.cost}</h4>
                            <hr class="my-4">
                            <p class="card-text">${item.ingredientName}</p>
                            <hr class="my-4">

                            <form action="${pageContext.request.contextPath}/controller" method="post">
                                <input type="hidden" name="id" value="${item.id}"/>
                                <input type="hidden" name="command" value="order"/>
                                <input type="submit" class="btn btn-danger btn-lg" value="Order">
                            </form>

                        </div>
                    </div>
                </div>
            </c:forEach>

        </div>
    </div>

    <div class="container">
        <form action="controller" method="post">
            <input type="hidden" name="command" value="to_menu_page"/>
            <button type="submit" class="btn btn-link" name="page" value="1">1</button>
        </form>
        <form action="controller" method="post">
            <input type="hidden" name="command" value="to_menu_page"/>
            <button type="submit" class="btn btn-link" name="page" value="2">2</button>
        </form>
        <form action="controller" method="post">
            <input type="hidden" name="command" value="to_menu_page"/>
            <button type="submit" class="btn btn-link" name="page" value="3">3</button>
        </form>
    </div>
    </body>

</fmt:bundle>

