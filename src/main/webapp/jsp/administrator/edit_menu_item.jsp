<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="owntag" tagdir="/WEB-INF/tags" %>

<fmt:bundle basename="property.text" prefix="label.">

    <head>
        <title>Edit menu item page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/styles.css">
    </head>

    <body>

     <owntag:menu/>

    <div class="container p-3">
        <h3>Edit menu item:</h3>
    </div>

    <div class="container">
        <form action="${pageContext.request.contextPath}/controller" method="post">
            <input type="hidden" name="command" value="edit_menu_item"/>
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

                <tbody>
                <tr>
                    <td><input type="text" name="id" value="" pattern="([0-9]+){1,3}" required/></td>
                    <td><input type="text" name="name" value="" pattern="([a-zA-Z]+){1,20}" required/></td>
                    <td><input type="text" name="weight" value="" pattern="([0-9]+){1,3}" required/></td>
                    <td><input type="text" name="cost" value="" pattern="([0-9]+){1,3}" required/></td>
                    <td><input type="text" name="ingredientName" value="" pattern="([a-zA-Z\\s]+){1,20}" required/></td>
                    <td>
                        <input type="hidden" name="id" value="${request.getParameter("menuItemById.getId()")}"/>
                        <button type="submit" class="btn btn-primary"><fmt:message key="save_key"/></button>
                    </td>
                </tr>
                </tbody>
            </table>
        </form>
    </div>

    <div class="container p-3">
        <owntag:footer/>
    </div>

    </body>

</fmt:bundle>
