<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="owntag" tagdir="/WEB-INF/tags" %>

<fmt:bundle basename="property.text" prefix="label.">

    <head>
        <title>List of menu items page</title>
        <meta charset="UTF-8">
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
        <h3>List of all menu items:</h3>
    </div>

    <div class="container">
        <table class="table table-bordered">
            <thead class="thead-dark">
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Weight</th>
                <th>Cost</th>
                <th>Ingredients</th>
                <th>Action</th>
            </tr>
            </thead>

            <c:forEach items="${requestScope.menuItemList}" var="item">
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
                            <button type="submit" class="btn btn-danger">Add</button>
                        </form>
                        <form action="${pageContext.request.contextPath}/controller" method="post">
                            <input type="hidden" name="id" value="${item.id}"/>
                            <input type="hidden" name="command" value="to_edit_menu_item_page"/>
                            <button type="submit" class="btn btn-danger">Edit</button>
                        </form>
                    </td>
                </tr>
                </tbody>
            </c:forEach>
        </table>
    </div>

    <div class="container">
        <a href="${pageContext.request.contextPath}/controller?command=menu_items_list?page=1">1</a>
        <a href="${pageContext.request.contextPath}/controller?command=menu_items_list?page=2">2</a>
        <a href="${pageContext.request.contextPath}/controller?command=menu_items_list?page=3">3</a>
    </div>

    </body>

    <div class="container">
        <owntag:footer/>
    </div>

</fmt:bundle>
